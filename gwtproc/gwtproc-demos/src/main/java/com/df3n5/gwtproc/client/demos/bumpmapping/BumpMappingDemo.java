package com.df3n5.gwtproc.client.demos.bumpmapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.df3n5.gwtproc.client.AbstractGwtProcDemo;
import com.df3n5.gwtproc.client.demos.bumpmapping.drawing.ModelDrawer;
import com.df3n5.gwtproc.client.demos.bumpmapping.loading.AbstractModelLoader;
import com.df3n5.gwtproc.client.demos.bumpmapping.loading.TextModelLoader;
import com.df3n5.gwtproc.client.demos.bumpmapping.model.Model;
import com.df3n5.gwtproc.client.util.MatrixWidget;
import com.df3n5.gwtproc.client.util.math.FloatMatrix;
import com.df3n5.gwtproc.client.util.math.MatrixUtil;
import com.df3n5.gwtproc.client.util.mesh.CubeFactory;
import com.df3n5.gwtproc.client.util.mesh.Mesh;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.logging.client.HtmlLogFormatter;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
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


/**
 * Main Procedural generation demo
 * 
 * @author Jonathan Frawley
 * 
 */
public class BumpMappingDemo extends AbstractGwtProcDemo {
	
	protected AbstractModelLoader loader;
	protected ModelDrawer drawer;
	protected Model[] models;

	/**
	 * Constructs an instance of the SkyboxWrapperExample.
	 */
	public BumpMappingDemo() {
		super();
		getFlexCellFormatter().setColSpan(2, 0, 2);

		// Show a description of the controls
		HTML exampleDescription = new HTML(
				"<h2>Main Demo</p>");
		VerticalPanel descriptionAndControls = new VerticalPanel();
		descriptionAndControls.add(exampleDescription);
		setWidget(1, 1, descriptionAndControls);
		
		loader = new TextModelLoader(glContext);
		drawer = new ModelDrawer(glContext);

		//Start
		/*
		super.start();
		webGLCanvas.setFocus(true);
		*/
		//Endstart
	}

	private long getTimeStampMilli() {
        Date date = new Date();
        return date.getTime();
	}

	
	@Override
	protected void init() {
		models = loader.getModels();
		drawer.init(webGLCanvas);
	}
	
	@Override
	protected void draw() {
		drawer.beginDraw();
		for(int i = 0 ; i < models.length ; i++) {
			drawer.drawModel(models[i]);
		}
		drawer.endDraw();
	}
	
	@Override
	public void update() {
		drawer.update();
	}
	
}
