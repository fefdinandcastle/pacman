
/* Cliente de RMI. Pide una Calculadora remota y realiza una suma con él. */

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import pacman.Juego;
import pacman.Tablero;
import pacman.Variables;

public class PacmanCliente {
    
    //static Juego juego;
            
    private PacmanCliente() {}

    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Pacman stub = (Pacman) registry.lookup("pacman");
            System.out.print("2 + 3 = ");
            int resultado = stub.suma(2, 3);
            int userID = stub.nuevoJugador();
            char[][] tablero = stub.obtenerEstado();
            System.out.println("Hola Jugador: "+userID);
            System.out.println(resultado);
            //juego = new Juego();
            //juego.setVisible(true);
            while(true){
                sleep(10);
                actualizarPantalla(tablero);
            }
        } catch (Exception e) {
            System.err.println("Excepcion del Cliente: " + e.toString());
            e.printStackTrace();
        }
    }
    
    public static void actualizarPantalla(char[][] t) throws IOException{
        System.out.print("\033[H\033[2J");
        System.out.flush();
        //imprimirTablero(tablero.getTablero());
        for(int i=0;i<Variables.sizeX;i++){
            for(int j=0;j<Variables.sizeY;j++){
                System.out.print(t[i][j]);
            }
            System.out.print("\n");
        }
        //juego.pantalla.setText(str);
    }
    
    
}
