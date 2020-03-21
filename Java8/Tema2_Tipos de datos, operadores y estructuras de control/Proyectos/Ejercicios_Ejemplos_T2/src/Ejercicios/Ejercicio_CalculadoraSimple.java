package Ejercicios;


import java.util.Scanner;

/**
 *
 * @author Emilio Luis Pareja Hinojosa
 */
public class Ejercicio_CalculadoraSimple {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        boolean finPrograma = false;
        boolean error = false;
        int num1, num2, operacion;
        double resultado = 0;

        do {
            mostrarMenu();

            System.out.println("\n Elija la operación a realizar:");
            operacion = entrada.nextInt();

            //Se ha introducido un numero valido
            if (operacion >= 0 && operacion <= 5) {

                System.out.println("Introduzca el primer numero");
                num1 = entrada.nextInt();

                System.out.println("Introduzca el segundo numero");
                num2 = entrada.nextInt();

                switch (operacion) {

                    //SUMA//
                    case 1: {
                        resultado = num1 + num2;
                        break;
                    }

                    //RESTA//
                    case 2: {
                        resultado = num1 - num2;
                        break;
                    }

                    //MULTIPLICACION//
                    case 3: {
                        resultado = num1 * num2;
                        break;
                    }

                    //DIVISION//
                    case 4: {
                        resultado = ((double) num1 / num2);
                        break;
                    }

                    //MODULO//
                    case 5: {
                        resultado = ((double) num1 % num2);
                        break;
                    }

                    //FIN DE PROGRAMA//
                    case 0: {
                        finPrograma = true;
                    }

                    //NO ES VALIDO EL NUMERO//
                    default: {
                        System.out.println("El numero introducido no es válido");
                        error = true;
                    }
                }
                
                //si no ha habido ningun error muestra los resultados y pregunta si se repite el programa
                if (!error) {
                    System.out.println("El resultado de la operación es: " + resultado);
                    System.out.println("");

                    System.out.println("¿Desea continuar el programa? (S/N)");
                    if (Character.toUpperCase(entrada.next().charAt(0)) == 'N') {
                        finPrograma = true;
                    }
                }
            }

        } while (!finPrograma);

    }

    public static void mostrarMenu() {

        System.out.println("------------------------INSTRUCCIONES DE USO------------------------");
        System.out.println("Cuando el programa solicite un numero, introducir cualquier otro caracter generará un error"
                + "\n El programa se seguira ejecutando automaticamente hasta que el usuario no escoja la opcion de salir del programa");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("");

        System.out.println("*********************** MENU CALCULADORA ***********************");
        System.out.println(" 1: Sumar"
                + "\n 2: Restar"
                + "\n 3: Multiplicar"
                + "\n 4: Dividir"
                + "\n 5: Resto"
                + "\n 0: Salir del programa");

    }

}
