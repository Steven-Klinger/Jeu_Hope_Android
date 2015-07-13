package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class BlocCoin3 extends Bloc {
	public BlocCoin3(int positionX, int positionY) {
		super(positionX, positionY, null,null);
		texture = new Texture(Gdx.files.internal("corner_3.png"));
		// TODO Auto-generated constructor stub
	}


}
