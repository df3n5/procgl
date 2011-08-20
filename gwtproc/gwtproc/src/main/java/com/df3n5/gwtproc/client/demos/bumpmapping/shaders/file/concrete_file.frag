/**
 * Procedural bump mapping
 */
#ifdef GL_ES
precision highp float;
#endif

varying vec2 vTextureCoord;
varying vec3 vLightDir;
varying vec3 vEyeDir;

//uniform vec3  SurfaceColor;    // = (0.7, 0.6, 0.18)
//uniform float BumpDensity;     // = 16.0
//uniform float BumpSize;        // = 0.15
//uniform float SpecularFactor;  // = 0.5
vec3  SurfaceColor = vec3(0.7, 0.6, 0.18);
float BumpDensity = 16.0;
float BumpSize = 0.15;
float SpecularFactor = 0.5;

uniform int uProcTextureType;

void main()
{
    vec3 litColor;
    vec2 c = BumpDensity * vTextureCoord.st; //Tex coord is just to figure out how far we are into polygon
    vec2 p = fract(c) - vec2(0.5);

    float d, f;
    d = p.x * p.x + p.y * p.y;
    f = 1.0 / sqrt(d + 1.0);

    if (d >= BumpSize)
    { 
    	p = vec2(0.0); 
    	f = 1.0; 
    }

    vec3 normDelta = vec3(p.x, p.y, 1.0) * f;
    litColor = SurfaceColor * max(dot(normDelta, vLightDir), 0.0);
    vec3 reflectDir = reflect(vLightDir, normDelta);
    
    float spec = max(dot(vEyeDir, reflectDir), 0.0);

    spec *= SpecularFactor;

    litColor = min(litColor + spec, vec3(1.0));

    gl_FragColor = vec4(litColor, 1.0);
}
