package com.googlecode.gwtgl.example.client.examples.skybox;

import java.util.Date;

import com.google.gwt.event.dom.client.KeyCodes;
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
import com.google.gwt.user.client.Window;

/**
 * Simple camera class that can consume mouse events and provides camera rotation data.
 * @author Sönke Sothmann
 */
public class Camera implements MouseMoveHandler, MouseDownHandler, MouseUpHandler, KeyDownHandler, KeyUpHandler {
	
	int oldMouseX = 0;
	int oldMouseY = 0;
	boolean mouseDown = false;
	private int angleX;
	private int angleY;
	
	private boolean[] currentlyPressedKeys;
	
	private double pitchRate;
	private double pitch;
	private double yawRate;
	private double yaw;
	private double speed;
	
    private long lastTime = 0;
    // Used to make us "jog" up and down as we move forward.
    private double joggingAngle = 0;
    
    private double xPos;
    private double yPos;
    private double zPos;
	
	public Camera() {
		currentlyPressedKeys = new boolean[255]; //TODO: Is this high enough?
		xPos = 0.0;
		yPos = 0.4;
		zPos = 0.0;
	}
	
	
	public float getXPos() {
		return (float)xPos;
	}
	public float getYPos() {
		return (float)yPos;
	}
	public float getZPos() {
		return (float)zPos;
	}
	
	private void handleKeys() {
        if (currentlyPressedKeys[33]) {
            // Page Up
            pitchRate = 0.1;
        } else if (currentlyPressedKeys[34]) {
            // Page Down
            pitchRate = -0.1;
        } else {
            pitchRate = 0;
        }

        if (currentlyPressedKeys[37] || currentlyPressedKeys[65]) {
            // Left cursor key or A
            yawRate = 0.1;
        } else if (currentlyPressedKeys[39] || currentlyPressedKeys[68]) {
            // Right cursor key or D
            yawRate = -0.1;
        } else {
            yawRate = 0;
        }

        if (currentlyPressedKeys[38] || currentlyPressedKeys[87]) {
            // Up cursor key or W
            speed = 0.003;
        } else if (currentlyPressedKeys[40] || currentlyPressedKeys[83]) {
            // Down cursor key
            speed = -0.003;
        } else {
            speed = 0;
        }
	}
	
	/**
	 * Get camera rotation on x axis
	 * @return rotation on x axis
	 */
	public int getRotationXAxis() {
//		return angleX;
		return (int)pitch;
	}

	/**
	 * Get camera rotation on y axis
	 * @return rotation on y axis
	 */
	public int getRotationYAxis() {
//		return angleY;
		return (int)yaw;
	}

	@Override
	public void onMouseMove(MouseMoveEvent event) {
		int mouseMoveX = event.getX()-oldMouseX;
		int mouseMoveY = event.getY()-oldMouseY;
		oldMouseX = event.getX();
		oldMouseY = event.getY();
		if(mouseDown){
			angleX += (mouseMoveY/2f) % 360;
			angleY += (mouseMoveX/2f) % 360;
		}
	}
	
	// Handle keyboard input
	@Override
	public void onKeyDown(KeyDownEvent event) {
		currentlyPressedKeys[event.getNativeKeyCode()] = true;
	}
	
	@Override
	public void onKeyUp(KeyUpEvent event) {
		currentlyPressedKeys[event.getNativeKeyCode()] = false;
	}

	@Override
	public void onMouseDown(MouseDownEvent event) {
		mouseDown = true;
	}

	@Override
	public void onMouseUp(MouseUpEvent event) {
		mouseDown = false;
	}

	//TODO:Put in Util class.
    double degToRad(double degrees) {
        return degrees * Math.PI / 180;
    }

    private void animate() {
        long timeNow = new Date().getTime();
        if (lastTime != 0) {
            long elapsed = timeNow - lastTime;

            if (speed != 0) {
                xPos -= Math.sin(degToRad(yaw)) * speed * elapsed;
                zPos -= Math.cos(degToRad(yaw)) * speed * elapsed;

                joggingAngle += elapsed * 0.6; // 0.6 "fiddle factor" - makes it feel more realistic :-)
                yPos = Math.sin(degToRad(joggingAngle)) / 20 + 0.4;
            }

            yaw += yawRate * elapsed;
            pitch += pitchRate * elapsed;
        }
        lastTime = timeNow;
    }
	
	public void update() {
		handleKeys();
		animate();
	}
}
