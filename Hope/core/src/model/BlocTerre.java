package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class BlocTerre extends Bloc {

	public BlocTerre(int positionX, int positionY) {
		super(positionX, positionY, null,null);
		texture = new Texture(Gdx.files.internal("dirt.png"));
		// TODO Auto-generated constructor stub
	}


}
