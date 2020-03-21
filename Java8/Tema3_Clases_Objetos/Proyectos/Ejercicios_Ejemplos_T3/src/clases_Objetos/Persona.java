
/**
 *
 * @author Emilio Luis Pareja Hinojosa
 */

public class Persona {

    private String nombre, apellidos, dni;
    private int edad;
    private long telefono;

    /**
     * Crea una persona con parametros nulos
     */
    public Persona() {
        this.nombre = "null";
        this.apellidos = "null";
        this.dni = "null";
        this.edad = 1;
        this.telefono = 0;
    }

    /**
     * Crea un objeto persona
     *
     * @param nombre Nombre de la persona
     * @param apellidos Apellidos de la persona
     * @param dni DNI de la persona
     * @param edad Edad de la persona
     * @param telefono Telefono de la persona
     */
    public Persona(String nombre, String apellidos, String dni, int edad, long telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad = edad;
        this.telefono = telefono;
    }
    
    public Persona(Persona p){
        this.nombre = p.getNombre();
        this.apellidos = p.getApellidos();
        this.dni = p.getDni();
        this.edad = p.getEdad();
        this.telefono = p.getTelefono();
    }
  
    @Override
    public String toString() {
        return " Nombre: " + this.nombre
                + "\n Apellidos: " + this.apellidos
                + "\n DNI: " + this.dni
                + "\n Edad: " + this.edad
                + "\n Telefono: " + this.telefono
                + "\n";
    }

    
    //---------------------------GETTERS AND SETTERS---------------------------//

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    
    
}
