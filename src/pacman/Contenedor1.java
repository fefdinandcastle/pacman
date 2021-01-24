/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

/**
 *
 * @author night
 */
public class Contenedor1 {
    Jugador j;
    Tablero t;

    public Contenedor1() {
    }

    public Contenedor1(Jugador j,Tablero t){
        this.j=j;
        this.t=t;
    }

    public Jugador getJ() {
        return j;
    }

    public void setJ(Jugador j) {
        this.j = j;
    }

    public Tablero getT() {
        return t;
    }

    public void setT(Tablero t) {
        this.t = t;
    } 
}
