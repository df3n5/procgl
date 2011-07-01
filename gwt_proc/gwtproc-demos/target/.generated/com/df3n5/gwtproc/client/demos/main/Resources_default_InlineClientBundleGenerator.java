package com.df3n5.gwtproc.client.demos.main;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class Resources_default_InlineClientBundleGenerator implements com.df3n5.gwtproc.client.demos.main.Resources {
  public com.google.gwt.resources.client.TextResource fragmentShader() {
    return fragmentShader;
  }
  public com.google.gwt.resources.client.TextResource map() {
    return map;
  }
  public com.google.gwt.resources.client.TextResource vertexShader() {
    return vertexShader;
  }
  public com.google.gwt.resources.client.ImageResource mudTexture() {
    return mudTexture;
  }
  public com.google.gwt.resources.client.ImageResource texture() {
    return texture;
  }
  public com.google.gwt.resources.client.ImageResource textureSkyboxBk() {
    return textureSkyboxBk;
  }
  public com.google.gwt.resources.client.ImageResource textureSkyboxDn() {
    return textureSkyboxDn;
  }
  public com.google.gwt.resources.client.ImageResource textureSkyboxFt() {
    return textureSkyboxFt;
  }
  public com.google.gwt.resources.client.ImageResource textureSkyboxLf() {
    return textureSkyboxLf;
  }
  public com.google.gwt.resources.client.ImageResource textureSkyboxRt() {
    return textureSkyboxRt;
  }
  public com.google.gwt.resources.client.ImageResource textureSkyboxUp() {
    return textureSkyboxUp;
  }
  public com.google.gwt.resources.client.ImageResource wallTexture() {
    return wallTexture;
  }
  private void _init0() {
    fragmentShader = new com.google.gwt.resources.client.TextResource() {
    // file:/home/j0n/code/procgl/gwt_proc/GwtGL-examples/src/main/java/com/df3n5/gwtproc/client/demos/main/fragment-shader.txt
    public String getText() {
      return "/*\n#ifdef GL_ES\nprecision highp float;\n#endif\n\nuniform sampler2D tex;\nvarying vec2 texCoord;\nvoid main() {\n	gl_FragColor = texture2D(tex, texCoord);\n}\n*/\n/*\n\n//Newer\n#ifdef GL_ES\nprecision highp float;\n#endif\n\nvarying vec2 vTextureCoord;\n\nuniform sampler2D uSampler;\n\nvoid main(void) {\n    gl_FragColor = texture2D(uSampler, vec2(vTextureCoord.s, vTextureCoord.t));\n}\n*/\n\n//Procedurally generated checkboard texture.\n#ifdef GL_ES\nprecision highp float;\n#endif\n\n//TODO : Pass in as uniform\nfloat uFrequency = 2.0;\nvec4 uColor0 = vec4(0.0,0.0,0.0,1.0);\nvec4 uColor1 = vec4(1.0,1.0,1.0,1.0);\n\nvarying vec2 vTextureCoord;\n\nuniform sampler2D uSampler;\n\nvoid main(void) {\n	vec2 texCoord = mod(floor(vTextureCoord * float(uFrequency*2.0)), 2.0);\n	float delta = abs(texCoord.x - texCoord.y);\n	\n	gl_FragColor = mix(uColor1, uColor0, delta);\n}";
    }
    public String getName() {
      return "fragmentShader";
    }
  }
  ;
    map = new com.google.gwt.resources.client.TextResource() {
    // file:/home/j0n/code/procgl/gwt_proc/GwtGL-examples/src/main/java/com/df3n5/gwtproc/client/demos/main/map.txt
    public String getText() {
      return "0.0  1.0  0.0 0.0 6.0\n0.0  0.0  0.0  0.0 0.0\n7.0  0.0  0.0 6.0 0.0\n0.0  1.0  0.0 0.0 6.0\n7.0  1.0  0.0  6.0 6.0\n7.0  0.0  0.0 6.0 0.0\n0.0  1.0  0.0 0.0 6.0\n0.0  0.0  0.0  0.0 0.0\n0.0  0.0  7.0 6.0 0.0\n0.0  1.0  0.0 0.0 6.0\n0.0  1.0  7.0  6.0 6.0\n0.0  0.0  7.0 6.0 0.0\n7.0  1.0  0.0 0.0 6.0\n7.0  0.0  0.0  0.0 0.0\n7.0  0.0  7.0 6.0 0.0\n7.0  1.0  0.0 0.0 6.0\n7.0  1.0  7.0  6.0 6.0\n7.0  0.0  7.0 6.0 0.0\n0.0  1.0  7.0 0.0 6.0\n0.0  0.0  7.0  0.0 0.0\n7.0  0.0  7.0 6.0 0.0\n0.0  1.0  7.0 0.0 6.0\n7.0  1.0  7.0  6.0 6.0\n7.0  0.0  7.0 6.0 0.0\n0.0  1.0  14.0 0.0 6.0\n0.0  0.0  14.0  0.0 0.0\n7.0  0.0  14.0 6.0 0.0\n0.0  1.0  14.0 0.0 6.0\n7.0  1.0  14.0  6.0 6.0\n7.0  0.0  14.0 6.0 0.0\n0.0  1.0  14.0 0.0 6.0\n0.0  0.0  14.0  0.0 0.0\n0.0  0.0  21.0 6.0 0.0\n0.0  1.0  14.0 0.0 6.0\n0.0  1.0  21.0  6.0 6.0\n0.0  0.0  21.0 6.0 0.0\n7.0  1.0  14.0 0.0 6.0\n7.0  0.0  14.0  0.0 0.0\n7.0  0.0  21.0 6.0 0.0\n7.0  1.0  14.0 0.0 6.0\n7.0  1.0  21.0  6.0 6.0\n7.0  0.0  21.0 6.0 0.0\n0.0  1.0  21.0 0.0 6.0\n0.0  0.0  21.0  0.0 0.0\n7.0  0.0  21.0 6.0 0.0\n0.0  1.0  21.0 0.0 6.0\n7.0  1.0  21.0  6.0 6.0\n7.0  0.0  21.0 6.0 0.0\n0.0  1.0  28.0 0.0 6.0\n0.0  0.0  28.0  0.0 0.0\n7.0  0.0  28.0 6.0 0.0\n0.0  1.0  28.0 0.0 6.0\n7.0  1.0  28.0  6.0 6.0\n7.0  0.0  28.0 6.0 0.0\n0.0  1.0  28.0 0.0 6.0\n0.0  0.0  28.0  0.0 0.0\n0.0  0.0  35.0 6.0 0.0\n0.0  1.0  28.0 0.0 6.0\n0.0  1.0  35.0  6.0 6.0\n0.0  0.0  35.0 6.0 0.0\n7.0  1.0  28.0 0.0 6.0\n7.0  0.0  28.0  0.0 0.0\n7.0  0.0  35.0 6.0 0.0\n7.0  1.0  28.0 0.0 6.0\n7.0  1.0  35.0  6.0 6.0\n7.0  0.0  35.0 6.0 0.0\n0.0  1.0  35.0 0.0 6.0\n0.0  0.0  35.0  0.0 0.0\n7.0  0.0  35.0 6.0 0.0\n0.0  1.0  35.0 0.0 6.0\n7.0  1.0  35.0  6.0 6.0\n7.0  0.0  35.0 6.0 0.0\n0.0  1.0  42.0 0.0 6.0\n0.0  0.0  42.0  0.0 0.0\n7.0  0.0  42.0 6.0 0.0\n0.0  1.0  42.0 0.0 6.0\n7.0  1.0  42.0  6.0 6.0\n7.0  0.0  42.0 6.0 0.0\n0.0  1.0  42.0 0.0 6.0\n0.0  0.0  42.0  0.0 0.0\n0.0  0.0  49.0 6.0 0.0\n0.0  1.0  42.0 0.0 6.0\n0.0  1.0  49.0  6.0 6.0\n0.0  0.0  49.0 6.0 0.0\n7.0  1.0  42.0 0.0 6.0\n7.0  0.0  42.0  0.0 0.0\n7.0  0.0  49.0 6.0 0.0\n7.0  1.0  42.0 0.0 6.0\n7.0  1.0  49.0  6.0 6.0\n7.0  0.0  49.0 6.0 0.0\n0.0  1.0  49.0 0.0 6.0\n0.0  0.0  49.0  0.0 0.0\n7.0  0.0  49.0 6.0 0.0\n0.0  1.0  49.0 0.0 6.0\n7.0  1.0  49.0  6.0 6.0\n7.0  0.0  49.0 6.0 0.0\n14.0  1.0  0.0 0.0 6.0\n14.0  0.0  0.0  0.0 0.0\n21.0  0.0  0.0 6.0 0.0\n14.0  1.0  0.0 0.0 6.0\n21.0  1.0  0.0  6.0 6.0\n21.0  0.0  0.0 6.0 0.0\n14.0  1.0  0.0 0.0 6.0\n14.0  0.0  0.0  0.0 0.0\n14.0  0.0  7.0 6.0 0.0\n14.0  1.0  0.0 0.0 6.0\n14.0  1.0  7.0  6.0 6.0\n14.0  0.0  7.0 6.0 0.0\n21.0  1.0  0.0 0.0 6.0\n21.0  0.0  0.0  0.0 0.0\n21.0  0.0  7.0 6.0 0.0\n21.0  1.0  0.0 0.0 6.0\n21.0  1.0  7.0  6.0 6.0\n21.0  0.0  7.0 6.0 0.0\n14.0  1.0  7.0 0.0 6.0\n14.0  0.0  7.0  0.0 0.0\n21.0  0.0  7.0 6.0 0.0\n14.0  1.0  7.0 0.0 6.0\n21.0  1.0  7.0  6.0 6.0\n21.0  0.0  7.0 6.0 0.0\n14.0  1.0  14.0 0.0 6.0\n14.0  0.0  14.0  0.0 0.0\n21.0  0.0  14.0 6.0 0.0\n14.0  1.0  14.0 0.0 6.0\n21.0  1.0  14.0  6.0 6.0\n21.0  0.0  14.0 6.0 0.0\n14.0  1.0  14.0 0.0 6.0\n14.0  0.0  14.0  0.0 0.0\n14.0  0.0  21.0 6.0 0.0\n14.0  1.0  14.0 0.0 6.0\n14.0  1.0  21.0  6.0 6.0\n14.0  0.0  21.0 6.0 0.0\n21.0  1.0  14.0 0.0 6.0\n21.0  0.0  14.0  0.0 0.0\n21.0  0.0  21.0 6.0 0.0\n21.0  1.0  14.0 0.0 6.0\n21.0  1.0  21.0  6.0 6.0\n21.0  0.0  21.0 6.0 0.0\n14.0  1.0  21.0 0.0 6.0\n14.0  0.0  21.0  0.0 0.0\n21.0  0.0  21.0 6.0 0.0\n14.0  1.0  21.0 0.0 6.0\n21.0  1.0  21.0  6.0 6.0\n21.0  0.0  21.0 6.0 0.0\n14.0  1.0  28.0 0.0 6.0\n14.0  0.0  28.0  0.0 0.0\n21.0  0.0  28.0 6.0 0.0\n14.0  1.0  28.0 0.0 6.0\n21.0  1.0  28.0  6.0 6.0\n21.0  0.0  28.0 6.0 0.0\n14.0  1.0  28.0 0.0 6.0\n14.0  0.0  28.0  0.0 0.0\n14.0  0.0  35.0 6.0 0.0\n14.0  1.0  28.0 0.0 6.0\n14.0  1.0  35.0  6.0 6.0\n14.0  0.0  35.0 6.0 0.0\n21.0  1.0  28.0 0.0 6.0\n21.0  0.0  28.0  0.0 0.0\n21.0  0.0  35.0 6.0 0.0\n21.0  1.0  28.0 0.0 6.0\n21.0  1.0  35.0  6.0 6.0\n21.0  0.0  35.0 6.0 0.0\n14.0  1.0  35.0 0.0 6.0\n14.0  0.0  35.0  0.0 0.0\n21.0  0.0  35.0 6.0 0.0\n14.0  1.0  35.0 0.0 6.0\n21.0  1.0  35.0  6.0 6.0\n21.0  0.0  35.0 6.0 0.0\n14.0  1.0  42.0 0.0 6.0\n14.0  0.0  42.0  0.0 0.0\n21.0  0.0  42.0 6.0 0.0\n14.0  1.0  42.0 0.0 6.0\n21.0  1.0  42.0  6.0 6.0\n21.0  0.0  42.0 6.0 0.0\n14.0  1.0  42.0 0.0 6.0\n14.0  0.0  42.0  0.0 0.0\n14.0  0.0  49.0 6.0 0.0\n14.0  1.0  42.0 0.0 6.0\n14.0  1.0  49.0  6.0 6.0\n14.0  0.0  49.0 6.0 0.0\n21.0  1.0  42.0 0.0 6.0\n21.0  0.0  42.0  0.0 0.0\n21.0  0.0  49.0 6.0 0.0\n21.0  1.0  42.0 0.0 6.0\n21.0  1.0  49.0  6.0 6.0\n21.0  0.0  49.0 6.0 0.0\n14.0  1.0  49.0 0.0 6.0\n14.0  0.0  49.0  0.0 0.0\n21.0  0.0  49.0 6.0 0.0\n14.0  1.0  49.0 0.0 6.0\n21.0  1.0  49.0  6.0 6.0\n21.0  0.0  49.0 6.0 0.0\n28.0  1.0  0.0 0.0 6.0\n28.0  0.0  0.0  0.0 0.0\n35.0  0.0  0.0 6.0 0.0\n28.0  1.0  0.0 0.0 6.0\n35.0  1.0  0.0  6.0 6.0\n35.0  0.0  0.0 6.0 0.0\n28.0  1.0  0.0 0.0 6.0\n28.0  0.0  0.0  0.0 0.0\n28.0  0.0  7.0 6.0 0.0\n28.0  1.0  0.0 0.0 6.0\n28.0  1.0  7.0  6.0 6.0\n28.0  0.0  7.0 6.0 0.0\n35.0  1.0  0.0 0.0 6.0\n35.0  0.0  0.0  0.0 0.0\n35.0  0.0  7.0 6.0 0.0\n35.0  1.0  0.0 0.0 6.0\n35.0  1.0  7.0  6.0 6.0\n35.0  0.0  7.0 6.0 0.0\n28.0  1.0  7.0 0.0 6.0\n28.0  0.0  7.0  0.0 0.0\n35.0  0.0  7.0 6.0 0.0\n28.0  1.0  7.0 0.0 6.0\n35.0  1.0  7.0  6.0 6.0\n35.0  0.0  7.0 6.0 0.0\n28.0  1.0  14.0 0.0 6.0\n28.0  0.0  14.0  0.0 0.0\n35.0  0.0  14.0 6.0 0.0\n28.0  1.0  14.0 0.0 6.0\n35.0  1.0  14.0  6.0 6.0\n35.0  0.0  14.0 6.0 0.0\n28.0  1.0  14.0 0.0 6.0\n28.0  0.0  14.0  0.0 0.0\n28.0  0.0  21.0 6.0 0.0\n28.0  1.0  14.0 0.0 6.0\n28.0  1.0  21.0  6.0 6.0\n28.0  0.0  21.0 6.0 0.0\n35.0  1.0  14.0 0.0 6.0\n35.0  0.0  14.0  0.0 0.0\n35.0  0.0  21.0 6.0 0.0\n35.0  1.0  14.0 0.0 6.0\n35.0  1.0  21.0  6.0 6.0\n35.0  0.0  21.0 6.0 0.0\n28.0  1.0  21.0 0.0 6.0\n28.0  0.0  21.0  0.0 0.0\n35.0  0.0  21.0 6.0 0.0\n28.0  1.0  21.0 0.0 6.0\n35.0  1.0  21.0  6.0 6.0\n35.0  0.0  21.0 6.0 0.0\n28.0  1.0  28.0 0.0 6.0\n28.0  0.0  28.0  0.0 0.0\n35.0  0.0  28.0 6.0 0.0\n28.0  1.0  28.0 0.0 6.0\n35.0  1.0  28.0  6.0 6.0\n35.0  0.0  28.0 6.0 0.0\n28.0  1.0  28.0 0.0 6.0\n28.0  0.0  28.0  0.0 0.0\n28.0  0.0  35.0 6.0 0.0\n28.0  1.0  28.0 0.0 6.0\n28.0  1.0  35.0  6.0 6.0\n28.0  0.0  35.0 6.0 0.0\n35.0  1.0  28.0 0.0 6.0\n35.0  0.0  28.0  0.0 0.0\n35.0  0.0  35.0 6.0 0.0\n35.0  1.0  28.0 0.0 6.0\n35.0  1.0  35.0  6.0 6.0\n35.0  0.0  35.0 6.0 0.0\n28.0  1.0  35.0 0.0 6.0\n28.0  0.0  35.0  0.0 0.0\n35.0  0.0  35.0 6.0 0.0\n28.0  1.0  35.0 0.0 6.0\n35.0  1.0  35.0  6.0 6.0\n35.0  0.0  35.0 6.0 0.0\n28.0  1.0  42.0 0.0 6.0\n28.0  0.0  42.0  0.0 0.0\n35.0  0.0  42.0 6.0 0.0\n28.0  1.0  42.0 0.0 6.0\n35.0  1.0  42.0  6.0 6.0\n35.0  0.0  42.0 6.0 0.0\n28.0  1.0  42.0 0.0 6.0\n28.0  0.0  42.0  0.0 0.0\n28.0  0.0  49.0 6.0 0.0\n28.0  1.0  42.0 0.0 6.0\n28.0  1.0  49.0  6.0 6.0\n28.0  0.0  49.0 6.0 0.0\n35.0  1.0  42.0 0.0 6.0\n35.0  0.0  42.0  0.0 0.0\n35.0  0.0  49.0 6.0 0.0\n35.0  1.0  42.0 0.0 6.0\n35.0  1.0  49.0  6.0 6.0\n35.0  0.0  49.0 6.0 0.0\n28.0  1.0  49.0 0.0 6.0\n28.0  0.0  49.0  0.0 0.0\n35.0  0.0  49.0 6.0 0.0\n28.0  1.0  49.0 0.0 6.0\n35.0  1.0  49.0  6.0 6.0\n35.0  0.0  49.0 6.0 0.0\n42.0  1.0  0.0 0.0 6.0\n42.0  0.0  0.0  0.0 0.0\n49.0  0.0  0.0 6.0 0.0\n42.0  1.0  0.0 0.0 6.0\n49.0  1.0  0.0  6.0 6.0\n49.0  0.0  0.0 6.0 0.0\n42.0  1.0  0.0 0.0 6.0\n42.0  0.0  0.0  0.0 0.0\n42.0  0.0  7.0 6.0 0.0\n42.0  1.0  0.0 0.0 6.0\n42.0  1.0  7.0  6.0 6.0\n42.0  0.0  7.0 6.0 0.0\n49.0  1.0  0.0 0.0 6.0\n49.0  0.0  0.0  0.0 0.0\n49.0  0.0  7.0 6.0 0.0\n49.0  1.0  0.0 0.0 6.0\n49.0  1.0  7.0  6.0 6.0\n49.0  0.0  7.0 6.0 0.0\n42.0  1.0  7.0 0.0 6.0\n42.0  0.0  7.0  0.0 0.0\n49.0  0.0  7.0 6.0 0.0\n42.0  1.0  7.0 0.0 6.0\n49.0  1.0  7.0  6.0 6.0\n49.0  0.0  7.0 6.0 0.0\n42.0  1.0  14.0 0.0 6.0\n42.0  0.0  14.0  0.0 0.0\n49.0  0.0  14.0 6.0 0.0\n42.0  1.0  14.0 0.0 6.0\n49.0  1.0  14.0  6.0 6.0\n49.0  0.0  14.0 6.0 0.0\n42.0  1.0  14.0 0.0 6.0\n42.0  0.0  14.0  0.0 0.0\n42.0  0.0  21.0 6.0 0.0\n42.0  1.0  14.0 0.0 6.0\n42.0  1.0  21.0  6.0 6.0\n42.0  0.0  21.0 6.0 0.0\n49.0  1.0  14.0 0.0 6.0\n49.0  0.0  14.0  0.0 0.0\n49.0  0.0  21.0 6.0 0.0\n49.0  1.0  14.0 0.0 6.0\n49.0  1.0  21.0  6.0 6.0\n49.0  0.0  21.0 6.0 0.0\n42.0  1.0  21.0 0.0 6.0\n42.0  0.0  21.0  0.0 0.0\n49.0  0.0  21.0 6.0 0.0\n42.0  1.0  21.0 0.0 6.0\n49.0  1.0  21.0  6.0 6.0\n49.0  0.0  21.0 6.0 0.0\n42.0  1.0  28.0 0.0 6.0\n42.0  0.0  28.0  0.0 0.0\n49.0  0.0  28.0 6.0 0.0\n42.0  1.0  28.0 0.0 6.0\n49.0  1.0  28.0  6.0 6.0\n49.0  0.0  28.0 6.0 0.0\n42.0  1.0  28.0 0.0 6.0\n42.0  0.0  28.0  0.0 0.0\n42.0  0.0  35.0 6.0 0.0\n42.0  1.0  28.0 0.0 6.0\n42.0  1.0  35.0  6.0 6.0\n42.0  0.0  35.0 6.0 0.0\n49.0  1.0  28.0 0.0 6.0\n49.0  0.0  28.0  0.0 0.0\n49.0  0.0  35.0 6.0 0.0\n49.0  1.0  28.0 0.0 6.0\n49.0  1.0  35.0  6.0 6.0\n49.0  0.0  35.0 6.0 0.0\n42.0  1.0  35.0 0.0 6.0\n42.0  0.0  35.0  0.0 0.0\n49.0  0.0  35.0 6.0 0.0\n42.0  1.0  35.0 0.0 6.0\n49.0  1.0  35.0  6.0 6.0\n49.0  0.0  35.0 6.0 0.0\n42.0  1.0  42.0 0.0 6.0\n42.0  0.0  42.0  0.0 0.0\n49.0  0.0  42.0 6.0 0.0\n42.0  1.0  42.0 0.0 6.0\n49.0  1.0  42.0  6.0 6.0\n49.0  0.0  42.0 6.0 0.0\n42.0  1.0  42.0 0.0 6.0\n42.0  0.0  42.0  0.0 0.0\n42.0  0.0  49.0 6.0 0.0\n42.0  1.0  42.0 0.0 6.0\n42.0  1.0  49.0  6.0 6.0\n42.0  0.0  49.0 6.0 0.0\n49.0  1.0  42.0 0.0 6.0\n49.0  0.0  42.0  0.0 0.0\n49.0  0.0  49.0 6.0 0.0\n49.0  1.0  42.0 0.0 6.0\n49.0  1.0  49.0  6.0 6.0\n49.0  0.0  49.0 6.0 0.0\n42.0  1.0  49.0 0.0 6.0\n42.0  0.0  49.0  0.0 0.0\n49.0  0.0  49.0 6.0 0.0\n42.0  1.0  49.0 0.0 6.0\n49.0  1.0  49.0  6.0 6.0\n49.0  0.0  49.0 6.0 0.0";
    }
    public String getName() {
      return "map";
    }
  }
  ;
    vertexShader = new com.google.gwt.resources.client.TextResource() {
    // file:/home/j0n/code/procgl/gwt_proc/GwtGL-examples/src/main/java/com/df3n5/gwtproc/client/demos/main/vertex-shader.txt
    public String getText() {
      return "/*\nattribute vec3 vertexPosition;\nattribute vec2 texPosition;\nuniform mat4 projectionMatrix;\nvarying vec2 texCoord;\n\n\nvoid main() {\n	gl_Position = projectionMatrix * vec4(vertexPosition, 1.0);\n	texCoord = texPosition;\n}\n*/\n/*\n//Newer\nattribute vec3 aVertexPosition;\nattribute vec2 aTextureCoord;\n\nuniform mat4 uMVMatrix;\nuniform mat4 uPMatrix;\n\nvarying vec2 vTextureCoord;\n\nvoid main(void) {\n//    gl_Position = uPMatrix * uMVMatrix * vec4(aVertexPosition, 1.0);\n	gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);\n    vTextureCoord = aTextureCoord;\n}\n*/\n\nuniform mat4 uMVMatrix;\nuniform mat4 uPMatrix;\n\nattribute vec3 aVertexPosition;\nattribute vec2 aTextureCoord;\nvarying vec2 vTextureCoord;\n\nvoid main() \n{\n	vTextureCoord = aTextureCoord;\n	gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);\n}";
    }
    public String getName() {
      return "vertexShader";
    }
  }
  ;
    mudTexture = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
    "mudTexture",
    externalImage,
    0, 0, 256, 256, false, false
  );
    texture = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
    "texture",
    externalImage0,
    0, 0, 256, 256, false, false
  );
    textureSkyboxBk = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
    "textureSkyboxBk",
    externalImage1,
    0, 0, 512, 512, false, false
  );
    textureSkyboxDn = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
    "textureSkyboxDn",
    externalImage2,
    0, 0, 512, 512, false, false
  );
    textureSkyboxFt = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
    "textureSkyboxFt",
    externalImage3,
    0, 0, 512, 512, false, false
  );
    textureSkyboxLf = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
    "textureSkyboxLf",
    externalImage4,
    0, 0, 512, 512, false, false
  );
    textureSkyboxRt = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
    "textureSkyboxRt",
    externalImage5,
    0, 0, 512, 512, false, false
  );
    textureSkyboxUp = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
    "textureSkyboxUp",
    externalImage6,
    0, 0, 512, 512, false, false
  );
    wallTexture = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
    "wallTexture",
    externalImage7,
    0, 0, 2560, 1920, false, true
  );
  }
  
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.TextResource fragmentShader;
  private static com.google.gwt.resources.client.TextResource map;
  private static com.google.gwt.resources.client.TextResource vertexShader;
  private static final java.lang.String externalImage = GWT.getModuleBaseURL() + "7A7076485693A060A14C42DEF8F19578.cache.gif";
  private static final java.lang.String externalImage0 = GWT.getModuleBaseURL() + "1F2BBE4A76519FEA96A682646622E032.cache.png";
  private static final java.lang.String externalImage1 = GWT.getModuleBaseURL() + "1199B3C237A005CD5E6715A9F4C2164D.cache.png";
  private static final java.lang.String externalImage2 = GWT.getModuleBaseURL() + "7F11213566CE515DA17EE2F55A771C58.cache.png";
  private static final java.lang.String externalImage3 = GWT.getModuleBaseURL() + "56754F5405D5B65C01DAA76BEED81CB9.cache.png";
  private static final java.lang.String externalImage4 = GWT.getModuleBaseURL() + "E1769233A9349025F769C1B6CFFB2447.cache.png";
  private static final java.lang.String externalImage5 = GWT.getModuleBaseURL() + "CEE0CC5D445A8EB3FCB79528F080004B.cache.png";
  private static final java.lang.String externalImage6 = GWT.getModuleBaseURL() + "EFF3AB314CBCE9C1C91C0E10A15DC353.cache.png";
  private static final java.lang.String externalImage7 = GWT.getModuleBaseURL() + "5C2122D4F03EBA194B982D6B2D7A28F1.cache.jpg";
  private static com.google.gwt.resources.client.ImageResource mudTexture;
  private static com.google.gwt.resources.client.ImageResource texture;
  private static com.google.gwt.resources.client.ImageResource textureSkyboxBk;
  private static com.google.gwt.resources.client.ImageResource textureSkyboxDn;
  private static com.google.gwt.resources.client.ImageResource textureSkyboxFt;
  private static com.google.gwt.resources.client.ImageResource textureSkyboxLf;
  private static com.google.gwt.resources.client.ImageResource textureSkyboxRt;
  private static com.google.gwt.resources.client.ImageResource textureSkyboxUp;
  private static com.google.gwt.resources.client.ImageResource wallTexture;
  
  static {
    new Resources_default_InlineClientBundleGenerator()._init0();
  }
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      fragmentShader(), 
      map(), 
      vertexShader(), 
      mudTexture(), 
      texture(), 
      textureSkyboxBk(), 
      textureSkyboxDn(), 
      textureSkyboxFt(), 
      textureSkyboxLf(), 
      textureSkyboxRt(), 
      textureSkyboxUp(), 
      wallTexture(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("fragmentShader", fragmentShader());
        resourceMap.put("map", map());
        resourceMap.put("vertexShader", vertexShader());
        resourceMap.put("mudTexture", mudTexture());
        resourceMap.put("texture", texture());
        resourceMap.put("textureSkyboxBk", textureSkyboxBk());
        resourceMap.put("textureSkyboxDn", textureSkyboxDn());
        resourceMap.put("textureSkyboxFt", textureSkyboxFt());
        resourceMap.put("textureSkyboxLf", textureSkyboxLf());
        resourceMap.put("textureSkyboxRt", textureSkyboxRt());
        resourceMap.put("textureSkyboxUp", textureSkyboxUp());
        resourceMap.put("wallTexture", wallTexture());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'fragmentShader': return this.@com.df3n5.gwtproc.client.demos.main.Resources::fragmentShader()();
      case 'map': return this.@com.df3n5.gwtproc.client.demos.main.Resources::map()();
      case 'vertexShader': return this.@com.df3n5.gwtproc.client.demos.main.Resources::vertexShader()();
      case 'mudTexture': return this.@com.df3n5.gwtproc.client.demos.main.Resources::mudTexture()();
      case 'texture': return this.@com.df3n5.gwtproc.client.demos.main.Resources::texture()();
      case 'textureSkyboxBk': return this.@com.df3n5.gwtproc.client.demos.main.Resources::textureSkyboxBk()();
      case 'textureSkyboxDn': return this.@com.df3n5.gwtproc.client.demos.main.Resources::textureSkyboxDn()();
      case 'textureSkyboxFt': return this.@com.df3n5.gwtproc.client.demos.main.Resources::textureSkyboxFt()();
      case 'textureSkyboxLf': return this.@com.df3n5.gwtproc.client.demos.main.Resources::textureSkyboxLf()();
      case 'textureSkyboxRt': return this.@com.df3n5.gwtproc.client.demos.main.Resources::textureSkyboxRt()();
      case 'textureSkyboxUp': return this.@com.df3n5.gwtproc.client.demos.main.Resources::textureSkyboxUp()();
      case 'wallTexture': return this.@com.df3n5.gwtproc.client.demos.main.Resources::wallTexture()();
    }
    return null;
  }-*/;
}
