package com.grupolaz.logic;

import java.awt.Point;


/**
 * <h3>Classe responsável por criar as casas do tabuleiro do jogo.</h3>
 * 
 * <strong>Disclaimer:</strong>
 * <p>Toda a classe Tile é inspirada nos
 * códigos referenciados no documento oficial do trabalho e no
 * <a href="https://github.com/atilamelo/batalha_naval">trabalho feito pelo colega de turma Átila Melo</a>.</p>
 */
public class Tile {

    boolean hit;
    Ship ship; 
    Point position = new Point();

    public Tile(Point position) { 
        this.position.x = position.x;
        this.position.y = position.y;
        this.hit = false;
        this.ship = null; 
    }

    /**
     * <h3>Configura o navio naquela posição</h3
     * 
     * @param ship <p>- navio a ser posicionado.</p>
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }

    /**
     * <h3>Configura um tiro naquela casa.</h3>
     * 
     * @param hit   <p>- true: atirou. </p>
     *              <p>- false: não atirou.</p>
     */
    public void setHit(boolean hit) {
        this.hit = hit;
    }

    /**
     * Retorna qual navio ocupa a casa.
     * 
     * @return <p>navio ocupando a casa ou null caso não haja navio.</p>
     */
    public Ship getShip() {
        return ship;
    }


    /**
     * Retorna o estado atual da casa.
     * 
     * @return <ul>
     *          <li>2 - caso não tenha sido acertada e não haja navio.</li>
     *          <li>1 - caso tenha sido acertada, mas não haja navio.</li>
     *          <li>0 - caso um navio tenha sido acertado.</li>
     *         </ul>
     */
    public int getCurrentState() {
        if(ship != null && hit) {
            return 2;
        } else if(ship == null && hit) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * <h3>Retorna a posição da casa.</h3>
     * 
     * @return <p>posição da casa.</p>
     */
    public Point getPosition() {
        return position;
    }

    /**
     * <h3>Retorna se a casa tem algum navio.</h3>
     * 
     * @return <p>- true: há um navio nessa posição.</p>
     *         <p>- false: não há navio nessa posição.</p>
     */
    public boolean isFull() {
        if(ship != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * <h3>Retorna se houve um tiro.</h3>
     * 
     * @return <p>- true: houve tiro.</p>
     *         <p>- false: não houve tiro.</p>
     */
    public boolean isHit() {
        return hit;
    }

    /**
     * <h3>Retorna o tipo de navio naquele local.</h3>
     * <p>Apenas para a impressão no console.</p>
     * 
     * @return <p>- " " caso não haja um navio.</p>
     *         <p>- <i>"$ship.getSize()"</i> caso haja um navio.</p>
     */
    @Override
    public String toString() {
        if(ship == null) {
            return " ";
        } else {
            return Integer.toString(ship.getSize());
        }
    }
    
}
