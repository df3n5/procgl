package com.df3n5.gwtproc.client.demos.main.loading;

import java.util.ArrayList;

//import org.apache.catalina.mbeans.GlobalResourcesLifecycleListener;

import com.df3n5.gwtproc.client.demos.main.ErrorHandler;
import com.df3n5.gwtproc.client.demos.main.Resources;
import com.df3n5.gwtproc.client.demos.main.model.Model;
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
	 *  vP vP vP tC tC\n
	 *  vP vP vP tC tC\n
	 *  vP vP vP tC tC\n
	 *  vP ...
	 */
	protected ArrayList<VertexPosTexCoordPair> getVertexPositionsTexCoords(String formattedString) {
	    ArrayList<VertexPosTexCoordPair> vertexPosTexCoordPairs = new ArrayList<VertexPosTexCoordPair>();
	    String[] lines = formattedString.split("\n");
	    
	    for (String line : lines) {
	    	if(line.equals(""))
	    	{
	    		continue;
	    	}
	    	String[] tokens = line.split("\\s");
    		if( ! tokens[0].equals("//")) {
    			float xCoord = Float.parseFloat(tokens[0]);
    			float yCoord = Float.parseFloat(tokens[1]);
    			float zCoord = Float.parseFloat(tokens[2]);
    			float uCoord = Float.parseFloat(tokens[3]);
    			float vCoord = Float.parseFloat(tokens[4]);
    					    	
		    	vertexPosTexCoordPairs.add(new VertexPosTexCoordPair(xCoord, yCoord, zCoord, uCoord, vCoord));
    		}
	    }
	    return vertexPosTexCoordPairs;
	}
	
	protected float[] getVertexPositions(ArrayList<VertexPosTexCoordPair> vertexPosTexCoordPairs) {
		float[] result = new float[vertexPosTexCoordPairs.size() * 3]; //3 axes
		int i = 0;
		for(VertexPosTexCoordPair pair : vertexPosTexCoordPairs) {
			result[i++] = pair.getVertexX();
			result[i++] = pair.getVertexY();
			result[i++] = pair.getVertexZ();
		}

		return result;
	}
	
	protected float[] getTexCoords(final ArrayList<VertexPosTexCoordPair> vertexPosTexCoordPairs) {
		float[] result = new float[vertexPosTexCoordPairs.size() * 2]; // u and v
		int i = 0;
		for(VertexPosTexCoordPair pair : vertexPosTexCoordPairs) {
			result[i++] = pair.getTexCoordU();
			result[i++] = pair.getTexCoordV();
		}

		return result;
	}
	
	protected WebGLBuffer loadVertexBuffer(final ArrayList<VertexPosTexCoordPair> vertexPosTexCoordPairs) {
		WebGLBuffer vertexPosBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexPosBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, 
				Float32Array.create(getVertexPositions(vertexPosTexCoordPairs)), 
				WebGLRenderingContext.STATIC_DRAW);
		return vertexPosBuffer;
	}
	
	
	protected WebGLBuffer loadTexCoordBuffer(final ArrayList<VertexPosTexCoordPair> vertexPosTexCoordPairs) {
		WebGLBuffer texCoordBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, texCoordBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, 
				Float32Array.create(getTexCoords(vertexPosTexCoordPairs)), 
				WebGLRenderingContext.STATIC_DRAW);
		return texCoordBuffer;
	}
	
	public Model loadModelFromString(String modelString) {
		Model model = new Model();
		ArrayList<VertexPosTexCoordPair> vertexPosTexCoordPairs = getVertexPositionsTexCoords(modelString);
		model.setVertexBuffer(loadVertexBuffer(vertexPosTexCoordPairs));
		model.setTexCoordBuffer(loadTexCoordBuffer(vertexPosTexCoordPairs));
		model.setNTriangles((vertexPosTexCoordPairs).size());
	
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
		Model[] models = new Model[5];
		
		int i = 0;
		models[i++] = loadWalls();
		models[i++] = loadFloor();
		models[i++] = loadCeiling();
		models[i++] = loadPillars();
		models[i++] = loadSkybox();

		return models;
	}
	
}
