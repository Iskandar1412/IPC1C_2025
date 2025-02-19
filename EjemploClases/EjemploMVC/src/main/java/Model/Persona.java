package Model;

public class Persona extends Profesion {
    private String nombre;
    private int edad;

    public Persona(String nombreProfesion, String nombre, int edad) {
        super(nombreProfesion);
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }

    @Override
    public String accionProfesion() {
        return "La persona de profesion " + getNombreProfesion() + " llamada " + getNombre() + "  tiene una edad de: " + getEdad() + " años";
    }
}
