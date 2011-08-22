package com.df3n5.gwtproc.client.demos.bumpmapping;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;

public interface Resources extends ClientBundle {
	public static Resources INSTANCE = GWT.create(Resources.class);
	public static final String shader_proc_base_dir = "shaders/proc/"; 

	@Source(value = { shader_proc_base_dir + "checkered_proc.frag" })
	TextResource ceiling_proc_frag();
	@Source(value = { shader_proc_base_dir + "checkered_proc.vert" })
	TextResource ceiling_proc_vert();

	@Source(value = { shader_proc_base_dir + "checkered_proc.frag" })
	TextResource floor_proc_frag();
	@Source(value = { shader_proc_base_dir + "checkered_proc.vert" })
	TextResource floor_proc_vert();
	
	@Source(value = { shader_proc_base_dir + "concrete_proc.frag" })
	TextResource pillar_proc_frag();
	@Source(value = { shader_proc_base_dir + "concrete_proc.vert" })
	TextResource pillar_proc_vert();
	
	@Source(value = { shader_proc_base_dir + "perlinsky_proc.frag" })
	TextResource skybox_proc_frag();
	@Source(value = { shader_proc_base_dir + "perlinsky_proc.vert" })
	TextResource skybox_proc_vert();
	
	@Source(value = { shader_proc_base_dir + "perlinwall_proc.frag" })
	TextResource wall_proc_frag();
	@Source(value = { shader_proc_base_dir + "perlinwall_proc.vert" })
	TextResource wall_proc_vert();
	
	@Source(value = { shader_proc_base_dir + "perlinwall2_proc.frag" })
	TextResource wall2_proc_frag();
	@Source(value = { shader_proc_base_dir + "perlinwall2_proc.vert" })
	TextResource wall2_proc_vert();
}
