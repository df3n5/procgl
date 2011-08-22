package com.df3n5.gwtproc.client.demos.bumpmapping;

public class VertexData {
	protected float vertexX;
	protected float vertexY;
	protected float vertexZ;
	protected float normalX;
	protected float normalY;
	protected float normalZ;
	protected float texCoordU;
	protected float texCoordV;
	
	public VertexData(float vertexX, float vertexY, float vertexZ,
			float normalX, float normalY, float normalZ,
			float texCoordU, float texCoordV) {
		this.vertexX = vertexX;
		this.vertexY = vertexY;
		this.vertexZ = vertexZ;
		this.normalX = normalX;
		this.normalY = normalY;
		this.normalZ = normalZ;
		this.texCoordU = texCoordU;
		this.texCoordV = texCoordV;
	}
	
	public float getNormalX() {
		return normalX;
	}

	public void setNormalX(float normalX) {
		this.normalX = normalX;
	}

	public float getNormalY() {
		return normalY;
	}

	public void setNormalY(float normalY) {
		this.normalY = normalY;
	}

	public float getNormalZ() {
		return normalZ;
	}

	public void setNormalZ(float normalZ) {
		this.normalZ = normalZ;
	}

	public float getVertexX() {
		return vertexX;
	}
	public void setVertexX(float vertexX) {
		this.vertexX = vertexX;
	}
	public float getVertexY() {
		return vertexY;
	}
	public void setVertexY(float vertexY) {
		this.vertexY = vertexY;
	}
	public float getVertexZ() {
		return vertexZ;
	}
	public void setVertexZ(float vertexZ) {
		this.vertexZ = vertexZ;
	}
	public float getTexCoordU() {
		return texCoordU;
	}
	public void setTexCoordU(float texCoordU) {
		this.texCoordU = texCoordU;
	}
	public float getTexCoordV() {
		return texCoordV;
	}
	public void setTexCoordV(float texCoordV) {
		this.texCoordV = texCoordV;
	}
}
