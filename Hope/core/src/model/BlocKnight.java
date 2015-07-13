package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class BlocKnight extends Bloc {

	private enum Deplacements {
		up, down, idle;
	}

	private Deplacements deplacementsK = Deplacements.down;
	private int speed;
	private int positionInitY;
	private Rectangle boxKnight = new Rectangle(positionX, positionY, 64, 92);

	public BlocKnight(int positionX, int positionY, int speed) {
		super(positionX, positionY, null, null);
		texture = new Texture(Gdx.files.internal("Knight_stand_front.png"));
		this.speed = speed;
		this.positionInitY = positionY;
		this.rectangle = boxKnight;

	}

	public Rectangle getBoxKnight() {

		return boxKnight;
	}

	public void setSpeed(int speed) {

		this.speed = speed;
	}

	/**
	 * Fonction de mise à jour de la classe BlocKnight : permet de gérer les
	 * déplacements de tout les chevaliers noirs
	 * 
	 * @param delta
	 */
	
	public void update(float delta) {

		switch (deplacementsK) {
		case up:

			break;

		case down:

			if (positionY > 0 - 100) {
				
				
				positionY = positionY - speed;

			} else {

				positionY = (int) (positionInitY + 100
						* (float) Gdx.graphics.getHeight() / (float) 578);
				int rand = 2 + (int) (Math.random() * ((10 - 2) + 2));
				setSpeed(rand);

			}

		case idle:
			break;

		default:
			break;

		}
	}
}
