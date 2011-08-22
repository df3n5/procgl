package com.df3n5.gwtproc.client;

import com.df3n5.gwtproc.client.demos.bumpmapping.BumpMappingDemo;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;

public class GwtProcDemos implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		TabPanel tp = new TabPanel();

		BumpMappingDemo bmDemo = new BumpMappingDemo();
		tp.add(bmDemo, "BumpMapping");
		
		tp.selectTab(0);
		RootPanel.get("gwtproc-demos").add(tp);
	}
}
