package com.mob.client.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mob.client.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
        System.setProperty("org.lwjgl.opengl.Display.enableOSXFullscreenModeAPI", "true");
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "Client";
        cfg.width = Game.GAME_SCREEN_WIDTH;
        cfg.height = Game.GAME_SCREEN_HEIGHT;
        cfg.fullscreen = Game.GAME_FULL_SCREEN;
        cfg.vSyncEnabled = Game.GAME_VSYNC_ENABLED;
        cfg.foregroundFPS = 0;
        cfg.resizable = false;
        
        new LwjglApplication(new Game(), cfg);
	}
}
