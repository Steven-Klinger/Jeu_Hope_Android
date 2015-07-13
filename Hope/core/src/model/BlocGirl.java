package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class BlocGirl extends Bloc {

	private Rectangle boxGirl = new Rectangle(positionX, positionY, 52, 64);

	public BlocGirl(int positionX, int positionY) {
		super(positionX, positionY, null, null);
		texture = new Texture(Gdx.files.internal("Woman_stand_left.png"));
		rectangle = boxGirl;
		// TODO Auto-generated constructor stub
	}

	public Rectangle getBoxGirl() {

		return boxGirl;

	}
}
