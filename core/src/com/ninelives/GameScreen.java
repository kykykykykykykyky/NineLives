package com.ninelives;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.math.Vector2;


public class GameScreen implements Screen {
    private NineLivesGame game;
    private OrthographicCamera camera;
    private Viewport viewport;
    private ShapeRenderer shapeRenderer;

    private static final float WORLD_WIDTH = 100;
    private static final float WORLD_HEIGHT = 150;
    private Cat cat;
    private GameInputProcessor inputProcessor;
    public GameScreen(NineLivesGame game) {
        this.game = game;
        camera = new OrthographicCamera();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        shapeRenderer = new ShapeRenderer();
        cat = new Cat(100, WORLD_HEIGHT - 150); // Initial position of the cat
        inputProcessor = new GameInputProcessor(cat);
        Gdx.input.setInputProcessor(inputProcessor);
    }

    @Override
    public void show() {
        // Initialize resources and setup when this screen is shown
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        shapeRenderer.setProjectionMatrix(camera.combined);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(1, 1, 1, 1); // White color
        shapeRenderer.line(10, 0, 10, WORLD_HEIGHT);
        shapeRenderer.line(WORLD_WIDTH - 10, 0, WORLD_WIDTH - 10, WORLD_HEIGHT);
        shapeRenderer.end();

        game.batch.begin();
        cat.draw(game.batch);
        game.batch.end();

        // Update the cat's movement based on the current key states
        inputProcessor.update(delta);

        cat.update(delta);
        checkCollisions();
    }
    private void checkCollisions() {
        if (cat.getBounds().x < 10 || cat.getBounds().x + cat.getBounds().width > WORLD_WIDTH - 10) {
            Vector2 currentVelocity = cat.getVelocity();
            cat.setVelocity(new Vector2(-currentVelocity.x, currentVelocity.y)); // Reverse the horizontal velocity on collision
        }
    }
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {
        // Handle pause
    }

    @Override
    public void resume() {
        // Handle resume
    }

    @Override
    public void hide() {
        // Handle when this screen is no longer the current screen
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
        // Dispose other resources if any
    }
}