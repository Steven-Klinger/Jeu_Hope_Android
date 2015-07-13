package game;

import screen.MenuScreen;
import model.Level;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.Texture;

public class Hope extends Game {

	private Texture img;
	private Level level;
	private FPSLogger fps;

	/**
	 * Constructeur de la classe Hope
	 */
	public Hope() {

		this.fps = new FPSLogger();

	}

	/**
	 * Voir Javadoc LibGDX
	 */
	public void create() {

		level = new Level(this);
		setScreen(new MenuScreen(this));
	}

	/**
	 * Voir Javadoc LibGDX
	 */
	public void render() {
		super.render();
		fps.log();
	}	
}
