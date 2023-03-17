package com.grupolaz.batalhanaval;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Array;
import com.grupolaz.batalhanaval.Ship;

public class BatalhaNaval extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture tableImage;
	private OrthographicCamera camera;
	private Rectangle table;
	private Array<Rectangle> tiles;
	
	@Override
	public void create () {
		//load table image
		tableImage = new Texture(Gdx.files.internal("tabuleiro.png"));
		


		//load camera and batch
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 640, 640);
		batch = new SpriteBatch();

		createTable();
		createTiles();
	}

	private void createTable() {
		table = new Rectangle();

		table.x = 0;
		table.y = 0;
		
		table.width = 640;
		table.height = 640;
	}

	private void createTiles() {
		for (int i = 0; i < 100; i++) {
			tiles = new Array<Rectangle>();
		}
	}

	@Override
	public void render () {

		//Fundo rosa choque bem cheguei para representar a Barbie =)
		ScreenUtils.clear(0.25f,0.01f,0.19f,1);

		camera.update();
	}
	
	@Override
	public void dispose () {

	}
}
