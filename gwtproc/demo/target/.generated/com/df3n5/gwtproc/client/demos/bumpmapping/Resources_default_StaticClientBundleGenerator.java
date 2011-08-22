package com.df3n5.gwtproc.client.demos.bumpmapping;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class Resources_default_StaticClientBundleGenerator implements com.df3n5.gwtproc.client.demos.bumpmapping.Resources {
  private static Resources_default_StaticClientBundleGenerator _instance0 = new Resources_default_StaticClientBundleGenerator();
  private void ceilingInitializer() {
    ceiling = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/assets/ceiling.txt
      public String getText() {
        return "0.0 2.0 1000.0 0.0 -1.0 0.0 0.0 6.0\n0.0 2.0 0.0 0.0 -1.0 0.0 0.0 0.0\n1000.0 2.0 0.0 0.0 -1.0 0.0 6.0 0.0\n0.0 2.0 1000.0 0.0 -1.0 0.0 0.0 6.0\n1000.0 2.0 1000.0 0.0 -1.0 0.0 6.0 6.0\n1000.0 2.0 0.0 0.0 -1.0 0.0 6.0 0.0\n";
      }
      public String getName() {
        return "ceiling";
      }
    }
    ;
  }
  private static class ceilingInitializer {
    static {
      _instance0.ceilingInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return ceiling;
    }
  }
  public com.google.gwt.resources.client.TextResource ceiling() {
    return ceilingInitializer.get();
  }
  private void ceiling_file_fragInitializer() {
    ceiling_file_frag = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/file/checkered_file.frag
      public String getText() {
        return "#ifdef GL_ES\nprecision highp float;\n#endif\n\n//UNIFORMS\n//TODO : Pass in as uniform\nfloat uFrequencyCeiling = 1024.0;\nvec4 uColorCeiling0 = vec4(0.01,0.01,0.01,1.0);\nvec4 uColorCeiling1 = vec4(0.0,0.0,0.0,1.0);\n\nvarying vec2 vTextureCoord;\n\nvoid main(void) {\n	vec2 texCoord = mod(floor(vTextureCoord * float(uFrequencyCeiling*2.0)), 2.0);\n	float delta = abs(texCoord.x - texCoord.y);\n\n	gl_FragColor = mix(uColorCeiling1, uColorCeiling0, delta);\n}";
      }
      public String getName() {
        return "ceiling_file_frag";
      }
    }
    ;
  }
  private static class ceiling_file_fragInitializer {
    static {
      _instance0.ceiling_file_fragInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return ceiling_file_frag;
    }
  }
  public com.google.gwt.resources.client.TextResource ceiling_file_frag() {
    return ceiling_file_fragInitializer.get();
  }
  private void ceiling_file_vertInitializer() {
    ceiling_file_vert = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/file/checkered_file.vert
      public String getText() {
        return "attribute vec3 aVertexPosition;\nattribute vec2 aTextureCoord;\n\nuniform mat4 uMVMatrix;\nuniform mat4 uPMatrix;\n\nvarying vec2 vTextureCoord;\n\nvoid main(void) {\n	gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);\n    vTextureCoord = aTextureCoord;\n}";
      }
      public String getName() {
        return "ceiling_file_vert";
      }
    }
    ;
  }
  private static class ceiling_file_vertInitializer {
    static {
      _instance0.ceiling_file_vertInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return ceiling_file_vert;
    }
  }
  public com.google.gwt.resources.client.TextResource ceiling_file_vert() {
    return ceiling_file_vertInitializer.get();
  }
  private void ceiling_proc_fragInitializer() {
    ceiling_proc_frag = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/proc/checkered_proc.frag
      public String getText() {
        return "#ifdef GL_ES\nprecision highp float;\n#endif\n\n//UNIFORMS\n//TODO : Pass in as uniform\nfloat uFrequencyCeiling = 1024.0;\nvec4 uColorCeiling0 = vec4(0.01,0.01,0.01,1.0);\nvec4 uColorCeiling1 = vec4(0.0,0.0,0.0,1.0);\n\nvarying vec2 vTextureCoord;\n\nvoid main(void) {\n	vec2 texCoord = mod(floor(vTextureCoord * float(uFrequencyCeiling*2.0)), 2.0);\n	float delta = abs(texCoord.x - texCoord.y);\n\n	gl_FragColor = mix(uColorCeiling1, uColorCeiling0, delta);\n}";
      }
      public String getName() {
        return "ceiling_proc_frag";
      }
    }
    ;
  }
  private static class ceiling_proc_fragInitializer {
    static {
      _instance0.ceiling_proc_fragInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return ceiling_proc_frag;
    }
  }
  public com.google.gwt.resources.client.TextResource ceiling_proc_frag() {
    return ceiling_proc_fragInitializer.get();
  }
  private void ceiling_proc_vertInitializer() {
    ceiling_proc_vert = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/proc/checkered_proc.vert
      public String getText() {
        return "attribute vec3 aVertexPosition;\nattribute vec2 aTextureCoord;\n\nuniform mat4 uMVMatrix;\nuniform mat4 uPMatrix;\n\nvarying vec2 vTextureCoord;\n\nvoid main(void) {\n	gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);\n    vTextureCoord = aTextureCoord;\n}";
      }
      public String getName() {
        return "ceiling_proc_vert";
      }
    }
    ;
  }
  private static class ceiling_proc_vertInitializer {
    static {
      _instance0.ceiling_proc_vertInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return ceiling_proc_vert;
    }
  }
  public com.google.gwt.resources.client.TextResource ceiling_proc_vert() {
    return ceiling_proc_vertInitializer.get();
  }
  private void floorInitializer() {
    floor = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/assets/floor.txt
      public String getText() {
        return "0.0 0.0 1000.0 0.0 1.0 0.0 0.0 6.0\n0.0 0.0 0.0 0.0 1.0 0.0 0.0 0.0\n1000.0 0.0 0.0 0.0 1.0 0.0 6.0 0.0\n0.0 0.0 1000.0 0.0 1.0 0.0 0.0 6.0\n1000.0 0.0 1000.0 0.0 1.0 0.0 6.0 6.0\n1000.0 0.0 0.0 0.0 1.0 0.0 6.0 0.0\n";
      }
      public String getName() {
        return "floor";
      }
    }
    ;
  }
  private static class floorInitializer {
    static {
      _instance0.floorInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return floor;
    }
  }
  public com.google.gwt.resources.client.TextResource floor() {
    return floorInitializer.get();
  }
  private void floor_file_fragInitializer() {
    floor_file_frag = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/file/checkered_file.frag
      public String getText() {
        return "#ifdef GL_ES\nprecision highp float;\n#endif\n\n//UNIFORMS\n//TODO : Pass in as uniform\nfloat uFrequencyCeiling = 1024.0;\nvec4 uColorCeiling0 = vec4(0.01,0.01,0.01,1.0);\nvec4 uColorCeiling1 = vec4(0.0,0.0,0.0,1.0);\n\nvarying vec2 vTextureCoord;\n\nvoid main(void) {\n	vec2 texCoord = mod(floor(vTextureCoord * float(uFrequencyCeiling*2.0)), 2.0);\n	float delta = abs(texCoord.x - texCoord.y);\n\n	gl_FragColor = mix(uColorCeiling1, uColorCeiling0, delta);\n}";
      }
      public String getName() {
        return "floor_file_frag";
      }
    }
    ;
  }
  private static class floor_file_fragInitializer {
    static {
      _instance0.floor_file_fragInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return floor_file_frag;
    }
  }
  public com.google.gwt.resources.client.TextResource floor_file_frag() {
    return floor_file_fragInitializer.get();
  }
  private void floor_file_vertInitializer() {
    floor_file_vert = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/file/checkered_file.vert
      public String getText() {
        return "attribute vec3 aVertexPosition;\nattribute vec2 aTextureCoord;\n\nuniform mat4 uMVMatrix;\nuniform mat4 uPMatrix;\n\nvarying vec2 vTextureCoord;\n\nvoid main(void) {\n	gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);\n    vTextureCoord = aTextureCoord;\n}";
      }
      public String getName() {
        return "floor_file_vert";
      }
    }
    ;
  }
  private static class floor_file_vertInitializer {
    static {
      _instance0.floor_file_vertInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return floor_file_vert;
    }
  }
  public com.google.gwt.resources.client.TextResource floor_file_vert() {
    return floor_file_vertInitializer.get();
  }
  private void floor_proc_fragInitializer() {
    floor_proc_frag = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/proc/checkered_proc.frag
      public String getText() {
        return "#ifdef GL_ES\nprecision highp float;\n#endif\n\n//UNIFORMS\n//TODO : Pass in as uniform\nfloat uFrequencyCeiling = 1024.0;\nvec4 uColorCeiling0 = vec4(0.01,0.01,0.01,1.0);\nvec4 uColorCeiling1 = vec4(0.0,0.0,0.0,1.0);\n\nvarying vec2 vTextureCoord;\n\nvoid main(void) {\n	vec2 texCoord = mod(floor(vTextureCoord * float(uFrequencyCeiling*2.0)), 2.0);\n	float delta = abs(texCoord.x - texCoord.y);\n\n	gl_FragColor = mix(uColorCeiling1, uColorCeiling0, delta);\n}";
      }
      public String getName() {
        return "floor_proc_frag";
      }
    }
    ;
  }
  private static class floor_proc_fragInitializer {
    static {
      _instance0.floor_proc_fragInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return floor_proc_frag;
    }
  }
  public com.google.gwt.resources.client.TextResource floor_proc_frag() {
    return floor_proc_fragInitializer.get();
  }
  private void floor_proc_vertInitializer() {
    floor_proc_vert = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/proc/checkered_proc.vert
      public String getText() {
        return "attribute vec3 aVertexPosition;\nattribute vec2 aTextureCoord;\n\nuniform mat4 uMVMatrix;\nuniform mat4 uPMatrix;\n\nvarying vec2 vTextureCoord;\n\nvoid main(void) {\n	gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);\n    vTextureCoord = aTextureCoord;\n}";
      }
      public String getName() {
        return "floor_proc_vert";
      }
    }
    ;
  }
  private static class floor_proc_vertInitializer {
    static {
      _instance0.floor_proc_vertInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return floor_proc_vert;
    }
  }
  public com.google.gwt.resources.client.TextResource floor_proc_vert() {
    return floor_proc_vertInitializer.get();
  }
  private void pillar_file_fragInitializer() {
    pillar_file_frag = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/file/concrete_file.frag
      public String getText() {
        return "/**\n * Procedural bump mapping\n */\n#ifdef GL_ES\nprecision highp float;\n#endif\n\nvarying vec2 vTextureCoord;\nvarying vec3 vLightDir;\nvarying vec3 vEyeDir;\n\n//uniform vec3  SurfaceColor;    // = (0.7, 0.6, 0.18)\n//uniform float BumpDensity;     // = 16.0\n//uniform float BumpSize;        // = 0.15\n//uniform float SpecularFactor;  // = 0.5\nvec3  SurfaceColor = vec3(0.7, 0.6, 0.18);\nfloat BumpDensity = 16.0;\nfloat BumpSize = 0.15;\nfloat SpecularFactor = 0.5;\n\nuniform int uProcTextureType;\n\nvoid main()\n{\n    vec3 litColor;\n    vec2 c = BumpDensity * vTextureCoord.st; //Tex coord is just to figure out how far we are into polygon\n    vec2 p = fract(c) - vec2(0.5);\n\n    float d, f;\n    d = p.x * p.x + p.y * p.y;\n    f = 1.0 / sqrt(d + 1.0);\n\n    if (d >= BumpSize)\n    { \n    	p = vec2(0.0); \n    	f = 1.0; \n    }\n\n    vec3 normDelta = vec3(p.x, p.y, 1.0) * f;\n    litColor = SurfaceColor * max(dot(normDelta, vLightDir), 0.0);\n    vec3 reflectDir = reflect(vLightDir, normDelta);\n    \n    float spec = max(dot(vEyeDir, reflectDir), 0.0);\n\n    spec *= SpecularFactor;\n\n    litColor = min(litColor + spec, vec3(1.0));\n\n    gl_FragColor = vec4(litColor, 1.0);\n}\n";
      }
      public String getName() {
        return "pillar_file_frag";
      }
    }
    ;
  }
  private static class pillar_file_fragInitializer {
    static {
      _instance0.pillar_file_fragInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return pillar_file_frag;
    }
  }
  public com.google.gwt.resources.client.TextResource pillar_file_frag() {
    return pillar_file_fragInitializer.get();
  }
  private void pillar_file_vertInitializer() {
    pillar_file_vert = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/file/concrete_file.vert
      public String getText() {
        return "/**\n * Procedural bumps\n **/\n\nuniform mat4 uMVMatrix;\nuniform mat4 uPMatrix;\nuniform vec3 uLightPosition;\n \nattribute vec3 aVertexPosition;\nattribute vec3 aNormal;\nattribute vec2 aTextureCoord;\n\nvarying vec2 vTextureCoord;\nvarying vec3 vLightDir;\nvarying vec3 vEyeDir;\n\nvec3 calcTangent(vec3 normal)\n{\n	vec3 tangent;\n	vec3 c1 = cross(normal, vec3(0.0, 0.0, 1.0));\n	vec3 c2 = cross(normal, vec3(0.0, 1.0, 0.0));\n	if(length(c1)>length(c2))\n	{\n		tangent = c1;\n	}\n	else\n	{\n		tangent = c2;\n	}\n	tangent = normalize(tangent);\n	return tangent;\n}\n\nvoid main() \n{\n    gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);\n    vTextureCoord = aTextureCoord;\n	vEyeDir = vec3(uMVMatrix * vec4(aVertexPosition, 1.0));\n    \n    vec3 n = normalize(aNormal);\n    vec3 t = normalize(calcTangent(aNormal));\n    vec3 b = cross(n, t); //binormal\n\n    vec3 v;\n    v.x = dot(uLightPosition, t);\n    v.y = dot(uLightPosition, b);\n    v.z = dot(uLightPosition, n);\n    vLightDir = normalize(v);\n\n    v.x = dot(vEyeDir, t);\n    v.y = dot(vEyeDir, b);\n    v.z = dot(vEyeDir, n);\n    vEyeDir = normalize(v);  \n}";
      }
      public String getName() {
        return "pillar_file_vert";
      }
    }
    ;
  }
  private static class pillar_file_vertInitializer {
    static {
      _instance0.pillar_file_vertInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return pillar_file_vert;
    }
  }
  public com.google.gwt.resources.client.TextResource pillar_file_vert() {
    return pillar_file_vertInitializer.get();
  }
  private void pillar_proc_fragInitializer() {
    pillar_proc_frag = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/proc/concrete_proc.frag
      public String getText() {
        return "/**\n * Procedural bump mapping\n */\n#ifdef GL_ES\nprecision highp float;\n#endif\n\nvarying vec2 vTextureCoord;\nvarying vec3 vLightDir;\nvarying vec3 vEyeDir;\n\n//uniform vec3  SurfaceColor;    // = (0.7, 0.6, 0.18)\n//uniform float BumpDensity;     // = 16.0\n//uniform float BumpSize;        // = 0.15\n//uniform float SpecularFactor;  // = 0.5\nvec3  SurfaceColor = vec3(0.7, 0.6, 0.18);\nfloat BumpDensity = 16.0;\nfloat BumpSize = 0.15;\nfloat SpecularFactor = 0.5;\n\nuniform int uProcTextureType;\n\nvoid main()\n{\n    vec3 litColor;\n    vec2 c = BumpDensity * vTextureCoord.st; //Tex coord is just to figure out how far we are into polygon\n    vec2 p = fract(c) - vec2(0.5);\n\n    float d, f;\n    d = p.x * p.x + p.y * p.y;\n    f = 1.0 / sqrt(d + 1.0);\n\n    if (d >= BumpSize)\n    { \n    	p = vec2(0.0); \n    	f = 1.0; \n    }\n\n    vec3 normDelta = vec3(p.x, p.y, 1.0) * f;\n    litColor = SurfaceColor * max(dot(normDelta, vLightDir), 0.0);\n    vec3 reflectDir = reflect(vLightDir, normDelta);\n    \n    float spec = max(dot(vEyeDir, reflectDir), 0.0);\n\n    spec *= SpecularFactor;\n\n    litColor = min(litColor + spec, vec3(1.0));\n\n    gl_FragColor = vec4(litColor, 1.0);\n}\n";
      }
      public String getName() {
        return "pillar_proc_frag";
      }
    }
    ;
  }
  private static class pillar_proc_fragInitializer {
    static {
      _instance0.pillar_proc_fragInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return pillar_proc_frag;
    }
  }
  public com.google.gwt.resources.client.TextResource pillar_proc_frag() {
    return pillar_proc_fragInitializer.get();
  }
  private void pillar_proc_vertInitializer() {
    pillar_proc_vert = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/proc/concrete_proc.vert
      public String getText() {
        return "/**\n * Procedural bumps\n **/\n\nuniform mat4 uMVMatrix;\nuniform mat4 uPMatrix;\nuniform vec3 uLightPosition;\n \nattribute vec3 aVertexPosition;\nattribute vec3 aNormal;\nattribute vec2 aTextureCoord;\n\nvarying vec2 vTextureCoord;\nvarying vec3 vLightDir;\nvarying vec3 vEyeDir;\n\nvec3 calcTangent(vec3 normal)\n{\n	vec3 tangent;\n	vec3 c1 = cross(normal, vec3(0.0, 0.0, 1.0));\n	vec3 c2 = cross(normal, vec3(0.0, 1.0, 0.0));\n	if(length(c1)>length(c2))\n	{\n		tangent = c1;\n	}\n	else\n	{\n		tangent = c2;\n	}\n	tangent = normalize(tangent);\n	return tangent;\n}\n\nvoid main() \n{\n    gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);\n    vTextureCoord = aTextureCoord;\n	vEyeDir = vec3(uMVMatrix * vec4(aVertexPosition, 1.0));\n    \n    vec3 n = normalize(aNormal);\n    vec3 t = normalize(calcTangent(aNormal));\n    vec3 b = cross(n, t); //binormal\n\n    vec3 v;\n    v.x = dot(uLightPosition, t);\n    v.y = dot(uLightPosition, b);\n    v.z = dot(uLightPosition, n);\n    vLightDir = normalize(v);\n\n    v.x = dot(vEyeDir, t);\n    v.y = dot(vEyeDir, b);\n    v.z = dot(vEyeDir, n);\n    vEyeDir = normalize(v);  \n}";
      }
      public String getName() {
        return "pillar_proc_vert";
      }
    }
    ;
  }
  private static class pillar_proc_vertInitializer {
    static {
      _instance0.pillar_proc_vertInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return pillar_proc_vert;
    }
  }
  public com.google.gwt.resources.client.TextResource pillar_proc_vert() {
    return pillar_proc_vertInitializer.get();
  }
  private void pillarsInitializer() {
    pillars = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/assets/pillars.txt
      public String getText() {
        return "0.5 2.0 0.0 0.309017 -0.0 0.04894346 0.0 6.0\n0.5 0.0 0.0 0.309017 -0.0 0.04894346 0.0 0.0\n0.47552827 0.0 0.1545085 0.309017 -0.0 0.04894346 6.0 0.0\n0.5 2.0 0.0 -0.309017 -0.0 -0.04894346 0.0 6.0\n0.47552827 2.0 0.1545085 -0.309017 -0.0 -0.04894346 6.0 6.0\n0.47552827 0.0 0.1545085 -0.309017 -0.0 -0.04894346 6.0 0.0\n0.47552827 2.0 0.1545085 0.27876824 -0.0 0.14203954 0.0 6.0\n0.47552827 0.0 0.1545085 0.27876824 -0.0 0.14203954 0.0 0.0\n0.4045085 0.0 0.29389262 0.27876824 -0.0 0.14203954 6.0 0.0\n0.47552827 2.0 0.1545085 -0.27876824 -0.0 -0.14203954 0.0 6.0\n0.4045085 2.0 0.29389262 -0.27876824 -0.0 -0.14203954 6.0 6.0\n0.4045085 0.0 0.29389262 -0.27876824 -0.0 -0.14203954 6.0 0.0\n0.4045085 2.0 0.29389262 0.22123176 -0.0 0.2212317 0.0 6.0\n0.4045085 0.0 0.29389262 0.22123176 -0.0 0.2212317 0.0 0.0\n0.29389265 0.0 0.4045085 0.22123176 -0.0 0.2212317 6.0 0.0\n0.4045085 2.0 0.29389262 -0.22123176 -0.0 -0.2212317 0.0 6.0\n0.29389265 2.0 0.4045085 -0.22123176 -0.0 -0.2212317 6.0 6.0\n0.29389265 0.0 0.4045085 -0.22123176 -0.0 -0.2212317 6.0 0.0\n0.29389265 2.0 0.4045085 0.14203954 -0.0 0.27876833 0.0 6.0\n0.29389265 0.0 0.4045085 0.14203954 -0.0 0.27876833 0.0 0.0\n0.15450849 0.0 0.47552827 0.14203954 -0.0 0.27876833 6.0 0.0\n0.29389265 2.0 0.4045085 -0.14203954 -0.0 -0.27876833 0.0 6.0\n0.15450849 2.0 0.47552827 -0.14203954 -0.0 -0.27876833 6.0 6.0\n0.15450849 0.0 0.47552827 -0.14203954 -0.0 -0.27876833 6.0 0.0\n0.15450849 2.0 0.47552827 0.04894346 -0.0 0.309017 0.0 6.0\n0.15450849 0.0 0.47552827 0.04894346 -0.0 0.309017 0.0 0.0\n-2.1855694E-8 0.0 0.5 0.04894346 -0.0 0.309017 6.0 0.0\n0.15450849 2.0 0.47552827 -0.04894346 -0.0 -0.309017 0.0 6.0\n-2.1855694E-8 2.0 0.5 -0.04894346 -0.0 -0.309017 6.0 6.0\n-2.1855694E-8 0.0 0.5 -0.04894346 -0.0 -0.309017 6.0 0.0\n-2.1855694E-8 2.0 0.5 -0.04894346 0.0 0.3090169 0.0 6.0\n-2.1855694E-8 0.0 0.5 -0.04894346 0.0 0.3090169 0.0 0.0\n-0.15450847 0.0 0.47552827 -0.04894346 0.0 0.3090169 6.0 0.0\n-2.1855694E-8 2.0 0.5 0.04894346 0.0 -0.3090169 0.0 6.0\n-0.15450847 2.0 0.47552827 0.04894346 0.0 -0.3090169 6.0 6.0\n-0.15450847 0.0 0.47552827 0.04894346 0.0 -0.3090169 6.0 0.0\n-0.15450847 2.0 0.47552827 -0.14203954 0.0 0.27876824 0.0 6.0\n-0.15450847 0.0 0.47552827 -0.14203954 0.0 0.27876824 0.0 0.0\n-0.2938926 0.0 0.4045085 -0.14203954 0.0 0.27876824 6.0 0.0\n-0.15450847 2.0 0.47552827 0.14203954 0.0 -0.27876824 0.0 6.0\n-0.2938926 2.0 0.4045085 0.14203954 0.0 -0.27876824 6.0 6.0\n-0.2938926 0.0 0.4045085 0.14203954 0.0 -0.27876824 6.0 0.0\n-0.2938926 2.0 0.4045085 -0.22123182 0.0 0.22123188 0.0 6.0\n-0.2938926 0.0 0.4045085 -0.22123182 0.0 0.22123188 0.0 0.0\n-0.40450853 0.0 0.2938926 -0.22123182 0.0 0.22123188 6.0 0.0\n-0.2938926 2.0 0.4045085 0.22123182 0.0 -0.22123188 0.0 6.0\n-0.40450853 2.0 0.2938926 0.22123182 0.0 -0.22123188 6.0 6.0\n-0.40450853 0.0 0.2938926 0.22123182 0.0 -0.22123188 6.0 0.0\n-0.40450853 2.0 0.2938926 -0.27876815 0.0 0.14203942 0.0 6.0\n-0.40450853 0.0 0.2938926 -0.27876815 0.0 0.14203942 0.0 0.0\n-0.47552824 0.0 0.15450852 -0.27876815 0.0 0.14203942 6.0 0.0\n-0.40450853 2.0 0.2938926 0.27876815 0.0 -0.14203942 0.0 6.0\n-0.47552824 2.0 0.15450852 0.27876815 0.0 -0.14203942 6.0 6.0\n-0.47552824 0.0 0.15450852 0.27876815 0.0 -0.14203942 6.0 0.0\n-0.47552824 2.0 0.15450852 -0.30901712 0.0 0.04894352 0.0 6.0\n-0.47552824 0.0 0.15450852 -0.30901712 0.0 0.04894352 0.0 0.0\n-0.5 0.0 -4.371139E-8 -0.30901712 0.0 0.04894352 6.0 0.0\n-0.47552824 2.0 0.15450852 0.30901712 0.0 -0.04894352 0.0 6.0\n-0.5 2.0 -4.371139E-8 0.30901712 0.0 -0.04894352 6.0 6.0\n-0.5 0.0 -4.371139E-8 0.30901712 0.0 -0.04894352 6.0 0.0\n-0.5 2.0 -4.371139E-8 -0.30901688 0.0 -0.04894346 0.0 6.0\n-0.5 0.0 -4.371139E-8 -0.30901688 0.0 -0.04894346 0.0 0.0\n-0.47552827 0.0 -0.15450849 -0.30901688 0.0 -0.04894346 6.0 0.0\n-0.5 2.0 -4.371139E-8 0.30901688 0.0 0.04894346 0.0 6.0\n-0.47552827 2.0 -0.15450849 0.30901688 0.0 0.04894346 6.0 6.0\n-0.47552827 0.0 -0.15450849 0.30901688 0.0 0.04894346 6.0 0.0\n-0.47552827 2.0 -0.15450849 -0.27876815 0.0 -0.14203948 0.0 6.0\n-0.47552827 0.0 -0.15450849 -0.27876815 0.0 -0.14203948 0.0 0.0\n-0.40450853 0.0 -0.29389256 -0.27876815 0.0 -0.14203948 6.0 0.0\n-0.47552827 2.0 -0.15450849 0.27876815 0.0 0.14203948 0.0 6.0\n-0.40450853 2.0 -0.29389256 0.27876815 0.0 0.14203948 6.0 6.0\n-0.40450853 0.0 -0.29389256 0.27876815 0.0 0.14203948 6.0 0.0\n-0.40450853 2.0 -0.29389256 -0.2212317 0.0 -0.22123164 0.0 6.0\n-0.40450853 0.0 -0.29389256 -0.2212317 0.0 -0.22123164 0.0 0.0\n-0.2938927 0.0 -0.4045084 -0.2212317 0.0 -0.22123164 6.0 0.0\n-0.40450853 2.0 -0.29389256 0.2212317 0.0 0.22123164 0.0 6.0\n-0.2938927 2.0 -0.4045084 0.2212317 0.0 0.22123164 6.0 6.0\n-0.2938927 0.0 -0.4045084 0.2212317 0.0 0.22123164 6.0 0.0\n-0.2938927 2.0 -0.4045084 -0.14203966 0.0 -0.27876833 0.0 6.0\n-0.2938927 0.0 -0.4045084 -0.14203966 0.0 -0.27876833 0.0 0.0\n-0.15450855 0.0 -0.47552824 -0.14203966 0.0 -0.27876833 6.0 0.0\n-0.2938927 2.0 -0.4045084 0.14203966 0.0 0.27876833 0.0 6.0\n-0.15450855 2.0 -0.47552824 0.14203966 0.0 0.27876833 6.0 6.0\n-0.15450855 0.0 -0.47552824 0.14203966 0.0 0.27876833 6.0 0.0\n-0.15450855 2.0 -0.47552824 -0.04894352 0.0 -0.3090171 0.0 6.0\n-0.15450855 0.0 -0.47552824 -0.04894352 0.0 -0.3090171 0.0 0.0\n5.9624403E-9 0.0 -0.5 -0.04894352 0.0 -0.3090171 6.0 0.0\n-0.15450855 2.0 -0.47552824 0.04894352 0.0 0.3090171 0.0 6.0\n5.9624403E-9 2.0 -0.5 0.04894352 0.0 0.3090171 6.0 6.0\n5.9624403E-9 0.0 -0.5 0.04894352 0.0 0.3090171 6.0 0.0\n5.9624403E-9 2.0 -0.5 0.04894352 0.0 -0.30901712 0.0 6.0\n5.9624403E-9 0.0 -0.5 0.04894352 0.0 -0.30901712 0.0 0.0\n0.15450856 0.0 -0.47552824 0.04894352 0.0 -0.30901712 6.0 0.0\n5.9624403E-9 2.0 -0.5 -0.04894352 0.0 0.30901712 0.0 6.0\n0.15450856 2.0 -0.47552824 -0.04894352 0.0 0.30901712 6.0 6.0\n0.15450856 0.0 -0.47552824 -0.04894352 0.0 0.30901712 6.0 0.0\n0.15450856 2.0 -0.47552824 0.14203936 0.0 -0.27876794 0.0 6.0\n0.15450856 0.0 -0.47552824 0.14203936 0.0 -0.27876794 0.0 0.0\n0.29389253 0.0 -0.40450856 0.14203936 0.0 -0.27876794 6.0 0.0\n0.15450856 2.0 -0.47552824 -0.14203936 0.0 0.27876794 0.0 6.0\n0.29389253 2.0 -0.40450856 -0.14203936 0.0 0.27876794 6.0 6.0\n0.29389253 0.0 -0.40450856 -0.14203936 0.0 0.27876794 6.0 0.0\n0.29389253 2.0 -0.40450856 0.22123182 0.0 -0.22123188 0.0 6.0\n0.29389253 0.0 -0.40450856 0.22123182 0.0 -0.22123188 0.0 0.0\n0.40450847 0.0 -0.29389265 0.22123182 0.0 -0.22123188 6.0 0.0\n0.29389253 2.0 -0.40450856 -0.22123182 0.0 0.22123188 0.0 6.0\n0.40450847 2.0 -0.29389265 -0.22123182 0.0 0.22123188 6.0 6.0\n0.40450847 0.0 -0.29389265 -0.22123182 0.0 0.22123188 6.0 0.0\n0.40450847 2.0 -0.29389265 0.27876836 0.0 -0.1420396 0.0 6.0\n0.40450847 0.0 -0.29389265 0.27876836 0.0 -0.1420396 0.0 0.0\n0.47552827 0.0 -0.15450847 0.27876836 0.0 -0.1420396 6.0 0.0\n0.40450847 2.0 -0.29389265 -0.27876836 0.0 0.1420396 0.0 6.0\n0.47552827 2.0 -0.15450847 -0.27876836 0.0 0.1420396 6.0 6.0\n0.47552827 0.0 -0.15450847 -0.27876836 0.0 0.1420396 6.0 0.0\n0.47552827 2.0 -0.15450847 0.30901712 0.0 -0.04894346 0.0 6.0\n0.47552827 0.0 -0.15450847 0.30901712 0.0 -0.04894346 0.0 0.0\n0.5 0.0 8.742278E-8 0.30901712 0.0 -0.04894346 6.0 0.0\n0.47552827 2.0 -0.15450847 -0.30901712 0.0 0.04894346 0.0 6.0\n0.5 2.0 8.742278E-8 -0.30901712 0.0 0.04894346 6.0 6.0\n0.5 0.0 8.742278E-8 -0.30901712 0.0 0.04894346 6.0 0.0\n";
      }
      public String getName() {
        return "pillars";
      }
    }
    ;
  }
  private static class pillarsInitializer {
    static {
      _instance0.pillarsInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return pillars;
    }
  }
  public com.google.gwt.resources.client.TextResource pillars() {
    return pillarsInitializer.get();
  }
  private void skybox_file_fragInitializer() {
    skybox_file_frag = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/file/perlinsky_file.frag
      public String getText() {
        return "#ifdef GL_ES\nprecision highp float;\n#endif\n\nvec4 permute(vec4 x)\n{\n  return mod(((x*34.0)+1.0)*x, 289.0);\n}\nvec4 taylorInvSqrt(vec4 r)\n{\n  return 1.79284291400159 - 0.85373472095314 * r;\n}\nfloat snoise(vec3 v)\n{\n  const vec2 C = vec2(1.0/6.0, 1.0/3.0) ;\n  const vec4 D = vec4(0.0, 0.5, 1.0, 2.0);\n  vec3 i = floor(v + dot(v, C.yyy) );\n  vec3 x0 = v - i + dot(i, C.xxx) ;\n  vec3 g = step(x0.yzx, x0.xyz);\n  vec3 l = 1.0 - g;\n  vec3 i1 = min( g.xyz, l.zxy );\n  vec3 i2 = max( g.xyz, l.zxy );\n  vec3 x1 = x0 - i1 + C.xxx;\n  vec3 x2 = x0 - i2 + C.yyy;\n  vec3 x3 = x0 - D.yyy;\n  i = mod(i, 289.0 );\n  vec4 p = permute( permute( permute(\n             i.z + vec4(0.0, i1.z, i2.z, 1.0 ))\n           + i.y + vec4(0.0, i1.y, i2.y, 1.0 ))\n           + i.x + vec4(0.0, i1.x, i2.x, 1.0 ));\n  float n_ = 0.142857142857;\n  vec3 ns = n_ * D.wyz - D.xzx;\n  vec4 j = p - 49.0 * floor(p * ns.z * ns.z);\n  vec4 x_ = floor(j * ns.z);\n  vec4 y_ = floor(j - 7.0 * x_ );\n  vec4 x = x_ *ns.x + ns.yyyy;\n  vec4 y = y_ *ns.x + ns.yyyy;\n  vec4 h = 1.0 - abs(x) - abs(y);\n  vec4 b0 = vec4( x.xy, y.xy );\n  vec4 b1 = vec4( x.zw, y.zw );\n  vec4 s0 = floor(b0)*2.0 + 1.0;\n  vec4 s1 = floor(b1)*2.0 + 1.0;\n  vec4 sh = -step(h, vec4(0.0));\n  vec4 a0 = b0.xzyw + s0.xzyw*sh.xxyy ;\n  vec4 a1 = b1.xzyw + s1.xzyw*sh.zzww ;\n  vec3 p0 = vec3(a0.xy,h.x);\n  vec3 p1 = vec3(a0.zw,h.y);\n  vec3 p2 = vec3(a1.xy,h.z);\n  vec3 p3 = vec3(a1.zw,h.w);\n  vec4 norm = taylorInvSqrt(vec4(dot(p0,p0), dot(p1,p1), dot(p2, p2), dot(p3,p3)));\n  p0 *= norm.x;\n  p1 *= norm.y;\n  p2 *= norm.z;\n  p3 *= norm.w;\n  vec4 m = max(0.6 - vec4(dot(x0,x0), dot(x1,x1), dot(x2,x2), dot(x3,x3)), 0.0);\n  m = m * m;\n  return 42.0 * dot( m*m, vec4( dot(p0,x0), dot(p1,x1),\n                                dot(p2,x2), dot(p3,x3) ) );\n}\n\nvarying vec3 vTexCoord3D;\n\nfloat time = 0.1;\n\nvoid main(void) {\n	vec3 uvw = vTexCoord3D + 0.1*vec3(snoise(vTexCoord3D + vec3(0.0, 0.0, time)),\n			snoise(vTexCoord3D + vec3(43.0, 17.0, time)),\n			snoise(vTexCoord3D + vec3(-17.0, -43.0, time)));\n			\n	//http://www.noisemachine.com/talk1/22.html\n	float n = 0.5; //x coord of surface location\n	n += snoise(uvw - vec3(0.0, 0.0, time));\n	n += 0.5 * snoise(uvw * 2.0 - vec3(0.0, 0.0, time*1.4));\n	n += 0.25 * snoise(uvw * 4.0 - vec3(0.0, 0.0, time*2.0));\n	n += 0.125 * snoise(uvw * 8.0 - vec3(0.0, 0.0, time*2.8));\n	n += 0.0625 * snoise(uvw * 16.0 - vec3(0.0, 0.0, time*4.0));\n	n += 0.03125 * snoise(uvw * 32.0 - vec3(0.0, 0.0, time*5.6));\n	n = sin(n);\n\n	gl_FragColor = vec4( vec3(1.0 - (0.450980*n),1.0-(0.184314*n), 1.0 - (0.074510*n)), 1.0); //Inverted? XXX:Beautiful skybox\n}";
      }
      public String getName() {
        return "skybox_file_frag";
      }
    }
    ;
  }
  private static class skybox_file_fragInitializer {
    static {
      _instance0.skybox_file_fragInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return skybox_file_frag;
    }
  }
  public com.google.gwt.resources.client.TextResource skybox_file_frag() {
    return skybox_file_fragInitializer.get();
  }
  private void skybox_file_vertInitializer() {
    skybox_file_vert = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/file/perlinsky_file.vert
      public String getText() {
        return "uniform mat4 uMVMatrix;\nuniform mat4 uPMatrix;\n\nattribute vec3 aVertexPosition;\nattribute vec2 aTextureCoord;\n\nvarying vec3 vTexCoord3D;\n\nvoid main(void) {\n	gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);\n\n	// Quantise effect - give this a go on highly detailed meshes.\n//	float quant = 3.0;\n//	gl_Position.x=quant*gl_Position.x/quant+gl_Position.x*0.001;\n//	gl_Position.y=quant*gl_Position.y/quant+gl_Position.y*0.001;\n//	gl_Position.z=quant*gl_Position.z/quant+gl_Position.z*0.001;\n    \n	vTexCoord3D = vec3(aTextureCoord,0);\n}";
      }
      public String getName() {
        return "skybox_file_vert";
      }
    }
    ;
  }
  private static class skybox_file_vertInitializer {
    static {
      _instance0.skybox_file_vertInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return skybox_file_vert;
    }
  }
  public com.google.gwt.resources.client.TextResource skybox_file_vert() {
    return skybox_file_vertInitializer.get();
  }
  private void skybox_proc_fragInitializer() {
    skybox_proc_frag = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/proc/perlinsky_proc.frag
      public String getText() {
        return "#ifdef GL_ES\nprecision highp float;\n#endif\n\nvec4 permute(vec4 x)\n{\n  return mod(((x*34.0)+1.0)*x, 289.0);\n}\nvec4 taylorInvSqrt(vec4 r)\n{\n  return 1.79284291400159 - 0.85373472095314 * r;\n}\nfloat snoise(vec3 v)\n{\n  const vec2 C = vec2(1.0/6.0, 1.0/3.0) ;\n  const vec4 D = vec4(0.0, 0.5, 1.0, 2.0);\n  vec3 i = floor(v + dot(v, C.yyy) );\n  vec3 x0 = v - i + dot(i, C.xxx) ;\n  vec3 g = step(x0.yzx, x0.xyz);\n  vec3 l = 1.0 - g;\n  vec3 i1 = min( g.xyz, l.zxy );\n  vec3 i2 = max( g.xyz, l.zxy );\n  vec3 x1 = x0 - i1 + C.xxx;\n  vec3 x2 = x0 - i2 + C.yyy;\n  vec3 x3 = x0 - D.yyy;\n  i = mod(i, 289.0 );\n  vec4 p = permute( permute( permute(\n             i.z + vec4(0.0, i1.z, i2.z, 1.0 ))\n           + i.y + vec4(0.0, i1.y, i2.y, 1.0 ))\n           + i.x + vec4(0.0, i1.x, i2.x, 1.0 ));\n  float n_ = 0.142857142857;\n  vec3 ns = n_ * D.wyz - D.xzx;\n  vec4 j = p - 49.0 * floor(p * ns.z * ns.z);\n  vec4 x_ = floor(j * ns.z);\n  vec4 y_ = floor(j - 7.0 * x_ );\n  vec4 x = x_ *ns.x + ns.yyyy;\n  vec4 y = y_ *ns.x + ns.yyyy;\n  vec4 h = 1.0 - abs(x) - abs(y);\n  vec4 b0 = vec4( x.xy, y.xy );\n  vec4 b1 = vec4( x.zw, y.zw );\n  vec4 s0 = floor(b0)*2.0 + 1.0;\n  vec4 s1 = floor(b1)*2.0 + 1.0;\n  vec4 sh = -step(h, vec4(0.0));\n  vec4 a0 = b0.xzyw + s0.xzyw*sh.xxyy ;\n  vec4 a1 = b1.xzyw + s1.xzyw*sh.zzww ;\n  vec3 p0 = vec3(a0.xy,h.x);\n  vec3 p1 = vec3(a0.zw,h.y);\n  vec3 p2 = vec3(a1.xy,h.z);\n  vec3 p3 = vec3(a1.zw,h.w);\n  vec4 norm = taylorInvSqrt(vec4(dot(p0,p0), dot(p1,p1), dot(p2, p2), dot(p3,p3)));\n  p0 *= norm.x;\n  p1 *= norm.y;\n  p2 *= norm.z;\n  p3 *= norm.w;\n  vec4 m = max(0.6 - vec4(dot(x0,x0), dot(x1,x1), dot(x2,x2), dot(x3,x3)), 0.0);\n  m = m * m;\n  return 42.0 * dot( m*m, vec4( dot(p0,x0), dot(p1,x1),\n                                dot(p2,x2), dot(p3,x3) ) );\n}\n\nvarying vec3 vTexCoord3D;\n\nfloat time = 0.1;\n\nvoid main(void) {\n	vec3 uvw = vTexCoord3D + 0.1*vec3(snoise(vTexCoord3D + vec3(0.0, 0.0, time)),\n			snoise(vTexCoord3D + vec3(43.0, 17.0, time)),\n			snoise(vTexCoord3D + vec3(-17.0, -43.0, time)));\n			\n	//http://www.noisemachine.com/talk1/22.html\n	float n = 0.5; //x coord of surface location\n	n += snoise(uvw - vec3(0.0, 0.0, time));\n	n += 0.5 * snoise(uvw * 2.0 - vec3(0.0, 0.0, time*1.4));\n	n += 0.25 * snoise(uvw * 4.0 - vec3(0.0, 0.0, time*2.0));\n	n += 0.125 * snoise(uvw * 8.0 - vec3(0.0, 0.0, time*2.8));\n	n += 0.0625 * snoise(uvw * 16.0 - vec3(0.0, 0.0, time*4.0));\n	n += 0.03125 * snoise(uvw * 32.0 - vec3(0.0, 0.0, time*5.6));\n	n = sin(n);\n\n	gl_FragColor = vec4( vec3(1.0 - (0.450980*n),1.0-(0.184314*n), 1.0 - (0.074510*n)), 1.0); //Inverted? XXX:Beautiful skybox\n}";
      }
      public String getName() {
        return "skybox_proc_frag";
      }
    }
    ;
  }
  private static class skybox_proc_fragInitializer {
    static {
      _instance0.skybox_proc_fragInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return skybox_proc_frag;
    }
  }
  public com.google.gwt.resources.client.TextResource skybox_proc_frag() {
    return skybox_proc_fragInitializer.get();
  }
  private void skybox_proc_vertInitializer() {
    skybox_proc_vert = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/proc/perlinsky_proc.vert
      public String getText() {
        return "uniform mat4 uMVMatrix;\nuniform mat4 uPMatrix;\n\nattribute vec3 aVertexPosition;\nattribute vec2 aTextureCoord;\n\nvarying vec3 vTexCoord3D;\n\nvoid main(void) {\n	gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);\n\n	// Quantise effect - give this a go on highly detailed meshes.\n//	float quant = 3.0;\n//	gl_Position.x=quant*gl_Position.x/quant+gl_Position.x*0.001;\n//	gl_Position.y=quant*gl_Position.y/quant+gl_Position.y*0.001;\n//	gl_Position.z=quant*gl_Position.z/quant+gl_Position.z*0.001;\n    \n	vTexCoord3D = vec3(aTextureCoord,0);\n}";
      }
      public String getName() {
        return "skybox_proc_vert";
      }
    }
    ;
  }
  private static class skybox_proc_vertInitializer {
    static {
      _instance0.skybox_proc_vertInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return skybox_proc_vert;
    }
  }
  public com.google.gwt.resources.client.TextResource skybox_proc_vert() {
    return skybox_proc_vertInitializer.get();
  }
  private void wall_file_fragInitializer() {
    wall_file_frag = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/file/perlinwall_file.frag
      public String getText() {
        return "#ifdef GL_ES\nprecision highp float;\n#endif\n\nvec4 permute(vec4 x)\n{\n  return mod(((x*34.0)+1.0)*x, 289.0);\n}\nvec4 taylorInvSqrt(vec4 r)\n{\n  return 1.79284291400159 - 0.85373472095314 * r;\n}\nfloat snoise(vec3 v)\n{\n  const vec2 C = vec2(1.0/6.0, 1.0/3.0) ;\n  const vec4 D = vec4(0.0, 0.5, 1.0, 2.0);\n  vec3 i = floor(v + dot(v, C.yyy) );\n  vec3 x0 = v - i + dot(i, C.xxx) ;\n  vec3 g = step(x0.yzx, x0.xyz);\n  vec3 l = 1.0 - g;\n  vec3 i1 = min( g.xyz, l.zxy );\n  vec3 i2 = max( g.xyz, l.zxy );\n  vec3 x1 = x0 - i1 + C.xxx;\n  vec3 x2 = x0 - i2 + C.yyy;\n  vec3 x3 = x0 - D.yyy;\n  i = mod(i, 289.0 );\n  vec4 p = permute( permute( permute(\n             i.z + vec4(0.0, i1.z, i2.z, 1.0 ))\n           + i.y + vec4(0.0, i1.y, i2.y, 1.0 ))\n           + i.x + vec4(0.0, i1.x, i2.x, 1.0 ));\n  float n_ = 0.142857142857;\n  vec3 ns = n_ * D.wyz - D.xzx;\n  vec4 j = p - 49.0 * floor(p * ns.z * ns.z);\n  vec4 x_ = floor(j * ns.z);\n  vec4 y_ = floor(j - 7.0 * x_ );\n  vec4 x = x_ *ns.x + ns.yyyy;\n  vec4 y = y_ *ns.x + ns.yyyy;\n  vec4 h = 1.0 - abs(x) - abs(y);\n  vec4 b0 = vec4( x.xy, y.xy );\n  vec4 b1 = vec4( x.zw, y.zw );\n  vec4 s0 = floor(b0)*2.0 + 1.0;\n  vec4 s1 = floor(b1)*2.0 + 1.0;\n  vec4 sh = -step(h, vec4(0.0));\n  vec4 a0 = b0.xzyw + s0.xzyw*sh.xxyy ;\n  vec4 a1 = b1.xzyw + s1.xzyw*sh.zzww ;\n  vec3 p0 = vec3(a0.xy,h.x);\n  vec3 p1 = vec3(a0.zw,h.y);\n  vec3 p2 = vec3(a1.xy,h.z);\n  vec3 p3 = vec3(a1.zw,h.w);\n  vec4 norm = taylorInvSqrt(vec4(dot(p0,p0), dot(p1,p1), dot(p2, p2), dot(p3,p3)));\n  p0 *= norm.x;\n  p1 *= norm.y;\n  p2 *= norm.z;\n  p3 *= norm.w;\n  vec4 m = max(0.6 - vec4(dot(x0,x0), dot(x1,x1), dot(x2,x2), dot(x3,x3)), 0.0);\n  m = m * m;\n  return 42.0 * dot( m*m, vec4( dot(p0,x0), dot(p1,x1),\n                                dot(p2,x2), dot(p3,x3) ) );\n}\n\nvarying vec3 vTexCoord3D;\n\nfloat time = 0.1;\n\nvoid main(void) {\n	vec3 uvw = vTexCoord3D + 0.1*vec3(snoise(vTexCoord3D + vec3(0.0, 0.0, time)),\n			snoise(vTexCoord3D + vec3(43.0, 17.0, time)),\n			snoise(vTexCoord3D + vec3(-17.0, -43.0, time)));\n			\n	//http://www.noisemachine.com/talk1/22.html\n	float n = 0.5; //x coord of surface location\n	n += snoise(uvw - vec3(0.0, 0.0, time));\n	n += 0.5 * snoise(uvw * 2.0 - vec3(0.0, 0.0, time*1.4));\n	n += 0.25 * snoise(uvw * 4.0 - vec3(0.0, 0.0, time*2.0));\n	n += 0.125 * snoise(uvw * 8.0 - vec3(0.0, 0.0, time*2.8));\n	n += 0.0625 * snoise(uvw * 16.0 - vec3(0.0, 0.0, time*4.0));\n	n += 0.03125 * snoise(uvw * 32.0 - vec3(0.0, 0.0, time*5.6));\n	n = sin(n);\n\n	gl_FragColor = vec4(vec3(0.0, -0.9, -0.9) + vec3(n, n, n), 1.0); //Wall material\n}\n";
      }
      public String getName() {
        return "wall_file_frag";
      }
    }
    ;
  }
  private static class wall_file_fragInitializer {
    static {
      _instance0.wall_file_fragInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return wall_file_frag;
    }
  }
  public com.google.gwt.resources.client.TextResource wall_file_frag() {
    return wall_file_fragInitializer.get();
  }
  private void wall_file_vertInitializer() {
    wall_file_vert = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/file/perlinwall_file.vert
      public String getText() {
        return "uniform mat4 uMVMatrix;\nuniform mat4 uPMatrix;\n\nattribute vec3 aVertexPosition;\nattribute vec2 aTextureCoord;\n\nvarying vec3 vTexCoord3D;\n\nvoid main(void) {\n	gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);\n\n	// Quantise effect - give this a go on highly detailed meshes.\n//	float quant = 3.0;\n//	gl_Position.x=quant*gl_Position.x/quant+gl_Position.x*0.001;\n//	gl_Position.y=quant*gl_Position.y/quant+gl_Position.y*0.001;\n//	gl_Position.z=quant*gl_Position.z/quant+gl_Position.z*0.001;\n    \n	vTexCoord3D = vec3(aTextureCoord,0);\n}";
      }
      public String getName() {
        return "wall_file_vert";
      }
    }
    ;
  }
  private static class wall_file_vertInitializer {
    static {
      _instance0.wall_file_vertInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return wall_file_vert;
    }
  }
  public com.google.gwt.resources.client.TextResource wall_file_vert() {
    return wall_file_vertInitializer.get();
  }
  private void wall_proc_fragInitializer() {
    wall_proc_frag = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/proc/perlinwall_proc.frag
      public String getText() {
        return "#ifdef GL_ES\nprecision highp float;\n#endif\n\nvec4 permute(vec4 x)\n{\n  return mod(((x*34.0)+1.0)*x, 289.0);\n}\nvec4 taylorInvSqrt(vec4 r)\n{\n  return 1.79284291400159 - 0.85373472095314 * r;\n}\nfloat snoise(vec3 v)\n{\n  const vec2 C = vec2(1.0/6.0, 1.0/3.0) ;\n  const vec4 D = vec4(0.0, 0.5, 1.0, 2.0);\n  vec3 i = floor(v + dot(v, C.yyy) );\n  vec3 x0 = v - i + dot(i, C.xxx) ;\n  vec3 g = step(x0.yzx, x0.xyz);\n  vec3 l = 1.0 - g;\n  vec3 i1 = min( g.xyz, l.zxy );\n  vec3 i2 = max( g.xyz, l.zxy );\n  vec3 x1 = x0 - i1 + C.xxx;\n  vec3 x2 = x0 - i2 + C.yyy;\n  vec3 x3 = x0 - D.yyy;\n  i = mod(i, 289.0 );\n  vec4 p = permute( permute( permute(\n             i.z + vec4(0.0, i1.z, i2.z, 1.0 ))\n           + i.y + vec4(0.0, i1.y, i2.y, 1.0 ))\n           + i.x + vec4(0.0, i1.x, i2.x, 1.0 ));\n  float n_ = 0.142857142857;\n  vec3 ns = n_ * D.wyz - D.xzx;\n  vec4 j = p - 49.0 * floor(p * ns.z * ns.z);\n  vec4 x_ = floor(j * ns.z);\n  vec4 y_ = floor(j - 7.0 * x_ );\n  vec4 x = x_ *ns.x + ns.yyyy;\n  vec4 y = y_ *ns.x + ns.yyyy;\n  vec4 h = 1.0 - abs(x) - abs(y);\n  vec4 b0 = vec4( x.xy, y.xy );\n  vec4 b1 = vec4( x.zw, y.zw );\n  vec4 s0 = floor(b0)*2.0 + 1.0;\n  vec4 s1 = floor(b1)*2.0 + 1.0;\n  vec4 sh = -step(h, vec4(0.0));\n  vec4 a0 = b0.xzyw + s0.xzyw*sh.xxyy ;\n  vec4 a1 = b1.xzyw + s1.xzyw*sh.zzww ;\n  vec3 p0 = vec3(a0.xy,h.x);\n  vec3 p1 = vec3(a0.zw,h.y);\n  vec3 p2 = vec3(a1.xy,h.z);\n  vec3 p3 = vec3(a1.zw,h.w);\n  vec4 norm = taylorInvSqrt(vec4(dot(p0,p0), dot(p1,p1), dot(p2, p2), dot(p3,p3)));\n  p0 *= norm.x;\n  p1 *= norm.y;\n  p2 *= norm.z;\n  p3 *= norm.w;\n  vec4 m = max(0.6 - vec4(dot(x0,x0), dot(x1,x1), dot(x2,x2), dot(x3,x3)), 0.0);\n  m = m * m;\n  return 42.0 * dot( m*m, vec4( dot(p0,x0), dot(p1,x1),\n                                dot(p2,x2), dot(p3,x3) ) );\n}\n\nvarying vec3 vTexCoord3D;\n\nfloat time = 0.1;\n\nvoid main(void) {\n	vec3 uvw = vTexCoord3D + 0.1*vec3(snoise(vTexCoord3D + vec3(0.0, 0.0, time)),\n			snoise(vTexCoord3D + vec3(43.0, 17.0, time)),\n			snoise(vTexCoord3D + vec3(-17.0, -43.0, time)));\n			\n	//http://www.noisemachine.com/talk1/22.html\n	float n = 0.5; //x coord of surface location\n	n += snoise(uvw - vec3(0.0, 0.0, time));\n	n += 0.5 * snoise(uvw * 2.0 - vec3(0.0, 0.0, time*1.4));\n	n += 0.25 * snoise(uvw * 4.0 - vec3(0.0, 0.0, time*2.0));\n	n += 0.125 * snoise(uvw * 8.0 - vec3(0.0, 0.0, time*2.8));\n	n += 0.0625 * snoise(uvw * 16.0 - vec3(0.0, 0.0, time*4.0));\n	n += 0.03125 * snoise(uvw * 32.0 - vec3(0.0, 0.0, time*5.6));\n	n = sin(n);\n\n	gl_FragColor = vec4(vec3(0.0, -0.9, -0.9) + vec3(n, n, n), 1.0); //Wall material\n}\n";
      }
      public String getName() {
        return "wall_proc_frag";
      }
    }
    ;
  }
  private static class wall_proc_fragInitializer {
    static {
      _instance0.wall_proc_fragInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return wall_proc_frag;
    }
  }
  public com.google.gwt.resources.client.TextResource wall_proc_frag() {
    return wall_proc_fragInitializer.get();
  }
  private void wall_proc_vertInitializer() {
    wall_proc_vert = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/proc/perlinwall_proc.vert
      public String getText() {
        return "uniform mat4 uMVMatrix;\nuniform mat4 uPMatrix;\n\nattribute vec3 aVertexPosition;\nattribute vec2 aTextureCoord;\n\nvarying vec3 vTexCoord3D;\n\nvoid main(void) {\n	gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);\n\n	// Quantise effect - give this a go on highly detailed meshes.\n//	float quant = 3.0;\n//	gl_Position.x=quant*gl_Position.x/quant+gl_Position.x*0.001;\n//	gl_Position.y=quant*gl_Position.y/quant+gl_Position.y*0.001;\n//	gl_Position.z=quant*gl_Position.z/quant+gl_Position.z*0.001;\n    \n	vTexCoord3D = vec3(aTextureCoord,0);\n}";
      }
      public String getName() {
        return "wall_proc_vert";
      }
    }
    ;
  }
  private static class wall_proc_vertInitializer {
    static {
      _instance0.wall_proc_vertInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return wall_proc_vert;
    }
  }
  public com.google.gwt.resources.client.TextResource wall_proc_vert() {
    return wall_proc_vertInitializer.get();
  }
  private void wallsInitializer() {
    walls = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/assets/walls.txt
      public String getText() {
        StringBuilder builder = new StringBuilder();
        builder.append("0.0 2.0 0.0 0.0 0.0 -0.6 0.0 2.0\n0.0 0.0 0.0 0.0 0.0 -0.6 0.0 0.0\n0.3 0.0 0.0 0.0 0.0 -0.6 0.3 0.0\n0.0 2.0 0.0 0.0 0.0 0.6 0.0 2.0\n0.3 2.0 0.0 0.0 0.0 0.6 0.3 2.0\n0.3 0.0 0.0 0.0 0.0 0.6 0.3 0.0\n0.3 2.0 0.0 0.0 0.0 -0.45 0.3 2.0\n0.3 1.1 0.0 0.0 0.0 -0.45 0.3 1.1\n0.8 1.1 0.0 0.0 0.0 -0.45 0.8 1.1\n0.3 2.0 0.0 0.0 0.0 0.45 0.3 2.0\n0.8 2.0 0.0 0.0 0.0 0.45 0.8 2.0\n0.8 1.1 0.0 0.0 0.0 0.45 0.8 1.1\n0.3 0.6 0.0 0.0 0.0 -0.3 0.3 0.6\n0.3 0.0 0.0 0.0 0.0 -0.3 0.3 0.0\n0.8 0.0 0.0 0.0 0.0 -0.3 0.8 0.0\n0.3 0.6 0.0 0.0 0.0 0.3 0.3 0.6\n0.8 0.6 0.0 0.0 0.0 0.3 0.8 0.6\n0.8 0.0 0.0 0.0 0.0 0.3 0.8 0.0\n0.8 2.0 0.0 0.0 0.0 -10.4 0.8 2.0\n0.8 0.0 0.0 0.0 0.0 -10.4 0.8 0.0\n6.0 0.0 0.0 0.0 0.0 -10.4 6.0 0.0\n0.8 2.0 0.0 0.0 0.0 10.4 0.8 2.0\n6.0 2.0 0.0 0.0 0.0 10.4 6.0 2.0\n6.0 0.0 0.0 0.0 0.0 10.4 6.0 0.0\n0.0 2.0 0.0 8.0 0.0 0.0 0.0 2.0\n0.0 0.0 0.0 8.0 0.0 0.0 0.0 0.0\n0.0 0.0 4.0 8.0 0.0 0.0 4.0 0.0\n0.0 2.0 0.0 -8.0 -0.0 -0.0 0.0 2.0\n0.0 2.0 4.0 -8.0 -0.0 -0.0 4.0 2.0\n0.0 0.0 4.0 -8.0 -0.0 -0.0 4.0 0.0\n6.0 2.0 0.0 8.0 0.0 0.0 0.0 2.0\n6.0 0.0 0.0 8.0 0.0 0.0 0.0 0.0\n6.0 0.0 4.0 8.0 0.0 0.0 4.0 0.0\n6.0 2.0 0.0 -8.0 -0.0 -0.0 0.0 2.0\n6.0 2.0 4.0 -8.0 -0.0 -0.0 4.0 2.0\n6.0 0.0 4.0 -8.0 -0.0 -0.0 4.0 0.0\n0.0 2.0 4.0 0.0 0.0 -12.0 0.0 2.0\n0.0 0.0 4.0 0.0 0.0 -12.0 0.0 0.0\n6.0 0.0 4.0 0.0 0.0 -12.0 6.0 0.0\n0.0 2.0 4.0 0.0 0.0 12.0 0.0 2.0\n6.0 2.0 4.0 0.0 0.0 12.0 6.0 2.0\n6.0 0.0 4.0 0.0 0.0 12.0 6.0 0.0\n0.0 2.0 4.0 0.0 0.0 -0.6 0.0 2.0\n0.0 0.0 4.0 0.0 0.0 -0.6 0.0 0.0\n0.3 0.0 4.0 0.0 0.0 -0.6 0.3 0.0\n0.0 2.0 4.0 0.0 0.0 0.6 0.0 2.0\n0.3 2.0 4.0 0.0 0.0 0.6 0.3 2.0\n0.3 0.0 4.0 0.0 0.0 0.6 0.3 0.0\n0.3 2.0 4.0 0.0 0.0 -0.45 0.3 2.0\n0.3 1.1 4.0 0.0 0.0 -0.45 0.3 1.1\n0.8 1.1 4.0 0.0 0.0 -0.45 0.8 1.1\n0.3 2.0 4.0 0.0 0.0 0.45 0.3 2.0\n0.8 2.0 4.0 0.0 0.0 0.45 0.8 2.0\n0.8 1.1 4.0 0.0 0.0 0.45 0.8 1.1\n0.3 0.6 4.0 0.0 0.0 -0.3 0.3 0.6\n0.3 0.0 4.0 0.0 0.0 -0.3 0.3 0.0\n0.8 0.0 4.0 0.0 0.0 -0.3 0.8 0.0\n0.3 0.6 4.0 0.0 0.0 0.3 0.3 0.6\n0.8 0.6 4.0 0.0 0.0 0.3 0.8 0.6\n0.8 0.0 4.0 0.0 0.0 0.3 0.8 0.0\n0.8 2.0 4.0 0.0 0.0 -4.4 0.8 2.0\n0.8 0.0 4.0 0.0 0.0 -4.4 0.8 0.0\n3.0 0.0 4.0 0.0 0.0 -4.4 3.0 0.0\n0.8 2.0 4.0 0.0 0.0 4.4 0.8 2.0\n3.0 2.0 4.0 0.0 0.0 4.4 3.0 2.0\n3.0 0.0 4.0 0.0 0.0 4.4 3.0 0.0\n0.0 2.0 4.0 8.0 0.0 0.0 0.0 2.0\n0.0 0.0 4.0 8.0 0.0 0.0 0.0 0.0\n0.0 0.0 8.0 8.0 0.0 0.0 4.0 0.0\n0.0 2.0 4.0 -8.0 -0.0 -0.0 0.0 2.0\n0.0 2.0 8.0 -8.0 -0.0 -0.0 4.0 2.0\n0.0 0.0 8.0 -8.0 -0.0 -0.0 4.0 0.0\n3.0 2.0 4.0 8.0 0.0 0.0 0.0 2.0\n3.0 0.0 4.0 8.0 0.0 0.0 0.0 0.0\n3.0 0.0 8.0 8.0 0.0 0.0 4.0 0.0\n3.0 2.0 4.0 -8.0 -0.0 -0.0 0.0 2.0\n3.0 2.0 8.0 -8.0 -0.0 -0.0 4.0 2.0\n3.0 0.0 8.0 -8.0 -0.0 -0.0 4.0 0.0\n0.0 2.0 8.0 0.0 0.0 -6.0 0.0 2.0\n0.0 0.0 8.0 0.0 0.0 -6.0 0.0 0.0\n3.0 0.0 8.0 0.0 0.0 -6.0 3.0 0.0\n0.0 2.0 8.0 0.0 0.0 6.0 0.0 2.0\n3.0 2.0 8.0 0.0 0.0 6.0 3.0 2.0\n3.0 0.0 8.0 0.0 0.0 6.0 3.0 0.0\n0.0 2.0 8.0 0.0 0.0 -0.6 0.0 2.0\n0.0 0.0 8.0 0.0 0.0 -0.6 0.0 0.0\n0.3 0.0 8.0 0.0 0.0 -0.6 0.3 0.0\n0.0 2.0 8.0 0.0 0.0 0.6 0.0 2.0\n0.3 2.0 8.0 0.0 0.0 0.6 0.3 2.0\n0.3 0.0 8.0 0.0 0.0 0.6 0.3 0.0\n0.3 2.0 8.0 0.0 0.0 -0.45 0.3 2.0\n0.3 1.1 8.0 0.0 0.0 -0.45 0.3 1.1\n0.8 1.1 8.0 0.0 0.0 -0.45 0.8 1.1\n0.3 2.0 8.0 0.0 0.0 0.45 0.3 2.0\n0.8 2.0 8.0 0.0 0.0 0.45 0.8 2.0\n0.8 1.1 8.0 0.0 0.0 0.45 0.8 1.1\n0.3 0.6 8.0 0.0 0.0 -0.3 0.3 0.6\n0.3 0.0 8.0 0.0 0.0 -0.3 0.3 0.0\n0.8 0.0 8.0 0.0 0.0 -0.3 0.8 0.0\n0.3 0.6 8.0 0.0 0.0 0.3 0.3 0.6\n0.8 0.6 8.0 0.0 0.0 0.3 0.8 0.6\n0.8 0.0 8.0 0.0 0.0 0.3 0.8 0.0\n0.8 2.0 8.0 0.0 0.0 -4.4 0.8 2.0\n0.8 0.0 8.0 0.0 0.0 -4.4 0.8 0.0\n3.0 0.0 8.0 0.0 0.0 -4.4 3.0 0.0\n0.8 2.0 8.0 0.0 0.0 4.4 0.8 2.0\n3.0 2.0 8.0 0.0 0.0 4.4 3.0 2.0\n3.0 0.0 8.0 0.0 0.0 4.4 3.0 0.0\n0.0 2.0 8.0 8.0 0.0 0.0 0.0 2.0\n0.0 0.0 8.0 8.0 0.0 0.0 0.0 0.0\n0.0 0.0 12.0 8.0 0.0 0.0 4.0 0.0\n0.0 2.0 8.0 -8.0 -0.0 -0.0 0.0 2.0\n0.0 2.0 12.0 -8.0 -0.0 -0.0 4.0 2.0\n0.0 0.0 12.0 -8.0 -0.0 -0.0 4.0 0.0\n3.0 2.0 8.0 8.0 0.0 0.0 0.0 2.0\n3.0 0.0 8.0 8.0 0.0 0.0 0.0 0.0\n3.0 0.0 12.0 8.0 0.0 0.0 4.0 0.0\n3.0 2.0 8.0 -8.0 -0.0 -0.0 0.0 2.0\n3.0 2.0 12.0 -8.0 -0.0 -0.0 4.0 2.0\n3.0 0.0 12.0 -8.0 -0.0 -0.0 4.0 0.0\n0.0 2.0 12.0 0.0 0.0 -6.0 0.0 2.0\n0.0 0.0 12.0 0.0 0.0 -6.0 0.0 0.0\n3.0 0.0 12.0 0.0 0.0 -6.0 3.0 0.0\n0.0 2.0 12.0 0.0 0.0 6.0 0.0 2.0\n3.0 2.0 12.0 0.0 0.0 6.0 3.0 2.0\n3.0 0.0 12.0 0.0 0.0 6.0 3.0 0.0\n0.0 2.0 12.0 0.0 0.0 -0.6 0.0 2.0\n0.0 0.0 12.0 0.0 0.0 -0.6 0.0 0.0\n0.3 0.0 12.0 0.0 0.0 -0.6 0.3 0.0\n0.0 2.0 12.0 0.0 0.0 0.6 0.0 2.0\n0.3 2.0 12.0 0.0 0.0 0.6 0.3 2.0\n0.3 0.0 12.0 0.0 0.0 0.6 0.3 0.0\n0.3 2.0 12.0 0.0 0.0 -0.45 0.3 2.0\n0.3 1.1 12.0 0.0 0.0 -0.45 0.3 1.1\n0.8 1.1 12.0 0.0 0.0 -0.45 0.8 1.1\n0.3 2.0 12.0 0.0 0.0 0.45 0.3 2.0\n0.8 2.0 12.0 0.0 0.0 0.45 0.8 2.0\n0.8 1.1 12.0 0.0 0.0 0.45 0.8 1.1\n0.3 0.6 12.0 0.0 0.0 -0.3 0.3 0.6\n0.3 0.0 12.0 0.0 0.0 -0.3 0.3 0.0\n0.8 0.0 12.0 0.0 0.0 -0.3 0.8 0.0\n0.3 0.6 12.0 0.0 0.0 0.3 0.3 0.6\n0.8 0.6 12.0 0.0 0.0 0.3 0.8 0.6\n0.8 0.0 12.0 0.0 0.0 0.3 0.8 0.0\n0.8 2.0 12.0 0.0 0.0 -4.4 0.8 2.0\n0.8 0.0 12.0 0.0 0.0 -4.4 0.8 0.0\n3.0 0.0 12.0 0.0 0.0 -4.4 3.0 0.0\n0.8 2.0 12.0 0.0 0.0 4.4 0.8 2.0\n3.0 2.0 12.0 0.0 0.0 4.4 3.0 2.0\n3.0 0.0 12.0 0.0 0.0 4.4 3.0 0.0\n0.0 2.0 12.0 8.0 0.0 0.0 0.0 2.0\n0.0 0.0 12.0 8.0 0.0 0.0 0.0 0.0\n0.0 0.0 16.0 8.0 0.0 0.0 4.0 0.0\n0.0 2.0 12.0 -8.0 -0.0 -0.0 0.0 2.0\n0.0 2.0 16.0 -8.0 -0.0 -0.0 4.0 2.0\n0.0 0.0 16.0 -8.0 -0.0 -0.0 4.0 0.0\n3.0 2.0 12.0 8.0 0.0 0.0 0.0 2.0\n3.0 0.0 12.0 8.0 0.0 0.0 0.0 0.0\n3.0 0.0 16.0 8.0 0.0 0.0 4.0 0.0\n3.0 2.0 12.0 -8.0 -0.0 -0.0 0.0 2.0\n3.0 2.0 16.0 -8.0 -0.0 -0.0 4.0 2.0\n3.0 0.0 16.0 -8.0 -0.0 -0.0 4.0 0.0\n0.0 2.0 16.0 0.0 0.0 -6.0 0.0 2.0\n0.0 0.0 16.0 0.0 0.0 -6.0 0.0 0.0\n3.0 0.0 16.0 0.0 0.0 -6.0 3.0 0.0\n0.0 2.0 16.0 0.0 0.0 6.0 0.0 2.0\n3.0 2.0 16.0 0.0 0.0 6.0 3.0 2.0\n3.0 0.0 16.0 0.0 0.0 6.0 3.0 0.0\n0.0 2.0 16.0 0.0 0.0 -0.6 0.0 2.0\n0.0 0.0 16.0 0.0 0.0 -0.6 0.0 0.0\n0.3 0.0 16.0 0.0 0.0 -0.6 0.3 0.0\n0.0 2.0 16.0 0.0 0.0 0.6 0.0 2.0\n0.3 2.0 16.0 0.0 0.0 0.6 0.3 2.0\n0.3 0.0 16.0 0.0 0.0 0.6 0.3 0.0\n0.3 2.0 16.0 0.0 0.0 -0.45 0.3 2.0\n0.3 1.1 16.0 0.0 0.0 -0.45 0.3 1.1\n0.8 1.1 16.0 0.0 0.0 -0.45 0.8 1.1\n0.3 2.0 16.0 0.0 0.0 0.45 0.3 2.0\n0.8 2.0 16.0 0.0 0.0 0.45 0.8 2.0\n0.8 1.1 16.0 0.0 0.0 0.45 0.8 1.1\n0.3 0.6 16.0 0.0 0.0 -0.3 0.3 0.6\n0.3 0.0 16.0 0.0 0.0 -0.3 0.3 0.0\n0.8 0.0 16.0 0.0 0.0 -0.3 0.8 0.0\n0.3 0.6 16.0 0.0 0.0 0.3 0.3 0.6\n0.8 0.6 16.0 0.0 0.0 0.3 0.8 0.6\n0.8 0.0 16.0 0.0 0.0 0.3 0.8 0.0\n0.8 2.0 16.0 0.0 0.0 -4.4 0.8 2.0\n0.8 0.0 16.0 0.0 0.0 -4.4 0.8 0.0\n3.0 0.0 16.0 0.0 0.0 -4.4 3.0 0.0\n0.8 2.0 16.0 0.0 0.0 4.4 0.8 2.0\n3.0 2.0 16.0 0.0 0.0 4.4 3.0 2.0\n3.0 0.0 16.0 0.0 0.0 4.4 3.0 0.0\n0.0 2.0 16.0 8.0 0.0 0.0 0.0 2.0\n0.0 0.0 16.0 8.0 0.0 0.0 0.0 0.0\n0.0 0.0 20.0 8.0 0.0 0.0 4.0 0.0\n0.0 2.0 16.0 -8.0 -0.0 -0.0 0.0 2.0\n0.0 2.0 20.0 -8.0 -0.0 -0.0 4.0 2.0\n0.0 0.0 20.0 -8.0 -0.0 -0.0 4.0 0.0\n3.0 2.0 16.0 8.0 0.0 0.0 0.0 2.0\n3.0 0.0 16.0 8.0 0.0 0.0 0.0 0.0\n3.0 0.0 20.0 8.0 0.0 0.0 4.0 0.0\n3.0 2.0 16.0 -8.0 -0.0 -0.0 0.0 2.0\n3.0 2.0 20.0 -8.0 -0.0 -0.0 4.0 2.0\n3.0 0.0 20.0 -8.0 -0.0 -0.0 4.0 0.0\n0.0 2.0 20.0 0.0 0.0 -6.0 0.0 2.0\n0.0 0.0 20.0 0.0 0.0 -6.0 0.0 0.0\n3.0 0.0 20.0 0.0 0.0 -6.0 3.0 0.0\n0.0 2.0 20.0 0.0 0.0 6.0 0.0 2.0\n3.0 2.0 20.0 0.0 0.0 6.0 3.0 2.0\n3.0 0.0 20.0 0.0 0.0 6.0 3.0 0.0\n0.0 2.0 20.0 0.0 0.0 -0.6 0.0 2.0\n0.0 0.0 20.0 0.0 0.0 -0.6 0.0 0.0\n0.3 0.0 20.0 0.0 0.0 -0.6 0.3 0.0\n0.0 2.0 20.0 0.0 0.0 0.6 0.0 2.0\n0.3 2.0 20.0 0.0 0.0 0.6 0.3 2.0\n0.3 0.0 20.0 0.0 0.0 0.6 0.3 0.0\n0.3 2.0 20.0 0.0 0.0 -0.45 0.3 2.0\n0.3 1.1 20.0 0.0 0.0 -0.45 0.3 1.1\n0.8 1.1 20.0 0.0 0.0 -0.45 0.8 1.1\n0.3 2.0 20.0 0.0 0.0 0.45 0.3 2.0\n0.8 2.0 20.0 0.0 0.0 0.45 0.8 2.0\n0.8 1.1 20.0 0.0 0.0 0.45 0.8 1.1\n0.3 0.6 20.0 0.0 0.0 -0.3 0.3 0.6\n0.3 0.0 20.0 0.0 0.0 -0.3 0.3 0.0\n0.8 0.0 20.0 0.0 0.0 -0.3 0.8 0.0\n0.3 0.6 20.0 0.0 0.0 0.3 0.3 0.6\n0.8 0.6 20.0 0.0 0.0 0.3 0.8 0.6\n0.8 0.0 20.0 0.0 0.0 0.3 0.8 0.0\n0.8 2.0 20.0 0.0 0.0 -4.4 0.8 2.0\n0.8 0.0 20.0 0.0 0.0 -4.4 0.8 0.0\n3.0 0.0 20.0 0.0 0.0 -4.4 3.0 0.0\n0.8 2.0 20.0 0.0 0.0 4.4 0.8 2.0\n3.0 2.0 20.0 0.0 0.0 4.4 3.0 2.0\n3.0 0.0 20.0 0.0 0.0 4.4 3.0 0.0\n0.0 2.0 20.0 8.0 0.0 0.0 0.0 2.0\n0.0 0.0 20.0 8.0 0.0 0.0 0.0 0.0\n0.0 0.0 24.0 8.0 0.0 0.0 4.0 0.0\n0.0 2.0 20.0 -8.0 -0.0 -0.0 0.0 2.0\n0.0 2.0 24.0 -8.0 -0.0 -0.0 4.0 2.0\n0.0 0.0 24.0 -8.0 -0.0 -0.0 4.0 0.0\n3.0 2.0 20.0 8.0 0.0 0.0 0.0 2.0\n3.0 0.0 20.0 8.0 0.0 0.0 0.0 0.0\n3.0 0.0 24.0 8.0 0.0 0.0 4.0 0.0\n3.0 2.0 20.0 -8.0 -0.0 -0.0 0.0 2.0\n3.0 2.0 24.0 -8.0 -0.0 -0.0 4.0 2.0\n3.0 0.0 24.0 -8.0 -0.0 -0.0 4.0 0.0\n0.0 2.0 24.0 0.0 0.0 -6.0 0.0 2.0\n0.0 0.0 24.0 0.0 0.0 -6.0 0.0 0.0\n3.0 0.0 24.0 0.0 0.0 -6.0 3.0 0.0\n0.0 2.0 24.0 0.0 0.0 6.0 0.0 2.0\n3.0 2.0 24.0 0.0 0.0 6.0 3.0 2.0\n3.0 0.0 24.0 0.0 0.0 6.0 3.0 0.0\n0.0 2.0 24.0 0.0 0.0 -0.6 0.0 2.0\n0.0 0.0 24.0 0.0 0.0 -0.6 0.0 0.0\n0.3 0.0 24.0 0.0 0.0 -0.6 0.3 0.0\n0.0 2.0 24.0 0.0 0.0 0.6 0.0 2.0\n0.3 2.0 24.0 0.0 0.0 0.6 0.3 2.0\n0.3 0.0 24.0 0.0 0.0 0.6 0.3 0.0\n0.3 2.0 24.0 0.0 0.0 -0.45 0.3 2.0\n0.3 1.1 24.0 0.0 0.0 -0.45 0.3 1.1\n0.8 1.1 24.0 0.0 0.0 -0.45 0.8 1.1\n0.3 2.0 24.0 0.0 0.0 0.45 0.3 2.0\n0.8 2.0 24.0 0.0 0.0 0.45 0.8 2.0\n0.8 1.1 24.0 0.0 0.0 0.45 0.8 1.1\n0.3 0.6 24.0 0.0 0.0 -0.3 0.3 0.6\n0.3 0.0 24.0 0.0 0.0 -0.3 0.3 0.0\n0.8 0.0 24.0 0.0 0.0 -0.3 0.8 0.0\n0.3 0.6 24.0 0.0 0.0 0.3 0.3 0.6\n0.8 0.6 24.0 0.0 0.0 0.3 0.8 0.6\n0.8 0.0 24.0 0.0 0.0 0.3 0.8 0.0\n0.8 2.0 24.0 0.0 0.0 -10.4 0.8 2.0\n0.8 0.0 24.0 0.0 0.0 -10.4 0.8 0.0\n6.0 0.0 24.0 0.0 0.0 -10.4 6.0 0.0\n0.8 2.0 24.0 0.0 0.0 10.4 0.8 2.0\n6.0 2.0 24.0 0.0 0.0 10.4 6.0 2.0\n6.0 0.0 24.0 0.0 0.0 10.4 6.0 0.0\n0.0 2.0 24.0 8.0 0.0 0.0 0.0 2.0\n0.0 0.0 24.0 8.0 0.0 0.0 0.0 0.0\n0.0 0.0 28.0 8.0 0.0 0.0 4.0 0.0\n0.0 2.0 24.0 -8.0 -0.0 -0.0 0.0 2.0\n0.0 2.0 28.0 -8.0 -0.0 -0.0 4.0 2.0\n0.0 0.0 28.0 -8.0 -0.0 -0.0 4.0 0.0\n6.0 2.0 24.0 8.0 0.0 0.0 0.0 2.0\n6.0 0.0 24.0 8.0 0.0 0.0 0.0 0.0\n6.0 0.0 28.0 8.0 0.0 0.0 4.0 0.0\n6.0 2.0 24.0 -8.0 -0.0 -0.0 0.0 2.0\n6.0 2.0 28.0 -8.0 -0.0 -0.0 4.0 2.0\n6.0 0.0 28.0 -8.0 -0.0 -0.0 4.0 0.0\n0.0 2.0 28.0 0.0 0.0 -12.0 0.0 2.0\n0.0 0.0 28.0 0.0 0.0 -12.0 0.0 0.0\n6.0 0.0 28.0 0.0 0.0 -12.0 6.0 0.0\n0.0 2.0 28.0 0.0 0.0 12.0 0.0 2.0\n6.0 2.0 28.0 0.0 0.0 12.0 6.0 2.0\n6.0 0.0 28.0 0.0 0.0 12.0 6.0 0.0\n6.0 2.0 0.0 0.0 0.0 -0.6000004 0.0 2.0\n6.0 0.0 0.0 0.0 0.0 -0.6000004 0.0 0.0\n6.3 0.0 0.0 0.0 0.0 -0.6000004 0.3000002 0.0\n6.0 2.0 0.0 0.0 0.0 0.6000004 0.0 2.0\n6.3 2.0 0.0 0.0 0.0 0.6000004 0.3000002 2.0\n6.3 0.0 0.0 0.0 0.0 0.6000004 0.3000002 0.0\n6.3 2.0 0.0 0.0 0.0 -0.45 0.3000002 2.0\n6.3 1.1 0.0 0.0 0.0 -0.45 0.3000002 1.1\n6.8 1.1 0.0 0.0 0.0 -0.45 0.8000002 1.1\n6.3 2.0 0.0 0.0 0.0 0.45 0.3000002 2.0\n6.8 2.0 0.0 0.0 0.0 0.45 0.8000002 2.0\n6.8 1.1 0.0 0.0 0.0 0.45 0.8000002 1.1\n6.3 0.6 0.0 0.0 0.0 -0.3 0.3000002 0.6\n6.3 0.0 0.0 0.0 0.0 -0.3 0.3000002 0.0\n6.8 0.0 0.0 0.0 0.0 -0.3 0.8000002 0.0\n6.3 0.6 0.0 0.0 0.0 0.3 0.3000002 0.6\n6.8 0.6 0.0 0.0 0.0 0.3 0.8000002 0.6\n6.8 0.0 0.0 0.0 0.0 0.3 0.8000002 0.0\n6.8 2.0 0.0 0.0 0.0 -4.3999996 0.8000002 2.0\n6.8 0.0 0.0 0.0 0.0 -4.3999996 0.8000002 0.0\n9.0 0.0 0.0 0.0 0.0 -4.3999996 3.0 0.0\n6.8 2.0 0.0 0.0 0.0 4.3999996 0.8000002 2.0\n9.0 2.0 0.0 0.0 0.0 4.3999996 3.0 2.0\n9.0 0.0 0.0 0.0 0.0 4.3999996 3.0 0.0\n6.0 2.0 0.0 8.0 0.0 0.0 0.0 2.0\n6.0 0.0 0.0 8.0 0.0 0.0 0.0 0.0\n6.0 0.0 4.0 8.0 0.0 0.0 4.0 0.0\n6.0 2.0 0.0 -8.0 -0.0 -0.0 0.0 2.0\n6.0 2.0 4.0 -8.0 -0.0 -0.0 4.0 2.0\n6.0 0.0 4.0 -8.0 -0.0 -0.0 4.0 0.0\n9.0 2.0 0.0 8.0 0.0 0.0 0.0 2.0\n9.0 0.0 0.0 8.0 0.0 0.0 0.0 0.0\n9.0 0.0 4.0 8.0 0.0 0.0 4.0 0.0\n9.0 2.0 0.0 -8.0 -0.0 -0.0 0.0 2.0\n9.0 2.0 4.0 -8.0 -0.0 -0.0 4.0 2.0\n9.0 0.0 4.0 -8.0 -0.0 -0.0 4.0 0.0\n6.0 2.0 4.0 0.0 0.0 -6.0 0.0 2.0\n6.0 0.0 4.0 0.0 0.0 -6.0 0.0 0.0\n9.0 0.0 4.0 0.0 0.0 -6.0 3.0 0.0\n6.0 2.0 4.0 0.0 0.0 6.0 0.0 2.0\n9.0 2.0 4.0 0.0 0.0 6.0 3.0 2.0\n9.0 0.0 4.0 0.0 0.0 6.0 3.0 0.0\n6.0 2.0 8.0 0.0 0.0 -0.6000004 0.0 2.0\n6.0 0.0 8.0 0.0 0.0 -0.6000004 0.0 0.0\n6.3 0.0 8.0 0.0 0.0 -0.6000004 0.3000002 0.0\n6.0 2.0 8.0 0.0 0.0 0.6000004 0.0 2.0\n6.3 2.0 8.0 0.0 0.0 0.6000004 0.3000002 2.0\n6.3 0.0 8.0 0.0 0.0 0.6000004 0.3000002 0.0\n6.3 2.0 8.0 0.0 0.0 -0.45 0.3000002 2.0\n6.3 1.1 8.0 0.0 0.0 -0.45 0.3000002 1.1\n6.8 1.1 8.0 0.0 0.0 -0.45 0.8000002 1.1\n6.3 2.0 8.0 0.0 0.0 0.45 0.3000002 2.0\n6.8 2.0 8.0 0.0 0.0 0.45 0.8000002 2.0\n6.8 1.1 8.0 0.0 0.0 0.45 0.8000002 1.1\n6.3 0.6 8.0 0.0 0.0 -0.3 0.3000002 0.6\n6.3 0.0 8.0 0.0 0.0 -0.3 0.3000002 0.0\n6.8 0.0 8.0 0.0 0.0 -0.3 0.8000002 0.0\n6.3 0.6 8.0 0.0 0.0 0.3 0.3000002 0.6\n6.8 0.6 8.0 0.0 0.0 0.3 0.8000002 0.6\n6.8 0.0 8.0 0.0 0.0 0.3 0.8000002 0.0\n6.8 2.0 8.0 0.0 0.0 -4.3999996 0.8000002 2.0\n6.8 0.0 8.0 0.0 0.0 -4.3999996 0.8000002 0.0\n9.0 0.0 8.0 0.0 0.0 -4.3999996 3.0 0.0\n6.8 2.0 8.0 0.0 0.0 4.3999996 0.8000002 2.0\n9.0 2.0 8.0 0.0 0.0 4.3999996 3.0 2.0\n9.0 0.0 8.0 0.0 0.0 4.3999996 3.0 0.0\n6.0 2.0 8.0 8.0 0.0 0.0 0.0 2.0\n6.0 0.0 8.0 8.0 0.0 0.0 0.0 0.0\n6.0 0.0 12.0 8.0 0.0 0.0 4.0 0.0\n6.0 2.0 8.0 -8.0 -0.0 -0.0 0.0 2.0\n6.0 2.0 12.0 -8.0 -0.0 -0.0 4.0 2.0\n6.0 0.0 12.0 -8.0 -0.0 -0.0 4.0 0.0\n9.0 2.0 8.0 8.0 0.0 0.0 0.0 2.0\n9.0 0.0 8.0 8.0 0.0 0.0 0.0 0.0\n9.0 0.0 12.0 8.0 0.0 0.0 4.0 0.0\n9.0 2.0 8.0 -8.0 -0.0 -0.0 0.0 2.0\n9.0 2.0 12.0 -8.0 -0.0 -0.0 4.0 2.0\n9.0 0.0 12.0 -8.0 -0.0 -0.0 4.0 0.0\n6.0 2.0 12.0 0.0 0.0 -6.0 0.0 2.0\n6.0 0.0 12.0 0.0 0.0 -6.0 0.0 0.0\n9.0 0.0 12.0 0.0 0.0 -6.0 3.0 0.0\n6.0 2.0 12.0 0.0 0.0 6.0 0.0 2.0\n9.0 2.0 12.0 0.0 0.0 6.0 3.0 2.0\n9.0 0.0 12.0 0.0 0.0 6.0 3.0 0.0\n6.0 2.0 12.0 0.0 0.0 -0.6000004 0.0 2.0\n6.0 0.0 12.0 0.0 0.0 -0.6000004 0.0 0.0\n6.3 0.0 12.0 0.0 0.0 -0.6000004 0.3000002 0.0\n6.0 2.0 12.0 0.0 0.0 0.6000004 0.0 2.0\n6.3 2.0 12.0 0.0 0.0 0.6000004 0.3000002 2.0\n6.3 0.0 12.0 0.0 0.0 0.6000004 0.3000002 0.0\n6.3 2.0 12.0 0.0 0.0 -0.45 0.3000002 2.0\n6.3 1.1 12.0 0.0 0.0 -0.45 0.3000002 1.1\n6.8 1.1 12.0 0.0 0.0 -0.45 0.8000002 1.1\n6.3 2.0 12.0 0.0 0.0 0.45 0.3000002 2.0\n6.8 2.0 12.0 0.0 0.0 0.45 0.8000002 2.0\n6.8 1.1 12.0 0.0 0.0 0.45 0.8000002 1.1\n6.3 0.6 12.0 0.0 0.0 -0.3 0.3000002 0.6\n6.3 0.0 12.0 0.0 0.0 -0.3 0.3000002 0.0\n6.8 0.0 12.0 0.0 0.0 -0.3 0.8000002 0.0\n6.3 0.6 12.0 0.0 0.0 0.3 0.3000002 0.6\n6.8 0.6 12.0 0.0 0.0 0.3 0.8000002 0.6\n6.8 0.0 12.0 0.0 0.0 0.3 0.8000002 0.0\n6.8 2.0 12.0 0.0 0.0 -4.3999996 0.8000002 2.0\n6.8 0.0 12.0 0.0 0.0 -4.3999996 0.8000002 0.0\n9.0 0.0 12.0 0.0 0.0 -4.3999996 3.0 0.0\n6.8 2.0 12.0 0.0 0.0 4.3999996 0.8000002 2.0\n9.0 2.0 12.0 0.0 0.0 4.3999996 3.0 2.0\n9.0 0.0 12.0 0.0 0.0 4.3999996 3.0 0.0\n6.0 2.0 12.0 8.0 0.0 0.0 0.0 2.0\n6.0 0.0 12.0 8.0 0.0 0.0 0.0 0.0\n6.0 0.0 16.0 8.0 0.0 0.0 4.0 0.0\n6.0 2.0 12.0 -8.0 -0.0 -0.0 0.0 2.0\n6.0 2.0 16.0 -8.0 -0.0 -0.0 4.0 2.0\n6.0 0.0 16.0 -8.0 -0.0 -0.0 4.0 0.0\n9.0 2.0 12.0 8.0 0.0 0.0 0.0 2.0\n9.0 0.0 12.0 8.0 0.0 0.0 0.0 0.0\n9.0 0.0 16.0 8.0 0.0 0.0 4.0 0.0\n9.0 2.0 12.0 -8.0 -0.0 -0.0 0.0 2.0\n9.0 2.0 16.0 -8.0 -0.0 -0.0 4.0 2.0\n9.0 0.0 16.0 -8.0 -0.0 -0.0 4.0 0.0\n6.0 2.0 16.0 0.0 0.0 -6.0 0.0 2.0\n6.0 0.0 16.0 0.0 0.0 -6.0 0.0 0.0\n9.0 0.0 16.0 0.0 0.0 -6.0 3.0 0.0\n6.0 2.0 16.0 0.0 0.0 6.0 0.0 2.0\n9.0 2.0 16.0 0.0 0.0 6.0 3.0 2.0\n9.0 0.0 16.0 0.0 0.0 6.0 3.0 0.0\n6.0 2.0 16.0 0.0 0.0 -0.6000004 0.0 2.0\n6.0 0.0 16.0 0.0 0.0 -0.6000004 0.0 0.0\n6.3 0.0 16.0 0.0 0.0 -0.6000004 0.3000002 0.0\n6.0 2.0 16.0 0.0 0.0 0.6000004 0.0 2.0\n6.3 2.0 16.0 0.0 0.0 0.6000004 0.3000002 2.0\n6.3 0.0 16.0 0.0 0.0 0.6000004 0.3000002 0.0\n6.3 2.0 16.0 0.0 0.0 -0.45 0.3000002 2.0\n6.3 1.1 16.0 0.0 0.0 -0.45 0.3000002 1.1\n6.8 1.1 16.0 0.0 0.0 -0.45 0.8000002 1.1\n6.3 2.0 16.0 0.0 0.0 0.45 0.3000002 2.0\n6.8 2.0 16.0 0.0 0.0 0.45 0.8000002 2.0\n6.8 1.1 16.0 0.0 0.0 0.45 0.8000002 1.1\n6.3 0.6 16.0 0.0 0.0 -0.3 0.3000002 0.6\n6.3 0.0 16.0 0.0 0.0 -0.3 0.3000002 0.0\n6.8 0.0 16.0 0.0 0.0 -0.3 0.8000002 0.0\n6.3 0.6 16.0 0.0 0.0 0.3 0.3000002 0.6\n6.8 0.6 16.0 0.0 0.0 0.3 0.8000002 0.6\n6.8 0.0 16.0 0.0 0.0 0.3 0.8000002 0.0\n6.8 2.0 16.0 0.0 0.0 -4.3999996 0.8000002 2.0\n6.8 0.0 16.0 0.0 0.0 -4.3999996 0.8000002 0.0\n9.0 0.0 16.0 0.0 0.0 -4.3999996 3.0 0.0\n6.8 2.0 16.0 0.0 0.0 4.3999996 0.8000002 2.0\n9.0 2.0 16.0 0.0 0.0 4.3999996 3.0 2.0\n9.0 0.0 16.0 0.0 0.0 4.3999996 3.0 0.0\n6.0 2.0 16.0 8.0 0.0 0.0 0.0 2.0\n6.0 0.0 16.0 8.0 0.0 0.0 0.0 0.0\n6.0 0.0 20.0 8.0 0.0 0.0 4.0 0.0\n6.0 2.0 16.0 -8.0 -0.0 -0.0 0.0 2.0\n6.0 2.0 20.0 -8.0 -0.0 -0.0 4.0 2.0\n6.0 0.0 20.0 -8.0 -0.0 -0.0 4.0 0.0\n9.0 2.0 16.0 8.0 0.0 0.0 0.0 2.0\n9.0 0.0 16.0 8.0 0.0 0.0 0.0 0.0\n9.0 0.0 20.0 8.0 0.0 0.0 4.0 0.0\n9.0 2.0 16.0 -8.0 -0.0 -0.0 0.0 2.0\n9.0 2.0 20.0 -8.0 -0.0 -0.0 4.0 2.0\n9.0 0.0 20.0 -8.0 -0.0 -0.0 4.0 0.0\n6.0 2.0 20.0 0.0 0.0 -6.0 0.0 2.0\n6.0 0.0 20.0 0.0 0.0 -6.0 0.0 0.0\n9.0 0.0 20.0 0.0 0.0 -6.0 3.0 0.0\n6.0 2.0 20.0 0.0 0.0 6.0 0.0 2.0\n9.0 2.0 20.0 0.0 0.0 6.0 3.0 2.0\n9.0 0.0 20.0 0.0 0.0 6.0 3.0 0.0\n6.0 2.0 24.0 0.0 0.0 -0.6000004 0.0 2.0\n6.0 0.0 24.0 0.0 0.0 -0.6000004 0.0 0.0\n6.3 0.0 24.0 0.0 0.0 -0.6000004 0.3000002 0.0\n6.0 2.0 24.0 0.0 0.0 0.6");
        builder.append("000004 0.0 2.0\n6.3 2.0 24.0 0.0 0.0 0.6000004 0.3000002 2.0\n6.3 0.0 24.0 0.0 0.0 0.6000004 0.3000002 0.0\n6.3 2.0 24.0 0.0 0.0 -0.45 0.3000002 2.0\n6.3 1.1 24.0 0.0 0.0 -0.45 0.3000002 1.1\n6.8 1.1 24.0 0.0 0.0 -0.45 0.8000002 1.1\n6.3 2.0 24.0 0.0 0.0 0.45 0.3000002 2.0\n6.8 2.0 24.0 0.0 0.0 0.45 0.8000002 2.0\n6.8 1.1 24.0 0.0 0.0 0.45 0.8000002 1.1\n6.3 0.6 24.0 0.0 0.0 -0.3 0.3000002 0.6\n6.3 0.0 24.0 0.0 0.0 -0.3 0.3000002 0.0\n6.8 0.0 24.0 0.0 0.0 -0.3 0.8000002 0.0\n6.3 0.6 24.0 0.0 0.0 0.3 0.3000002 0.6\n6.8 0.6 24.0 0.0 0.0 0.3 0.8000002 0.6\n6.8 0.0 24.0 0.0 0.0 0.3 0.8000002 0.0\n6.8 2.0 24.0 0.0 0.0 -4.3999996 0.8000002 2.0\n6.8 0.0 24.0 0.0 0.0 -4.3999996 0.8000002 0.0\n9.0 0.0 24.0 0.0 0.0 -4.3999996 3.0 0.0\n6.8 2.0 24.0 0.0 0.0 4.3999996 0.8000002 2.0\n9.0 2.0 24.0 0.0 0.0 4.3999996 3.0 2.0\n9.0 0.0 24.0 0.0 0.0 4.3999996 3.0 0.0\n6.0 2.0 24.0 8.0 0.0 0.0 0.0 2.0\n6.0 0.0 24.0 8.0 0.0 0.0 0.0 0.0\n6.0 0.0 28.0 8.0 0.0 0.0 4.0 0.0\n6.0 2.0 24.0 -8.0 -0.0 -0.0 0.0 2.0\n6.0 2.0 28.0 -8.0 -0.0 -0.0 4.0 2.0\n6.0 0.0 28.0 -8.0 -0.0 -0.0 4.0 0.0\n9.0 2.0 24.0 8.0 0.0 0.0 0.0 2.0\n9.0 0.0 24.0 8.0 0.0 0.0 0.0 0.0\n9.0 0.0 28.0 8.0 0.0 0.0 4.0 0.0\n9.0 2.0 24.0 -8.0 -0.0 -0.0 0.0 2.0\n9.0 2.0 28.0 -8.0 -0.0 -0.0 4.0 2.0\n9.0 0.0 28.0 -8.0 -0.0 -0.0 4.0 0.0\n6.0 2.0 28.0 0.0 0.0 -6.0 0.0 2.0\n6.0 0.0 28.0 0.0 0.0 -6.0 0.0 0.0\n9.0 0.0 28.0 0.0 0.0 -6.0 3.0 0.0\n6.0 2.0 28.0 0.0 0.0 6.0 0.0 2.0\n9.0 2.0 28.0 0.0 0.0 6.0 3.0 2.0\n9.0 0.0 28.0 0.0 0.0 6.0 3.0 0.0\n9.0 2.0 0.0 0.0 0.0 -0.6000004 0.0 2.0\n9.0 0.0 0.0 0.0 0.0 -0.6000004 0.0 0.0\n9.3 0.0 0.0 0.0 0.0 -0.6000004 0.3000002 0.0\n9.0 2.0 0.0 0.0 0.0 0.6000004 0.0 2.0\n9.3 2.0 0.0 0.0 0.0 0.6000004 0.3000002 2.0\n9.3 0.0 0.0 0.0 0.0 0.6000004 0.3000002 0.0\n9.3 2.0 0.0 0.0 0.0 -0.45 0.3000002 2.0\n9.3 1.1 0.0 0.0 0.0 -0.45 0.3000002 1.1\n9.8 1.1 0.0 0.0 0.0 -0.45 0.8000002 1.1\n9.3 2.0 0.0 0.0 0.0 0.45 0.3000002 2.0\n9.8 2.0 0.0 0.0 0.0 0.45 0.8000002 2.0\n9.8 1.1 0.0 0.0 0.0 0.45 0.8000002 1.1\n9.3 0.6 0.0 0.0 0.0 -0.3 0.3000002 0.6\n9.3 0.0 0.0 0.0 0.0 -0.3 0.3000002 0.0\n9.8 0.0 0.0 0.0 0.0 -0.3 0.8000002 0.0\n9.3 0.6 0.0 0.0 0.0 0.3 0.3000002 0.6\n9.8 0.6 0.0 0.0 0.0 0.3 0.8000002 0.6\n9.8 0.0 0.0 0.0 0.0 0.3 0.8000002 0.0\n9.8 2.0 0.0 0.0 0.0 -4.3999996 0.8000002 2.0\n9.8 0.0 0.0 0.0 0.0 -4.3999996 0.8000002 0.0\n12.0 0.0 0.0 0.0 0.0 -4.3999996 3.0 0.0\n9.8 2.0 0.0 0.0 0.0 4.3999996 0.8000002 2.0\n12.0 2.0 0.0 0.0 0.0 4.3999996 3.0 2.0\n12.0 0.0 0.0 0.0 0.0 4.3999996 3.0 0.0\n9.0 2.0 0.0 8.0 0.0 0.0 0.0 2.0\n9.0 0.0 0.0 8.0 0.0 0.0 0.0 0.0\n9.0 0.0 4.0 8.0 0.0 0.0 4.0 0.0\n9.0 2.0 0.0 -8.0 -0.0 -0.0 0.0 2.0\n9.0 2.0 4.0 -8.0 -0.0 -0.0 4.0 2.0\n9.0 0.0 4.0 -8.0 -0.0 -0.0 4.0 0.0\n12.0 2.0 0.0 8.0 0.0 0.0 0.0 2.0\n12.0 0.0 0.0 8.0 0.0 0.0 0.0 0.0\n12.0 0.0 4.0 8.0 0.0 0.0 4.0 0.0\n12.0 2.0 0.0 -8.0 -0.0 -0.0 0.0 2.0\n12.0 2.0 4.0 -8.0 -0.0 -0.0 4.0 2.0\n12.0 0.0 4.0 -8.0 -0.0 -0.0 4.0 0.0\n9.0 2.0 4.0 0.0 0.0 -6.0 0.0 2.0\n9.0 0.0 4.0 0.0 0.0 -6.0 0.0 0.0\n12.0 0.0 4.0 0.0 0.0 -6.0 3.0 0.0\n9.0 2.0 4.0 0.0 0.0 6.0 0.0 2.0\n12.0 2.0 4.0 0.0 0.0 6.0 3.0 2.0\n12.0 0.0 4.0 0.0 0.0 6.0 3.0 0.0\n9.0 2.0 24.0 0.0 0.0 -0.6000004 0.0 2.0\n9.0 0.0 24.0 0.0 0.0 -0.6000004 0.0 0.0\n9.3 0.0 24.0 0.0 0.0 -0.6000004 0.3000002 0.0\n9.0 2.0 24.0 0.0 0.0 0.6000004 0.0 2.0\n9.3 2.0 24.0 0.0 0.0 0.6000004 0.3000002 2.0\n9.3 0.0 24.0 0.0 0.0 0.6000004 0.3000002 0.0\n9.3 2.0 24.0 0.0 0.0 -0.45 0.3000002 2.0\n9.3 1.1 24.0 0.0 0.0 -0.45 0.3000002 1.1\n9.8 1.1 24.0 0.0 0.0 -0.45 0.8000002 1.1\n9.3 2.0 24.0 0.0 0.0 0.45 0.3000002 2.0\n9.8 2.0 24.0 0.0 0.0 0.45 0.8000002 2.0\n9.8 1.1 24.0 0.0 0.0 0.45 0.8000002 1.1\n9.3 0.6 24.0 0.0 0.0 -0.3 0.3000002 0.6\n9.3 0.0 24.0 0.0 0.0 -0.3 0.3000002 0.0\n9.8 0.0 24.0 0.0 0.0 -0.3 0.8000002 0.0\n9.3 0.6 24.0 0.0 0.0 0.3 0.3000002 0.6\n9.8 0.6 24.0 0.0 0.0 0.3 0.8000002 0.6\n9.8 0.0 24.0 0.0 0.0 0.3 0.8000002 0.0\n9.8 2.0 24.0 0.0 0.0 -4.3999996 0.8000002 2.0\n9.8 0.0 24.0 0.0 0.0 -4.3999996 0.8000002 0.0\n12.0 0.0 24.0 0.0 0.0 -4.3999996 3.0 0.0\n9.8 2.0 24.0 0.0 0.0 4.3999996 0.8000002 2.0\n12.0 2.0 24.0 0.0 0.0 4.3999996 3.0 2.0\n12.0 0.0 24.0 0.0 0.0 4.3999996 3.0 0.0\n9.0 2.0 24.0 8.0 0.0 0.0 0.0 2.0\n9.0 0.0 24.0 8.0 0.0 0.0 0.0 0.0\n9.0 0.0 28.0 8.0 0.0 0.0 4.0 0.0\n9.0 2.0 24.0 -8.0 -0.0 -0.0 0.0 2.0\n9.0 2.0 28.0 -8.0 -0.0 -0.0 4.0 2.0\n9.0 0.0 28.0 -8.0 -0.0 -0.0 4.0 0.0\n12.0 2.0 24.0 8.0 0.0 0.0 0.0 2.0\n12.0 0.0 24.0 8.0 0.0 0.0 0.0 0.0\n12.0 0.0 28.0 8.0 0.0 0.0 4.0 0.0\n12.0 2.0 24.0 -8.0 -0.0 -0.0 0.0 2.0\n12.0 2.0 28.0 -8.0 -0.0 -0.0 4.0 2.0\n12.0 0.0 28.0 -8.0 -0.0 -0.0 4.0 0.0\n9.0 2.0 28.0 0.0 0.0 -6.0 0.0 2.0\n9.0 0.0 28.0 0.0 0.0 -6.0 0.0 0.0\n12.0 0.0 28.0 0.0 0.0 -6.0 3.0 0.0\n9.0 2.0 28.0 0.0 0.0 6.0 0.0 2.0\n12.0 2.0 28.0 0.0 0.0 6.0 3.0 2.0\n12.0 0.0 28.0 0.0 0.0 6.0 3.0 0.0\n12.0 2.0 0.0 0.0 0.0 -0.6000004 0.0 2.0\n12.0 0.0 0.0 0.0 0.0 -0.6000004 0.0 0.0\n12.3 0.0 0.0 0.0 0.0 -0.6000004 0.3000002 0.0\n12.0 2.0 0.0 0.0 0.0 0.6000004 0.0 2.0\n12.3 2.0 0.0 0.0 0.0 0.6000004 0.3000002 2.0\n12.3 0.0 0.0 0.0 0.0 0.6000004 0.3000002 0.0\n12.3 2.0 0.0 0.0 0.0 -0.45 0.3000002 2.0\n12.3 1.1 0.0 0.0 0.0 -0.45 0.3000002 1.1\n12.8 1.1 0.0 0.0 0.0 -0.45 0.8000002 1.1\n12.3 2.0 0.0 0.0 0.0 0.45 0.3000002 2.0\n12.8 2.0 0.0 0.0 0.0 0.45 0.8000002 2.0\n12.8 1.1 0.0 0.0 0.0 0.45 0.8000002 1.1\n12.3 0.6 0.0 0.0 0.0 -0.3 0.3000002 0.6\n12.3 0.0 0.0 0.0 0.0 -0.3 0.3000002 0.0\n12.8 0.0 0.0 0.0 0.0 -0.3 0.8000002 0.0\n12.3 0.6 0.0 0.0 0.0 0.3 0.3000002 0.6\n12.8 0.6 0.0 0.0 0.0 0.3 0.8000002 0.6\n12.8 0.0 0.0 0.0 0.0 0.3 0.8000002 0.0\n12.8 2.0 0.0 0.0 0.0 -4.3999996 0.8000002 2.0\n12.8 0.0 0.0 0.0 0.0 -4.3999996 0.8000002 0.0\n15.0 0.0 0.0 0.0 0.0 -4.3999996 3.0 0.0\n12.8 2.0 0.0 0.0 0.0 4.3999996 0.8000002 2.0\n15.0 2.0 0.0 0.0 0.0 4.3999996 3.0 2.0\n15.0 0.0 0.0 0.0 0.0 4.3999996 3.0 0.0\n12.0 2.0 0.0 8.0 0.0 0.0 0.0 2.0\n12.0 0.0 0.0 8.0 0.0 0.0 0.0 0.0\n12.0 0.0 4.0 8.0 0.0 0.0 4.0 0.0\n12.0 2.0 0.0 -8.0 -0.0 -0.0 0.0 2.0\n12.0 2.0 4.0 -8.0 -0.0 -0.0 4.0 2.0\n12.0 0.0 4.0 -8.0 -0.0 -0.0 4.0 0.0\n15.0 2.0 0.0 8.0 0.0 0.0 0.0 2.0\n15.0 0.0 0.0 8.0 0.0 0.0 0.0 0.0\n15.0 0.0 4.0 8.0 0.0 0.0 4.0 0.0\n15.0 2.0 0.0 -8.0 -0.0 -0.0 0.0 2.0\n15.0 2.0 4.0 -8.0 -0.0 -0.0 4.0 2.0\n15.0 0.0 4.0 -8.0 -0.0 -0.0 4.0 0.0\n12.0 2.0 4.0 0.0 0.0 -6.0 0.0 2.0\n12.0 0.0 4.0 0.0 0.0 -6.0 0.0 0.0\n15.0 0.0 4.0 0.0 0.0 -6.0 3.0 0.0\n12.0 2.0 4.0 0.0 0.0 6.0 0.0 2.0\n15.0 2.0 4.0 0.0 0.0 6.0 3.0 2.0\n15.0 0.0 4.0 0.0 0.0 6.0 3.0 0.0\n12.0 2.0 8.0 0.0 0.0 -0.6000004 0.0 2.0\n12.0 0.0 8.0 0.0 0.0 -0.6000004 0.0 0.0\n12.3 0.0 8.0 0.0 0.0 -0.6000004 0.3000002 0.0\n12.0 2.0 8.0 0.0 0.0 0.6000004 0.0 2.0\n12.3 2.0 8.0 0.0 0.0 0.6000004 0.3000002 2.0\n12.3 0.0 8.0 0.0 0.0 0.6000004 0.3000002 0.0\n12.3 2.0 8.0 0.0 0.0 -0.45 0.3000002 2.0\n12.3 1.1 8.0 0.0 0.0 -0.45 0.3000002 1.1\n12.8 1.1 8.0 0.0 0.0 -0.45 0.8000002 1.1\n12.3 2.0 8.0 0.0 0.0 0.45 0.3000002 2.0\n12.8 2.0 8.0 0.0 0.0 0.45 0.8000002 2.0\n12.8 1.1 8.0 0.0 0.0 0.45 0.8000002 1.1\n12.3 0.6 8.0 0.0 0.0 -0.3 0.3000002 0.6\n12.3 0.0 8.0 0.0 0.0 -0.3 0.3000002 0.0\n12.8 0.0 8.0 0.0 0.0 -0.3 0.8000002 0.0\n12.3 0.6 8.0 0.0 0.0 0.3 0.3000002 0.6\n12.8 0.6 8.0 0.0 0.0 0.3 0.8000002 0.6\n12.8 0.0 8.0 0.0 0.0 0.3 0.8000002 0.0\n12.8 2.0 8.0 0.0 0.0 -4.3999996 0.8000002 2.0\n12.8 0.0 8.0 0.0 0.0 -4.3999996 0.8000002 0.0\n15.0 0.0 8.0 0.0 0.0 -4.3999996 3.0 0.0\n12.8 2.0 8.0 0.0 0.0 4.3999996 0.8000002 2.0\n15.0 2.0 8.0 0.0 0.0 4.3999996 3.0 2.0\n15.0 0.0 8.0 0.0 0.0 4.3999996 3.0 0.0\n12.0 2.0 8.0 8.0 0.0 0.0 0.0 2.0\n12.0 0.0 8.0 8.0 0.0 0.0 0.0 0.0\n12.0 0.0 12.0 8.0 0.0 0.0 4.0 0.0\n12.0 2.0 8.0 -8.0 -0.0 -0.0 0.0 2.0\n12.0 2.0 12.0 -8.0 -0.0 -0.0 4.0 2.0\n12.0 0.0 12.0 -8.0 -0.0 -0.0 4.0 0.0\n15.0 2.0 8.0 8.0 0.0 0.0 0.0 2.0\n15.0 0.0 8.0 8.0 0.0 0.0 0.0 0.0\n15.0 0.0 12.0 8.0 0.0 0.0 4.0 0.0\n15.0 2.0 8.0 -8.0 -0.0 -0.0 0.0 2.0\n15.0 2.0 12.0 -8.0 -0.0 -0.0 4.0 2.0\n15.0 0.0 12.0 -8.0 -0.0 -0.0 4.0 0.0\n12.0 2.0 12.0 0.0 0.0 -6.0 0.0 2.0\n12.0 0.0 12.0 0.0 0.0 -6.0 0.0 0.0\n15.0 0.0 12.0 0.0 0.0 -6.0 3.0 0.0\n12.0 2.0 12.0 0.0 0.0 6.0 0.0 2.0\n15.0 2.0 12.0 0.0 0.0 6.0 3.0 2.0\n15.0 0.0 12.0 0.0 0.0 6.0 3.0 0.0\n12.0 2.0 12.0 0.0 0.0 -0.6000004 0.0 2.0\n12.0 0.0 12.0 0.0 0.0 -0.6000004 0.0 0.0\n12.3 0.0 12.0 0.0 0.0 -0.6000004 0.3000002 0.0\n12.0 2.0 12.0 0.0 0.0 0.6000004 0.0 2.0\n12.3 2.0 12.0 0.0 0.0 0.6000004 0.3000002 2.0\n12.3 0.0 12.0 0.0 0.0 0.6000004 0.3000002 0.0\n12.3 2.0 12.0 0.0 0.0 -0.45 0.3000002 2.0\n12.3 1.1 12.0 0.0 0.0 -0.45 0.3000002 1.1\n12.8 1.1 12.0 0.0 0.0 -0.45 0.8000002 1.1\n12.3 2.0 12.0 0.0 0.0 0.45 0.3000002 2.0\n12.8 2.0 12.0 0.0 0.0 0.45 0.8000002 2.0\n12.8 1.1 12.0 0.0 0.0 0.45 0.8000002 1.1\n12.3 0.6 12.0 0.0 0.0 -0.3 0.3000002 0.6\n12.3 0.0 12.0 0.0 0.0 -0.3 0.3000002 0.0\n12.8 0.0 12.0 0.0 0.0 -0.3 0.8000002 0.0\n12.3 0.6 12.0 0.0 0.0 0.3 0.3000002 0.6\n12.8 0.6 12.0 0.0 0.0 0.3 0.8000002 0.6\n12.8 0.0 12.0 0.0 0.0 0.3 0.8000002 0.0\n12.8 2.0 12.0 0.0 0.0 -4.3999996 0.8000002 2.0\n12.8 0.0 12.0 0.0 0.0 -4.3999996 0.8000002 0.0\n15.0 0.0 12.0 0.0 0.0 -4.3999996 3.0 0.0\n12.8 2.0 12.0 0.0 0.0 4.3999996 0.8000002 2.0\n15.0 2.0 12.0 0.0 0.0 4.3999996 3.0 2.0\n15.0 0.0 12.0 0.0 0.0 4.3999996 3.0 0.0\n12.0 2.0 12.0 8.0 0.0 0.0 0.0 2.0\n12.0 0.0 12.0 8.0 0.0 0.0 0.0 0.0\n12.0 0.0 16.0 8.0 0.0 0.0 4.0 0.0\n12.0 2.0 12.0 -8.0 -0.0 -0.0 0.0 2.0\n12.0 2.0 16.0 -8.0 -0.0 -0.0 4.0 2.0\n12.0 0.0 16.0 -8.0 -0.0 -0.0 4.0 0.0\n15.0 2.0 12.0 8.0 0.0 0.0 0.0 2.0\n15.0 0.0 12.0 8.0 0.0 0.0 0.0 0.0\n15.0 0.0 16.0 8.0 0.0 0.0 4.0 0.0\n15.0 2.0 12.0 -8.0 -0.0 -0.0 0.0 2.0\n15.0 2.0 16.0 -8.0 -0.0 -0.0 4.0 2.0\n15.0 0.0 16.0 -8.0 -0.0 -0.0 4.0 0.0\n12.0 2.0 16.0 0.0 0.0 -6.0 0.0 2.0\n12.0 0.0 16.0 0.0 0.0 -6.0 0.0 0.0\n15.0 0.0 16.0 0.0 0.0 -6.0 3.0 0.0\n12.0 2.0 16.0 0.0 0.0 6.0 0.0 2.0\n15.0 2.0 16.0 0.0 0.0 6.0 3.0 2.0\n15.0 0.0 16.0 0.0 0.0 6.0 3.0 0.0\n12.0 2.0 16.0 0.0 0.0 -0.6000004 0.0 2.0\n12.0 0.0 16.0 0.0 0.0 -0.6000004 0.0 0.0\n12.3 0.0 16.0 0.0 0.0 -0.6000004 0.3000002 0.0\n12.0 2.0 16.0 0.0 0.0 0.6000004 0.0 2.0\n12.3 2.0 16.0 0.0 0.0 0.6000004 0.3000002 2.0\n12.3 0.0 16.0 0.0 0.0 0.6000004 0.3000002 0.0\n12.3 2.0 16.0 0.0 0.0 -0.45 0.3000002 2.0\n12.3 1.1 16.0 0.0 0.0 -0.45 0.3000002 1.1\n12.8 1.1 16.0 0.0 0.0 -0.45 0.8000002 1.1\n12.3 2.0 16.0 0.0 0.0 0.45 0.3000002 2.0\n12.8 2.0 16.0 0.0 0.0 0.45 0.8000002 2.0\n12.8 1.1 16.0 0.0 0.0 0.45 0.8000002 1.1\n12.3 0.6 16.0 0.0 0.0 -0.3 0.3000002 0.6\n12.3 0.0 16.0 0.0 0.0 -0.3 0.3000002 0.0\n12.8 0.0 16.0 0.0 0.0 -0.3 0.8000002 0.0\n12.3 0.6 16.0 0.0 0.0 0.3 0.3000002 0.6\n12.8 0.6 16.0 0.0 0.0 0.3 0.8000002 0.6\n12.8 0.0 16.0 0.0 0.0 0.3 0.8000002 0.0\n12.8 2.0 16.0 0.0 0.0 -4.3999996 0.8000002 2.0\n12.8 0.0 16.0 0.0 0.0 -4.3999996 0.8000002 0.0\n15.0 0.0 16.0 0.0 0.0 -4.3999996 3.0 0.0\n12.8 2.0 16.0 0.0 0.0 4.3999996 0.8000002 2.0\n15.0 2.0 16.0 0.0 0.0 4.3999996 3.0 2.0\n15.0 0.0 16.0 0.0 0.0 4.3999996 3.0 0.0\n12.0 2.0 16.0 8.0 0.0 0.0 0.0 2.0\n12.0 0.0 16.0 8.0 0.0 0.0 0.0 0.0\n12.0 0.0 20.0 8.0 0.0 0.0 4.0 0.0\n12.0 2.0 16.0 -8.0 -0.0 -0.0 0.0 2.0\n12.0 2.0 20.0 -8.0 -0.0 -0.0 4.0 2.0\n12.0 0.0 20.0 -8.0 -0.0 -0.0 4.0 0.0\n15.0 2.0 16.0 8.0 0.0 0.0 0.0 2.0\n15.0 0.0 16.0 8.0 0.0 0.0 0.0 0.0\n15.0 0.0 20.0 8.0 0.0 0.0 4.0 0.0\n15.0 2.0 16.0 -8.0 -0.0 -0.0 0.0 2.0\n15.0 2.0 20.0 -8.0 -0.0 -0.0 4.0 2.0\n15.0 0.0 20.0 -8.0 -0.0 -0.0 4.0 0.0\n12.0 2.0 20.0 0.0 0.0 -6.0 0.0 2.0\n12.0 0.0 20.0 0.0 0.0 -6.0 0.0 0.0\n15.0 0.0 20.0 0.0 0.0 -6.0 3.0 0.0\n12.0 2.0 20.0 0.0 0.0 6.0 0.0 2.0\n15.0 2.0 20.0 0.0 0.0 6.0 3.0 2.0\n15.0 0.0 20.0 0.0 0.0 6.0 3.0 0.0\n12.0 2.0 24.0 0.0 0.0 -0.6000004 0.0 2.0\n12.0 0.0 24.0 0.0 0.0 -0.6000004 0.0 0.0\n12.3 0.0 24.0 0.0 0.0 -0.6000004 0.3000002 0.0\n12.0 2.0 24.0 0.0 0.0 0.6000004 0.0 2.0\n12.3 2.0 24.0 0.0 0.0 0.6000004 0.3000002 2.0\n12.3 0.0 24.0 0.0 0.0 0.6000004 0.3000002 0.0\n12.3 2.0 24.0 0.0 0.0 -0.45 0.3000002 2.0\n12.3 1.1 24.0 0.0 0.0 -0.45 0.3000002 1.1\n12.8 1.1 24.0 0.0 0.0 -0.45 0.8000002 1.1\n12.3 2.0 24.0 0.0 0.0 0.45 0.3000002 2.0\n12.8 2.0 24.0 0.0 0.0 0.45 0.8000002 2.0\n12.8 1.1 24.0 0.0 0.0 0.45 0.8000002 1.1\n12.3 0.6 24.0 0.0 0.0 -0.3 0.3000002 0.6\n12.3 0.0 24.0 0.0 0.0 -0.3 0.3000002 0.0\n12.8 0.0 24.0 0.0 0.0 -0.3 0.8000002 0.0\n12.3 0.6 24.0 0.0 0.0 0.3 0.3000002 0.6\n12.8 0.6 24.0 0.0 0.0 0.3 0.8000002 0.6\n12.8 0.0 24.0 0.0 0.0 0.3 0.8000002 0.0\n12.8 2.0 24.0 0.0 0.0 -4.3999996 0.8000002 2.0\n12.8 0.0 24.0 0.0 0.0 -4.3999996 0.8000002 0.0\n15.0 0.0 24.0 0.0 0.0 -4.3999996 3.0 0.0\n12.8 2.0 24.0 0.0 0.0 4.3999996 0.8000002 2.0\n15.0 2.0 24.0 0.0 0.0 4.3999996 3.0 2.0\n15.0 0.0 24.0 0.0 0.0 4.3999996 3.0 0.0\n12.0 2.0 24.0 8.0 0.0 0.0 0.0 2.0\n12.0 0.0 24.0 8.0 0.0 0.0 0.0 0.0\n12.0 0.0 28.0 8.0 0.0 0.0 4.0 0.0\n12.0 2.0 24.0 -8.0 -0.0 -0.0 0.0 2.0\n12.0 2.0 28.0 -8.0 -0.0 -0.0 4.0 2.0\n12.0 0.0 28.0 -8.0 -0.0 -0.0 4.0 0.0\n15.0 2.0 24.0 8.0 0.0 0.0 0.0 2.0\n15.0 0.0 24.0 8.0 0.0 0.0 0.0 0.0\n15.0 0.0 28.0 8.0 0.0 0.0 4.0 0.0\n15.0 2.0 24.0 -8.0 -0.0 -0.0 0.0 2.0\n15.0 2.0 28.0 -8.0 -0.0 -0.0 4.0 2.0\n15.0 0.0 28.0 -8.0 -0.0 -0.0 4.0 0.0\n12.0 2.0 28.0 0.0 0.0 -6.0 0.0 2.0\n12.0 0.0 28.0 0.0 0.0 -6.0 0.0 0.0\n15.0 0.0 28.0 0.0 0.0 -6.0 3.0 0.0\n12.0 2.0 28.0 0.0 0.0 6.0 0.0 2.0\n15.0 2.0 28.0 0.0 0.0 6.0 3.0 2.0\n15.0 0.0 28.0 0.0 0.0 6.0 3.0 0.0\n15.0 2.0 0.0 0.0 0.0 -0.6000004 0.0 2.0\n15.0 0.0 0.0 0.0 0.0 -0.6000004 0.0 0.0\n15.3 0.0 0.0 0.0 0.0 -0.6000004 0.3000002 0.0\n15.0 2.0 0.0 0.0 0.0 0.6000004 0.0 2.0\n15.3 2.0 0.0 0.0 0.0 0.6000004 0.3000002 2.0\n15.3 0.0 0.0 0.0 0.0 0.6000004 0.3000002 0.0\n15.3 2.0 0.0 0.0 0.0 -0.45 0.3000002 2.0\n15.3 1.1 0.0 0.0 0.0 -0.45 0.3000002 1.1\n15.8 1.1 0.0 0.0 0.0 -0.45 0.8000002 1.1\n15.3 2.0 0.0 0.0 0.0 0.45 0.3000002 2.0\n15.8 2.0 0.0 0.0 0.0 0.45 0.8000002 2.0\n15.8 1.1 0.0 0.0 0.0 0.45 0.8000002 1.1\n15.3 0.6 0.0 0.0 0.0 -0.3 0.3000002 0.6\n15.3 0.0 0.0 0.0 0.0 -0.3 0.3000002 0.0\n15.8 0.0 0.0 0.0 0.0 -0.3 0.8000002 0.0\n15.3 0.6 0.0 0.0 0.0 0.3 0.3000002 0.6\n15.8 0.6 0.0 0.0 0.0 0.3 0.8000002 0.6\n15.8 0.0 0.0 0.0 0.0 0.3 0.8000002 0.0\n15.8 2.0 0.0 0.0 0.0 -10.4 0.8000002 2.0\n15.8 0.0 0.0 0.0 0.0 -10.4 0.8000002 0.0\n21.0 0.0 0.0 0.0 0.0 -10.4 6.0 0.0\n15.8 2.0 0.0 0.0 0.0 10.4 0.8000002 2.0\n21.0 2.0 0.0 0.0 0.0 10.4 6.0 2.0\n21.0 0.0 0.0 0.0 0.0 10.4 6.0 0.0\n15.0 2.0 0.0 8.0 0.0 0.0 0.0 2.0\n15.0 0.0 0.0 8.0 0.0 0.0 0.0 0.0\n15.0 0.0 4.0 8.0 0.0 0.0 4.0 0.0\n15.0 2.0 0.0 -8.0 -0.0 -0.0 0.0 2.0\n15.0 2.0 4.0 -8.0 -0.0 -0.0 4.0 2.0\n15.0 0.0 4.0 -8.0 -0.0 -0.0 4.0 0.0\n21.0 2.0 0.0 8.0 0.0 0.0 0.0 2.0\n21.0 0.0 0.0 8.0 0.0 0.0 0.0 0.0\n21.0 0.0 4.0 8.0 0.0 0.0 4.0 0.0\n21.0 2.0 0.0 -8.0 -0.0 -0.0 0.0 2.0\n21.0 2.0 4.0 -8.0 -0.0 -0.0 4.0 2.0\n21.0 0.0 4.0 -8.0 -0.0 -0.0 4.0 0.0\n15.0 2.0 4.0 0.0 0.0 -12.0 0.0 2.0\n15.0 0.0 4.0 0.0 0.0 -12.0 0.0 0.0\n21.0 0.0 4.0 0.0 0.0 -12.0 6.0 0.0\n15.0 2.0 4.0 0.0 0.0 12.0 0.0 2.0\n21.0 2.0 4.0 0.0 0.0 12.0 6.0 2.0\n21.0 0.0 4.0 0.0 0.0 12.0 6.0 0.0\n15.0 2.0 24.0 0.0 0.0 -0.6000004 0.0 2.0\n15.0 0.0 24.0 0.0 0.0 -0.6000004 0.0 0.0\n15.3 0.0 24.0 0.0 0.0 -0.6000004 0.3000002 0.0\n15.0 2.0 24.0 0.0 0.0 0.6000004 0.0 2.0\n15.3 2.0 24.0 0.0 0.0 0.6000004 0.3000002 2.0\n15.3 0.0 24.0 0.0 0.0 0.6000004 0.3000002 0.0\n15.3 2.0 24.0 0.0 0.0 -0.45 0.3000002 2.0\n15.3 1.1 24.0 0.0 0.0 -0.45 0.3000002 1.1\n15.8 1.1 24.0 0.0 0.0 -0.45 0.8000002 1.1\n15.3 2.0 24.0 0.0 0.0 0.45 0.3000002 2.0\n15.8 2.0 24.0 0.0 0.0 0.45 0.8000002 2.0\n15.8 1.1 24.0 0.0 0.0 0.45 0.8000002 1.1\n15.3 0.6 24.0 0.0 0.0 -0.3 0.3000002 0.6\n15.3 0.0 24.0 0.0 0.0 -0.3 0.3000002 0.0\n15.8 0.0 24.0 0.0 0.0 -0.3 0.8000002 0.0\n15.3 0.6 24.0 0.0 0.0 0.3 0.3000002 0.6\n15.8 0.6 24.0 0.0 0.0 0.3 0.8000002 0.6\n15.8 0.0 24.0 0.0 0.0 0.3 0.8000002 0.0\n15.8 2.0 24.0 0.0 0.0 -10.4 0.8000002 2.0\n15.8 0.0 24.0 0.0 0.0 -10.4 0.8000002 0.0\n21.0 0.0 24.0 0.0 0.0 -10.4 6.0 0.0\n15.8 2.0 24.0 0.0 0.0 10.4 0.8000002 2.0\n21.0 2.0 24.0 0.0 0.0 10.4 6.0 2.0\n21.0 0.0 24.0 0.0 0.0 10.4 6.0 0.0\n15.0 2.0 24.0 8.0 0.0 0.0 0.0 2.0\n15.0 0.0 24.0 8.0 0.0 0.0 0.0 0.0\n15.0 0.0 28.0 8.0 0.0 0.0 4.0 0.0\n15.0 2.0 24.0 -8.0 -0.0 -0.0 0.0 2.0\n15.0 2.0 28.0 -8.0 -0.0 -0.0 4.0 2.0\n15.0 0.0 28.0 -8.0 -0.0 -0.0 4.0 0.0\n21.0 2.0 24.0 8.0 0.0 0.0 0.0 2.0\n21.0 0.0 24.0 8.0 0.0 0.0 0.0 0.0\n21.0 0.0 28.0 8.0 0.0 0.0 4.0 0.0\n21.0 2.0 24.0 -8.0 -0.0 -0.0 0.0 2.0\n21.0 2.0 28.0 -8.0 -0.0 -0.0 4.0 2.0\n21.0 0.0 28.0 -8.0 -0.0 -0.0 4.0 0.0\n15.0 2.0 28.0 0.0 0.0 -12.0 0.0 2.0\n15.0 0.0 28.0 0.0 0.0 -12.0 0.0 0.0\n21.0 0.0 28.0 0.0 0.0 -12.0 6.0 0.0\n15.0 2.0 28.0 0.0 0.0 12.0 0.0 2.0\n21.0 2.0 28.0 0.0 0.0 12.0 6.0 2.0\n21.0 0.0 28.0 0.0 0.0 12.0 6.0 0.0\n18.0 2.0 4.0 0.0 0.0 -0.5999985 0.0 2.0\n18.0 0.0 4.0 0.0 0.0 -0.5999985 0.0 0.0\n18.3 0.0 4.0 0.0 0.0 -0.5999985 0.29999924 0.0\n18.0 2.0 4.0 0.0 0.0 0.5999985 0.0 2.0\n18.3 2.0 4.0 0.0 0.0 0.5999985 0.29999924 2.0\n18.3 0.0 4.0 0.0 0.0 0.5999985 0.29999924 0.0\n18.3 2.0 4.0 0.0 0.0 -0.45 0.29999924 2.0\n18.3 1.1 4.0 0.0 0.0 -0.45 0.29999924 1.1\n18.8 1.1 4.0 0.0 0.0 -0.45 ");
        builder.append("0.79999924 1.1\n18.3 2.0 4.0 0.0 0.0 0.45 0.29999924 2.0\n18.8 2.0 4.0 0.0 0.0 0.45 0.79999924 2.0\n18.8 1.1 4.0 0.0 0.0 0.45 0.79999924 1.1\n18.3 0.6 4.0 0.0 0.0 -0.3 0.29999924 0.6\n18.3 0.0 4.0 0.0 0.0 -0.3 0.29999924 0.0\n18.8 0.0 4.0 0.0 0.0 -0.3 0.79999924 0.0\n18.3 0.6 4.0 0.0 0.0 0.3 0.29999924 0.6\n18.8 0.6 4.0 0.0 0.0 0.3 0.79999924 0.6\n18.8 0.0 4.0 0.0 0.0 0.3 0.79999924 0.0\n18.8 2.0 4.0 0.0 0.0 -4.4000015 0.79999924 2.0\n18.8 0.0 4.0 0.0 0.0 -4.4000015 0.79999924 0.0\n21.0 0.0 4.0 0.0 0.0 -4.4000015 3.0 0.0\n18.8 2.0 4.0 0.0 0.0 4.4000015 0.79999924 2.0\n21.0 2.0 4.0 0.0 0.0 4.4000015 3.0 2.0\n21.0 0.0 4.0 0.0 0.0 4.4000015 3.0 0.0\n18.0 2.0 4.0 8.0 0.0 0.0 0.0 2.0\n18.0 0.0 4.0 8.0 0.0 0.0 0.0 0.0\n18.0 0.0 8.0 8.0 0.0 0.0 4.0 0.0\n18.0 2.0 4.0 -8.0 -0.0 -0.0 0.0 2.0\n18.0 2.0 8.0 -8.0 -0.0 -0.0 4.0 2.0\n18.0 0.0 8.0 -8.0 -0.0 -0.0 4.0 0.0\n21.0 2.0 4.0 8.0 0.0 0.0 0.0 2.0\n21.0 0.0 4.0 8.0 0.0 0.0 0.0 0.0\n21.0 0.0 8.0 8.0 0.0 0.0 4.0 0.0\n21.0 2.0 4.0 -8.0 -0.0 -0.0 0.0 2.0\n21.0 2.0 8.0 -8.0 -0.0 -0.0 4.0 2.0\n21.0 0.0 8.0 -8.0 -0.0 -0.0 4.0 0.0\n18.0 2.0 8.0 0.0 0.0 -6.0 0.0 2.0\n18.0 0.0 8.0 0.0 0.0 -6.0 0.0 0.0\n21.0 0.0 8.0 0.0 0.0 -6.0 3.0 0.0\n18.0 2.0 8.0 0.0 0.0 6.0 0.0 2.0\n21.0 2.0 8.0 0.0 0.0 6.0 3.0 2.0\n21.0 0.0 8.0 0.0 0.0 6.0 3.0 0.0\n18.0 2.0 8.0 0.0 0.0 -0.5999985 0.0 2.0\n18.0 0.0 8.0 0.0 0.0 -0.5999985 0.0 0.0\n18.3 0.0 8.0 0.0 0.0 -0.5999985 0.29999924 0.0\n18.0 2.0 8.0 0.0 0.0 0.5999985 0.0 2.0\n18.3 2.0 8.0 0.0 0.0 0.5999985 0.29999924 2.0\n18.3 0.0 8.0 0.0 0.0 0.5999985 0.29999924 0.0\n18.3 2.0 8.0 0.0 0.0 -0.45 0.29999924 2.0\n18.3 1.1 8.0 0.0 0.0 -0.45 0.29999924 1.1\n18.8 1.1 8.0 0.0 0.0 -0.45 0.79999924 1.1\n18.3 2.0 8.0 0.0 0.0 0.45 0.29999924 2.0\n18.8 2.0 8.0 0.0 0.0 0.45 0.79999924 2.0\n18.8 1.1 8.0 0.0 0.0 0.45 0.79999924 1.1\n18.3 0.6 8.0 0.0 0.0 -0.3 0.29999924 0.6\n18.3 0.0 8.0 0.0 0.0 -0.3 0.29999924 0.0\n18.8 0.0 8.0 0.0 0.0 -0.3 0.79999924 0.0\n18.3 0.6 8.0 0.0 0.0 0.3 0.29999924 0.6\n18.8 0.6 8.0 0.0 0.0 0.3 0.79999924 0.6\n18.8 0.0 8.0 0.0 0.0 0.3 0.79999924 0.0\n18.8 2.0 8.0 0.0 0.0 -4.4000015 0.79999924 2.0\n18.8 0.0 8.0 0.0 0.0 -4.4000015 0.79999924 0.0\n21.0 0.0 8.0 0.0 0.0 -4.4000015 3.0 0.0\n18.8 2.0 8.0 0.0 0.0 4.4000015 0.79999924 2.0\n21.0 2.0 8.0 0.0 0.0 4.4000015 3.0 2.0\n21.0 0.0 8.0 0.0 0.0 4.4000015 3.0 0.0\n18.0 2.0 8.0 8.0 0.0 0.0 0.0 2.0\n18.0 0.0 8.0 8.0 0.0 0.0 0.0 0.0\n18.0 0.0 12.0 8.0 0.0 0.0 4.0 0.0\n18.0 2.0 8.0 -8.0 -0.0 -0.0 0.0 2.0\n18.0 2.0 12.0 -8.0 -0.0 -0.0 4.0 2.0\n18.0 0.0 12.0 -8.0 -0.0 -0.0 4.0 0.0\n21.0 2.0 8.0 8.0 0.0 0.0 0.0 2.0\n21.0 0.0 8.0 8.0 0.0 0.0 0.0 0.0\n21.0 0.0 12.0 8.0 0.0 0.0 4.0 0.0\n21.0 2.0 8.0 -8.0 -0.0 -0.0 0.0 2.0\n21.0 2.0 12.0 -8.0 -0.0 -0.0 4.0 2.0\n21.0 0.0 12.0 -8.0 -0.0 -0.0 4.0 0.0\n18.0 2.0 12.0 0.0 0.0 -6.0 0.0 2.0\n18.0 0.0 12.0 0.0 0.0 -6.0 0.0 0.0\n21.0 0.0 12.0 0.0 0.0 -6.0 3.0 0.0\n18.0 2.0 12.0 0.0 0.0 6.0 0.0 2.0\n21.0 2.0 12.0 0.0 0.0 6.0 3.0 2.0\n21.0 0.0 12.0 0.0 0.0 6.0 3.0 0.0\n18.0 2.0 12.0 0.0 0.0 -0.5999985 0.0 2.0\n18.0 0.0 12.0 0.0 0.0 -0.5999985 0.0 0.0\n18.3 0.0 12.0 0.0 0.0 -0.5999985 0.29999924 0.0\n18.0 2.0 12.0 0.0 0.0 0.5999985 0.0 2.0\n18.3 2.0 12.0 0.0 0.0 0.5999985 0.29999924 2.0\n18.3 0.0 12.0 0.0 0.0 0.5999985 0.29999924 0.0\n18.3 2.0 12.0 0.0 0.0 -0.45 0.29999924 2.0\n18.3 1.1 12.0 0.0 0.0 -0.45 0.29999924 1.1\n18.8 1.1 12.0 0.0 0.0 -0.45 0.79999924 1.1\n18.3 2.0 12.0 0.0 0.0 0.45 0.29999924 2.0\n18.8 2.0 12.0 0.0 0.0 0.45 0.79999924 2.0\n18.8 1.1 12.0 0.0 0.0 0.45 0.79999924 1.1\n18.3 0.6 12.0 0.0 0.0 -0.3 0.29999924 0.6\n18.3 0.0 12.0 0.0 0.0 -0.3 0.29999924 0.0\n18.8 0.0 12.0 0.0 0.0 -0.3 0.79999924 0.0\n18.3 0.6 12.0 0.0 0.0 0.3 0.29999924 0.6\n18.8 0.6 12.0 0.0 0.0 0.3 0.79999924 0.6\n18.8 0.0 12.0 0.0 0.0 0.3 0.79999924 0.0\n18.8 2.0 12.0 0.0 0.0 -4.4000015 0.79999924 2.0\n18.8 0.0 12.0 0.0 0.0 -4.4000015 0.79999924 0.0\n21.0 0.0 12.0 0.0 0.0 -4.4000015 3.0 0.0\n18.8 2.0 12.0 0.0 0.0 4.4000015 0.79999924 2.0\n21.0 2.0 12.0 0.0 0.0 4.4000015 3.0 2.0\n21.0 0.0 12.0 0.0 0.0 4.4000015 3.0 0.0\n18.0 2.0 12.0 8.0 0.0 0.0 0.0 2.0\n18.0 0.0 12.0 8.0 0.0 0.0 0.0 0.0\n18.0 0.0 16.0 8.0 0.0 0.0 4.0 0.0\n18.0 2.0 12.0 -8.0 -0.0 -0.0 0.0 2.0\n18.0 2.0 16.0 -8.0 -0.0 -0.0 4.0 2.0\n18.0 0.0 16.0 -8.0 -0.0 -0.0 4.0 0.0\n21.0 2.0 12.0 8.0 0.0 0.0 0.0 2.0\n21.0 0.0 12.0 8.0 0.0 0.0 0.0 0.0\n21.0 0.0 16.0 8.0 0.0 0.0 4.0 0.0\n21.0 2.0 12.0 -8.0 -0.0 -0.0 0.0 2.0\n21.0 2.0 16.0 -8.0 -0.0 -0.0 4.0 2.0\n21.0 0.0 16.0 -8.0 -0.0 -0.0 4.0 0.0\n18.0 2.0 16.0 0.0 0.0 -6.0 0.0 2.0\n18.0 0.0 16.0 0.0 0.0 -6.0 0.0 0.0\n21.0 0.0 16.0 0.0 0.0 -6.0 3.0 0.0\n18.0 2.0 16.0 0.0 0.0 6.0 0.0 2.0\n21.0 2.0 16.0 0.0 0.0 6.0 3.0 2.0\n21.0 0.0 16.0 0.0 0.0 6.0 3.0 0.0\n18.0 2.0 16.0 0.0 0.0 -0.5999985 0.0 2.0\n18.0 0.0 16.0 0.0 0.0 -0.5999985 0.0 0.0\n18.3 0.0 16.0 0.0 0.0 -0.5999985 0.29999924 0.0\n18.0 2.0 16.0 0.0 0.0 0.5999985 0.0 2.0\n18.3 2.0 16.0 0.0 0.0 0.5999985 0.29999924 2.0\n18.3 0.0 16.0 0.0 0.0 0.5999985 0.29999924 0.0\n18.3 2.0 16.0 0.0 0.0 -0.45 0.29999924 2.0\n18.3 1.1 16.0 0.0 0.0 -0.45 0.29999924 1.1\n18.8 1.1 16.0 0.0 0.0 -0.45 0.79999924 1.1\n18.3 2.0 16.0 0.0 0.0 0.45 0.29999924 2.0\n18.8 2.0 16.0 0.0 0.0 0.45 0.79999924 2.0\n18.8 1.1 16.0 0.0 0.0 0.45 0.79999924 1.1\n18.3 0.6 16.0 0.0 0.0 -0.3 0.29999924 0.6\n18.3 0.0 16.0 0.0 0.0 -0.3 0.29999924 0.0\n18.8 0.0 16.0 0.0 0.0 -0.3 0.79999924 0.0\n18.3 0.6 16.0 0.0 0.0 0.3 0.29999924 0.6\n18.8 0.6 16.0 0.0 0.0 0.3 0.79999924 0.6\n18.8 0.0 16.0 0.0 0.0 0.3 0.79999924 0.0\n18.8 2.0 16.0 0.0 0.0 -4.4000015 0.79999924 2.0\n18.8 0.0 16.0 0.0 0.0 -4.4000015 0.79999924 0.0\n21.0 0.0 16.0 0.0 0.0 -4.4000015 3.0 0.0\n18.8 2.0 16.0 0.0 0.0 4.4000015 0.79999924 2.0\n21.0 2.0 16.0 0.0 0.0 4.4000015 3.0 2.0\n21.0 0.0 16.0 0.0 0.0 4.4000015 3.0 0.0\n18.0 2.0 16.0 8.0 0.0 0.0 0.0 2.0\n18.0 0.0 16.0 8.0 0.0 0.0 0.0 0.0\n18.0 0.0 20.0 8.0 0.0 0.0 4.0 0.0\n18.0 2.0 16.0 -8.0 -0.0 -0.0 0.0 2.0\n18.0 2.0 20.0 -8.0 -0.0 -0.0 4.0 2.0\n18.0 0.0 20.0 -8.0 -0.0 -0.0 4.0 0.0\n21.0 2.0 16.0 8.0 0.0 0.0 0.0 2.0\n21.0 0.0 16.0 8.0 0.0 0.0 0.0 0.0\n21.0 0.0 20.0 8.0 0.0 0.0 4.0 0.0\n21.0 2.0 16.0 -8.0 -0.0 -0.0 0.0 2.0\n21.0 2.0 20.0 -8.0 -0.0 -0.0 4.0 2.0\n21.0 0.0 20.0 -8.0 -0.0 -0.0 4.0 0.0\n18.0 2.0 20.0 0.0 0.0 -6.0 0.0 2.0\n18.0 0.0 20.0 0.0 0.0 -6.0 0.0 0.0\n21.0 0.0 20.0 0.0 0.0 -6.0 3.0 0.0\n18.0 2.0 20.0 0.0 0.0 6.0 0.0 2.0\n21.0 2.0 20.0 0.0 0.0 6.0 3.0 2.0\n21.0 0.0 20.0 0.0 0.0 6.0 3.0 0.0\n18.0 2.0 20.0 0.0 0.0 -0.5999985 0.0 2.0\n18.0 0.0 20.0 0.0 0.0 -0.5999985 0.0 0.0\n18.3 0.0 20.0 0.0 0.0 -0.5999985 0.29999924 0.0\n18.0 2.0 20.0 0.0 0.0 0.5999985 0.0 2.0\n18.3 2.0 20.0 0.0 0.0 0.5999985 0.29999924 2.0\n18.3 0.0 20.0 0.0 0.0 0.5999985 0.29999924 0.0\n18.3 2.0 20.0 0.0 0.0 -0.45 0.29999924 2.0\n18.3 1.1 20.0 0.0 0.0 -0.45 0.29999924 1.1\n18.8 1.1 20.0 0.0 0.0 -0.45 0.79999924 1.1\n18.3 2.0 20.0 0.0 0.0 0.45 0.29999924 2.0\n18.8 2.0 20.0 0.0 0.0 0.45 0.79999924 2.0\n18.8 1.1 20.0 0.0 0.0 0.45 0.79999924 1.1\n18.3 0.6 20.0 0.0 0.0 -0.3 0.29999924 0.6\n18.3 0.0 20.0 0.0 0.0 -0.3 0.29999924 0.0\n18.8 0.0 20.0 0.0 0.0 -0.3 0.79999924 0.0\n18.3 0.6 20.0 0.0 0.0 0.3 0.29999924 0.6\n18.8 0.6 20.0 0.0 0.0 0.3 0.79999924 0.6\n18.8 0.0 20.0 0.0 0.0 0.3 0.79999924 0.0\n18.8 2.0 20.0 0.0 0.0 -4.4000015 0.79999924 2.0\n18.8 0.0 20.0 0.0 0.0 -4.4000015 0.79999924 0.0\n21.0 0.0 20.0 0.0 0.0 -4.4000015 3.0 0.0\n18.8 2.0 20.0 0.0 0.0 4.4000015 0.79999924 2.0\n21.0 2.0 20.0 0.0 0.0 4.4000015 3.0 2.0\n21.0 0.0 20.0 0.0 0.0 4.4000015 3.0 0.0\n18.0 2.0 20.0 8.0 0.0 0.0 0.0 2.0\n18.0 0.0 20.0 8.0 0.0 0.0 0.0 0.0\n18.0 0.0 24.0 8.0 0.0 0.0 4.0 0.0\n18.0 2.0 20.0 -8.0 -0.0 -0.0 0.0 2.0\n18.0 2.0 24.0 -8.0 -0.0 -0.0 4.0 2.0\n18.0 0.0 24.0 -8.0 -0.0 -0.0 4.0 0.0\n21.0 2.0 20.0 8.0 0.0 0.0 0.0 2.0\n21.0 0.0 20.0 8.0 0.0 0.0 0.0 0.0\n21.0 0.0 24.0 8.0 0.0 0.0 4.0 0.0\n21.0 2.0 20.0 -8.0 -0.0 -0.0 0.0 2.0\n21.0 2.0 24.0 -8.0 -0.0 -0.0 4.0 2.0\n21.0 0.0 24.0 -8.0 -0.0 -0.0 4.0 0.0\n18.0 2.0 24.0 0.0 0.0 -6.0 0.0 2.0\n18.0 0.0 24.0 0.0 0.0 -6.0 0.0 0.0\n21.0 0.0 24.0 0.0 0.0 -6.0 3.0 0.0\n18.0 2.0 24.0 0.0 0.0 6.0 0.0 2.0\n21.0 2.0 24.0 0.0 0.0 6.0 3.0 2.0\n21.0 0.0 24.0 0.0 0.0 6.0 3.0 0.0\n\n");
        return builder.toString();
      }
      public String getName() {
        return "walls";
      }
    }
    ;
  }
  private static class wallsInitializer {
    static {
      _instance0.wallsInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return walls;
    }
  }
  public com.google.gwt.resources.client.TextResource walls() {
    return wallsInitializer.get();
  }
  private void mudTextureInitializer() {
    mudTexture = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "mudTexture",
      bundledImage_None,
      0, 0, 256, 256, false, false
    );
  }
  private static class mudTextureInitializer {
    static {
      _instance0.mudTextureInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return mudTexture;
    }
  }
  public com.google.gwt.resources.client.ImageResource mudTexture() {
    return mudTextureInitializer.get();
  }
  private void textureSkyboxBkInitializer() {
    textureSkyboxBk = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "textureSkyboxBk",
      externalImage,
      0, 0, 512, 512, false, false
    );
  }
  private static class textureSkyboxBkInitializer {
    static {
      _instance0.textureSkyboxBkInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return textureSkyboxBk;
    }
  }
  public com.google.gwt.resources.client.ImageResource textureSkyboxBk() {
    return textureSkyboxBkInitializer.get();
  }
  private void textureSkyboxDnInitializer() {
    textureSkyboxDn = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "textureSkyboxDn",
      externalImage0,
      0, 0, 512, 512, false, false
    );
  }
  private static class textureSkyboxDnInitializer {
    static {
      _instance0.textureSkyboxDnInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return textureSkyboxDn;
    }
  }
  public com.google.gwt.resources.client.ImageResource textureSkyboxDn() {
    return textureSkyboxDnInitializer.get();
  }
  private void textureSkyboxFtInitializer() {
    textureSkyboxFt = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "textureSkyboxFt",
      externalImage1,
      0, 0, 512, 512, false, false
    );
  }
  private static class textureSkyboxFtInitializer {
    static {
      _instance0.textureSkyboxFtInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return textureSkyboxFt;
    }
  }
  public com.google.gwt.resources.client.ImageResource textureSkyboxFt() {
    return textureSkyboxFtInitializer.get();
  }
  private void textureSkyboxLfInitializer() {
    textureSkyboxLf = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "textureSkyboxLf",
      externalImage2,
      0, 0, 512, 512, false, false
    );
  }
  private static class textureSkyboxLfInitializer {
    static {
      _instance0.textureSkyboxLfInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return textureSkyboxLf;
    }
  }
  public com.google.gwt.resources.client.ImageResource textureSkyboxLf() {
    return textureSkyboxLfInitializer.get();
  }
  private void textureSkyboxRtInitializer() {
    textureSkyboxRt = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "textureSkyboxRt",
      externalImage3,
      0, 0, 512, 512, false, false
    );
  }
  private static class textureSkyboxRtInitializer {
    static {
      _instance0.textureSkyboxRtInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return textureSkyboxRt;
    }
  }
  public com.google.gwt.resources.client.ImageResource textureSkyboxRt() {
    return textureSkyboxRtInitializer.get();
  }
  private void textureSkyboxUpInitializer() {
    textureSkyboxUp = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "textureSkyboxUp",
      externalImage4,
      0, 0, 512, 512, false, false
    );
  }
  private static class textureSkyboxUpInitializer {
    static {
      _instance0.textureSkyboxUpInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return textureSkyboxUp;
    }
  }
  public com.google.gwt.resources.client.ImageResource textureSkyboxUp() {
    return textureSkyboxUpInitializer.get();
  }
  private void wallTextureInitializer() {
    wallTexture = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "wallTexture",
      externalImage5,
      0, 0, 2560, 1920, false, true
    );
  }
  private static class wallTextureInitializer {
    static {
      _instance0.wallTextureInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return wallTexture;
    }
  }
  public com.google.gwt.resources.client.ImageResource wallTexture() {
    return wallTextureInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.TextResource ceiling;
  private static com.google.gwt.resources.client.TextResource ceiling_file_frag;
  private static com.google.gwt.resources.client.TextResource ceiling_file_vert;
  private static com.google.gwt.resources.client.TextResource ceiling_proc_frag;
  private static com.google.gwt.resources.client.TextResource ceiling_proc_vert;
  private static com.google.gwt.resources.client.TextResource floor;
  private static com.google.gwt.resources.client.TextResource floor_file_frag;
  private static com.google.gwt.resources.client.TextResource floor_file_vert;
  private static com.google.gwt.resources.client.TextResource floor_proc_frag;
  private static com.google.gwt.resources.client.TextResource floor_proc_vert;
  private static com.google.gwt.resources.client.TextResource pillar_file_frag;
  private static com.google.gwt.resources.client.TextResource pillar_file_vert;
  private static com.google.gwt.resources.client.TextResource pillar_proc_frag;
  private static com.google.gwt.resources.client.TextResource pillar_proc_vert;
  private static com.google.gwt.resources.client.TextResource pillars;
  private static com.google.gwt.resources.client.TextResource skybox_file_frag;
  private static com.google.gwt.resources.client.TextResource skybox_file_vert;
  private static com.google.gwt.resources.client.TextResource skybox_proc_frag;
  private static com.google.gwt.resources.client.TextResource skybox_proc_vert;
  private static com.google.gwt.resources.client.TextResource wall_file_frag;
  private static com.google.gwt.resources.client.TextResource wall_file_vert;
  private static com.google.gwt.resources.client.TextResource wall_proc_frag;
  private static com.google.gwt.resources.client.TextResource wall_proc_vert;
  private static com.google.gwt.resources.client.TextResource walls;
  private static final java.lang.String bundledImage_None = GWT.getModuleBaseURL() + "EEF4A495D94E1F300998209DF6CA1697.cache.png";
  private static final java.lang.String externalImage = GWT.getModuleBaseURL() + "1199B3C237A005CD5E6715A9F4C2164D.cache.png";
  private static final java.lang.String externalImage0 = GWT.getModuleBaseURL() + "7F11213566CE515DA17EE2F55A771C58.cache.png";
  private static final java.lang.String externalImage1 = GWT.getModuleBaseURL() + "56754F5405D5B65C01DAA76BEED81CB9.cache.png";
  private static final java.lang.String externalImage2 = GWT.getModuleBaseURL() + "E1769233A9349025F769C1B6CFFB2447.cache.png";
  private static final java.lang.String externalImage3 = GWT.getModuleBaseURL() + "CEE0CC5D445A8EB3FCB79528F080004B.cache.png";
  private static final java.lang.String externalImage4 = GWT.getModuleBaseURL() + "EFF3AB314CBCE9C1C91C0E10A15DC353.cache.png";
  private static final java.lang.String externalImage5 = GWT.getModuleBaseURL() + "5C2122D4F03EBA194B982D6B2D7A28F1.cache.jpg";
  private static com.google.gwt.resources.client.ImageResource mudTexture;
  private static com.google.gwt.resources.client.ImageResource textureSkyboxBk;
  private static com.google.gwt.resources.client.ImageResource textureSkyboxDn;
  private static com.google.gwt.resources.client.ImageResource textureSkyboxFt;
  private static com.google.gwt.resources.client.ImageResource textureSkyboxLf;
  private static com.google.gwt.resources.client.ImageResource textureSkyboxRt;
  private static com.google.gwt.resources.client.ImageResource textureSkyboxUp;
  private static com.google.gwt.resources.client.ImageResource wallTexture;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      ceiling(), 
      ceiling_file_frag(), 
      ceiling_file_vert(), 
      ceiling_proc_frag(), 
      ceiling_proc_vert(), 
      floor(), 
      floor_file_frag(), 
      floor_file_vert(), 
      floor_proc_frag(), 
      floor_proc_vert(), 
      pillar_file_frag(), 
      pillar_file_vert(), 
      pillar_proc_frag(), 
      pillar_proc_vert(), 
      pillars(), 
      skybox_file_frag(), 
      skybox_file_vert(), 
      skybox_proc_frag(), 
      skybox_proc_vert(), 
      wall_file_frag(), 
      wall_file_vert(), 
      wall_proc_frag(), 
      wall_proc_vert(), 
      walls(), 
      mudTexture(), 
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
        resourceMap.put("ceiling", ceiling());
        resourceMap.put("ceiling_file_frag", ceiling_file_frag());
        resourceMap.put("ceiling_file_vert", ceiling_file_vert());
        resourceMap.put("ceiling_proc_frag", ceiling_proc_frag());
        resourceMap.put("ceiling_proc_vert", ceiling_proc_vert());
        resourceMap.put("floor", floor());
        resourceMap.put("floor_file_frag", floor_file_frag());
        resourceMap.put("floor_file_vert", floor_file_vert());
        resourceMap.put("floor_proc_frag", floor_proc_frag());
        resourceMap.put("floor_proc_vert", floor_proc_vert());
        resourceMap.put("pillar_file_frag", pillar_file_frag());
        resourceMap.put("pillar_file_vert", pillar_file_vert());
        resourceMap.put("pillar_proc_frag", pillar_proc_frag());
        resourceMap.put("pillar_proc_vert", pillar_proc_vert());
        resourceMap.put("pillars", pillars());
        resourceMap.put("skybox_file_frag", skybox_file_frag());
        resourceMap.put("skybox_file_vert", skybox_file_vert());
        resourceMap.put("skybox_proc_frag", skybox_proc_frag());
        resourceMap.put("skybox_proc_vert", skybox_proc_vert());
        resourceMap.put("wall_file_frag", wall_file_frag());
        resourceMap.put("wall_file_vert", wall_file_vert());
        resourceMap.put("wall_proc_frag", wall_proc_frag());
        resourceMap.put("wall_proc_vert", wall_proc_vert());
        resourceMap.put("walls", walls());
        resourceMap.put("mudTexture", mudTexture());
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
      case 'ceiling': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::ceiling()();
      case 'ceiling_file_frag': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::ceiling_file_frag()();
      case 'ceiling_file_vert': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::ceiling_file_vert()();
      case 'ceiling_proc_frag': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::ceiling_proc_frag()();
      case 'ceiling_proc_vert': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::ceiling_proc_vert()();
      case 'floor': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::floor()();
      case 'floor_file_frag': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::floor_file_frag()();
      case 'floor_file_vert': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::floor_file_vert()();
      case 'floor_proc_frag': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::floor_proc_frag()();
      case 'floor_proc_vert': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::floor_proc_vert()();
      case 'pillar_file_frag': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::pillar_file_frag()();
      case 'pillar_file_vert': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::pillar_file_vert()();
      case 'pillar_proc_frag': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::pillar_proc_frag()();
      case 'pillar_proc_vert': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::pillar_proc_vert()();
      case 'pillars': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::pillars()();
      case 'skybox_file_frag': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::skybox_file_frag()();
      case 'skybox_file_vert': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::skybox_file_vert()();
      case 'skybox_proc_frag': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::skybox_proc_frag()();
      case 'skybox_proc_vert': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::skybox_proc_vert()();
      case 'wall_file_frag': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::wall_file_frag()();
      case 'wall_file_vert': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::wall_file_vert()();
      case 'wall_proc_frag': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::wall_proc_frag()();
      case 'wall_proc_vert': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::wall_proc_vert()();
      case 'walls': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::walls()();
      case 'mudTexture': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::mudTexture()();
      case 'textureSkyboxBk': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::textureSkyboxBk()();
      case 'textureSkyboxDn': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::textureSkyboxDn()();
      case 'textureSkyboxFt': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::textureSkyboxFt()();
      case 'textureSkyboxLf': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::textureSkyboxLf()();
      case 'textureSkyboxRt': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::textureSkyboxRt()();
      case 'textureSkyboxUp': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::textureSkyboxUp()();
      case 'wallTexture': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::wallTexture()();
    }
    return null;
  }-*/;
}
