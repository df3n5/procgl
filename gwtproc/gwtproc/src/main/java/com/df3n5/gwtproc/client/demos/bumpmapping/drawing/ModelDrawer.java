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
	/*
	private WebGLProgram[] shaderPrograms;
	
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
	*/

//	private WebGLUniformLocation uTexSamp;
	
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
		
	protected void initControls(Canvas webGLCanvas) {
		webGLCanvas.addMouseMoveHandler(camera);
		webGLCanvas.addMouseDownHandler(camera);
		webGLCanvas.addMouseUpHandler(camera);

		webGLCanvas.addKeyDownHandler(camera);
		webGLCanvas.addKeyUpHandler(camera);
	}

	///----------------------------------------------------------------------------------------------------------------
	///----------------------------------------------------------------------------------------------------------------
	///----------------------------------------------------------------------------------------------------------------

	public void init(Canvas webGLCanvas) {
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
		translationMatrix = MatrixUtil.createTranslationMatrix(-camera.getX(), -camera.getY(), -camera.getZ());
		rotationMatrix = MatrixUtil.createRotationMatrix(camera.getRotationXAxis(), camera.getRotationYAxis(), 0);
		resultingMatrix = perspectiveMatrix.multiply(rotationMatrix).multiply(translationMatrix);

		//setAttribs();

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
		
		translationMatrix = MatrixUtil.createTranslationMatrix(-camera.getX(), -camera.getY(), -camera.getZ());
		rotationMatrix = MatrixUtil.createRotationMatrix(camera.getRotationXAxis(), camera.getRotationYAxis(), 0);
		resultingMatrix = perspectiveMatrix.multiply(rotationMatrix).multiply(translationMatrix);
	}

	public void drawModel(Model model, boolean isProc) {
		glContext.useProgram(model.getShaderProgram(glContext, isProc));
		model.setCommonUniforms(glContext,
				camera,
				perspectiveMatrix,
				resultingMatrix,
				isProc);
		model.setUniforms(glContext, isProc);
		model.setCommonAttribs(glContext, isProc);
		model.setAttribs(glContext, isProc);

		glContext.drawArrays(WebGLRenderingContext.TRIANGLES, 0, model.getNTriangles());
	}
	
	public void endDraw() {
		glContext.flush();
	}
}
