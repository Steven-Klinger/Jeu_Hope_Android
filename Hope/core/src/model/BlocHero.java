package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class BlocHero extends Bloc {

	private enum Deplacements {
		left, right, up, down, idle;
	}

	private int life = 5;
	private float speed = 5;
	private Deplacements deplacements = Deplacements.idle;
	private Rectangle boxHero = new Rectangle(positionX, positionY, 52, 64);
	private Animation heroRight;
	private TextureAtlas atlasRight;
	private Animation heroLeft;
	private TextureAtlas atlasLeft;
	private Animation heroUp;
	private TextureAtlas atlasUp;
	private Animation heroDown;
	private TextureAtlas atlasDown;
	private float stateTime = 0;
	private static final float JUMPING_FRAME_DURATION = 0.2f;

	public BlocHero(int positionX, int positionY) {

		super(positionX, positionY, null, null);
		texture = new Texture(Gdx.files.internal("empty.png"));
		// TODO Auto-generated constructor stub
		rectangle = boxHero;

		this.atlasRight = new TextureAtlas(Gdx.files.internal("heroRight.txt"));

		TextureRegion[] rightFrames = new TextureRegion[3];
		rightFrames[0] = atlasRight.findRegion("Man_step_right1");
		rightFrames[1] = atlasRight.findRegion("Man_step_right2");
		rightFrames[2] = atlasRight.findRegion("Man_step_right3");
		setHeroRight(new Animation(JUMPING_FRAME_DURATION, rightFrames));

		this.atlasLeft = new TextureAtlas(Gdx.files.internal("heroLeft.txt"));

		TextureRegion[] leftFrames = new TextureRegion[3];
		leftFrames[0] = atlasLeft.findRegion("Man_step_left1");
		leftFrames[1] = atlasLeft.findRegion("Man_step_left2");
		leftFrames[2] = atlasLeft.findRegion("Man_step_left3");
		setHeroLeft(new Animation(JUMPING_FRAME_DURATION, leftFrames));

		this.atlasUp = new TextureAtlas(Gdx.files.internal("heroUp.txt"));

		TextureRegion[] upFrames = new TextureRegion[3];
		upFrames[0] = atlasUp.findRegion("Man_step_back1");
		upFrames[1] = atlasUp.findRegion("Man_step_back2");
		upFrames[2] = atlasUp.findRegion("Man_step_back3");
		setHeroUp(new Animation(JUMPING_FRAME_DURATION, upFrames));

		this.atlasDown = new TextureAtlas(Gdx.files.internal("heroDown.txt"));

		TextureRegion[] downFrames = new TextureRegion[3];
		downFrames[0] = atlasDown.findRegion("Man_step_front1");
		downFrames[1] = atlasDown.findRegion("Man_step_front2");
		downFrames[2] = atlasDown.findRegion("Man_step_front3");
		setHeroDown(new Animation(JUMPING_FRAME_DURATION, downFrames));

	}

	public int getLife() {

		return life;

	}

	public void setLife(int life) {

		this.life = life;

	}

	public Rectangle getBoxHero() {
		return boxHero;
	}

	public float getSpeed() {

		return speed;
	}

	public void setSpeed(float speed) {

		this.speed = speed;
	}

	public Deplacements getDeplacements() {

		return deplacements;

	}

	public void setDeplacementsRight() {

		deplacements = Deplacements.right;

	}

	public void setDeplacementsLeft() {

		deplacements = Deplacements.left;

	}

	public void setDeplacementsUp() {

		deplacements = Deplacements.up;
	}

	public void setDeplacementsDown() {

		deplacements = Deplacements.down;

	}

	public void setDeplacementsIdle() {

		deplacements = Deplacements.idle;
	}

	/**
	 * Permet de faire un switch dans la classe Level pour tester les collisions
	 * avec des éléments qui ne bougent pas
	 * 
	 * @return deplacement : int
	 */
	public int getDeplacementsInt() {

		int deplacement = 0;
		switch (deplacements) {
		case up:

			deplacement = 1;
			break;

		case down:

			deplacement = 2;
			break;

		case right:

			deplacement = 3;
			break;

		case left:

			deplacement = 4;
			break;

		case idle:

			deplacement = 5;
			break;

		default:

			break;

		}
		return deplacement;

	}

	/**
	 * Fonction de mise à jour de la classe BlocHero : Teste et gère les
	 * déplacements du Hero
	 * 
	 * @param delta
	 */
	public void update(float delta) {

		this.stateTime += delta;

		switch (deplacements) {
		case up:

			if (positionY <= 700) {
				positionY = (int) (positionY + speed);
				texture = new Texture(Gdx.files.internal("empty.png"));
			}

			break;

		case down:

			if (positionY > 0) {
				positionY = (int) (positionY - speed);
				texture = new Texture(Gdx.files.internal("empty.png"));

			}
			break;

		case right:
			if (positionX <= 1225) {
				positionX = (int) (positionX + speed);
				texture = new Texture(Gdx.files.internal("empty.png"));
			}
			break;
		case left:

			if (positionX > 0) {
				positionX = (int) (positionX - speed);
				texture = new Texture(Gdx.files.internal("empty.png"));
			

			}
			break;

		case idle:

			texture = new Texture(Gdx.files.internal("Man_stand_right.png"));
			break;

		default:
			break;

		}

	}

	public Animation getHeroRight() {
		return heroRight;
	}

	public void setHeroRight(Animation heroRight) {
		this.heroRight = heroRight;
	}

	public float getStateTime() {
		// TODO Auto-generated method stub
		return stateTime;
	}

	public Animation getHeroLeft() {
		return heroLeft;
	}

	public void setHeroLeft(Animation heroLeft) {
		this.heroLeft = heroLeft;
	}

	public Animation getHeroUp() {
		return heroUp;
	}

	public void setHeroUp(Animation heroUp) {
		this.heroUp = heroUp;
	}

	public Animation getHeroDown() {
		return heroDown;
	}

	public void setHeroDown(Animation heroDown) {
		this.heroDown = heroDown;
	}
}
