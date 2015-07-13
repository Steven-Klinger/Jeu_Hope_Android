package screen;

import game.Hope;
import model.Bloc;
import model.BlocKnight;
import model.Level2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import controller.GameListener;
import controller.HeroController;

public class GameScreen2 implements Screen {

	private Hope hp;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private HeroController heroC;
	private Viewport viewport;
	private Sprite aspectRatios;
	private Stage stage;
	private Touchpad touchpad;
	private TouchpadStyle touchpadStyle;
	private Skin touchpadSkin;
	private Drawable touchPadBackground;
	private Drawable touchPadButton;
	private Music sound;
	private Texture lifeT;
	private TextureRegion myLifeT;
	private TextureAtlas heroRight;
	private TextureRegion heroRightRegion;
	private TextureAtlas heroLeft;
	private TextureRegion heroLeftRegion;
	private TextureAtlas heroUp;
	private TextureRegion heroUpRegion;
	private TextureAtlas heroDown;
	private TextureRegion heroDownRegion;
	private Level2 level2;

	/**
	 * Constructeur de la classe Gamescreen : ecran de jeu principal
	 * 
	 * @param hp
	 *            : classe maître de l'application
	 */
	public GameScreen2(Hope hp) {

		this.hp = hp;
		this.level2 = new Level2(hp);
		this.heroRight = new TextureAtlas(Gdx.files.internal("heroRight.txt"));
		this.heroRightRegion = new TextureRegion();
		this.heroUp = new TextureAtlas(Gdx.files.internal("heroUp.txt"));
		this.heroUpRegion = new TextureRegion();
		this.heroDown = new TextureAtlas(Gdx.files.internal("heroDown.txt"));
		this.heroDownRegion = new TextureRegion();
		this.heroLeft = new TextureAtlas(Gdx.files.internal("heroLeft.txt"));
		this.heroLeftRegion = new TextureRegion();

	}

	/**
	 * Voir javaDoc LibJDX
	 */
	public void render(float delta) {
		// TODO Auto-generated method stub
		camera.update();

		batch.setProjectionMatrix(camera.combined);
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		/*****
		 * Permet d'activer le touchpad sur android et d'activer les touches du
		 * clavier sur la version Desktop
		 ******/

		switch (Gdx.app.getType()) {
		case Android:
			Gdx.input.setInputProcessor(stage);
			heroC.update(delta);
			break;
		case Desktop:
			Gdx.input.setInputProcessor(new GameListener(heroC));
			heroC.updateDesktop(delta);
			break;
		default:
			break;
		}

		for (BlocKnight bloc : level2.getKnight()) {

			bloc.update(delta);

		}

		level2.update(delta);
		batch.begin();

		aspectRatios.draw(batch);
		batch.setProjectionMatrix(camera.combined);

		/******************************* Permet de placer les textures objets ************/
		for (Bloc bloc : this.level2) {

			Texture a = bloc.getTexture();
			int b = (int) bloc.getPositionX();
			int c = (int) bloc.getPositionY();

			batch.draw(a, b, c);

		}

		switch (level2.getHero().getDeplacementsInt()) {
		case 1: // Up
			heroUpRegion = level2.getHero().getHeroUp()
					.getKeyFrame(level2.getHero().getStateTime(), true);
			batch.draw(heroUpRegion, level2.getHero().getPositionX(), level2
					.getHero().getPositionY());
			break;
		case 2: // down

			heroDownRegion = level2.getHero().getHeroDown()
					.getKeyFrame(level2.getHero().getStateTime(), true);
			batch.draw(heroDownRegion, level2.getHero().getPositionX(), level2
					.getHero().getPositionY());

			break;
		case 3:// right

			heroRightRegion = level2.getHero().getHeroRight()
					.getKeyFrame(level2.getHero().getStateTime(), true);
			batch.draw(heroRightRegion, level2.getHero().getPositionX(), level2
					.getHero().getPositionY());

			break;
		case 4:// left
			heroLeftRegion = level2.getHero().getHeroLeft()
					.getKeyFrame(level2.getHero().getStateTime(), true);
			batch.draw(heroLeftRegion, level2.getHero().getPositionX(), level2
					.getHero().getPositionY());

			break;
		default:
			break;
		}
		/*********** BARRE DE VIE ***********************/

		switch (level2.getHero().getLife()) {

		case 5:
			this.lifeT = new Texture(Gdx.files.internal("life5.png"));
			this.myLifeT = new TextureRegion(lifeT, 0, 0, 389, 73);
			batch.draw(myLifeT, 0, 690);
			break;
		case 4:
			this.lifeT = new Texture(Gdx.files.internal("life4.png"));
			this.myLifeT = new TextureRegion(lifeT, 0, 0, 389, 73);
			batch.draw(myLifeT, 0, 690);
			break;
		case 3:
			lifeT = new Texture(Gdx.files.internal("life3.png"));
			this.myLifeT = new TextureRegion(lifeT, 0, 0, 389, 73);
			batch.draw(myLifeT, 0, 690);
			break;
		case 2:
			lifeT = new Texture(Gdx.files.internal("life2.png"));
			this.myLifeT = new TextureRegion(lifeT, 0, 0, 389, 73);
			batch.draw(myLifeT, 0, 690);
			break;
		case 1:
			lifeT = new Texture(Gdx.files.internal("life1.png"));
			this.myLifeT = new TextureRegion(lifeT, 0, 0, 389, 73);
			batch.draw(myLifeT, 0, 690);
			break;
		}

		/********************************** TOUCHPAD ******************************/
		batch.end();

		if (touchpad.getKnobPercentX() == 0 && touchpad.getKnobPercentY() == 0) {
			level2.getHero().setDeplacementsIdle();
		}
		if (touchpad.getKnobPercentX() > 0
				&& touchpad.getKnobPercentX() > touchpad.getKnobPercentY()) {
			level2.getHero().setDeplacementsRight();
		}
		if (touchpad.getKnobPercentX() < 0
				&& touchpad.getKnobPercentX() < touchpad.getKnobPercentY()) {
			level2.getHero().setDeplacementsLeft();
		}
		if (touchpad.getKnobX() <= 152 && touchpad.getKnobY() < 100
				&& touchpad.getKnobPercentY() < touchpad.getKnobPercentX()) {
			level2.getHero().setDeplacementsDown();
		}
		if (touchpad.getKnobY() > 138 && touchpad.getKnobX() > 50
				&& touchpad.getKnobPercentY() > touchpad.getKnobPercentX()) {
			level2.getHero().setDeplacementsUp();
		}
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();

		// for(Bloc bloc : this.level){
		//
		// batch.draw(bloc.getTexture(),bloc.getPositionX(),bloc.getPositionY());
		//
		// }
		// batch.end();

	}

	/**
	 * Voir javaDoc LibJDX
	 */
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(camera.viewportWidth / 2,
				camera.viewportHeight / 2, 0);
		touchpad.setBounds(980, 15, 200, 200);
	}

	/**
	 * Voir javaDoc LibJDX
	 */
	public void show() {
		// TODO Auto-generated method stub

		/********************* MUSIQUE *******************************/
		sound = Gdx.audio.newMusic(Gdx.files.internal("music2.wav"));

		if (sound.isPlaying() == false) {
			sound.play();
		}

		sound.setLooping(true);

		batch = new SpriteBatch();

		/************************ ECRAN *****************************************************/
		aspectRatios = new Sprite(new Texture(Gdx.files.internal("fond.png")));
		aspectRatios.setPosition(0, 0);
		aspectRatios.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		camera = new OrthographicCamera(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		camera.position.set(camera.viewportWidth / 2,
				camera.viewportHeight / 2, 0);

		viewport = new FitViewport(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight(), camera);
		viewport.apply();

		heroC = new HeroController(level2.getHero());

		/******************************** TOUCHPAD ****************************************/

		touchpadSkin = new Skin();
		touchpadSkin.add("touchPadBackground", new Texture(
				"touchPadBackground.png"));
		touchpadSkin.add("touchPadButton", new Texture("touchPadButton.png"));

		touchpadStyle = new TouchpadStyle();
		touchPadBackground = touchpadSkin.getDrawable("touchPadBackground");
		touchPadButton = touchpadSkin.getDrawable("touchPadButton");

		touchpadStyle.background = touchPadBackground;
		touchpadStyle.knob = touchPadButton;

		// Crée un touchpadd avec le style crée auparavant
		touchpad = new Touchpad(10, touchpadStyle);
		// position du TouchPad
		touchpad.setBounds(980, 15, 200, 200);

		stage = new Stage();
		stage.addActor(touchpad);

	}

	/**
	 * Voir javaDoc LibJDX
	 */
	public void hide() {
		// TODO Auto-generated method stub
		sound.stop();
	}

	/**
	 * Voir javaDoc LibJDX
	 */
	public void pause() {
		// TODO Auto-generated method stub
	}

	/**
	 * Voir javaDoc LibJDX
	 */
	public void resume() {
		// TODO Auto-generated method stub
	}

	/**
	 * Voir javaDoc LibJDX
	 */
	public void dispose() {
		// TODO Auto-generated method stub
		batch.dispose();
		sound.dispose();
		lifeT.dispose();
		heroRight.dispose();
		heroLeft.dispose();
		heroUp.dispose();
		heroDown.dispose();
	}

}