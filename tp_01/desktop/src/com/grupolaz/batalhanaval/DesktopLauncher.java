package com.grupolaz.batalhanaval;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.grupolaz.batalhanaval.BatalhaNaval;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Batalha Naval");
		config.setWindowedMode(640, 640);
		config.useVsync(true);
		new Lwjgl3Application(new BatalhaNaval(), config);
	}
}
