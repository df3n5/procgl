#ifdef GL_ES
precision highp float;
#endif

//UNIFORMS
//TODO : Pass in as uniform
float uFrequencyCeiling = 1.0;
//vec4 uColorCeiling0 = vec4(0.01,0.01,0.01,1.0);
vec4 uColorCeiling0 = vec4(1.00,1.00,1.0,1.0);
vec4 uColorCeiling1 = vec4(0.0,0.0,0.0,1.0);

varying vec2 vTextureCoord;

void main(void) {
/*
	vec2 texCoord = mod(floor(vTextureCoord * float(uFrequencyCeiling*2.0)), 2.0);
	float delta = abs(texCoord.x - texCoord.y);

	gl_FragColor = mix(uColorCeiling1, uColorCeiling0, delta);
	*/
	gl_FragColor = uColorCeiling1;
}