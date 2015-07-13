package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class BlocCoin2 extends Bloc {
	public BlocCoin2(int positionX, int positionY) {
		super(positionX, positionY, null,null);
		texture = new Texture(Gdx.files.internal("corner_2.png"));
		// TODO Auto-generated constructor stub
	}


}
