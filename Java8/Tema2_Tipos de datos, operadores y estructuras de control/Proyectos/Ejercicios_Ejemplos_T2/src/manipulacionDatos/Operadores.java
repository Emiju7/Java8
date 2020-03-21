package manipulacionDatos;

/**
 *
 * @author Emilio Luis Pareja Hinojosa
 */
public class Operadores {

    public static void main(String[] args) {

        int num1 = 4, num2 = 2, num3 = 0;
        int resultado;

        System.out.println("Suma: " + (num3 + 5));
        System.out.println("Resta: " + (num1 - num2));
        System.out.println("Multiplicacion: " + (num1 * num2));
        System.out.println("Division: " + (num1 / num2));
        System.out.println("Modulo: " + (num1 % 3));

        System.out.println("++ : " + num3++);
        System.out.println("-- : " + num1--);

        //De igual manera se hace con la suma, la resta, la multiplicacion, el modulo y la division
        resultado = (num1 += num2);
        System.out.println(resultado);

    }

}
