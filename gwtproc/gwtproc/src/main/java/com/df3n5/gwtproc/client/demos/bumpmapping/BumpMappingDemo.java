package com.df3n5.gwtproc.client.demos.bumpmapping;

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
	protected Model[] models;
	protected static final boolean isProc = false;

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
			drawer.drawModel(models[i], isProc);
		}
		drawer.endDraw();
	}
	
	@Override
	public void update() {
		drawer.update();
	}
	
}
