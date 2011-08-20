package com.df3n5.gwtproc.client.demos.bumpmapping.loading.proc;

import java.util.ArrayList;

import com.df3n5.gwtproc.client.demos.bumpmapping.ErrorHandler;
import com.df3n5.gwtproc.client.demos.bumpmapping.VertexData;
import com.df3n5.gwtproc.client.demos.bumpmapping.model.Model;
import com.df3n5.gwtproc.client.demos.bumpmapping.loading.AbstractModelLoader;
import com.googlecode.gwtgl.binding.WebGLRenderingContext;

public class ProceduralModelLoader extends AbstractModelLoader {
	protected ArrayList<Entity> walls;
	protected WebGLRenderingContext glContext;

	public ProceduralModelLoader(WebGLRenderingContext glContext) {
		super(glContext);
		walls = new ArrayList<Entity>();
	}
	
	public void createRoom(int x, int y, int w, int h) {
		Room room = new Room(Model.WALL_TYPE, x,y,w,h, 0.0f, 2.0f);
		room.addWindow(0, new Point2(0.3f, 0.6f), new Point2(0.5f,0.5f) );
		walls.add(room);
	}

	public void generateGrid(int roomLength, int max) {
		for(int i = 0 ; i < max ; i++) {
			for(int j = 0 ; j < max ; j++) {
				if((i % 2 != 1) && (j % 2 != 1)){
					createRoom(i*roomLength,j*roomLength,roomLength,roomLength);
				}
			}
		}
	}

	public void generateOffice01(int roomWidth, int roomHeight, int max) {
		//Problem: Corner rooms have no hallway access
		for(int i = 0 ; i < max ; i++) {
			for(int j = 0 ; j < max ; j++) {
				if( ((i % 2 == 1) && (j!=0) && (j!=(max-1))) //Left and Right sides
						|| ((j==1) && (i!=0) && (i!=max-1)) //Left side hallway
						|| ((j==max-2) && (i!=0) && (i!=max-1)) //Right side hallway
						|| ((i==1 || i==max-1) && (j==0 || j==max-1)) //No 2nd one
				){
					continue;
				}

				if((j==0 || j==max-1) && (i==0 || i==max-2)) {
					//Make room which is of twice the width
					createRoom(i*roomWidth,j*roomHeight,roomWidth*2,roomHeight);
				} else {
					createRoom(i*roomWidth,j*roomHeight,roomWidth,roomHeight);
				}
			}
		}
	}
	
	public Model loadWalls() {
		Model model = new Model();
	    generateOffice01(3,4,7);
	    
	    ArrayList<VertexData> vertexDatas = new ArrayList<VertexData>();
	    //Efficiently generate model.
	    for(Entity wall : walls) {
	    	vertexDatas.addAll(wall.getVertexDatas());
	    }
	    
		model = loadModelFromVertexDatas(vertexDatas);
		model.setType(Model.WALL_TYPE);
		return model;
	}
	
	public Model loadFloor() {
	    Plane floor = new Plane(Model.FLOOR_TYPE, 0,0, 1000,1000, 0);
		Model model = loadModelFromVertexDatas(floor.getVertexDatas());
		model.setType(Model.FLOOR_TYPE);
		return model;
	}
	
	public Model loadCeiling() {
	    Plane ceiling = new Plane(Model.CEILING_TYPE, 0,0, 1000,1000, 2);
		Model model = loadModelFromVertexDatas(ceiling.getVertexDatas());
		model.setType(Model.CEILING_TYPE);
		return model;
	}
	
	public Model loadPillars() {
	    ArrayList<Entity> pillars = new ArrayList<Entity>();
	    //TODO : Generate a pattern of pillars
	    Pillar pillar = new Pillar(Model.PILLAR_TYPE, 0.0f,0.0f, 0.5f, 0.0f, 2.0f);
	    pillars.add(pillar);
	    
	    ArrayList<VertexData> vertexDatas = new ArrayList<VertexData>();
	    //Efficiently generate model.
	    for(Entity p : pillars) {
	    	vertexDatas.addAll(p.getVertexDatas());
	    }

		Model model = loadModelFromVertexDatas(vertexDatas);
		model.setType(Model.PILLAR_TYPE);
		return model;
	}

	@Override
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
