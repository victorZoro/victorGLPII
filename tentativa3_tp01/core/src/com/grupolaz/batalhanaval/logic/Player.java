package com.grupolaz.batalhanaval.logic;

public class Player {

    private int bombCount;
    private int currentScore;
    private int maxScore; //Talvez deletar
    private String name = new String();
    private boolean isWinner;
    /**
     * <h3>Construtor da classe Player.</h3>
     * 
     * @param bombCount <p>- Quantidade de bombas</p>
     */
    public Player(int bombCount) {
        this.bombCount = bombCount;
        this.currentScore = 0;
    }

    /**
     * <h3> Configura a pontuação do jogador</h3>
     * 
     * @param score <p>- Pontuação atual do jogador</p>
     */
    public void addScore(int score) {
        this.currentScore += score;
    }

    /**
     * <h3>Configura a pontuação máxima do jogador</h3>
     * 
     * @param maxScore <- Pontuação máxima do jogador
     */
    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    /**
     * Configura o nome do jogador.
     * 
     * @param name - Nome do jogador
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Configura o estado do jogador
     * 
     * @param isWinner - Estado do jogador.
     */
    public void setState(boolean isWinner) {
        this.isWinner = isWinner;
    } 

    /**
     * Retorna a quantidade de bombas que o jogador possui.
     * 
     * @return - quantidade de bombas
     */
    public int getBombCount() {
        return bombCount;
    }

    /**
     * Retorna a pontuação do jogador
     * 
     * @return - pontuação atual do jogador
     */
    public int getScore() {
        return currentScore;
    }

    /**
     * Retorna a pontuação máxima do jogador
     * 
     * @return - pontuação máxima do jogador
     */
    public int getMaxScore() {
        return maxScore;
    }

    /**
     * Retorna o nome do jogador
     * 
     * @return - nome do jogador
     */
    public String getName() {
        return name;
    }
    
    /**
     * Testa se ainda há bombas para o jogador
     * 
     * @return - true: ainda possui bombas.
     *         - false: não possui mais bombas.
     */
    public boolean isThereBomb() {
        if(bombCount != 0) {
            return true;
        }
        return false;
    }

    /**
     * Retorna o estado do jogador
     * 
     * @return - true: jogador venceu!
     *         - false: jogador perdeu!
     */
    public boolean isWinner() {
        return isWinner;
    }

    /**
     * Diminui a quantidade de bombas que o jogador possui
     * 
     */
    public void strike() {
        bombCount--;
    }

}
