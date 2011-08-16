package com.df3n5.gwtproc.client.demos.main;

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
	
	@Source(value = { "walls.txt" })
	TextResource walls();
	
	@Source(value = { "ceiling.txt" })
	TextResource ceiling();
	
	@Source(value = { "floor.txt" })
	TextResource floor();
	
	@Source(value = { "pillars.txt" })
	TextResource pillars();
/*
	@Source(value = { "skybox_water_ft.png" })
	ImageResource textureSkyboxFt();

	@Source(value = { "skybox_water_lf.png" })
	ImageResource textureSkyboxLf();
	
	@Source(value = { "skybox_water_up.png" })
	ImageResource textureSkyboxUp();
	
	@Source(value = { "skybox_water_bk.png" })
	ImageResource textureSkyboxBk();
	
	@Source(value = { "skybox_water_rt.png" })
	ImageResource textureSkyboxRt();
	
	@Source(value = { "skybox_water_dn.png" })
	ImageResource textureSkyboxDn();
	*/
	
	@Source(value = { "texture.png" })
	ImageResource texture();
	
	@Source(value = { "mudTexture.gif" })
	ImageResource mudTexture();
	
	@Source(value = { "wallTexture.jpg" })
	ImageResource wallTexture();
}
