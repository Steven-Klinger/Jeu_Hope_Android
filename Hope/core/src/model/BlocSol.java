package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class BlocSol extends Bloc {

	public BlocSol(int positionX, int positionY) {
		super(positionX, positionY, null,null);
		texture = new Texture(Gdx.files.internal("stone.png"));
		// TODO Auto-generated constructor stub
	}

}
