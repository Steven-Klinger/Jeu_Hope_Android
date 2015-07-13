package controller;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class GameListener implements InputProcessor {

	private HeroController heroC;

	/**
	 * Permet de récupérer le GameListener de heroC
	 * 
	 * @param heroC
	 *            : controlleur de hero
	 */
	public GameListener(HeroController heroC) {
		this.heroC = heroC;
	}

	/**
	 * Comportement du personnage lorsqu'une touche est enfoncée
	 * 
	 * @param keycode
	 *            : code de la touche pressée
	 */
	public boolean keyDown(int keycode) {
		switch (keycode) {

		case (Keys.LEFT):
			heroC.gauchePress();
			break;
		case (Keys.RIGHT):
			heroC.droitePress();
			break;
		case (Keys.UP):
			heroC.hautPress();
			break;
		case (Keys.DOWN):
			heroC.basPress();
			break;
		default:

			break;

		}
		return false;

		// TODO Auto-generated method stub
	}

	/**
	 * Comportement du personnage lorsqu'une touche est relachée
	 * 
	 * @param keycode
	 *            : code de la touche relachée
	 */
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		switch (keycode) {

		case (Keys.LEFT):
			heroC.gaucheRelease();
			break;
		case (Keys.RIGHT):
			heroC.droiteRelease();
			break;
		case (Keys.UP):
			heroC.hautRelease();
			break;
		case (Keys.DOWN):
			heroC.basRelease();
			break;
		default:

			break;

		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
