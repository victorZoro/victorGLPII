package com.grupolaz.batalhanaval;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.Gdx;

/**
 * Classe que inicializa e renderiza o tabuleiro na tela.
 */

public class Table {

    //Constantes
    private static final int TABLE_SIZE = 10; //Tabuleiro 10x10
    private static final int TILE_SIZE = 64; //Cada casa tem 64x64 pixels
    
    private Texture texture; //Cria textura do tabuleiro =)
    private Sprite table; //Cria sprite do tabuleiro ;)
    
    private Array<Rectangle> tiles; //Casas do tabuleiro

    /**
     * Inicializa o tabuleiro e suas casas
     * 
     */
    public void createTable() {
        texture = new Texture(Gdx.files.internal("table/tabuleiro.png")); //inicializa a textura do tabuleiro;

        table = new Sprite(texture, texture.getWidth(), texture.getHeight()); // inicializa o sprite do tabuleiro;
        table.setPosition(0, 0); //Configura a posição inicial do Sprite do tabuleiro(x:0 | y:0);

        tiles = new Array<Rectangle>(); //Inicializa o array de casas
        
        //Define matriz 10x10 de retângulos
        for(int linha = 0; linha < TABLE_SIZE; linha++) { 
            for(int coluna = 0; coluna < TABLE_SIZE; coluna++) {
                tiles.add(new Rectangle(linha * TILE_SIZE, coluna * TILE_SIZE, TILE_SIZE, TILE_SIZE)); //Adiciona novo retângulo. Rectangle(x,y,width,height)
            }
        }
    }
    
    /**
     * Desenha tabuleiro na tela. Não possui batch.begin(), pois será utilizada dentro do arquivo BatalhaNaval.java.
     * 
     * @param batch - Recebe o lote de sprites do arquivo principal BatalhaNaval.java.
     */
    public void drawTable(SpriteBatch batch) {
        batch.draw(table, table.getX(), table.getY());  //desenha a textura tabulerio nas posiçoes getX e getY;      
    }

    /**
     * Renderiza um retângulo de outra cor por cima da casa que o mouse se encontra.
     * 
     * @param square - Forma a ser renderizada dentro do arquivo BatalhaNaval.java.
     * @param camera - Camera utilizada dentro do arquivo BatalhaNaval.java.
     * @param x - Posição x do mouse.
     * @param y - Posição y do mouse.
     */
    public void tableHover(ShapeRenderer square, OrthographicCamera camera, int x, int y) {
        for(Rectangle tile: tiles) {
            square.setProjectionMatrix(camera.combined); //Configura a posição da forma para 0,0
            
            if(tile.contains(x, y)) {
                square.begin(ShapeType.Filled); //Inicializa a forma como preenchida
                square.setColor(Color.WHITE); //Configura a cor como Branco
                square.rect(tile.x, tile.y, tile.width, tile.height); //Configura o tamanho (uma casa)
            } else {
                square.begin(ShapeType.Line); //Inicializa a forma como traçado
                square.setColor(Color.BLACK); //Configura a cor como Preto
                square.rect(tile.x, tile.y, tile.width, tile.height); //Configura o tamanho (uma casa)
            }
            square.end(); //Finaliza a forma
        }
    }


    /**
     * Dá acesso das casas do tabuleiro para outras classes
     * 
     * @return - Retorna o array de casas
     */
    public Array<Rectangle> getTiles() { 
        return tiles;
    }
    

    public void tableDispose() {
        texture.dispose();
    }

}
