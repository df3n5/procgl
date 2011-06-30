/**   
 * Copyright 2009-2010 Sönke Sothmann, Steffen Schäfer and others
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.gwtgl.example.client.examples.skybox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Timer;
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
import com.googlecode.gwtgl.example.client.AbstractGwtGLExample;
import com.googlecode.gwtgl.example.client.util.MatrixWidget;
import com.googlecode.gwtgl.example.client.util.math.FloatMatrix;
import com.googlecode.gwtgl.example.client.util.math.MatrixUtil;
import com.googlecode.gwtgl.example.client.util.mesh.CubeFactory;
import com.googlecode.gwtgl.example.client.util.mesh.Mesh;

/**
 * Example that shows a skybox. User can look around using the mouse.
 * 
 * @author Steffen Schäfer
 * @author Sönke Sothmann
 * 
 */
public class SkyboxExample extends AbstractGwtGLExample {

	private Mesh cube = CubeFactory.createNewInstance(1.0f);
	private MatrixWidget perspectiveMatrixWidget;
	private MatrixWidget translationMatrixWidget;
	private MatrixWidget rotationMatrixWidget;
	private MatrixWidget resultingMatrixWidget;

	private WebGLTexture textureTop;
	private WebGLTexture textureBottom;
	private WebGLTexture textureFront;
	private WebGLTexture textureBack;
	private WebGLTexture textureLeft;
	private WebGLTexture textureRight;
	private WebGLUniformLocation textureUniform;
	private WebGLProgram shaderProgram;
	private WebGLBuffer buffer;

	private float translateZ = 0;
	private FloatMatrix perspectiveMatrix;
	private FloatMatrix translationMatrix;
	private FloatMatrix rotationMatrix;
	private FloatMatrix resultingMatrix;
	private Camera camera = new Camera();
	private int texCoordsOffset;
	private int vertexPositionAttribute;
	private int textureCoordAttribute;

	/**
	 * Constructs an instance of the SkyboxWrapperExample.
	 */
	public SkyboxExample() {
		// create an panel to show the matrices
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
		getFlexCellFormatter().setColSpan(2, 0, 2);

		// Show a description of the controls
		HTML exampleDescription = new HTML(
				"<h2>Skyox Wrapper Example</h2><h3>Controls</h3><p>Hold down left mouse button on the canvas and move the mouse to look around.</p>");
		VerticalPanel descriptionAndControls = new VerticalPanel();
		descriptionAndControls.add(exampleDescription);
		setWidget(1, 1, descriptionAndControls);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.gwtgl.example.client.AbstractGwtGLExample#init()
	 */
	@Override
	protected void init() {
		initParams();
		initTexture();
		initShaders();
		initBuffers();
		initControls();

		showMatrices();
	}

	/**
	 * Updates the Matrix widgets every 500ms
	 */
	private void showMatrices() {
		Timer timer = new Timer() {
			@Override
			public void run() {
				perspectiveMatrixWidget.setData(perspectiveMatrix);
				translationMatrixWidget.setData(translationMatrix);
				rotationMatrixWidget.setData(rotationMatrix);
				resultingMatrixWidget.setData(resultingMatrix);
			}
		};
		timer.scheduleRepeating(500);
	}

	/**
	 * Initializes the controls of the example.
	 */
	private void initControls() {
		webGLCanvas.addMouseMoveHandler(camera);
		
		webGLCanvas.addMouseDownHandler(camera);
		
		webGLCanvas.addMouseUpHandler(camera);
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
		
		vertexPositionAttribute = glContext.getAttribLocation(shaderProgram, "vertexPosition");
		glContext.enableVertexAttribArray(vertexPositionAttribute);
		
		textureCoordAttribute = glContext.getAttribLocation(shaderProgram, "texPosition");
	    glContext.enableVertexAttribArray(textureCoordAttribute);
		// Check the link status
		boolean linked = glContext.getProgramParameterb(shaderProgram, WebGLRenderingContext.LINK_STATUS);
		if (!linked) {
			String infoLog = glContext.getProgramInfoLog(shaderProgram);
			GWT.log("Error linking program:\n" + infoLog, null);
			glContext.deleteProgram(shaderProgram);
			return;
		}

		textureUniform = glContext.getUniformLocation(shaderProgram, "tex");

		checkErrors();
	}

	/**
	 * Initializes the buffers for vertex coordinates, normals and texture
	 * coordinates.
	 */
	private void initBuffers() {
		buffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, buffer);
		
		Float32Array vertices = Float32Array.create(cube.getVertices());
		texCoordsOffset = vertices.getByteLength();
		Float32Array texCoords = Float32Array.create(cube.getTexCoords());
		
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER,
				vertices.getByteLength() + texCoords.getByteLength(),
				WebGLRenderingContext.STATIC_DRAW);
		
		glContext
				.bufferSubData(WebGLRenderingContext.ARRAY_BUFFER, 0, vertices);
		glContext.bufferSubData(WebGLRenderingContext.ARRAY_BUFFER,
				texCoordsOffset, texCoords);
		
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

		// Load the vertex data
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, buffer);
		glContext.vertexAttribPointer(vertexPositionAttribute, 3, WebGLRenderingContext.FLOAT, false, 0, 0);

		glContext.vertexAttribPointer(textureCoordAttribute, 2, WebGLRenderingContext.FLOAT, false, 0, texCoordsOffset);
		WebGLUniformLocation mvUniform = glContext.getUniformLocation(shaderProgram, "projectionMatrix");

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
		
		checkErrors();
		glContext.flush();
		checkErrors();
	}

	/**
	 * Initializes the textures of this example.
	 */
	private void initTexture() {
		// Create and initialize the WebGLTexture objects.
		textureFront = createTexture(Resources.INSTANCE.textureSkyboxFt());
		textureBack = createTexture(Resources.INSTANCE.textureSkyboxBk());
		textureTop = createTexture(Resources.INSTANCE.textureSkyboxUp());
		textureBottom = createTexture(Resources.INSTANCE.textureSkyboxDn());
		textureLeft = createTexture(Resources.INSTANCE.textureSkyboxLf());
		textureRight = createTexture(Resources.INSTANCE.textureSkyboxRt());
		checkErrors();
	}

	private WebGLTexture createTexture(ImageResource imageResource) {
		final WebGLTexture texture = glContext.createTexture();
		
		final Image img = new Image();
		img.addLoadHandler(new LoadHandler() {
			@Override
			public void onLoad(LoadEvent event) {
				RootPanel.get().remove(img);
				
				glContext.activeTexture(WebGLRenderingContext.TEXTURE0);
				glContext.bindTexture(WebGLRenderingContext.TEXTURE_2D, texture);
				
				glContext.texParameteri(WebGLRenderingContext.TEXTURE_2D, WebGLRenderingContext.TEXTURE_MIN_FILTER, WebGLRenderingContext.NEAREST);
				glContext.texParameteri(WebGLRenderingContext.TEXTURE_2D, WebGLRenderingContext.TEXTURE_MAG_FILTER, WebGLRenderingContext.NEAREST);
				glContext.texParameteri(WebGLRenderingContext.TEXTURE_2D, WebGLRenderingContext.TEXTURE_WRAP_S, WebGLRenderingContext.CLAMP_TO_EDGE);
				glContext.texParameteri(WebGLRenderingContext.TEXTURE_2D, WebGLRenderingContext.TEXTURE_WRAP_T, WebGLRenderingContext.CLAMP_TO_EDGE);
				
				glContext.texImage2D(WebGLRenderingContext.TEXTURE_2D, 0, WebGLRenderingContext.RGBA,WebGLRenderingContext.RGBA, WebGLRenderingContext.UNSIGNED_BYTE, img.getElement());
				checkErrors();
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

}
