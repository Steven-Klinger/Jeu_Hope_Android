package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class BlocCoin4 extends Bloc {
	public BlocCoin4(int positionX, int positionY) {
		super(positionX, positionY, null,null);
		texture = new Texture(Gdx.files.internal("corner_4.png"));
		// TODO Auto-generated constructor stub
	}


}
