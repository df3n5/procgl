package com.df3n5.gwtproc.client.demos.bumpmapping.model;

import com.df3n5.gwtproc.client.demos.bumpmapping.Camera;
import com.df3n5.gwtproc.client.demos.bumpmapping.ErrorHandler;
import com.df3n5.gwtproc.client.demos.bumpmapping.Resources;
import com.df3n5.gwtproc.client.demos.bumpmapping.model.Model;
import com.df3n5.gwtproc.client.util.math.FloatMatrix;
import com.google.gwt.core.client.GWT;
import com.googlecode.gwtgl.binding.WebGLBuffer;
import com.googlecode.gwtgl.binding.WebGLProgram;
import com.googlecode.gwtgl.binding.WebGLRenderingContext;
import com.googlecode.gwtgl.binding.WebGLShader;
import com.googlecode.gwtgl.binding.WebGLUniformLocation;

public class Model {
	protected int nTriangles;
	protected WebGLBuffer vertexBuffer;
	protected WebGLBuffer texCoordBuffer;
	protected WebGLBuffer normalBuffer;
	protected int type;
	protected WebGLProgram shaderProgram;
	
	public final static int WALL_TYPE = 0;
	public final static int FLOOR_TYPE = 1;
	public final static int CEILING_TYPE = 2;
	public final static int PILLAR_TYPE = 3;
	public final static int SKYBOX_TYPE = 4;
	public final static int WALL2_TYPE = 5;
	
	public Model() {
		shaderProgram = null;
	}
	
	public void setType(int type) { 
		this.type = type;
	}
	
	public int getType() { 
		return type;
	}
	
	public void setNTriangles(int nTriangles) {
		this.nTriangles = nTriangles;
	}
	
	public int getNTriangles() {
		return nTriangles;
	}
	
	public void setVertexBuffer(WebGLBuffer vertexBuffer) {
		this.vertexBuffer = vertexBuffer;
	}
	
	public void setTexCoordBuffer(WebGLBuffer texCoordBuffer) {
		this.texCoordBuffer = texCoordBuffer;
	}
	
	public WebGLBuffer getVertexBuffer() {
		return vertexBuffer;
	}
	
	public WebGLBuffer getNormalBuffer() {
		return normalBuffer;
	}

	public WebGLBuffer getTexCoordBuffer() {
		return texCoordBuffer;
	}

	public void setNormalBuffer(WebGLBuffer normalBuffer) {
		this.normalBuffer = normalBuffer;
	}
	
	public String getFragShader(boolean isProc) {
		if(isProc) {
			switch(this.type) {
				case Model.CEILING_TYPE:
					return Resources.INSTANCE.ceiling_proc_frag().getText();
				case Model.FLOOR_TYPE:
					return Resources.INSTANCE.floor_proc_frag().getText();
				case Model.PILLAR_TYPE:
					return Resources.INSTANCE.pillar_proc_frag().getText();
				case Model.SKYBOX_TYPE:
					return Resources.INSTANCE.skybox_proc_frag().getText();
				case Model.WALL_TYPE:
					return Resources.INSTANCE.wall_proc_frag().getText();
				case Model.WALL2_TYPE:
					return Resources.INSTANCE.wall2_proc_frag().getText();
				default:
					return "NULL";
			}
		}else{
			switch(this.type) {
				case Model.CEILING_TYPE:
					return Resources.INSTANCE.ceiling_file_frag().getText();
				case Model.FLOOR_TYPE:
					return Resources.INSTANCE.floor_file_frag().getText();
				case Model.PILLAR_TYPE:
					return Resources.INSTANCE.pillar_file_frag().getText();
				case Model.SKYBOX_TYPE:
					return Resources.INSTANCE.skybox_file_frag().getText();
				case Model.WALL_TYPE:
					return Resources.INSTANCE.wall_file_frag().getText();
				case Model.WALL2_TYPE:
					return Resources.INSTANCE.wall2_file_frag().getText();
				default:
					return "NULL";
			}
		}
	}

	public String getVertShader(boolean isProc) {
		if(isProc) {
			switch(this.type) {
				case Model.CEILING_TYPE:
					return Resources.INSTANCE.ceiling_proc_vert().getText();
				case Model.FLOOR_TYPE:
					return Resources.INSTANCE.floor_proc_vert().getText();
				case Model.PILLAR_TYPE:
					return Resources.INSTANCE.pillar_proc_vert().getText();
				case Model.SKYBOX_TYPE:
					return Resources.INSTANCE.skybox_proc_vert().getText();
				case Model.WALL_TYPE:
					return Resources.INSTANCE.wall_proc_vert().getText();
				case Model.WALL2_TYPE:
					return Resources.INSTANCE.wall2_proc_vert().getText();
				default:
					return "NULL";
			}
		}else{
			switch(this.type) {
				case Model.CEILING_TYPE:
					return Resources.INSTANCE.ceiling_file_vert().getText();
				case Model.FLOOR_TYPE:
					return Resources.INSTANCE.floor_file_vert().getText();
				case Model.PILLAR_TYPE:
					return Resources.INSTANCE.pillar_file_vert().getText();
				case Model.SKYBOX_TYPE:
					return Resources.INSTANCE.skybox_file_vert().getText();
				case Model.WALL_TYPE:
					return Resources.INSTANCE.wall_file_vert().getText();
				case Model.WALL2_TYPE:
					return Resources.INSTANCE.wall2_file_vert().getText();
				default:
					return "NULL";
			}
		}
	}
	
	public void setCommonUniforms(WebGLRenderingContext glContext, 
			Camera camera,
			FloatMatrix perspectiveMatrix,
			FloatMatrix resultingMatrix,
			boolean isProc) {
		WebGLUniformLocation mvUniform = glContext.getUniformLocation(
				getShaderProgram(glContext, isProc), "uMVMatrix");
		glContext.uniformMatrix4fv(mvUniform, false, resultingMatrix.getColumnWiseFlatData());
		
		WebGLUniformLocation projectionUniform = glContext.getUniformLocation(shaderProgram, "uPMatrix");
		glContext.uniformMatrix4fv(projectionUniform, false, perspectiveMatrix.getColumnWiseFlatData());
		
		WebGLUniformLocation lightPositionUniform = glContext.getUniformLocation(shaderProgram, "uLightPosition");
		glContext.uniform3f(lightPositionUniform, camera.getX(), camera.getY(), camera.getZ());
	}
	
	/**
	 * Sets per-model specific uniforms.
	 * @param glContext
	 */
	public void setUniforms(WebGLRenderingContext glContext, boolean isProc) {
		if(isProc) {
			switch(type) {
				case Model.WALL_TYPE:
					break;
				case Model.FLOOR_TYPE:
					break;
				case Model.CEILING_TYPE:
					break;
				case Model.PILLAR_TYPE:
					break;
				case Model.SKYBOX_TYPE:
					break;
			}
		}else{
			switch(type) {
				case Model.WALL_TYPE:
					break;
				case Model.FLOOR_TYPE:
					break;
				case Model.CEILING_TYPE:
					break;
				case Model.PILLAR_TYPE:
					break;
				case Model.SKYBOX_TYPE:
					break;
		}
		}
	}
	
	public void setCommonAttribs(WebGLRenderingContext glContext, boolean isProc) {
		int vertexPositionAttribute = glContext.getAttribLocation(
				getShaderProgram(glContext, isProc), "aVertexPosition");
		glContext.enableVertexAttribArray(vertexPositionAttribute);

		
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, getVertexBuffer());
		glContext.vertexAttribPointer(vertexPositionAttribute, 3, WebGLRenderingContext.FLOAT, false, 0, 0);
		
		int textureCoordAttribute = glContext.getAttribLocation(
				getShaderProgram(glContext, isProc), "aTextureCoord");
		glContext.enableVertexAttribArray(textureCoordAttribute);
		
		//Load the vertex texture data into buffer
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, getTexCoordBuffer());
		glContext.vertexAttribPointer(textureCoordAttribute, 2, WebGLRenderingContext.FLOAT, false, 0, 0);
	}
	
	/**
	 * Set attributes on a per model basis
	 */
	public void setAttribs(WebGLRenderingContext glContext, boolean isProc) {
		if(isProc) {
		    switch(type) {
			    case Model.WALL_TYPE:
			    	break;
			    case Model.FLOOR_TYPE:
			    	break;
			    case Model.CEILING_TYPE:
			    	break;
			    case Model.PILLAR_TYPE:
			    	int normalAttribute = glContext.getAttribLocation(
			    			getShaderProgram(glContext, isProc), "aNormal");
			    	glContext.enableVertexAttribArray(normalAttribute);
					glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, getNormalBuffer());
					glContext.vertexAttribPointer(normalAttribute, 3, WebGLRenderingContext.FLOAT, false, 0, 0);
			    	break;
			    case Model.SKYBOX_TYPE:
			    	break;
			    default:
			    	break;
		    }
		}else{
		    switch(type) {
			    case Model.WALL_TYPE:
			    	break;
			    case Model.FLOOR_TYPE:
			    	break;
			    case Model.CEILING_TYPE:
			    	break;
			    case Model.PILLAR_TYPE:
			    	int normalAttribute = glContext.getAttribLocation(
			    			getShaderProgram(glContext, isProc), "aNormal");
			    	glContext.enableVertexAttribArray(normalAttribute);
					glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, getNormalBuffer());
					glContext.vertexAttribPointer(normalAttribute, 3, WebGLRenderingContext.FLOAT, false, 0, 0);
			    	break;
			    case Model.SKYBOX_TYPE:
			    	break;
			    default:
			    	break;
		    }
		}
	}
	
	public WebGLProgram getShaderProgram(WebGLRenderingContext glContext, boolean isProc) {
		if(shaderProgram != null) {
			return shaderProgram;
		} else {
			//Compile and link shader, then return.
			WebGLShader fragmentShader = null;
			WebGLShader vertexShader = null;
			try{
				vertexShader = getShader(glContext,
						WebGLRenderingContext.VERTEX_SHADER,
						getVertShader(isProc));
			}catch(RuntimeException e) {
				System.err.println("Error trying to compile vertex shader for modeltype <" + Integer.toString(type) +"> :");
				System.err.println(e.toString());
			}
			try{
				fragmentShader = getShader(glContext,
						WebGLRenderingContext.FRAGMENT_SHADER,
						getFragShader(isProc));
			}catch(RuntimeException e) {
				System.err.println("Error trying to compile fragment shader for modeltype <" + Integer.toString(type) +"> :");
				System.err.println(e.toString());
			}

			shaderProgram = glContext.createProgram();
			glContext.attachShader(shaderProgram, vertexShader);
			glContext.attachShader(shaderProgram, fragmentShader);
			
			glContext.linkProgram(shaderProgram);
			
		    // Check the link status
			boolean linked = glContext.getProgramParameterb(shaderProgram, WebGLRenderingContext.LINK_STATUS);
			if (!linked) {
				String infoLog = glContext.getProgramInfoLog(shaderProgram);
				GWT.log("Error linking program:\n" + infoLog, null);
				glContext.deleteProgram(shaderProgram);
				return null;
			}
			
			ErrorHandler.checkErrors(glContext);
			return shaderProgram;
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
	protected WebGLShader getShader(WebGLRenderingContext glContext, int shaderType, String source) {
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