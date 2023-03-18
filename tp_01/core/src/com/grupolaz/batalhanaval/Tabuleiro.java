package com.grupolaz.batalhanaval;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import java.awt.*;

public class Tabuleiro {
    
    private Texture txTabuleiro;
    private Texture txBombardeado;   
    
    public Tabuleiro(Texture txTabuleiro, Texture txBombardeado) {
        this.txTabuleiro = txTabuleiro;
        this.txBombardeado = txBombardeado;
    }
    
    public void draw(Batch bBatch) {
        bBatch.draw(txTabuleiro, 0, 0);
    }
}

