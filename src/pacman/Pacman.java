import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Pacman extends Remote
{
   /* Método al que accederá el cliente.
* Se le pasan dos enteros, a y b, y devuelve la suma.
    * Lanza una excepción si hay problemas de RMI al ser
    * llamado desde el cliente. */
     
   public int suma(int a, int b) throws RemoteException;

   public int nuevoJugador() throws RemoteException;

   public void movimientoPacman(int id, ArrayList pos) throws RemoteException;

   public char[][] obtenerEstado() throws RemoteException;

}
