
class App
	gl = null
	mvMatrix = mat4.create()
	pMatrix = mat4.create()
	shaderProgram = null

	constuctor: ->

	initGl:(canvas) ->
		try
			gl = canvas.getContext "experimental-webgl"
			gl.viewportWidth = canvas.width
			gl.viewportHeight = canvas.height

			gl.clearColor(0.0, 0.0, 0.0, 1.0)
			gl.enable(gl.DEPTH_TEST)
		catch e
			if !gl
				alert("Could not initialise WebGL, sorry :-(" + e)

	getShader:(gl, id) ->
		shaderScript = document.getElementById(id)
		if (!shaderScript) 
			return null

		str = ""
		k = shaderScript.firstChild
		while (k) 
			if (k.nodeType == 3) 
				str += k.textContent
			k = k.nextSibling;

		shader = null
		if (shaderScript.type == "x-shader/x-fragment") 
			shader = gl.createShader(gl.FRAGMENT_SHADER)
		else if (shaderScript.type == "x-shader/x-vertex") 
			shader = gl.createShader(gl.VERTEX_SHADER)
		else 
			return null

		gl.shaderSource(shader, str)
		gl.compileShader(shader)

		if (!gl.getShaderParameter(shader, gl.COMPILE_STATUS)) 
			alert(gl.getShaderInfoLog(shader))
			return null

		return shader

	initShaders : ->
		fragmentShader = this.getShader gl, "shader-fs"
		vertexShader = this.getShader gl, "shader-vs"

		this.shaderProgram = gl.createProgram()
		gl.attachShader(this.shaderProgram, vertexShader)
		gl.attachShader(this.shaderProgram, fragmentShader)
		gl.linkProgram(this.shaderProgram)

		if (!gl.getProgramParameter(this.shaderProgram, gl.LINK_STATUS)) 
			alert "Could not initialise shaders"

		gl.useProgram(this.shaderProgram);
		this.shaderProgram.vertexPositionAttribute = gl.getAttribLocation(this.shaderProgram, "aVertexPosition")
		gl.enableVertexAttribArray(this.shaderProgram.vertexPositionAttribute)
		this.shaderProgram.pMatrixUniform = gl.getUniformLocation(this.shaderProgram, "uPMatrix")
		this.shaderProgram.mvMatrixUniform = gl.getUniformLocation(this.shaderProgram, "uMVMatrix")

	setMatrixUniforms: ->
		gl.uniformMatrix4fv(this.shaderProgram.pMatrixUniform, false, pMatrix)
		gl.uniformMatrix4fv(this.shaderProgram.mvMatrixUniform, false, mvMatrix)

	triangleVertexPositionBuffer = null
	squareVertexPositionBuffer = null

	initBuffers: ->
		triangleVertexPositionBuffer = gl.createBuffer()
		gl.bindBuffer(gl.ARRAY_BUFFER, triangleVertexPositionBuffer)
		vertices = [
			0.0,  1.0,  0.0,
			-1.0, -1.0,  0.0,
			1.0, -1.0,  0.0]
		gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(vertices), gl.STATIC_DRAW)
		triangleVertexPositionBuffer.itemSize = 3
		triangleVertexPositionBuffer.numItems = 3 

		squareVertexPositionBuffer = gl.createBuffer()
		gl.bindBuffer(gl.ARRAY_BUFFER, squareVertexPositionBuffer)
		vertices = [
			1.0,  1.0,  0.0,
			-1.0,  1.0,  0.0,
			1.0, -1.0,  0.0,
			-1.0, -1.0,  0.0]
		gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(vertices), gl.STATIC_DRAW)
		squareVertexPositionBuffer.itemSize = 3
		squareVertexPositionBuffer.numItems = 4

	drawScene: ->
		gl.viewport(0, 0, gl.viewportWidth, gl.viewportHeight)
		gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT)

		mat4.perspective(45, gl.viewportWidth / gl.viewportHeight, 0.1, 100.0, pMatrix)

		mat4.identity(mvMatrix)

		mat4.translate(mvMatrix, [-1.5, 0.0, -7.0])
		gl.bindBuffer(gl.ARRAY_BUFFER, triangleVertexPositionBuffer)
		gl.vertexAttribPointer this.shaderProgram.vertexPositionAttribute, triangleVertexPositionBuffer.itemSize, gl.FLOAT, false, 0, 0
		this.setMatrixUniforms()
		gl.drawArrays(gl.TRIANGLES, 0, triangleVertexPositionBuffer.numItems)

		mat4.translate(mvMatrix, [3.0, 0.0, 0.0])
		gl.bindBuffer(gl.ARRAY_BUFFER, squareVertexPositionBuffer)
		gl.vertexAttribPointer(this.shaderProgram.vertexPositionAttribute, squareVertexPositionBuffer.itemSize, gl.FLOAT, false, 0, 0)
		this.setMatrixUniforms()
		gl.drawArrays(gl.TRIANGLE_STRIP, 0, squareVertexPositionBuffer.numItems)

	init: ->
		canvas = document.getElementById("webGlCanvas")
		this.initGl(canvas)
		this.initShaders()
		this.initBuffers()

	mainLoop: ->
		this.drawScene()

webGlStart = () ->
  #canvas = document.getElementById "webGlCanvas"
  app = new App()
  app.init()
  app.mainLoop()

webGlStart()
