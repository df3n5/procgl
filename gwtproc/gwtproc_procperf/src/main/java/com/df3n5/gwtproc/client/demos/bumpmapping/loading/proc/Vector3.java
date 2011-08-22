package com.df3n5.gwtproc.client.demos.bumpmapping.loading.proc;

class Vector3 {
	protected float x,y,z;

	public Vector3() {
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
	}

	public Vector3(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float getX() { return x; }
	public float getY() { return y; }
	public float getZ() { return z; }

	public Vector3 crossProduct(Vector3 other) { 
		float x = (this.y * other.getZ()) - (this.z * other.getY());
		float y = (this.z * other.getX()) - (this.x * other.getZ());
		float z = (this.x * other.getY()) - (this.y * other.getX());
		return new Vector3(x,y,z);
	}

	public Vector3 subtract(Vector3 other) { 
		float x = this.x - other.getX();
		float y = this.y - other.getY();
		float z = this.z - other.getZ();
		return new Vector3(x,y,z);
	}

	public float magnitude() {
		return (float) Math.sqrt(x*x + y*y + z*z);
	}

	public Vector3 normalize() throws Exception{
		float mag = magnitude();
		if(mag > 0)
		{
			float invMag = 1.0f/mag;
			return new Vector3(invMag*x, invMag*y, invMag*z);
		} else {
			throw new Exception("Vector cannot have a mag <= 0 and be able to normalize;");
		}
	}
}

