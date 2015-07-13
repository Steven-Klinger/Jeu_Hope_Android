package com.mygdx.game.android;

import game.Hope;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		/*
		 * Permet de cacher les icônes téléphones pour avoir une meilleure prise
		 * en main du joystick
		 */
		config.useImmersiveMode = true;
		initialize(new Hope(), config);
	}
}
