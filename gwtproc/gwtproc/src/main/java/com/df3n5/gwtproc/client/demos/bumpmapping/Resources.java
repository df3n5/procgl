package com.df3n5.gwtproc.client.demos.bumpmapping;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;

public interface Resources extends ClientBundle {
	public static Resources INSTANCE = GWT.create(Resources.class);
	public static final String asset_base_dir = "assets/"; 
	public static final String shader_proc_base_dir = "shaders/proc/"; 
	public static final String shader_file_base_dir = "shaders/file/"; 

	//-------------------------------------------------------
	//BEGIN proc shaders
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
	//-------------------------------------------------------
	//END proc shaders
	
	//-------------------------------------------------------
	//BEGIN file shaders
	@Source(value = { shader_file_base_dir + "checkered_file.frag" })
	TextResource ceiling_file_frag();
	@Source(value = { shader_file_base_dir + "checkered_file.vert" })
	TextResource ceiling_file_vert();

	@Source(value = { shader_file_base_dir + "checkered_file.frag" })
	TextResource floor_file_frag();
	@Source(value = { shader_file_base_dir + "checkered_file.vert" })
	TextResource floor_file_vert();
	
	@Source(value = { shader_file_base_dir + "concrete_file.frag" })
	TextResource pillar_file_frag();
	@Source(value = { shader_file_base_dir + "concrete_file.vert" })
	TextResource pillar_file_vert();
	
	@Source(value = { shader_file_base_dir + "perlinsky_file.frag" })
	TextResource skybox_file_frag();
	@Source(value = { shader_file_base_dir + "perlinsky_file.vert" })
	TextResource skybox_file_vert();
	
	@Source(value = { shader_file_base_dir + "perlinwall_file.frag" })
	TextResource wall_file_frag();
	@Source(value = { shader_file_base_dir + "perlinwall_file.vert" })
	TextResource wall_file_vert();
	
	@Source(value = { shader_file_base_dir + "perlinwall2_file.frag" })
	TextResource wall2_file_frag();
	@Source(value = { shader_file_base_dir + "perlinwall2_file.vert" })
	TextResource wall2_file_vert();
	//-------------------------------------------------------
	//END file shaders
	
	//-------------------------------------------------------
	//BEGIN assets
	@Source(value = { asset_base_dir + "walls.txt" })
	TextResource walls();
	
	@Source(value = { asset_base_dir + "walls2.txt" })
	TextResource walls2();
	
	@Source(value = { asset_base_dir + "ceiling.txt" })
	TextResource ceiling();
	
	@Source(value = { asset_base_dir + "floor.txt" })
	TextResource floor();
	
	@Source(value = { asset_base_dir + "pillars.txt" })
	TextResource pillars();

	@Source(value = { asset_base_dir + "skybox_water_ft.png" })
	ImageResource textureSkyboxFt();

	@Source(value = { asset_base_dir + "skybox_water_lf.png" })
	ImageResource textureSkyboxLf();
	
	@Source(value = { asset_base_dir + "skybox_water_up.png" })
	ImageResource textureSkyboxUp();
	
	@Source(value = { asset_base_dir + "skybox_water_bk.png" })
	ImageResource textureSkyboxBk();
	
	@Source(value = { asset_base_dir + "skybox_water_rt.png" })
	ImageResource textureSkyboxRt();
	
	@Source(value = { asset_base_dir + "skybox_water_dn.png" })
	ImageResource textureSkyboxDn();
	
	@Source(value = { asset_base_dir + "mudTexture.gif" })
	ImageResource mudTexture();
	
	@Source(value = { asset_base_dir + "wallTexture.jpg" })
	ImageResource wallTexture();
	//-------------------------------------------------------
	//END assets
}
