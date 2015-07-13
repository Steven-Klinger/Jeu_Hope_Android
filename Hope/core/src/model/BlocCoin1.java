package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class BlocCoin1 extends Bloc {
	
	public BlocCoin1(int positionX, int positionY) {
		super(positionX, positionY, null,null);
		texture = new Texture(Gdx.files.internal("corner_1.png"));
		// TODO Auto-generated constructor stub
	}


}
