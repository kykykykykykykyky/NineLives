package com.ninelives;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.ninelives.NineLivesGame;

public class DesktopLauncher {
    public static void main (String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

        // Set configuration options using setter methods
        config.setTitle("Nine Lives");
        config.setWindowedMode(800, 600); // Example width and height

        // Other configuration settings...
        // For example, to set the background FPS limit:
        // config.setBackgroundFPS(60);

        new Lwjgl3Application(new NineLivesGame(), config);
    }
}