package com.df3n5.gwtproc.client.demos.main;

import java.util.ArrayList;

public class Plane {
	int xMin, zMin, xMax, zMax, y;

	  public Plane(int xMin, int zMin, int xMax, int zMax, int y) {
	    this.xMin = xMin;
	    this.zMin = zMin;
	    this.xMax = xMax;
	    this.zMax = zMax;
	    this.y = y;
	  }

	  public ArrayList<Triangle> getTriangles()
	  {
	    //Two triangles : 
	    //           (xMax, y, zMax)
	    // * ------- * 
	    // | \       |
	    // |  \      |
	    // |   \     |
	    // |    \    |
	    // |     \   |
	    // |      \  |
	    // |       \ |
	    // * ------- *
	    //(xMin, y, zMin)
	    ArrayList<Triangle> res = new ArrayList<Triangle>();
//	    res.add(new Triangle(x1,highY,z1, x2,lowY, z2, x1,lowY,z1));
//	    res.add(new Triangle(x1,highY,z1, x2,lowY, z2, x2,highY,z2));

	    res.add(new Triangle(xMin,y,zMax, xMin,y,zMin, xMax,y,zMin));
	    res.add(new Triangle(xMin,y,zMax, xMax,y,zMax, xMax,y,zMin));

	    return res;
	  }

	  public ArrayList<Point2> getUVCoords()
	  {
	    ArrayList<Point2> res = new ArrayList<Point2>();
	    float amount = 6.0f;
	    res.add(new Point2(0,amount));
	    res.add(new Point2(0,0));
	    res.add(new Point2(amount,0));

	    res.add(new Point2(0,amount));
	    res.add(new Point2(amount,amount));
	    res.add(new Point2(amount,0));

	    return res;
	  }

	  public String toString() {
	    String resultStr = "";
	    ArrayList<Triangle> triangles = getTriangles();
	    ArrayList<Point2> uvCoords = getUVCoords();
	    int i = 0;
	    for(Triangle tri : triangles) {
	      resultStr += Float.toString(tri.getX1()) + "  " +
	        Float.toString(tri.getY1()) + "  " +
	        Float.toString(tri.getZ1()) + " " +
	        Float.toString(uvCoords.get(i).getX()) + " " +
	        Float.toString(uvCoords.get(i++).getY()) + "\n" +
	        Float.toString(tri.getX2()) + "  " +
	        Float.toString(tri.getY2()) + "  " +
	        Float.toString(tri.getZ2()) + "  " +
	        Float.toString(uvCoords.get(i).getX()) + " " + 
	        Float.toString(uvCoords.get(i++).getY()) + "\n" +
	        Float.toString(tri.getX3()) + "  " +
	        Float.toString(tri.getY3()) + "  " +
	        Float.toString(tri.getZ3()) + " " +
	        Float.toString(uvCoords.get(i).getX()) + " " +
	        Float.toString(uvCoords.get(i++).getY()) + "\n";
	    }
	    return resultStr;
	  }
}
