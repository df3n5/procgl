package com.df3n5.gwtproc.client.demos.bumpmapping;

import java.util.ArrayList;

class Pillar extends Entity {
  private double radius;
  private float numSlices;
  private float totalAngle;

  public Pillar(float x, float y, double radius) {
    super(Entity.PILLAR_TYPE, x, y);
    this.radius = radius;
    this.numSlices = 10;
    //totalAngle = 360.0f;
    totalAngle = 360.0f;
    //this.widthResolution = 10;
  }

  private ArrayList<Triangle> extrudeLineSegTo3D(double x1, double y1, double x2, double y2, float lowY, float highY) {
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

    res.add(new Triangle(x1,highY,y1, x1,lowY, y1, x2,lowY,y2));
    res.add(new Triangle(x1,highY,y1, x2, highY, y2, x2,lowY,y2));
    return res; 
  }

  public double degreeToRad(double degree) {
    double PI = 3.14159265;
    return ( (degree) * (PI / 180.0) );
  }

  public ArrayList<Triangle> getTriangles(float lowY, float highY, int camx, int camy) {
    ArrayList<Triangle> res = new ArrayList<Triangle>();
    
    double angle = (totalAngle/numSlices);
    for (int i=0; i < numSlices ; i++) {

      double x1 = (x + (Math.cos(degreeToRad( angle * i )) * radius));
      double y1 = (y + (Math.sin(degreeToRad( angle * i )) * radius));

      if((i+1) <= numSlices) { //Defensive coding, shouldn't happen.
    	double x2 = (x + (Math.cos(degreeToRad( angle * (i+1) )) * radius));
    	double y2 = (y + (Math.sin(degreeToRad( angle * (i+1) )) * radius));

        res.addAll(extrudeLineSegTo3D(x1,y1, x2, y2, lowY, highY));
      }
    }

    return res;
  }

  public ArrayList<Point2> getUVCoords() {
    ArrayList<Point2> res = new ArrayList<Point2>();

    float amount = 6.0f;
    for (int i=0; i < numSlices; i++) {
      // TODO:Verify this is correct.
      res.add(new Point2(0,amount));
      res.add(new Point2(0,0));
      res.add(new Point2(amount,0));

      res.add(new Point2(0,amount));
      res.add(new Point2(amount,amount));
      res.add(new Point2(amount,0));
    }
    return res;
  }
}