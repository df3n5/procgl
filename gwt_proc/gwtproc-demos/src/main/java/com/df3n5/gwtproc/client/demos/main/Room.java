package com.df3n5.gwtproc.client.demos.main;

import java.util.ArrayList;

class Room extends Entity {
	private int wt, ht; // Width and height

	public Room(int x, int y, int wt, int ht) {
		super(Entity.ROOM_TYPE, x, y);
		this.wt = wt;
		this.ht = ht;
	}

	public int getWt() {
		return wt;
	}

	public int getHt() {
		return ht;
	}

	private ArrayList<Triangle> extrudeLineSegTo3D(int x1, int z1, int x2,
			int z2, float lowY, float highY) {
		// Two triangles :
		// (x1,z1) (x2,z2)
		// * ------- * highY
		// | \ |
		// | \ |
		// | \ |
		// | \ |
		// | \ |
		// | \ |
		// | \ |
		// * ------- * lowY
		ArrayList<Triangle> res = new ArrayList<Triangle>();
		// res.add(new Triangle(x1,highY,z1, x2,lowY, z2, x1,lowY,z1));
		// res.add(new Triangle(x1,highY,z1, x2,lowY, z2, x2,highY,z2));

		res.add(new Triangle(x1, highY, z1, x1, lowY, z1, x2, lowY, z2));
		res.add(new Triangle(x1, highY, z1, x2, highY, z2, x2, lowY, z2));
		return res;
	}

	public ArrayList<Triangle> getTriangles(float lowY, float highY, int camx,
			int camy) {
		ArrayList<Triangle> res = new ArrayList<Triangle>();

		// TODO:Offset room coords by camera pos
		res.addAll(extrudeLineSegTo3D(x, y, x + wt, y, lowY, highY));
		res.addAll(extrudeLineSegTo3D(x, y, x, y + ht, lowY, highY));
		res.addAll(extrudeLineSegTo3D(x + wt, y, x + wt, y + ht, lowY, highY));
		res.addAll(extrudeLineSegTo3D(x, y + ht, x + wt, y + ht, lowY, highY));

		return res;
	}

	public ArrayList<Point2> getUVCoords() {
		ArrayList<Point2> res = new ArrayList<Point2>();
		float amount = 6.0f;
		// TODO:Verify this is correct.
		res.add(new Point2(0, amount));
		res.add(new Point2(0, 0));
		res.add(new Point2(amount, 0));

		res.add(new Point2(0, amount));
		res.add(new Point2(amount, amount));
		res.add(new Point2(amount, 0));

		res.add(new Point2(0, amount));
		res.add(new Point2(0, 0));
		res.add(new Point2(amount, 0));

		res.add(new Point2(0, amount));
		res.add(new Point2(amount, amount));
		res.add(new Point2(amount, 0));

		res.add(new Point2(0, amount));
		res.add(new Point2(0, 0));
		res.add(new Point2(amount, 0));

		res.add(new Point2(0, amount));
		res.add(new Point2(amount, amount));
		res.add(new Point2(amount, 0));

		res.add(new Point2(0, amount));
		res.add(new Point2(0, 0));
		res.add(new Point2(amount, 0));

		res.add(new Point2(0, amount));
		res.add(new Point2(amount, amount));
		res.add(new Point2(amount, 0));

		return res;
	}
}
