package com.df3n5.gwtproc.client.demos.main;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class Resources_default_InlineClientBundleGenerator implements com.df3n5.gwtproc.client.demos.main.Resources {
  private static Resources_default_InlineClientBundleGenerator _instance0 = new Resources_default_InlineClientBundleGenerator();
  private void ceilingInitializer() {
    ceiling = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/tmp/new/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/main/ceiling.txt
      public String getText() {
        return "0.0 2.0 1000.0 0.0 6.0\n0.0 2.0 0.0 0.0 0.0\n1000.0 2.0 0.0 6.0 0.0\n0.0 2.0 1000.0 0.0 6.0\n1000.0 2.0 1000.0 6.0 6.0\n1000.0 2.0 0.0 6.0 0.0";
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
  private void floorInitializer() {
    floor = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/tmp/new/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/main/floor.txt
      public String getText() {
        return "0.0 0.0 1000.0 0.0 6.0\n0.0 0.0 0.0 0.0 0.0\n1000.0 0.0 0.0 6.0 0.0\n0.0 0.0 1000.0 0.0 6.0\n1000.0 0.0 1000.0 6.0 6.0\n1000.0 0.0 0.0 6.0 0.0";
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
  private void fragmentShaderInitializer() {
    fragmentShader = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/tmp/new/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/main/fragment-shader.txt
      public String getText() {
        return "/*\n#ifdef GL_ES\nprecision highp float;\n#endif\n\nuniform sampler2D tex;\nvarying vec2 texCoord;\nvoid main() {\n	gl_FragColor = texture2D(tex, texCoord);\n}\n*/\n/*\n\n//Newer\n#ifdef GL_ES\nprecision highp float;\n#endif\n\nvarying vec2 vTextureCoord;\n\nuniform sampler2D uSampler;\n\nvoid main(void) {\n    gl_FragColor = texture2D(uSampler, vec2(vTextureCoord.s, vTextureCoord.t));\n}\n*/\n/*\n//XXX:Working\n//Procedurally generated checkboard texture.\n#ifdef GL_ES\nprecision highp float;\n#endif\n\n//TODO : Pass in as uniform\nfloat uFrequency = 2.0;\nvec4 uColor0 = vec4(0.0,0.0,0.0,1.0);\nvec4 uColor1 = vec4(1.0,1.0,1.0,1.0);\n\nvarying vec2 vTextureCoord;\n\nuniform sampler2D uSampler;\n\nvoid main(void) {\n	vec2 texCoord = mod(floor(vTextureCoord * float(uFrequency*2.0)), 2.0);\n	float delta = abs(texCoord.x - texCoord.y);\n	\n	gl_FragColor = mix(uColor1, uColor0, delta);\n}\n*/\n/*\n//Procedurally generated AA checkboard texture.\n#ifdef GL_ES\nprecision highp float;\n#endif\n\n//TODO : Pass in as uniform\nfloat uFrequency = 2.0;\nvec4 uColor0 = vec4(0.0,0.0,0.0,1.0);\nvec4 uColor1 = vec4(1.0,1.0,1.0,1.0);\n\nvarying vec2 vTextureCoord;\n\nuniform sampler2D uSampler;\n\nvoid main(void) {\n	vec4 color;\n	vec2 st_width;\n	vec2 fuzz;\n	vec2 check_pos;\n	float fuzz_max;\n	\n	//calc the filter width\n	//st_width = fwidth(vTextureCoord);\n	st_width.s = fwidth(vTextureCoord.s);\n	st_width.t = fwidth(vTextureCoord.t);\n	fuzz = st_width * uFrequency * 2.0;\n	fuzz_max = max(fuzz.s, fuzz.t);\n	\n	//get the place in the pattern where we are sampling\n	check_pos = fract(vTextureCoord * uFrequency);\n	\n	if( fuzz_max <= 0.5 )\n	{\n		//if the filter width is small enough, compute the pattern\n		// color by performing a smooth interpolation between the \n		// computed color and the average color\n		\n		vec2 p = smoothstep( vec2(0.5), fuzz + vec2(0.5), check_pos)\n		+ (1.0 - smoothstep(vec2(0.0), fuzz, check_pos));\n		\n		//XXX: Assigning twice? This is MADNESS!\n		color = mix(uColor0, uColor1,\n			p.x * p.y + (1.0 - p.x) * (1.0 - p.y));\n		color = mix(color, (uColor0 + uColor1)/2.0,\n			smoothstep(0.125,0.5, fuzz_max));\n	}\n	else\n	{\n		//filter is too wide. just use the average color.\n		color = (uColor0 + uColor1)/2.0;\n	}\n	\n	gl_FragColor = color;\n}\n*/\n/*\n#extension GL_OES_standard_derivatives : enable\n\nprecision highp float;\n\nfloat uFrequency = 2.0;\nvec4 uColor0 = vec4(0.0,0.0,0.0,1.0);\nvec4 uColor1 = vec4(1.0,1.0,1.0,1.0);\n\nvarying vec2    vTextureCoord;\n\nvoid\nmain()\n{\n   vec4   color;\n   vec2   st_width;\n   vec2   fuzz;\n   vec2   pmod;\n   float  fuzz_max;\n   \n   // determine the filter width\n   st_width = fwidth(vTextureCoord);\n   \n   // calculate the fuzziness taking normal into account\n   fuzz = st_width * float(uFrequency) * 2.0;\n \n   fuzz_max = max(fuzz.s, fuzz.t);\n   \n   // calculate position in the checkerboard pattern\n   pmod = fract(vTextureCoord * float(uFrequency));\n   \n   // if the filter width is small enough, compute the pattern color\n   if (fuzz_max <= 0.5)\n   {\n      vec2   p = smoothstep(vec2(0.5), fuzz + vec2(0.5), pmod) + (1.0 - smoothstep(vec2(0.0), fuzz, pmod));\n      \n      color = mix(uColor0, uColor1, p.x * p.y + (1.0 - p.x) * (1.0 - p.y));\n      \n      // gradually fade in the average color when we get close to the limit\n      color = mix(color, (uColor0 + uColor1)/2.0, smoothstep(0.125, 0.5, fuzz_max));\n   }\n   else\n   {\n      // otherwise, use only the average color\n      color = (uColor0 + uColor1)/2.0;\n   }\n   \n   gl_FragColor = color;\n}\n*/\n/*\n//Per frag lighting\nprecision mediump float;\n\nuniform vec4 uAmbient;\nuniform vec4 uSpecular;\nuniform vec4 uDiffuse;\nuniform float uSpecularPower;\n\nuniform sampler2D sBaseMap;\nuniform sampler2D sBumpMap;\n\nvarying vec2 vTexCoord;\nvarying vec3 vViewDirection;\nvarying vec3 vLightDirection;\n\nvoid main( void )\n{\n   // Fetch basemap color\n   vec4 baseColor = texture2D( sBaseMap, vTexCoord );\n   \n   // Fetch the tangent space normal from normal map\n   vec3 normal = texture2D( sBumpMap, vTexCoord ).xyz;\n   \n   // Scale and bias from [0, 1] to [-1, 1] and normalize\n   normal = normalize( normal * 2.0 - 1.0 );\n   \n   // Normalize the light direction and view direction\n   vec3 lightDirection = normalize( vLightDirection );\n   vec3 viewDirection = normalize( vViewDirection );\n   \n   // Compute N.L\n   float nDotL = dot( normal, lightDirection );\n   \n   // Compute reflection vector\n   vec3 reflection = ( 2.0 * normal * nDotL ) - lightDirection;\n   \n   // Compute R.V\n   float rDotV = max( 0.0, dot( reflection, viewDirection ) );\n   \n   // Compute Ambient term\n   vec4 ambient = uAmbient * baseColor;\n   \n   // Compute Diffuse term\n   vec4 diffuse = uDiffuse * nDotL * baseColor;\n   \n   // Compute Specular term\n   vec4 specular = uSpecular * pow( rDotV, uSpecularPower );\n   \n   // Output final color\n   gl_FragColor = ambient + diffuse + specular;     \n}\n*/\n\n/*\n#ifdef GL_ES\nprecision highp float;\n#endif\nvec4 permute(vec4 x)\n{\n  return mod(((x*34.0)+1.0)*x, 289.0);\n}\nvec4 taylorInvSqrt(vec4 r)\n{\n  return 1.79284291400159 - 0.85373472095314 * r;\n}\nfloat snoise(vec3 v)\n{\n  const vec2 C = vec2(1.0/6.0, 1.0/3.0) ;\n  const vec4 D = vec4(0.0, 0.5, 1.0, 2.0);\n  vec3 i = floor(v + dot(v, C.yyy) );\n  vec3 x0 = v - i + dot(i, C.xxx) ;\n  vec3 g = step(x0.yzx, x0.xyz);\n  vec3 l = 1.0 - g;\n  vec3 i1 = min( g.xyz, l.zxy );\n  vec3 i2 = max( g.xyz, l.zxy );\n  vec3 x1 = x0 - i1 + C.xxx;\n  vec3 x2 = x0 - i2 + C.yyy;\n  vec3 x3 = x0 - D.yyy;\n  i = mod(i, 289.0 );\n  vec4 p = permute( permute( permute(\n             i.z + vec4(0.0, i1.z, i2.z, 1.0 ))\n           + i.y + vec4(0.0, i1.y, i2.y, 1.0 ))\n           + i.x + vec4(0.0, i1.x, i2.x, 1.0 ));\n  float n_ = 0.142857142857;\n  vec3 ns = n_ * D.wyz - D.xzx;\n  vec4 j = p - 49.0 * floor(p * ns.z * ns.z);\n  vec4 x_ = floor(j * ns.z);\n  vec4 y_ = floor(j - 7.0 * x_ );\n  vec4 x = x_ *ns.x + ns.yyyy;\n  vec4 y = y_ *ns.x + ns.yyyy;\n  vec4 h = 1.0 - abs(x) - abs(y);\n  vec4 b0 = vec4( x.xy, y.xy );\n  vec4 b1 = vec4( x.zw, y.zw );\n  vec4 s0 = floor(b0)*2.0 + 1.0;\n  vec4 s1 = floor(b1)*2.0 + 1.0;\n  vec4 sh = -step(h, vec4(0.0));\n  vec4 a0 = b0.xzyw + s0.xzyw*sh.xxyy ;\n  vec4 a1 = b1.xzyw + s1.xzyw*sh.zzww ;\n  vec3 p0 = vec3(a0.xy,h.x);\n  vec3 p1 = vec3(a0.zw,h.y);\n  vec3 p2 = vec3(a1.xy,h.z);\n  vec3 p3 = vec3(a1.zw,h.w);\n  vec4 norm = taylorInvSqrt(vec4(dot(p0,p0), dot(p1,p1), dot(p2, p2), dot(p3,p3)));\n  p0 *= norm.x;\n  p1 *= norm.y;\n  p2 *= norm.z;\n  p3 *= norm.w;\n  vec4 m = max(0.6 - vec4(dot(x0,x0), dot(x1,x1), dot(x2,x2), dot(x3,x3)), 0.0);\n  m = m * m;\n  return 42.0 * dot( m*m, vec4( dot(p0,x0), dot(p1,x1),\n                                dot(p2,x2), dot(p3,x3) ) );\n}\n\n//uniform float time;\nfloat time = 0.1;\nvarying vec3 v_texCoord3D;\nvoid main( void )\n{\n	vec3 uvw = v_texCoord3D + 0.1*vec3(snoise(v_texCoord3D + vec3(0.0, 0.0, time)),\n			snoise(v_texCoord3D + vec3(43.0, 17.0, time)),\n			snoise(v_texCoord3D + vec3(-17.0, -43.0, time)));\n	float n = snoise(uvw - vec3(0.0, 0.0, time));\n	n += 0.5 * snoise(uvw * 2.0 - vec3(0.0, 0.0, time*1.4));\n	n += 0.25 * snoise(uvw * 4.0 - vec3(0.0, 0.0, time*2.0));\n	n += 0.125 * snoise(uvw * 8.0 - vec3(0.0, 0.0, time*2.8));\n	n += 0.0625 * snoise(uvw * 16.0 - vec3(0.0, 0.0, time*4.0));\n	n += 0.03125 * snoise(uvw * 32.0 - vec3(0.0, 0.0, time*5.6));\n	n = n * 0.7;\n	gl_FragColor = vec4(vec3(1.0, 0.5, 0.0) + vec3(n, n, n), 1.0);\n}\n\n*/\n/*\n#ifdef GL_ES\nprecision highp float;\n#endif\n\nvoid main(void) {\n	gl_FragColor = vec4(1.0, 1.0, 1.0, 1.0);\n}\n*/\n\n//XXX:Working\n#ifdef GL_ES\nprecision highp float;\n#endif\n\nvec4 permute(vec4 x)\n{\n  return mod(((x*34.0)+1.0)*x, 289.0);\n}\nvec4 taylorInvSqrt(vec4 r)\n{\n  return 1.79284291400159 - 0.85373472095314 * r;\n}\nfloat snoise(vec3 v)\n{\n  const vec2 C = vec2(1.0/6.0, 1.0/3.0) ;\n  const vec4 D = vec4(0.0, 0.5, 1.0, 2.0);\n  vec3 i = floor(v + dot(v, C.yyy) );\n  vec3 x0 = v - i + dot(i, C.xxx) ;\n  vec3 g = step(x0.yzx, x0.xyz);\n  vec3 l = 1.0 - g;\n  vec3 i1 = min( g.xyz, l.zxy );\n  vec3 i2 = max( g.xyz, l.zxy );\n  vec3 x1 = x0 - i1 + C.xxx;\n  vec3 x2 = x0 - i2 + C.yyy;\n  vec3 x3 = x0 - D.yyy;\n  i = mod(i, 289.0 );\n  vec4 p = permute( permute( permute(\n             i.z + vec4(0.0, i1.z, i2.z, 1.0 ))\n           + i.y + vec4(0.0, i1.y, i2.y, 1.0 ))\n           + i.x + vec4(0.0, i1.x, i2.x, 1.0 ));\n  float n_ = 0.142857142857;\n  vec3 ns = n_ * D.wyz - D.xzx;\n  vec4 j = p - 49.0 * floor(p * ns.z * ns.z);\n  vec4 x_ = floor(j * ns.z);\n  vec4 y_ = floor(j - 7.0 * x_ );\n  vec4 x = x_ *ns.x + ns.yyyy;\n  vec4 y = y_ *ns.x + ns.yyyy;\n  vec4 h = 1.0 - abs(x) - abs(y);\n  vec4 b0 = vec4( x.xy, y.xy );\n  vec4 b1 = vec4( x.zw, y.zw );\n  vec4 s0 = floor(b0)*2.0 + 1.0;\n  vec4 s1 = floor(b1)*2.0 + 1.0;\n  vec4 sh = -step(h, vec4(0.0));\n  vec4 a0 = b0.xzyw + s0.xzyw*sh.xxyy ;\n  vec4 a1 = b1.xzyw + s1.xzyw*sh.zzww ;\n  vec3 p0 = vec3(a0.xy,h.x);\n  vec3 p1 = vec3(a0.zw,h.y);\n  vec3 p2 = vec3(a1.xy,h.z);\n  vec3 p3 = vec3(a1.zw,h.w);\n  vec4 norm = taylorInvSqrt(vec4(dot(p0,p0), dot(p1,p1), dot(p2, p2), dot(p3,p3)));\n  p0 *= norm.x;\n  p1 *= norm.y;\n  p2 *= norm.z;\n  p3 *= norm.w;\n  vec4 m = max(0.6 - vec4(dot(x0,x0), dot(x1,x1), dot(x2,x2), dot(x3,x3)), 0.0);\n  m = m * m;\n  return 42.0 * dot( m*m, vec4( dot(p0,x0), dot(p1,x1),\n                                dot(p2,x2), dot(p3,x3) ) );\n}\n\n//TODO : Pass in as uniform\n//UNIFORMS\nfloat uFrequencyCeiling = 1024.0;\nfloat uFrequencyFloor = 32.0;\nvec4 uColorCeiling0 = vec4(0.01,0.01,0.01,1.0);\nvec4 uColorCeiling1 = vec4(0.0,0.0,0.0,1.0);\nvec4 uColorFloor0 = vec4(0.1,0.1,0.1,1.0);\nvec4 uColorFloor1 = vec4(0.2,0.2,0.2,1.0);\n\nvarying vec2 vTextureCoord;\n\n//uniform sampler2D uSampler;\n\nuniform int uProcTextureType;\n\nvarying vec3 v_texCoord3D;\nfloat time = 0.1;\n\n//MAIN\nvoid main(void) {\n	vec3 uvw = v_texCoord3D + 0.1*vec3(snoise(v_texCoord3D + vec3(0.0, 0.0, time)),\n			snoise(v_texCoord3D + vec3(43.0, 17.0, time)),\n			snoise(v_texCoord3D + vec3(-17.0, -43.0, time)));\n/*\n	//http://www.noisemachine.com/talk1/22.html\n	float n = snoise(uvw - vec3(0.0, 0.0, time));\n	n += 0.5 * snoise(uvw * 2.0 - vec3(0.0, 0.0, time*1.4));\n	n += 0.25 * snoise(uvw * 4.0 - vec3(0.0, 0.0, time*2.0));\n	n += 0.125 * snoise(uvw * 8.0 - vec3(0.0, 0.0, time*2.8));\n	n += 0.0625 * snoise(uvw * 16.0 - vec3(0.0, 0.0, time*4.0));\n	n += 0.03125 * snoise(uvw * 32.0 - vec3(0.0, 0.0, time*5.6));\n	n = n * 0.7;\n	*/\n	\n	float n = 0.5; //x coord of surface location\n	n += snoise(uvw - vec3(0.0, 0.0, time));\n	n += 0.5 * snoise(uvw * 2.0 - vec3(0.0, 0.0, time*1.4));\n	n += 0.25 * snoise(uvw * 4.0 - vec3(0.0, 0.0, time*2.0));\n	n += 0.125 * snoise(uvw * 8.0 - vec3(0.0, 0.0, time*2.8));\n	n += 0.0625 * snoise(uvw * 16.0 - vec3(0.0, 0.0, time*4.0));\n	n += 0.03125 * snoise(uvw * 32.0 - vec3(0.0, 0.0, time*5.6));\n	n = sin(n);\n\n	if(uProcTextureType == 0)\n	{\n		gl_FragColor = vec4(vec3(0.0, -0.9, -0.9) + vec3(n, n, n), 1.0); //Wall material\n	}\n	else if (uProcTextureType == 1)\n	{\n		gl_FragColor = vec4( vec3(1.0 - (0.450980*n),1.0-(0.184314*n), 1.0 - (0.074510*n)), 1.0); //Inverted? XXX:Beautiful skybox\n	}\n	else if (uProcTextureType == 2)\n	{\n		gl_FragColor = vec4(1.0,1.0,1.0,1.0);\n	}\n	else if (uProcTextureType == 3)\n	{\n		//Ceiling\n		vec2 texCoord = mod(floor(vTextureCoord * float(uFrequencyCeiling*2.0)), 2.0);\n		float delta = abs(texCoord.x - texCoord.y);\n	\n		gl_FragColor = mix(uColorCeiling1, uColorCeiling0, delta);\n	}\n	else if (uProcTextureType == 4)\n	{\n		//Floor\n		vec2 texCoord = mod(floor(vTextureCoord * float(uFrequencyFloor*2.0)), 2.0);\n		float delta = abs(texCoord.x - texCoord.y);\n	\n		gl_FragColor = mix(uColorFloor1, uColorFloor0, delta);\n	}\n	\n\n//	gl_FragColor = vec4(vec3(1.0, 0.5, 0.0) + vec3(n, n, n), 1.0);\n\n\n\n	//gl_FragColor = vec4(vec3(0.0, 0.0, 0.1) + vec3(n, n, n), 1.0);\n//	gl_FragColor = vec4( vec3(0.549020,0.815686,0.925490) + vec3(n,n,n), 1.0);\n//	gl_FragColor = vec4( vec3(0.549020*n,0.815686 *n, 0.925490*n), 1.0); //Blue + black, if we could invert...\n\n//	gl_FragColor = vec4( vec3(1.0 - (0.450980*n),1.0-(0.184314*n), 1.0 - (0.074510*n)), 1.0); //Inverted? XXX:Beautiful skybox\n	\n//	gl_FragColor = vec4( vec3(1.0 - (0.549020*n),1.0-(0.815686*n), 1.0 - (0.925490*n)), 1.0);\n//	gl_FragColor = vec4( vec3((1.0 - n) * 0.549020,(1.0-n)*0.815686, (1.0 - n) * 0.925490), 1.0);\n//	gl_FragColor = vec4( vec3((1.0 - 0.549020) * n,(1.0-0.815686)*n, (1.0 - 0.925490) * n), 1.0); //desert\n\n\n	\n	//gl_FragColor = mix(uColor1, uColor0, delta);\n}\n";
      }
      public String getName() {
        return "fragmentShader";
      }
    }
    ;
  }
  private static class fragmentShaderInitializer {
    static {
      _instance0.fragmentShaderInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return fragmentShader;
    }
  }
  public com.google.gwt.resources.client.TextResource fragmentShader() {
    return fragmentShaderInitializer.get();
  }
  private void pillarsInitializer() {
    pillars = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/tmp/new/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/main/pillars.txt
      public String getText() {
        return "0.5 2.0 0.0 0.0 6.0\n0.5 0.0 0.0 0.0 0.0\n0.4045085 0.0 0.29389262 6.0 0.0\n0.5 2.0 0.0 0.0 6.0\n0.4045085 2.0 0.29389262 6.0 6.0\n0.4045085 0.0 0.29389262 6.0 0.0\n0.4045085 2.0 0.29389262 0.0 6.0\n0.4045085 0.0 0.29389262 0.0 0.0\n0.15450849 0.0 0.47552827 6.0 0.0\n0.4045085 2.0 0.29389262 0.0 6.0\n0.15450849 2.0 0.47552827 6.0 6.0\n0.15450849 0.0 0.47552827 6.0 0.0\n0.15450849 2.0 0.47552827 0.0 6.0\n0.15450849 0.0 0.47552827 0.0 0.0\n-0.15450847 0.0 0.47552827 6.0 0.0\n0.15450849 2.0 0.47552827 0.0 6.0\n-0.15450847 2.0 0.47552827 6.0 6.0\n-0.15450847 0.0 0.47552827 6.0 0.0\n-0.15450847 2.0 0.47552827 0.0 6.0\n-0.15450847 0.0 0.47552827 0.0 0.0\n-0.40450853 0.0 0.2938926 6.0 0.0\n-0.15450847 2.0 0.47552827 0.0 6.0\n-0.40450853 2.0 0.2938926 6.0 6.0\n-0.40450853 0.0 0.2938926 6.0 0.0\n-0.40450853 2.0 0.2938926 0.0 6.0\n-0.40450853 0.0 0.2938926 0.0 0.0\n-0.5 0.0 -4.371139E-8 6.0 0.0\n-0.40450853 2.0 0.2938926 0.0 6.0\n-0.5 2.0 -4.371139E-8 6.0 6.0\n-0.5 0.0 -4.371139E-8 6.0 0.0\n-0.5 2.0 -4.371139E-8 0.0 6.0\n-0.5 0.0 -4.371139E-8 0.0 0.0\n-0.40450853 0.0 -0.29389256 6.0 0.0\n-0.5 2.0 -4.371139E-8 0.0 6.0\n-0.40450853 2.0 -0.29389256 6.0 6.0\n-0.40450853 0.0 -0.29389256 6.0 0.0\n-0.40450853 2.0 -0.29389256 0.0 6.0\n-0.40450853 0.0 -0.29389256 0.0 0.0\n-0.15450855 0.0 -0.47552824 6.0 0.0\n-0.40450853 2.0 -0.29389256 0.0 6.0\n-0.15450855 2.0 -0.47552824 6.0 6.0\n-0.15450855 0.0 -0.47552824 6.0 0.0\n-0.15450855 2.0 -0.47552824 0.0 6.0\n-0.15450855 0.0 -0.47552824 0.0 0.0\n0.15450856 0.0 -0.47552824 6.0 0.0\n-0.15450855 2.0 -0.47552824 0.0 6.0\n0.15450856 2.0 -0.47552824 6.0 6.0\n0.15450856 0.0 -0.47552824 6.0 0.0\n0.15450856 2.0 -0.47552824 0.0 6.0\n0.15450856 0.0 -0.47552824 0.0 0.0\n0.40450847 0.0 -0.29389265 6.0 0.0\n0.15450856 2.0 -0.47552824 0.0 6.0\n0.40450847 2.0 -0.29389265 6.0 6.0\n0.40450847 0.0 -0.29389265 6.0 0.0\n0.40450847 2.0 -0.29389265 0.0 6.0\n0.40450847 0.0 -0.29389265 0.0 0.0\n0.5 0.0 8.742278E-8 6.0 0.0\n0.40450847 2.0 -0.29389265 0.0 6.0\n0.5 2.0 8.742278E-8 6.0 6.0\n0.5 0.0 8.742278E-8 6.0 0.0";
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
  private void vertexShaderInitializer() {
    vertexShader = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/tmp/new/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/main/vertex-shader.txt
      public String getText() {
        return "/*\nattribute vec3 vertexPosition;\nattribute vec2 texPosition;\nuniform mat4 projectionMatrix;\nvarying vec2 texCoord;\n\n\nvoid main() {\n	gl_Position = projectionMatrix * vec4(vertexPosition, 1.0);\n	texCoord = texPosition;\n}\n*/\n/*\n//XXX:Working\n//Newer\nattribute vec3 aVertexPosition;\nattribute vec2 aTextureCoord;\n\nuniform mat4 uMVMatrix;\nuniform mat4 uPMatrix;\n\nvarying vec2 vTextureCoord;\n\nvoid main(void) {\n//    gl_Position = uPMatrix * uMVMatrix * vec4(aVertexPosition, 1.0);\n	gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);\n    vTextureCoord = aTextureCoord;\n}\n*/\n/*\nuniform mat4 uMVMatrix;\nuniform mat4 uPMatrix;\n\nattribute vec3 aVertexPosition;\nattribute vec2 aTextureCoord;\nvarying vec2 vTextureCoord;\n\nvoid main() \n{\n	vTextureCoord = aTextureCoord;\n	gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);\n}\n*/\n/*\n//Per frag lighting\nuniform mat4 uMatViewInverse;\nuniform mat4 uMatViewProjection;\nuniform vec3 uLightPosition;\nuniform vec3 uEyePosition;\n\nvarying vec2 vTexcoord;\nvarying vec3 vViewDirection;\nvarying vec3 vLightDirection;\n\nattribute vec4 aVertex;\nattribute vec2 aTexcoord0;\nattribute vec3 aNormal;\nattribute vec3 aBinormal;\nattribute vec3 aTangent;\n   \nvoid main( void )\n{\n   // Transform eye vector into world space\n   vec3 eyePositionWorld = (uMatViewInverse * vec4(uEyePosition, 1.0)).xyz;\n   \n   // Compute world-space direction vector\n   vec3 viewDirectionWorld = eyePositionWorld - aVertex.xyz;\n      \n   // Transform light position into world space\n   vec3 lightPositionWorld = (uMatViewInverse * vec4(uLightPosition, 1.0)).xyz;   \n   \n   // Compute world-space light dirction vector\n   vec3 lightDirectionWorld = lightPositionWorld - aVertex.xyz;\n   \n   // Create the tangent matrix\n   mat3 tangentMat = mat3( aTangent, \n                           aBinormal,\n                           aNormal );   \n   \n   // Transform the view and light vectors into tangent space\n   vViewDirection = viewDirectionWorld * tangentMat;\n   vLightDirection = lightDirectionWorld * tangentMat;\n      \n   // Transform output position\n   gl_Position = uMatViewProjection * aVertex;\n   \n   // Pass through texture coordinate\n   vTexcoord = aTexcoord0.xy;\n\n}\n*/\n\n/*\n//TODO:RIPPED CODE\nuniform float time;\nvarying vec2 v_texCoord2D;\nvarying vec3 v_texCoord3D;\nvarying vec4 v_color;\n\nvoid main( void )\n{\n	gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;\n\n	v_texCoord2D = gl_MultiTexCoord0.xy;\n    \n    v_texCoord3D = gl_Vertex.xyz;\n	\n	v_color = gl_Color;\n\n}\n*/\n/*\n//uniform float time;\nfloat time = 0.1;\nvarying vec3 v_texCoord3D;\n\nvoid main( void )\n{\n	gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;\n    v_texCoord3D = gl_Vertex.xyz;\n}\n*/\n/*\nuniform mat4 uMVMatrix;\nuniform mat4 uPMatrix;\n//uniform float time;\n//float time = 0.1;\n\nattribute vec3 aVertexPosition;\nattribute vec2 aTextureCoord;\n//varying vec2 vTextureCoord;\nvarying vec3 v_texCoord3D;\n\nvoid main() \n{\n	//vTextureCoord = aTextureCoord;\n	gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);\n	v_texCoord3D = vec3(aTextureCoord,0);\n}\n*/\n/*\n\nattribute vec3 aVertexPosition;\n\nuniform mat4 uMVMatrix;\nuniform mat4 uPMatrix;\n\nvoid main(void) {\n	gl_Position = uPMatrix * uMVMatrix * vec4(aVertexPosition, 1.0);\n}\n*/\n\n//XXX:Working\n//Newer\nattribute vec3 aVertexPosition;\nattribute vec2 aTextureCoord;\n\nuniform mat4 uMVMatrix;\nuniform mat4 uPMatrix;\n\nvarying vec2 vTextureCoord;\n\nvarying vec3 v_texCoord3D;\n\nvoid main(void) {\n//    gl_Position = uPMatrix * uMVMatrix * vec4(aVertexPosition, 1.0);\n	gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);\n\n/*\n	// Quantise effect - give this a go on highly detailed meshes.\n	float quant = 3.0;\n	gl_Position.x=quant*gl_Position.x/quant+gl_Position.x*0.001;\n	gl_Position.y=quant*gl_Position.y/quant+gl_Position.y*0.001;\n	gl_Position.z=quant*gl_Position.z/quant+gl_Position.z*0.001;\n*/\n	 \n    vTextureCoord = aTextureCoord;\n\n	v_texCoord3D = vec3(aTextureCoord,0);\n}\n";
      }
      public String getName() {
        return "vertexShader";
      }
    }
    ;
  }
  private static class vertexShaderInitializer {
    static {
      _instance0.vertexShaderInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return vertexShader;
    }
  }
  public com.google.gwt.resources.client.TextResource vertexShader() {
    return vertexShaderInitializer.get();
  }
  private void wallsInitializer() {
    walls = new com.google.gwt.resources.client.TextResource() {
      // file:/home/j0n/tmp/new/gwtproc/src/main/java/com/df3n5/gwtproc/client/demos/main/walls.txt
      public String getText() {
        StringBuilder builder = new StringBuilder();
        builder.append("0.0 2.0 0.0 0.0 6.0\n0.0 0.0 0.0 0.0 0.0\n0.3 0.0 0.0 6.0 0.0\n0.0 2.0 0.0 0.0 6.0\n0.3 2.0 0.0 6.0 6.0\n0.3 0.0 0.0 6.0 0.0\n0.3 2.0 0.0 0.0 6.0\n0.3 1.1 0.0 0.0 0.0\n0.8 1.1 0.0 6.0 0.0\n0.3 2.0 0.0 0.0 6.0\n0.8 2.0 0.0 6.0 6.0\n0.8 1.1 0.0 6.0 0.0\n0.3 0.5 0.0 0.0 6.0\n0.3 0.0 0.0 0.0 0.0\n0.8 0.0 0.0 6.0 0.0\n0.3 0.5 0.0 0.0 6.0\n0.8 0.5 0.0 6.0 6.0\n0.8 0.0 0.0 6.0 0.0\n0.8 2.0 0.0 0.0 6.0\n0.8 0.0 0.0 0.0 0.0\n6.0 0.0 0.0 6.0 0.0\n0.8 2.0 0.0 0.0 6.0\n6.0 2.0 0.0 6.0 6.0\n6.0 0.0 0.0 6.0 0.0\n0.0 2.0 0.0 0.0 6.0\n0.0 0.0 0.0 0.0 0.0\n0.0 0.0 4.0 6.0 0.0\n0.0 2.0 0.0 0.0 6.0\n0.0 2.0 4.0 6.0 6.0\n0.0 0.0 4.0 6.0 0.0\n6.0 2.0 0.0 0.0 6.0\n6.0 0.0 0.0 0.0 0.0\n6.0 0.0 4.0 6.0 0.0\n6.0 2.0 0.0 0.0 6.0\n6.0 2.0 4.0 6.0 6.0\n6.0 0.0 4.0 6.0 0.0\n0.0 2.0 4.0 0.0 6.0\n0.0 0.0 4.0 0.0 0.0\n6.0 0.0 4.0 6.0 0.0\n0.0 2.0 4.0 0.0 6.0\n6.0 2.0 4.0 6.0 6.0\n6.0 0.0 4.0 6.0 0.0\n0.0 2.0 4.0 0.0 6.0\n0.0 0.0 4.0 0.0 0.0\n0.3 0.0 4.0 6.0 0.0\n0.0 2.0 4.0 0.0 6.0\n0.3 2.0 4.0 6.0 6.0\n0.3 0.0 4.0 6.0 0.0\n0.3 2.0 4.0 0.0 6.0\n0.3 1.1 4.0 0.0 0.0\n0.8 1.1 4.0 6.0 0.0\n0.3 2.0 4.0 0.0 6.0\n0.8 2.0 4.0 6.0 6.0\n0.8 1.1 4.0 6.0 0.0\n0.3 0.5 4.0 0.0 6.0\n0.3 0.0 4.0 0.0 0.0\n0.8 0.0 4.0 6.0 0.0\n0.3 0.5 4.0 0.0 6.0\n0.8 0.5 4.0 6.0 6.0\n0.8 0.0 4.0 6.0 0.0\n0.8 2.0 4.0 0.0 6.0\n0.8 0.0 4.0 0.0 0.0\n3.0 0.0 4.0 6.0 0.0\n0.8 2.0 4.0 0.0 6.0\n3.0 2.0 4.0 6.0 6.0\n3.0 0.0 4.0 6.0 0.0\n0.0 2.0 4.0 0.0 6.0\n0.0 0.0 4.0 0.0 0.0\n0.0 0.0 8.0 6.0 0.0\n0.0 2.0 4.0 0.0 6.0\n0.0 2.0 8.0 6.0 6.0\n0.0 0.0 8.0 6.0 0.0\n3.0 2.0 4.0 0.0 6.0\n3.0 0.0 4.0 0.0 0.0\n3.0 0.0 8.0 6.0 0.0\n3.0 2.0 4.0 0.0 6.0\n3.0 2.0 8.0 6.0 6.0\n3.0 0.0 8.0 6.0 0.0\n0.0 2.0 8.0 0.0 6.0\n0.0 0.0 8.0 0.0 0.0\n3.0 0.0 8.0 6.0 0.0\n0.0 2.0 8.0 0.0 6.0\n3.0 2.0 8.0 6.0 6.0\n3.0 0.0 8.0 6.0 0.0\n0.0 2.0 8.0 0.0 6.0\n0.0 0.0 8.0 0.0 0.0\n0.3 0.0 8.0 6.0 0.0\n0.0 2.0 8.0 0.0 6.0\n0.3 2.0 8.0 6.0 6.0\n0.3 0.0 8.0 6.0 0.0\n0.3 2.0 8.0 0.0 6.0\n0.3 1.1 8.0 0.0 0.0\n0.8 1.1 8.0 6.0 0.0\n0.3 2.0 8.0 0.0 6.0\n0.8 2.0 8.0 6.0 6.0\n0.8 1.1 8.0 6.0 0.0\n0.3 0.5 8.0 0.0 6.0\n0.3 0.0 8.0 0.0 0.0\n0.8 0.0 8.0 6.0 0.0\n0.3 0.5 8.0 0.0 6.0\n0.8 0.5 8.0 6.0 6.0\n0.8 0.0 8.0 6.0 0.0\n0.8 2.0 8.0 0.0 6.0\n0.8 0.0 8.0 0.0 0.0\n3.0 0.0 8.0 6.0 0.0\n0.8 2.0 8.0 0.0 6.0\n3.0 2.0 8.0 6.0 6.0\n3.0 0.0 8.0 6.0 0.0\n0.0 2.0 8.0 0.0 6.0\n0.0 0.0 8.0 0.0 0.0\n0.0 0.0 12.0 6.0 0.0\n0.0 2.0 8.0 0.0 6.0\n0.0 2.0 12.0 6.0 6.0\n0.0 0.0 12.0 6.0 0.0\n3.0 2.0 8.0 0.0 6.0\n3.0 0.0 8.0 0.0 0.0\n3.0 0.0 12.0 6.0 0.0\n3.0 2.0 8.0 0.0 6.0\n3.0 2.0 12.0 6.0 6.0\n3.0 0.0 12.0 6.0 0.0\n0.0 2.0 12.0 0.0 6.0\n0.0 0.0 12.0 0.0 0.0\n3.0 0.0 12.0 6.0 0.0\n0.0 2.0 12.0 0.0 6.0\n3.0 2.0 12.0 6.0 6.0\n3.0 0.0 12.0 6.0 0.0\n0.0 2.0 12.0 0.0 6.0\n0.0 0.0 12.0 0.0 0.0\n0.3 0.0 12.0 6.0 0.0\n0.0 2.0 12.0 0.0 6.0\n0.3 2.0 12.0 6.0 6.0\n0.3 0.0 12.0 6.0 0.0\n0.3 2.0 12.0 0.0 6.0\n0.3 1.1 12.0 0.0 0.0\n0.8 1.1 12.0 6.0 0.0\n0.3 2.0 12.0 0.0 6.0\n0.8 2.0 12.0 6.0 6.0\n0.8 1.1 12.0 6.0 0.0\n0.3 0.5 12.0 0.0 6.0\n0.3 0.0 12.0 0.0 0.0\n0.8 0.0 12.0 6.0 0.0\n0.3 0.5 12.0 0.0 6.0\n0.8 0.5 12.0 6.0 6.0\n0.8 0.0 12.0 6.0 0.0\n0.8 2.0 12.0 0.0 6.0\n0.8 0.0 12.0 0.0 0.0\n3.0 0.0 12.0 6.0 0.0\n0.8 2.0 12.0 0.0 6.0\n3.0 2.0 12.0 6.0 6.0\n3.0 0.0 12.0 6.0 0.0\n0.0 2.0 12.0 0.0 6.0\n0.0 0.0 12.0 0.0 0.0\n0.0 0.0 16.0 6.0 0.0\n0.0 2.0 12.0 0.0 6.0\n0.0 2.0 16.0 6.0 6.0\n0.0 0.0 16.0 6.0 0.0\n3.0 2.0 12.0 0.0 6.0\n3.0 0.0 12.0 0.0 0.0\n3.0 0.0 16.0 6.0 0.0\n3.0 2.0 12.0 0.0 6.0\n3.0 2.0 16.0 6.0 6.0\n3.0 0.0 16.0 6.0 0.0\n0.0 2.0 16.0 0.0 6.0\n0.0 0.0 16.0 0.0 0.0\n3.0 0.0 16.0 6.0 0.0\n0.0 2.0 16.0 0.0 6.0\n3.0 2.0 16.0 6.0 6.0\n3.0 0.0 16.0 6.0 0.0\n0.0 2.0 16.0 0.0 6.0\n0.0 0.0 16.0 0.0 0.0\n0.3 0.0 16.0 6.0 0.0\n0.0 2.0 16.0 0.0 6.0\n0.3 2.0 16.0 6.0 6.0\n0.3 0.0 16.0 6.0 0.0\n0.3 2.0 16.0 0.0 6.0\n0.3 1.1 16.0 0.0 0.0\n0.8 1.1 16.0 6.0 0.0\n0.3 2.0 16.0 0.0 6.0\n0.8 2.0 16.0 6.0 6.0\n0.8 1.1 16.0 6.0 0.0\n0.3 0.5 16.0 0.0 6.0\n0.3 0.0 16.0 0.0 0.0\n0.8 0.0 16.0 6.0 0.0\n0.3 0.5 16.0 0.0 6.0\n0.8 0.5 16.0 6.0 6.0\n0.8 0.0 16.0 6.0 0.0\n0.8 2.0 16.0 0.0 6.0\n0.8 0.0 16.0 0.0 0.0\n3.0 0.0 16.0 6.0 0.0\n0.8 2.0 16.0 0.0 6.0\n3.0 2.0 16.0 6.0 6.0\n3.0 0.0 16.0 6.0 0.0\n0.0 2.0 16.0 0.0 6.0\n0.0 0.0 16.0 0.0 0.0\n0.0 0.0 20.0 6.0 0.0\n0.0 2.0 16.0 0.0 6.0\n0.0 2.0 20.0 6.0 6.0\n0.0 0.0 20.0 6.0 0.0\n3.0 2.0 16.0 0.0 6.0\n3.0 0.0 16.0 0.0 0.0\n3.0 0.0 20.0 6.0 0.0\n3.0 2.0 16.0 0.0 6.0\n3.0 2.0 20.0 6.0 6.0\n3.0 0.0 20.0 6.0 0.0\n0.0 2.0 20.0 0.0 6.0\n0.0 0.0 20.0 0.0 0.0\n3.0 0.0 20.0 6.0 0.0\n0.0 2.0 20.0 0.0 6.0\n3.0 2.0 20.0 6.0 6.0\n3.0 0.0 20.0 6.0 0.0\n0.0 2.0 20.0 0.0 6.0\n0.0 0.0 20.0 0.0 0.0\n0.3 0.0 20.0 6.0 0.0\n0.0 2.0 20.0 0.0 6.0\n0.3 2.0 20.0 6.0 6.0\n0.3 0.0 20.0 6.0 0.0\n0.3 2.0 20.0 0.0 6.0\n0.3 1.1 20.0 0.0 0.0\n0.8 1.1 20.0 6.0 0.0\n0.3 2.0 20.0 0.0 6.0\n0.8 2.0 20.0 6.0 6.0\n0.8 1.1 20.0 6.0 0.0\n0.3 0.5 20.0 0.0 6.0\n0.3 0.0 20.0 0.0 0.0\n0.8 0.0 20.0 6.0 0.0\n0.3 0.5 20.0 0.0 6.0\n0.8 0.5 20.0 6.0 6.0\n0.8 0.0 20.0 6.0 0.0\n0.8 2.0 20.0 0.0 6.0\n0.8 0.0 20.0 0.0 0.0\n3.0 0.0 20.0 6.0 0.0\n0.8 2.0 20.0 0.0 6.0\n3.0 2.0 20.0 6.0 6.0\n3.0 0.0 20.0 6.0 0.0\n0.0 2.0 20.0 0.0 6.0\n0.0 0.0 20.0 0.0 0.0\n0.0 0.0 24.0 6.0 0.0\n0.0 2.0 20.0 0.0 6.0\n0.0 2.0 24.0 6.0 6.0\n0.0 0.0 24.0 6.0 0.0\n3.0 2.0 20.0 0.0 6.0\n3.0 0.0 20.0 0.0 0.0\n3.0 0.0 24.0 6.0 0.0\n3.0 2.0 20.0 0.0 6.0\n3.0 2.0 24.0 6.0 6.0\n3.0 0.0 24.0 6.0 0.0\n0.0 2.0 24.0 0.0 6.0\n0.0 0.0 24.0 0.0 0.0\n3.0 0.0 24.0 6.0 0.0\n0.0 2.0 24.0 0.0 6.0\n3.0 2.0 24.0 6.0 6.0\n3.0 0.0 24.0 6.0 0.0\n0.0 2.0 24.0 0.0 6.0\n0.0 0.0 24.0 0.0 0.0\n0.3 0.0 24.0 6.0 0.0\n0.0 2.0 24.0 0.0 6.0\n0.3 2.0 24.0 6.0 6.0\n0.3 0.0 24.0 6.0 0.0\n0.3 2.0 24.0 0.0 6.0\n0.3 1.1 24.0 0.0 0.0\n0.8 1.1 24.0 6.0 0.0\n0.3 2.0 24.0 0.0 6.0\n0.8 2.0 24.0 6.0 6.0\n0.8 1.1 24.0 6.0 0.0\n0.3 0.5 24.0 0.0 6.0\n0.3 0.0 24.0 0.0 0.0\n0.8 0.0 24.0 6.0 0.0\n0.3 0.5 24.0 0.0 6.0\n0.8 0.5 24.0 6.0 6.0\n0.8 0.0 24.0 6.0 0.0\n0.8 2.0 24.0 0.0 6.0\n0.8 0.0 24.0 0.0 0.0\n6.0 0.0 24.0 6.0 0.0\n0.8 2.0 24.0 0.0 6.0\n6.0 2.0 24.0 6.0 6.0\n6.0 0.0 24.0 6.0 0.0\n0.0 2.0 24.0 0.0 6.0\n0.0 0.0 24.0 0.0 0.0\n0.0 0.0 28.0 6.0 0.0\n0.0 2.0 24.0 0.0 6.0\n0.0 2.0 28.0 6.0 6.0\n0.0 0.0 28.0 6.0 0.0\n6.0 2.0 24.0 0.0 6.0\n6.0 0.0 24.0 0.0 0.0\n6.0 0.0 28.0 6.0 0.0\n6.0 2.0 24.0 0.0 6.0\n6.0 2.0 28.0 6.0 6.0\n6.0 0.0 28.0 6.0 0.0\n0.0 2.0 28.0 0.0 6.0\n0.0 0.0 28.0 0.0 0.0\n6.0 0.0 28.0 6.0 0.0\n0.0 2.0 28.0 0.0 6.0\n6.0 2.0 28.0 6.0 6.0\n6.0 0.0 28.0 6.0 0.0\n6.0 2.0 0.0 0.0 6.0\n6.0 0.0 0.0 0.0 0.0\n6.3 0.0 0.0 6.0 0.0\n6.0 2.0 0.0 0.0 6.0\n6.3 2.0 0.0 6.0 6.0\n6.3 0.0 0.0 6.0 0.0\n6.3 2.0 0.0 0.0 6.0\n6.3 1.1 0.0 0.0 0.0\n6.8 1.1 0.0 6.0 0.0\n6.3 2.0 0.0 0.0 6.0\n6.8 2.0 0.0 6.0 6.0\n6.8 1.1 0.0 6.0 0.0\n6.3 0.5 0.0 0.0 6.0\n6.3 0.0 0.0 0.0 0.0\n6.8 0.0 0.0 6.0 0.0\n6.3 0.5 0.0 0.0 6.0\n6.8 0.5 0.0 6.0 6.0\n6.8 0.0 0.0 6.0 0.0\n6.8 2.0 0.0 0.0 6.0\n6.8 0.0 0.0 0.0 0.0\n9.0 0.0 0.0 6.0 0.0\n6.8 2.0 0.0 0.0 6.0\n9.0 2.0 0.0 6.0 6.0\n9.0 0.0 0.0 6.0 0.0\n6.0 2.0 0.0 0.0 6.0\n6.0 0.0 0.0 0.0 0.0\n6.0 0.0 4.0 6.0 0.0\n6.0 2.0 0.0 0.0 6.0\n6.0 2.0 4.0 6.0 6.0\n6.0 0.0 4.0 6.0 0.0\n9.0 2.0 0.0 0.0 6.0\n9.0 0.0 0.0 0.0 0.0\n9.0 0.0 4.0 6.0 0.0\n9.0 2.0 0.0 0.0 6.0\n9.0 2.0 4.0 6.0 6.0\n9.0 0.0 4.0 6.0 0.0\n6.0 2.0 4.0 0.0 6.0\n6.0 0.0 4.0 0.0 0.0\n9.0 0.0 4.0 6.0 0.0\n6.0 2.0 4.0 0.0 6.0\n9.0 2.0 4.0 6.0 6.0\n9.0 0.0 4.0 6.0 0.0\n6.0 2.0 8.0 0.0 6.0\n6.0 0.0 8.0 0.0 0.0\n6.3 0.0 8.0 6.0 0.0\n6.0 2.0 8.0 0.0 6.0\n6.3 2.0 8.0 6.0 6.0\n6.3 0.0 8.0 6.0 0.0\n6.3 2.0 8.0 0.0 6.0\n6.3 1.1 8.0 0.0 0.0\n6.8 1.1 8.0 6.0 0.0\n6.3 2.0 8.0 0.0 6.0\n6.8 2.0 8.0 6.0 6.0\n6.8 1.1 8.0 6.0 0.0\n6.3 0.5 8.0 0.0 6.0\n6.3 0.0 8.0 0.0 0.0\n6.8 0.0 8.0 6.0 0.0\n6.3 0.5 8.0 0.0 6.0\n6.8 0.5 8.0 6.0 6.0\n6.8 0.0 8.0 6.0 0.0\n6.8 2.0 8.0 0.0 6.0\n6.8 0.0 8.0 0.0 0.0\n9.0 0.0 8.0 6.0 0.0\n6.8 2.0 8.0 0.0 6.0\n9.0 2.0 8.0 6.0 6.0\n9.0 0.0 8.0 6.0 0.0\n6.0 2.0 8.0 0.0 6.0\n6.0 0.0 8.0 0.0 0.0\n6.0 0.0 12.0 6.0 0.0\n6.0 2.0 8.0 0.0 6.0\n6.0 2.0 12.0 6.0 6.0\n6.0 0.0 12.0 6.0 0.0\n9.0 2.0 8.0 0.0 6.0\n9.0 0.0 8.0 0.0 0.0\n9.0 0.0 12.0 6.0 0.0\n9.0 2.0 8.0 0.0 6.0\n9.0 2.0 12.0 6.0 6.0\n9.0 0.0 12.0 6.0 0.0\n6.0 2.0 12.0 0.0 6.0\n6.0 0.0 12.0 0.0 0.0\n9.0 0.0 12.0 6.0 0.0\n6.0 2.0 12.0 0.0 6.0\n9.0 2.0 12.0 6.0 6.0\n9.0 0.0 12.0 6.0 0.0\n6.0 2.0 12.0 0.0 6.0\n6.0 0.0 12.0 0.0 0.0\n6.3 0.0 12.0 6.0 0.0\n6.0 2.0 12.0 0.0 6.0\n6.3 2.0 12.0 6.0 6.0\n6.3 0.0 12.0 6.0 0.0\n6.3 2.0 12.0 0.0 6.0\n6.3 1.1 12.0 0.0 0.0\n6.8 1.1 12.0 6.0 0.0\n6.3 2.0 12.0 0.0 6.0\n6.8 2.0 12.0 6.0 6.0\n6.8 1.1 12.0 6.0 0.0\n6.3 0.5 12.0 0.0 6.0\n6.3 0.0 12.0 0.0 0.0\n6.8 0.0 12.0 6.0 0.0\n6.3 0.5 12.0 0.0 6.0\n6.8 0.5 12.0 6.0 6.0\n6.8 0.0 12.0 6.0 0.0\n6.8 2.0 12.0 0.0 6.0\n6.8 0.0 12.0 0.0 0.0\n9.0 0.0 12.0 6.0 0.0\n6.8 2.0 12.0 0.0 6.0\n9.0 2.0 12.0 6.0 6.0\n9.0 0.0 12.0 6.0 0.0\n6.0 2.0 12.0 0.0 6.0\n6.0 0.0 12.0 0.0 0.0\n6.0 0.0 16.0 6.0 0.0\n6.0 2.0 12.0 0.0 6.0\n6.0 2.0 16.0 6.0 6.0\n6.0 0.0 16.0 6.0 0.0\n9.0 2.0 12.0 0.0 6.0\n9.0 0.0 12.0 0.0 0.0\n9.0 0.0 16.0 6.0 0.0\n9.0 2.0 12.0 0.0 6.0\n9.0 2.0 16.0 6.0 6.0\n9.0 0.0 16.0 6.0 0.0\n6.0 2.0 16.0 0.0 6.0\n6.0 0.0 16.0 0.0 0.0\n9.0 0.0 16.0 6.0 0.0\n6.0 2.0 16.0 0.0 6.0\n9.0 2.0 16.0 6.0 6.0\n9.0 0.0 16.0 6.0 0.0\n6.0 2.0 16.0 0.0 6.0\n6.0 0.0 16.0 0.0 0.0\n6.3 0.0 16.0 6.0 0.0\n6.0 2.0 16.0 0.0 6.0\n6.3 2.0 16.0 6.0 6.0\n6.3 0.0 16.0 6.0 0.0\n6.3 2.0 16.0 0.0 6.0\n6.3 1.1 16.0 0.0 0.0\n6.8 1.1 16.0 6.0 0.0\n6.3 2.0 16.0 0.0 6.0\n6.8 2.0 16.0 6.0 6.0\n6.8 1.1 16.0 6.0 0.0\n6.3 0.5 16.0 0.0 6.0\n6.3 0.0 16.0 0.0 0.0\n6.8 0.0 16.0 6.0 0.0\n6.3 0.5 16.0 0.0 6.0\n6.8 0.5 16.0 6.0 6.0\n6.8 0.0 16.0 6.0 0.0\n6.8 2.0 16.0 0.0 6.0\n6.8 0.0 16.0 0.0 0.0\n9.0 0.0 16.0 6.0 0.0\n6.8 2.0 16.0 0.0 6.0\n9.0 2.0 16.0 6.0 6.0\n9.0 0.0 16.0 6.0 0.0\n6.0 2.0 16.0 0.0 6.0\n6.0 0.0 16.0 0.0 0.0\n6.0 0.0 20.0 6.0 0.0\n6.0 2.0 16.0 0.0 6.0\n6.0 2.0 20.0 6.0 6.0\n6.0 0.0 20.0 6.0 0.0\n9.0 2.0 16.0 0.0 6.0\n9.0 0.0 16.0 0.0 0.0\n9.0 0.0 20.0 6.0 0.0\n9.0 2.0 16.0 0.0 6.0\n9.0 2.0 20.0 6.0 6.0\n9.0 0.0 20.0 6.0 0.0\n6.0 2.0 20.0 0.0 6.0\n6.0 0.0 20.0 0.0 0.0\n9.0 0.0 20.0 6.0 0.0\n6.0 2.0 20.0 0.0 6.0\n9.0 2.0 20.0 6.0 6.0\n9.0 0.0 20.0 6.0 0.0\n6.0 2.0 24.0 0.0 6.0\n6.0 0.0 24.0 0.0 0.0\n6.3 0.0 24.0 6.0 0.0\n6.0 2.0 24.0 0.0 6.0\n6.3 2.0 24.0 6.0 6.0\n6.3 0.0 24.0 6.0 0.0\n6.3 2.0 24.0 0.0 6.0\n6.3 1.1 24.0 0.0 0.0\n6.8 1.1 24.0 6.0 0.0\n6.3 2.0 24.0 0.0 6.0\n6.8 2.0 24.0 6.0 6.0\n6.8 1.1 24.0 6.0 0.0\n6.3 0.5 24.0 0.0 6.0\n6.3 0.0 24.0 0.0 0.0\n6.8 0.0 24.0 6.0 0.0\n6.3 0.5 24.0 0.0 6.0\n6.8 0.5 24.0 6.0 6.0\n6.8 0.0 24.0 6.0 0.0\n6.8 2.0 24.0 0.0 6.0\n6.8 0.0 24.0 0.0 0.0\n9.0 0.0 24.0 6.0 0.0\n6.8 2.0 24.0 0.0 6.0\n9.0 2.0 24.0 6.0 6.0\n9.0 0.0 24.0 6.0 0.0\n6.0 2.0 24.0 0.0 6.0\n6.0 0.0 24.0 0.0 0.0\n6.0 0.0 28.0 6.0 0.0\n6.0 2.0 24.0 0.0 6.0\n6.0 2.0 28.0 6.0 6.0\n6.0 0.0 28.0 6.0 0.0\n9.0 2.0 24.0 0.0 6.0\n9.0 0.0 24.0 0.0 0.0\n9.0 0.0 28.0 6.0 0.0\n9.0 2.0 24.0 0.0 6.0\n9.0 2.0 28.0 6.0 6.0\n9.0 0.0 28.0 6.0 0.0\n6.0 2.0 28.0 0.0 6.0\n6.0 0.0 28.0 0.0 0.0\n9.0 0.0 28.0 6.0 0.0\n6.0 2.0 28.0 0.0 6.0\n9.0 2.0 28.0 6.0 6.0\n9.0 0.0 28.0 6.0 0.0\n9.0 2.0 0.0 0.0 6.0\n9.0 0.0 0.0 0.0 0.0\n9.3 0.0 0.0 6.0 0.0\n9.0 2.0 0.0 0.0 6.0\n9.3 2.0 0.0 6.0 6.0\n9.3 0.0 0.0 6.0 0.0\n9.3 2.0 0.0 0.0 6.0\n9.3 1.1 0.0 0.0 0.0\n9.8 1.1 0.0 6.0 0.0\n9.3 2.0 0.0 0.0 6.0\n9.8 2.0 0.0 6.0 6.0\n9.8 1.1 0.0 6.0 0.0\n9.3 0.5 0.0 0.0 6.0\n9.3 0.0 0.0 0.0 0.0\n9.8 0.0 0.0 6.0 0.0\n9.3 0.5 0.0 0.0 6.0\n9.8 0.5 0.0 6.0 6.0\n9.8 0.0 0.0 6.0 0.0\n9.8 2.0 0.0 0.0 6.0\n9.8 0.0 0.0 0.0 0.0\n12.0 0.0 0.0 6.0 0.0\n9.8 2.0 0.0 0.0 6.0\n12.0 2.0 0.0 6.0 6.0\n12.0 0.0 0.0 6.0 0.0\n9.0 2.0 0.0 0.0 6.0\n9.0 0.0 0.0 0.0 0.0\n9.0 0.0 4.0 6.0 0.0\n9.0 2.0 0.0 0.0 6.0\n9.0 2.0 4.0 6.0 6.0\n9.0 0.0 4.0 6.0 0.0\n12.0 2.0 0.0 0.0 6.0\n12.0 0.0 0.0 0.0 0.0\n12.0 0.0 4.0 6.0 0.0\n12.0 2.0 0.0 0.0 6.0\n12.0 2.0 4.0 6.0 6.0\n12.0 0.0 4.0 6.0 0.0\n9.0 2.0 4.0 0.0 6.0\n9.0 0.0 4.0 0.0 0.0\n12.0 0.0 4.0 6.0 0.0\n9.0 2.0 4.0 0.0 6.0\n12.0 2.0 4.0 6.0 6.0\n12.0 0.0 4.0 6.0 0.0\n9.0 2.0 24.0 0.0 6.0\n9.0 0.0 24.0 0.0 0.0\n9.3 0.0 24.0 6.0 0.0\n9.0 2.0 24.0 0.0 6.0\n9.3 2.0 24.0 6.0 6.0\n9.3 0.0 24.0 6.0 0.0\n9.3 2.0 24.0 0.0 6.0\n9.3 1.1 24.0 0.0 0.0\n9.8 1.1 24.0 6.0 0.0\n9.3 2.0 24.0 0.0 6.0\n9.8 2.0 24.0 6.0 6.0\n9.8 1.1 24.0 6.0 0.0\n9.3 0.5 24.0 0.0 6.0\n9.3 0.0 24.0 0.0 0.0\n9.8 0.0 24.0 6.0 0.0\n9.3 0.5 24.0 0.0 6.0\n9.8 0.5 24.0 6.0 6.0\n9.8 0.0 24.0 6.0 0.0\n9.8 2.0 24.0 0.0 6.0\n9.8 0.0 24.0 0.0 0.0\n12.0 0.0 24.0 6.0 0.0\n9.8 2.0 24.0 0.0 6.0\n12.0 2.0 24.0 6.0 6.0\n12.0 0.0 24.0 6.0 0.0\n9.0 2.0 24.0 0.0 6.0\n9.0 0.0 24.0 0.0 0.0\n9.0 0.0 28.0 6.0 0.0\n9.0 2.0 24.0 0.0 6.0\n9.0 2.0 28.0 6.0 6.0\n9.0 0.0 28.0 6.0 0.0\n12.0 2.0 24.0 0.0 6.0\n12.0 0.0 24.0 0.0 0.0\n12.0 0.0 28.0 6.0 0.0\n12.0 2.0 24.0 0.0 6.0\n12.0 2.0 28.0 6.0 6.0\n12.0 0.0 28.0 6.0 0.0\n9.0 2.0 28.0 0.0 6.0\n9.0 0.0 28.0 0.0 0.0\n12.0 0.0 28.0 6.0 0.0\n9.0 2.0 28.0 0.0 6.0\n12.0 2.0 28.0 6.0 6.0\n12.0 0.0 28.0 6.0 0.0\n12.0 2.0 0.0 0.0 6.0\n12.0 0.0 0.0 0.0 0.0\n12.3 0.0 0.0 6.0 0.0\n12.0 2.0 0.0 0.0 6.0\n12.3 2.0 0.0 6.0 6.0\n12.3 0.0 0.0 6.0 0.0\n12.3 2.0 0.0 0.0 6.0\n12.3 1.1 0.0 0.0 0.0\n12.8 1.1 0.0 6.0 0.0\n12.3 2.0 0.0 0.0 6.0\n12.8 2.0 0.0 6.0 6.0\n12.8 1.1 0.0 6.0 0.0\n12.3 0.5 0.0 0.0 6.0\n12.3 0.0 0.0 0.0 0.0\n12.8 0.0 0.0 6.0 0.0\n12.3 0.5 0.0 0.0 6.0\n12.8 0.5 0.0 6.0 6.0\n12.8 0.0 0.0 6.0 0.0\n12.8 2.0 0.0 0.0 6.0\n12.8 0.0 0.0 0.0 0.0\n15.0 0.0 0.0 6.0 0.0\n12.8 2.0 0.0 0.0 6.0\n15.0 2.0 0.0 6.0 6.0\n15.0 0.0 0.0 6.0 0.0\n12.0 2.0 0.0 0.0 6.0\n12.0 0.0 0.0 0.0 0.0\n12.0 0.0 4.0 6.0 0.0\n12.0 2.0 0.0 0.0 6.0\n12.0 2.0 4.0 6.0 6.0\n12.0 0.0 4.0 6.0 0.0\n15.0 2.0 0.0 0.0 6.0\n15.0 0.0 0.0 0.0 0.0\n15.0 0.0 4.0 6.0 0.0\n15.0 2.0 0.0 0.0 6.0\n15.0 2.0 4.0 6.0 6.0\n15.0 0.0 4.0 6.0 0.0\n12.0 2.0 4.0 0.0 6.0\n12.0 0.0 4.0 0.0 0.0\n15.0 0.0 4.0 6.0 0.0\n12.0 2.0 4.0 0.0 6.0\n15.0 2.0 4.0 6.0 6.0\n15.0 0.0 4.0 6.0 0.0\n12.0 2.0 8.0 0.0 6.0\n12.0 0.0 8.0 0.0 0.0\n12.3 0.0 8.0 6.0 0.0\n12.0 2.0 8.0 0.0 6.0\n12.3 2.0 8.0 6.0 6.0\n12.3 0.0 8.0 6.0 0.0\n12.3 2.0 8.0 0.0 6.0\n12.3 1.1 8.0 0.0 0.0\n12.8 1.1 8.0 6.0 0.0\n12.3 2.0 8.0 0.0 6.0\n12.8 2.0 8.0 6.0 6.0\n12.8 1.1 8.0 6.0 0.0\n12.3 0.5 8.0 0.0 6.0\n12.3 0.0 8.0 0.0 0.0\n12.8 0.0 8.0 6.0 0.0\n12.3 0.5 8.0 0.0 6.0\n12.8 0.5 8.0 6.0 6.0\n12.8 0.0 8.0 6.0 0.0\n12.8 2.0 8.0 0.0 6.0\n12.8 0.0 8.0 0.0 0.0\n15.0 0.0 8.0 6.0 0.0\n12.8 2.0 8.0 0.0 6.0\n15.0 2.0 8.0 6.0 6.0\n15.0 0.0 8.0 6.0 0.0\n12.0 2.0 8.0 0.0 6.0\n12.0 0.0 8.0 0.0 0.0\n12.0 0.0 12.0 6.0 0.0\n12.0 2.0 8.0 0.0 6.0\n12.0 2.0 12.0 6.0 6.0\n12.0 0.0 12.0 6.0 0.0\n15.0 2.0 8.0 0.0 6.0\n15.0 0.0 8.0 0.0 0.0\n15.0 0.0 12.0 6.0 0.0\n15.0 2.0 8.0 0.0 6.0\n15.0 2.0 12.0 6.0 6.0\n15.0 0.0 12.0 6.0 0.0\n12.0 2.0 12.0 0.0 6.0\n12.0 0.0 12.0 0.0 0.0\n15.0 0.0 12.0 6.0 0.0\n12.0 2.0 12.0 0.0 6.0\n15.0 2.0 12.0 6.0 6.0\n15.0 0.0 12.0 6.0 0.0\n12.0 2.0 12.0 0.0 6.0\n12.0 0.0 12.0 0.0 0.0\n12.3 0.0 12.0 6.0 0.0\n12.0 2.0 12.0 0.0 6.0\n12.3 2.0 12.0 6.0 6.0\n12.3 0.0 12.0 6.0 0.0\n12.3 2.0 12.0 0.0 6.0\n12.3 1.1 12.0 0.0 0.0\n12.8 1.1 12.0 6.0 0.0\n12.3 2.0 12.0 0.0 6.0\n12.8 2.0 12.0 6.0 6.0\n12.8 1.1 12.0 6.0 0.0\n12.3 0.5 12.0 0.0 6.0\n12.3 0.0 12.0 0.0 0.0\n12.8 0.0 12.0 6.0 0.0\n12.3 0.5 12.0 0.0 6.0\n12.8 0.5 12.0 6.0 6.0\n12.8 0.0 12.0 6.0 0.0\n12.8 2.0 12.0 0.0 6.0\n12.8 0.0 12.0 0.0 0.0\n15.0 0.0 12.0 6.0 0.0\n12.8 2.0 12.0 0.0 6.0\n15.0 2.0 12.0 6.0 6.0\n15.0 0.0 12.0 6.0 0.0\n12.0 2.0 12.0 0.0 6.0\n12.0 0.0 12.0 0.0 0.0\n12.0 0.0 16.0 6.0 0.0\n12.0 2.0 12.0 0.0 6.0\n12.0 2.0 16.0 6.0 6.0\n12.0 0.0 16.0 6.0 0.0\n15.0 2.0 12.0 0.0 6.0\n15.0 0.0 12.0 0.0 0.0\n15.0 0.0 16.0 6.0 0.0\n15.0 2.0 12.0 0.0 6.0\n15.0 2.0 16.0 6.0 6.0\n15.0 0.0 16.0 6.0 0.0\n12.0 2.0 16.0 0.0 6.0\n12.0 0.0 16.0 0.0 0.0\n15.0 0.0 16.0 6.0 0.0\n12.0 2.0 16.0 0.0 6.0\n15.0 2.0 16.0 6.0 6.0\n15.0 0.0 16.0 6.0 0.0\n12.0 2.0 16.0 0.0 6.0\n12.0 0.0 16.0 0.0 0.0\n12.3 0.0 16.0 6.0 0.0\n12.0 2.0 16.0 0.0 6.0\n12.3 2.0 16.0 6.0 6.0\n12.3 0.0 16.0 6.0 0.0\n12.3 2.0 16.0 0.0 6.0\n12.3 1.1 16.0 0.0 0.0\n12.8 1.1 16.0 6.0 0.0\n12.3 2.0 16.0 0.0 6.0\n12.8 2.0 16.0 6.0 6.0\n12.8 1.1 16.0 6.0 0.0\n12.3 0.5 16.0 0.0 6.0\n12.3 0.0 16.0 0.0 0.0\n12.8 0.0 16.0 6.0 0.0\n12.3 0.5 16.0 0.0 6.0\n12.8 0.5 16.0 6.0 6.0\n12.8 0.0 16.0 6.0 0.0\n12.8 2.0 16.0 0.0 6.0\n12.8 0.0 16.0 0.0 0.0\n15.0 0.0 16.0 6.0 0.0\n12.8 2.0 16.0 0.0 6.0\n15.0 2.0 16.0 6.0 6.0\n15.0 0.0 16.0 6.0 0.0\n12.0 2.0 16.0 0.0 6.0\n12.0 0.0 16.0 0.0 0.0\n12.0 0.0 20.0 6.0 0.0\n12.0 2.0 16.0 0.0 6.0\n12.0 2.0 20.0 6.0 6.0\n12.0 0.0 20.0 6.0 0.0\n15.0 2.0 16.0 0.0 6.0\n15.0 0.0 16.0 0.0 0.0\n15.0 0.0 20.0 6.0 0.0\n15.0 2.0 16.0 0.0 6.0\n15.0 2.0 20.0 6.0 6.0\n15.0 0.0 20.0 6.0 0.0\n12.0 2.0 20.0 0.0 6.0\n12.0 0.0 20.0 0.0 0.0\n15.0 0.0 20.0 6.0 0.0\n12.0 2.0 20.0 0.0 6.0\n15.0 2.0 20.0 6.0 6.0\n15.0 0.0 20.0 6.0 0.0\n12.0 2.0 24.0 0.0 6.0\n12.0 0.0 24.0 0.0 0.0\n12.3 0.0 24.0 6.0 0.0\n12.0 2.0 24.0 0.0 6.0\n12.3 2.0 24.0 6.0 6.0\n12.3 0.0 24.0 6.0 0.0\n12.3 2.0 24.0 0.0 6.0\n12.3 1.1 24.0 0.0 0.0\n12.8 1.1 24.0 6.0 0.0\n12.3 2.0 24.0 0.0 6.0\n12.8 2.0 24.0 6.0 6.0\n12.8 1.1 24.0 6.0 0.0\n12.3 0.5 24.0 0.0 6.0\n12.3 0.0 24.0 0.0 0.0\n12.8 0.0 24.0 6.0 0.0\n12.3 0.5 24.0 0.0 6.0\n12.8 0.5 24.0 6.0 6.0\n12.8 0.0 24.0 6.0 0.0\n12.8 2.0 24.0 0.0 6.0\n12.8 0.0 24.0 0.0 0.0\n15.0 0.0 24.0 6.0 0.0\n12.8 2.0 24.0 0.0 6.0\n15.0 2.0 24.0 6.0 6.0\n15.0 0.0 24.0 6.0 0.0\n12.0 2.0 24.0 0.0 6.0\n12.0 0.0 24.0 0.0 0.0\n12.0 0.0 28.0 6.0 0.0\n12.0 2.0 24.0 0.0 6.0");
        builder.append("\n12.0 2.0 28.0 6.0 6.0\n12.0 0.0 28.0 6.0 0.0\n15.0 2.0 24.0 0.0 6.0\n15.0 0.0 24.0 0.0 0.0\n15.0 0.0 28.0 6.0 0.0\n15.0 2.0 24.0 0.0 6.0\n15.0 2.0 28.0 6.0 6.0\n15.0 0.0 28.0 6.0 0.0\n12.0 2.0 28.0 0.0 6.0\n12.0 0.0 28.0 0.0 0.0\n15.0 0.0 28.0 6.0 0.0\n12.0 2.0 28.0 0.0 6.0\n15.0 2.0 28.0 6.0 6.0\n15.0 0.0 28.0 6.0 0.0\n15.0 2.0 0.0 0.0 6.0\n15.0 0.0 0.0 0.0 0.0\n15.3 0.0 0.0 6.0 0.0\n15.0 2.0 0.0 0.0 6.0\n15.3 2.0 0.0 6.0 6.0\n15.3 0.0 0.0 6.0 0.0\n15.3 2.0 0.0 0.0 6.0\n15.3 1.1 0.0 0.0 0.0\n15.8 1.1 0.0 6.0 0.0\n15.3 2.0 0.0 0.0 6.0\n15.8 2.0 0.0 6.0 6.0\n15.8 1.1 0.0 6.0 0.0\n15.3 0.5 0.0 0.0 6.0\n15.3 0.0 0.0 0.0 0.0\n15.8 0.0 0.0 6.0 0.0\n15.3 0.5 0.0 0.0 6.0\n15.8 0.5 0.0 6.0 6.0\n15.8 0.0 0.0 6.0 0.0\n15.8 2.0 0.0 0.0 6.0\n15.8 0.0 0.0 0.0 0.0\n21.0 0.0 0.0 6.0 0.0\n15.8 2.0 0.0 0.0 6.0\n21.0 2.0 0.0 6.0 6.0\n21.0 0.0 0.0 6.0 0.0\n15.0 2.0 0.0 0.0 6.0\n15.0 0.0 0.0 0.0 0.0\n15.0 0.0 4.0 6.0 0.0\n15.0 2.0 0.0 0.0 6.0\n15.0 2.0 4.0 6.0 6.0\n15.0 0.0 4.0 6.0 0.0\n21.0 2.0 0.0 0.0 6.0\n21.0 0.0 0.0 0.0 0.0\n21.0 0.0 4.0 6.0 0.0\n21.0 2.0 0.0 0.0 6.0\n21.0 2.0 4.0 6.0 6.0\n21.0 0.0 4.0 6.0 0.0\n15.0 2.0 4.0 0.0 6.0\n15.0 0.0 4.0 0.0 0.0\n21.0 0.0 4.0 6.0 0.0\n15.0 2.0 4.0 0.0 6.0\n21.0 2.0 4.0 6.0 6.0\n21.0 0.0 4.0 6.0 0.0\n15.0 2.0 24.0 0.0 6.0\n15.0 0.0 24.0 0.0 0.0\n15.3 0.0 24.0 6.0 0.0\n15.0 2.0 24.0 0.0 6.0\n15.3 2.0 24.0 6.0 6.0\n15.3 0.0 24.0 6.0 0.0\n15.3 2.0 24.0 0.0 6.0\n15.3 1.1 24.0 0.0 0.0\n15.8 1.1 24.0 6.0 0.0\n15.3 2.0 24.0 0.0 6.0\n15.8 2.0 24.0 6.0 6.0\n15.8 1.1 24.0 6.0 0.0\n15.3 0.5 24.0 0.0 6.0\n15.3 0.0 24.0 0.0 0.0\n15.8 0.0 24.0 6.0 0.0\n15.3 0.5 24.0 0.0 6.0\n15.8 0.5 24.0 6.0 6.0\n15.8 0.0 24.0 6.0 0.0\n15.8 2.0 24.0 0.0 6.0\n15.8 0.0 24.0 0.0 0.0\n21.0 0.0 24.0 6.0 0.0\n15.8 2.0 24.0 0.0 6.0\n21.0 2.0 24.0 6.0 6.0\n21.0 0.0 24.0 6.0 0.0\n15.0 2.0 24.0 0.0 6.0\n15.0 0.0 24.0 0.0 0.0\n15.0 0.0 28.0 6.0 0.0\n15.0 2.0 24.0 0.0 6.0\n15.0 2.0 28.0 6.0 6.0\n15.0 0.0 28.0 6.0 0.0\n21.0 2.0 24.0 0.0 6.0\n21.0 0.0 24.0 0.0 0.0\n21.0 0.0 28.0 6.0 0.0\n21.0 2.0 24.0 0.0 6.0\n21.0 2.0 28.0 6.0 6.0\n21.0 0.0 28.0 6.0 0.0\n15.0 2.0 28.0 0.0 6.0\n15.0 0.0 28.0 0.0 0.0\n21.0 0.0 28.0 6.0 0.0\n15.0 2.0 28.0 0.0 6.0\n21.0 2.0 28.0 6.0 6.0\n21.0 0.0 28.0 6.0 0.0\n18.0 2.0 4.0 0.0 6.0\n18.0 0.0 4.0 0.0 0.0\n18.3 0.0 4.0 6.0 0.0\n18.0 2.0 4.0 0.0 6.0\n18.3 2.0 4.0 6.0 6.0\n18.3 0.0 4.0 6.0 0.0\n18.3 2.0 4.0 0.0 6.0\n18.3 1.1 4.0 0.0 0.0\n18.8 1.1 4.0 6.0 0.0\n18.3 2.0 4.0 0.0 6.0\n18.8 2.0 4.0 6.0 6.0\n18.8 1.1 4.0 6.0 0.0\n18.3 0.5 4.0 0.0 6.0\n18.3 0.0 4.0 0.0 0.0\n18.8 0.0 4.0 6.0 0.0\n18.3 0.5 4.0 0.0 6.0\n18.8 0.5 4.0 6.0 6.0\n18.8 0.0 4.0 6.0 0.0\n18.8 2.0 4.0 0.0 6.0\n18.8 0.0 4.0 0.0 0.0\n21.0 0.0 4.0 6.0 0.0\n18.8 2.0 4.0 0.0 6.0\n21.0 2.0 4.0 6.0 6.0\n21.0 0.0 4.0 6.0 0.0\n18.0 2.0 4.0 0.0 6.0\n18.0 0.0 4.0 0.0 0.0\n18.0 0.0 8.0 6.0 0.0\n18.0 2.0 4.0 0.0 6.0\n18.0 2.0 8.0 6.0 6.0\n18.0 0.0 8.0 6.0 0.0\n21.0 2.0 4.0 0.0 6.0\n21.0 0.0 4.0 0.0 0.0\n21.0 0.0 8.0 6.0 0.0\n21.0 2.0 4.0 0.0 6.0\n21.0 2.0 8.0 6.0 6.0\n21.0 0.0 8.0 6.0 0.0\n18.0 2.0 8.0 0.0 6.0\n18.0 0.0 8.0 0.0 0.0\n21.0 0.0 8.0 6.0 0.0\n18.0 2.0 8.0 0.0 6.0\n21.0 2.0 8.0 6.0 6.0\n21.0 0.0 8.0 6.0 0.0\n18.0 2.0 8.0 0.0 6.0\n18.0 0.0 8.0 0.0 0.0\n18.3 0.0 8.0 6.0 0.0\n18.0 2.0 8.0 0.0 6.0\n18.3 2.0 8.0 6.0 6.0\n18.3 0.0 8.0 6.0 0.0\n18.3 2.0 8.0 0.0 6.0\n18.3 1.1 8.0 0.0 0.0\n18.8 1.1 8.0 6.0 0.0\n18.3 2.0 8.0 0.0 6.0\n18.8 2.0 8.0 6.0 6.0\n18.8 1.1 8.0 6.0 0.0\n18.3 0.5 8.0 0.0 6.0\n18.3 0.0 8.0 0.0 0.0\n18.8 0.0 8.0 6.0 0.0\n18.3 0.5 8.0 0.0 6.0\n18.8 0.5 8.0 6.0 6.0\n18.8 0.0 8.0 6.0 0.0\n18.8 2.0 8.0 0.0 6.0\n18.8 0.0 8.0 0.0 0.0\n21.0 0.0 8.0 6.0 0.0\n18.8 2.0 8.0 0.0 6.0\n21.0 2.0 8.0 6.0 6.0\n21.0 0.0 8.0 6.0 0.0\n18.0 2.0 8.0 0.0 6.0\n18.0 0.0 8.0 0.0 0.0\n18.0 0.0 12.0 6.0 0.0\n18.0 2.0 8.0 0.0 6.0\n18.0 2.0 12.0 6.0 6.0\n18.0 0.0 12.0 6.0 0.0\n21.0 2.0 8.0 0.0 6.0\n21.0 0.0 8.0 0.0 0.0\n21.0 0.0 12.0 6.0 0.0\n21.0 2.0 8.0 0.0 6.0\n21.0 2.0 12.0 6.0 6.0\n21.0 0.0 12.0 6.0 0.0\n18.0 2.0 12.0 0.0 6.0\n18.0 0.0 12.0 0.0 0.0\n21.0 0.0 12.0 6.0 0.0\n18.0 2.0 12.0 0.0 6.0\n21.0 2.0 12.0 6.0 6.0\n21.0 0.0 12.0 6.0 0.0\n18.0 2.0 12.0 0.0 6.0\n18.0 0.0 12.0 0.0 0.0\n18.3 0.0 12.0 6.0 0.0\n18.0 2.0 12.0 0.0 6.0\n18.3 2.0 12.0 6.0 6.0\n18.3 0.0 12.0 6.0 0.0\n18.3 2.0 12.0 0.0 6.0\n18.3 1.1 12.0 0.0 0.0\n18.8 1.1 12.0 6.0 0.0\n18.3 2.0 12.0 0.0 6.0\n18.8 2.0 12.0 6.0 6.0\n18.8 1.1 12.0 6.0 0.0\n18.3 0.5 12.0 0.0 6.0\n18.3 0.0 12.0 0.0 0.0\n18.8 0.0 12.0 6.0 0.0\n18.3 0.5 12.0 0.0 6.0\n18.8 0.5 12.0 6.0 6.0\n18.8 0.0 12.0 6.0 0.0\n18.8 2.0 12.0 0.0 6.0\n18.8 0.0 12.0 0.0 0.0\n21.0 0.0 12.0 6.0 0.0\n18.8 2.0 12.0 0.0 6.0\n21.0 2.0 12.0 6.0 6.0\n21.0 0.0 12.0 6.0 0.0\n18.0 2.0 12.0 0.0 6.0\n18.0 0.0 12.0 0.0 0.0\n18.0 0.0 16.0 6.0 0.0\n18.0 2.0 12.0 0.0 6.0\n18.0 2.0 16.0 6.0 6.0\n18.0 0.0 16.0 6.0 0.0\n21.0 2.0 12.0 0.0 6.0\n21.0 0.0 12.0 0.0 0.0\n21.0 0.0 16.0 6.0 0.0\n21.0 2.0 12.0 0.0 6.0\n21.0 2.0 16.0 6.0 6.0\n21.0 0.0 16.0 6.0 0.0\n18.0 2.0 16.0 0.0 6.0\n18.0 0.0 16.0 0.0 0.0\n21.0 0.0 16.0 6.0 0.0\n18.0 2.0 16.0 0.0 6.0\n21.0 2.0 16.0 6.0 6.0\n21.0 0.0 16.0 6.0 0.0\n18.0 2.0 16.0 0.0 6.0\n18.0 0.0 16.0 0.0 0.0\n18.3 0.0 16.0 6.0 0.0\n18.0 2.0 16.0 0.0 6.0\n18.3 2.0 16.0 6.0 6.0\n18.3 0.0 16.0 6.0 0.0\n18.3 2.0 16.0 0.0 6.0\n18.3 1.1 16.0 0.0 0.0\n18.8 1.1 16.0 6.0 0.0\n18.3 2.0 16.0 0.0 6.0\n18.8 2.0 16.0 6.0 6.0\n18.8 1.1 16.0 6.0 0.0\n18.3 0.5 16.0 0.0 6.0\n18.3 0.0 16.0 0.0 0.0\n18.8 0.0 16.0 6.0 0.0\n18.3 0.5 16.0 0.0 6.0\n18.8 0.5 16.0 6.0 6.0\n18.8 0.0 16.0 6.0 0.0\n18.8 2.0 16.0 0.0 6.0\n18.8 0.0 16.0 0.0 0.0\n21.0 0.0 16.0 6.0 0.0\n18.8 2.0 16.0 0.0 6.0\n21.0 2.0 16.0 6.0 6.0\n21.0 0.0 16.0 6.0 0.0\n18.0 2.0 16.0 0.0 6.0\n18.0 0.0 16.0 0.0 0.0\n18.0 0.0 20.0 6.0 0.0\n18.0 2.0 16.0 0.0 6.0\n18.0 2.0 20.0 6.0 6.0\n18.0 0.0 20.0 6.0 0.0\n21.0 2.0 16.0 0.0 6.0\n21.0 0.0 16.0 0.0 0.0\n21.0 0.0 20.0 6.0 0.0\n21.0 2.0 16.0 0.0 6.0\n21.0 2.0 20.0 6.0 6.0\n21.0 0.0 20.0 6.0 0.0\n18.0 2.0 20.0 0.0 6.0\n18.0 0.0 20.0 0.0 0.0\n21.0 0.0 20.0 6.0 0.0\n18.0 2.0 20.0 0.0 6.0\n21.0 2.0 20.0 6.0 6.0\n21.0 0.0 20.0 6.0 0.0\n18.0 2.0 20.0 0.0 6.0\n18.0 0.0 20.0 0.0 0.0\n18.3 0.0 20.0 6.0 0.0\n18.0 2.0 20.0 0.0 6.0\n18.3 2.0 20.0 6.0 6.0\n18.3 0.0 20.0 6.0 0.0\n18.3 2.0 20.0 0.0 6.0\n18.3 1.1 20.0 0.0 0.0\n18.8 1.1 20.0 6.0 0.0\n18.3 2.0 20.0 0.0 6.0\n18.8 2.0 20.0 6.0 6.0\n18.8 1.1 20.0 6.0 0.0\n18.3 0.5 20.0 0.0 6.0\n18.3 0.0 20.0 0.0 0.0\n18.8 0.0 20.0 6.0 0.0\n18.3 0.5 20.0 0.0 6.0\n18.8 0.5 20.0 6.0 6.0\n18.8 0.0 20.0 6.0 0.0\n18.8 2.0 20.0 0.0 6.0\n18.8 0.0 20.0 0.0 0.0\n21.0 0.0 20.0 6.0 0.0\n18.8 2.0 20.0 0.0 6.0\n21.0 2.0 20.0 6.0 6.0\n21.0 0.0 20.0 6.0 0.0\n18.0 2.0 20.0 0.0 6.0\n18.0 0.0 20.0 0.0 0.0\n18.0 0.0 24.0 6.0 0.0\n18.0 2.0 20.0 0.0 6.0\n18.0 2.0 24.0 6.0 6.0\n18.0 0.0 24.0 6.0 0.0\n21.0 2.0 20.0 0.0 6.0\n21.0 0.0 20.0 0.0 0.0\n21.0 0.0 24.0 6.0 0.0\n21.0 2.0 20.0 0.0 6.0\n21.0 2.0 24.0 6.0 6.0\n21.0 0.0 24.0 6.0 0.0\n18.0 2.0 24.0 0.0 6.0\n18.0 0.0 24.0 0.0 0.0\n21.0 0.0 24.0 6.0 0.0\n18.0 2.0 24.0 0.0 6.0\n21.0 2.0 24.0 6.0 6.0\n21.0 0.0 24.0 6.0 0.0\n");
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
      externalImage,
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
  private void textureInitializer() {
    texture = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "texture",
      externalImage0,
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
  private void wallTextureInitializer() {
    wallTexture = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "wallTexture",
      externalImage1,
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
  private static com.google.gwt.resources.client.TextResource floor;
  private static com.google.gwt.resources.client.TextResource fragmentShader;
  private static com.google.gwt.resources.client.TextResource pillars;
  private static com.google.gwt.resources.client.TextResource vertexShader;
  private static com.google.gwt.resources.client.TextResource walls;
  private static final java.lang.String externalImage = GWT.getModuleBaseURL() + "7A7076485693A060A14C42DEF8F19578.cache.gif";
  private static final java.lang.String externalImage0 = GWT.getModuleBaseURL() + "1F2BBE4A76519FEA96A682646622E032.cache.png";
  private static final java.lang.String externalImage1 = GWT.getModuleBaseURL() + "5C2122D4F03EBA194B982D6B2D7A28F1.cache.jpg";
  private static com.google.gwt.resources.client.ImageResource mudTexture;
  private static com.google.gwt.resources.client.ImageResource texture;
  private static com.google.gwt.resources.client.ImageResource wallTexture;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      ceiling(), 
      floor(), 
      fragmentShader(), 
      pillars(), 
      vertexShader(), 
      walls(), 
      mudTexture(), 
      texture(), 
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
        resourceMap.put("floor", floor());
        resourceMap.put("fragmentShader", fragmentShader());
        resourceMap.put("pillars", pillars());
        resourceMap.put("vertexShader", vertexShader());
        resourceMap.put("walls", walls());
        resourceMap.put("mudTexture", mudTexture());
        resourceMap.put("texture", texture());
        resourceMap.put("wallTexture", wallTexture());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'ceiling': return this.@com.df3n5.gwtproc.client.demos.main.Resources::ceiling()();
      case 'floor': return this.@com.df3n5.gwtproc.client.demos.main.Resources::floor()();
      case 'fragmentShader': return this.@com.df3n5.gwtproc.client.demos.main.Resources::fragmentShader()();
      case 'pillars': return this.@com.df3n5.gwtproc.client.demos.main.Resources::pillars()();
      case 'vertexShader': return this.@com.df3n5.gwtproc.client.demos.main.Resources::vertexShader()();
      case 'walls': return this.@com.df3n5.gwtproc.client.demos.main.Resources::walls()();
      case 'mudTexture': return this.@com.df3n5.gwtproc.client.demos.main.Resources::mudTexture()();
      case 'texture': return this.@com.df3n5.gwtproc.client.demos.main.Resources::texture()();
      case 'wallTexture': return this.@com.df3n5.gwtproc.client.demos.main.Resources::wallTexture()();
    }
    return null;
  }-*/;
}
