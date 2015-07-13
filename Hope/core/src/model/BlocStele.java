package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class BlocStele extends Bloc {

	private Rectangle boxStele = new Rectangle(positionX, positionY, 37, 74);

	public BlocStele(float positionX, float positionY) {
		super(positionX, positionY, null, null);
		texture = new Texture(Gdx.files.internal("stele.png"));
		rectangle = boxStele;
		// TODO Auto-generated constructor stub
	}

	public Rectangle getBoxStele() {

		return boxStele;

	}
}
