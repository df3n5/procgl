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
    // file:/home/j0n/code/procgl/gwt_proc/gwtproc-demos/src/main/java/com/df3n5/gwtproc/client/demos/main/fragment-shader.txt
    public String getText() {
      return "/*\n#ifdef GL_ES\nprecision highp float;\n#endif\n\nuniform sampler2D tex;\nvarying vec2 texCoord;\nvoid main() {\n	gl_FragColor = texture2D(tex, texCoord);\n}\n*/\n/*\n\n//Newer\n#ifdef GL_ES\nprecision highp float;\n#endif\n\nvarying vec2 vTextureCoord;\n\nuniform sampler2D uSampler;\n\nvoid main(void) {\n    gl_FragColor = texture2D(uSampler, vec2(vTextureCoord.s, vTextureCoord.t));\n}\n*/\n/*\n//XXX:Working\n//Procedurally generated checkboard texture.\n#ifdef GL_ES\nprecision highp float;\n#endif\n\n//TODO : Pass in as uniform\nfloat uFrequency = 2.0;\nvec4 uColor0 = vec4(0.0,0.0,0.0,1.0);\nvec4 uColor1 = vec4(1.0,1.0,1.0,1.0);\n\nvarying vec2 vTextureCoord;\n\nuniform sampler2D uSampler;\n\nvoid main(void) {\n	vec2 texCoord = mod(floor(vTextureCoord * float(uFrequency*2.0)), 2.0);\n	float delta = abs(texCoord.x - texCoord.y);\n	\n	gl_FragColor = mix(uColor1, uColor0, delta);\n}\n*/\n/*\n//Procedurally generated AA checkboard texture.\n#ifdef GL_ES\nprecision highp float;\n#endif\n\n//TODO : Pass in as uniform\nfloat uFrequency = 2.0;\nvec4 uColor0 = vec4(0.0,0.0,0.0,1.0);\nvec4 uColor1 = vec4(1.0,1.0,1.0,1.0);\n\nvarying vec2 vTextureCoord;\n\nuniform sampler2D uSampler;\n\nvoid main(void) {\n	vec4 color;\n	vec2 st_width;\n	vec2 fuzz;\n	vec2 check_pos;\n	float fuzz_max;\n	\n	//calc the filter width\n	//st_width = fwidth(vTextureCoord);\n	st_width.s = fwidth(vTextureCoord.s);\n	st_width.t = fwidth(vTextureCoord.t);\n	fuzz = st_width * uFrequency * 2.0;\n	fuzz_max = max(fuzz.s, fuzz.t);\n	\n	//get the place in the pattern where we are sampling\n	check_pos = fract(vTextureCoord * uFrequency);\n	\n	if( fuzz_max <= 0.5 )\n	{\n		//if the filter width is small enough, compute the pattern\n		// color by performing a smooth interpolation between the \n		// computed color and the average color\n		\n		vec2 p = smoothstep( vec2(0.5), fuzz + vec2(0.5), check_pos)\n		+ (1.0 - smoothstep(vec2(0.0), fuzz, check_pos));\n		\n		//XXX: Assigning twice? This is MADNESS!\n		color = mix(uColor0, uColor1,\n			p.x * p.y + (1.0 - p.x) * (1.0 - p.y));\n		color = mix(color, (uColor0 + uColor1)/2.0,\n			smoothstep(0.125,0.5, fuzz_max));\n	}\n	else\n	{\n		//filter is too wide. just use the average color.\n		color = (uColor0 + uColor1)/2.0;\n	}\n	\n	gl_FragColor = color;\n}\n*/\n/*\n#extension GL_OES_standard_derivatives : enable\n\nprecision highp float;\n\nfloat uFrequency = 2.0;\nvec4 uColor0 = vec4(0.0,0.0,0.0,1.0);\nvec4 uColor1 = vec4(1.0,1.0,1.0,1.0);\n\nvarying vec2    vTextureCoord;\n\nvoid\nmain()\n{\n   vec4   color;\n   vec2   st_width;\n   vec2   fuzz;\n   vec2   pmod;\n   float  fuzz_max;\n   \n   // determine the filter width\n   st_width = fwidth(vTextureCoord);\n   \n   // calculate the fuzziness taking normal into account\n   fuzz = st_width * float(uFrequency) * 2.0;\n \n   fuzz_max = max(fuzz.s, fuzz.t);\n   \n   // calculate position in the checkerboard pattern\n   pmod = fract(vTextureCoord * float(uFrequency));\n   \n   // if the filter width is small enough, compute the pattern color\n   if (fuzz_max <= 0.5)\n   {\n      vec2   p = smoothstep(vec2(0.5), fuzz + vec2(0.5), pmod) + (1.0 - smoothstep(vec2(0.0), fuzz, pmod));\n      \n      color = mix(uColor0, uColor1, p.x * p.y + (1.0 - p.x) * (1.0 - p.y));\n      \n      // gradually fade in the average color when we get close to the limit\n      color = mix(color, (uColor0 + uColor1)/2.0, smoothstep(0.125, 0.5, fuzz_max));\n   }\n   else\n   {\n      // otherwise, use only the average color\n      color = (uColor0 + uColor1)/2.0;\n   }\n   \n   gl_FragColor = color;\n}\n*/\n/*\n//Per frag lighting\nprecision mediump float;\n\nuniform vec4 uAmbient;\nuniform vec4 uSpecular;\nuniform vec4 uDiffuse;\nuniform float uSpecularPower;\n\nuniform sampler2D sBaseMap;\nuniform sampler2D sBumpMap;\n\nvarying vec2 vTexCoord;\nvarying vec3 vViewDirection;\nvarying vec3 vLightDirection;\n\nvoid main( void )\n{\n   // Fetch basemap color\n   vec4 baseColor = texture2D( sBaseMap, vTexCoord );\n   \n   // Fetch the tangent space normal from normal map\n   vec3 normal = texture2D( sBumpMap, vTexCoord ).xyz;\n   \n   // Scale and bias from [0, 1] to [-1, 1] and normalize\n   normal = normalize( normal * 2.0 - 1.0 );\n   \n   // Normalize the light direction and view direction\n   vec3 lightDirection = normalize( vLightDirection );\n   vec3 viewDirection = normalize( vViewDirection );\n   \n   // Compute N.L\n   float nDotL = dot( normal, lightDirection );\n   \n   // Compute reflection vector\n   vec3 reflection = ( 2.0 * normal * nDotL ) - lightDirection;\n   \n   // Compute R.V\n   float rDotV = max( 0.0, dot( reflection, viewDirection ) );\n   \n   // Compute Ambient term\n   vec4 ambient = uAmbient * baseColor;\n   \n   // Compute Diffuse term\n   vec4 diffuse = uDiffuse * nDotL * baseColor;\n   \n   // Compute Specular term\n   vec4 specular = uSpecular * pow( rDotV, uSpecularPower );\n   \n   // Output final color\n   gl_FragColor = ambient + diffuse + specular;     \n}\n*/\n\n/*\n#ifdef GL_ES\nprecision highp float;\n#endif\nvec4 permute(vec4 x)\n{\n  return mod(((x*34.0)+1.0)*x, 289.0);\n}\nvec4 taylorInvSqrt(vec4 r)\n{\n  return 1.79284291400159 - 0.85373472095314 * r;\n}\nfloat snoise(vec3 v)\n{\n  const vec2 C = vec2(1.0/6.0, 1.0/3.0) ;\n  const vec4 D = vec4(0.0, 0.5, 1.0, 2.0);\n  vec3 i = floor(v + dot(v, C.yyy) );\n  vec3 x0 = v - i + dot(i, C.xxx) ;\n  vec3 g = step(x0.yzx, x0.xyz);\n  vec3 l = 1.0 - g;\n  vec3 i1 = min( g.xyz, l.zxy );\n  vec3 i2 = max( g.xyz, l.zxy );\n  vec3 x1 = x0 - i1 + C.xxx;\n  vec3 x2 = x0 - i2 + C.yyy;\n  vec3 x3 = x0 - D.yyy;\n  i = mod(i, 289.0 );\n  vec4 p = permute( permute( permute(\n             i.z + vec4(0.0, i1.z, i2.z, 1.0 ))\n           + i.y + vec4(0.0, i1.y, i2.y, 1.0 ))\n           + i.x + vec4(0.0, i1.x, i2.x, 1.0 ));\n  float n_ = 0.142857142857;\n  vec3 ns = n_ * D.wyz - D.xzx;\n  vec4 j = p - 49.0 * floor(p * ns.z * ns.z);\n  vec4 x_ = floor(j * ns.z);\n  vec4 y_ = floor(j - 7.0 * x_ );\n  vec4 x = x_ *ns.x + ns.yyyy;\n  vec4 y = y_ *ns.x + ns.yyyy;\n  vec4 h = 1.0 - abs(x) - abs(y);\n  vec4 b0 = vec4( x.xy, y.xy );\n  vec4 b1 = vec4( x.zw, y.zw );\n  vec4 s0 = floor(b0)*2.0 + 1.0;\n  vec4 s1 = floor(b1)*2.0 + 1.0;\n  vec4 sh = -step(h, vec4(0.0));\n  vec4 a0 = b0.xzyw + s0.xzyw*sh.xxyy ;\n  vec4 a1 = b1.xzyw + s1.xzyw*sh.zzww ;\n  vec3 p0 = vec3(a0.xy,h.x);\n  vec3 p1 = vec3(a0.zw,h.y);\n  vec3 p2 = vec3(a1.xy,h.z);\n  vec3 p3 = vec3(a1.zw,h.w);\n  vec4 norm = taylorInvSqrt(vec4(dot(p0,p0), dot(p1,p1), dot(p2, p2), dot(p3,p3)));\n  p0 *= norm.x;\n  p1 *= norm.y;\n  p2 *= norm.z;\n  p3 *= norm.w;\n  vec4 m = max(0.6 - vec4(dot(x0,x0), dot(x1,x1), dot(x2,x2), dot(x3,x3)), 0.0);\n  m = m * m;\n  return 42.0 * dot( m*m, vec4( dot(p0,x0), dot(p1,x1),\n                                dot(p2,x2), dot(p3,x3) ) );\n}\n\n//uniform float time;\nfloat time = 0.1;\nvarying vec3 v_texCoord3D;\nvoid main( void )\n{\n	vec3 uvw = v_texCoord3D + 0.1*vec3(snoise(v_texCoord3D + vec3(0.0, 0.0, time)),\n			snoise(v_texCoord3D + vec3(43.0, 17.0, time)),\n			snoise(v_texCoord3D + vec3(-17.0, -43.0, time)));\n	float n = snoise(uvw - vec3(0.0, 0.0, time));\n	n += 0.5 * snoise(uvw * 2.0 - vec3(0.0, 0.0, time*1.4));\n	n += 0.25 * snoise(uvw * 4.0 - vec3(0.0, 0.0, time*2.0));\n	n += 0.125 * snoise(uvw * 8.0 - vec3(0.0, 0.0, time*2.8));\n	n += 0.0625 * snoise(uvw * 16.0 - vec3(0.0, 0.0, time*4.0));\n	n += 0.03125 * snoise(uvw * 32.0 - vec3(0.0, 0.0, time*5.6));\n	n = n * 0.7;\n	gl_FragColor = vec4(vec3(1.0, 0.5, 0.0) + vec3(n, n, n), 1.0);\n}\n\n*/\n/*\n#ifdef GL_ES\nprecision highp float;\n#endif\n\nvoid main(void) {\n	gl_FragColor = vec4(1.0, 1.0, 1.0, 1.0);\n}\n*/\n\n//XXX:Working\n#ifdef GL_ES\nprecision highp float;\n#endif\n\nvec4 permute(vec4 x)\n{\n  return mod(((x*34.0)+1.0)*x, 289.0);\n}\nvec4 taylorInvSqrt(vec4 r)\n{\n  return 1.79284291400159 - 0.85373472095314 * r;\n}\nfloat snoise(vec3 v)\n{\n  const vec2 C = vec2(1.0/6.0, 1.0/3.0) ;\n  const vec4 D = vec4(0.0, 0.5, 1.0, 2.0);\n  vec3 i = floor(v + dot(v, C.yyy) );\n  vec3 x0 = v - i + dot(i, C.xxx) ;\n  vec3 g = step(x0.yzx, x0.xyz);\n  vec3 l = 1.0 - g;\n  vec3 i1 = min( g.xyz, l.zxy );\n  vec3 i2 = max( g.xyz, l.zxy );\n  vec3 x1 = x0 - i1 + C.xxx;\n  vec3 x2 = x0 - i2 + C.yyy;\n  vec3 x3 = x0 - D.yyy;\n  i = mod(i, 289.0 );\n  vec4 p = permute( permute( permute(\n             i.z + vec4(0.0, i1.z, i2.z, 1.0 ))\n           + i.y + vec4(0.0, i1.y, i2.y, 1.0 ))\n           + i.x + vec4(0.0, i1.x, i2.x, 1.0 ));\n  float n_ = 0.142857142857;\n  vec3 ns = n_ * D.wyz - D.xzx;\n  vec4 j = p - 49.0 * floor(p * ns.z * ns.z);\n  vec4 x_ = floor(j * ns.z);\n  vec4 y_ = floor(j - 7.0 * x_ );\n  vec4 x = x_ *ns.x + ns.yyyy;\n  vec4 y = y_ *ns.x + ns.yyyy;\n  vec4 h = 1.0 - abs(x) - abs(y);\n  vec4 b0 = vec4( x.xy, y.xy );\n  vec4 b1 = vec4( x.zw, y.zw );\n  vec4 s0 = floor(b0)*2.0 + 1.0;\n  vec4 s1 = floor(b1)*2.0 + 1.0;\n  vec4 sh = -step(h, vec4(0.0));\n  vec4 a0 = b0.xzyw + s0.xzyw*sh.xxyy ;\n  vec4 a1 = b1.xzyw + s1.xzyw*sh.zzww ;\n  vec3 p0 = vec3(a0.xy,h.x);\n  vec3 p1 = vec3(a0.zw,h.y);\n  vec3 p2 = vec3(a1.xy,h.z);\n  vec3 p3 = vec3(a1.zw,h.w);\n  vec4 norm = taylorInvSqrt(vec4(dot(p0,p0), dot(p1,p1), dot(p2, p2), dot(p3,p3)));\n  p0 *= norm.x;\n  p1 *= norm.y;\n  p2 *= norm.z;\n  p3 *= norm.w;\n  vec4 m = max(0.6 - vec4(dot(x0,x0), dot(x1,x1), dot(x2,x2), dot(x3,x3)), 0.0);\n  m = m * m;\n  return 42.0 * dot( m*m, vec4( dot(p0,x0), dot(p1,x1),\n                                dot(p2,x2), dot(p3,x3) ) );\n}\n\n//TODO : Pass in as uniform\n//UNIFORMS\nfloat uFrequency = 2.0;\nvec4 uColor0 = vec4(0.0,0.0,0.0,1.0);\nvec4 uColor1 = vec4(1.0,1.0,1.0,1.0);\n\nvarying vec2 vTextureCoord;\n\nuniform sampler2D uSampler;\n\nvarying vec3 v_texCoord3D;\nfloat time = 0.1;\n\n//MAIN\nvoid main(void) {\n	vec2 texCoord = mod(floor(vTextureCoord * float(uFrequency*2.0)), 2.0);\n	float delta = abs(texCoord.x - texCoord.y);\n\n	vec3 uvw = v_texCoord3D + 0.1*vec3(snoise(v_texCoord3D + vec3(0.0, 0.0, time)),\n			snoise(v_texCoord3D + vec3(43.0, 17.0, time)),\n			snoise(v_texCoord3D + vec3(-17.0, -43.0, time)));\n\n	float n = snoise(uvw - vec3(0.0, 0.0, time));\n	n += 0.5 * snoise(uvw * 2.0 - vec3(0.0, 0.0, time*1.4));\n	n += 0.25 * snoise(uvw * 4.0 - vec3(0.0, 0.0, time*2.0));\n	n += 0.125 * snoise(uvw * 8.0 - vec3(0.0, 0.0, time*2.8));\n	n += 0.0625 * snoise(uvw * 16.0 - vec3(0.0, 0.0, time*4.0));\n	n += 0.03125 * snoise(uvw * 32.0 - vec3(0.0, 0.0, time*5.6));\n	n = n * 0.7;\n\n	gl_FragColor = vec4(vec3(1.0, 0.5, 0.0) + vec3(n, n, n), 1.0);\n\n	\n	//gl_FragColor = mix(uColor1, uColor0, delta);\n}\n";
    }
    public String getName() {
      return "fragmentShader";
    }
  }
  ;
    map = new com.google.gwt.resources.client.TextResource() {
    // file:/home/j0n/code/procgl/gwt_proc/gwtproc-demos/src/main/java/com/df3n5/gwtproc/client/demos/main/map.txt
    public String getText() {
      return "0.0  1.0  0.0 0.0 6.0\n0.0  0.0  0.0  0.0 0.0\n7.0  0.0  0.0 6.0 0.0\n0.0  1.0  0.0 0.0 6.0\n7.0  1.0  0.0  6.0 6.0\n7.0  0.0  0.0 6.0 0.0\n0.0  1.0  0.0 0.0 6.0\n0.0  0.0  0.0  0.0 0.0\n0.0  0.0  7.0 6.0 0.0\n0.0  1.0  0.0 0.0 6.0\n0.0  1.0  7.0  6.0 6.0\n0.0  0.0  7.0 6.0 0.0\n7.0  1.0  0.0 0.0 6.0\n7.0  0.0  0.0  0.0 0.0\n7.0  0.0  7.0 6.0 0.0\n7.0  1.0  0.0 0.0 6.0\n7.0  1.0  7.0  6.0 6.0\n7.0  0.0  7.0 6.0 0.0\n0.0  1.0  7.0 0.0 6.0\n0.0  0.0  7.0  0.0 0.0\n7.0  0.0  7.0 6.0 0.0\n0.0  1.0  7.0 0.0 6.0\n7.0  1.0  7.0  6.0 6.0\n7.0  0.0  7.0 6.0 0.0\n0.0  1.0  14.0 0.0 6.0\n0.0  0.0  14.0  0.0 0.0\n7.0  0.0  14.0 6.0 0.0\n0.0  1.0  14.0 0.0 6.0\n7.0  1.0  14.0  6.0 6.0\n7.0  0.0  14.0 6.0 0.0\n0.0  1.0  14.0 0.0 6.0\n0.0  0.0  14.0  0.0 0.0\n0.0  0.0  21.0 6.0 0.0\n0.0  1.0  14.0 0.0 6.0\n0.0  1.0  21.0  6.0 6.0\n0.0  0.0  21.0 6.0 0.0\n7.0  1.0  14.0 0.0 6.0\n7.0  0.0  14.0  0.0 0.0\n7.0  0.0  21.0 6.0 0.0\n7.0  1.0  14.0 0.0 6.0\n7.0  1.0  21.0  6.0 6.0\n7.0  0.0  21.0 6.0 0.0\n0.0  1.0  21.0 0.0 6.0\n0.0  0.0  21.0  0.0 0.0\n7.0  0.0  21.0 6.0 0.0\n0.0  1.0  21.0 0.0 6.0\n7.0  1.0  21.0  6.0 6.0\n7.0  0.0  21.0 6.0 0.0\n0.0  1.0  28.0 0.0 6.0\n0.0  0.0  28.0  0.0 0.0\n7.0  0.0  28.0 6.0 0.0\n0.0  1.0  28.0 0.0 6.0\n7.0  1.0  28.0  6.0 6.0\n7.0  0.0  28.0 6.0 0.0\n0.0  1.0  28.0 0.0 6.0\n0.0  0.0  28.0  0.0 0.0\n0.0  0.0  35.0 6.0 0.0\n0.0  1.0  28.0 0.0 6.0\n0.0  1.0  35.0  6.0 6.0\n0.0  0.0  35.0 6.0 0.0\n7.0  1.0  28.0 0.0 6.0\n7.0  0.0  28.0  0.0 0.0\n7.0  0.0  35.0 6.0 0.0\n7.0  1.0  28.0 0.0 6.0\n7.0  1.0  35.0  6.0 6.0\n7.0  0.0  35.0 6.0 0.0\n0.0  1.0  35.0 0.0 6.0\n0.0  0.0  35.0  0.0 0.0\n7.0  0.0  35.0 6.0 0.0\n0.0  1.0  35.0 0.0 6.0\n7.0  1.0  35.0  6.0 6.0\n7.0  0.0  35.0 6.0 0.0\n0.0  1.0  42.0 0.0 6.0\n0.0  0.0  42.0  0.0 0.0\n7.0  0.0  42.0 6.0 0.0\n0.0  1.0  42.0 0.0 6.0\n7.0  1.0  42.0  6.0 6.0\n7.0  0.0  42.0 6.0 0.0\n0.0  1.0  42.0 0.0 6.0\n0.0  0.0  42.0  0.0 0.0\n0.0  0.0  49.0 6.0 0.0\n0.0  1.0  42.0 0.0 6.0\n0.0  1.0  49.0  6.0 6.0\n0.0  0.0  49.0 6.0 0.0\n7.0  1.0  42.0 0.0 6.0\n7.0  0.0  42.0  0.0 0.0\n7.0  0.0  49.0 6.0 0.0\n7.0  1.0  42.0 0.0 6.0\n7.0  1.0  49.0  6.0 6.0\n7.0  0.0  49.0 6.0 0.0\n0.0  1.0  49.0 0.0 6.0\n0.0  0.0  49.0  0.0 0.0\n7.0  0.0  49.0 6.0 0.0\n0.0  1.0  49.0 0.0 6.0\n7.0  1.0  49.0  6.0 6.0\n7.0  0.0  49.0 6.0 0.0\n14.0  1.0  0.0 0.0 6.0\n14.0  0.0  0.0  0.0 0.0\n21.0  0.0  0.0 6.0 0.0\n14.0  1.0  0.0 0.0 6.0\n21.0  1.0  0.0  6.0 6.0\n21.0  0.0  0.0 6.0 0.0\n14.0  1.0  0.0 0.0 6.0\n14.0  0.0  0.0  0.0 0.0\n14.0  0.0  7.0 6.0 0.0\n14.0  1.0  0.0 0.0 6.0\n14.0  1.0  7.0  6.0 6.0\n14.0  0.0  7.0 6.0 0.0\n21.0  1.0  0.0 0.0 6.0\n21.0  0.0  0.0  0.0 0.0\n21.0  0.0  7.0 6.0 0.0\n21.0  1.0  0.0 0.0 6.0\n21.0  1.0  7.0  6.0 6.0\n21.0  0.0  7.0 6.0 0.0\n14.0  1.0  7.0 0.0 6.0\n14.0  0.0  7.0  0.0 0.0\n21.0  0.0  7.0 6.0 0.0\n14.0  1.0  7.0 0.0 6.0\n21.0  1.0  7.0  6.0 6.0\n21.0  0.0  7.0 6.0 0.0\n14.0  1.0  14.0 0.0 6.0\n14.0  0.0  14.0  0.0 0.0\n21.0  0.0  14.0 6.0 0.0\n14.0  1.0  14.0 0.0 6.0\n21.0  1.0  14.0  6.0 6.0\n21.0  0.0  14.0 6.0 0.0\n14.0  1.0  14.0 0.0 6.0\n14.0  0.0  14.0  0.0 0.0\n14.0  0.0  21.0 6.0 0.0\n14.0  1.0  14.0 0.0 6.0\n14.0  1.0  21.0  6.0 6.0\n14.0  0.0  21.0 6.0 0.0\n21.0  1.0  14.0 0.0 6.0\n21.0  0.0  14.0  0.0 0.0\n21.0  0.0  21.0 6.0 0.0\n21.0  1.0  14.0 0.0 6.0\n21.0  1.0  21.0  6.0 6.0\n21.0  0.0  21.0 6.0 0.0\n14.0  1.0  21.0 0.0 6.0\n14.0  0.0  21.0  0.0 0.0\n21.0  0.0  21.0 6.0 0.0\n14.0  1.0  21.0 0.0 6.0\n21.0  1.0  21.0  6.0 6.0\n21.0  0.0  21.0 6.0 0.0\n14.0  1.0  28.0 0.0 6.0\n14.0  0.0  28.0  0.0 0.0\n21.0  0.0  28.0 6.0 0.0\n14.0  1.0  28.0 0.0 6.0\n21.0  1.0  28.0  6.0 6.0\n21.0  0.0  28.0 6.0 0.0\n14.0  1.0  28.0 0.0 6.0\n14.0  0.0  28.0  0.0 0.0\n14.0  0.0  35.0 6.0 0.0\n14.0  1.0  28.0 0.0 6.0\n14.0  1.0  35.0  6.0 6.0\n14.0  0.0  35.0 6.0 0.0\n21.0  1.0  28.0 0.0 6.0\n21.0  0.0  28.0  0.0 0.0\n21.0  0.0  35.0 6.0 0.0\n21.0  1.0  28.0 0.0 6.0\n21.0  1.0  35.0  6.0 6.0\n21.0  0.0  35.0 6.0 0.0\n14.0  1.0  35.0 0.0 6.0\n14.0  0.0  35.0  0.0 0.0\n21.0  0.0  35.0 6.0 0.0\n14.0  1.0  35.0 0.0 6.0\n21.0  1.0  35.0  6.0 6.0\n21.0  0.0  35.0 6.0 0.0\n14.0  1.0  42.0 0.0 6.0\n14.0  0.0  42.0  0.0 0.0\n21.0  0.0  42.0 6.0 0.0\n14.0  1.0  42.0 0.0 6.0\n21.0  1.0  42.0  6.0 6.0\n21.0  0.0  42.0 6.0 0.0\n14.0  1.0  42.0 0.0 6.0\n14.0  0.0  42.0  0.0 0.0\n14.0  0.0  49.0 6.0 0.0\n14.0  1.0  42.0 0.0 6.0\n14.0  1.0  49.0  6.0 6.0\n14.0  0.0  49.0 6.0 0.0\n21.0  1.0  42.0 0.0 6.0\n21.0  0.0  42.0  0.0 0.0\n21.0  0.0  49.0 6.0 0.0\n21.0  1.0  42.0 0.0 6.0\n21.0  1.0  49.0  6.0 6.0\n21.0  0.0  49.0 6.0 0.0\n14.0  1.0  49.0 0.0 6.0\n14.0  0.0  49.0  0.0 0.0\n21.0  0.0  49.0 6.0 0.0\n14.0  1.0  49.0 0.0 6.0\n21.0  1.0  49.0  6.0 6.0\n21.0  0.0  49.0 6.0 0.0\n28.0  1.0  0.0 0.0 6.0\n28.0  0.0  0.0  0.0 0.0\n35.0  0.0  0.0 6.0 0.0\n28.0  1.0  0.0 0.0 6.0\n35.0  1.0  0.0  6.0 6.0\n35.0  0.0  0.0 6.0 0.0\n28.0  1.0  0.0 0.0 6.0\n28.0  0.0  0.0  0.0 0.0\n28.0  0.0  7.0 6.0 0.0\n28.0  1.0  0.0 0.0 6.0\n28.0  1.0  7.0  6.0 6.0\n28.0  0.0  7.0 6.0 0.0\n35.0  1.0  0.0 0.0 6.0\n35.0  0.0  0.0  0.0 0.0\n35.0  0.0  7.0 6.0 0.0\n35.0  1.0  0.0 0.0 6.0\n35.0  1.0  7.0  6.0 6.0\n35.0  0.0  7.0 6.0 0.0\n28.0  1.0  7.0 0.0 6.0\n28.0  0.0  7.0  0.0 0.0\n35.0  0.0  7.0 6.0 0.0\n28.0  1.0  7.0 0.0 6.0\n35.0  1.0  7.0  6.0 6.0\n35.0  0.0  7.0 6.0 0.0\n28.0  1.0  14.0 0.0 6.0\n28.0  0.0  14.0  0.0 0.0\n35.0  0.0  14.0 6.0 0.0\n28.0  1.0  14.0 0.0 6.0\n35.0  1.0  14.0  6.0 6.0\n35.0  0.0  14.0 6.0 0.0\n28.0  1.0  14.0 0.0 6.0\n28.0  0.0  14.0  0.0 0.0\n28.0  0.0  21.0 6.0 0.0\n28.0  1.0  14.0 0.0 6.0\n28.0  1.0  21.0  6.0 6.0\n28.0  0.0  21.0 6.0 0.0\n35.0  1.0  14.0 0.0 6.0\n35.0  0.0  14.0  0.0 0.0\n35.0  0.0  21.0 6.0 0.0\n35.0  1.0  14.0 0.0 6.0\n35.0  1.0  21.0  6.0 6.0\n35.0  0.0  21.0 6.0 0.0\n28.0  1.0  21.0 0.0 6.0\n28.0  0.0  21.0  0.0 0.0\n35.0  0.0  21.0 6.0 0.0\n28.0  1.0  21.0 0.0 6.0\n35.0  1.0  21.0  6.0 6.0\n35.0  0.0  21.0 6.0 0.0\n28.0  1.0  28.0 0.0 6.0\n28.0  0.0  28.0  0.0 0.0\n35.0  0.0  28.0 6.0 0.0\n28.0  1.0  28.0 0.0 6.0\n35.0  1.0  28.0  6.0 6.0\n35.0  0.0  28.0 6.0 0.0\n28.0  1.0  28.0 0.0 6.0\n28.0  0.0  28.0  0.0 0.0\n28.0  0.0  35.0 6.0 0.0\n28.0  1.0  28.0 0.0 6.0\n28.0  1.0  35.0  6.0 6.0\n28.0  0.0  35.0 6.0 0.0\n35.0  1.0  28.0 0.0 6.0\n35.0  0.0  28.0  0.0 0.0\n35.0  0.0  35.0 6.0 0.0\n35.0  1.0  28.0 0.0 6.0\n35.0  1.0  35.0  6.0 6.0\n35.0  0.0  35.0 6.0 0.0\n28.0  1.0  35.0 0.0 6.0\n28.0  0.0  35.0  0.0 0.0\n35.0  0.0  35.0 6.0 0.0\n28.0  1.0  35.0 0.0 6.0\n35.0  1.0  35.0  6.0 6.0\n35.0  0.0  35.0 6.0 0.0\n28.0  1.0  42.0 0.0 6.0\n28.0  0.0  42.0  0.0 0.0\n35.0  0.0  42.0 6.0 0.0\n28.0  1.0  42.0 0.0 6.0\n35.0  1.0  42.0  6.0 6.0\n35.0  0.0  42.0 6.0 0.0\n28.0  1.0  42.0 0.0 6.0\n28.0  0.0  42.0  0.0 0.0\n28.0  0.0  49.0 6.0 0.0\n28.0  1.0  42.0 0.0 6.0\n28.0  1.0  49.0  6.0 6.0\n28.0  0.0  49.0 6.0 0.0\n35.0  1.0  42.0 0.0 6.0\n35.0  0.0  42.0  0.0 0.0\n35.0  0.0  49.0 6.0 0.0\n35.0  1.0  42.0 0.0 6.0\n35.0  1.0  49.0  6.0 6.0\n35.0  0.0  49.0 6.0 0.0\n28.0  1.0  49.0 0.0 6.0\n28.0  0.0  49.0  0.0 0.0\n35.0  0.0  49.0 6.0 0.0\n28.0  1.0  49.0 0.0 6.0\n35.0  1.0  49.0  6.0 6.0\n35.0  0.0  49.0 6.0 0.0\n42.0  1.0  0.0 0.0 6.0\n42.0  0.0  0.0  0.0 0.0\n49.0  0.0  0.0 6.0 0.0\n42.0  1.0  0.0 0.0 6.0\n49.0  1.0  0.0  6.0 6.0\n49.0  0.0  0.0 6.0 0.0\n42.0  1.0  0.0 0.0 6.0\n42.0  0.0  0.0  0.0 0.0\n42.0  0.0  7.0 6.0 0.0\n42.0  1.0  0.0 0.0 6.0\n42.0  1.0  7.0  6.0 6.0\n42.0  0.0  7.0 6.0 0.0\n49.0  1.0  0.0 0.0 6.0\n49.0  0.0  0.0  0.0 0.0\n49.0  0.0  7.0 6.0 0.0\n49.0  1.0  0.0 0.0 6.0\n49.0  1.0  7.0  6.0 6.0\n49.0  0.0  7.0 6.0 0.0\n42.0  1.0  7.0 0.0 6.0\n42.0  0.0  7.0  0.0 0.0\n49.0  0.0  7.0 6.0 0.0\n42.0  1.0  7.0 0.0 6.0\n49.0  1.0  7.0  6.0 6.0\n49.0  0.0  7.0 6.0 0.0\n42.0  1.0  14.0 0.0 6.0\n42.0  0.0  14.0  0.0 0.0\n49.0  0.0  14.0 6.0 0.0\n42.0  1.0  14.0 0.0 6.0\n49.0  1.0  14.0  6.0 6.0\n49.0  0.0  14.0 6.0 0.0\n42.0  1.0  14.0 0.0 6.0\n42.0  0.0  14.0  0.0 0.0\n42.0  0.0  21.0 6.0 0.0\n42.0  1.0  14.0 0.0 6.0\n42.0  1.0  21.0  6.0 6.0\n42.0  0.0  21.0 6.0 0.0\n49.0  1.0  14.0 0.0 6.0\n49.0  0.0  14.0  0.0 0.0\n49.0  0.0  21.0 6.0 0.0\n49.0  1.0  14.0 0.0 6.0\n49.0  1.0  21.0  6.0 6.0\n49.0  0.0  21.0 6.0 0.0\n42.0  1.0  21.0 0.0 6.0\n42.0  0.0  21.0  0.0 0.0\n49.0  0.0  21.0 6.0 0.0\n42.0  1.0  21.0 0.0 6.0\n49.0  1.0  21.0  6.0 6.0\n49.0  0.0  21.0 6.0 0.0\n42.0  1.0  28.0 0.0 6.0\n42.0  0.0  28.0  0.0 0.0\n49.0  0.0  28.0 6.0 0.0\n42.0  1.0  28.0 0.0 6.0\n49.0  1.0  28.0  6.0 6.0\n49.0  0.0  28.0 6.0 0.0\n42.0  1.0  28.0 0.0 6.0\n42.0  0.0  28.0  0.0 0.0\n42.0  0.0  35.0 6.0 0.0\n42.0  1.0  28.0 0.0 6.0\n42.0  1.0  35.0  6.0 6.0\n42.0  0.0  35.0 6.0 0.0\n49.0  1.0  28.0 0.0 6.0\n49.0  0.0  28.0  0.0 0.0\n49.0  0.0  35.0 6.0 0.0\n49.0  1.0  28.0 0.0 6.0\n49.0  1.0  35.0  6.0 6.0\n49.0  0.0  35.0 6.0 0.0\n42.0  1.0  35.0 0.0 6.0\n42.0  0.0  35.0  0.0 0.0\n49.0  0.0  35.0 6.0 0.0\n42.0  1.0  35.0 0.0 6.0\n49.0  1.0  35.0  6.0 6.0\n49.0  0.0  35.0 6.0 0.0\n42.0  1.0  42.0 0.0 6.0\n42.0  0.0  42.0  0.0 0.0\n49.0  0.0  42.0 6.0 0.0\n42.0  1.0  42.0 0.0 6.0\n49.0  1.0  42.0  6.0 6.0\n49.0  0.0  42.0 6.0 0.0\n42.0  1.0  42.0 0.0 6.0\n42.0  0.0  42.0  0.0 0.0\n42.0  0.0  49.0 6.0 0.0\n42.0  1.0  42.0 0.0 6.0\n42.0  1.0  49.0  6.0 6.0\n42.0  0.0  49.0 6.0 0.0\n49.0  1.0  42.0 0.0 6.0\n49.0  0.0  42.0  0.0 0.0\n49.0  0.0  49.0 6.0 0.0\n49.0  1.0  42.0 0.0 6.0\n49.0  1.0  49.0  6.0 6.0\n49.0  0.0  49.0 6.0 0.0\n42.0  1.0  49.0 0.0 6.0\n42.0  0.0  49.0  0.0 0.0\n49.0  0.0  49.0 6.0 0.0\n42.0  1.0  49.0 0.0 6.0\n49.0  1.0  49.0  6.0 6.0\n49.0  0.0  49.0 6.0 0.0";
    }
    public String getName() {
      return "map";
    }
  }
  ;
    vertexShader = new com.google.gwt.resources.client.TextResource() {
    // file:/home/j0n/code/procgl/gwt_proc/gwtproc-demos/src/main/java/com/df3n5/gwtproc/client/demos/main/vertex-shader.txt
    public String getText() {
      return "/*\nattribute vec3 vertexPosition;\nattribute vec2 texPosition;\nuniform mat4 projectionMatrix;\nvarying vec2 texCoord;\n\n\nvoid main() {\n	gl_Position = projectionMatrix * vec4(vertexPosition, 1.0);\n	texCoord = texPosition;\n}\n*/\n/*\n//XXX:Working\n//Newer\nattribute vec3 aVertexPosition;\nattribute vec2 aTextureCoord;\n\nuniform mat4 uMVMatrix;\nuniform mat4 uPMatrix;\n\nvarying vec2 vTextureCoord;\n\nvoid main(void) {\n//    gl_Position = uPMatrix * uMVMatrix * vec4(aVertexPosition, 1.0);\n	gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);\n    vTextureCoord = aTextureCoord;\n}\n*/\n/*\nuniform mat4 uMVMatrix;\nuniform mat4 uPMatrix;\n\nattribute vec3 aVertexPosition;\nattribute vec2 aTextureCoord;\nvarying vec2 vTextureCoord;\n\nvoid main() \n{\n	vTextureCoord = aTextureCoord;\n	gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);\n}\n*/\n/*\n//Per frag lighting\nuniform mat4 uMatViewInverse;\nuniform mat4 uMatViewProjection;\nuniform vec3 uLightPosition;\nuniform vec3 uEyePosition;\n\nvarying vec2 vTexcoord;\nvarying vec3 vViewDirection;\nvarying vec3 vLightDirection;\n\nattribute vec4 aVertex;\nattribute vec2 aTexcoord0;\nattribute vec3 aNormal;\nattribute vec3 aBinormal;\nattribute vec3 aTangent;\n   \nvoid main( void )\n{\n   // Transform eye vector into world space\n   vec3 eyePositionWorld = (uMatViewInverse * vec4(uEyePosition, 1.0)).xyz;\n   \n   // Compute world-space direction vector\n   vec3 viewDirectionWorld = eyePositionWorld - aVertex.xyz;\n      \n   // Transform light position into world space\n   vec3 lightPositionWorld = (uMatViewInverse * vec4(uLightPosition, 1.0)).xyz;   \n   \n   // Compute world-space light dirction vector\n   vec3 lightDirectionWorld = lightPositionWorld - aVertex.xyz;\n   \n   // Create the tangent matrix\n   mat3 tangentMat = mat3( aTangent, \n                           aBinormal,\n                           aNormal );   \n   \n   // Transform the view and light vectors into tangent space\n   vViewDirection = viewDirectionWorld * tangentMat;\n   vLightDirection = lightDirectionWorld * tangentMat;\n      \n   // Transform output position\n   gl_Position = uMatViewProjection * aVertex;\n   \n   // Pass through texture coordinate\n   vTexcoord = aTexcoord0.xy;\n\n}\n*/\n\n/*\n//TODO:RIPPED CODE\nuniform float time;\nvarying vec2 v_texCoord2D;\nvarying vec3 v_texCoord3D;\nvarying vec4 v_color;\n\nvoid main( void )\n{\n	gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;\n\n	v_texCoord2D = gl_MultiTexCoord0.xy;\n    \n    v_texCoord3D = gl_Vertex.xyz;\n	\n	v_color = gl_Color;\n\n}\n*/\n/*\n//uniform float time;\nfloat time = 0.1;\nvarying vec3 v_texCoord3D;\n\nvoid main( void )\n{\n	gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;\n    v_texCoord3D = gl_Vertex.xyz;\n}\n*/\n/*\nuniform mat4 uMVMatrix;\nuniform mat4 uPMatrix;\n//uniform float time;\n//float time = 0.1;\n\nattribute vec3 aVertexPosition;\nattribute vec2 aTextureCoord;\n//varying vec2 vTextureCoord;\nvarying vec3 v_texCoord3D;\n\nvoid main() \n{\n	//vTextureCoord = aTextureCoord;\n	gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);\n	v_texCoord3D = vec3(aTextureCoord,0);\n}\n*/\n/*\n\nattribute vec3 aVertexPosition;\n\nuniform mat4 uMVMatrix;\nuniform mat4 uPMatrix;\n\nvoid main(void) {\n	gl_Position = uPMatrix * uMVMatrix * vec4(aVertexPosition, 1.0);\n}\n*/\n\n//XXX:Working\n//Newer\nattribute vec3 aVertexPosition;\nattribute vec2 aTextureCoord;\n\nuniform mat4 uMVMatrix;\nuniform mat4 uPMatrix;\n\nvarying vec2 vTextureCoord;\n\nvarying vec3 v_texCoord3D;\n\nvoid main(void) {\n//    gl_Position = uPMatrix * uMVMatrix * vec4(aVertexPosition, 1.0);\n	gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);\n    vTextureCoord = aTextureCoord;\n\n	v_texCoord3D = vec3(aTextureCoord,0);\n}\n";
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
