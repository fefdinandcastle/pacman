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
    private Coordenadas pos = new Coordenadas();
    private int manzanasComidas;
    private int id;

    public Jugador() {
        Random rand = new Random();
        pos.setXY(rand.nextInt(Variables.sizeX), rand.nextInt(Variables.sizeY));
        id = rand.nextInt((9999 - 1000) + 1) + 1000;
        manzanasComidas = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
