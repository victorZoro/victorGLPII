package com.grupolaz.logic;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class Table {

    //Tabuleiro
    Tile[][] table;

    //Contador de posições
    Point axis = new Point();

    //Dimensões do tabuleiro
    public final int LARGURA = 10;
    public final int ALTURA = 10;

    /**
     * Construtor da classe Table
     * 
     * @param ships - lista de navios a serem colocados no tabuleiro.
     */
    public Table(List<Ship> ships) {
        //Gera uma matriz
        table = new Tile[LARGURA][ALTURA];
        
        //Para cada posição da matriz, gera um novo objeto
        for(axis.x = 0; axis.x < LARGURA; axis.x += 1) {
            for(axis.y = 0; axis.y < ALTURA; axis.y += 1) {
                table[axis.x][axis.y] = new Tile(axis);
            }
        }

        //Coloca os navios aleatóriamente
        placeShips(ships);
    }

    /**
     * Retorna uma casa do tabuleiro
     * 
     * @param position - posição x e y do tabuleiro
     * @return - uma casa na posição indicada.
     */
    public Tile getTile(Point position) {
        return table[position.x][position.y];
    }

    /**
     * Retorna as casas vizinhas aos navios do tabuleiro
     * 
     * @param tile - casa onde o navio foi posicionado
     * @return - uma lista de casas vizinhas aos navios do tabuleiro
     */
    public List<Tile> getNeighbors(Tile tile) {
        List<Tile> neighbors = new ArrayList<>();
        Point position = tile.getPosition();

        for(axis.x = position.x - 1; axis.x <= position.x + 1; axis.x += 1) {
            for(axis.y = position.y - 1; axis.y <= position.y + 1; axis.y += 1) {
                if (axis.x >= 0 && axis.x < LARGURA && //Dentro do limite da matriz no eixo X
                axis.y >= 0 && axis.y < ALTURA && //Dentro do limite da matriz no eixo Y
                (axis.x != position.x || axis.y != position.y)) { //Não é a casa selecionada.
                    
                    neighbors.add(table[axis.x][axis.y]);
                }
            }
        }
        return neighbors;
    }

    /**
     * Insere os navios no tabuleiro de forma aleatória.
     * 
     * @param ships - lista de navios a serem colocados
     */
    private void placeShips(List<Ship> ships) {
        Random randomPosition = new Random();
        Point position = new Point();

        //Percorre os navios
        for(Ship ship: ships) {
            //Configura que o navio ainda não foi colocado no tabuleiro
            ship.setPlace(false);

            while(!ship.isPlaced()) {
                //Gera uma posição aleatória
                position.x = randomPosition.nextInt(LARGURA);
                position.y = randomPosition.nextInt(ALTURA);

                //Gera uma orientação aleatória
                ship.setOrientation(randomPosition.nextBoolean());

                //Casas que o navio ocupa
                List<Tile> shipTiles = new ArrayList<>();
                
                /**
                 * Set é apenas um conjunto de valores
                 * sem informações duplicadas.
                 * 
                 * É utilizado aqui para economia de
                 * memória, visto que é inútil saber
                 * que dois navios tem o mesmo vizinho.
                 * Basta que um deles tenha este vizinho
                 * para que nenhum navio seja colocado ali.
                 * 
                 * Já o HashSet é a classe que guarda estes
                 * valores, porém de forma desordenada,
                 * diferentemente da classe TreeSet, que
                 * guarda estes valores de forma ordenada,
                 * porém, é mais lenta.
                 */

                //Conjunto de casas vizinhas ao navio
                Set<Tile> neighbors = new HashSet<>();
                
                //Pergunta se esta casa está disponível
                boolean isTileAvailable = true;

                for(int i = 0; i < ship.getSize(); i++) {
                    //Posição do navio utilizada para testes.
                    Point shipPosition = new Point();

                    //Coloca o navio no tabuleiro.
                    if(ship.getOrientation()) {
                        shipPosition.x = position.x + i; //Coloca o navio na horizontal
                        shipPosition.y = position.y;
                    } else {
                        shipPosition.x = position.x; 
                        shipPosition.y = position.y + i; //Coloca o navio na vertical
                    }

                    //Testa se o barco está fora da tela
                    if(isOutOfBounds(shipPosition)) {
                        isTileAvailable = false;
                        break;
                    }
                    
                    //Configura uma casa naquela posição
                    Tile tile = table[shipPosition.x][shipPosition.y];

                    //Testa se já há um barco naquela posição
                    if(tile.isFull()) {
                        isTileAvailable = false;
                        break;
                    }

                    //Adiciona esta casa à lista de casas do navio
                    shipTiles.add(tile);
                    //Adiciona os vizinhos da casa à lista de vizinhos do navio
                    neighbors.addAll(getNeighbors(tile));
                    
                    //Testa se os vizinhos estão ocupados
                    //(isto é, confere a disponibilidade dos vizinhos)
                    for(Tile neighbor : neighbors) {
                        if(neighbor.isFull()) {
                            isTileAvailable = false;
                            break;
                        }
                    }
                }

                //Testa se a casa está disponível
                if(isTileAvailable) {
                    //Coloca os navios no tabuleiro
                    for(Tile tile : shipTiles) {
                        tile.setShip(ship);
                        ship.addTile(tile);
                    }

                    //Configura que o navio foi colocado no tabuleiro
                    ship.setPlace(true);
                }
            }
        }
    }

    /**
     * Retorna se o navio posicionado está fora da tela
     * 
     * @param position - Recebe a posição do navio.
     * @return - true: está fora da tela.
     *         - false: está dentro da tela.
     */
    public boolean isOutOfBounds(Point position) {
        if(position.x >= LARGURA || position.y >= ALTURA) {
            return true;
        }
        return false;
    }

    //Somente para o console
    public void printTable() {
        int count = 0;

        System.out.print("   ");

        for(char letter = 'A'; letter <= 'J'; letter++) {
            System.out.print(letter + "");
        }
        System.out.println();

        for(int x = 0; x < ALTURA; x++) {
            System.out.print(count + " | ");
            for(int y = 0; y < ALTURA; y++) {
                System.out.print(table[x][y] + " | ");
            }
            System.out.println();
            count++;
        }
    }
}
