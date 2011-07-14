package com.df3n5.gwtproc.client.demos.main;

import java.util.ArrayList;

abstract class Entity {
	protected int type;
	protected int x, y;

	public Entity(int type, int x, int y) {
		this.type = type;
		this.x = x;
		this.y = y;
	}

	public static final int ROOM_TYPE = 0;
	public static final int HALL_TYPE = 1;

	public int getType() {
		return type;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public abstract ArrayList<Triangle> getTriangles(float lowY, float highY,
			int camx, int camy);

	public abstract ArrayList<Point2> getUVCoords();

}