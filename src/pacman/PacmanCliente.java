
/* Cliente de RMI. Pide una Calculadora remota y realiza una suma con él. */

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class PacmanCliente {
    private PacmanCliente() {}

    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Pacman stub = (Pacman) registry.lookup("pacman");
            System.out.print("2 + 3 = ");
            int resultado = stub.suma(2, 3);
            System.out.println(resultado);
        } catch (Exception e) {
            System.err.println("Excepcion del Cliente: " + e.toString());
            e.printStackTrace();
        }
    }
    
    
}
