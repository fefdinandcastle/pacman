
/* Cliente de RMI. Pide una Calculadora remota y realiza una suma con él. */

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;
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
            int[] contManz;
            int bestID;
            boolean play = true;
            System.out.println("Hola Jugador: "+userID);
            System.out.println(resultado);
            Scanner sc = new Scanner(System.in);  // Create a Scanner object
            String mov;
            while(play){
                System.out.println("Entra movimiento (up,down,right,left");
                mov = sc.nextLine();
                stub.movimientoPacman(userID, mov);
                tablero = stub.obtenerEstado();
                contManz = stub.obtenerManzanasEstado(userID);
                bestID = stub.getIDMejorJugador();
                System.out.print("Tus manzanas: "+contManz[0]+"\nManzanas en partida: "+contManz[1]+"\nManzanas de mejor jugador: "+contManz[2]);
                actualizarPantalla(tablero);
                if(contManz[1]==0){
                    if(bestID==userID){
                        System.out.println("Has ganado!");
                        play = false;
                    }else{
                        System.out.println("Has perdido");
                        play = false;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Excepcion del Cliente: " + e.toString());
            e.printStackTrace();
        }
    }
    
    public static void actualizarPantalla(char[][] t) throws IOException{
        //final String ANSI_CLS = "\u001b[2J";
        //final String ANSI_HOME = "\u001b[H";
        //System.out.print(ANSI_CLS + ANSI_HOME);
        //System.out.flush();
        //imprimirTablero(tablero.getTablero());
        System.out.print("\n");
        for(int i=0;i<Variables.sizeX;i++){
            for(int j=0;j<Variables.sizeY;j++){
                System.out.print(t[i][j]);
            }
            System.out.print("\n");
        }
        //juego.pantalla.setText(str);
    }
    
    
}
