package com.df3n5.gwtproc.client.demos.webglperf;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;

public interface Resources extends ClientBundle {

	public static Resources INSTANCE = GWT.create(Resources.class);

	@Source(value = { "fragment-shader.txt" })
	TextResource fragmentShader();

	@Source(value = { "vertex-shader.txt" })
	TextResource vertexShader();

	@Source(value = { "texture.png" })
	ImageResource texture();
}
