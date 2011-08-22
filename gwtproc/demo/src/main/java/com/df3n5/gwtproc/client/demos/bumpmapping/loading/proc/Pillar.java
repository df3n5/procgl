package com.df3n5.gwtproc.client.demos.bumpmapping.loading.proc;

import java.util.ArrayList;

class Pillar extends Entity {
	private float radius;
	private float numSlices;
	private float totalAngle;
	private float lowY;
	private float highY;

	public Pillar(int modelType, float x, float y, float radius, float lowY, float highY) {
		super(Entity.PILLAR_TYPE, modelType, x, y);
		this.radius = radius;
		this.numSlices = 10;
		//totalAngle = 360.0f;
		totalAngle = 360.0f;
		//this.widthResolution = 10;
		this.lowY = lowY;
		this.highY = highY;
	}

	public float degreeToRad(float degree) {
		float PI = 3.14159265f;
		return ( (degree) * (PI / 180.0f) );
	}

	protected void generateTriangles() {
		ArrayList<Triangle> res = new ArrayList<Triangle>();

		float angle = (totalAngle/numSlices);
		for (int i=0; i < numSlices ; i++) {

			float x1 = x + (float)(Math.cos(degreeToRad( angle * i )) * radius);
			float y1 = y + (float)(Math.sin(degreeToRad( angle * i )) * radius);

			if((i+1) <= numSlices) { //Defensive coding, shouldn't happen.
				float x2 = x + (float)(Math.cos(degreeToRad( angle * (i+1) )) * radius);
				float y2 = y + (float)(Math.sin(degreeToRad( angle * (i+1) )) * radius);

				res.addAll(extrudeLineSegTo3D(x1,y1, x2, y2, lowY, highY));
			}
		}

		this.triangles = res;
	}

	protected void generateNormals() {
		this.normals = generateNormalsFromTriangles();
	}

	protected void generateTexCoords() {
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

		this.texCoords = res;
	}
} //END Pillar