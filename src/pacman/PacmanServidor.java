/* Objeto remoto de RMI que suma dos enteros. Implementa la interfaz Calculadora */

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class PacmanServidor implements Pacman {
    public PacmanServidor() {}

    public int suma(int a, int b) {
        System.out.println("sumando " + a + " + " + b + " ...");
        return a + b;
    }
            
    public int nuevoJugador(){
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return 1;
    }

    public void movimientoPacman(int id, ArrayList pos) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public char[][] obtenerEstado() {
        char[][] xd= new char[40][40];
        return xd;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }   


    public static void main(String args[]) {
        try {
            PacmanServidor obj = new PacmanServidor();
            Pacman stub = (Pacman) UnicastRemoteObject.exportObject(obj, 0);

            // Agrega el stud del objeto remoto al registro RMI
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Pacman", stub);
            System.err.println("PacmanServidor lista!");
        // FIN del try 
        } catch (Exception e) {
            System.err.println("PacmanServidor exception: " + e.toString());
            e.printStackTrace();
        }
    } // Fin del main

    
} // Fin de la clase

