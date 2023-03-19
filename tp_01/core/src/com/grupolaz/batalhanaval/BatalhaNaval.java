package com.grupolaz.batalhanaval;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;

public class BatalhaNaval extends ApplicationAdapter {
	private SpriteBatch bBatch;
	private OrthographicCamera cCamera;
	Vector3 vMousePosition;

	public static final Texture TEXTURE_TABULEIRO = new Texture(Gdx.files.internal("tabuleiro.png"));
	
	@Override
	public void create() {

		bBatch = new SpriteBatch();
		cCamera.setToOrtho(false, 640, 640); 
		cCamera = new OrthographicCamera();

	}

	public void pegaMouse() {
		Gdx.input.setInputProcessor(new InputAdapter()  {
			
			@Override
			public boolean touchDown(int iScreenX, int iScreenY, int iPointer, int iButton){

				vMousePosition.set(Gdx.input.getX(), Gdx.input.getY(), 0);
				cCamera.unproject(vMousePosition);

				float x = vMousePosition.x;
				float y = vMousePosition.y;

				for(Rectangle rCasa: Tabuleiro.rCasas) {
					if(rCasa.contains(x, y)) {
						//Faz algo aqui com o clique
						break;
					}
				}
				return super.touchDown(iScreenX, iScreenY, iPointer, iButton);
			}
		});
	}

	@Override
	public void render() {

		ScreenUtils.clear(0,0,0,0);

		cCamera.update();

		bBatch.setProjectionMatrix(cCamera.combined);

		bBatch.begin();
		bBatch.draw(TEXTURE_TABULEIRO, 0, 0); 
	}

	@Override
	public void dispose() {

	}
}
