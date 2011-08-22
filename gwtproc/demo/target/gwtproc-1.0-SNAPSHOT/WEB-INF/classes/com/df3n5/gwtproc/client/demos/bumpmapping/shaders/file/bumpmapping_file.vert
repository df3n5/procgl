/**
 * Procedural bumps
 **/

uniform mat4 uMVMatrix;
uniform mat4 uPMatrix;
uniform vec3 uLightPosition;
 
attribute vec3 aVertexPosition;
attribute vec3 aNormal;
attribute vec2 aTextureCoord;

varying vec2 vTextureCoord;
varying vec3 vLightDir;
varying vec3 vEyeDir;

//varying vec3 v_texCoord3D;
//varying vec3 vreflect;

//attribute vec3 aTangent;

vec3 calcTangent(vec3 normal)
{
	vec3 tangent;
	vec3 c1 = cross(normal, vec3(0.0, 0.0, 1.0));
	vec3 c2 = cross(normal, vec3(0.0, 1.0, 0.0));
	if(length(c1)>length(c2))
	{
		tangent = c1;
	}
	else
	{
		tangent = c2;
	}
	tangent = normalize(tangent);
	return tangent;
}

void main() 
{
    gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);
    vTextureCoord = aTextureCoord;
//    v_texCoord3D = vec3(aTextureCoord,0);

//    EyeDir         = vec3(gl_ModelViewMatrix * gl_Vertex);
	vEyeDir = vec3(uMVMatrix * vec4(aVertexPosition, 1.0));
    
    //vec3 n = normalize(gl_NormalMatrix * gl_Normal);
    vec3 n = normalize(aNormal);
    //vec3 t = normalize(gl_NormalMatrix * aTangent);
    vec3 t = normalize(calcTangent(aNormal));
    vec3 b = cross(n, t); //binormal

    vec3 v;
    v.x = dot(uLightPosition, t);
    v.y = dot(uLightPosition, b);
    v.z = dot(uLightPosition, n);
    vLightDir = normalize(v);

    v.x = dot(vEyeDir, t);
    v.y = dot(vEyeDir, b);
    v.z = dot(vEyeDir, n);
    vEyeDir = normalize(v);
    
/*
    vec3 eyew = aVertexPosition; //HACK
    
	//Reflection^
    vec4 positionw = uMVMatrix * vec4(aVertexPosition, 1.0);
    vec4 normw = normalize(uMVMatrix * vec4(aNormal,0.0));
    vec3 lightw = normalize(positionw.xyz - eyew);
    reflectv = reflect(lightw,normw.xyz); //this does reflection
//              reflectv = clamp(reflectv, 0, 1);^M
    gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);
*/
    
}
