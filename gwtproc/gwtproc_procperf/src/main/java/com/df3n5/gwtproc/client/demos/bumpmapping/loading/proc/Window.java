package com.df3n5.gwtproc.client.demos.bumpmapping.loading.proc;

class Window{
	private int wallN;
	private Point2 startPoint;
	private Point2 windowSpan;

	public Window(int wallN, 
			Point2 startPoint, 
			Point2 windowSpan) {
		this.wallN = wallN;
		this.startPoint = startPoint;
		this.windowSpan = windowSpan;
	}

	public int getWallN() { return wallN; }
	public Point2 getStartPoint() { return startPoint; }
	public Point2 getWindowSpan() { return windowSpan; }

}