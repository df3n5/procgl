package com.df3n5.gwtproc.client.demos.main.loading;

public class VertexPosTexCoordPair {
	protected float vertexX;
	protected float vertexY;
	protected float vertexZ;
	protected float texCoordU;
	protected float texCoordV;
	
	public VertexPosTexCoordPair(float vertexX, float vertexY, float vertexZ, float texCoordU, float texCoordV) {
		this.vertexX = vertexX;
		this.vertexY = vertexY;
		this.vertexZ = vertexZ;
		this.texCoordU = texCoordU;
		this.texCoordV = texCoordV;
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
