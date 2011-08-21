package com.df3n5.gwtproc.client.demos.webglperf;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.google.gwt.core.client.GWT.log;

import com.df3n5.gwtproc.client.AbstractGwtProcDemo;
import com.df3n5.gwtproc.client.util.math.FloatMatrix;
import com.df3n5.gwtproc.client.util.math.FloatMatrix4x4;
import com.df3n5.gwtproc.client.util.math.MatrixUtil;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwtgl.array.Float32Array;
import com.googlecode.gwtgl.array.Uint16Array;
import com.googlecode.gwtgl.binding.WebGLBuffer;
import com.googlecode.gwtgl.binding.WebGLContextAttributes;
import com.googlecode.gwtgl.binding.WebGLProgram;
import com.googlecode.gwtgl.binding.WebGLRenderingContext;
import com.googlecode.gwtgl.binding.WebGLShader;
import com.googlecode.gwtgl.binding.WebGLTexture;
import com.googlecode.gwtgl.binding.WebGLUniformLocation;

public class WebGLPerfDemo extends AbstractGwtProcDemo {
	
	protected float translateZ;
	private WebGLProgram shaderProgram;
	private int vertexPositionAttribute;
	private int textureCoordAttribute;
	private WebGLUniformLocation projectionMatrixUniform;
	private WebGLUniformLocation textureUniform;
	private WebGLBuffer vertexBuffer;
	private WebGLBuffer verticesIndexBuffer;
	private WebGLTexture texture;
	private FloatMatrix4x4 perspectiveMatrix;
	private FloatMatrix4x4 translationMatrix;
	private FloatMatrix rotationMatrix;
	private FloatMatrix resultingMatrix;
	private int angleX;
	private int angleY;
	private int angleZ;
	private WebGLBuffer vertexTextureCoordBuffer;
	private Date currentTime;
	private Date lastTime;
	
	private final int SUBDIVISION_LEVEL = 2000;
	private final boolean isWithTex = true;

    Logger perfLogger = Logger.getLogger("WebGLPerfDemo Logger");
	
	public WebGLPerfDemo() {
		super();
		getFlexCellFormatter().setColSpan(2, 0, 2);

		// Show a description of the controls
		HTML exampleDescription = new HTML(
				"<h2>WebGLPerf Demo</p>");
		VerticalPanel descriptionAndControls = new VerticalPanel();
		descriptionAndControls.add(exampleDescription);
		setWidget(1, 1, descriptionAndControls);
		
		translateZ = -2.0f;
 
		currentTime = new Date();
		//Start
		/*
		super.start();
		webGLCanvas.setFocus(true);
		*/
		//Endstart
	}

	private long getTimeStampMilli() {
        Date date = new Date();
        return date.getTime();
	}

	@Override
	protected void init() {
		initParams();
		initShaders();
		initBuffers();
		if(isWithTex){
			initTexture();
		}
		initControls();
	}
	
	@Override
	public void update() {
	}

	private void initControls() {
		// Handle keyboard input
		webGLCanvas.addKeyDownHandler(new KeyDownHandler() {
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_PAGEUP) {
					translateZ += 0.1f;
					event.stopPropagation();
					event.preventDefault();
				}
				if (event.getNativeKeyCode() == KeyCodes.KEY_PAGEDOWN) {
					translateZ -= 0.1f;
					event.stopPropagation();
					event.preventDefault();
				}
			}
		});
	}

	/**
	 * Initialized the params of WebGL.
	 */
	private void initParams() {
		glContext.viewport(0, 0, webGLCanvas.getOffsetWidth(), webGLCanvas.getOffsetHeight());
		
		// clear with background color
		glContext.clearColor(0.2f, 0.2f, 0.2f, 1.0f);

		// clear the whole image
		glContext.clearDepth(1.0f);

		// enable the depth test
		glContext.enable(WebGLRenderingContext.DEPTH_TEST);
		glContext.depthFunc(WebGLRenderingContext.LEQUAL);
		
		checkErrors();
	}

	/**
	 * Checks the WebGL Errors and throws an exception if there is an error.
	 */
	private void checkErrors() {
		int error = glContext.getError();
		if (error != WebGLRenderingContext.NO_ERROR) {
			String message = "WebGL Error: " + error;
			log(message, null);
			throw new RuntimeException(message);
		}
	}

	/**
	 * Creates the ShaderProgram used by the example to render.
	 */
	private void initShaders() {
		// Create the Shaders
		WebGLShader fragmentShader = null;
		WebGLShader vertexShader = null;
		if(isWithTex) {
			fragmentShader = getShader(WebGLRenderingContext.FRAGMENT_SHADER, Resources.INSTANCE.fragmentShaderWithTex().getText());
			log("Created fragment shader");
		
			vertexShader = getShader(WebGLRenderingContext.VERTEX_SHADER, Resources.INSTANCE.vertexShaderWithTex().getText());
			log("Created vertex shader");
		}else{
			fragmentShader = getShader(WebGLRenderingContext.FRAGMENT_SHADER, Resources.INSTANCE.fragmentShaderWithoutTex().getText());
			log("Created fragment shader");
		
			vertexShader = getShader(WebGLRenderingContext.VERTEX_SHADER, Resources.INSTANCE.vertexShaderWithoutTex().getText());
			log("Created vertex shader");
		}
		if (vertexShader == null || fragmentShader == null) {
			log("Shader error");
			throw new RuntimeException("shader error");
		}

		// create the ShaderProgram and attach the Shaders
		shaderProgram = glContext.createProgram();
		if (shaderProgram == null || glContext.getError() != WebGLRenderingContext.NO_ERROR) {
			log("Program errror");
			throw new RuntimeException("program error");
		}

		log("Shader program created");
		glContext.attachShader(shaderProgram, vertexShader);
		log("vertex shader attached to shader program");
		glContext.attachShader(shaderProgram, fragmentShader);
		log("fragment shader attached to shader program");

		// Bind vertexPosition to attribute 0
		glContext.bindAttribLocation(shaderProgram, 0, "vertexPosition");
		// Bind texPosition to attribute 1
		glContext.bindAttribLocation(shaderProgram, 1, "texPosition");
		
		// Link the Shader Program
		glContext.linkProgram(shaderProgram);
		if (!glContext.getProgramParameterb(shaderProgram,
				WebGLRenderingContext.LINK_STATUS)) {
			throw new RuntimeException("Could not initialise shaders: " + glContext.getProgramInfoLog (shaderProgram));
		}
		log("Shader program linked");
		

		// Set the ShaderProgram active
		glContext.useProgram(shaderProgram);

		vertexPositionAttribute = glContext.getAttribLocation(shaderProgram, "vertexPosition");
		glContext.enableVertexAttribArray(vertexPositionAttribute);
		


		// get the position of the projectionMatrix uniform.
		projectionMatrixUniform = glContext.getUniformLocation(shaderProgram,
				"projectionMatrix");
		
		if(isWithTex) {
			textureCoordAttribute = glContext.getAttribLocation(shaderProgram, "texPosition");
			glContext.enableVertexAttribArray(textureCoordAttribute);
	    
			// get the position of the tex uniform.
			textureUniform = glContext.getUniformLocation(shaderProgram, "tex");
		}
		
		checkErrors();
	}
	
	/**
	 * Creates an Shader instance defined by the ShaderType and the source.
	 * 
	 * @param type
	 *            the type of the shader to create
	 * @param source
	 *            the source of the shader
	 * @return the created Shader instance.
	 */
	private WebGLShader getShader(int type, String source) {
		WebGLShader shader = glContext.createShader(type);
		glContext.shaderSource(shader, source);
		glContext.compileShader(shader);
		checkErrors();

		// check if the Shader is successfully compiled
		if (!glContext.getShaderParameterb(shader, WebGLRenderingContext.COMPILE_STATUS)) {
			throw new RuntimeException(glContext.getShaderInfoLog(shader));
		}

		return shader;

	}

	//Helper function to get index for a 1D array as if it were a 2D array
	int idx(int i, int j, int size)
	{
	    return (i + (size * j));
	}
	
	/**
	 * Initializes the buffers for vertex coordinates, normals and texture
	 * coordinates.
	 */
	private void initBuffers() {
		float halfSize = 10000.0f;
		float newHalfSize = halfSize / SUBDIVISION_LEVEL;
		float squareSide = newHalfSize * 2.0f;
		float z = -1.0f;
		/*
		float[] vertices = new float[]{
				// Front face
				-1.0f, -1.0f,  -1.0f,
				1.0f, -1.0f,  -1.0f,
				1.0f,  1.0f,  -1.0f,
				-1.0f,  1.0f,  -1.0f,
		};
		*/
		
		//Non-element-array method (Wasteful method)
		//------------------------------
		int numSquares = SUBDIVISION_LEVEL*SUBDIVISION_LEVEL;
		int numTriangles = numSquares * 2;
		int numVerticesPerRow = SUBDIVISION_LEVEL * 2 * 9;//9=3*3 is number of vertices in triangle * x,y,z of vertex
		float[] vertices = new float[numTriangles * 9]; //9=3*3 is number of vertices in triangle * x,y,z of vertex
		
		System.out.println("numSquares : " + numSquares);
		System.out.println("numTriangles * 3 : " + numTriangles * 9); //9=3*3 is number of vertices in triangle * x,y,z of vertex
		
		//Loop through squares, each loop iteration makes one square
		for(int i = 0 ; i < SUBDIVISION_LEVEL ; i++) {
			for(int j = 0 ; j < SUBDIVISION_LEVEL ; j++) {
		    
			    int newI = i * 18;
				int baseIdx = idx(newI,j,numVerticesPerRow);
				float iBySquareSide = i*squareSide;
				float iPlus1BySquareSide = (i+1)*squareSide;

				float jBySquareSide = j*squareSide;
				float jPlus1BySquareSide = (j+1)*squareSide;

			    //tri1
			    //p1
			    vertices[baseIdx++] = iBySquareSide;
			    vertices[baseIdx++] = jPlus1BySquareSide;
			    vertices[baseIdx++] = z; 
			    
			    //p2
			    vertices[baseIdx++] = iBySquareSide; 
			    vertices[baseIdx++] = jBySquareSide; 
			    vertices[baseIdx++] = z;
			    
			    //p4
			    vertices[baseIdx++] = iPlus1BySquareSide; 
			    vertices[baseIdx++] = jBySquareSide; 
			    vertices[baseIdx++] = z;
			    
			    //tri2
			    //p1
			    vertices[baseIdx++] = iBySquareSide;
			    vertices[baseIdx++] = jPlus1BySquareSide;
			    vertices[baseIdx++] = z; 
			    
			    //p3
			    vertices[baseIdx++] = iPlus1BySquareSide;
			    vertices[baseIdx++] = jPlus1BySquareSide;
			    vertices[baseIdx++] = z; 
			    
			    //p4
			    vertices[baseIdx++] = iPlus1BySquareSide; 
			    vertices[baseIdx++] = jBySquareSide; 
			    vertices[baseIdx++] = z;
			}
		}
		
		//BEGIN debug
		/*
		for(int i=0 ; i<numTriangles * 9;i++) {
			System.out.println("x is : " + vertices[i++]);
			System.out.println("y is : " + vertices[i++]);
			System.out.println("z is : " + vertices[i]);
		}
		*/
		//END debug
		
		vertexBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER,
				Float32Array.create(vertices),
				WebGLRenderingContext.STATIC_DRAW);
		
		if(isWithTex) {
			//Tex coords:
			float[] texCoords = new float[numTriangles * 6]; //6=3*2
			for(int i = 0 ; i < numSquares ;i++) {
				int tempI = 0;
				int squareOffset = i * 12;
				
				texCoords[squareOffset + tempI++] = -1.0f;
				texCoords[squareOffset + tempI++] = 1.0f;  //p1
				
				texCoords[squareOffset + tempI++] = -1.0f;
				texCoords[squareOffset + tempI++] = -1.0f;  //p2
				
				texCoords[squareOffset + tempI++] = 1.0f;
				texCoords[squareOffset + tempI++] = -1.0f;  //p4
				
				texCoords[squareOffset + tempI++] = -1.0f;
				texCoords[squareOffset + tempI++] = 1.0f;  //p1
				
				texCoords[squareOffset + tempI++] = 1.0f;
				texCoords[squareOffset + tempI++] = 1.0f;  //p3
				
				texCoords[squareOffset + tempI++] = 1.0f;
				texCoords[squareOffset + tempI++] = -1.0f;  //p4
			}
			vertexTextureCoordBuffer = glContext.createBuffer();
			glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexTextureCoordBuffer);
			glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, 
					Float32Array.create(texCoords), 
					WebGLRenderingContext.STATIC_DRAW);
		}
		//------------------------------
		
		
		//Element-array method (good method?)
		//------------------------------
		/*
		float[] vertices = new float[]{
				// Front face
				-newHalfSize, -newHalfSize,  -newHalfSize,
				newHalfSize, -newHalfSize,  -newHalfSize,
				newHalfSize,  newHalfSize,  -newHalfSize,
				-newHalfSize,  newHalfSize,  -newHalfSize,
		};

		vertexBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER,
				Float32Array.create(vertices),
				WebGLRenderingContext.STATIC_DRAW);

		//Index for maximum efficiency
		verticesIndexBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ELEMENT_ARRAY_BUFFER, verticesIndexBuffer);

		int[] vertexIndices = new int[]{
				0,  1,  2,      0,  2,  3,    // front
		};
		glContext.bufferData(WebGLRenderingContext.ELEMENT_ARRAY_BUFFER,
				Uint16Array.create(vertexIndices), 
				WebGLRenderingContext.STATIC_DRAW);  

		//Tex coords:
		float[] texCoords = new float[]{
                // Front face
                -1.0f, -1.0f,  
                 1.0f, -1.0f, 
                 1.0f,  1.0f,
                -1.0f,  1.0f,
				};
		vertexTextureCoordBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexTextureCoordBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, 
				Float32Array.create(texCoords), 
				WebGLRenderingContext.STATIC_DRAW);
		*/
		//------------------------------
		
		checkErrors();
	}

	@Override
	protected void draw() {
		lastTime = currentTime;
		currentTime = new Date();
		//System.out.println((currentTime.getTime() - lastTime.getTime()));
		perfLogger.log(Level.INFO, Long.toString(currentTime.getTime() - lastTime.getTime()));
		
		angleX = (angleX + 1) % 360;
		angleY = (angleY + 1) % 360;
		//angleZ=(angleZ+2)%360;

		glContext.clear(WebGLRenderingContext.COLOR_BUFFER_BIT | WebGLRenderingContext.DEPTH_BUFFER_BIT);
		
		//Non-element-array method (Wasteful method)
		//------------------------------
		glContext.vertexAttribPointer(vertexPositionAttribute, 3,
				WebGLRenderingContext.FLOAT, false, 0, 0);
		// Load the vertex data
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexBuffer);
		glContext.vertexAttribPointer(vertexPositionAttribute, 3, WebGLRenderingContext.FLOAT, false, 0, 0);
		//------------------------------

		//Element-array method (good method?)
		//------------------------------
		/*
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexBuffer);
	    glContext.bindBuffer(WebGLRenderingContext.ELEMENT_ARRAY_BUFFER, 
			  verticesIndexBuffer);
		glContext.vertexAttribPointer(vertexPositionAttribute, 
				3, 
				WebGLRenderingContext.FLOAT, 
				false, 
				0, 
				0);
				*/
		//------------------------------
		if(isWithTex){
			// Load the texture coordinates data
			glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexTextureCoordBuffer);
			glContext.vertexAttribPointer(textureCoordAttribute, 2, WebGLRenderingContext.FLOAT, false, 0, 0);
			
			// Bind the texture to texture unit 0
			glContext.activeTexture(WebGLRenderingContext.TEXTURE0);
			glContext.bindTexture(WebGLRenderingContext.TEXTURE_2D, texture);

			// Point the uniform sampler to texture unit 0
			glContext.uniform1i(textureUniform, 0);
		}
		
		perspectiveMatrix = MatrixUtil.createPerspectiveMatrix(45, 1.0f, 0.1f, 100);
		translationMatrix = MatrixUtil.createTranslationMatrix(0, 0, translateZ);
		rotationMatrix = MatrixUtil.createRotationMatrix(angleX, angleY, angleZ);
		resultingMatrix = perspectiveMatrix.multiply(translationMatrix).multiply(rotationMatrix);

		glContext.uniformMatrix4fv(projectionMatrixUniform, false, resultingMatrix.getColumnWiseFlatData());
		
		//Non-element-array method (Wasteful method)
		//------------------------------
		//glContext.drawArrays(WebGLRenderingContext.TRIANGLES, 0, 64);
		glContext.drawArrays(WebGLRenderingContext.TRIANGLES, 0, SUBDIVISION_LEVEL*SUBDIVISION_LEVEL*6);
		//------------------------------
		
		//Element-array method (good method?)
		//------------------------------
		/*
		glContext.drawElements(WebGLRenderingContext.TRIANGLES, 
				6, 
				WebGLRenderingContext.UNSIGNED_SHORT, 
				0);
				*/
		//------------------------------
		glContext.flush();
		checkErrors();
	}

	private void initTexture() {
		texture = glContext.createTexture();
		glContext.bindTexture(WebGLRenderingContext.TEXTURE_2D, texture);
		final Image img = getImage(Resources.INSTANCE.texture());
		img.addLoadHandler(new LoadHandler() {
			public void onLoad(LoadEvent event) {
				RootPanel.get().remove(img);
				log("texture image loaded", null);
				glContext.bindTexture(WebGLRenderingContext.TEXTURE_2D, texture);
				glContext.texImage2D(WebGLRenderingContext.TEXTURE_2D, 0, WebGLRenderingContext.RGBA, WebGLRenderingContext.RGBA, WebGLRenderingContext.UNSIGNED_BYTE, img.getElement());
			}
		});
		checkErrors();
		glContext.texParameteri(WebGLRenderingContext.TEXTURE_2D, WebGLRenderingContext.TEXTURE_MAG_FILTER, WebGLRenderingContext.LINEAR);
		glContext.texParameteri(WebGLRenderingContext.TEXTURE_2D, WebGLRenderingContext.TEXTURE_MIN_FILTER, WebGLRenderingContext.LINEAR);
		glContext.bindTexture(WebGLRenderingContext.TEXTURE_2D, null);
		checkErrors();
	}
	
	public Image getImage(final ImageResource imageResource) {
		final Image img = new Image();
		img.setVisible(false);
		RootPanel.get().add(img);

		img.setUrl(imageResource.getURL());
	
		return img;
	}
}
