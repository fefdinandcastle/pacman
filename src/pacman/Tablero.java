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
public class Tablero {
    char[][] tablero = new char[40][40];

    public Tablero() {
        inicializarTablero();
    }

    public char[][] getTablero() {
        return tablero;
    }
    
    
    public void inicializarTablero(){
        int maxManzanas = 50;
        int manzanasCont = 0;
        boolean bool = false;
        Random rand = new Random();
        for(int i=0;i<40;i++){
            for(int j=0;j<40;j++){
                if(manzanasCont<maxManzanas){
                    bool = (rand.nextInt(30) == 0) ? true : false; //%20
                    if(bool){
                        tablero[i][j]='■';
                        manzanasCont++;
                    }else{
                        tablero[i][j]=(char)32;
                    }
                }
            }
        }
    }
    
    
    
}
