package com.df3n5.gwtproc.client.demos.bumpmapping.loading.proc;

public class Cuboid {
	float x;
	float y;
	float z;
	float depth;
	float ht;
	float len;

	Cuboid(float x, float y, float z, 
			float depth, float ht, float len) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.depth = depth;
		this.ht = ht;
		this.len = len;
	}

	public float getX() { return x; }
	public float getY() { return y; }
	public float getZ() { return z; }
	public float getDepth() { return depth; }
	public float getHeight() { return ht; }
	public float getLength() { return len; }
}
