package com.df3n5.gwtproc.client.demos.bumpmapping;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class Resources_default_StaticClientBundleGenerator implements com.df3n5.gwtproc.client.demos.bumpmapping.Resources {
  private static Resources_default_StaticClientBundleGenerator _instance0 = new Resources_default_StaticClientBundleGenerator();
  private void ceiling_proc_fragInitializer() {
    ceiling_proc_frag = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc_procperf/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/proc/checkered_proc.frag
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
      // file:/home/j0n/code/procgl/gwtproc/gwtproc_procperf/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/proc/checkered_proc.vert
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
  private void floor_proc_fragInitializer() {
    floor_proc_frag = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc_procperf/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/proc/checkered_proc.frag
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
      // file:/home/j0n/code/procgl/gwtproc/gwtproc_procperf/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/proc/checkered_proc.vert
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
  private void pillar_proc_fragInitializer() {
    pillar_proc_frag = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc_procperf/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/proc/concrete_proc.frag
      public String getText() {
        return "/**\n * Procedural bump mapping\n */\n#ifdef GL_ES\nprecision highp float;\n#endif\n\nvarying vec2 vTextureCoord;\nvarying vec3 vLightDir;\nvarying vec3 vEyeDir;\n\n//uniform vec3  SurfaceColor;    // = (0.7, 0.6, 0.18)\n//uniform float BumpDensity;     // = 16.0\n//uniform float BumpSize;        // = 0.15\n//uniform float SpecularFactor;  // = 0.5\nvec3  SurfaceColor = vec3(0.7, 0.7, 0.7);\nfloat BumpDensity = 1.0;\nfloat BumpSize = 0.3;\nfloat SpecularFactor = 0.9;\n\nuniform int uProcTextureType;\n\nvoid main()\n{\n    vec3 litColor;\n    vec2 c = BumpDensity * vTextureCoord.st; //Tex coord is just to figure out how far we are into polygon\n    vec2 p = fract(c) - vec2(0.5);\n\n    float d, f;\n    //d = p.x * p.x + p.y * p.y;\n    d = p.x * p.x;\n    f = 1.0 / sqrt(d + 1.0);\n\n    if (d >= BumpSize)\n    { \n    	p = vec2(0.0); \n    	f = 1.0; \n    }\n\n    //vec3 normDelta = vec3(p.x, p.y, 1.0) * f;\n    vec3 normDelta = vec3(p.x, p.y, 1.0) * 1.0/f;\n    litColor = SurfaceColor * max(dot(normDelta, vLightDir), 0.0);\n    vec3 reflectDir = reflect(vLightDir, normDelta);\n    \n    float spec = max(dot(vEyeDir, reflectDir), 0.0);\n\n    spec *= SpecularFactor;\n\n    //litColor = min(litColor + spec, vec3(1.0));\n    litColor = litColor + spec;\n\n    gl_FragColor = vec4(litColor, 1.0);\n}";
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
      // file:/home/j0n/code/procgl/gwtproc/gwtproc_procperf/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/proc/concrete_proc.vert
      public String getText() {
        return "/**\n * Procedural bumps\n **/\n\nuniform mat4 uMVMatrix;\nuniform mat4 uPMatrix;\nuniform vec3 uLightPosition;\n \nattribute vec3 aVertexPosition;\nattribute vec3 aNormal;\nattribute vec2 aTextureCoord;\n\nvarying vec2 vTextureCoord;\nvarying vec3 vLightDir;\nvarying vec3 vEyeDir;\n\nvec3 calcTangent(vec3 normal)\n{\n	vec3 tangent;\n	vec3 c1 = cross(normal, vec3(0.0, 0.0, 1.0));\n	vec3 c2 = cross(normal, vec3(0.0, 1.0, 0.0));\n	if(length(c1)>length(c2))\n	{\n		tangent = c1;\n	}\n	else\n	{\n		tangent = c2;\n	}\n	tangent = normalize(tangent);\n	return tangent;\n}\n\nvoid main() \n{\n    gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);\n    vTextureCoord = aTextureCoord;\n	vEyeDir = vec3(uMVMatrix * vec4(aVertexPosition, 1.0));\n    \n    vec3 n = normalize(aNormal);\n    vec3 t = normalize(calcTangent(aNormal));\n    vec3 b = -cross(n, t); //binormal\n\n    vec3 v;\n    v.x = dot(uLightPosition, t);\n    v.y = dot(uLightPosition, b);\n    v.z = dot(uLightPosition, n);\n    vLightDir = normalize(v);\n\n    v.x = dot(vEyeDir, t);\n    v.y = dot(vEyeDir, b);\n    v.z = dot(vEyeDir, n);\n    vEyeDir = normalize(v);\n}";
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
  private void skybox_proc_fragInitializer() {
    skybox_proc_frag = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc_procperf/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/proc/perlinsky_proc.frag
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
      // file:/home/j0n/code/procgl/gwtproc/gwtproc_procperf/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/proc/perlinsky_proc.vert
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
  private void wall2_proc_fragInitializer() {
    wall2_proc_frag = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc_procperf/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/proc/perlinwall2_proc.frag
      public String getText() {
        return "#ifdef GL_ES\nprecision highp float;\n#endif\n\nvec4 permute(vec4 x)\n{\n  return mod(((x*34.0)+1.0)*x, 289.0);\n}\nvec4 taylorInvSqrt(vec4 r)\n{\n  return 1.79284291400159 - 0.85373472095314 * r;\n}\nfloat snoise(vec3 v)\n{\n  const vec2 C = vec2(1.0/6.0, 1.0/3.0) ;\n  const vec4 D = vec4(0.0, 0.5, 1.0, 2.0);\n  vec3 i = floor(v + dot(v, C.yyy) );\n  vec3 x0 = v - i + dot(i, C.xxx) ;\n  vec3 g = step(x0.yzx, x0.xyz);\n  vec3 l = 1.0 - g;\n  vec3 i1 = min( g.xyz, l.zxy );\n  vec3 i2 = max( g.xyz, l.zxy );\n  vec3 x1 = x0 - i1 + C.xxx;\n  vec3 x2 = x0 - i2 + C.yyy;\n  vec3 x3 = x0 - D.yyy;\n  i = mod(i, 289.0 );\n  vec4 p = permute( permute( permute(\n             i.z + vec4(0.0, i1.z, i2.z, 1.0 ))\n           + i.y + vec4(0.0, i1.y, i2.y, 1.0 ))\n           + i.x + vec4(0.0, i1.x, i2.x, 1.0 ));\n  float n_ = 0.142857142857;\n  vec3 ns = n_ * D.wyz - D.xzx;\n  vec4 j = p - 49.0 * floor(p * ns.z * ns.z);\n  vec4 x_ = floor(j * ns.z);\n  vec4 y_ = floor(j - 7.0 * x_ );\n  vec4 x = x_ *ns.x + ns.yyyy;\n  vec4 y = y_ *ns.x + ns.yyyy;\n  vec4 h = 1.0 - abs(x) - abs(y);\n  vec4 b0 = vec4( x.xy, y.xy );\n  vec4 b1 = vec4( x.zw, y.zw );\n  vec4 s0 = floor(b0)*2.0 + 1.0;\n  vec4 s1 = floor(b1)*2.0 + 1.0;\n  vec4 sh = -step(h, vec4(0.0));\n  vec4 a0 = b0.xzyw + s0.xzyw*sh.xxyy ;\n  vec4 a1 = b1.xzyw + s1.xzyw*sh.zzww ;\n  vec3 p0 = vec3(a0.xy,h.x);\n  vec3 p1 = vec3(a0.zw,h.y);\n  vec3 p2 = vec3(a1.xy,h.z);\n  vec3 p3 = vec3(a1.zw,h.w);\n  vec4 norm = taylorInvSqrt(vec4(dot(p0,p0), dot(p1,p1), dot(p2, p2), dot(p3,p3)));\n  p0 *= norm.x;\n  p1 *= norm.y;\n  p2 *= norm.z;\n  p3 *= norm.w;\n  vec4 m = max(0.6 - vec4(dot(x0,x0), dot(x1,x1), dot(x2,x2), dot(x3,x3)), 0.0);\n  m = m * m;\n  return 42.0 * dot( m*m, vec4( dot(p0,x0), dot(p1,x1),\n                                dot(p2,x2), dot(p3,x3) ) );\n}\n\nvarying vec3 vTexCoord3D;\n\nfloat time = 0.1;\n\nvoid main(void) {\n	vec3 uvw = vTexCoord3D + 0.1*vec3(snoise(vTexCoord3D + vec3(0.0, 0.0, time)),\n			snoise(vTexCoord3D + vec3(43.0, 17.0, time)),\n			snoise(vTexCoord3D + vec3(-17.0, -43.0, time)));\n			\n	//http://www.noisemachine.com/talk1/22.html\n	float n = 0.5; //x coord of surface location\n	n += snoise(uvw - vec3(0.0, 0.0, time));\n	//n += 0.5 * snoise(uvw * 2.0 - vec3(0.0, 0.0, time*1.4));\n	//n += 0.25 * snoise(uvw * 4.0 - vec3(0.0, 0.0, time*2.0));\n	//n += 0.125 * snoise(uvw * 8.0 - vec3(0.0, 0.0, time*2.8));\n	n += 0.0625 * snoise(uvw * 16.0 - vec3(0.0, 0.0, time*4.0));\n	n += 0.03125 * snoise(uvw * 32.0 - vec3(0.0, 0.0, time*5.6));\n	n = sin(n);\n\n	gl_FragColor = vec4(vec3(-0.4, -0.4, 0.0) + vec3(n, n, n), 1.0); //Wall material\n}";
      }
      public String getName() {
        return "wall2_proc_frag";
      }
    }
    ;
  }
  private static class wall2_proc_fragInitializer {
    static {
      _instance0.wall2_proc_fragInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return wall2_proc_frag;
    }
  }
  public com.google.gwt.resources.client.TextResource wall2_proc_frag() {
    return wall2_proc_fragInitializer.get();
  }
  private void wall2_proc_vertInitializer() {
    wall2_proc_vert = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc_procperf/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/proc/perlinwall2_proc.vert
      public String getText() {
        return "uniform mat4 uMVMatrix;\nuniform mat4 uPMatrix;\n\nattribute vec3 aVertexPosition;\nattribute vec2 aTextureCoord;\n\nvarying vec3 vTexCoord3D;\n\nvoid main(void) {\n	gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);\n\n	// Quantise effect - give this a go on highly detailed meshes.\n//	float quant = 3.0;\n//	gl_Position.x=quant*gl_Position.x/quant+gl_Position.x*0.001;\n//	gl_Position.y=quant*gl_Position.y/quant+gl_Position.y*0.001;\n//	gl_Position.z=quant*gl_Position.z/quant+gl_Position.z*0.001;\n    \n	vTexCoord3D = vec3(aTextureCoord,0);\n}";
      }
      public String getName() {
        return "wall2_proc_vert";
      }
    }
    ;
  }
  private static class wall2_proc_vertInitializer {
    static {
      _instance0.wall2_proc_vertInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return wall2_proc_vert;
    }
  }
  public com.google.gwt.resources.client.TextResource wall2_proc_vert() {
    return wall2_proc_vertInitializer.get();
  }
  private void wall_proc_fragInitializer() {
    wall_proc_frag = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/code/procgl/gwtproc/gwtproc_procperf/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/proc/perlinwall_proc.frag
      public String getText() {
        return "#ifdef GL_ES\nprecision highp float;\n#endif\n\nvec4 permute(vec4 x)\n{\n  return mod(((x*34.0)+1.0)*x, 289.0);\n}\nvec4 taylorInvSqrt(vec4 r)\n{\n  return 1.79284291400159 - 0.85373472095314 * r;\n}\nfloat snoise(vec3 v)\n{\n  const vec2 C = vec2(1.0/6.0, 1.0/3.0) ;\n  const vec4 D = vec4(0.0, 0.5, 1.0, 2.0);\n  vec3 i = floor(v + dot(v, C.yyy) );\n  vec3 x0 = v - i + dot(i, C.xxx) ;\n  vec3 g = step(x0.yzx, x0.xyz);\n  vec3 l = 1.0 - g;\n  vec3 i1 = min( g.xyz, l.zxy );\n  vec3 i2 = max( g.xyz, l.zxy );\n  vec3 x1 = x0 - i1 + C.xxx;\n  vec3 x2 = x0 - i2 + C.yyy;\n  vec3 x3 = x0 - D.yyy;\n  i = mod(i, 289.0 );\n  vec4 p = permute( permute( permute(\n             i.z + vec4(0.0, i1.z, i2.z, 1.0 ))\n           + i.y + vec4(0.0, i1.y, i2.y, 1.0 ))\n           + i.x + vec4(0.0, i1.x, i2.x, 1.0 ));\n  float n_ = 0.142857142857;\n  vec3 ns = n_ * D.wyz - D.xzx;\n  vec4 j = p - 49.0 * floor(p * ns.z * ns.z);\n  vec4 x_ = floor(j * ns.z);\n  vec4 y_ = floor(j - 7.0 * x_ );\n  vec4 x = x_ *ns.x + ns.yyyy;\n  vec4 y = y_ *ns.x + ns.yyyy;\n  vec4 h = 1.0 - abs(x) - abs(y);\n  vec4 b0 = vec4( x.xy, y.xy );\n  vec4 b1 = vec4( x.zw, y.zw );\n  vec4 s0 = floor(b0)*2.0 + 1.0;\n  vec4 s1 = floor(b1)*2.0 + 1.0;\n  vec4 sh = -step(h, vec4(0.0));\n  vec4 a0 = b0.xzyw + s0.xzyw*sh.xxyy ;\n  vec4 a1 = b1.xzyw + s1.xzyw*sh.zzww ;\n  vec3 p0 = vec3(a0.xy,h.x);\n  vec3 p1 = vec3(a0.zw,h.y);\n  vec3 p2 = vec3(a1.xy,h.z);\n  vec3 p3 = vec3(a1.zw,h.w);\n  vec4 norm = taylorInvSqrt(vec4(dot(p0,p0), dot(p1,p1), dot(p2, p2), dot(p3,p3)));\n  p0 *= norm.x;\n  p1 *= norm.y;\n  p2 *= norm.z;\n  p3 *= norm.w;\n  vec4 m = max(0.6 - vec4(dot(x0,x0), dot(x1,x1), dot(x2,x2), dot(x3,x3)), 0.0);\n  m = m * m;\n  return 42.0 * dot( m*m, vec4( dot(p0,x0), dot(p1,x1),\n                                dot(p2,x2), dot(p3,x3) ) );\n}\n\nvarying vec3 vTexCoord3D;\n\nfloat time = 0.1;\n\nvoid main(void) {\n	vec3 uvw = vTexCoord3D + 0.1*vec3(snoise(vTexCoord3D + vec3(0.0, 0.0, time)),\n			snoise(vTexCoord3D + vec3(43.0, 17.0, time)),\n			snoise(vTexCoord3D + vec3(-17.0, -43.0, time)));\n			\n	//http://www.noisemachine.com/talk1/22.html\n	float n = 0.5; //x coord of surface location\n	//n += snoise(uvw - vec3(0.0, 0.0, time));\n	//n += 0.5 * snoise(uvw * 2.0 - vec3(0.0, 0.0, time*1.4));\n	//n += 0.25 * snoise(uvw * 4.0 - vec3(0.0, 0.0, time*2.0));\n	n += 0.125 * snoise(uvw * 8.0 - vec3(0.0, 0.0, time*2.8));\n	n += 0.0625 * snoise(uvw * 16.0 - vec3(0.0, 0.0, time*4.0));\n	n += 0.03125 * snoise(uvw * 32.0 - vec3(0.0, 0.0, time*5.6));\n	n = sin(n);\n\n	gl_FragColor = vec4(vec3(0.0, -0.9, -0.9) + vec3(n, n, n), 1.0); //Wall material\n}";
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
      // file:/home/j0n/code/procgl/gwtproc/gwtproc_procperf/src/main/java/com/df3n5/gwtproc/client/demos/bumpmapping/shaders/proc/perlinwall_proc.vert
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
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.TextResource ceiling_proc_frag;
  private static com.google.gwt.resources.client.TextResource ceiling_proc_vert;
  private static com.google.gwt.resources.client.TextResource floor_proc_frag;
  private static com.google.gwt.resources.client.TextResource floor_proc_vert;
  private static com.google.gwt.resources.client.TextResource pillar_proc_frag;
  private static com.google.gwt.resources.client.TextResource pillar_proc_vert;
  private static com.google.gwt.resources.client.TextResource skybox_proc_frag;
  private static com.google.gwt.resources.client.TextResource skybox_proc_vert;
  private static com.google.gwt.resources.client.TextResource wall2_proc_frag;
  private static com.google.gwt.resources.client.TextResource wall2_proc_vert;
  private static com.google.gwt.resources.client.TextResource wall_proc_frag;
  private static com.google.gwt.resources.client.TextResource wall_proc_vert;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      ceiling_proc_frag(), 
      ceiling_proc_vert(), 
      floor_proc_frag(), 
      floor_proc_vert(), 
      pillar_proc_frag(), 
      pillar_proc_vert(), 
      skybox_proc_frag(), 
      skybox_proc_vert(), 
      wall2_proc_frag(), 
      wall2_proc_vert(), 
      wall_proc_frag(), 
      wall_proc_vert(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("ceiling_proc_frag", ceiling_proc_frag());
        resourceMap.put("ceiling_proc_vert", ceiling_proc_vert());
        resourceMap.put("floor_proc_frag", floor_proc_frag());
        resourceMap.put("floor_proc_vert", floor_proc_vert());
        resourceMap.put("pillar_proc_frag", pillar_proc_frag());
        resourceMap.put("pillar_proc_vert", pillar_proc_vert());
        resourceMap.put("skybox_proc_frag", skybox_proc_frag());
        resourceMap.put("skybox_proc_vert", skybox_proc_vert());
        resourceMap.put("wall2_proc_frag", wall2_proc_frag());
        resourceMap.put("wall2_proc_vert", wall2_proc_vert());
        resourceMap.put("wall_proc_frag", wall_proc_frag());
        resourceMap.put("wall_proc_vert", wall_proc_vert());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'ceiling_proc_frag': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::ceiling_proc_frag()();
      case 'ceiling_proc_vert': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::ceiling_proc_vert()();
      case 'floor_proc_frag': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::floor_proc_frag()();
      case 'floor_proc_vert': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::floor_proc_vert()();
      case 'pillar_proc_frag': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::pillar_proc_frag()();
      case 'pillar_proc_vert': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::pillar_proc_vert()();
      case 'skybox_proc_frag': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::skybox_proc_frag()();
      case 'skybox_proc_vert': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::skybox_proc_vert()();
      case 'wall2_proc_frag': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::wall2_proc_frag()();
      case 'wall2_proc_vert': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::wall2_proc_vert()();
      case 'wall_proc_frag': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::wall_proc_frag()();
      case 'wall_proc_vert': return this.@com.df3n5.gwtproc.client.demos.bumpmapping.Resources::wall_proc_vert()();
    }
    return null;
  }-*/;
}
