package com.df3n5.gwtproc.client.demos.bumpmapping;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.Date;

import com.df3n5.gwtproc.client.AbstractGwtProcDemo;
import com.df3n5.gwtproc.client.demos.bumpmapping.drawing.ModelDrawer;
import com.df3n5.gwtproc.client.demos.bumpmapping.loading.file.TextModelLoader;
import com.df3n5.gwtproc.client.demos.bumpmapping.loading.proc.ProceduralModelLoader;
import com.df3n5.gwtproc.client.demos.bumpmapping.model.Model;
import com.df3n5.gwtproc.client.demos.bumpmapping.loading.AbstractModelLoader;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

public class BumpMappingDemo extends AbstractGwtProcDemo {
	
	protected AbstractModelLoader loader;
	protected ModelDrawer drawer;
	protected ArrayList<Model> models;
	protected static final boolean isProc = false;

    Logger perfLogger = Logger.getLogger("WebGLPerfDemo Logger");
	
	public static BumpMappingDemo INSTANCE;
	
	private Date currentTime = new Date();;
	private Date lastTime;

	public BumpMappingDemo() {
		super();
		getFlexCellFormatter().setColSpan(2, 0, 2);

		// Show a description of the controls
		HTML exampleDescription = new HTML(
				"<h2>Main Demo</p>");
		VerticalPanel descriptionAndControls = new VerticalPanel();
		descriptionAndControls.add(exampleDescription);
		setWidget(1, 1, descriptionAndControls);
		
		if(!isProc){
			loader = new TextModelLoader(glContext);
		} else {
			loader = new ProceduralModelLoader(glContext);
		}
		drawer = new ModelDrawer(glContext);

		INSTANCE = this;
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
		Date beforeInit = new Date();
		
		models = loader.getModels();
		
		if(! isProc) {
			TextureLoader textureLoader = new TextureLoader();
			textureLoader.initTextures(glContext);
		}
		
		drawer.init(webGLCanvas);
		Date afterInit = new Date();
		perfLogger.log(Level.INFO, Long.toString(afterInit.getTime() - beforeInit.getTime()));
	}
	
	@Override
	protected void draw() {
		lastTime = currentTime;
		currentTime = new Date();
		//System.out.println((currentTime.getTime() - lastTime.getTime()));
		perfLogger.log(Level.INFO, Long.toString(currentTime.getTime() - lastTime.getTime()));
		
		drawer.beginDraw();
		for(Model model : models) {
			drawer.drawModel(model, isProc);
		}
		drawer.endDraw();
	}
	
	@Override
	public void update() {
		drawer.update();
	}
	
	public void removeCeiling() {
		int i = 0;
		for(Model model : models) {
			if(model.getType() == Model.CEILING_TYPE){
				models.remove(i);
				return;
			}
			i++;
		}
	}
	
}
