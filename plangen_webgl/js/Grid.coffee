
class Grid
	vertexBuffer = null

	constuctor:(@gl, @width, @height, @blockHalfSize, @shaderProgram, @app) ->

	generateVertices: ->
		vertices = []
		xLen = @width / @blockHalfSize
		for i in [0..xLen]
			yLen = @height / @blockHalfSize
			for j in [0..yLen]
				vertices.append([i*@blockHalfSize, j*@blockHalfSize, 0.0])
		return vertices

	init: ->
		vertexBuffer = @gl.createBuffer()
		@gl.bindBuffer @gl.ARRAY_BUFFER, vertexBuffer
		vertices = generateVertices
		@gl.bufferData @gl.ARRAY_BUFFER, new Float32Array(vertices), @gl.STATIC_DRAW
		vertexBuffer.itemSize = 3
		vertexBuffer.numItems = vertices.length / itemSize

	draw: ->
		alert("hi")
		@gl.bindBuffer @gl.ARRAY_BUFFER, vertexBuffer
		@gl.vertexAttribPointer @shaderProgram.vertexPositionAttribute, vertexBuffer.itemSize, @gl.FLOAT, false, 0, 0
		@app.setMatrixUniforms()
		@gl.drawArrays @gl.LINES, 0, vertexBuffer.numItems
