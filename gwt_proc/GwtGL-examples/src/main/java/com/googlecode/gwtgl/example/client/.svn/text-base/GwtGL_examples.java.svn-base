package com.googlecode.gwtgl.example.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.googlecode.gwtgl.example.client.examples.coloredtriangle.binding.ColoredTriangleBindingExample;
import com.googlecode.gwtgl.example.client.examples.skybox.SkyboxExample;
import com.googlecode.gwtgl.example.client.examples.texturedcube.binding.TexturedCubeBindingExample;
import com.googlecode.gwtgl.example.client.examples.whitetriangle.WhiteTriangleExample;

/**
 * @author Steffen Schäfer
 * @author Sönke Sothmann
 * 
 */
public class GwtGL_examples implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		TabPanel tp = new TabPanel();

		WhiteTriangleExample whiteTriangleExample = new WhiteTriangleExample();
		tp.add(whiteTriangleExample, "White Triangle");
		
		ColoredTriangleBindingExample coloredTriangleBindingExample = new ColoredTriangleBindingExample();
		tp.add(coloredTriangleBindingExample, "Colored Triangle");
		
		TexturedCubeBindingExample texturedCubeBindingExample = new TexturedCubeBindingExample();
		tp.add(texturedCubeBindingExample, "Textured Cube");

		SkyboxExample skyboxExample  = new SkyboxExample();
		tp.add(skyboxExample, "Skybox");
		
		tp.selectTab(3);
		RootPanel.get("gwtgl-examples").add(tp);
	}
}
