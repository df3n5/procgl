package com.df3n5.gwtproc.client.demos.bumpmapping.loading;

import java.util.ArrayList;

//import org.apache.catalina.mbeans.GlobalResourcesLifecycleListener;

import com.df3n5.gwtproc.client.demos.bumpmapping.ErrorHandler;
import com.df3n5.gwtproc.client.demos.bumpmapping.Resources;
import com.df3n5.gwtproc.client.demos.bumpmapping.model.Model;
import com.googlecode.gwtgl.array.Float32Array;
import com.googlecode.gwtgl.binding.WebGLBuffer;
import com.googlecode.gwtgl.binding.WebGLRenderingContext;
import com.df3n5.gwtproc.client.util.mesh.CubeFactory;
import com.df3n5.gwtproc.client.util.mesh.Mesh;

public class TextModelLoader extends AbstractModelLoader {
	protected WebGLRenderingContext glContext;
	
	public TextModelLoader(WebGLRenderingContext glContext){
		this.glContext = glContext;
	}
	
	///----------------------------------------------------------------------------------------------------------------
	///----------------------------------------------------------------------------------------------------------------
	///----------------------------------------------------------------------------------------------------------------
	
	/*
	 * The format is:
	 *  vx vy vz nx ny nz tu tv\n
	 *  vx vy vz nx ny nz tu tv\n
	 *  vx vy vz nx ny nz tu tv\n
	 *  vx ...
	 */
	protected ArrayList<VertexData> getVerticesDataFromStr(String formattedString) {
	    ArrayList<VertexData> vertexDatas = new ArrayList<VertexData>();
	    String[] lines = formattedString.split("\n");
	    
	    for (String line : lines) {
	    	if(line.equals(""))
	    	{
	    		continue;
	    	}
	    	String[] tokens = line.split("\\s");
    		if( ! tokens[0].equals("//")) {
    			float posX = Float.parseFloat(tokens[0]);
    			float posY = Float.parseFloat(tokens[1]);
    			float poxZ = Float.parseFloat(tokens[2]);
    			
    			float normalX = Float.parseFloat(tokens[3]);
    			float normalY = Float.parseFloat(tokens[4]);
    			float normalZ = Float.parseFloat(tokens[5]);
    			
    			float uCoord = Float.parseFloat(tokens[6]);
    			float vCoord = Float.parseFloat(tokens[7]);
    					    	
		    	vertexDatas.add(new VertexData(posX, posY, poxZ, 
		    			normalX, normalY, normalZ, 
		    			uCoord, vCoord));
    		}
	    }
	    return vertexDatas;
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
	
	public Model loadModelFromString(String modelString) {
		Model model = new Model();
		ArrayList<VertexData> vertexDatas = getVerticesDataFromStr(modelString);
		model.setVertexBuffer(loadVertexBuffer(vertexDatas));
		model.setNormalBuffer(loadNormalBuffer(vertexDatas));
		model.setTexCoordBuffer(loadTexCoordBuffer(vertexDatas));
		model.setNTriangles((vertexDatas).size());
	
		ErrorHandler.checkErrors(glContext);
		return model;
	}
	
	///----------------------------------------------------------------------------------------------------------------
	///----------------------------------------------------------------------------------------------------------------
	///----------------------------------------------------------------------------------------------------------------
	
	public Model loadWalls() {
		Model model = loadModelFromString(Resources.INSTANCE.walls().getText());
		model.setType(Model.WALL_TYPE);
		return model;
	}

	public Model loadFloor() {
		Model model = loadModelFromString(Resources.INSTANCE.floor().getText());
		model.setType(Model.FLOOR_TYPE);
		return model;
	}

	public Model loadCeiling() {
		Model model = loadModelFromString(Resources.INSTANCE.ceiling().getText());
		model.setType(Model.CEILING_TYPE);
		return model;
	}

	public Model loadPillars() {
		Model model = loadModelFromString(Resources.INSTANCE.pillars().getText());
		model.setType(Model.PILLAR_TYPE);
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
	
	public Model[] getModels() {
		Model[] models = new Model[1];
		
		int i = 0;
		models[i++] = loadWalls();
		/*
		models[i++] = loadFloor();
		models[i++] = loadCeiling();
		models[i++] = loadPillars();
		models[i++] = loadSkybox();
		*/
		return models;
	}
	
}
