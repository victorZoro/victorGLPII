package com.grupolaz.batalhanaval;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Tabuleiro {

    public static Array<Rectangle> rCasas;

    public static final int SIZE_TABULEIRO = 10; //tabuleiro 10x10
    public static final int SIDE_CASA = 64; //cada casa tem 64x64 pixels
    private static final Color ALPHA_WHITE = new Color(1, 1, 1, 0.6f);

    public Tabuleiro() {

        criaTabuleiro();

    }

    public void criaTabuleiro() {
        rCasas = new Array<Rectangle>();
        for(int linha = 0; linha < SIZE_TABULEIRO; linha++) {
            for(int coluna = 0; coluna < SIZE_TABULEIRO; coluna++) {
                rCasas.add(new Rectangle(linha * SIDE_CASA, coluna * SIDE_CASA, SIDE_CASA, SIDE_CASA)); // Rectangle recebe x, y, width, height.
            }
        }
    }

    public void desenhaTabuleiro(SpriteBatch bBatch, OrthographicCamera cCamera, ShapeRenderer sForma, Vector3 vMousePosition) {

        vMousePosition.set(Gdx.input.getX(), Gdx.input.getY(), 0);
        cCamera.unproject(vMousePosition);

        float x = vMousePosition.x;
        float y = vMousePosition.y;

        for(Rectangle rCasa: rCasas) {
            sForma.setProjectionMatrix(cCamera.combined);

            if(rCasa.contains(x, y)) {
                sForma.setColor(Color.BLACK);
                sForma.begin(ShapeType.Filled);
                sForma.rect(rCasa.x, rCasa.y, SIDE_CASA, SIDE_CASA);
            } else {
                sForma.setColor(ALPHA_WHITE);
                sForma.begin(ShapeType.Line);
                sForma.rect(rCasa.x, rCasa.y, SIDE_CASA, SIDE_CASA);
            }

            sForma.end();
        }
        
    }
}

