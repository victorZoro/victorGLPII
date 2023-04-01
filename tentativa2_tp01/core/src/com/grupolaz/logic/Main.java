package com.grupolaz.logic;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Ship> ships =  new ArrayList<Ship>();
        
        for (int i = 0; i < 10; i++) {
            if(i == 0){

                ships.add(new Ship(1));

            }else if( i != 0 && i <= 2){

                ships.add(new Ship(2));

            }else if(i > 2 && i <= 5){

                ships.add(new Ship(3));

            }else if(i > 5 && i < 10){
                ships.add(new Ship(4));
            }
        }

        Table table = new Table(ships);

        table.printTable();
    }
}
