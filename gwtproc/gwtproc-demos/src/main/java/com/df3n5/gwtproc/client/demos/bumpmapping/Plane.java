package com.df3n5.gwtproc.client.demos.bumpmapping;

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
	    double amount = 6.0;
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
	      resultStr += Double.toString(tri.getX1()) + "  " +
	        Double.toString(tri.getY1()) + "  " +
	        Double.toString(tri.getZ1()) + " " +
	        Double.toString(uvCoords.get(i).getX()) + " " +
	        Double.toString(uvCoords.get(i++).getY()) + "\n" +
	        Double.toString(tri.getX2()) + "  " +
	        Double.toString(tri.getY2()) + "  " +
	        Double.toString(tri.getZ2()) + "  " +
	        Double.toString(uvCoords.get(i).getX()) + " " + 
	        Double.toString(uvCoords.get(i++).getY()) + "\n" +
	        Double.toString(tri.getX3()) + "  " +
	        Double.toString(tri.getY3()) + "  " +
	        Double.toString(tri.getZ3()) + " " +
	        Double.toString(uvCoords.get(i).getX()) + " " +
	        Double.toString(uvCoords.get(i++).getY()) + "\n";
	    }
	    return resultStr;
	  }
}
