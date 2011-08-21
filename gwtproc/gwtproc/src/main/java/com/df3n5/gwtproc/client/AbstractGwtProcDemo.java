package com.df3n5.gwtproc.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.PushButton;
import com.googlecode.gwtgl.binding.WebGLRenderingContext;

public abstract class AbstractGwtProcDemo extends FlexTable {

	/** The Canvas to render on. */
	protected final Canvas webGLCanvas;
	/** The Canvas' 3D rendering context. */
	protected final WebGLRenderingContext glContext;

	/**
	 * Constructs a new instance of a GwtGL example with a launch button and a
	 * Canvas to render on.
	 */
	protected AbstractGwtProcDemo() {
		final PushButton button = new PushButton("Launch");
		setWidget(0, 0, button);
		
		int width = 1024;
		int height = 800;
		// create the WebGL Canvas
		webGLCanvas = Canvas.createIfSupported();
		webGLCanvas.setCoordinateSpaceHeight(height);
		webGLCanvas.setCoordinateSpaceWidth(width);
		glContext = (WebGLRenderingContext) webGLCanvas.getContext("experimental-webgl");
		if(glContext == null) {
			Window.alert("Sorry, Your Browser doesn't support WebGL!");
		}
		//glContext.viewport(0, 0, height, width);
		glContext.viewport(0, 0, width, height);

		setWidget(1, 0, webGLCanvas);

		// add a ClickHandler to start the example when the button is clicked
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				button.setEnabled(false);
				start();
				webGLCanvas.setFocus(true);
			}
		});

	}

	/**
	 * Starts the execution of the example. First the example is initialized
	 * using {@link AbstractGwtProcDemo#init()}. After that the rendering loop
	 * is executed with 50 fps. Each frame is rendered using
	 * {@link AbstractGwtProcDemo#draw()}.
	 */
	protected void start() {
		init();

		Timer timer = new Timer() {
			@Override
			public void run() {
				update();
				draw();
			}
		};
//		timer.scheduleRepeating(20);
//		timer.scheduleRepeating(1);
		timer.scheduleRepeating(10);

	}

	/**
	 * Initializes the needed resources of the demo.
	 */
	protected abstract void init();

	/**
	 * Updates the state of the game.
	 */
	protected abstract void update();
	
	/**
	 * Draws the demo.
	 */
	protected abstract void draw();

}
