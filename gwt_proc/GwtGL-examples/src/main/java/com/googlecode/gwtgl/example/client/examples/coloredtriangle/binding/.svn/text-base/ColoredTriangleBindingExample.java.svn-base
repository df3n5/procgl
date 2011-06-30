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
package com.googlecode.gwtgl.example.client.examples.coloredtriangle.binding;

import static com.google.gwt.core.client.GWT.log;

import com.google.gwt.core.client.GWT;
import com.googlecode.gwtgl.array.Float32Array;
import com.googlecode.gwtgl.array.Uint16Array;
import com.googlecode.gwtgl.binding.WebGLBuffer;
import com.googlecode.gwtgl.binding.WebGLProgram;
import com.googlecode.gwtgl.binding.WebGLRenderingContext;
import com.googlecode.gwtgl.binding.WebGLShader;
import com.googlecode.gwtgl.binding.WebGLUniformLocation;
import com.googlecode.gwtgl.example.client.AbstractGwtGLExample;
import com.googlecode.gwtgl.example.client.util.math.FloatMatrix4x4;
import com.googlecode.gwtgl.example.client.util.math.MatrixUtil;

/**
 * Example that shows a colored triangle created with the GwtGL binding.
 * 
 * @author Sönke Sothmann
 * 
 */
public class ColoredTriangleBindingExample extends AbstractGwtGLExample {

	private WebGLProgram shaderProgram;
	private int vertexPositionAttribute;
	private int vertexColorAttribute;
	private FloatMatrix4x4 projectionMatrix;
	private WebGLBuffer vertexBuffer;
	private WebGLBuffer indexBuffer;
	private WebGLBuffer colorBuffer;
	private WebGLUniformLocation projectionMatrixUniform;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.gwtgl.example.client.AbstractGwtGLExample#init()
	 */
	@Override
	protected void init() {
		createShaderProgram();
		initParams();
		initBuffers();
		initProjectionMatrix();
		draw();
	}

	/**
	 * initializes the projection matrix used in this example.
	 */
	private void initProjectionMatrix() {
		projectionMatrix = MatrixUtil.createPerspectiveMatrix(45, 1.0f, 0.1f, 100);
	}

	/**
	 * Initialized the params of WebGL.
	 */
	private void initParams() {
		glContext.viewport(0, 0, webGLCanvas.getOffsetWidth(), webGLCanvas.getOffsetHeight());
		
		// Set the background color
		glContext.clearColor(0.0f, 0.0f, 0.0f, 1.0f);
		// Set the clear depth (everything is cleared)
		glContext.clearDepth(1.0f);

		// Activate depth test and set the depth function
		glContext.enable(WebGLRenderingContext.DEPTH_TEST);
		glContext.depthFunc(WebGLRenderingContext.LEQUAL);
		
		checkErrors();
	}

	/**
	 * Initializes the buffer containing the vertex and color coordinates.
	 */
	private void initBuffers() {
		// create the vertexBuffer
		// One Triangle with 3 Points à 3 coordinates
		vertexBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexBuffer);
		float[] vertices = new float[] { 
				0.0f, 1.0f, -5.0f, // x y z des ersten Dreieckpunktes
				-1.0f, -1.0f, -5.0f, // x y z des zweiten Dreieckpunktes
				1.0f, -1.0f, -5.0f // x y z des dritten Dreieckpunktes
		};
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER,
				Float32Array.create(vertices),
				WebGLRenderingContext.STATIC_DRAW);
		
		// create the colorBuffer
		colorBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, colorBuffer);
		float[] colors = new float[] { 
				1.0f, 0.0f, 0.0f, 1.0f,
				0.0f, 1.0f, 0.0f, 1.0f,
				0.0f, 0.0f, 1.0f, 1.0f };
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER,
				Float32Array.create(colors),
				WebGLRenderingContext.STATIC_DRAW);
		
		// create the indexBuffer
		indexBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ELEMENT_ARRAY_BUFFER, indexBuffer);
		int[] indices = new int[] {0, 1, 2};
		glContext.bufferData(WebGLRenderingContext.ELEMENT_ARRAY_BUFFER,
				Uint16Array.create(indices),
				WebGLRenderingContext.STATIC_DRAW);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.gwtgl.example.client.AbstractGwtGLExample#draw()
	 */
	@Override
	protected void draw() {
		// Clear the color buffer and the depth buffer
		glContext.clear(WebGLRenderingContext.COLOR_BUFFER_BIT | WebGLRenderingContext.DEPTH_BUFFER_BIT);

		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexBuffer);
		glContext.vertexAttribPointer(vertexPositionAttribute, 3, WebGLRenderingContext.FLOAT, false, 0, 0);
		glContext.enableVertexAttribArray(vertexPositionAttribute);

		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, colorBuffer);
		glContext.vertexAttribPointer(vertexColorAttribute, 4, WebGLRenderingContext.FLOAT, false, 0, 0);
		glContext.enableVertexAttribArray(vertexColorAttribute);
		
		glContext.bindBuffer(WebGLRenderingContext.ELEMENT_ARRAY_BUFFER, indexBuffer);

		// Bind the projection matrix to the shader
		glContext.uniformMatrix4fv(projectionMatrixUniform, false, projectionMatrix.getColumnWiseFlatData());

		// Draw the polygon
		glContext.drawElements(WebGLRenderingContext.TRIANGLES, 3, WebGLRenderingContext.UNSIGNED_SHORT, 0);
//		glContext.drawArrays(WebGLRenderingContext.TRIANGLES, 0, 3);
		glContext.flush();
		checkErrors();
	}

	/**
	 * Creates the ShaderProgram used by the example to render.
	 */
	private void createShaderProgram() {
		// Create the Shaders
		WebGLShader fragmentShader = getShader(WebGLRenderingContext.FRAGMENT_SHADER, Shaders.INSTANCE.fragmentShader().getText());
		log("Created fragment shader");
		
		WebGLShader vertexShader = getShader(WebGLRenderingContext.VERTEX_SHADER, Shaders.INSTANCE.vertexShader().getText());
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
		vertexColorAttribute = glContext.getAttribLocation(shaderProgram, "vertexColor");
		
		// get the position of the projectionMatrix uniform.
		projectionMatrixUniform = glContext.getUniformLocation(shaderProgram, "projectionMatrix");
		
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

		// check if the Shader is successfully compiled
		if (!glContext.getShaderParameterb(shader,
				WebGLRenderingContext.COMPILE_STATUS)) {
			throw new RuntimeException(glContext.getShaderInfoLog(shader));
		}

		return shader;
	}
}
