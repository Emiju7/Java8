
/**
 *
 * @author Emilio Luis Pareja Hinojosa
 */

public class EstructurasRepeticion {

    public static void main(String[] args) {

        boolean condicion = true;

        int valor;

        for (int i = 0; i <= 10; i++) {
            valor = i;
            System.out.println(valor);
        }

        //mismo bucle//
        for (int i = 0; condicion; i++) {
            valor = i;
            condicion = valor != 10;
            System.out.println(valor);
        }

        valor = 0;
        while (condicion) {

            condicion = valor != 10;
            System.out.println(valor);
            valor++;
        }

        valor = 0;
        do {

            condicion = valor != 10;
            System.out.println(valor);
            valor++;
        } while (condicion);

    }

}
