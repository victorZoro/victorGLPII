package com.grupolaz.batalhanaval;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.InputAdapter;

public class BatalhaNaval extends ApplicationAdapter {
	private SpriteBatch bBatch;
	private OrthographicCamera cCamera;
	Vector3 vMousePosition;
	ShapeRenderer sForma;

	public Texture txTabuleiro;

	public Tabuleiro tTabuleiro;

	@Override
	public void create() {

		txTabuleiro = new Texture(Gdx.files.internal("tabuleiro.png"));

		tTabuleiro = new Tabuleiro();

		sForma = new ShapeRenderer();

		tTabuleiro.criaTabuleiro();

		bBatch = new SpriteBatch();
		cCamera.setToOrtho(false, 640, 640);
		cCamera = new OrthographicCamera();

		vMousePosition = new Vector3(0,0,0);

		pegaMouse();
	}

	public void pegaMouse() {
		Gdx.input.setInputProcessor(new InputAdapter() {

			@Override
			public boolean touchDown(int iScreenX, int iScreenY, int iPointer, int iButton) {

				vMousePosition.set(Gdx.input.getX(), Gdx.input.getY(), 0);
				cCamera.unproject(vMousePosition);

				float x = vMousePosition.x;
				float y = vMousePosition.y;

				for (Rectangle rCasa : Tabuleiro.rCasas) {
					if (rCasa.contains(x, y)) {
						// Faz algo aqui com o clique
						break;
					}
				}
				return super.touchDown(iScreenX, iScreenY, iPointer, iButton);
			}
		});
	}

	@Override
	public void render() {

		ScreenUtils.clear(0, 0, 0, 0);

		cCamera.update();

		bBatch.setProjectionMatrix(cCamera.combined);

		tTabuleiro.desenhaTabuleiro(bBatch, cCamera, sForma, vMousePosition);

		bBatch.begin();
		bBatch.draw(txTabuleiro, 0, 0);
		bBatch.end();
	}

	@Override
	public void dispose() {

	}
}
