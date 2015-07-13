package model;

import game.Hope;

import java.util.ArrayList;
import java.util.Iterator;

import screen.LoseScreen;
import screen.TransiScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class Level implements Iterable<Bloc> {

	// protected int[][] tabBloc = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	// { 5, 1, 1, 1, 1, 1, 1, 1, 2 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1 },
	// { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1 },
	// { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1 },
	// { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1 },
	// { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1 },
	// { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1 },
	// { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 4, 1, 1, 1, 1, 1, 1, 1, 3 },
	// { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	private Hope hp;
	private int[][] tabObjets = { { 0, 0, 0, 0, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 3 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 3 }, { 0, 0, 0, 0, 0, 0, 0, 0, 3 },
			{ 5, 5, 0, 0, 0, 0, 0, 5, 5 }, { 0, 0, 0, 0, 0, 0, 0, 4, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 3 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 3 }, { 0, 0, 0, 0, 0, 0, 0, 0, 3 },
			{ 0, 0, 0, 0, 0, 0, 0, 2, 0 } };

	private ArrayList<Bloc> listeBloc;
	private BlocHero hero;
	private BlocKnight knight;
	private BlocGirl girl;
	private BlocStatue statue;
	private BlocStele stele;
	private ArrayList<BlocKnight> listeBlocKnight;
	private ArrayList<BlocStatue> listeBlocStatue;
	private ArrayList<BlocStele> listeBlocStele;
	private Sound bonus;

	/**
	 * Constructeur classe Level
	 * 
	 * @param hp
	 *            : classe maître de l'application
	 */
	public Level(Hope hp) {

		this.bonus = Gdx.audio.newSound(Gdx.files.internal("life.wav"));

		this.hp = hp;
		// int i = 0;
		// int j = 0;
		int k = 0;
		int l = 0;

		listeBloc = new ArrayList<Bloc>();
		listeBlocKnight = new ArrayList<BlocKnight>();
		listeBlocStatue = new ArrayList<BlocStatue>();
		listeBlocStele = new ArrayList<BlocStele>();

		// for (i = 0; i < tabBloc.length; i++) {
		// for (j = 0; j < tabBloc[i].length; j++) {
		//
		// switch (tabBloc[i][j]) {
		// case 0:
		// listeBloc.add(new BlocSol(i * 64, j * 64));
		// break;
		//
		// case 1:
		// listeBloc.add(new BlocTerre(i * 64, j * 64));
		// break;
		//
		// case 2:
		// listeBloc.add(new BlocCoin1(i * 64, j * 64));
		// break;
		//
		// case 3:
		// listeBloc.add(new BlocCoin2(i * 64, j * 64));
		// break;
		//
		// case 4:
		// listeBloc.add(new BlocCoin3(i * 64, j * 64));
		// break;
		//
		// case 5:
		// listeBloc.add(new BlocCoin4(i * 64, j * 64));
		// break;
		//
		// default:
		// }
		// }
		// }
		// }

		for (k = 0; k < tabObjets.length; k++) {
			for (l = 0; l < tabObjets[k].length; l++) {

				switch (tabObjets[k][l]) {

				case 1:
					this.hero = new BlocHero(
							k
									* (int) (64 * ((float) Gdx.graphics
											.getWidth() / (float) 1000)),
							l
									* (int) (64 * ((float) Gdx.graphics
											.getHeight() / (float) 578)));
					listeBloc.add(hero);

					break;

				case 2:
					this.girl = new BlocGirl(
							k
									* (int) (64 * ((float) Gdx.graphics
											.getWidth() / (float) 1000)),
							l
									* (int) (64 * ((float) Gdx.graphics
											.getHeight() / (float) 578)));
					listeBloc.add(girl);
					break;

				case 3:
					int rand = 1 + (int) (Math.random() * ((10 - 1) + 1));
					this.knight = new BlocKnight(
							k
									* (int) (64 * ((float) Gdx.graphics
											.getWidth() / (float) 1000)),
							l
									* (int) (64 * ((float) Gdx.graphics
											.getHeight() / (float) 578)), rand);
					listeBloc.add(knight);
					listeBlocKnight.add(knight);
					break;

				case 4:

					this.statue = new BlocStatue(
							k
									* (int) (64 * ((float) Gdx.graphics
											.getWidth() / (float) 1000)),
							l
									* (int) (64 * ((float) Gdx.graphics
											.getHeight() / (float) 578)));
					listeBloc.add(statue);
					listeBlocStatue.add(statue);
					break;

				case 5:

					this.stele = new BlocStele(
							k
									* (int) (64 * ((float) Gdx.graphics
											.getWidth() / (float) 1000)),
							l
									* (int) (64 * ((float) Gdx.graphics
											.getHeight() / (float) 578)));
					listeBloc.add(stele);
					listeBlocStele.add(stele);
					break;

				default:

				}
			}
		}
	}

	/**
	 * Fonction de mise à jour de la classe Level : permet de tester toutes les
	 * collisions entre le hero et le reste des éléments
	 * 
	 * @param delta
	 */

	public void update(float delta) {

		/********** COLLISIONS AVEC CHEVALIERS NOIRS ****************/
		hero.setRectangle(hero.getBoxHero());

		for (BlocKnight knight : listeBlocKnight) {
			
			knight.setRectangle(knight.getBoxKnight());
			boolean col = hero.getRectangle().overlaps(knight.getRectangle());
			if (col == true) {
				Gdx.input.vibrate(200);
				hero.setPositionX(0);
				hero.setLife(hero.getLife() - 1);
				if (hero.getLife() == 0) {
					hp.setScreen(new LoseScreen(hp));
				}
				hero.setSpeed(5);
			}
		}

		/********* COLLISION AVEC GIRL ************************************/
		boolean win = hero.getRectangle().overlaps(girl.getRectangle());

		if (win == true) {

			hp.setScreen(new TransiScreen(hp));
		}

		/************ COLLISION AVEC STELE ******************/
		for (BlocStele stele : listeBlocStele) {

			stele.setRectangle(stele.getBoxStele());
			boolean colSt = hero.getRectangle().overlaps(stele.getRectangle());
			if (colSt == true) {

				switch (hero.getDeplacementsInt()) {

				case 1: // up

					hero.setPositionY(hero.getPositionY() - 5);
					break;

				case 2: // down

					hero.setPositionY(hero.getPositionY() + 5);
					break;

				case 3: // right

					hero.setPositionX(hero.getPositionX() - 5);
					break;

				case 4: // left

					hero.setPositionX(hero.getPositionX() + 5);
					break;

				default:

					break;
				}

			}

		}

		/************* COLLISION AVEC BONUS ***************************/
		for (BlocStatue statue : listeBlocStatue) {

			statue.setRectangle(statue.getBoxStatue());
			boolean colS = hero.getRectangle().overlaps(statue.getRectangle());
			if (colS == true) {

				this.bonus.play();
				hero.setLife(5);
				statue.setPositionX(10000);
				statue.setPositionY(10000);

			}

		}

	}

	public Iterator<Bloc> iterator() {
		return listeBloc.iterator();
	}

	public BlocHero getHero() {
		// TODO Auto-generated method stub
		return hero;
	}

	public ArrayList<BlocKnight> getKnight() {

		return listeBlocKnight;
	}

	public ArrayList<BlocStatue> getArrayStatue() {

		return listeBlocStatue;
	}

	public BlocStatue getStatue() {

		return statue;
	}

	public BlocStele getStele() {
		return stele;
	}

	public void setStele(BlocStele stele) {
		this.stele = stele;
	}

	public ArrayList<BlocStele> getListeBlocStele() {
		return listeBlocStele;
	}

	public void setListeBlocStele(ArrayList<BlocStele> listeBlocStele) {
		this.listeBlocStele = listeBlocStele;
	}

}