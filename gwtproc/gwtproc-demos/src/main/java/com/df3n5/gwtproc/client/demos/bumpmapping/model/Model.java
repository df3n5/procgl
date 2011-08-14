package com.df3n5.gwtproc.client.demos.bumpmapping.model;

import com.googlecode.gwtgl.binding.WebGLBuffer;

public class Model {
	protected int nTriangles;
	protected WebGLBuffer vertexBuffer;
	protected WebGLBuffer texCoordBuffer;
	protected WebGLBuffer normalBuffer;
	protected int type;
	
	public final static int WALL_TYPE = 0;
	public final static int FLOOR_TYPE = 1;
	public final static int CEILING_TYPE = 2;
	public final static int PILLAR_TYPE = 3;
	public final static int SKYBOX_TYPE = 4;
	
	public void setType(int type) { 
		this.type = type;
	}
	
	public int getType() { 
		return type;
	}
	
	public void setNTriangles(int nTriangles) {
		this.nTriangles = nTriangles;
	}
	
	public int getNTriangles() {
		return nTriangles;
	}
	
	public void setVertexBuffer(WebGLBuffer vertexBuffer) {
		this.vertexBuffer = vertexBuffer;
	}
	
	public void setTexCoordBuffer(WebGLBuffer texCoordBuffer) {
		this.texCoordBuffer = texCoordBuffer;
	}
	
	public WebGLBuffer getVertexBuffer() {
		return vertexBuffer;
	}
	
	public WebGLBuffer getNormalBuffer() {
		return normalBuffer;
	}

	public WebGLBuffer getTexCoordBuffer() {
		return texCoordBuffer;
	}

	public void setNormalBuffer(WebGLBuffer normalBuffer) {
		this.normalBuffer = normalBuffer;
	}
}