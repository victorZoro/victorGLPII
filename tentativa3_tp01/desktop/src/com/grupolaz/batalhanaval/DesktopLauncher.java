package com.grupolaz.batalhanaval;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.grupolaz.batalhanaval.BatalhaNaval;

/**
 * Código do Jogo Batalha Naval
 * Trabalho Prático de No. 1 de LP II (Linguagens e Técnicas de Programação II)
 * Centro Federal de Ensino Tecnológico de Minas Gerais Campus Contagem
 * Turma: INFORMÁTICA 3 (2023)
 * @author: Anna Luisa Andrade da Silva
 * @author: Lucas Vinicios Santos da Cruz
 * @author: Victor Gabriel Ribeiro Mariano
 * @version: 1.3.0
 */

public class DesktopLauncher {
	public static void main(String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

		config.setForegroundFPS(60);
		config.setTitle("Batalha Naval");
		config.setWindowSizeLimits(800, 600, 9999, 9999);

		new Lwjgl3Application(new BatalhaNaval(), config);
	}
}
