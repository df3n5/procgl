package com.df3n5.gwtproc.client.demos.webglperf;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class Resources_default_InlineClientBundleGenerator implements com.df3n5.gwtproc.client.demos.webglperf.Resources {
  private static Resources_default_InlineClientBundleGenerator _instance0 = new Resources_default_InlineClientBundleGenerator();
  private void fragmentShaderWithTexInitializer() {
    fragmentShaderWithTex = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/webglperf/withtex.frag
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
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/webglperf/notex.frag
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
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/webglperf/withtex.vert
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
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/webglperf/notex.vert
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
      externalImage,
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
  private static final java.lang.String externalImage = "data:image/png;base64,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";
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
