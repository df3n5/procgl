package com.df3n5.gwtproc.client.demos.main;

public class Triangle {
	  double x1,y1,z1;
	  double x2,y2,z2;
	  double x3,y3,z3;

	  public Triangle(double x12, double y1, double y12,
	      double x13, double y2, double y13,
	      double x22, double y3, double y22
	      ) {
	    this.x1 = x12;
	    this.y1 = y1;
	    this.z1 = y12;

	    this.x2 = x13;
	    this.y2 = y2;
	    this.z2 = y13;

	    this.x3 = x22;
	    this.y3 = y3;
	    this.z3 = y22;
	  }

	  double getX1() { return x1; }
	  double getY1() { return y1; }
	  double getZ1() { return z1; }

	  double getX2() { return x2; }
	  double getY2() { return y2; }
	  double getZ2() { return z2; }

	  double getX3() { return x3; }
	  double getY3() { return y3; }
	  double getZ3() { return z3; }
}
