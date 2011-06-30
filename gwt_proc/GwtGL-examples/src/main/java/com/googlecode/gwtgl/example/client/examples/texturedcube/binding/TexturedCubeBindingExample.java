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
package com.googlecode.gwtgl.example.client.examples.texturedcube.binding;

import static com.google.gwt.core.client.GWT.log;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
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
 * Example that shows a rotating cube with a texture applied to all sides.
 * 
 * @author Sönke Sothmann
 * 
 */
public class TexturedCubeBindingExample extends AbstractGwtGLExample {

	private Mesh cube = CubeFactory.createNewInstance(1.0f);
	private MatrixWidget perspectiveMatrixWidget;
	private MatrixWidget translationMatrixWidget;
	private MatrixWidget rotationMatrixWidget;
	private MatrixWidget resultingMatrixWidget;

	private int angleX = 0;
	private int angleY = 0;
	private int angleZ = 0;
	private float translateZ = -2;
	private FloatMatrix perspectiveMatrix;
	private FloatMatrix translationMatrix;
	private FloatMatrix rotationMatrix;
	private FloatMatrix resultingMatrix;
	
	private WebGLProgram shaderProgram;
	private int vertexPositionAttribute;
	private int textureCoordAttribute;
	private WebGLBuffer vertexBuffer;
	private WebGLBuffer vertexTextureCoordBuffer;
	private WebGLUniformLocation projectionMatrixUniform;
	private WebGLUniformLocation textureUniform;
	private WebGLTexture texture;

	/**
	 * Constructs an instance of the TexturedCubeWrapperExample.
	 */
	public TexturedCubeBindingExample() {
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
				"<h2>Texture2D Binding Example</h2><h3>Controls</h3><p>PAGEGUP - Zoom in<br/>PAGEDOWN - Zoom out</p>");
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
		initShaders();
		initBuffers();
		initTexture();
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
		// Handle keyboard input
		webGLCanvas.addKeyDownHandler(new KeyDownHandler() {
			@Override
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
			GWT.log(message, null);
			throw new RuntimeException(message);
		}
	}

	/**
	 * Creates the ShaderProgram used by the example to render.
	 */
	private void initShaders() {
		// Create the Shaders
		WebGLShader fragmentShader = getShader(WebGLRenderingContext.FRAGMENT_SHADER, Resources.INSTANCE.fragmentShader().getText());
		log("Created fragment shader");
		
		WebGLShader vertexShader = getShader(WebGLRenderingContext.VERTEX_SHADER, Resources.INSTANCE.vertexShader().getText());
		log("Created vertex shader");
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
		
		textureCoordAttribute = glContext.getAttribLocation(shaderProgram, "texPosition");
	    glContext.enableVertexAttribArray(textureCoordAttribute);

		// get the position of the projectionMatrix uniform.
		projectionMatrixUniform = glContext.getUniformLocation(shaderProgram,
				"projectionMatrix");
		
		// get the position of the tex uniform.
		textureUniform = glContext.getUniformLocation(shaderProgram, "tex");
		
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

	/**
	 * Initializes the buffers for vertex coordinates, normals and texture
	 * coordinates.
	 */
	private void initBuffers() {
		vertexBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER,
				Float32Array.create(cube.getVertices()),
				WebGLRenderingContext.STATIC_DRAW);
		vertexTextureCoordBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexTextureCoordBuffer);
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER, Float32Array.create(cube.getTexCoords()), WebGLRenderingContext.STATIC_DRAW);
		checkErrors();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.gwtgl.example.client.AbstractGwtGLExample#draw()
	 */
	@Override
	protected void draw() {
		angleX = (angleX + 1) % 360;
		angleY = (angleY + 1) % 360;
		// angleZ=(angleZ+2)%360;

		glContext.clear(WebGLRenderingContext.COLOR_BUFFER_BIT | WebGLRenderingContext.DEPTH_BUFFER_BIT);

		glContext.vertexAttribPointer(vertexPositionAttribute, 3,
				WebGLRenderingContext.FLOAT, false, 0, 0);

		// Load the vertex data
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexBuffer);
		glContext.vertexAttribPointer(vertexPositionAttribute, 3, WebGLRenderingContext.FLOAT, false, 0, 0);
		
		// Load the texture coordinates data
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexTextureCoordBuffer);
		glContext.vertexAttribPointer(textureCoordAttribute, 2, WebGLRenderingContext.FLOAT, false, 0, 0);

		perspectiveMatrix = MatrixUtil.createPerspectiveMatrix(45, 1.0f, 0.1f, 100);
		translationMatrix = MatrixUtil.createTranslationMatrix(0, 0, translateZ);
		rotationMatrix = MatrixUtil.createRotationMatrix(angleX, angleY, angleZ);
		resultingMatrix = perspectiveMatrix.multiply(translationMatrix).multiply(rotationMatrix);

		glContext.uniformMatrix4fv(projectionMatrixUniform, false, resultingMatrix.getColumnWiseFlatData());
		
		// Bind the texture to texture unit 0
		glContext.activeTexture(WebGLRenderingContext.TEXTURE0);
		glContext.bindTexture(WebGLRenderingContext.TEXTURE_2D, texture);

		// Point the uniform sampler to texture unit 0
		glContext.uniform1i(textureUniform, 0);
		glContext.drawArrays(WebGLRenderingContext.TRIANGLES, 0, 36);
		glContext.flush();
		checkErrors();
	}

	/**
	 * Initializes the texture of this example.
	 */
	private void initTexture() {
		texture = glContext.createTexture();
		glContext.bindTexture(WebGLRenderingContext.TEXTURE_2D, texture);
		final Image img = getImage(Resources.INSTANCE.texture());
		img.addLoadHandler(new LoadHandler() {
			@Override
			public void onLoad(LoadEvent event) {
				RootPanel.get().remove(img);
				GWT.log("texture image loaded", null);
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

}
