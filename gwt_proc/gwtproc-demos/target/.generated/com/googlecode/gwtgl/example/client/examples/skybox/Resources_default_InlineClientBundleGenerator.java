package com.googlecode.gwtgl.example.client.examples.skybox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class Resources_default_InlineClientBundleGenerator implements com.googlecode.gwtgl.example.client.examples.skybox.Resources {
  public com.google.gwt.resources.client.TextResource fragmentShader() {
    return fragmentShader;
  }
  public com.google.gwt.resources.client.TextResource vertexShader() {
    return vertexShader;
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
  private void _init0() {
    fragmentShader = new com.google.gwt.resources.client.TextResource() {
    // file:/home/j0n/data/build/gwtgl-read-only/GwtGL-examples/src/main/java/com/googlecode/gwtgl/example/client/examples/skybox/fragment-shader.txt
    public String getText() {
      return "#ifdef GL_ES\nprecision highp float;\n#endif\n\nuniform sampler2D tex;\nvarying vec2 texCoord;\nvoid main() {\n	gl_FragColor = texture2D(tex, texCoord);\n}";
    }
    public String getName() {
      return "fragmentShader";
    }
  }
  ;
    vertexShader = new com.google.gwt.resources.client.TextResource() {
    // file:/home/j0n/data/build/gwtgl-read-only/GwtGL-examples/src/main/java/com/googlecode/gwtgl/example/client/examples/skybox/vertex-shader.txt
    public String getText() {
      return "attribute vec3 vertexPosition;\nattribute vec2 texPosition;\nuniform mat4 projectionMatrix;\nvarying vec2 texCoord;\nvoid main() {\n	gl_Position = projectionMatrix * vec4(vertexPosition, 1.0);\n	texCoord = texPosition;\n}";
    }
    public String getName() {
      return "vertexShader";
    }
  }
  ;
    textureSkyboxBk = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
    "textureSkyboxBk",
    externalImage,
    0, 0, 512, 512, false, false
  );
    textureSkyboxDn = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
    "textureSkyboxDn",
    externalImage0,
    0, 0, 512, 512, false, false
  );
    textureSkyboxFt = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
    "textureSkyboxFt",
    externalImage1,
    0, 0, 512, 512, false, false
  );
    textureSkyboxLf = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
    "textureSkyboxLf",
    externalImage2,
    0, 0, 512, 512, false, false
  );
    textureSkyboxRt = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
    "textureSkyboxRt",
    externalImage3,
    0, 0, 512, 512, false, false
  );
    textureSkyboxUp = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
    "textureSkyboxUp",
    externalImage4,
    0, 0, 512, 512, false, false
  );
  }
  
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.TextResource fragmentShader;
  private static com.google.gwt.resources.client.TextResource vertexShader;
  private static final java.lang.String externalImage = GWT.getModuleBaseURL() + "1199B3C237A005CD5E6715A9F4C2164D.cache.png";
  private static final java.lang.String externalImage0 = GWT.getModuleBaseURL() + "7F11213566CE515DA17EE2F55A771C58.cache.png";
  private static final java.lang.String externalImage1 = GWT.getModuleBaseURL() + "56754F5405D5B65C01DAA76BEED81CB9.cache.png";
  private static final java.lang.String externalImage2 = GWT.getModuleBaseURL() + "E1769233A9349025F769C1B6CFFB2447.cache.png";
  private static final java.lang.String externalImage3 = GWT.getModuleBaseURL() + "CEE0CC5D445A8EB3FCB79528F080004B.cache.png";
  private static final java.lang.String externalImage4 = GWT.getModuleBaseURL() + "EFF3AB314CBCE9C1C91C0E10A15DC353.cache.png";
  private static com.google.gwt.resources.client.ImageResource textureSkyboxBk;
  private static com.google.gwt.resources.client.ImageResource textureSkyboxDn;
  private static com.google.gwt.resources.client.ImageResource textureSkyboxFt;
  private static com.google.gwt.resources.client.ImageResource textureSkyboxLf;
  private static com.google.gwt.resources.client.ImageResource textureSkyboxRt;
  private static com.google.gwt.resources.client.ImageResource textureSkyboxUp;
  
  static {
    new Resources_default_InlineClientBundleGenerator()._init0();
  }
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      fragmentShader(), 
      vertexShader(), 
      textureSkyboxBk(), 
      textureSkyboxDn(), 
      textureSkyboxFt(), 
      textureSkyboxLf(), 
      textureSkyboxRt(), 
      textureSkyboxUp(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("fragmentShader", fragmentShader());
        resourceMap.put("vertexShader", vertexShader());
        resourceMap.put("textureSkyboxBk", textureSkyboxBk());
        resourceMap.put("textureSkyboxDn", textureSkyboxDn());
        resourceMap.put("textureSkyboxFt", textureSkyboxFt());
        resourceMap.put("textureSkyboxLf", textureSkyboxLf());
        resourceMap.put("textureSkyboxRt", textureSkyboxRt());
        resourceMap.put("textureSkyboxUp", textureSkyboxUp());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'fragmentShader': return this.@com.googlecode.gwtgl.example.client.examples.skybox.Resources::fragmentShader()();
      case 'vertexShader': return this.@com.googlecode.gwtgl.example.client.examples.skybox.Resources::vertexShader()();
      case 'textureSkyboxBk': return this.@com.googlecode.gwtgl.example.client.examples.skybox.Resources::textureSkyboxBk()();
      case 'textureSkyboxDn': return this.@com.googlecode.gwtgl.example.client.examples.skybox.Resources::textureSkyboxDn()();
      case 'textureSkyboxFt': return this.@com.googlecode.gwtgl.example.client.examples.skybox.Resources::textureSkyboxFt()();
      case 'textureSkyboxLf': return this.@com.googlecode.gwtgl.example.client.examples.skybox.Resources::textureSkyboxLf()();
      case 'textureSkyboxRt': return this.@com.googlecode.gwtgl.example.client.examples.skybox.Resources::textureSkyboxRt()();
      case 'textureSkyboxUp': return this.@com.googlecode.gwtgl.example.client.examples.skybox.Resources::textureSkyboxUp()();
    }
    return null;
  }-*/;
}
