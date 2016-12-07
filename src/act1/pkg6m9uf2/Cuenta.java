package act1.pkg6m9uf2;

/**
 *
 * @author Matias
 */
public class Cuenta {

    private static float saldo = 2000;
    private boolean entrar = Boolean.FALSE;

    public static float getSaldo() {
        return saldo;
    }

    /**
     * Método para retirar dinero. Mientras el dinero a retirar menos el que tenemos sea menor a 0,
     * es decir, que intentemos sacar más de lo que tengamos, mostrará un mensaje de error. 
     * Pausamos los hilos con "wait()" y hacemos las operaciones de retiro, mostrando por pantalla la operacion
     * Una vez se haya realizado la operación de retiro, se notifica a los demás objetos con el "notifyAll()".
     * Muestra por pantalla la operación junto al saldo actual en ese momento.
     *
     * @param dineroRetirar
     */
    public synchronized void retirar(float dineroRetirar) {
        while (entrar || (this.saldo - dineroRetirar) < 0) {
            try {
                if (this.saldo - dineroRetirar < 0) {
                    System.out.println("No se puede retirar: " + dineroRetirar + " €" + ", tiene que ingresar antes de retirar esa cantidad.");
                }
                wait();
            } catch (InterruptedException ex) {
                System.err.println("Error en retiro -> " + ex.getMessage());
            }
        }
        entrar = !entrar;
        this.saldo -= dineroRetirar;
        System.out.println("Retiro: - " + dineroRetirar + " €" + "------->  saldo actual: " + getSaldo() + " €");
        entrar = !entrar;
        notifyAll();
    }

    /**
     * Hace la misma funcionalidad que el método "retirar", la única diferencia es que en vez
     * de retirar dinero, este método lo ingresa. Por todo lo demás realiza lo mismo, pausa los hilos
     * realiza las operaciones de ingreso y notifica a los objetos, reanudando los hilos.
     * Muestra por pantalla la operación junto al saldo actual en ese momento.
     *
     * @param dineroIngreso
     */
    public synchronized void ingresar(float dineroIngreso) {
        while (entrar) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.err.println("Error en ingreso -> " + ex.getMessage());
            }

        }
        entrar = !entrar;
        this.saldo += dineroIngreso;
        System.out.println("Ingreso: + " + dineroIngreso + " €" + "------->  saldo actual: " + getSaldo() + " €");
        entrar = !entrar;
        notifyAll();
    }
}
