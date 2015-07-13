package controller;

import java.util.HashMap;
import java.util.Map;

import model.BlocHero;

public class HeroController {

	private BlocHero hero;

	protected enum deplacements {
		left, right, up, down, idle;
	}

	static Map<deplacements, Boolean> keys = new HashMap<deplacements, Boolean>();

	static {
		keys.put(deplacements.left, false);
		keys.put(deplacements.right, false);
		keys.put(deplacements.up, false);
		keys.put(deplacements.down, false);
	}

	/**
	 * Permet de r�cup�rer le GameListener de heroC
	 * 
	 * @param heroC
	 *            : controlleur de hero
	 */
	public HeroController(BlocHero hero) {

		this.hero = hero;
	}

	/**
	 * Lorsque la touche droite est pr�ss�e, ajoute � la HashMap un d�placement
	 * vers la droite � true
	 */
	public void droitePress() {

		keys.get(keys.put(deplacements.right, true));

	}

	/**
	 * Lorsque la touche droite est relach�e, ajoute � la HashMap un d�placement
	 * vers la droite � false
	 */
	public void droiteRelease() {

		keys.get(keys.put(deplacements.right, false));
	}

	/**
	 * Lorsque la touche gauche est pr�ss�e, ajoute � la HashMap un d�placement
	 * vers la gauche � true
	 */
	public void gauchePress() {

		keys.get(keys.put(deplacements.left, true));

	}

	/**
	 * Lorsque la touche gauche est relach�e, ajoute � la HashMap un d�placement
	 * vers la gauche � false
	 */
	public void gaucheRelease() {

		keys.get(keys.put(deplacements.left, false));
	}

	/**
	 * Lorsque la touche haut est pr�ss�e, ajoute � la HashMap un d�placement
	 * vers le haut � true
	 */
	public void hautPress() {

		keys.get(keys.put(deplacements.up, true));

	}

	/**
	 * Lorsque la touche haut est relach�e, ajoute � la HashMap un d�placement
	 * vers le haut � false
	 */
	public void hautRelease() {

		keys.get(keys.put(deplacements.up, false));
	}

	/**
	 * Lorsque la touche bas est pr�ss�e, ajoute � la HashMap un d�placement
	 * vers le bas � true
	 */
	public void basPress() {

		keys.get(keys.put(deplacements.down, true));

	}

	/**
	 * Lorsque la touche bas est relach�e, ajoute � la HashMap un d�placement
	 * vers le bas � false
	 */
	public void basRelease() {

		keys.get(keys.put(deplacements.down, false));
	}

	/**
	 * Fonction de mise � jour de la classe HeroController qui est appell�e dans
	 * GameScreen pour activer le contr�le du personnage avec le TouchPad
	 * 
	 * @param delta
	 */
	public void update(float delta) {
		hero.update(delta);
	}

	/**
	 * Fonction de mise a jour de la classe HeroController qui est appell�e dans
	 * GameScreen pour activer le contr�le du personnage avec les touches
	 * clavier
	 * 
	 * @param delta
	 */
	public void updateDesktop(float delta) {
		processInput();
		hero.update(delta);
	}

	/**
	 * Voir JavaDoc LibGDX
	 */
	public void processInput() {
		if (keys.get(deplacements.right)) {
			hero.setDeplacementsRight();
		} else if (keys.get(deplacements.left)) {
			hero.setDeplacementsLeft();
		} else if (keys.get(deplacements.up)) {
			hero.setDeplacementsUp();
		} else if (keys.get(deplacements.down)) {
			hero.setDeplacementsDown();
		} else {
			hero.setDeplacementsIdle();
		}
	}
}
