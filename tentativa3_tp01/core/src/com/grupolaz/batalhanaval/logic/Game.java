package com.grupolaz.batalhanaval.logic;
import java.util.List;

public class Game {
    private Board table;
    private List<Ship> ships;
    private Player player;
    private int scoreDefaultValue;
    private int scoreMultiplier;
    private int temporaryScore;

    /**
     * <h3> Construtor da classe Logic.</h3>
     * 
     * @param ships <p>- lista de navios.</p>
     * @param difficulty <p>- configura a dificuldade do jogo (quantas bombas o jogador tem).</p>
     */
    public Game(List<Ship> ships, int difficulty) {
        this.table = new Board(ships);
        this.ships = ships;
        this.scoreDefaultValue = 10;
        this.scoreMultiplier = 1;
        this.temporaryScore = 0;

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
     * <h3> Retorna o multiplicador de pontuação.</h3>
     * 
     * @return <p> - multiplicador. </p>
     */
    public int getMultiplier() {
        return scoreMultiplier;
    }

    /**
     * <h3> Retorna o tabuleiro.</h3>
     * 
     * @return <p> - tabuleiro do jogo. </p>
     */    
    public Board getTable() {
        return table;
    }
    
    /**
     * <h3>Retorna a lista de navios.</h3>
     * 
     * @return <p>- lista de navios.</p>
     */
    public List<Ship> getShips() {
        return ships;
    }

    /**
     * <h3>Retorna a quantidade de bombas do jogador.</h3>
     * 
     * @return <p>- quantidade de bombas do jogador.</p>
     */
    public int getBombCount() {
        return player.getBombCount();
    }

    /**
     * <h3>Permite que o jogador jogue um torpedo caso ainda hajam bombas.</h3>
     */
    public void strike() {
        if(player.getBombCount() != 0) {
            player.strike();
        }
    }

    /**
     * <h3>Aumenta o multiplicador de pontuação.</h3>
     */
    public void increaseMultiplier() {
        scoreMultiplier++;
    }

    /**
     * <h3>Aumenta os pontos ganhos.</h3>
     */
    public void increaseScore() {
        temporaryScore += scoreDefaultValue;
    }

    /**
     * <h3>Reseta o multiplicador de pontuação.</h3>
     */
    public void resetMultiplier() {
        scoreMultiplier = 1;
    }

    /**
     * <h3>Reseta a pontuação temporária.</h3>
     */
    public void resetTempScore() {
        temporaryScore = 0;
    }

    /**
     * <h3>Configura a pontuação atual do jogador.</h3>
     * 
     * @param scoreMultiplier
     */
    public void addScore(int scoreMultiplier) {
        player.addScore(temporaryScore * scoreMultiplier);
        resetTempScore();
    }

    /**
     * <h3>Confere se todos os navios foram afundados.</h3>
     * 
     * @return <p>- true: todos os navios foram afundados.</p>
     *         <p>- false: ainda há navios no tabuleiro</p>
     */
    public boolean hasShip() {
        for(Ship ship : ships) {
            if(!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }

    /**
     * <h3>Confere se o jogo acabou.</h3>
     * 
     * @return <p>- true: o jogo acabou.</p>
     *         <p>- false: o jogo não acabou.</p>
     */
    public boolean isGameOver() {
        if(player.getBombCount() == 0) {
            player.setState(!hasShip() ? false : true);
            return true;
        }

        if(!hasShip()) {
            return false;
        }

        player.setState(true);
        return true;
    }

    /**
     * <h3>Retorna se o jogador venceu</h3>
     * 
     * @return <p>- true: jogador venceu!</p>
     *         <p>- false: jogador perdeu!</p
     */
    public boolean isWinner() {
        return player.isWinner();
    }

    /**
     * <h3>Converte as bombas restantes em pontos para o jogador.</h3>
     */
    public void bombsToScore() {
        while(player.getBombCount() > 0) {
            player.addScore(scoreDefaultValue / 2);
            player.strike();
        }
    }

}
