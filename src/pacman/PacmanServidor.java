/* Objeto remoto de RMI que suma dos enteros. Implementa la interfaz Calculadora */

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import pacman.Coordenadas;
import pacman.Jugador;
import pacman.Tablero;
import pacman.Variables;

public class PacmanServidor implements Pacman {
    static Tablero tablero;
    ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    public PacmanServidor() {}

    public int suma(int a, int b) {
        System.out.println("sumando " + a + " + " + b + " ...");
        return a + b;
    }
            
    public int nuevoJugador(){
        Jugador jugador = new Jugador();
        jugadores.add(jugador);
        agregarJugadorATablero(jugador);
        return jugador.getId();
    }
    
    public int[] obtenerManzanasEstado(int id){
        int n[] = new int[3];
        for(int i=0;i<jugadores.size();i++){
            if(jugadores.get(i).getId()==id){
                n[0]=jugadores.get(i).getManzanasComidas();
            }
        }    
        n[1] =  tablero.getManzanas();
        n[2] = getMaxManzanasJugador();
        return n;
    }
    
    private int getMaxManzanasJugador(){
        int mayor = -1;
        for(int i=0;i<jugadores.size();i++){
            if(mayor==-1){
                mayor = jugadores.get(i).getManzanasComidas();
            }else{
                if(jugadores.get(i).getManzanasComidas()>mayor){
                    mayor = jugadores.get(i).getManzanasComidas();
                }
            }
        }   
        return mayor;
    } 

    public void movimientoPacman(int id, String mov) {
        Jugador tmp = null;
        int posx=0;
        int posy=0;
        for(int i=0;i<jugadores.size();i++){
            if(jugadores.get(i).getId()==id){
                tmp = jugadores.get(i); 
            }
        }
        posx = tmp.getPos().getX();
        posy = tmp.getPos().getY();
        if(mov.equals("up")){
            if(tablero.getTablero()[posx-1][posy]=='■'){
                tmp.addManzanasComidas();  
                tablero.reducirManzana();
            }
            tablero.getTablero()[posx][posy]=(char)32;
            tablero.getTablero()[posx-1][posy]='V';
            Coordenadas cords = new Coordenadas();
            cords.setXY(posx-1, posy);
            tmp.setPos(cords);
        }else if(mov.equals("down")){
            if(tablero.getTablero()[posx+1][posy]=='■'){
                tmp.addManzanasComidas();  
                tablero.reducirManzana();
            }
            tablero.getTablero()[posx][posy]=(char)32;
            tablero.getTablero()[posx+1][posy]='V';
            Coordenadas cords = new Coordenadas();
            cords.setXY(posx+1, posy);
            tmp.setPos(cords);
        }else if(mov.equals("right")){
            if(tablero.getTablero()[posx][posy+1]=='■'){
                tmp.addManzanasComidas();  
                tablero.reducirManzana();
            }
            tablero.getTablero()[posx][posy]=(char)32;
            tablero.getTablero()[posx][posy+1]='V';
            Coordenadas cords = new Coordenadas();
            cords.setXY(posx, posy+1);
            tmp.setPos(cords);
        }else if(mov.equals("left")){
            if(tablero.getTablero()[posx][posy-1]=='■'){
                tmp.addManzanasComidas();  
                tablero.reducirManzana();
            }
            tablero.getTablero()[posx][posy]=(char)32;
            tablero.getTablero()[posx][posy-1]='V';
            Coordenadas cords = new Coordenadas();
            cords.setXY(posx, posy-1);
            tmp.setPos(cords);
        }
    }
    
    public int getIDMejorJugador(){
        int mayor = -1;
        int id=0;
        for(int i=0;i<jugadores.size();i++){
            if(mayor==-1){
                mayor = jugadores.get(i).getManzanasComidas();
                id=jugadores.get(i).getId();
            }else{
                if(jugadores.get(i).getManzanasComidas()>mayor){
                    mayor = jugadores.get(i).getManzanasComidas();
                    id=jugadores.get(i).getId();
                }
            }
        }   
        return id;
    }

    public char[][] obtenerEstado() {
        return tablero.getTablero();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }   


    public static void main(String args[]) {
        try {
            PacmanServidor obj = new PacmanServidor();
            Pacman stub = (Pacman) UnicastRemoteObject.exportObject(obj, 0);
            tablero = new Tablero();
            // Agrega el stud del objeto remoto al registro RMI
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("pacman", stub);
            System.err.println("PacmanServidor lista!");
        // FIN del try 
        } catch (Exception e) {
            System.err.println("PacmanServidor exception: " + e.toString());
            e.printStackTrace();
        }
    } // Fin del main
    
    public void agregarJugadorATablero(Jugador jugador){
        tablero.getTablero()[jugador.getPos().getX()][jugador.getPos().getY()] = 'V';
    }
    
   

    
} // Fin de la clase

