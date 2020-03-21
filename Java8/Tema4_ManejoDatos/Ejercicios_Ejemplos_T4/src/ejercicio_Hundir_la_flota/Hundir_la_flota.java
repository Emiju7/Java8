package ejercicio_Hundir_la_flota;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Emilio Luis Pareja Hinojosa
 */
public class Hundir_la_flota {

    static Tablero tableroUsu = new Tablero();
    static Tablero tableroContr = new Tablero();
    static ArrayList<int[]> arrayCoordenadasTirosIA = new ArrayList();

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        comenzarPartida();

        System.out.println("******************************************************");
        System.out.println("\t\tGRACIAS POR JUGAR");
        System.out.println("******************************************************");
    }

    public static void comenzarPartida() {

        do {
            boolean error;
            int[] coordenadasTiro = null;

            if (!finPartida()) {

                System.out.println("**********************TURNO DEL USUARIO**********************");

                tableroUsu.visualizarTableroTiros();
                System.out.println("");
                tableroUsu.visualizarTableroBarcos();

                //***********Movimiento del usuario***************//
                do {
                    error = false;
                    System.out.println("\nIntroduce las coordenadas del tiro a realizar (ejemplo: A4)");
                    try {
                        coordenadasTiro = obtenerNumCoorTiro(entrada.nextLine());
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        error = true;
                    }

                } while (error);

                //Realizamos el tiro en el tablero de la IA
                char estadoTiro = tableroContr.realizarTiro(coordenadasTiro[0], coordenadasTiro[1]);
                //Guardamos nuestro tiro en nuestro tablero
                tableroUsu.actualizarTiros(coordenadasTiro[0], coordenadasTiro[1], estadoTiro);

                if (estadoTiro == Tablero.TOCADO) {
                    System.out.println("");
                    System.out.println("\n EL tiro ha impactado en un barco \n");
                } else {
                    System.out.println("\n El tiro no ha impactado en ningun barco \n");
                }

            } else {
                break;
            }

            if (!finPartida()) {
                //***********Movimiento de la IA***************//

                System.out.println("**********************TURNO DE LA IA**********************");

                movimientoIA();
            } else {
                break;
            }

        } while (true);
    }

    /**
     * Devuelve un array de enteros con las coordenadas en numero del tiro (pos
     * 0-> fila, pos 1-> columna)
     *
     * @param coordenadas Las coordenadas en fomato (LetraNumero)
     * @return Array de enteros con las coordenadas (pos 0-> fila, pos 1->
     * columna)
     * @throws Exception Posibles errores en la creacion/transformacion del
     * String de coordenadas al int[] de coordenadas
     */
    private static int[] obtenerNumCoorTiro(String coordenadas) throws Exception {
        int[] coordenadasTiro = new int[2];

        if ((Character.isLetter(coordenadas.charAt(0))) && (Character.isDigit(coordenadas.charAt(1)))) {
            //Se han dado los numeros en el formato correcto

            coordenadasTiro[0] = ((int) (coordenadas.charAt(0))) - 65;
            coordenadasTiro[1] = (Integer.parseInt(coordenadas.substring(1))) - 1;

            if ((coordenadasTiro[0] >= 0 && coordenadasTiro[0] < Tablero.ALTO)
                    && (coordenadasTiro[1] >= 0 && coordenadasTiro[1] < Tablero.ANCHO)) {
                //Las coordenadas pertenecen a la tabla
            } else {
                Exception e = new Exception("Las coordenadas dadas no pertenecen a la tabla");
                throw e;
            }

            return coordenadasTiro;

        } else {
            Exception e = new Exception("El formato de las coordenadas no es valido");
            throw e;
        }

    }

    /**
     * La IA realiza su movimiento random
     */
    private static void movimientoIA() {
        boolean diferenteTiro;
        int fila, columna;

        if (arrayCoordenadasTirosIA.isEmpty()) {
            //El almacen de tiros de la IA esta vacio

            fila = new Random(System.currentTimeMillis()).nextInt(Tablero.ALTO);
            columna = new Random(System.currentTimeMillis()).nextInt(Tablero.ANCHO);
            int[] temp = {fila, columna};

            //Añadimos directamente las coordenadas del tiro creadas
            arrayCoordenadasTirosIA.add(temp);

        } else {
            //Repetimos el proceso hasta obtener un numero diferente
            do {
                diferenteTiro = false;
                //El almacen de tiros de la IA ya posee tiros

                fila = new Random(System.currentTimeMillis()).nextInt(Tablero.ALTO);
                columna = new Random(System.currentTimeMillis()).nextInt(Tablero.ANCHO);
                int[] temp = {fila, columna};

                //Comrpobamos si las coordenadas propuestas son validas
                if (!arrayCoordenadasTirosIA.contains(temp)) {
                    arrayCoordenadasTirosIA.add(temp);
                    diferenteTiro = true;
                }
            } while (diferenteTiro);
        }

        //Recogemos el tiro de la IA en nuestro tablero
        char estadoTiro = tableroUsu.realizarTiro(fila, columna);
        //Actualizamos el tablero de tiros de la IA
        tableroContr.actualizarTiros(fila, columna, estadoTiro);

        if (estadoTiro == Tablero.TOCADO) {
            System.out.println("\n EL tiro ha impactado en un barco \n");
        } else {
            System.out.println("\n El tiro no ha impactado en ningun barco \n");
        }

    }

    /**
     * Comprobamos si la partida ha finalizado
     *
     * @return True-> Alguien se ha quedado sin barcos, False-> La partida aun
     * no ha finalizado
     */
    private static boolean finPartida() {
        if (!tableroUsu.quedanBarcos() || !tableroContr.quedanBarcos()) {
            //Alguno de los participantes se han quedado sin barcos

            System.out.println("********************************FIN DE PARTIDA********************************");
            if (tableroUsu.quedanBarcos()) {
                //El usuario ha ganado la partida
                System.out.println("El usuario ha ganado la partida con " + tableroUsu.getPuntos() + " puntos");
            } else {
                //La IA ha ganado la partida
                System.out.println("La IA ha ganado la partida con " + tableroContr.getPuntos() + " puntos");
            }

            return true;

        } else {
            return false;
        }
    }

}
