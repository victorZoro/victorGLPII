package com.grupolaz.logic;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private int id;
    private int size;
    private List<Tile> tiles;
    private boolean orientation;
    private boolean isPlaced;
    
    private final int SIZE_PORTA_AVIOES = 5;
    private final int SIZE_ENCOURACADO = 4;
    private final int SIZE_CRUZEIRO = 3;
    private final int SIZE_DESTROYER = 2;    

    /**
     * <h3>Construtor da classe Ship</h3>
     * 
     * @param id - id do navio.
     *             <ol>
     *              <li>Porta-Aviões.</li>
     *              <li>Encouracado.</li>
     *              <li>Cruzeiro.</li>
     *              <li>Destroyer.</li>
     *             </ol>
     */
    public Ship(int id) {
        this.id = id;
        this.tiles = new ArrayList<>();
        
        switch(this.id) {
            case 1: {
                this.size = SIZE_PORTA_AVIOES;
                break;
            }
            case 2: {
                this.size = SIZE_ENCOURACADO;
                break;
            }
            case 3: {
                this.size = SIZE_CRUZEIRO;
                break;
            }
            case 4: {
                this.size = SIZE_DESTROYER;
                break;
            }
        }
    }

    /**
     * <h3>Recebe a orientação do navio</h3>
     * 
     * @param orientation <p>- true: navio na horizontal.</p>
     *                    <p>- false: navio na vertical </p>  
     */
    public void setOrientation(boolean orientation) {
        this.orientation = orientation; 
    }

    /**
     * Configura se o navio foi ou não colocado no tabuleiro
     * 
     * @param isPlaced - recebe o estado do navio.
     */
    public void setPlace(boolean isPlaced) {
        this.isPlaced = isPlaced;
    }

    /**
     * <h3>Retorna a orientação do navio</h3>
     * 
     * @return <p>- true: navio na horizontal.</p>
     *         <p>- false: navio na vertical </p>  
     */
    public boolean getOrientation() {
        return orientation;
    }

    
    /**
     * <h3>Retorna o tamanho do navio.</h3>
     * 
     * @return  tamanho do navio.
     */
    public int getSize() {
        return size;
    }
    
    /**
     * <h3>Retorna em quais casas o navio está.</h3>
     * 
     * @return casas que o navio ocupa.
     */
    public List<Tile> getTiles() {
        return tiles;
    }
    
    /**
     * Retorna se o navio foi colocado no tabuleiro.
     * 
     * @return - true: foi colocado no tabuleiro.
     *         - false: não foi colocado no tabuleiro.
     */
    public boolean isPlaced() {
        return isPlaced;
    }

    /**
     * <h3>Adiciona o navio em uma casa.</h3
     * 
     * @param tile - Adiciona o navio em uma casa.
     */
    public void addTile(Tile tile) {
        this.tiles.add(tile);
    }


    /**
     * <h3>Retorna se o navio afundou.</h3>
     * 
     * @return <p>true: se todas as casas foram acertadas</p>
     *         <p>false: se, pelo menos, uma das casas não foi acertada.</p>
     */
    public boolean isSunk() {
        for(Tile tile : tiles) {
            if(!tile.isHit()) {
                return false;
            }
        }
        return true;
    }
}
