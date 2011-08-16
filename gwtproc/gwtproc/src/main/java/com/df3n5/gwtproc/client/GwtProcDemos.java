package com.df3n5.gwtproc.client;

import com.df3n5.gwtproc.client.demos.main.MainDemo;
import com.df3n5.gwtproc.client.demos.bumpmapping.BumpMappingDemo;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;

/**
 * @author Steffen Schäfer
 * @author Sönke Sothmann
 * 
 */
public class GwtProcDemos implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		TabPanel tp = new TabPanel();
/*
		WhiteTriangleExample whiteTriangleExample = new WhiteTriangleExample();
		tp.add(whiteTriangleExample, "White Triangle");
		
		ColoredTriangleBindingExample coloredTriangleBindingExample = new ColoredTriangleBindingExample();
		tp.add(coloredTriangleBindingExample, "Colored Triangle");
		
		TexturedCubeBindingExample texturedCubeBindingExample = new TexturedCubeBindingExample();
		tp.add(texturedCubeBindingExample, "Textured Cube");
*/
		MainDemo mainDemo  = new MainDemo();
		tp.add(mainDemo, "Main");

		BumpMappingDemo bmDemo = new BumpMappingDemo();
		tp.add(bmDemo, "BumpMapping");
		
		tp.selectTab(1);
		RootPanel.get("gwtproc-demos").add(tp);
	}
}
