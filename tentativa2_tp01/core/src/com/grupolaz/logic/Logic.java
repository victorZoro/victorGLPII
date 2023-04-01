package com.grupolaz.logic;

import java.util.List;

public class Logic {
    private Table table;
    private List<Ship> ships;

    public boolean isGameOver() {
        for (Ship ship : ships) {
            if(!ship.isSunk()) {
                return false;
            }
        }

        return true;
    }

    public Table getTable() {
        return table;
    }

    public List<Ship> getShips() {
        return ships;
    }
    
}
