package com.df3n5.gwtproc.client.demos.bumpmapping;

import com.google.gwt.core.client.GWT;
import com.googlecode.gwtgl.binding.WebGLRenderingContext;

public class ErrorHandler {
	
	/**
	 * Checks the WebGL Errors and throws an exception if there is an error.
	 */
	public static void checkErrors(WebGLRenderingContext glContext) {
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
}
