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
	 * Permet de récupérer le GameListener de heroC
	 * 
	 * @param heroC
	 *            : controlleur de hero
	 */
	public HeroController(BlocHero hero) {

		this.hero = hero;
	}

	/**
	 * Lorsque la touche droite est préssée, ajoute à la HashMap un déplacement
	 * vers la droite à true
	 */
	public void droitePress() {

		keys.get(keys.put(deplacements.right, true));

	}

	/**
	 * Lorsque la touche droite est relachée, ajoute à la HashMap un déplacement
	 * vers la droite à false
	 */
	public void droiteRelease() {

		keys.get(keys.put(deplacements.right, false));
	}

	/**
	 * Lorsque la touche gauche est préssée, ajoute à la HashMap un déplacement
	 * vers la gauche à true
	 */
	public void gauchePress() {

		keys.get(keys.put(deplacements.left, true));

	}

	/**
	 * Lorsque la touche gauche est relachée, ajoute à la HashMap un déplacement
	 * vers la gauche à false
	 */
	public void gaucheRelease() {

		keys.get(keys.put(deplacements.left, false));
	}

	/**
	 * Lorsque la touche haut est préssée, ajoute à la HashMap un déplacement
	 * vers le haut à true
	 */
	public void hautPress() {

		keys.get(keys.put(deplacements.up, true));

	}

	/**
	 * Lorsque la touche haut est relachée, ajoute à la HashMap un déplacement
	 * vers le haut à false
	 */
	public void hautRelease() {

		keys.get(keys.put(deplacements.up, false));
	}

	/**
	 * Lorsque la touche bas est préssée, ajoute à la HashMap un déplacement
	 * vers le bas à true
	 */
	public void basPress() {

		keys.get(keys.put(deplacements.down, true));

	}

	/**
	 * Lorsque la touche bas est relachée, ajoute à la HashMap un déplacement
	 * vers le bas à false
	 */
	public void basRelease() {

		keys.get(keys.put(deplacements.down, false));
	}

	/**
	 * Fonction de mise à jour de la classe HeroController qui est appellée dans
	 * GameScreen pour activer le contrôle du personnage avec le TouchPad
	 * 
	 * @param delta
	 */
	public void update(float delta) {
		hero.update(delta);
	}

	/**
	 * Fonction de mise a jour de la classe HeroController qui est appellée dans
	 * GameScreen pour activer le contrôle du personnage avec les touches
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
