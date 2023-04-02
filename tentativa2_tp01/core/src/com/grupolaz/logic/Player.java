package com.grupolaz.logic;

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
     * @param maxScore <p>p>- Pontuação máxima do jogad</p>or
     */
    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    /**
     * <h3>Configura o nome do jogador.</h3>
     * 
     * @param name <p>- Nome do jogador</p>
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <h3>Configura o estado do jogador</h3>
     * 
     * @param isWinner <p>- Estado do jogador.</p>
     */
    public void setState(boolean isWinner) {
        this.isWinner = isWinner;
    }

    /**
     * <h3>Retorna a quantidade de bombas que o jogador possui.</h3>
     * 
     * @return <p>- quantidade de bombas</p>
     */
    public int getBombCount() {
        return bombCount;
    }

    /**
     * <p>Retorna a pontuação do jogador</p>
     * 
     * @return <p>- pontuação atual do jogador</p>
     */
    public int getScore() {
        return currentScore;
    }

    /**
     * <h3>Retorna a pontuação máxima do jogador</h3>
     * 
     * @return <p>- pontuação máxima do jogador</p>
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
     * <h3>Testa se ainda há bombas para o jogador</h3>
     * 
     * @return <p>- true: ainda possui bombas.</p>
     *         <p>- false: não possui mais bombas.</p>
     */
    public boolean isThereBomb() {
        if(bombCount != 0) {
            return true;
        }
        return false;
    }

    /**
     * <h3>Retorna o estado do jogador</h3>
     * 
     * @return <p>- true: jogador venceu!</p>
     *         <p>- false: jogador perdeu!</p>
     */
    public boolean isWinner() {
        return isWinner;
    }

    /**
     * <h3>Diminui a quantidade de bombas que o jogador possui</h3>
     * 
     */
    public void strike() {
        bombCount--;
    }

}
