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

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;

/**
 * @author Steffen Schäfer
 * 
 */
public interface Resources extends ClientBundle {

	/** The instance of the Resources ClientBundle. */
	public static Resources INSTANCE = GWT.create(Resources.class);

	/**
	 * The fragment shader to use in the example.
	 * 
	 * @return the source of the fragment shader.
	 */
	@Source(value = { "fragment-shader.txt" })
	TextResource fragmentShader();

	/**
	 * The vertex shader to use in the example.
	 * 
	 * @return the source of the vertex shader.
	 */
	@Source(value = { "vertex-shader.txt" })
	TextResource vertexShader();

	/**
	 * The texture to use in the example.
	 * 
	 * @return the image to use as texture.
	 */
	@Source(value = { "texture.png" })
	ImageResource texture();

}
