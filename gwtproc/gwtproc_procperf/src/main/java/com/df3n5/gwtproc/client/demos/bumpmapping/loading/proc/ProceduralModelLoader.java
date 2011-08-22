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
	
	public Model loadWalls() {
		Model model = new Model();
	    //generateOffice01(3,4,7);
	    
	    ArrayList<VertexData> vertexDatas = new ArrayList<VertexData>();
	    
	    ArrayList<Entity> walls = generateOfficeOuterRim(3,4,7);
	    //Efficiently generate model.
	    for(Entity wall : walls) {
	    	vertexDatas.addAll(wall.getVertexDatas());
	    }
	    
		model = loadModelFromVertexDatas(vertexDatas);
		model.setType(Model.WALL_TYPE);
		return model;
	}
	
	public Model loadWalls2() {
		Model model = new Model();
	    //generateOffice01(3,4,7);
	    
	    ArrayList<VertexData> vertexDatas = new ArrayList<VertexData>();
	    
	    ArrayList<Entity> walls = generateOfficeInner(3,4,7);
	    //Efficiently generate model.
	    for(Entity wall : walls) {
	    	vertexDatas.addAll(wall.getVertexDatas());
	    }
	    
		model = loadModelFromVertexDatas(vertexDatas);
		model.setType(Model.WALL2_TYPE);
		return model;
	}
	
	public Model loadFloor() {
	    Plane floor = new Plane(Model.FLOOR_TYPE, 0,0, 21,28, 0);
	    
		Model model = loadModelFromVertexDatas(floor.getVertexDatas());
		model.setType(Model.FLOOR_TYPE);
		return model;
	}
	
	public Model loadCeiling() {
	    Plane ceiling = new Plane(Model.CEILING_TYPE, 0,0, 21,28, 2);
		Model model = loadModelFromVertexDatas(ceiling.getVertexDatas());
		model.setType(Model.CEILING_TYPE);
		return model;
	}
	
	  public ArrayList<Entity> generatePillars() {
		    ArrayList<Entity> res = new ArrayList<Entity>();
	
		    int xmax = 7;
		    int ymax = 7;
		    float xDist = 3.0f;
		    float yDist = 4.0f;
		    float rad = 0.2f;
		    float lowY = 0.0f;
		    float highY = 2.0f;
	
			  for(int i = 1 ; i < xmax ; i++) {
				  for(int j = 1 ; j < ymax ; j++) {
		        res.add(new Pillar(Model.PILLAR_TYPE, xDist * i, yDist * j, rad, lowY, highY));
		      }
		    }
	
		    return res;
		  }
	
	public Model loadPillars() {
		ArrayList<Entity> pillars = generatePillars();
		/*
	    ArrayList<Entity> pillars = new ArrayList<Entity>();
	    //TODO : Generate a pattern of pillars
	    Pillar pillar = new Pillar(Model.PILLAR_TYPE, 0.0f,0.0f, 0.5f, 0.0f, 2.0f);
	    pillars.add(pillar);
	    */
	    
	    ArrayList<VertexData> vertexDatas = new ArrayList<VertexData>();
	    //Efficiently generate model.
	    for(Entity p : pillars) {
	    	vertexDatas.addAll(p.getVertexDatas());
	    }

		Model model = loadModelFromVertexDatas(vertexDatas);
		model.setType(Model.PILLAR_TYPE);
		return model;
	}
	
	//Factory method
	public Room createRoom(int type, int x, int y, int w, int h) {
		//Room room = new Room(x,y,w,h, 0.0f, 2.0f);
		Room room = new CuboidRoom(type, x,y,w,h, 0.0f, 2.0f, 0.2f);
		//room.addWindow(0, new Point2(0.4, 0.6), new Point2(0.5,0.5) );
		//room.addDoor(0, 3, 6);
		return room;
	}

	public ArrayList<Entity> generateOfficeOuterRim(int roomWidth, int roomHeight, int max) {
		ArrayList<Entity> res = new ArrayList<Entity>();
		for(int i = 0 ; i < max ; i++) {
			for(int j = 0 ; j < max ; j++) {
				if( ((i % 2 == 1) && (j!=0) && (j!=(max-1))) //Left and Right sides
						|| ((j==1) && (i!=0) && (i!=max-1)) //Left side hallway
						|| ((j==max-2) && (i!=0) && (i!=max-1)) //Right side hallway
						|| ((i==1 || i==max-1) && (j==0 || j==max-1)) //No 2nd one
						|| ( (i>1) && (j>1) && (i<max-1) && (j<max-1)) //No middle offices
				){
					continue;
				}

				if((j==0 || j==max-1) && (i==0 || i==max-2)) { //Corner room
					//Make room which is of twice the width in corners
					//res.add(createRoom(i*roomWidth,j*roomHeight,roomWidth*2,roomHeight));
					if(i==0 && j==0) {
						Room room = createRoom(Model.WALL_TYPE, i*roomWidth,j*roomHeight,roomWidth*2,roomHeight);

						room.addWindow(0, new Point2(0.4f, 0.6f), new Point2(0.5f,0.5f) );
						room.addWindow(1, new Point2(0.4f, 0.6f), new Point2(0.5f,0.5f) );
						//room.addWindow(3, new Point2(4.0, 1.0), new Point2(1.5,0.00001) ); //Door
						room.addWindow(3, new Point2(4.0f, 0.0f), new Point2(0.5f,1.0f) ); //Door
						res.add(room);
					}else if (i==0 && j==max-1) {
						Room room = createRoom(Model.WALL_TYPE,i*roomWidth,j*roomHeight,roomWidth*2,roomHeight);

						room.addWindow(0, new Point2(0.4f, 0.6f), new Point2(0.5f,0.5f) );
						room.addWindow(3, new Point2(0.4f, 0.6f), new Point2(0.5f,0.5f) );
						//room.addWindow(1, new Point2(4.0, 1.0), new Point2(1.5,0.00001) ); //Door
						room.addWindow(1, new Point2(4.0f, 0.0f), new Point2(0.5f,1.0f) ); //Door

						res.add(room);
					}else if (i==max-2 && j==0) {
						Room room = createRoom(Model.WALL_TYPE,i*roomWidth,j*roomHeight,roomWidth*2,roomHeight);

						room.addWindow(1, new Point2(0.4f, 0.6f), new Point2(0.5f,0.5f) );
						room.addWindow(2, new Point2(0.4f, 0.6f), new Point2(0.5f,0.5f) );
						//room.addWindow(3, new Point2(1.0, 1.0), new Point2(0.5,0.00001) ); //Door
						room.addWindow(3, new Point2(1.0f, 0.0f), new Point2(0.5f,1.0f) ); //Door

						res.add(room);
					}else if (i==max-2 && j==max-1) {
						Room room = createRoom(Model.WALL_TYPE,i*roomWidth,j*roomHeight,roomWidth*2,roomHeight);

						room.addWindow(2, new Point2(0.4f, 0.6f), new Point2(0.5f,0.5f) );
						room.addWindow(3, new Point2(0.4f, 0.6f), new Point2(0.5f,0.5f) );
						//room.addWindow(1, new Point2(1.0, 1.0), new Point2(0.5,0.00001) ); //Door
						room.addWindow(1, new Point2(1.0f, 0.0f), new Point2(0.5f,1.0f) ); //Door

						res.add(room);
					}
				} else {
					//Non corner room
					if(i==0) {
						//		            res.add(createRoom(i*roomWidth,j*roomHeight,roomWidth,roomHeight));

						Room room = createRoom(Model.WALL_TYPE,i*roomWidth,j*roomHeight,roomWidth,roomHeight);

						room.addWindow(0, new Point2(0.4f, 0.6f), new Point2(0.5f,0.5f) );
						//room.addWindow(2, new Point2(1.0, 1.0), new Point2(0.3,0.00001) ); //Door
						room.addWindow(2, new Point2(1.0f, 0.0f), new Point2(0.5f,1.0f) ); //Door

						res.add(room);
					}else if(i==max-1) {
						//		            res.add(createRoom(i*roomWidth,j*roomHeight,roomWidth,roomHeight));

						Room room = createRoom(Model.WALL_TYPE,i*roomWidth,j*roomHeight,roomWidth,roomHeight);

						room.addWindow(2, new Point2(0.4f, 0.6f), new Point2(0.5f,0.5f) );
						//room.addWindow(0, new Point2(1.0, 1.0), new Point2(0.5,0.00001) ); //Door
						room.addWindow(0, new Point2(1.0f, 0.0f), new Point2(0.5f,1.0f) ); //Door

						res.add(room);
					}else if(j==0) {
						//		            res.add(createRoom(i*roomWidth,j*roomHeight,roomWidth,roomHeight));

						Room room = createRoom(Model.WALL_TYPE,i*roomWidth,j*roomHeight,roomWidth,roomHeight);

						room.addWindow(1, new Point2(0.4f, 0.6f), new Point2(0.5f,0.5f) );
						//room.addWindow(3, new Point2(1.0, 1.0), new Point2(0.5,0.00001) ); //Door
						room.addWindow(3, new Point2(1.0f, 0.0f), new Point2(0.5f,1.0f) ); //Door

						res.add(room);
					}else if(j==max-1) {
						//		            res.add(createRoom(i*roomWidth,j*roomHeight,roomWidth,roomHeight));

						Room room = createRoom(Model.WALL_TYPE,i*roomWidth,j*roomHeight,roomWidth,roomHeight);

						room.addWindow(3, new Point2(0.4f, 0.6f), new Point2(0.5f,0.5f) );
						//room.addWindow(1, new Point2(1.0, 1.0), new Point2(0.5,0.00001) ); //Door
						room.addWindow(1, new Point2(1.0f, 0.0f), new Point2(0.5f,1.0f) ); //Door

						res.add(room);
					}
				}
			}
		}
		return res;
	}
	public ArrayList<Entity> generateOfficeInner(int roomWidth, int roomHeight, int max) {
		ArrayList<Entity> res = new ArrayList<Entity>();
		for(int i = 0 ; i < max ; i++) {
			for(int j = 0 ; j < max ; j++) {
				if( ((i % 2 == 1) && (j!=0) && (j!=(max-1))) //Left and Right sides
						|| ((j==1) && (i!=0) && (i!=max-1)) //Left side hallway
						|| ((j==max-2) && (i!=0) && (i!=max-1)) //Right side hallway
						|| ((i==1 || i==max-1) && (j==0 || j==max-1)) //No 2nd one
				){
					continue;
				}

				if((i>1) && (j>1) && (i<max-1) && (j<max-1)) { //middle offices only
					if(i==2){
						//           res.add(createRoom(i*roomWidth,j*roomHeight,roomWidth,roomHeight));
						Room room = createRoom(Model.WALL2_TYPE,i*roomWidth,j*roomHeight,roomWidth,roomHeight);

						//room.addWindow(0, new Point2(1.0, 1.0), new Point2(0.5,0.001f) ); //Door
						room.addWindow(0, new Point2(1.0f, 0.0f), new Point2(0.5f,1.0f) ); //Door

						res.add(room);
					}else if(i==4){
						//           res.add(createRoom(i*roomWidth,j*roomHeight,roomWidth,roomHeight));
						Room room = createRoom(Model.WALL2_TYPE,i*roomWidth,j*roomHeight,roomWidth,roomHeight);

						room.addWindow(2, new Point2(1.0f, 0.0f), new Point2(0.5f,1.0f) ); //Door

						res.add(room);
					}
				}
			}
		}
		return res;
	}

	
	@Override
	public ArrayList<Model> getModels() {
		ArrayList<Model> models = new ArrayList<Model>();
		
		models.add(loadWalls());
		models.add(loadWalls2());
		models.add(loadFloor());
		models.add(loadCeiling());
		models.add(loadPillars());
		models.add(loadSkybox());
	    
	    return models;
	}

}
