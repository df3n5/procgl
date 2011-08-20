package com.df3n5.gwtproc.client.demos.bumpmapping.loading.file;

import java.util.ArrayList;

//import org.apache.catalina.mbeans.GlobalResourcesLifecycleListener;

import com.df3n5.gwtproc.client.demos.bumpmapping.ErrorHandler;
import com.df3n5.gwtproc.client.demos.bumpmapping.Resources;
import com.df3n5.gwtproc.client.demos.bumpmapping.VertexData;
import com.df3n5.gwtproc.client.demos.bumpmapping.model.Model;
import com.df3n5.gwtproc.client.demos.bumpmapping.loading.AbstractModelLoader;
import com.googlecode.gwtgl.array.Float32Array;
import com.googlecode.gwtgl.binding.WebGLBuffer;
import com.googlecode.gwtgl.binding.WebGLRenderingContext;
import com.df3n5.gwtproc.client.util.mesh.CubeFactory;
import com.df3n5.gwtproc.client.util.mesh.Mesh;

public class TextModelLoader extends AbstractModelLoader {

	
	public TextModelLoader(WebGLRenderingContext glContext){
		super(glContext);
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
	
	public Model loadModelFromString(String modelString) {
		ArrayList<VertexData> vertexDatas = getVerticesDataFromStr(modelString);
		return loadModelFromVertexDatas(vertexDatas);
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
