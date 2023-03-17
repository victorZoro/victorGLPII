/**
 * @author: Anna Luisa
 * @author: Lucas Vinicios 
 * @author: Victor Gabriel
 * @version: 1.0 
*/

package com.grupolaz.batalhanaval;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;

/**
 * Classes abstratas são classes que apenas as classes
 * filhas conseguem acessar. Não há uma forma de
 * acessar classes abstratas como classes comuns.
 * 
 * Métodos abstratos são exatamente como interfaces.
 * Ela não tem corpo e é definida pelo filho da
 * classe pai.
 */

abstract class Navio {

    private Sprite sNavioAcertado;
    private Sprite sNavioOk;
    private boolean bHorizontal;
    private int iPosX, iPosY;
    private Array<Integer> iPosAcertadas;

    public final int TYPE_CARRIER = 1;
    public final int TYPE_BATTLESHIP = 2;
    public final int TYPE_CRUISER = 3;
    public final int TYPE_DESTROYER = 4;

    public final String NAME_CARRIER = "Porta-Avioes";
    public final String NAME_BATTLESHIP = "Encouracado";
    public final String NAME_CRUISER = "Cruzeiro";
    public final String NAME_DESTROYER = "Destroyer"; // Chamado tambem de contratorpedeiro

    abstract public String getNome();
    abstract public int getTamanho();
    abstract public int getTipo();
    
    public Navio(Sprite sNavioAcertado, Sprite sNavioOk) {
        this.sNavioAcertado = sNavioAcertado;
        this.sNavioOk = sNavioOk;
        reset(); // Valores padronizados
    }
    
    private void reset() {
        iPosX = -1;
        iPosY = -1;
        iPosAcertadas = new Array<Integer>();
    }

    public boolean atiraNoBarco(int iPosX, int iYPos){
        
    } 
}
