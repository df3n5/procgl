package com.df3n5.gwtproc.client.demos.bumpmapping.loading.proc;

import java.util.ArrayList;

public class CuboidRoom extends Room {
	protected ArrayList<Cuboid> cuboids;
	  protected float wallWidth;

	  public CuboidRoom(int type, int x, int y, int wt, int ht, float lowY, float highY, float wallWidth) {
	    super(type, x, y, wt, ht, lowY, highY);
	    this.wallWidth = wallWidth;
	  }

	  protected void generateGeom() {
	    generateCuboids();
	    generateTriangles();
	    generateNormals();
	    generateTexCoords();
	  }

	  protected ArrayList<Cuboid> getCuboidsForWallWithWindow(
	      Window window,
	      float x, float y, float z,
	      float depth, float ht, float len) {
	    //TODO
	    ArrayList<Cuboid> res = new ArrayList<Cuboid>();

	    float angle;
	    boolean depthGreatest = (depth>len);

	    boolean isDoor = (window.getStartPoint().getY() < 0.001f);

	    if(depthGreatest) {
	      float x1 = x;
	      float x2 = x+depth;
	      float z1 = z;
	      float z2 = z;
	      angle = (float)Math.atan2((z2-z1), (x2-x1));
	    } else {
	      float x1 = x;
	      float x2 = x;
	      float z1 = z;
	      float z2 = z+len;
	      angle = (float)Math.atan2((z2-z1), (x2-x1));
	    }

	    float relWindowX = (window.getStartPoint().getX()*(float)Math.cos(angle));
	    float relWindowZ = (window.getStartPoint().getX()*(float)Math.sin(angle));

	    float relWindowXPlusSpanX = (relWindowX+(window.getWindowSpan().getX()*(float)Math.cos(angle)));
	    float relWindowZPlusSpanZ = (relWindowZ+(window.getWindowSpan().getX()*(float)Math.sin(angle)));

	    float relWindowYTop = window.getStartPoint().getY() + window.getWindowSpan().getY();
	    float relWindowYBottom = window.getStartPoint().getY();

	    if(depthGreatest) {
	      //Since depth greatest, we are going along x axis, so no need to care about z
	      res.add(new Cuboid(x,y,z, 
	            relWindowX, ht, len)); //Leftmost

	      res.add(new Cuboid(x+relWindowX,y+relWindowYTop,z, 
	            window.getWindowSpan().getX(), ht-relWindowYTop, len)); //Above Window

	      if(!isDoor){
	        res.add(new Cuboid(x+relWindowX,y,z, 
	              window.getWindowSpan().getX(), relWindowYBottom, len)); //Below Window
	      }

	      res.add(new Cuboid(x+relWindowXPlusSpanX,y,z, 
	            depth-relWindowXPlusSpanX, ht, len)); //Right of window
	    } else {
	      //Since len greatest, we are going along z axis, so no need to care about x
	      res.add(new Cuboid(x,y,z, 
	            depth, ht, relWindowZ)); //Leftmost

	      res.add(new Cuboid(x,y+relWindowYTop,z+relWindowZ, 
	            depth, ht-relWindowYTop, window.getWindowSpan().getX())); //Above Window

	      if(!isDoor) {
	        res.add(new Cuboid(x,y,z+relWindowZ, 
	              depth, relWindowYBottom, window.getWindowSpan().getX())); //Below Window
	      }

	      res.add(new Cuboid(x,y,z+relWindowZPlusSpanZ, 
	            depth, ht, len-relWindowZPlusSpanZ)); //Right of window
	    }

	    return res;
	  }

	  protected ArrayList<Cuboid> getCuboidForWall(int wallN,
	      float x, float y, float z,
	      float depth, float ht, float len) {
	    ArrayList<Cuboid> res = new ArrayList<Cuboid>();

	    boolean extruded = false;
	    for(int i=0 ; i < windows.size() ; i++) {
	      if(wallN == windows.get(i).getWallN()) {
	        res.addAll(getCuboidsForWallWithWindow(windows.get(i), 
	              x,y,z,
	              depth,ht,len));
	        extruded = true;
	      }
	    }

	    if(! extruded) {
	      res.add(new Cuboid(x,y,z,depth,ht,len));
	    }

	    return res;
	  }

	  protected void generateCuboids() {
	    cuboids = new ArrayList<Cuboid>();

	    float roomHeight = highY - lowY;

	    //alpha
	    cuboids.addAll(getCuboidForWall(0, 
	          x,lowY,y+wallWidth, 
	          wallWidth,roomHeight,ht-(2*wallWidth)));

	    //beta
	    cuboids.addAll(getCuboidForWall(1,
	        x,lowY,y, 
	        wt,roomHeight,wallWidth));

	    //gamma
	    cuboids.addAll(getCuboidForWall(2,
	        x+wt-wallWidth,lowY,y+wallWidth, 
	        wallWidth,roomHeight,ht-(2*wallWidth)));

	    //delta
	    cuboids.addAll(getCuboidForWall(3,
	        x,lowY,y+ht-wallWidth, 
	        wt,roomHeight,wallWidth));
	  }


	  protected void generateTriangles() {
	    this.triangles = generateTrianglesFromCuboids(cuboids);
	  }

	  protected void generateNormals() {
	    this.normals = generateNormalsFromTriangles();
	  }

	  protected void generateTexCoords() {
	    this.texCoords = generateTexCoordsFromCuboids(cuboids);
	  }

}
