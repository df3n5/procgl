package com.df3n5.gwtproc.client.demos.bumpmapping.loading;

import java.util.ArrayList;

import com.df3n5.gwtproc.client.demos.bumpmapping.ErrorHandler;
import com.df3n5.gwtproc.client.demos.bumpmapping.VertexData;
import com.df3n5.gwtproc.client.demos.bumpmapping.model.Model;
import com.df3n5.gwtproc.client.util.mesh.CubeFactory;
import com.df3n5.gwtproc.client.util.mesh.Mesh;
import com.googlecode.gwtgl.array.Float32Array;
import com.googlecode.gwtgl.binding.WebGLBuffer;
import com.googlecode.gwtgl.binding.WebGLRenderingContext;

public abstract class AbstractModelLoader {
	protected WebGLRenderingContext glContext;
	
	public AbstractModelLoader(WebGLRenderingContext glContext) {
		this.glContext = glContext;
	}
	
	public abstract Model[] getModels();
	
	protected WebGLBuffer loadVertexBuffer(final ArrayList<VertexData> vertexDatas) {
		WebGLBuffer vertexPosBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexPosBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, 
				Float32Array.create(getVertexPositions(vertexDatas)), 
				WebGLRenderingContext.STATIC_DRAW);
		return vertexPosBuffer;
	}
	
	protected WebGLBuffer loadNormalBuffer(final ArrayList<VertexData> vertexDatas) {
		WebGLBuffer normalBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, normalBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, 
				Float32Array.create(getVertexNormals(vertexDatas)), 
				WebGLRenderingContext.STATIC_DRAW);
		return normalBuffer;
	}
	
	protected WebGLBuffer loadTexCoordBuffer(final ArrayList<VertexData> vertexDatas) {
		WebGLBuffer texCoordBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, texCoordBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, 
				Float32Array.create(getTexCoords(vertexDatas)), 
				WebGLRenderingContext.STATIC_DRAW);
		return texCoordBuffer;
	}
	
	protected float[] getVertexPositions(ArrayList<VertexData> vertexDatas) {
		float[] result = new float[vertexDatas.size() * 3]; //3 axes
		int i = 0;
		for(VertexData pair : vertexDatas) {
			result[i++] = pair.getVertexX();
			result[i++] = pair.getVertexY();
			result[i++] = pair.getVertexZ();
		}

		return result;
	}
	
	protected float[] getVertexNormals(ArrayList<VertexData> vertexDatas) {
		float[] result = new float[vertexDatas.size() * 3]; //3 axes
		int i = 0;
		for(VertexData pair : vertexDatas) {
			result[i++] = pair.getNormalX();
			result[i++] = pair.getNormalY();
			result[i++] = pair.getNormalZ();
		}

		return result;
	}
	
	protected float[] getTexCoords(final ArrayList<VertexData> vertexDatas) {
		float[] result = new float[vertexDatas.size() * 2]; // u and v
		int i = 0;
		for(VertexData pair : vertexDatas) {
			result[i++] = pair.getTexCoordU();
			result[i++] = pair.getTexCoordV();
		}

		return result;
	}
	
	public Model loadModelFromVertexDatas(ArrayList<VertexData> vertexDatas) {
		Model model = new Model();
		model.setVertexBuffer(loadVertexBuffer(vertexDatas));
		model.setNormalBuffer(loadNormalBuffer(vertexDatas));
		model.setTexCoordBuffer(loadTexCoordBuffer(vertexDatas));
		model.setNTriangles((vertexDatas).size());
	
		ErrorHandler.checkErrors(glContext);
		return model;
	}
	

	public Model loadSkybox() {
		Model model = new Model();
		model.setType(Model.SKYBOX_TYPE);

		Mesh skyCube = CubeFactory.createNewInstance(100.0f);

		WebGLBuffer vertexPosBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexPosBuffer);
		Float32Array vertices = Float32Array.create(skyCube.getVertices());
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER,
				vertices,
				WebGLRenderingContext.STATIC_DRAW);

		WebGLBuffer texCoordBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, texCoordBuffer);
		Float32Array texCoords = Float32Array.create(skyCube.getTexCoords());
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, 
				Float32Array.create(skyCube.getTexCoords()), 
				WebGLRenderingContext.STATIC_DRAW);
		
		model.setVertexBuffer(vertexPosBuffer);
		model.setTexCoordBuffer(texCoordBuffer);
		model.setNTriangles(36);

		return model;
	}
}
