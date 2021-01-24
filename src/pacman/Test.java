/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import static java.lang.Thread.sleep;

/**
 *
 * @author night
 */
public class Test {
    
    static Tablero tablero = new Tablero();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
        String str="";
        Juego jg = new Juego();
        jg.pantalla.setText(str);
        jg.setVisible(true);
        nuevoJugador();
        while(true){
            sleep(2);
            str="";
            //imprimirTablero(tablero.getTablero());
            for(int i=0;i<Variables.sizeX;i++){
                for(int j=0;j<Variables.sizeY;j++){
                    str += tablero.tablero[i][j];
                }
                str += "\n";
            }
            jg.pantalla.setText(str);
        }
        
        
    }
    
    public static int nuevoJugador(){
        Jugador j = new Jugador();
        tablero.tablero[j.pos.x][j.pos.y]='v';
        //(//(char[][])tablero.getTablero())[j.pos.x][j.pos.y]='v';
        return 1;
    }
    
    public static void imprimirTablero(char[][] tablero) throws IOException{
        //System.out.print("\033[H\033[2J");
        //System.out.flush();
        String str="";
        for(int i=0;i<Variables.sizeX;i++){
            for(int j=0;j<Variables.sizeY;j++){
                str += tablero[i][j];
            }
            str += "\n";
        }
        Juego jg = new Juego();
        jg.pantalla.setText(str);
        jg.setVisible(true);
        //System.out.println("**************************************************");
        //for(int i=0;i<Variables.sizeX;i++){
        //    for(int j=0;j<Variables.sizeY;j++){
        //        System.out.print(tablero[i][j]);
        //    }
        //    System.out.print("\n");
        //}
        //System.out.println("**************************************************");
    }
    
    public static void cleanScreen(){
        for(int i = 0; i < 1000; i++)
        {
            System.out.println("\b");
        }
    }
    
    
}
