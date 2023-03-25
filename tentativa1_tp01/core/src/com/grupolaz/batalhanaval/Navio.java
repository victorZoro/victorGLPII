/**
 * @author: Anna Luisa
 * @author: Lucas Vinicios 
 * @author: Victor Gabriel
 * @version: 1.0 
*/

package com.grupolaz.batalhanaval;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class Navio {

    private Texture txNavio;
    private String sNome;
    private Rectangle rPosicao;
    private int iTipo;

    private Array<Integer> iAcertadas;
    private boolean bHorizontal;

    //Constantes
    public static final int TYPE_PORTA_AVIOES = 2;
    public static final int TYPE_ENCOURACADO = 4;
    public static final int TYPE_CRUZEIRO = 8;
    public static final int TYPE_DESTROIER = 16;

    /**
     * Define o tamanho dos barcos
     * WIDTH -> Largura
     * HEIGHT -> Altura
     * Todos os barcos tem a mesma altura.
    */
    public static final int WIDTH_PORTA_AVIOES = 64*5;
    public static final int WIDTH_ENCOURACADO = 64*4;
    public static final int WIDTH_CRUZEIRO = 64*3;
    public static final int WIDTH_DESTROIER = 64*2;
    public static final int HEIGHT = 64;

    public static final String NAME_PORTA_AVIOES = "Porta Avioes";
    public static final String NAME_ENCOURACADO = "Encouracado";
    public static final String NAME_CRUZEIRO = "Cruzeiro";
    public static final String NAME_DESTROIER = "Destroier";

    public static final Texture TEXTURE_PORTA_AVIOES = new Texture(Gdx.files.internal("barcoTamanho5.jpg"));
    public static final Texture TEXTURE_ENCOURACADO = new Texture(Gdx.files.internal(
        "barcoTamanho4.jpg"));
    public static final Texture TEXTURE_CRUZEIRO = new Texture(Gdx.files.internal("barcoTamanho3.jpg"));
    public static final Texture TEXTURE_DESTROIER = new Texture(Gdx.files.internal("barcoTamanho2.jpg"));

    public Navio(String sNome, Rectangle rPosicao, int iTipo, Texture txNavio) {
        this.sNome = sNome;
        this.rPosicao = rPosicao;
        this.iTipo = iTipo;
        this.txNavio = txNavio;
    }

    public  Navio constroiNavio(int iTipo) {
        Rectangle tamanhoNavio = new Rectangle();
        switch(iTipo) {
            case TYPE_PORTA_AVIOES: {
                reseta(tamanhoNavio);
                tamanhoNavio.width = WIDTH_PORTA_AVIOES;
                new Navio(NAME_PORTA_AVIOES, tamanhoNavio, TYPE_PORTA_AVIOES, TEXTURE_PORTA_AVIOES);
            }
            case TYPE_ENCOURACADO: {
                reseta(tamanhoNavio);
                tamanhoNavio.width = WIDTH_ENCOURACADO;
                new Navio(NAME_ENCOURACADO, tamanhoNavio, TYPE_ENCOURACADO, TEXTURE_ENCOURACADO);
            }
            case TYPE_CRUZEIRO: {
                reseta(tamanhoNavio);
                tamanhoNavio.width = WIDTH_CRUZEIRO;
                new Navio(NAME_CRUZEIRO, tamanhoNavio, TYPE_ENCOURACADO, TEXTURE_ENCOURACADO);
            }
            case TYPE_DESTROIER: {
                reseta(tamanhoNavio);
                tamanhoNavio.width = WIDTH_DESTROIER;
                new Navio(NAME_DESTROIER, tamanhoNavio, TYPE_DESTROIER, TEXTURE_DESTROIER);
            }
            default: {
                return null;
            }
        }
    }

    public void reseta(Rectangle r) {
        r.x = -1;
        r.y = -1;
        r.height = HEIGHT;
    }
}
