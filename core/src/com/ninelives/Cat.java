package com.ninelives;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Cat {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;
    private Texture texture;
    private Rectangle bounds;
    public Cat(float x, float y) {
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 0);
        texture = new Texture("cat.png"); // Replace with your cat texture path

        // Initialize the bounds object
        bounds = new Rectangle();
        // Set initial size or position if necessary
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 50; // Example width
        bounds.height = 50; // Example height
    }

    public void update(float delta) {
        // Apply acceleration to velocity
        velocity.add(acceleration.x * delta, acceleration.y * delta);

        // Update position based on velocity
        position.add(velocity.x * delta, velocity.y * delta);

        // Reset acceleration after applying it
        acceleration.set(0, 0);
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void applyForce(Vector2 force) {
        acceleration.add(force);
    }

    // Other methods like getBounds for collision detection

    public Rectangle getBounds() {
        return bounds;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 newVelocity) {
        velocity.set(newVelocity);
    }

    // Add more methods as needed for movement, collision, etc.
}