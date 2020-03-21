package ejercicio_Hundir_la_flota;

import java.util.Random;

/**
 *
 * @author Emilio Luis Pareja Hinojosa
 */
public class Tablero {

    //Dimensiones del tablero
    public static final int ANCHO = 7, ALTO = 7;

    //Estados de las posiciones del tablero
    public static final char TOCADO = 'X', AGUA = 'A', COMIENZO = '·';

    private char[][] tableroTiros;
    private String[][] tableroBarcos;
    private final int[] barcos = {5, 5, 3, 3, 2, 1, 1, 1};
    public int puntos = this.totalPuntos();

    /**
     * Constructor de un tablero de dimensiones prefijadas
     */
    public Tablero() {
        this.tableroTiros = new char[ALTO][ANCHO];
        this.tableroBarcos = new String[ALTO][ANCHO];
        rellenarTableros();
    }

    /**
     * Rellena el tablero con los valores por defecto
     */
    private void rellenarTableros() {
        //Colocacion por defecto//
        for (int i = 0; i < ALTO; i++) {
            for (int j = 0; j < ANCHO; j++) {
                this.tableroTiros[i][j] = COMIENZO;
                this.tableroBarcos[i][j] = Character.toString(COMIENZO);
            }
        }

        colocarBarcos();
    }

    /**
     * Muestra el tablero de los tiros por consola
     */
    public void visualizarTableroTiros() {
        System.out.println("---------------------TABLERO DE TIROS---------------------");
        for (int i = 0; i < ALTO; i++) {
            System.out.print("\t " + (i + 1));
        }
        System.out.println("");

        for (int i = 0; i < ALTO; i++) {

            System.out.print((char) ('A' + i));

            for (int j = 0; j < ANCHO; j++) {
                System.out.print("\t " + tableroTiros[i][j]);
            }

            System.out.println("");
        }

    }

    /**
     * Muestra el tablero de los barcos por consola
     */
    public void visualizarTableroBarcos() {
        System.out.println("---------------------TABLERO DE BARCOS---------------------");
        for (int i = 0; i < ALTO; i++) {
            System.out.print("\t " + (i + 1));
        }
        System.out.println("");

        for (int i = 0; i < ALTO; i++) {

            System.out.print((char) ('A' + i));

            for (int j = 0; j < ANCHO; j++) {
                System.out.print("\t " + tableroBarcos[i][j]);
            }

            System.out.println("");
        }

    }

    /**
     * Actualiza el mapa de barcos en funcion de las coordenadas del tiro dadas
     *
     * @param fila Coordenada de las filas del tiro
     * @param columna Coordenada de las columnas del tiro
     * @return El estado del tiro X-> Tocado, A->Agua
     */
    public char realizarTiro(int fila, int columna) {
        char estado;

        if (this.otroBarco(fila, columna)) {
            //Le hemos dado a un barco
            estado = TOCADO;
            this.tableroBarcos[fila][columna] = Character.toString(TOCADO);
        } else {
            estado = AGUA;
        }

        return estado;
    }

    /**
     * Actualiza el mapa de tiros en funcion de las coordenadas del tiro y su
     * resultado
     *
     * @param fila Coordenada de las filas del tiro
     * @param columna Coordenadas de las columnas del tiro
     * @param estado Resultado del tiro
     */
    public void actualizarTiros(int fila, int columna, char estado) {
        this.tableroTiros[fila][columna] = estado;
        if(estado == TOCADO){
            
            this.puntos--;
        }
    }

    /**
     * Genera un numero aleatorio dado un limite superior, sin incluir a este
     *
     * @param limiteSup Limite superior para la generacion del numero
     * @return El numero aleatorio creado desde 0 hasta limiteSup -1
     */
    private int generarAleatorio(int limiteSup) {
        Random numRandom = new Random(System.currentTimeMillis());
        return numRandom.nextInt(limiteSup);
    }

    /**
     * Coloca todos los barcos en el mapa para iniciar la partida
     */
    private void colocarBarcos() {
        // Recorremos el array de barcos a colocar, de mayor a menor tamaño
        for (int i = 0; i < barcos.length;) {

            //A cada paso del for generamos nuevas posiciones aleatorias
            int columna = this.generarAleatorio(ANCHO);
            int fila = this.generarAleatorio(ALTO);

            if (((columna + barcos[i]) < ANCHO)) {
                //El barco se puede poscionar horizontalmente
                boolean libreParaColocar = true;

                //Se comprueba si en esa fila existen barcos
                for (int j = 0; (j < barcos[i]) && libreParaColocar; j++) {
                    if (otroBarco(fila, columna + j)) {
                        libreParaColocar = false;
                    }

                }

                //Si esta libre la fila se colocan los barcos
                if (libreParaColocar) {
                    for (int j = 0; j < barcos[i]; j++) {
                        this.tableroBarcos[fila][columna + j] = Integer.toString(barcos[i]);
                    }

                    i++;
                }

            } else if (((fila + barcos[i]) < ALTO)) {
                //El barco se puede posicionar verticalmente

                boolean libreParaColocar = true;

                //Se comprueba si en esa columna existen barcos
                for (int j = 0; (j < barcos[i]) && libreParaColocar; j++) {
                    if (otroBarco(fila + j, columna)) {
                        libreParaColocar = false;
                    }

                }

                //Si esta libre la fila se colocan los barcos
                if (libreParaColocar) {
                    for (int j = 0; j < barcos[i]; j++) {
                        this.tableroBarcos[fila + j][columna] = Integer.toString(barcos[i]);
                    }

                    i++;
                }

            }
        }
    }

    /**
     * Comprueba si hay otro barco en la posicion dada
     *
     * @param fila La posicion de la fila en el tablero
     * @param columna La posicion de la columna en el tablero
     * @return True -> Si existe otro barco, False -> Si no existe otro barco
     */
    private boolean otroBarco(int fila, int columna) {
        boolean ocupado = false;

        if (this.tableroBarcos[fila][columna].compareTo(Character.toString(COMIENZO)) != 0) {
            //Hay algun barco
            ocupado = true;
        }

        return ocupado;
    }

    /**
     * Comprueba en funcion de los putnos, si quedan barcos o no
     * @return 
     */
    public boolean quedanBarcos() {
        boolean quedan = false;

        if(this.puntos!=0){
            quedan = true;
        }

        return quedan;
    }
    
    /**
     * Devuelve la cantidad de puntos totales calculados en funcion de los barcos que hay
     * 
     * @return La cantidad de puntos total
     */
    public int totalPuntos(){
        int puntos = 0;
        
        for(int i = 0; i< this.barcos.length; i++){
            puntos += barcos[i];
        }
        
        return puntos;
    }

    //-------------------------------GETTERS Y SETTERS-------------------------------//
    public char[][] getTableroTiros() {
        return tableroTiros;
    }

    public String[][] getTableroBarcos() {
        return tableroBarcos;
    }

    public int[] getBarcos() {
        return barcos;
    }

    public int getPuntos() {
        return puntos;
    }
    
    
}
