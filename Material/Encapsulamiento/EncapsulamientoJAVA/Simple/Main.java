class Persona {
    // Atributos privados (encapsulamiento)
    private String nombre;
    private int edad;

    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Get
    public String getNombre() {
        return nombre;
    }

    // Set
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Get
    public int getEdad() {
        return edad;
    }

    // Set
    public void setEdad(int edad) {
        if (edad > 0) {
            this.edad = edad;
        } else {
            System.out.println("La edad no puede ser igual o menor a 0");
        }
    }

    // Mostrar información de la persona
    public void mostrarInfo() {
        System.out.println("------------------------------------");
        System.out.println("Persona");
        System.out.println("Nombre: " + nombre + ", Edad: " + edad);
        System.out.println("------------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        // Creación de instancia persona
        Persona persona = new Persona("Jose", 25);

        // Acceder a los atributos de la persona
        System.out.println("Nombre inicial: " + persona.getNombre());
        persona.setEdad(30);
        persona.setNombre("Pablo");

        // Imprimir información de la persona
        persona.mostrarInfo();

        // Intentar asignar una edad no válida
        persona.setEdad(-5);
        System.out.println("Edad: " + persona.getEdad());
    }
}