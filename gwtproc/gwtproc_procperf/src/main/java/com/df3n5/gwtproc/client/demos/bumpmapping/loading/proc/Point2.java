package com.df3n5.gwtproc.client.demos.bumpmapping.loading.proc;

class Point2 {
	float x, y;
	Point2(float x, float y) {
		this.x = x;
		this.y = y;
	}
	public float getX() { return x; }
	public float getY() { return y; }

	public float dist(Point2 other) {
		return (float)Math.sqrt((other.getX()-x) * (other.getX()-x) + 
				(other.getY()-y) * (other.getY()-y));
	}
}