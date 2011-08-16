
package com.df3n5.gwtproc.client.demos.bumpmapping;

public class Vector3 {
	float x;
	float y;
	float z;
	
	public Vector3(){
	}
	
	public Vector3(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getZ() {
		return z;
	}
	public void setZ(float z) {
		this.z = z;
	}
	
	public Vector3 multiply(float scalar) {
		Vector3 result = new Vector3();
		result.setX(x*scalar);
		result.setY(y*scalar);
		result.setZ(z*scalar);
		
		return result;
	}
	
	
	public Vector3 crossProduct(Vector3 other) {
		Vector3 result = new Vector3();
		result.setX((y*other.getZ()) - (z*other.getY()));
		result.setY((z*other.getX()) - (x*other.getZ()));
		result.setZ((x*other.getY()) - (y*other.getX()));
		return result;
	}

}
