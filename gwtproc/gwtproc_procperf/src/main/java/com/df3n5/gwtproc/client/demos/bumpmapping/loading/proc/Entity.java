package com.df3n5.gwtproc.client.demos.bumpmapping.loading.proc;

import java.util.ArrayList;

import com.df3n5.gwtproc.client.demos.bumpmapping.VertexData;
import com.df3n5.gwtproc.client.demos.bumpmapping.model.Model;

abstract class Entity {
	protected int type;
	protected int modelType;
	protected float x, y;
	protected ArrayList<Triangle> triangles;
	protected ArrayList<Point2> texCoords;
	protected ArrayList<Vector3> normals;

	public Entity(int type, int modelType, float x, float y) {
		this.type = type;
		this.modelType = modelType;
		this.x = x;
		this.y = y;
	}

	public static final int ROOM_TYPE = 0;
	public static final int PILLAR_TYPE = 1;
	public static final int PLANE_TYPE = 2;

	public int getType() { return type; }
	public float getX() { return x; }
	public float getY() { return y; }

	protected abstract void generateTriangles();

	protected abstract void generateTexCoords();

	//Only to be called by "toString()"
	  protected void generateGeom() {
	    generateTriangles();
	    generateNormals();
	    generateTexCoords();
	  }

	  //Only to be called by "toString()"
	  protected String geomAsString() {
	    String resultStr = "";
	    int texCoordI = 0;
	    int normalI = 0;
	    for(Triangle tri : triangles) {
	      resultStr += Float.toString(tri.getX1()) + " " +
	        Float.toString(tri.getY1()) + " " +
	        Float.toString(tri.getZ1()) + " " +
	        Float.toString(normals.get(normalI).getX()) + " " +
	        Float.toString(normals.get(normalI).getY()) + " " +
	        Float.toString(normals.get(normalI++).getZ()) + " " +
	        Float.toString(texCoords.get(texCoordI).getX()) + " " +
	        Float.toString(texCoords.get(texCoordI++).getY()) + "\n" +
	        Float.toString(tri.getX2()) + " " +
	        Float.toString(tri.getY2()) + " " +
	        Float.toString(tri.getZ2()) + " " +
	        Float.toString(normals.get(normalI).getX()) + " " +
	        Float.toString(normals.get(normalI).getY()) + " " +
	        Float.toString(normals.get(normalI++).getZ()) + " " +
	        Float.toString(texCoords.get(texCoordI).getX()) + " " + 
	        Float.toString(texCoords.get(texCoordI++).getY()) + "\n" +
	        Float.toString(tri.getX3()) + " " +
	        Float.toString(tri.getY3()) + " " +
	        Float.toString(tri.getZ3()) + " " +
	        Float.toString(normals.get(normalI).getX()) + " " +
	        Float.toString(normals.get(normalI).getY()) + " " +
	        Float.toString(normals.get(normalI++).getZ()) + " " +
	        Float.toString(texCoords.get(texCoordI).getX()) + " " +
	        Float.toString(texCoords.get(texCoordI++).getY()) + "\n";
	    }
	    return resultStr;
	  }    

	  public String toString() {
	    generateGeom();
	    return geomAsString();
	  }

	  protected ArrayList<Triangle> extrudeLineSegTo3D(
	      float x1, float z1, float x2, 
	      float z2, float lowY, float highY) {
	    //Two triangles : 
	    // (x1,z1)   (x2,z2)
	    // * ------- * highY
	    // | \       |
	    // |  \      |
	    // |   \     |
	    // |    \    |
	    // |     \   |
	    // |      \  |
	    // |       \ |
	    // * ------- * lowY
	    ArrayList<Triangle> res = new ArrayList<Triangle>();
	    //    res.add(new Triangle(x1,highY,z1, x2,lowY, z2, x1,lowY,z1));
	    //    res.add(new Triangle(x1,highY,z1, x2,lowY, z2, x2,highY,z2));

	    res.add(new Triangle(x1,highY,z1, x1,lowY,z1, x2,lowY,z2));
//	    res.add(new Triangle(x1,highY,z1, x2,highY,z2, x2,lowY,z2));
	    res.add(new Triangle(x1,highY,z1, x2,lowY,z2, x2,highY,z2));
	    return res; 
	  }

	  public ArrayList<Triangle> getTrianglesFromSquare(float x1, float y1,float z1,
	      float x2, float y2, float z2) {
	    //Two triangles : 
	    // (x1,y1,z1)   
	    // * ------- *
	    // | \       |
	    // |  \      |
	    // |   \     | Anticlockwise triangle vertex decl.
	    // |    \    |
	    // |     \   |
	    // |      \  |
	    // |       \ |
	    // * ------- * (x2,y2,z2)
	    ArrayList<Triangle> res = new ArrayList<Triangle>();

	    res.add(new Triangle(x1,y1,z1, x1,y2, z1, x2,y2,z2));
	    //res.add(new Triangle(x1,y1,z1, x2, y1, z2, x2,y2,z2));
	    res.add(new Triangle(x1,y1,z1, x2, y2, z2, x2,y1,z2));
	    return res;
	  }

	  public ArrayList<Triangle> getTrianglesFromSquareHor(float x1, float y1,float z1,
	      float x2, float y2, float z2) {
	    ArrayList<Triangle> res = new ArrayList<Triangle>();

	    res.add(new Triangle(x1,y1,z1, x1,y1,z2, x2,y1,z2));
	    res.add(new Triangle(x1,y1,z1, x2, y1, z1, x2,y1,z2));
	    return res;
	  }

	  public ArrayList<Point2> getTexCoordsFromSquare(float x1, float y1,
	      float x2, float y2) {
	    //Two triangles : 
	    // (x1,y1)   
	    // *---------* (x2,y1)
	    // | \       |
	    // |  \      |
	    // |   \     |
	    // |    \    |
	    // |     \   |
	    // |      \  |
	    // |       \ |
	    // *---------* (x2,y2)
	    ArrayList<Point2> res = new ArrayList<Point2>();

	    res.add(new Point2(x1,y1));
	    res.add(new Point2(x1,y2));
	    res.add(new Point2(x2,y2));

	    /*
	    res.add(new Point2(x1,y1));
	    res.add(new Point2(x2,y1));
	    res.add(new Point2(x2,y2));
	    */
	    res.add(new Point2(x1,y1));
	    res.add(new Point2(x2,y2));
	    res.add(new Point2(x2,y1));

	   return res;
	  }

	  //For plain wall (no windows)
	  protected ArrayList<Point2> extrudeLineSegTo3DTexCoords(
	      float x1, float z1,
	      float x2, float z2,
	      float lowY, float highY) {
	    //Two triangles : 
	    // (0.0, highY, 0.0)    (wt,highY)
	    // * ------- * highY
	    // | \       |
	    // |  \      |
	    // |   \     |
	    // |    \    |
	    // |     \   |
	    // |      \  |
	    // |       \ |
	    // * ------- * lowY
	    ArrayList<Point2> res = new ArrayList<Point2>();

	    //Width is the length of the wall, which is distance between points in 2d
	    float wt = (float)Math.sqrt( ((x2-x1)*(x2-x1)) + ((z2-z1)*(z2-z1)));

	    res.addAll(getTexCoordsFromSquare(0.0f, highY, wt, lowY));
	    return res; 
	  }

	  protected Vector3 generateNormalFromTri(Triangle tri) {
	    // *k
	    // | \ 
	    // |  \   
	    // |   \
	    // |    \ 
	    // ^b    \ 
	    // |      \ 
	    // |   a   \ 
	    // *l-->----m*
	    Vector3 k = new Vector3(tri.getX1(), tri.getY1(), tri.getZ1());
	    Vector3 l = new Vector3(tri.getX2(), tri.getY2(), tri.getZ2());
	    Vector3 m = new Vector3(tri.getX3(), tri.getY3(), tri.getZ3());

	    Vector3 a = m.subtract(l);
	    Vector3 b = k.subtract(l);

	    Vector3 cross = a.crossProduct(b);

	    try{
	      Vector3 res = cross.normalize();
	      return res;
	    }catch(Exception e) {
	      System.err.println("Cannot normalize vector, cross is : "
	          + cross.getX() + "," 
	          + cross.getY() + "," 
	          + cross.getZ());

	      System.err.println("Type is : " + this.type);

	      System.err.println("Cannot normalize vector, a is : "
	          + a.getX() + "," 
	          + a.getY() + "," 
	          + a.getZ());

	      System.err.println("Cannot normalize vector, b is : "
	          + b.getX() + "," 
	          + b.getY() + "," 
	          + b.getZ());

	      System.err.println("Cannot normalize vector, k is : "
	          + k.getX() + "," 
	          + k.getY() + "," 
	          + k.getZ());

	      System.err.println("Cannot normalize vector, l is : "
	          + l.getX() + "," 
	          + l.getY() + "," 
	          + l.getZ());

	      System.err.println("Cannot normalize vector, m is : "
	          + m.getX() + "," 
	          + m.getY() + "," 
	          + m.getZ());

	      e.printStackTrace();
	      return null;
	    }
	  }

	  protected ArrayList<Vector3> generateNormalsFromTriangles() {
	    ArrayList<Vector3> res = new ArrayList<Vector3>();
	    for(Triangle tri : triangles) {
	      Vector3 normal = generateNormalFromTri(tri);
	      res.add(normal);
	      res.add(normal);
	      res.add(normal);
	    }
	    return res;
	  }

	  protected ArrayList<Triangle> getTrianglesFromCuboid(Cuboid cuboid) {
	    ArrayList<Triangle> res = new ArrayList<Triangle>();

	    //1
	    res.addAll( getTrianglesFromSquare(
	          cuboid.getX(), 
	          cuboid.getY(), 
	          cuboid.getZ(),
	          cuboid.getX() + cuboid.getDepth(),
	          cuboid.getY() + cuboid.getHeight(),
	          cuboid.getZ() ));

	    //2
	    res.addAll( getTrianglesFromSquare(
	          cuboid.getX() + cuboid.getDepth(),
	          cuboid.getY(), 
	          cuboid.getZ(),
	          cuboid.getX() + cuboid.getDepth(),
	          cuboid.getY() + cuboid.getHeight(),
	          cuboid.getZ() + cuboid.getLength()));

	    //3
	    res.addAll( getTrianglesFromSquare(
	          cuboid.getX() + cuboid.getDepth(),
	          cuboid.getY(), 
	          cuboid.getZ() + cuboid.getLength(),
	          cuboid.getX(),
	          cuboid.getY() + cuboid.getHeight(),
	          cuboid.getZ() + cuboid.getLength()));

	    //4
	    res.addAll( getTrianglesFromSquare(
	          cuboid.getX(),
	          cuboid.getY(), 
	          cuboid.getZ() + cuboid.getLength(),
	          cuboid.getX(),
	          cuboid.getY() + cuboid.getHeight(),
	          cuboid.getZ()));

	    //5
	    res.addAll( getTrianglesFromSquareHor(
	          cuboid.getX(),
	          cuboid.getY() + cuboid.getHeight(), 
	          cuboid.getZ(),
	          cuboid.getX() + cuboid.getDepth(),
	          cuboid.getY() + cuboid.getHeight(),
	          cuboid.getZ() + cuboid.getLength()));

	    //6
	    res.addAll( getTrianglesFromSquareHor(
	          cuboid.getX(),
	          cuboid.getY(), 
	          cuboid.getZ(),
	          cuboid.getX() + cuboid.getDepth(),
	          cuboid.getY(),
	          cuboid.getZ() + cuboid.getLength()));

	    return res;
	  }

	  protected ArrayList<Triangle> generateTrianglesFromCuboids(ArrayList<Cuboid> cuboids) {
	    ArrayList<Triangle> res = new ArrayList<Triangle>();
	    for(Cuboid cuboid : cuboids) {
	      res.addAll(getTrianglesFromCuboid(cuboid));       
	    }
	    return res;
	  }

	  protected ArrayList<Point2> getTexCoordsFromCuboid(Cuboid cuboid) {
	    ArrayList<Point2> res = new ArrayList<Point2>();
	    float x1 = 0.0f;
	    float y1 = 0.0f;
	    float x2 = 1.0f;
	    float y2 = 1.0f;

	    for(int i = 0 ; i < 6 ; i++) {
	      res.addAll(getTexCoordsFromSquare(x1,y1,x2,y2));
	    }
	    return res;
	  }

	  protected ArrayList<Point2> generateTexCoordsFromCuboids(ArrayList<Cuboid> cuboids) {
	    ArrayList<Point2> res = new ArrayList<Point2>();
	    for(Cuboid cuboid : cuboids) {
	      res.addAll(getTexCoordsFromCuboid(cuboid));       
	    }
	    return res;
	  }

	  protected void generateNormals() {
	    this.normals = generateNormalsFromTriangles();
	  }

	
	public ArrayList<VertexData> getVertexDatas(){
		generateGeom();
		
	    int normalI = 0;
	    int texCoordI = 0;
		ArrayList<VertexData> res = new ArrayList<VertexData>();
	    for(Triangle tri : triangles) {
	    	// Add vertex, normal, texCoord for each vertex in triangle (3!)
	    	Vector3 normal = normals.get(normalI++);
	    	Point2 texCoord = texCoords.get(texCoordI++);
			res.add(new VertexData(tri.x1,tri.y1, tri.z1, 
					normal.getX(), normal.getY(), normal.getZ(),
					texCoord.getX(), texCoord.getY()));
			
	    	normal = normals.get(normalI++);
	    	texCoord = texCoords.get(texCoordI++);
			res.add(new VertexData(tri.x2,tri.y2, tri.z2, 
					normal.getX(), normal.getY(), normal.getZ(),
					texCoord.getX(), texCoord.getY()));
			
	    	normal = normals.get(normalI++);
	    	texCoord = texCoords.get(texCoordI++);
			res.add(new VertexData(tri.x3,tri.y3, tri.z3, 
					normal.getX(), normal.getY(), normal.getZ(),
					texCoord.getX(), texCoord.getY()));
		}
		
		return res;
	}
}

