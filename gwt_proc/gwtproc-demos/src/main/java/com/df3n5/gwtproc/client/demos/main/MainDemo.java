package com.df3n5.gwtproc.client.demos.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.df3n5.gwtproc.client.AbstractGwtProcDemo;
import com.df3n5.gwtproc.client.util.MatrixWidget;
import com.df3n5.gwtproc.client.util.math.FloatMatrix;
import com.df3n5.gwtproc.client.util.math.MatrixUtil;
import com.df3n5.gwtproc.client.util.mesh.CubeFactory;
import com.df3n5.gwtproc.client.util.mesh.Mesh;
import com.gargoylesoftware.htmlunit.AlertHandler;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.logging.client.HtmlLogFormatter;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwtgl.array.Float32Array;
import com.googlecode.gwtgl.binding.WebGLBuffer;
import com.googlecode.gwtgl.binding.WebGLProgram;
import com.googlecode.gwtgl.binding.WebGLRenderingContext;
import com.googlecode.gwtgl.binding.WebGLShader;
import com.googlecode.gwtgl.binding.WebGLTexture;
import com.googlecode.gwtgl.binding.WebGLUniformLocation;

/**
 * Main Procedural generation demo
 * 
 * @author Jonathan Frawley
 * 
 */
public class MainDemo extends AbstractGwtProcDemo {

	private static final boolean procOn = true;
	
	private Mesh skyCube = CubeFactory.createNewInstance(100.0f);

	private WebGLBuffer vertexBuffer;
	private WebGLBuffer vertexTextureCoordBuffer;
	private WebGLTexture textureTop;
	private WebGLTexture textureBottom;
	private WebGLTexture textureFront;
	private WebGLTexture textureBack;
	private WebGLTexture textureLeft;
	private WebGLTexture textureRight;
	private WebGLTexture texture;
	private WebGLTexture mudTexture;
	private WebGLTexture wallTexture;
	private WebGLUniformLocation textureUniform;
	private WebGLUniformLocation procTextureTypeUniform;
	private WebGLProgram shaderProgram;
	private WebGLBuffer skyboxBuffer;
	private WebGLBuffer skyboxTextureBuffer;
	
	//Walls
	private WebGLBuffer wallsVertexPosBuffer;
	private WebGLBuffer wallsVertexTextureCoordBuffer;
	private int wallsVertexCount;
	
	//Floor
	private WebGLBuffer floorVertexPosBuffer;
	private WebGLBuffer floorVertexTextureCoordBuffer;
	private int floorVertexCount;
	
	//Ceiling
	private WebGLBuffer ceilingVertexPosBuffer;
	private WebGLBuffer ceilingVertexTextureCoordBuffer;
	private int ceilingVertexCount;
	
	//Pillars
	private WebGLBuffer pillarsVertexPosBuffer;
	private WebGLBuffer pillarsVertexTextureCoordBuffer;
	private int pillarsVertexCount;

	private float translateZ = 0.5f;
	private FloatMatrix perspectiveMatrix;
	private FloatMatrix translationMatrix;
	private FloatMatrix rotationMatrix;
	private FloatMatrix resultingMatrix;
	private FloatMatrix mvMatrix;
	private Camera camera = new Camera();
	private int texCoordsOffset;
	private int vertexPositionAttribute;
	private int textureCoordAttribute;

	/**
	 * Constructs an instance of the SkyboxWrapperExample.
	 */
	public MainDemo() {
		// create an panel to show the matrices
		/*
		HorizontalPanel matrixPanel = new HorizontalPanel();
		perspectiveMatrixWidget = new MatrixWidget(4, 4, "perspective matrix:");
		translationMatrixWidget = new MatrixWidget(4, 4, "translation matrix:");
		rotationMatrixWidget = new MatrixWidget(4, 4, "rotation matrix:");
		resultingMatrixWidget = new MatrixWidget(4, 4, "resulting matrix:");
		matrixPanel.add(perspectiveMatrixWidget);
		matrixPanel.add(translationMatrixWidget);
		matrixPanel.add(rotationMatrixWidget);
		matrixPanel.add(resultingMatrixWidget);

		setWidget(2, 0, matrixPanel);
				*/
		getFlexCellFormatter().setColSpan(2, 0, 2);

		// Show a description of the controls
		HTML exampleDescription = new HTML(
				"<h2>Main Demo</p>");
		VerticalPanel descriptionAndControls = new VerticalPanel();
		descriptionAndControls.add(exampleDescription);
		setWidget(1, 1, descriptionAndControls);
	}
	
	private long getTimeStampMilli() {
        Date date = new Date();
        return date.getTime();
	}

	@Override
	protected void init() {
		
		long before = getTimeStampMilli();
		
		initParams();
		
		if( ! procOn )
		{
			initTexture();
			initWorld();
			initCeiling();
			initFloor();
			initPillars();
		}
		else
		{
			initWorldProc();
			initCeilingProc();
			initFloorProc();
			initPillarsProc();
		}

		initShaders();
		initSkyBox();
		initControls();
		
		long after = getTimeStampMilli();
		
		System.out.println("Init: " + (after-before));
		
		//showMatrices();
	}
	
	/**
	 * TODO : Put this in util place
	 * @param vertexPositions
	 * @return
	 */
	public float[] convertToFloatArray(Vector<Double> vertexPositions) {
		float[] result = new float[vertexPositions.size()];
		for(int i = 0 ; i < vertexPositions.size(); i++) {
			result[i] = vertexPositions.elementAt(i).floatValue();
		}
		return result;
	}
	
	/**
	 * Initializes the buffers for vertex coordinates, normals and texture
	 * coordinates.
	 */
	private void initSkyBox() {
		skyboxBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, skyboxBuffer);
		
		//Skycube
		Float32Array vertices = Float32Array.create(skyCube.getVertices());
		texCoordsOffset = vertices.getByteLength();
		Float32Array texCoords = Float32Array.create(skyCube.getTexCoords());
		/*
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER,
				vertices.getByteLength() + texCoords.getByteLength(),
				WebGLRenderingContext.STATIC_DRAW);
		
		glContext.bufferSubData(WebGLRenderingContext.ARRAY_BUFFER, 0, vertices);
		glContext.bufferSubData(WebGLRenderingContext.ARRAY_BUFFER,
				texCoordsOffset, texCoords);
				*/
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER,
				vertices,
				WebGLRenderingContext.STATIC_DRAW);
		skyboxTextureBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, skyboxTextureBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, Float32Array.create(skyCube.getTexCoords()), WebGLRenderingContext.STATIC_DRAW);
		/*
		
		vertexBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER,
				Float32Array.create(cube.getVertices()),
				WebGLRenderingContext.STATIC_DRAW);
		vertexTextureCoordBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexTextureCoordBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, Float32Array.create(cube.getTexCoords()), WebGLRenderingContext.STATIC_DRAW);
		
		
		checkErrors();
		*/
	}
	
	public void initPillars() {
		String mapData = Resources.INSTANCE.pillars().getText();
	    String[] lines = mapData.split("\n");
	    Vector<Double> vertexPositions = new Vector();
	    Vector<Double> vertexTextureCoords = new Vector();
	    
	    pillarsVertexCount = 0;
	    
	    for (String line : lines) {
	    	if(line.equals(""))
	    	{
	    		continue;
	    	}
	    	String[] tokens = line.split("\\s");
    		if( ! tokens[0].equals("//")) {
		    	/*
		    	 * The format is:
		    	 *  vP vP vP tC tC
		    	 */
    			double xCoord = Float.parseFloat(tokens[0]);
    			double yCoord = Float.parseFloat(tokens[1]);
    			double zCoord = Float.parseFloat(tokens[2]);
    			double uCoord = Float.parseFloat(tokens[3]);
    			double vCoord = Float.parseFloat(tokens[4]);
    			
		    	// Move 6 along x axis
		    	//System.out.println(Float.toString(xCoord + 6.0f) + "  " + yCoord + "  " + zCoord + " " + uCoord + " " + vCoord);
		    	
		    	vertexPositions.add(xCoord);
		    	vertexPositions.add(yCoord);
		    	vertexPositions.add(zCoord);
		    	
		    	vertexTextureCoords.add(uCoord);
		    	vertexTextureCoords.add(vCoord);
		    	
		    	pillarsVertexCount++;
    		}
	    }
	    
	    pillarsVertexPosBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, pillarsVertexPosBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, 
				Float32Array.create(convertToFloatArray(vertexPositions)), 
				WebGLRenderingContext.STATIC_DRAW);
		
		pillarsVertexTextureCoordBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, pillarsVertexTextureCoordBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, 
				Float32Array.create(convertToFloatArray(vertexTextureCoords)), 
				WebGLRenderingContext.STATIC_DRAW);
		
		checkErrors();
	}
	

	public void initPillarsProc() {
	    Vector<Double> vertexPositions = new Vector<Double>();
	    Vector<Double> vertexTextureCoords = new Vector<Double>();
	    
	    Pillar pillar = new Pillar(0,0, 0.3f);
	    
	    pillarsVertexCount = 0;
	    
	    ArrayList<Triangle> triangles = pillar.getTriangles(0,2,0,0);
	    ArrayList<Point2> uvCoords = pillar.getUVCoords();
	    int i = 0;
	    for(Triangle tri : triangles) {
	    	vertexPositions.add(tri.getX1());
	    	vertexPositions.add(tri.getY1());
	    	vertexPositions.add(tri.getZ1());

	    	vertexTextureCoords.add(uvCoords.get(i).getX());
	    	vertexTextureCoords.add(uvCoords.get(i++).getY());

	    	vertexPositions.add(tri.getX2());
	    	vertexPositions.add(tri.getY2());
	    	vertexPositions.add(tri.getZ2());

	    	vertexTextureCoords.add(uvCoords.get(i).getX());
	    	vertexTextureCoords.add(uvCoords.get(i++).getY());

	    	vertexPositions.add(tri.getX3());
	    	vertexPositions.add(tri.getY3());
	    	vertexPositions.add(tri.getZ3());

	    	vertexTextureCoords.add(uvCoords.get(i).getX());
	    	vertexTextureCoords.add(uvCoords.get(i++).getY());

	    	pillarsVertexCount += 3;
	    }
	    
	    pillarsVertexPosBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, pillarsVertexPosBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, 
				Float32Array.create(convertToFloatArray(vertexPositions)), 
				WebGLRenderingContext.STATIC_DRAW);
		
		pillarsVertexTextureCoordBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, pillarsVertexTextureCoordBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, 
				Float32Array.create(convertToFloatArray(vertexTextureCoords)), 
				WebGLRenderingContext.STATIC_DRAW);
		
		checkErrors();
	}
	
	public void initWorld() {
		String mapData = Resources.INSTANCE.map().getText();
	    String[] lines = mapData.split("\n");
	    int vertexCount = 0;
	    Vector<Double> vertexPositions = new Vector();
	    Vector<Double> vertexTextureCoords = new Vector();
	    
	    wallsVertexCount = 0;
	    
	    for (String line : lines) {
	    	if(line.equals(""))
	    	{
	    		continue;
	    	}
	    	String[] tokens = line.split("\\s");
    		if( ! tokens[0].equals("//")) {
		    	/*
		    	 * The format is:
		    	 *  vP vP vP tC tC
		    	 */
    			double xCoord = Double.parseDouble(tokens[0]);
    			double yCoord = Double.parseDouble(tokens[1]);
    			double zCoord = Double.parseDouble(tokens[2]);
    			double uCoord = Double.parseDouble(tokens[3]);
    			double vCoord = Double.parseDouble(tokens[4]);
    			
		    	// Move 6 along x axis
		    	//System.out.println(Float.toString(xCoord + 6.0f) + "  " + yCoord + "  " + zCoord + " " + uCoord + " " + vCoord);
		    	
		    	vertexPositions.add(xCoord);
		    	vertexPositions.add(yCoord);
		    	vertexPositions.add(zCoord);
		    	
		    	vertexTextureCoords.add(uCoord);
		    	vertexTextureCoords.add(vCoord);
		    	
		    	wallsVertexCount++;
    		}
	    }
	    
	    wallsVertexPosBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, wallsVertexPosBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, 
				Float32Array.create(convertToFloatArray(vertexPositions)), 
				WebGLRenderingContext.STATIC_DRAW);
		
		wallsVertexTextureCoordBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, wallsVertexTextureCoordBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, 
				Float32Array.create(convertToFloatArray(vertexTextureCoords)), 
				WebGLRenderingContext.STATIC_DRAW);
		
		checkErrors();
	}
	
	public ArrayList<Room> generateGrid(int roomLength, int max) {
		ArrayList<Room> resultGrid = new ArrayList<Room>();
		for(int i = 0 ; i < max ; i++) {
			for(int j = 0 ; j < max ; j++) {
				if((i % 2 != 1) && (j % 2 != 1)){
					resultGrid.add(new Room(i*roomLength,j*roomLength,roomLength,roomLength));
				}
			}
		}
		return resultGrid;
	}
	
	public void initWorldProc() {
	    Vector<Double> vertexPositions = new Vector<Double>();
	    Vector<Double> vertexTextureCoords = new Vector<Double>();
	    ArrayList<Room> rooms = generateGrid(7,7);
	    
	    wallsVertexCount = 0;
	    
	    for (Room room : rooms) {
	    	ArrayList<Triangle> triangles = room.getTriangles(0, 2, 0, 0);
		    ArrayList<Point2> uvCoords = room.getUVCoords();
		    int i = 0;
		    for(Triangle tri : triangles) {
		    	vertexPositions.add(tri.getX1());
		    	vertexPositions.add(tri.getY1());
		    	vertexPositions.add(tri.getZ1());

		    	vertexTextureCoords.add(uvCoords.get(i).getX());
		    	vertexTextureCoords.add(uvCoords.get(i++).getY());

		    	vertexPositions.add(tri.getX2());
		    	vertexPositions.add(tri.getY2());
		    	vertexPositions.add(tri.getZ2());

		    	vertexTextureCoords.add(uvCoords.get(i).getX());
		    	vertexTextureCoords.add(uvCoords.get(i++).getY());

		    	vertexPositions.add(tri.getX3());
		    	vertexPositions.add(tri.getY3());
		    	vertexPositions.add(tri.getZ3());

		    	vertexTextureCoords.add(uvCoords.get(i).getX());
		    	vertexTextureCoords.add(uvCoords.get(i++).getY());

		    	wallsVertexCount += 3;
		    }
	    }
	    
	    wallsVertexPosBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, wallsVertexPosBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, 
				Float32Array.create(convertToFloatArray(vertexPositions)), 
				WebGLRenderingContext.STATIC_DRAW);
		
		wallsVertexTextureCoordBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, wallsVertexTextureCoordBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, 
				Float32Array.create(convertToFloatArray(vertexTextureCoords)), 
				WebGLRenderingContext.STATIC_DRAW);
		
		checkErrors();
	}
	
	public void initCeiling() {
		String ceilingStr = Resources.INSTANCE.ceiling().getText();
	    String[] lines = ceilingStr.split("\n");
	    Vector<Double> vertexPositions = new Vector();
	    Vector<Double> vertexTextureCoords = new Vector();
	    
	    for (String line : lines) {
	    	if(line.equals(""))
	    	{
	    		continue;
	    	}
	    	
	    	String[] tokens = line.split("\\s");
    		if( ! tokens[0].equals("//")) {
		    	/*
		    	 * The format is:
		    	 *  vP vP vP tC tC
		    	 */
    			double xCoord = Double.parseDouble(tokens[0]);
    			double yCoord = Double.parseDouble(tokens[1]);
    			double zCoord = Double.parseDouble(tokens[2]);
    			double uCoord = Double.parseDouble(tokens[3]);
    			double vCoord = Double.parseDouble(tokens[4]);
    			
		    	// Move 6 along x axis
		    	//System.out.println(Float.toString(xCoord + 6.0f) + "  " + yCoord + "  " + zCoord + " " + uCoord + " " + vCoord);
		    	
		    	vertexPositions.add(xCoord);
		    	vertexPositions.add(yCoord);
		    	vertexPositions.add(zCoord);
		    	
		    	vertexTextureCoords.add(uCoord);
		    	vertexTextureCoords.add(vCoord);
		    	
		    	ceilingVertexCount++;
    		}
	    }
	    ceilingVertexPosBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, ceilingVertexPosBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, 
				Float32Array.create(convertToFloatArray(vertexPositions)), 
				WebGLRenderingContext.STATIC_DRAW);
		
		ceilingVertexTextureCoordBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, ceilingVertexTextureCoordBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, 
				Float32Array.create(convertToFloatArray(vertexTextureCoords)), 
				WebGLRenderingContext.STATIC_DRAW);
		
		checkErrors();
	}
	
	public void initCeilingProc() {
	    Vector<Double> vertexPositions = new Vector<Double>();
	    Vector<Double> vertexTextureCoords = new Vector<Double>();
	    
	    Plane ceiling = new Plane(0,0, 1000,1000, 2);
	    
	    ArrayList<Triangle> triangles = ceiling.getTriangles();
	    ArrayList<Point2> uvCoords = ceiling.getUVCoords();
	    int i = 0;
	    for(Triangle tri : triangles) {
	    	vertexPositions.add(tri.getX1());
	    	vertexPositions.add(tri.getY1());
	    	vertexPositions.add(tri.getZ1());

	    	vertexTextureCoords.add(uvCoords.get(i).getX());
	    	vertexTextureCoords.add(uvCoords.get(i++).getY());

	    	vertexPositions.add(tri.getX2());
	    	vertexPositions.add(tri.getY2());
	    	vertexPositions.add(tri.getZ2());

	    	vertexTextureCoords.add(uvCoords.get(i).getX());
	    	vertexTextureCoords.add(uvCoords.get(i++).getY());

	    	vertexPositions.add(tri.getX3());
	    	vertexPositions.add(tri.getY3());
	    	vertexPositions.add(tri.getZ3());

	    	vertexTextureCoords.add(uvCoords.get(i).getX());
	    	vertexTextureCoords.add(uvCoords.get(i++).getY());

	    	ceilingVertexCount += 3;
	    }
	    ceilingVertexPosBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, ceilingVertexPosBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, 
				Float32Array.create(convertToFloatArray(vertexPositions)), 
				WebGLRenderingContext.STATIC_DRAW);
		
		ceilingVertexTextureCoordBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, ceilingVertexTextureCoordBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, 
				Float32Array.create(convertToFloatArray(vertexTextureCoords)), 
				WebGLRenderingContext.STATIC_DRAW);
		
		checkErrors();
	}
	

	public void initFloor() {
		String floorStr = Resources.INSTANCE.floor().getText();
	    String[] lines = floorStr.split("\n");
	    Vector<Double> vertexPositions = new Vector();
	    Vector<Double> vertexTextureCoords = new Vector();
	    
	    for (String line : lines) {
	    	if(line.equals(""))
	    	{
	    		continue;
	    	}
	    	
	    	String[] tokens = line.split("\\s");
    		if( ! tokens[0].equals("//")) {
		    	/*
		    	 * The format is:
		    	 *  vP vP vP tC tC
		    	 */
    			double xCoord = Double.parseDouble(tokens[0]);
    			double yCoord = Double.parseDouble(tokens[1]);
    			double zCoord = Double.parseDouble(tokens[2]);
    			double uCoord = Double.parseDouble(tokens[3]);
    			double vCoord = Double.parseDouble(tokens[4]);
    			
		    	// Move 6 along x axis
		    	//System.out.println(Float.toString(xCoord + 6.0f) + "  " + yCoord + "  " + zCoord + " " + uCoord + " " + vCoord);
		    	
		    	vertexPositions.add(xCoord);
		    	vertexPositions.add(yCoord);
		    	vertexPositions.add(zCoord);
		    	
		    	vertexTextureCoords.add(uCoord);
		    	vertexTextureCoords.add(vCoord);
		    	
		    	floorVertexCount++;
    		}
	    }
	    floorVertexPosBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, floorVertexPosBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, 
				Float32Array.create(convertToFloatArray(vertexPositions)), 
				WebGLRenderingContext.STATIC_DRAW);
		
		floorVertexTextureCoordBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, floorVertexTextureCoordBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, 
				Float32Array.create(convertToFloatArray(vertexTextureCoords)), 
				WebGLRenderingContext.STATIC_DRAW);
		
		checkErrors();
	}
	
	public void initFloorProc() {
	    Vector<Double> vertexPositions = new Vector<Double>();
	    Vector<Double> vertexTextureCoords = new Vector<Double>();
	    
	    Plane floor = new Plane(0,0, 1000,1000, 0);
	    
	    ArrayList<Triangle> triangles = floor.getTriangles();
	    ArrayList<Point2> uvCoords = floor.getUVCoords();
	    int i = 0;
	    for(Triangle tri : triangles) {
	    	vertexPositions.add(tri.getX1());
	    	vertexPositions.add(tri.getY1());
	    	vertexPositions.add(tri.getZ1());

	    	vertexTextureCoords.add(uvCoords.get(i).getX());
	    	vertexTextureCoords.add(uvCoords.get(i++).getY());

	    	vertexPositions.add(tri.getX2());
	    	vertexPositions.add(tri.getY2());
	    	vertexPositions.add(tri.getZ2());

	    	vertexTextureCoords.add(uvCoords.get(i).getX());
	    	vertexTextureCoords.add(uvCoords.get(i++).getY());

	    	vertexPositions.add(tri.getX3());
	    	vertexPositions.add(tri.getY3());
	    	vertexPositions.add(tri.getZ3());

	    	vertexTextureCoords.add(uvCoords.get(i).getX());
	    	vertexTextureCoords.add(uvCoords.get(i++).getY());

	    	floorVertexCount += 3;
	    }
	    floorVertexPosBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, floorVertexPosBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, 
				Float32Array.create(convertToFloatArray(vertexPositions)), 
				WebGLRenderingContext.STATIC_DRAW);
		
		floorVertexTextureCoordBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, floorVertexTextureCoordBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, 
				Float32Array.create(convertToFloatArray(vertexTextureCoords)), 
				WebGLRenderingContext.STATIC_DRAW);
		
		checkErrors();
	}

	/**
	 * Updates the Matrix widgets every 500ms
	 */
	private void showMatrices() {
		Timer timer = new Timer() {
			@Override
			public void run() {
			}
		};
		//timer.scheduleRepeating(500);
	}

	/**
	 * Initializes the controls of the example.
	 */
	private void initControls() {
		webGLCanvas.addMouseMoveHandler(camera);
		
		webGLCanvas.addMouseDownHandler(camera);
		
		webGLCanvas.addMouseUpHandler(camera);
		
		webGLCanvas.addKeyDownHandler(camera);
		webGLCanvas.addKeyUpHandler(camera);
	}

	/**
	 * Initialized the params of WebGL.
	 */
	private void initParams() {
		// Set the background color
		glContext.clearColor(0.2f, 0.2f, 0.2f, 1.0f);
		// Set the clear depth (everything is cleared)
		glContext.clearDepth(1.0f);

		// Activate depth test and set the depth function
		glContext.enable(WebGLRenderingContext.DEPTH_TEST);
		glContext.depthFunc(WebGLRenderingContext.LEQUAL);
	}

	/**
	 * Checks the WebGL Errors and throws an exception if there is an error.
	 */
	private void checkErrors() {
		int error = glContext.getError();
		if (error != WebGLRenderingContext.NO_ERROR) {
			String errorDesc = "UNKNOWN";
			if (error == WebGLRenderingContext.INVALID_ENUM) {
				errorDesc="INVALID_ENUM";
			} else if (error == WebGLRenderingContext.INVALID_OPERATION) {
				errorDesc="INVALID_OPERATION";
			} else if (error == WebGLRenderingContext.INVALID_FRAMEBUFFER_OPERATION) {
				errorDesc="INVALID_FRAMEBUFFER_OPERATION";
			} else if (error == WebGLRenderingContext.OUT_OF_MEMORY) {
				errorDesc="OUT_OF_MEMORY";
			}
			
			String message = "WebGL Error: " + error+", "+errorDesc;
			GWT.log(message, null);
			throw new RuntimeException(message);
		}
	}

	/**
	 * Creates the ShaderProgram used by the example to render.
	 */
	private void initShaders() {
		WebGLShader vertexShader = getShader(WebGLRenderingContext.VERTEX_SHADER,
				Resources.INSTANCE.vertexShader().getText());
		WebGLShader fragmentShader = getShader(WebGLRenderingContext.FRAGMENT_SHADER,
				Resources.INSTANCE.fragmentShader().getText());
		// Create the program object
		shaderProgram = glContext.createProgram();
		glContext.attachShader(shaderProgram, vertexShader);
		glContext.attachShader(shaderProgram, fragmentShader);
		
		glContext.linkProgram(shaderProgram);
		
		vertexPositionAttribute = glContext.getAttribLocation(shaderProgram, "aVertexPosition");
		glContext.enableVertexAttribArray(vertexPositionAttribute);
		
		textureCoordAttribute = glContext.getAttribLocation(shaderProgram, "aTextureCoord");
	    glContext.enableVertexAttribArray(textureCoordAttribute);
		// Check the link status
		boolean linked = glContext.getProgramParameterb(shaderProgram, WebGLRenderingContext.LINK_STATUS);
		if (!linked) {
			String infoLog = glContext.getProgramInfoLog(shaderProgram);
			GWT.log("Error linking program:\n" + infoLog, null);
			glContext.deleteProgram(shaderProgram);
			return;
		}

		textureUniform = glContext.getUniformLocation(shaderProgram, "uSampler");

		procTextureTypeUniform = glContext.getUniformLocation(shaderProgram, "uProcTextureType");
		
		checkErrors();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.gwtgl.example.client.AbstractGwtGLExample#draw()
	 */
	@Override
	protected void draw() {
		glContext.clear(WebGLRenderingContext.COLOR_BUFFER_BIT | WebGLRenderingContext.DEPTH_BUFFER_BIT);
		// Use the program object
		glContext.useProgram(shaderProgram);
		
	    if (wallsVertexTextureCoordBuffer == null || wallsVertexPosBuffer == null) {
	        return;
    	}
	    
		//TODO:Use this to move
		mvMatrix = MatrixUtil.createTranslationMatrix(0, 0, 0);
		
		perspectiveMatrix = MatrixUtil.createPerspectiveMatrix(45, 1.0f, 0.1f, 100);
		//translationMatrix = MatrixUtil.createTranslationMatrix(0, 0, translateZ);
		//translationMatrix = MatrixUtil.createTranslationMatrix(camera.getXPos(), camera.getYPos(), camera.getZPos());
		translationMatrix = MatrixUtil.createTranslationMatrix(-camera.getXPos(), -camera.getYPos(), -camera.getZPos());
		rotationMatrix = MatrixUtil.createRotationMatrix(camera.getRotationXAxis(), camera.getRotationYAxis(), 0);
		resultingMatrix = perspectiveMatrix.multiply(rotationMatrix).multiply(translationMatrix);
		
		/*
	    mat4.rotate(mvMatrix, degToRad(-pitch), [1, 0, 0]);
	    mat4.rotate(mvMatrix, degToRad(-yaw), [0, 1, 0]);
	    mat4.translate(mvMatrix, [-xPos, -yPos, -zPos]);
	    
		rotationMatrix = MatrixUtil.createRotationMatrix(camera.getRotationXAxis(), camera.getRotationYAxis(), 0);
		*/

		
		//Set common uniforms
		WebGLUniformLocation mvUniform = glContext.getUniformLocation(shaderProgram, "uMVMatrix");
		glContext.uniformMatrix4fv(mvUniform, false, resultingMatrix.getColumnWiseFlatData());
		WebGLUniformLocation projectionUniform = glContext.getUniformLocation(shaderProgram, "uPMatrix");
		glContext.uniformMatrix4fv(projectionUniform, false, perspectiveMatrix.getColumnWiseFlatData());
		
	    //Setup Texture info ready for shader to process.
		//XXX:Remove this?
		glContext.activeTexture(WebGLRenderingContext.TEXTURE0);
		//glContext.bindTexture(WebGLRenderingContext.TEXTURE_2D, mudTexture);
		glContext.bindTexture(WebGLRenderingContext.TEXTURE_2D, wallTexture);
		glContext.uniform1i(textureUniform, 0);

		//Load the vertex texture data into buffer
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, wallsVertexTextureCoordBuffer);
		glContext.vertexAttribPointer(textureCoordAttribute, 2, WebGLRenderingContext.FLOAT, false, 0, 0);

		//load vertex data into buffer.
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, wallsVertexPosBuffer);
		glContext.vertexAttribPointer(vertexPositionAttribute, 3, WebGLRenderingContext.FLOAT, false, 0, 0);
		
		/*
		//Draw walls you!
		glContext.uniform1i(procTextureTypeUniform, 0);
	    glContext.drawArrays(WebGLRenderingContext.TRIANGLES, 0, wallsVertexCount);
	    
	    //Skybox!
		//Vertex pos attrib
		glContext.uniform1i(procTextureTypeUniform, 1);
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, skyboxBuffer);
		glContext.vertexAttribPointer(vertexPositionAttribute, 3, WebGLRenderingContext.FLOAT, false, 0, 0);
		
		//Load the vertex texture data into buffer
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, skyboxTextureBuffer);
		glContext.vertexAttribPointer(textureCoordAttribute, 2, WebGLRenderingContext.FLOAT, false, 0, 0);
		
		glContext.drawArrays(WebGLRenderingContext.TRIANGLES, 0, 36);
		glContext.flush();

		//Ceiling
		//Vertex pos attrib
		glContext.uniform1i(procTextureTypeUniform, 3);
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, ceilingVertexPosBuffer);
		glContext.vertexAttribPointer(vertexPositionAttribute, 3, WebGLRenderingContext.FLOAT, false, 0, 0);
		//Load the vertex texture data into buffer
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, ceilingVertexTextureCoordBuffer);
		glContext.vertexAttribPointer(textureCoordAttribute, 2, WebGLRenderingContext.FLOAT, false, 0, 0);
		
		glContext.drawArrays(WebGLRenderingContext.TRIANGLES, 0, ceilingVertexCount);
		glContext.flush();
		
		//Floor
		//Vertex pos attrib
		glContext.uniform1i(procTextureTypeUniform, 4);
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, floorVertexPosBuffer);
		glContext.vertexAttribPointer(vertexPositionAttribute, 3, WebGLRenderingContext.FLOAT, false, 0, 0);
		//Load the vertex texture data into buffer
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, floorVertexTextureCoordBuffer);
		glContext.vertexAttribPointer(textureCoordAttribute, 2, WebGLRenderingContext.FLOAT, false, 0, 0);
		
		glContext.drawArrays(WebGLRenderingContext.TRIANGLES, 0, floorVertexCount);
		glContext.flush();
		*/
	    //Pillars
		//Vertex pos attrib
		glContext.uniform1i(procTextureTypeUniform, 1);
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, pillarsVertexPosBuffer);
		glContext.vertexAttribPointer(vertexPositionAttribute, 3, WebGLRenderingContext.FLOAT, false, 0, 0);
		
		//Load the vertex texture data into buffer
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, pillarsVertexTextureCoordBuffer);
		glContext.vertexAttribPointer(textureCoordAttribute, 2, WebGLRenderingContext.FLOAT, false, 0, 0);
		
		glContext.drawArrays(WebGLRenderingContext.TRIANGLES, 0, pillarsVertexCount);
		glContext.flush();
		//
		
		
	    /*
		// Load the vertex data
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, buffer);
		glContext.vertexAttribPointer(vertexPositionAttribute, 3, WebGLRenderingContext.FLOAT, false, 0, 0);

		glContext.vertexAttribPointer(textureCoordAttribute, 2, WebGLRenderingContext.FLOAT, false, 0, texCoordsOffset);
		WebGLUniformLocation mvUniform = glContext.getUniformLocation(shaderProgram, "projectionMatrix");

		// Load the vertex data
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexBuffer);
		glContext.vertexAttribPointer(vertexPositionAttribute, 3, WebGLRenderingContext.FLOAT, false, 0, 0);
		
		// Load the texture coordinates data
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexTextureCoordBuffer);
		glContext.vertexAttribPointer(textureCoordAttribute, 2, WebGLRenderingContext.FLOAT, false, 0, 0);
		
		perspectiveMatrix = MatrixUtil.createPerspectiveMatrix(45, 1.0f, 0.1f, 100);
		translationMatrix = MatrixUtil.createTranslationMatrix(0, 0, translateZ);
		rotationMatrix = MatrixUtil.createRotationMatrix(camera.getRotationXAxis(), camera.getRotationYAxis(), 0);
		resultingMatrix = perspectiveMatrix.multiply(translationMatrix).multiply(rotationMatrix);

		glContext.uniformMatrix4fv(mvUniform, false, resultingMatrix.getColumnWiseFlatData());
		glContext.uniform1i(textureUniform, 0);
		
		glContext.activeTexture(WebGLRenderingContext.TEXTURE0);
		
		glContext.bindTexture(WebGLRenderingContext.TEXTURE_2D, textureBack);
		glContext.drawArrays(WebGLRenderingContext.TRIANGLES, 0, 6);
		
		glContext.bindTexture(WebGLRenderingContext.TEXTURE_2D, textureFront);
		glContext.drawArrays(WebGLRenderingContext.TRIANGLES, 6, 6);
		
		glContext.bindTexture(WebGLRenderingContext.TEXTURE_2D, textureLeft);
		glContext.drawArrays(WebGLRenderingContext.TRIANGLES, 12, 6);
		
		glContext.bindTexture(WebGLRenderingContext.TEXTURE_2D, textureRight);
		glContext.drawArrays(WebGLRenderingContext.TRIANGLES, 18, 6);
		
		glContext.bindTexture(WebGLRenderingContext.TEXTURE_2D, textureTop);
		glContext.drawArrays(WebGLRenderingContext.TRIANGLES, 24, 6);
		
		glContext.bindTexture(WebGLRenderingContext.TEXTURE_2D, textureBottom);
		glContext.drawArrays(WebGLRenderingContext.TRIANGLES, 30, 6);
		
		// Bind the texture to texture unit 1
//		glContext.activeTexture(WebGLRenderingContext.TEXTURE1);
//		glContext.bindTexture(WebGLRenderingContext.TEXTURE_2D, texture);

		// Point the uniform sampler to texture unit 1
//		glContext.uniform1i(textureUniform, 1);
//		glContext.drawArrays(WebGLRenderingContext.TRIANGLES, 0, 36);
//		glContext.flush();
		
//		checkErrors();
		glContext.flush();
		checkErrors();
		*/
	}

	/**
	 * Converts ImageResource to Image.
	 * @param imageResource
	 * @return {@link Image} to be used as a texture
	 */
	public Image getImage(final ImageResource imageResource) {
		final Image img = new Image();
		img.setVisible(false);
		RootPanel.get().add(img);

		img.setUrl(imageResource.getURL());
	
		return img;
	}
	
	/**
	 * Initializes the textures of this example.
	 */
	private void initTexture() {
		//mudTexture = createTexture(Resources.INSTANCE.mudTexture());
		wallTexture = createTexture(Resources.INSTANCE.texture());
		/*
		glContext.texParameteri(WebGLRenderingContext.TEXTURE_2D, 
				WebGLRenderingContext.TEXTURE_MAG_FILTER, 
				WebGLRenderingContext.LINEAR);
		glContext.texParameteri(WebGLRenderingContext.TEXTURE_2D, 
				WebGLRenderingContext.TEXTURE_MIN_FILTER, 
				WebGLRenderingContext.LINEAR);
		glContext.bindTexture(WebGLRenderingContext.TEXTURE_2D, 
				null);
		*/
		checkErrors();
		
		/*
		// Create and initialize the WebGLTexture objects.
		textureFront = createTexture(Resources.INSTANCE.textureSkyboxFt());
		textureBack = createTexture(Resources.INSTANCE.textureSkyboxBk());
		textureTop = createTexture(Resources.INSTANCE.textureSkyboxUp());
		textureBottom = createTexture(Resources.INSTANCE.textureSkyboxDn());
		textureLeft = createTexture(Resources.INSTANCE.textureSkyboxLf());
		textureRight = createTexture(Resources.INSTANCE.textureSkyboxRt());
		texture = glContext.createTexture();
		glContext.bindTexture(WebGLRenderingContext.TEXTURE_2D, texture);
		final Image img = getImage(Resources.INSTANCE.texture());
		img.addLoadHandler(new LoadHandler() {
			@Override
			public void onLoad(LoadEvent event) {
				RootPanel.get().remove(img);
				GWT.log("texture image loaded", null);
				glContext.bindTexture(WebGLRenderingContext.TEXTURE_2D, texture);
				glContext.texImage2D(WebGLRenderingContext.TEXTURE_2D, 
						0, 
						WebGLRenderingContext.RGBA, 
						WebGLRenderingContext.RGBA, 
						WebGLRenderingContext.UNSIGNED_BYTE, 
						img.getElement());
			}
		});

		glContext.texParameteri(WebGLRenderingContext.TEXTURE_2D, 
				WebGLRenderingContext.TEXTURE_MAG_FILTER, 
				WebGLRenderingContext.LINEAR);
		glContext.texParameteri(WebGLRenderingContext.TEXTURE_2D, 
				WebGLRenderingContext.TEXTURE_MIN_FILTER, 
				WebGLRenderingContext.LINEAR);
		glContext.bindTexture(WebGLRenderingContext.TEXTURE_2D, 
				null);
		
		checkErrors();
		*/
	}

	private WebGLTexture createTexture(ImageResource imageResource) {
		final WebGLTexture texture = glContext.createTexture();
		
		final Image img = new Image();
		img.addLoadHandler(new LoadHandler() {
			@Override
			public void onLoad(LoadEvent event) {
				RootPanel.get().remove(img);

				glContext.pixelStorei(WebGLRenderingContext.UNPACK_FLIP_Y_WEBGL, 1);
				glContext.activeTexture(WebGLRenderingContext.TEXTURE0);
				glContext.bindTexture(WebGLRenderingContext.TEXTURE_2D, texture);
				
				glContext.texParameteri(WebGLRenderingContext.TEXTURE_2D, WebGLRenderingContext.TEXTURE_MIN_FILTER, WebGLRenderingContext.NEAREST);
				glContext.texParameteri(WebGLRenderingContext.TEXTURE_2D, WebGLRenderingContext.TEXTURE_MAG_FILTER, WebGLRenderingContext.NEAREST);
				glContext.texParameteri(WebGLRenderingContext.TEXTURE_2D, WebGLRenderingContext.TEXTURE_MAG_FILTER, WebGLRenderingContext.NEAREST);
				
				glContext.texImage2D(WebGLRenderingContext.TEXTURE_2D, 0, WebGLRenderingContext.RGBA,WebGLRenderingContext.RGBA, WebGLRenderingContext.UNSIGNED_BYTE, img.getElement());
				
				glContext.bindTexture(WebGLRenderingContext.TEXTURE_2D, null);
				checkErrors();

				/*
				glContext.pixelStorei(WebGLRenderingContext.UNPACK_FLIP_Y_WEBGL, 1);
				glContext.bindTexture(WebGLRenderingContext.TEXTURE_2D, texture);
				glContext.texImage2D(WebGLRenderingContext.TEXTURE_2D, 0, WebGLRenderingContext.RGBA, WebGLRenderingContext.RGBA, WebGLRenderingContext.UNSIGNED_BYTE, texture); //Not sure about last param here.
				glContext.texParameteri(WebGLRenderingContext.TEXTURE_2D, WebGLRenderingContext.TEXTURE_MAG_FILTER, WebGLRenderingContext.LINEAR);
				glContext.texParameteri(WebGLRenderingContext.TEXTURE_2D, WebGLRenderingContext.TEXTURE_MIN_FILTER, WebGLRenderingContext.LINEAR);
				//glContext.bindTexture(WebGLRenderingContext.TEXTURE_2D, null);
				
				checkErrors();
								 */
			}
		});
		img.setVisible(false);
		RootPanel.get().add(img);
		// image.setResource(imageResource);
		// TODO doesn't work with more than one image bundled to one
		// ImageBundle if the browser doesn't support data:... urls
		// So it's no problem at the moment because Chrome and FF support it
		img.setUrl(imageResource.getURL());
		return texture;
	}

	/**
	 * Creates an Shader instance defined by the ShaderType and the source.
	 * 
	 * @param shaderType
	 *            the type of the shader to create
	 * @param source
	 *            the source of the shader
	 * @return the created Shader instance.
	 */
	WebGLShader getShader(int shaderType, String source) {
		WebGLShader shader = glContext.createShader(shaderType);
		glContext.shaderSource(shader, source);
		glContext.compileShader(shader);

		// check if the Shader is successfully compiled
		if (!glContext.getShaderParameterb(shader, WebGLRenderingContext.COMPILE_STATUS)) {
			throw new RuntimeException(glContext.getShaderInfoLog(shader));
		}

		return shader;

	}
	
	public void update() {
		camera.update();
	}

}
