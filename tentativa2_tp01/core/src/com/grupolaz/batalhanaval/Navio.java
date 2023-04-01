/**
 * @author: Anna Luisa
 * @author: Lucas Vinicios 
 * @author: Victor Gabriel
 * @version: 2.0 
 * Nesse classe foi utilizado como referencia o código "JavaBship" do usuário do Github Mark Hutcheson (meh2481). Segue abaixo o link para verificação:
 * https://github.com/meh2481/JavaBship
 * 
 * Observasse que usamos COMO REFERENCIA, portanto terá semelhanças com ele.
*/
package com.grupolaz.batalhanaval;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

// inincializando as variaveis
public class Navio {
    private Texture shipTexture; // textura navio
    private Sprite ship; // sprite navio
    private boolean sentido; // vertical ou horizontal
    Array<Integer> hitPositions; // posições acertadas
    private int posicaoX, posicaoY; // posição do barco
    private int tamanho;
    private int tipo;
    private String nome;

        // Declarando as constantes;
    /*
     * essas constantes serão usadas como parametros para indentificarmos qual barco
     * será inicializado.
     */
    public static final int PORTA_AVIOES = 1;
    public static final int ENCOURACADO = 2;
    public static final int CRUZEIRO = 3;
    public static final int DESTROIER = 4;

    public static final int SIZE_PORTA_AVIOES = 5;
    public static final int SIZE_ENCOURACADO = 4;
    public static final int SIZE_CRUZEIRO = 3;
    public static final int SIZE_DESTROIER = 2;

    public static final String NAME_PORTA_AVIOES = "PORTA-AVIOES";
    public static final String NAME_ENCOURACADO = "ENCOURACADO";
    public static final String NAME_CRUZEIRO = "CRUZEIRO";
    public static final String NAME_DESTROIER = "DESTROIER";

    public Navio(int tipo) {
        this.tipo = tipo;

        switch (tipo) {
            case 1: {
                tamanho = SIZE_PORTA_AVIOES;
                nome = NAME_PORTA_AVIOES;
                break;
            }
            case 2: {
                tamanho = SIZE_ENCOURACADO;
                nome = NAME_ENCOURACADO;
                break;
            }
            case 3: {
                tamanho = SIZE_CRUZEIRO;
                nome = NAME_CRUZEIRO;
                break;
            }
            case 4: {
                tamanho = SIZE_DESTROIER;
                nome = NAME_DESTROIER;
                break;
            }
        }
    }

    public boolean isHorizontal() {
        return sentido;
    }

    public int getSize() {
        return tamanho;
    }

    public void setPosition(int x, int y) {
        this.posicaoX = x;
        this.posicaoY = y;
    }

    public boolean isOverlapping(Navio outroNavio) {
        boolean overlap = false;

        if(this.isHorizontal() && outroNavio.isHorizontal()) { //dois barcos na horizontal
         
        } else if(!this.isHorizontal() && !outroNavio.isHorizontal()) { //dois barcos na vertical

        } else if(isHorizontal()) { //apenas este barco na horizontal

        } else { //apenas o outro barco na horizontal

        }
    }
    
}

