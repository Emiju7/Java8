/**
 *
 * @author Emilio Luis Pareja Hinojosa
 */

public class UsoPersona {

    public static void main(String[] args) {

    Persona persona1, persona2, persona3;
    
    persona1 = new Persona("Paco", "Jimenez", "76591994Q", 22, 669922083);
    
    persona2 = new Persona(persona1);
    
    persona3 = new Persona();
    
        System.out.println("Persona1");
        System.out.println(persona1);
        
        System.out.println("Persona2");
        System.out.println(persona1);
        
        System.out.println("Persona3");
        System.out.println(persona1);
    
    }

}
