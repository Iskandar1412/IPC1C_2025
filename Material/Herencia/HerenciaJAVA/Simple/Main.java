// Superclase
class Animal {
    String nombre;

    // Constructor
    public Animal(String nombre) {
        this.nombre = nombre;
    }

    // Método común
    void comer() {
        System.out.println(nombre + " [ocupado (está comiendo)]");
    }
}

// Subclase
class Perro extends Animal {
    String raza;

    // Constructor
    public Perro(String nombre, String raza) {
        super(nombre); // Llama al constructor de la superclase
        this.raza = raza;
    }

    // Método exclusivo de clase Perro
    void ladrar() {
        System.out.println(nombre + " está ladrando: ¡Raaaa!");
    }

    // Sobrescritura de método
    @Override
    void comer() {
        System.out.println(nombre + " (un " + raza + ") está comiendo");
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear instancia (superclase)
        Animal animal = new Animal("Perry");
        animal.comer();

        // Crear un objeto de la subclase
        Perro perro = new Perro("Arcanine", "Pokemon");
        perro.comer(); // Llama al método
        perro.ladrar(); // Método
    }
}