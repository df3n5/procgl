package com.df3n5.gwtproc.client.demos.bumpmapping.loading.proc;

import java.util.ArrayList;

class Room extends Entity {
	protected int wt, ht; //Width and height
	protected float lowY, highY; //Y for floor and ceiling
	protected ArrayList<Window> windows; // = new int[0];

	public Room(int modelType, int x, int y, int wt, int ht, float lowY, float highY) {
		super(Entity.ROOM_TYPE, modelType, x, y);
		this.wt = wt;
		this.ht = ht;
		this.lowY = lowY;
		this.highY = highY;
		windows = new ArrayList<Window>();
	}
	public int getWt() { return wt; }
	public int getHt() { return ht; }

	protected ArrayList<Triangle> extrudeWallFlat(int wallN, 
			float lowY, float highY) {
		switch(wallN) {
		case 0:
			return extrudeLineSegTo3D(x,y, x+wt,y, lowY, highY);
		case 1:
			return extrudeLineSegTo3D(x,y, x,y+ht, lowY, highY);
		case 2:
			return extrudeLineSegTo3D(x+wt,y, x+wt,y+ht, lowY, highY); 
		case 3:
			return extrudeLineSegTo3D(x,y+ht, x+wt,y+ht, lowY, highY);
		default:
			return null;
		}
	}

	public ArrayList<Triangle> extrudeLineSegTo3DWithWindow(
			Window window, 
			float x1, float z1, float x2, 
			float z2, float lowY, float highY
	) {
		//Two triangles : 
		// (x1,z1)                       (x2,z2)
		// * ---------------------------- * highY
		// |  |   |                       |
		// |  |   |  (sx+spanx,sy+spany)  |
		// |  *---*                       |
		// |  |EEE|                       |
		// |  *---*                       |
		// |(sx,sy)                       |
		// |  |   |                       |
		// * ---------------------------- * lowY
		ArrayList<Triangle> res = new ArrayList<Triangle>();
		float angle = (float)Math.atan2((z2-z1), (x2-x1));

		float relWindowX = (float)(x1+(window.getStartPoint().getX()*Math.cos(angle)));
		float relWindowZ = (float)(z1+(window.getStartPoint().getX()*Math.sin(angle)));

		float relWindowXPlusSpanX = (float)(relWindowX+(window.getWindowSpan().getX()*Math.cos(angle)));
		float relWindowZPlusSpanZ = (float)(relWindowZ+(window.getWindowSpan().getX()*Math.sin(angle)));

		float windowYTop = lowY + window.getStartPoint().getY() + window.getWindowSpan().getY();
		float windowYBottom = lowY + window.getStartPoint().getY();

		res.addAll(getTrianglesFromSquare(x1,highY,z1, 
				relWindowX,lowY,relWindowZ)); //Leftmost

				res.addAll(getTrianglesFromSquare(relWindowX,highY,relWindowZ, 
						relWindowXPlusSpanX, windowYTop, relWindowZPlusSpanZ)); //Above window

				res.addAll(getTrianglesFromSquare(relWindowX,windowYBottom,relWindowZ, 
						relWindowXPlusSpanX, lowY, relWindowZPlusSpanZ)); //Below window

				res.addAll(getTrianglesFromSquare(relWindowXPlusSpanX, highY, relWindowZPlusSpanZ,
						x2,lowY,z2)); //Rightmost
				return res; 
	}

	public ArrayList<Triangle> extrudeWallWithWindowsOrDoors(
			Window window, float lowY, float highY) {

		switch(window.getWallN()) {
		case 0:
			return extrudeLineSegTo3DWithWindow(window, x,y, x+wt,y, lowY, highY);
		case 1:
			return extrudeLineSegTo3DWithWindow(window, x,y, x,y+ht, lowY, highY);
		case 2:
			return extrudeLineSegTo3DWithWindow(window, x+wt,y, x+wt,y+ht, lowY, highY); 
		case 3:
			return extrudeLineSegTo3DWithWindow(window, x,y+ht, x+wt,y+ht, lowY, highY);
		default:
			return null;
		}
	}

	public ArrayList<Triangle> getTrianglesForWall(int wallN, float lowY, float highY) {
		boolean extruded = false;
		ArrayList<Triangle> res = new ArrayList<Triangle>();

		for(int i=0 ; i < windows.size() ; i++) {
			if(wallN == windows.get(i).getWallN()) {
				res.addAll(extrudeWallWithWindowsOrDoors(windows.get(i), lowY, highY));
				extruded = true;
			}
		}

		if(! extruded) {
			res.addAll(extrudeWallFlat(wallN, lowY, highY));
		}

		return res;
	}
	
	public ArrayList<Point2> extrudeLineSegTo3DWithWindowTexCoords(
			Window window, 
			float x1, float z1, float x2, 
			float z2, float lowY, float highY
	) {
		ArrayList<Point2> res = new ArrayList<Point2>();

		float angle = (float)Math.atan2((z2-z1), (x2-x1));

		float relWindowX = (float)(x1+(window.getStartPoint().getX()*Math.cos(angle)));
		float relWindowZ = (float)(z1+(window.getStartPoint().getX()*Math.sin(angle)));

		float relWindowXPlusSpanX = (float)(relWindowX+(window.getWindowSpan().getX()*Math.cos(angle)));
		float relWindowZPlusSpanZ = (float)(relWindowZ+(window.getWindowSpan().getX()*Math.sin(angle)));

		float windowYTop = lowY + window.getStartPoint().getY() + window.getWindowSpan().getY();
		float windowYBottom = lowY + window.getStartPoint().getY();

		Point2 startPoint = new Point2(x1,z1);
		Point2 relWindowPt = new Point2(relWindowX, relWindowZ);
		Point2 relWindowPlusSpanPt = new Point2(relWindowXPlusSpanX, relWindowZPlusSpanZ);
		Point2 endPt = new Point2(x2,z2);

		//We add the texture coords individually for these squares, based on their x and y positions on the wall, from the top left.
		res.addAll(getTexCoordsFromSquare(0.0f,highY, startPoint.dist(relWindowPt), lowY)); //Leftmost
		res.addAll(getTexCoordsFromSquare(startPoint.dist(relWindowPt),highY, startPoint.dist(relWindowPlusSpanPt), windowYTop)); //Above Window
		res.addAll(getTexCoordsFromSquare(startPoint.dist(relWindowPt),windowYBottom, startPoint.dist(relWindowPlusSpanPt), lowY)); //Below Window
		res.addAll(getTexCoordsFromSquare(startPoint.dist(relWindowPlusSpanPt),highY, startPoint.dist(endPt), lowY)); //Right

		return res; 
	}

	public ArrayList<Point2> extrudeWallWithWindowsOrDoorsTexCoords(Window window, float lowY, float highY) {
		switch(window.getWallN()) {
		case 0:
			return extrudeLineSegTo3DWithWindowTexCoords(window, x,y, x+wt,y, lowY, highY);
		case 1:
			return extrudeLineSegTo3DWithWindowTexCoords(window, x,y, x,y+ht, lowY, highY);
		case 2:
			return extrudeLineSegTo3DWithWindowTexCoords(window, x+wt,y, x+wt,y+ht, lowY, highY); 
		case 3:
			return extrudeLineSegTo3DWithWindowTexCoords(window, x,y+ht, x+wt,y+ht, lowY, highY);
		default:
			return null;
		}
	}

	public ArrayList<Point2> extrudeWallFlatTexCoords(int wallN, float lowY, float highY) {
		switch(wallN) {
		case 0:
			return extrudeLineSegTo3DTexCoords(x,y, x+wt,y, lowY, highY);
		case 1:
			return extrudeLineSegTo3DTexCoords(x,y, x,y+ht, lowY, highY);
		case 2:
			return extrudeLineSegTo3DTexCoords(x+wt,y, x+wt,y+ht, lowY, highY); 
		case 3:
			return extrudeLineSegTo3DTexCoords(x,y+ht, x+wt,y+ht, lowY, highY);
		default:
			return null;
		}
	}

	public ArrayList<Point2> getTexCoordsForWall(int wallN, float lowY, float highY) {
		ArrayList<Point2> res = new ArrayList<Point2>();
		boolean extruded = false;

		//Tell whether the window is extruded or not.
		for(int i=0 ; i < windows.size() ; i++) {
			if(wallN == windows.get(i).getWallN()) {
				res.addAll(extrudeWallWithWindowsOrDoorsTexCoords(windows.get(i), lowY, highY));
				extruded = true;
			}
		}

		if(! extruded) {
			res.addAll(extrudeWallFlatTexCoords(wallN, lowY, highY));
		}

		return res;
	}

	public void addWindow(int wallN, Point2 startPoint, Point2 span) {
		windows.add(new Window(wallN, startPoint, span));
	}

	protected void generateTriangles() {
		ArrayList<Triangle> res = new ArrayList<Triangle>();
		res.addAll(getTrianglesForWall(0, lowY, highY));
		res.addAll(getTrianglesForWall(1, lowY, highY));
		res.addAll(getTrianglesForWall(2, lowY, highY));
		res.addAll(getTrianglesForWall(3, lowY, highY));
		this.triangles = res;
	}

	protected void generateNormals() {
		this.normals = generateNormalsFromTriangles();
	}

	protected void generateTexCoords() {
		ArrayList<Point2> res = new ArrayList<Point2>();
		res.addAll(getTexCoordsForWall(0, lowY, highY));
		res.addAll(getTexCoordsForWall(1, lowY, highY));
		res.addAll(getTexCoordsForWall(2, lowY, highY));
		res.addAll(getTexCoordsForWall(3, lowY, highY));
		this.texCoords = res;
	}

}
