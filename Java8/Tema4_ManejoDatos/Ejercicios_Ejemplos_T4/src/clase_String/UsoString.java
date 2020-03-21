
/**
 *
 * @author Emilio Luis Pareja Hinojosa
 */

public class UsoString {

    public static void main(String[] args) {

        String cad1, cad2, cad3, cad4;

        cad1 = "hola";
        cad2 = "Pepe";
        cad3 = "¿Como estan ustedes...?";

        System.out.println(cad1.concat(" " + cad2));

        System.out.println("Tamaño de cad1: " + cad1.length());
        System.out.println("Mayusculas: " + cad1.toUpperCase());
        System.out.println("Minusculas: " + cad1.toLowerCase());

        //quitamos los dos ultimos caracteres de la concatenacion de cad1 y cad2
        System.out.println("Susbstraer: " + cad1.concat(cad2).substring(0, (cad1.length() + cad2.length() - 2)));

        cad4 = String.format("%s soy %s como se encuentran, han sobrepasado el coronavirus, bueno, se despide %s", cad1, cad2, cad2);
        System.out.println(cad4);
        
        //se puede hacer en un unico paso con printf
        System.out.printf("%s soy %s como se encuentran, han sobrepasado el coronavirus, bueno, se despide %s\n", cad1, cad2, cad2);
        
        //---------------------COMPARACION DE CADENAS--------------------//
        
        System.out.println(cad1.compareTo(cad2));
    }

}
