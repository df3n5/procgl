package com.df3n5.gwtproc.client.demos.main;

public class Triangle {
	  float x1,y1,z1;
	  float x2,y2,z2;
	  float x3,y3,z3;

	  public Triangle(float x1, float y1, float z1,
	      float x2, float y2, float z2,
	      float x3, float y3, float z3
	      ) {
	    this.x1 = x1;
	    this.y1 = y1;
	    this.z1 = z1;

	    this.x2 = x2;
	    this.y2 = y2;
	    this.z2 = z2;

	    this.x3 = x3;
	    this.y3 = y3;
	    this.z3 = z3;
	  }

	  float getX1() { return x1; }
	  float getY1() { return y1; }
	  float getZ1() { return z1; }

	  float getX2() { return x2; }
	  float getY2() { return y2; }
	  float getZ2() { return z2; }

	  float getX3() { return x3; }
	  float getY3() { return y3; }
	  float getZ3() { return z3; }
}
