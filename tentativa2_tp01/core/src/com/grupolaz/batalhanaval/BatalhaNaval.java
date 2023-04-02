package com.grupolaz.batalhanaval;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;


public class BatalhaNaval extends Game {

	public void create () {
		setScreen(new GameScreen(this, 1));
	}
}
