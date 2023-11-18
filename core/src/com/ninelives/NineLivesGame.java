package com.ninelives;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class NineLivesGame extends Game {
	public SpriteBatch batch;

	@Override
	public void create() {
		batch = new SpriteBatch();
		// Set the initial screen to the game screen
		this.setScreen(new GameScreen(this));
	}

	@Override
	public void render() {
		super.render(); // Important to call the render method of the current screen
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
}