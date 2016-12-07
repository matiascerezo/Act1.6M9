package act1.pkg6m9uf2;

/**
 *
 * @author Matias
 */
public class Test {

    private static Cuenta cuenta;
    private static Thread[] ingresar;
    private static Thread[] retiro;
    private static final int personasIngRet = 5;

    /**
     * Método principal
     * @param args 
     */
    public static void main(String[] args) {

        //Iniciamos la clase cuenta
        cuenta = new Cuenta();
        
        //Creamos arrays ingresar y retiro
        ingresar = new Thread[personasIngRet];
        retiro = new Thread[personasIngRet];

        //Bucle para recorrer el array e iniciar los hilos
        for (int i = 0; i < personasIngRet; i++) {
            retiro[i] = new Thread(new Retirar(cuenta));
            retiro[i].start();
        }
        for (int i = 0; i < personasIngRet; i++) {
            ingresar[i] = new Thread(new Ingresar(cuenta));
            ingresar[i].start();
        }
    }

}
