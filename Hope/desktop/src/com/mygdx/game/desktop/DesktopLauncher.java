package com.mygdx.game.desktop;

import game.Hope;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1280;
		config.height = 768;
		config.title = "Hope";
		config.resizable = false;
		//config.fullscreen = true;
		new LwjglApplication(new Hope(), config);
	}
}
