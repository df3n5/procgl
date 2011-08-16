package com.df3n5.gwtproc.client.demos.bumpmapping;

import java.util.ArrayList;

abstract class Entity {
	protected int type;
	protected float x, y;

	public Entity(int type, float x, float y) {
		this.type = type;
		this.x = x;
		this.y = y;
	}

	public static final int ROOM_TYPE = 0;
	public static final int HALL_TYPE = 1;
	public static final int PILLAR_TYPE = 2;

	public int getType() { return type; }
	public float getX() { return x; }
	public float getY() { return y; }

	public abstract ArrayList<Triangle> getTriangles(float lowY, float highY, int camx, int camy);

	public abstract ArrayList<Point2> getUVCoords();

}

