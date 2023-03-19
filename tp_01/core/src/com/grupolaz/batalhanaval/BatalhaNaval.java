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

public class BatalhaNaval extends ApplicationAdapter {
	private SpriteBatch bBatch;
	private OrthographicCamera cCamera;
	Vector3 vMousePosition;

	@Override
	public void create() {

	}

	public void pegaMouse() {
		@Override
		Gdx.input.setInputProcessor(new InputAdapter()  {
			public boolean touchDown(int screenX, int screenY, int pointer, int button){
				mouse_position.set(Gdx.input.get(),Gdx)
			}
		});
	}

	@Override
	public void render() {

	}

	@Override
	public void dispose() {

	}
}
