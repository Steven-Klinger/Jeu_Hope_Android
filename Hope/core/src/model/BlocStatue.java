package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class BlocStatue extends Bloc {

	private Rectangle boxStatue = new Rectangle(positionX, positionY, 22, 53);

	public BlocStatue(int positionX, int positionY) {
		super(positionX, positionY, null, null);
		texture = new Texture(Gdx.files.internal("statue.png"));
		rectangle = boxStatue;
		// TODO Auto-generated constructor stub
	}

	public Rectangle getBoxStatue() {

		return boxStatue;

	}
}
