package com.df3n5.gwtproc.client.demos.bumpmapping;

import java.util.Date;

import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;

/**
 * FPS Camera.
 * @author Jonathan Frawley
 */
public class Camera implements MouseMoveHandler, 
								MouseDownHandler, 
								MouseUpHandler, 
								KeyDownHandler, 
								KeyUpHandler {
	int oldMouseX = 0;
	int oldMouseY = 0;
	boolean mouseDown = false;
	private boolean[] currentlyPressedKeys;
	private float pitchRate;
	private float pitch;
	private float yawRate;
	private float yaw;
	private float forwardSpeed;
	private float strafeSpeed;
    private long lastTime = 0;
    private float xPos;
    private float yPos;
    private float zPos;

	public Camera() {
		currentlyPressedKeys = new boolean[255]; //TODO: Is this high enough?
		xPos = 0.0f;
		yPos = 0.4f;
		zPos = 0.0f;
	}
	
	public float getX() {
		return (float)xPos;
	}
	
	public float getY() {
		return (float)yPos;
	}
	
	public float getZ() {
		return (float)zPos;
	}

	private void handleKeys() {

		if (currentlyPressedKeys[37] || currentlyPressedKeys[65]) {
            // Left cursor key or A
            strafeSpeed = 0.003f;
        } else if (currentlyPressedKeys[39] || currentlyPressedKeys[68]) {
            // Right cursor key or D
            strafeSpeed = -0.003f;
        } else {
            strafeSpeed = 0.0f;
        }

        if (currentlyPressedKeys[38] || currentlyPressedKeys[87]) {
            // Up cursor key or W
            forwardSpeed = 0.003f;
        } else if (currentlyPressedKeys[40] || currentlyPressedKeys[83]) {
            // Down cursor key
            forwardSpeed = -0.003f;
        } else {
            forwardSpeed = 0;
        }
	}
	
	/**
	 * Get camera rotation on x axis
	 * @return rotation on x axis
	 */
	public int getRotationXAxis() {
		return (int)pitch;
	}

	/**
	 * Get camera rotation on y axis
	 * @return rotation on y axis
	 */
	public int getRotationYAxis() {
		return (int)yaw;
	}

	public void onMouseMove(MouseMoveEvent event) {
		int mouseMoveX = event.getX()-oldMouseX;
		int mouseMoveY = event.getY()-oldMouseY;
		oldMouseX = event.getX();
		oldMouseY = event.getY();
		if(mouseDown){
			float slowdownRate = 20.0f;
			pitchRate += mouseMoveY / slowdownRate;
			yawRate += mouseMoveX / slowdownRate;
		}
	}
	
	// Handle keyboard input
	public void onKeyDown(KeyDownEvent event) {
		currentlyPressedKeys[event.getNativeKeyCode()] = true;
	}
	
	public void onKeyUp(KeyUpEvent event) {
		currentlyPressedKeys[event.getNativeKeyCode()] = false;
	}

	public void onMouseDown(MouseDownEvent event) {
		mouseDown = true;
	}

	public void onMouseUp(MouseUpEvent event) {
		mouseDown = false;
		
		yawRate = 0.0f;
		pitchRate = 0.0f;
	}

	//TODO:Put in Util class.
    float degToRad(float degrees) {
        return degrees * (float)Math.PI / 180.0f;
    }

    private void animate() {
        long timeNow = new Date().getTime();
        if (lastTime != 0) {
            long elapsed = timeNow - lastTime;

			//Do looking.
            yaw -= yawRate * elapsed;
            pitch -= pitchRate * elapsed;
            yawRate = 0.0f;
            pitchRate = 0.0f;

			//Forward movement
            xPos -= Math.sin(degToRad(yaw)) * forwardSpeed * elapsed;
            zPos -= Math.cos(degToRad(yaw)) * forwardSpeed * elapsed;
			
			xPos -= Math.sin(degToRad(90+yaw)) * strafeSpeed * elapsed;
			zPos -= Math.cos(degToRad(90+yaw)) * strafeSpeed * elapsed;
        }
        lastTime = timeNow;
    }
	
	public void update() {
		handleKeys();
		animate();
	}
}
