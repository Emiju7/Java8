package ejemploVarargs;


import ejemploPunto_Rectangulo.Punto;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Emilio Luis Pareja Hinojosa
 */
public class Poligono {

    private ArrayList<Punto> coordenadasPuntos = new ArrayList();

    public Poligono(Punto... p) { //los tres puntos se conocen como vararg, indican un numero indefinido de puntos
        coordenadasPuntos.addAll(Arrays.asList(p)); //Compacta el array y lo vuelve serializable y lo añade al arrayList
    }

}
