package com.ninelives;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
public class GameInputProcessor implements InputProcessor {
    private Cat cat;
    private boolean leftPressed, rightPressed, upPressed, downPressed;

    public GameInputProcessor(Cat cat) {
        this.cat = cat;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Keys.LEFT:
                leftPressed = true;
                break;
            case Keys.RIGHT:
                rightPressed = true;
                break;
            case Keys.UP:
                upPressed = true;
                break;
            case Keys.DOWN:
                downPressed = true;
                break;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Keys.LEFT:
                leftPressed = false;
                break;
            case Keys.RIGHT:
                rightPressed = false;
                break;
            case Keys.UP:
                upPressed = false;
                break;
            case Keys.DOWN:
                downPressed = false;
                break;
        }
        return false;
    }

    public void update(float deltaTime) {
        Vector2 force = new Vector2();
        if (leftPressed) force.add(-100, 0);
        if (rightPressed) force.add(100, 0);
        if (upPressed) force.add(0, 100);
        if (downPressed) force.add(0, -100);

        cat.applyForce(force.scl(deltaTime)); // Scale force by deltaTime for frame rate independence
    }

    @Override
    public boolean keyTyped(char character) {
        // Your implementation
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        // Your implementation
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        // Your implementation
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        // Your implementation
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        // Your implementation
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        // Your implementation
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        // Your implementation
        return false;
    }
}
