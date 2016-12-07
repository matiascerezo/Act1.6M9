package act1.pkg6m9uf2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matias
 */
public class Ingresar implements Runnable {

    private final Random aleatorio;
    private final Cuenta cuenta;
    private final int TIEMPOESPERA = 1500;
    private static float ingreso;

    /**
     * Constructor de "Ingresar"
     * @param cuenta 
     */
    public Ingresar(Cuenta cuenta) {
        aleatorio = new Random();
        this.cuenta = cuenta;
    }
 
    /**
     * Crea un número aleatorio entre 0 y 150 que luego enviara como parámetro
     * al método "ingresar" i ingresará ese valor al saldo. Todo ello lo hace en intervalos
     * con un segundo y medio de pausa.
     */
    @Override
    public void run() {
        while (Boolean.TRUE) {
            ingreso = aleatorio.nextInt(150); // Ingresamos más de lo que retiramos
            cuenta.ingresar(ingreso);       
            try {
                Thread.sleep(TIEMPOESPERA);
            } catch (InterruptedException e) {
                Logger.getLogger(Retirar.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
