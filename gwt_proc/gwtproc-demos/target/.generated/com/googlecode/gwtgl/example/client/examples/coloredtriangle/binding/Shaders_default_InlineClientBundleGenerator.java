package com.googlecode.gwtgl.example.client.examples.coloredtriangle.binding;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class Shaders_default_InlineClientBundleGenerator implements com.googlecode.gwtgl.example.client.examples.coloredtriangle.binding.Shaders {
  public com.google.gwt.resources.client.TextResource fragmentShader() {
    return fragmentShader;
  }
  public com.google.gwt.resources.client.TextResource vertexShader() {
    return vertexShader;
  }
  private void _init0() {
    fragmentShader = new com.google.gwt.resources.client.TextResource() {
    // file:/home/j0n/data/build/gwtgl-read-only/GwtGL-examples/src/main/java/com/googlecode/gwtgl/example/client/examples/coloredtriangle/binding/fragment-shader.txt
    public String getText() {
      return "#ifdef GL_ES\nprecision highp float;\n#endif\n\nvarying vec4 vColor;\n\nvoid main(void)\n{\n	gl_FragColor = vColor;\n}";
    }
    public String getName() {
      return "fragmentShader";
    }
  }
  ;
    vertexShader = new com.google.gwt.resources.client.TextResource() {
    // file:/home/j0n/data/build/gwtgl-read-only/GwtGL-examples/src/main/java/com/googlecode/gwtgl/example/client/examples/coloredtriangle/binding/vertex-shader.txt
    public String getText() {
      return "attribute vec3 vertexPosition;\nattribute vec4 vertexColor;\nuniform mat4 projectionMatrix;\nvarying vec4 vColor;\n\nvoid main(void) {\n	gl_Position = projectionMatrix * vec4(vertexPosition, 1.0);\n	vColor = vertexColor;\n}";
    }
    public String getName() {
      return "vertexShader";
    }
  }
  ;
  }
  
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.TextResource fragmentShader;
  private static com.google.gwt.resources.client.TextResource vertexShader;
  
  static {
    new Shaders_default_InlineClientBundleGenerator()._init0();
  }
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      fragmentShader(), 
      vertexShader(), 
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
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'fragmentShader': return this.@com.googlecode.gwtgl.example.client.examples.coloredtriangle.binding.Shaders::fragmentShader()();
      case 'vertexShader': return this.@com.googlecode.gwtgl.example.client.examples.coloredtriangle.binding.Shaders::vertexShader()();
    }
    return null;
  }-*/;
}
