uniform mat4 uMVMatrix;
uniform mat4 uPMatrix;

attribute vec3 aVertexPosition;
attribute vec2 aTextureCoord;

varying vec3 vTexCoord3D;

void main(void) {
	gl_Position = uMVMatrix * vec4(aVertexPosition, 1.0);

	// Quantise effect - give this a go on highly detailed meshes.
//	float quant = 3.0;
//	gl_Position.x=quant*gl_Position.x/quant+gl_Position.x*0.001;
//	gl_Position.y=quant*gl_Position.y/quant+gl_Position.y*0.001;
//	gl_Position.z=quant*gl_Position.z/quant+gl_Position.z*0.001;
    
	vTexCoord3D = vec3(aTextureCoord,0);
}