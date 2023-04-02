package com.grupolaz.logic;
import java.util.List;

public class Game {
    private Table table;
    private List<Ship> ships;
    private Player player;
    private int scoreDefaultValue;
    private int scoreMultiplier;

    /**
     * Construtor da classe Game.
     * 
     * @param ships - lista de navios.
     * @param difficulty - configura a dificuldade do jogo (quantas bombas o jogador tem).
     */
    public Game(List<Ship> ships, int difficulty) {
        this.table = new Table(ships);
        this.ships = ships;
        this.scoreDefaultValue = 10;
        this.scoreMultiplier = 1;

        //Configura a dificuldade (quantidade de bombas e pontos obtidos)
        switch(difficulty) {
            case 1: { //Fácil
                player = new Player(100);
                                        //1x pontos
                break;
            }
            case 2: { //Médio
                player = new Player(75);
                scoreDefaultValue *= 2; //2x pontos
                break;
            }
            case 3: { //Difícil
                player = new Player(50);
                scoreDefaultValue *= 3; //3x pontos
                break;
            }
            case 4: { //Hardcore
                player = new Player(35);
                scoreDefaultValue *= 5; //5x pontos
                break;
            }
        }
    }

    /**
     * Retorna o multiplicador de pontuação.
     * 
     * @return - multiplicador.
     */
    public int getMultiplier() {
        return scoreMultiplier;
    }

    /**
     * Retorna o tabuleiro.
     * 
     * @return - tabuleiro do jogo.
     */    
    public Table getTable() {
        return table;
    }
    
    /**
     * Retorna a lista de navios.
     * 
     * @return - lista de navios.
     */
    public List<Ship> getShips() {
        return ships;
    }

    /**
     * Retorna a quantidade de bombas do jogador.
     * 
     * @return - quantidade de bombas do jogador.
     */
    public int getBombCount() {
        return player.getBombCount();
    }

    /**
     * Permite que o jogador jogue um torpedo caso ainda hajam bombas.
     */
    public void strike() {
        if(player.getBombCount() != 0) {
            player.strike();
        }
    }

    /**
     * Aumenta o multiplicador de pontuação.
     */
    public void increaseMultiplier() {
        scoreMultiplier++;
    }

    /**
     * Reseta o multiplicador de pontuação.
     */
    public void resetMultiplier() {
        scoreMultiplier = 1;
    }

    /**
     * Configura a pontuação atual do jogador.
     * @param scoreMultiplier
     */
    public void addScore(int scoreMultiplier) {
        player.addScore(scoreDefaultValue * scoreMultiplier);
    }

    /**
     * Confere se todos os navios foram afundados.
     * 
     * @return - true: todos os navios foram afundados.
     *         - false: ainda há navios no tabuleiro
     */
    public boolean allShipsSunk() {
        for(Ship ship : ships) {
            if(!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Confere se o jogo acabou.
     * 
     * @return - true: o jogo acabou.
     *         - false: o jogo não acabou.
     */
    public boolean isGameOver() {
        if(player.getBombCount() == 0) {
            player.setState(!allShipsSunk() ? false : true);
            return true;
        }

        if(!allShipsSunk()) {
            return false;
        }

        player.setState(true);
        return true;
    }

    /**
     * Retorna se o jogador venceu
     * 
     * @return - true: jogador venceu!
     *         - false: jogador perdeu!
     */
    public boolean isWinner() {
        return player.isWinner();
    }

    /**
     * Converte as bombas restantes em pontos para o jogador.
     */
    public void bombsToScore() {
        while(player.getBombCount() > 0) {
            player.addScore(scoreDefaultValue / 2);
            player.strike();
        }
    }

}
