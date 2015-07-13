package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class Bloc {

	protected float positionX;
	protected float positionY;
	protected Texture texture;
	protected Rectangle rectangle;

	/**
	 * Classe abstraite permettant de créer toutes sortes de Bloc
	 * 
	 * @param positionX
	 *            : position en X du bloc
	 * @param positionY
	 *            : position en Y du bloc
	 * @param texture
	 *            : texture du bloc
	 * @param rectangle
	 *            : hitbox du bloc
	 */
	public Bloc(float positionX, float positionY, Texture texture,
			Rectangle rectangle) {

		this.positionX = positionX;
		this.positionY = positionY;
		this.texture = texture;
		this.rectangle = rectangle;

	}

	public void setPositionX(float f) {
		this.positionX = f;
	}

	public void setPositionY(float positionY) {
		this.positionY = positionY;
	}

	public float getPositionX() {
		return positionX;
	}

	public float getPositionY() {
		return positionY;
	}

	public Texture getTexture() {
		return texture;
	}

	public Texture setTexture(Texture t) {

		return texture = t;
	}

	public Rectangle getRectangle() {

		return rectangle;

	}

	public void setRectangle(Rectangle r) {

		r.x = positionX;
		r.y = positionY;

	}

}
