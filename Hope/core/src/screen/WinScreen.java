package screen;

import game.Hope;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class WinScreen implements Screen {

	private Hope hp;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Viewport viewport;
	private Sprite aspectRatios;
	private Music sound;

	/**
	 * Constructeur de la classe WinScreen : ecran de gameover si le joueur
	 * gagne
	 * 
	 * @param hp
	 */
	public WinScreen(Hope hp) {
		
		this.hp = hp;


	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		sound = Gdx.audio.newMusic(Gdx.files.internal("win.wav"));

		if (sound.isPlaying() == false) {
			sound.play();
		}

		sound.setLooping(true);

		batch = new SpriteBatch();

		aspectRatios = new Sprite(new Texture(Gdx.files.internal("win.png")));
		aspectRatios.setPosition(0, 0);
		aspectRatios.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		camera = new OrthographicCamera(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		camera.position.set(camera.viewportWidth / 2,
				camera.viewportHeight / 2, 0);

		viewport = new FitViewport(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight(), camera);
		viewport.apply();

	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stubs
		camera.update();

		batch.setProjectionMatrix(camera.combined);
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		aspectRatios.draw(batch);
		if (Gdx.input.justTouched()) // use your own criterion here
			hp.setScreen(new MenuScreen(hp));
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(camera.viewportWidth / 2,
				camera.viewportHeight / 2, 0);

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		sound.stop();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		batch.dispose();
		sound.dispose();

	}

}
