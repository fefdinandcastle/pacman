/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.util.Random;

/**
 *
 * @author night
 */
public class Jugador {
    Coordenadas pos = new Coordenadas();
    int manzanasComidas;

    public Jugador() {
        Random rand = new Random();
        pos.setXY(rand.nextInt(Variables.sizeX), rand.nextInt(50));
        manzanasComidas = 0;
    }

    public void setPos(Coordenadas pos) {
        this.pos = pos;
    }
    
    public Coordenadas getPos() {
        return pos;
    }

    public void setManzanasComidas(int manzanasComidas) {
        this.manzanasComidas = manzanasComidas;
    }

    public int getManzanasComidas() {
        return manzanasComidas;
    }
    
    
    
    
    
    
}
