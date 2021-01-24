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
    private char[][] tablero = new char[Variables.sizeX][Variables.sizeY];
    private int manzanasCont;

    public Tablero() {
        manzanasCont=0;
        inicializarTablero();   
    }

    public char[][] getTablero() {
        return tablero;
    }
    
    public void reducirManzana(){
        manzanasCont--;
    }
    
    public int getManzanas(){
        return manzanasCont;
    }
    
    
    public void inicializarTablero(){
        int maxManzanas = Variables.manzanasCount;
        manzanasCont = 0;
        boolean bool = false;
        Random rand = new Random();
        for(int i=0;i<Variables.sizeX;i++){
            for(int j=0;j<Variables.sizeY;j++){
                if(manzanasCont<maxManzanas){
                    bool = (rand.nextInt(40) == 0) ? true : false; //%20
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
