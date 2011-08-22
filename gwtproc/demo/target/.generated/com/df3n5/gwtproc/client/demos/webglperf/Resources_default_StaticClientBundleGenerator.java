package com.df3n5.gwtproc.client.demos.webglperf;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class Resources_default_StaticClientBundleGenerator implements com.df3n5.gwtproc.client.demos.webglperf.Resources {
  private static Resources_default_StaticClientBundleGenerator _instance0 = new Resources_default_StaticClientBundleGenerator();
  private void fragmentShaderWithTexInitializer() {
    fragmentShaderWithTex = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/demo/src/main/java/com/df3n5/gwtproc/client/demos/webglperf/withtex.frag
      public String getText() {
        return "#ifdef GL_ES\nprecision highp float;\n#endif\n\nuniform sampler2D tex;\nvarying vec2 texCoord;\nvoid main() {\n	gl_FragColor = texture2D(tex, texCoord);\n}";
      }
      public String getName() {
        return "fragmentShaderWithTex";
      }
    }
    ;
  }
  private static class fragmentShaderWithTexInitializer {
    static {
      _instance0.fragmentShaderWithTexInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return fragmentShaderWithTex;
    }
  }
  public com.google.gwt.resources.client.TextResource fragmentShaderWithTex() {
    return fragmentShaderWithTexInitializer.get();
  }
  private void fragmentShaderWithoutTexInitializer() {
    fragmentShaderWithoutTex = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/demo/src/main/java/com/df3n5/gwtproc/client/demos/webglperf/notex.frag
      public String getText() {
        return "#ifdef GL_ES\nprecision highp float;\n#endif\n\nvoid main() {\n	gl_FragColor = vec4(1.0,1.0,1.0,1.0);\n}";
      }
      public String getName() {
        return "fragmentShaderWithoutTex";
      }
    }
    ;
  }
  private static class fragmentShaderWithoutTexInitializer {
    static {
      _instance0.fragmentShaderWithoutTexInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return fragmentShaderWithoutTex;
    }
  }
  public com.google.gwt.resources.client.TextResource fragmentShaderWithoutTex() {
    return fragmentShaderWithoutTexInitializer.get();
  }
  private void vertexShaderWithTexInitializer() {
    vertexShaderWithTex = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/demo/src/main/java/com/df3n5/gwtproc/client/demos/webglperf/withtex.vert
      public String getText() {
        return "attribute vec3 vertexPosition;\nattribute vec2 texPosition;\nuniform mat4 projectionMatrix;\nvarying vec2 texCoord;\nvoid main() {\n	gl_Position = projectionMatrix * vec4(vertexPosition, 1.0);\n	texCoord = texPosition;\n}";
      }
      public String getName() {
        return "vertexShaderWithTex";
      }
    }
    ;
  }
  private static class vertexShaderWithTexInitializer {
    static {
      _instance0.vertexShaderWithTexInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return vertexShaderWithTex;
    }
  }
  public com.google.gwt.resources.client.TextResource vertexShaderWithTex() {
    return vertexShaderWithTexInitializer.get();
  }
  private void vertexShaderWithoutTexInitializer() {
    vertexShaderWithoutTex = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/demo/src/main/java/com/df3n5/gwtproc/client/demos/webglperf/notex.vert
      public String getText() {
        return "attribute vec3 vertexPosition;\nuniform mat4 projectionMatrix;\nvoid main() {\n	gl_Position = projectionMatrix * vec4(vertexPosition, 1.0);\n}";
      }
      public String getName() {
        return "vertexShaderWithoutTex";
      }
    }
    ;
  }
  private static class vertexShaderWithoutTexInitializer {
    static {
      _instance0.vertexShaderWithoutTexInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return vertexShaderWithoutTex;
    }
  }
  public com.google.gwt.resources.client.TextResource vertexShaderWithoutTex() {
    return vertexShaderWithoutTexInitializer.get();
  }
  private void textureInitializer() {
    texture = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "texture",
      bundledImage_None,
      0, 0, 256, 256, false, false
    );
  }
  private static class textureInitializer {
    static {
      _instance0.textureInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return texture;
    }
  }
  public com.google.gwt.resources.client.ImageResource texture() {
    return textureInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.TextResource fragmentShaderWithTex;
  private static com.google.gwt.resources.client.TextResource fragmentShaderWithoutTex;
  private static com.google.gwt.resources.client.TextResource vertexShaderWithTex;
  private static com.google.gwt.resources.client.TextResource vertexShaderWithoutTex;
  private static final java.lang.String bundledImage_None = GWT.getModuleBaseURL() + "5203DEF41204164CD890F76EF17DE8A5.cache.png";
  private static com.google.gwt.resources.client.ImageResource texture;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      fragmentShaderWithTex(), 
      fragmentShaderWithoutTex(), 
      vertexShaderWithTex(), 
      vertexShaderWithoutTex(), 
      texture(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("fragmentShaderWithTex", fragmentShaderWithTex());
        resourceMap.put("fragmentShaderWithoutTex", fragmentShaderWithoutTex());
        resourceMap.put("vertexShaderWithTex", vertexShaderWithTex());
        resourceMap.put("vertexShaderWithoutTex", vertexShaderWithoutTex());
        resourceMap.put("texture", texture());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'fragmentShaderWithTex': return this.@com.df3n5.gwtproc.client.demos.webglperf.Resources::fragmentShaderWithTex()();
      case 'fragmentShaderWithoutTex': return this.@com.df3n5.gwtproc.client.demos.webglperf.Resources::fragmentShaderWithoutTex()();
      case 'vertexShaderWithTex': return this.@com.df3n5.gwtproc.client.demos.webglperf.Resources::vertexShaderWithTex()();
      case 'vertexShaderWithoutTex': return this.@com.df3n5.gwtproc.client.demos.webglperf.Resources::vertexShaderWithoutTex()();
      case 'texture': return this.@com.df3n5.gwtproc.client.demos.webglperf.Resources::texture()();
    }
    return null;
  }-*/;
}
