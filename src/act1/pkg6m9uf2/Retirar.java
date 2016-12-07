package act1.pkg6m9uf2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matias
 */
public class Retirar implements Runnable {

    private final Random aleatorio;
    private final Cuenta cuenta;
    private final int TIEMPOESPERA = 1500;
   
    /**
     * Constructor de "Retirar"
     * @param cuenta 
     */
    public Retirar(Cuenta cuenta) {
        this.cuenta = cuenta;
        aleatorio = new Random();
    }

    /**
     * Crea un número aleatorio entre 0 y 50 que luego enviara como parámetro
     * al método "retirar" i sacará ese valor del saldo. Todo ello lo hace en intervalos
     * con un segundo y medio de pausa. 
     */
    @Override
    public void run() {
        while (Boolean.TRUE) {         
            int retiro = aleatorio.nextInt(50); // Vamos a ser ricos gracias a esto
                                                //(El truco está en sacar menos de lo que ingresas)
            cuenta.retirar(retiro);
            try {
                Thread.sleep(TIEMPOESPERA);
            } catch (InterruptedException e) {
                Logger.getLogger(Retirar.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
