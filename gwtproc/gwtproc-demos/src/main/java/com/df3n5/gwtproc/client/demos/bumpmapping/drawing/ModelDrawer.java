package com.df3n5.gwtproc.client.demos.bumpmapping.drawing;

import com.df3n5.gwtproc.client.demos.bumpmapping.Camera;
import com.df3n5.gwtproc.client.demos.bumpmapping.ErrorHandler;
import com.df3n5.gwtproc.client.demos.bumpmapping.Resources;
import com.df3n5.gwtproc.client.demos.bumpmapping.model.Model;
import com.df3n5.gwtproc.client.util.math.FloatMatrix;
import com.df3n5.gwtproc.client.util.math.MatrixUtil;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.GWT;
import com.googlecode.gwtgl.binding.WebGLProgram;
import com.googlecode.gwtgl.binding.WebGLRenderingContext;
import com.googlecode.gwtgl.binding.WebGLShader;
import com.googlecode.gwtgl.binding.WebGLUniformLocation;

public class ModelDrawer {
	protected final WebGLRenderingContext glContext;
	
	private Camera camera;
	
	private WebGLProgram shaderProgram;
	
	//ATTRIB
	private int vertexPositionAttribute;
	private int normalAttribute;
	private int textureCoordAttribute;
	
	//UNIFORM
	private WebGLUniformLocation procTextureTypeUniform;
	private WebGLUniformLocation mvUniform;
	private WebGLUniformLocation projectionUniform;
//	private WebGLUniformLocation lightingUniform;
//	private WebGLUniformLocation ambientColorUniform;
	//For bump mapping
	private WebGLUniformLocation lightPositionUniform;
//	private WebGLUniformLocation lightDirUniform;
//	private WebGLUniformLocation eyeDirUniform;

	private WebGLUniformLocation uTexSamp;
	
	private FloatMatrix perspectiveMatrix;
	private FloatMatrix translationMatrix;
	private FloatMatrix rotationMatrix;
	private FloatMatrix resultingMatrix;
	
	public ModelDrawer(WebGLRenderingContext glContext) {
		this.glContext = glContext;
		camera = new Camera();
	}
	
	///----------------------------------------------------------------------------------------------------------------
	///----------------------------------------------------------------------------------------------------------------
	///----------------------------------------------------------------------------------------------------------------
	
	/**
	 * Note: This has to be called each time the matrices change.
	 */
	protected void setCommonUniforms() {
		mvUniform = glContext.getUniformLocation(shaderProgram, "uMVMatrix");
		glContext.uniformMatrix4fv(mvUniform, false, resultingMatrix.getColumnWiseFlatData());
		
		projectionUniform = glContext.getUniformLocation(shaderProgram, "uPMatrix");
		glContext.uniformMatrix4fv(projectionUniform, false, perspectiveMatrix.getColumnWiseFlatData());
		
		lightPositionUniform = glContext.getUniformLocation(shaderProgram, "uLightPosition");

		//Set Texture Sampler to look for texture in texture unit 0
//		uTexSamp = glContext.getUniformLocation(shaderProgram, "uTexSamp");
//		glContext.uniform1i(uTexSamp, 0);
	}


	
	protected void setUniforms(Model model) {
		switch(model.getType()) {
			case Model.WALL_TYPE:
				glContext.uniform1i(procTextureTypeUniform, 0);
				break;
			case Model.FLOOR_TYPE:
				glContext.uniform1i(procTextureTypeUniform, 4);
				break;
			case Model.CEILING_TYPE:
				glContext.uniform1i(procTextureTypeUniform, 3);
				break;
			case Model.PILLAR_TYPE:
				glContext.uniform1i(procTextureTypeUniform, 3);
				break;
			case Model.SKYBOX_TYPE:
				glContext.uniform1i(procTextureTypeUniform, 1);
				break;
		}
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
	protected WebGLShader getShader(int shaderType, String source) {
		WebGLShader shader = glContext.createShader(shaderType);
		glContext.shaderSource(shader, source);
		glContext.compileShader(shader);

		// check if the Shader is successfully compiled
		if (!glContext.getShaderParameterb(shader, WebGLRenderingContext.COMPILE_STATUS)) {
			throw new RuntimeException(glContext.getShaderInfoLog(shader));
		}

		return shader;
	}
	
	/**
	 * Creates the ShaderProgram used by the example to render.
	 */
	private void initShaders() {
		/*
		WebGLShader vertexShader = getShader(WebGLRenderingContext.VERTEX_SHADER,
				Resources.INSTANCE.vertexShader().getText());
		WebGLShader fragmentShader = getShader(WebGLRenderingContext.FRAGMENT_SHADER,
				Resources.INSTANCE.fragmentShader().getText());
				*/

		WebGLShader vertexShader = getShader(WebGLRenderingContext.VERTEX_SHADER,
				Resources.INSTANCE.bumpMappingVert().getText());
		WebGLShader fragmentShader = getShader(WebGLRenderingContext.FRAGMENT_SHADER,
				Resources.INSTANCE.bumpMappingFrag().getText());
		// Create the program object
		shaderProgram = glContext.createProgram();
		glContext.attachShader(shaderProgram, vertexShader);
		glContext.attachShader(shaderProgram, fragmentShader);
		
		glContext.linkProgram(shaderProgram);
		
		/*
		vertexPositionAttribute = glContext.getAttribLocation(shaderProgram, "aPos");
		glContext.enableVertexAttribArray(vertexPositionAttribute);
		
		textureCoordAttribute = glContext.getAttribLocation(shaderProgram, "aTexCoord");
	    glContext.enableVertexAttribArray(textureCoordAttribute);
		*/
	    
		/*
		normalAttribute = glContext.getAttribLocation(shaderProgram, "aNorm");
	    glContext.enableVertexAttribArray(normalAttribute);

		aBinorm1Attribute = glContext.getAttribLocation(shaderProgram, "aBinorm1");
	    glContext.enableVertexAttribArray(aBinorm1Attribute);

		aBinorm2Attribute = glContext.getAttribLocation(shaderProgram, "aBinorm2");
	    glContext.enableVertexAttribArray(aBinorm2Attribute);
		*/
		
		procTextureTypeUniform = glContext.getUniformLocation(shaderProgram, "uProcTextureType");
		/*
		procTextureTypeUniform = glContext.getUniformLocation(shaderProgram, "uProcTextureType");

		lightPositionUniform = glContext.getUniformLocation(shaderProgram, "uLightPosition");
		*/
		
	    // Check the link status
		boolean linked = glContext.getProgramParameterb(shaderProgram, WebGLRenderingContext.LINK_STATUS);
		if (!linked) {
			String infoLog = glContext.getProgramInfoLog(shaderProgram);
			GWT.log("Error linking program:\n" + infoLog, null);
			glContext.deleteProgram(shaderProgram);
			return;
		}
		
		ErrorHandler.checkErrors(glContext);
	}
	
	protected void initControls(Canvas webGLCanvas) {
		webGLCanvas.addMouseMoveHandler(camera);
		webGLCanvas.addMouseDownHandler(camera);
		webGLCanvas.addMouseUpHandler(camera);

		webGLCanvas.addKeyDownHandler(camera);
		webGLCanvas.addKeyUpHandler(camera);
	}

	protected void setAttribs() {
		vertexPositionAttribute = glContext.getAttribLocation(shaderProgram, "aVertexPosition");
		glContext.enableVertexAttribArray(vertexPositionAttribute);

		textureCoordAttribute = glContext.getAttribLocation(shaderProgram, "aTextureCoord");
		glContext.enableVertexAttribArray(textureCoordAttribute);

		normalAttribute = glContext.getAttribLocation(shaderProgram, "aNorm");
	    glContext.enableVertexAttribArray(normalAttribute);
	}

	///----------------------------------------------------------------------------------------------------------------
	///----------------------------------------------------------------------------------------------------------------
	///----------------------------------------------------------------------------------------------------------------

	public void init(Canvas webGLCanvas) {
		initShaders();
		initControls(webGLCanvas);

		// Set the clear depth (everything is cleared)
		glContext.clearDepth(1.0f);

		// Set the background color
		glContext.clearColor(0.2f, 0.2f, 0.2f, 1.0f);

		// Activate depth test and set the depth function
		glContext.enable(WebGLRenderingContext.DEPTH_TEST);
		glContext.depthFunc(WebGLRenderingContext.LEQUAL);

		//This needs to be done in this order.
		perspectiveMatrix = MatrixUtil.createPerspectiveMatrix(45, 1.0f, 0.1f, 100);
		translationMatrix = MatrixUtil.createTranslationMatrix(-camera.getXPos(), -camera.getYPos(), -camera.getZPos());
		rotationMatrix = MatrixUtil.createRotationMatrix(camera.getRotationXAxis(), camera.getRotationYAxis(), 0);
		resultingMatrix = perspectiveMatrix.multiply(rotationMatrix).multiply(translationMatrix);

		glContext.useProgram(shaderProgram);

		setAttribs();

		/*
		//Lighting stuff.
		int lighting = 0;
		lightingUniform = glContext.getUniformLocation(shaderProgram, "uLighting");
		glContext.uniform1i(lightingUniform, lighting);
		if (lighting != 0) {
			
			float ambientR = 0.1f;
			float ambientG = 0.1f;
			float ambientB = 0.1f;
			
			ambientColorUniform = glContext.getUniformLocation(shaderProgram, "uAmbientColor");
			
			glContext.uniform3f(
					ambientColorUniform,
					ambientR,
					ambientG,
					ambientB
					);
		}
		*/
	}
	
	public void update() {
		camera.update();
	}
	
	public void beginDraw() {
		glContext.clear(WebGLRenderingContext.COLOR_BUFFER_BIT | WebGLRenderingContext.DEPTH_BUFFER_BIT);
		
		translationMatrix = MatrixUtil.createTranslationMatrix(-camera.getXPos(), -camera.getYPos(), -camera.getZPos());
		rotationMatrix = MatrixUtil.createRotationMatrix(camera.getRotationXAxis(), camera.getRotationYAxis(), 0);
		resultingMatrix = perspectiveMatrix.multiply(rotationMatrix).multiply(translationMatrix);

		setCommonUniforms();
	}

	public void drawModel(Model model) {
		setUniforms(model);

		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, model.getVertexBuffer());
		glContext.vertexAttribPointer(vertexPositionAttribute, 3, WebGLRenderingContext.FLOAT, false, 0, 0);
		
		//Load the vertex texture data into buffer
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, model.getTexCoordBuffer());
		glContext.vertexAttribPointer(textureCoordAttribute, 2, WebGLRenderingContext.FLOAT, false, 0, 0);
		
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, model.getNormalBuffer());
		glContext.vertexAttribPointer(normalAttribute, 3, WebGLRenderingContext.FLOAT, false, 0, 0);
		
		glContext.drawArrays(WebGLRenderingContext.TRIANGLES, 0, model.getNTriangles());
	}
	
	public void endDraw() {
		glContext.flush();
	}
	


}
