attribute vec3 vertexPosition;
uniform mat4 projectionMatrix;
void main() {
	gl_Position = projectionMatrix * vec4(vertexPosition, 1.0);
}