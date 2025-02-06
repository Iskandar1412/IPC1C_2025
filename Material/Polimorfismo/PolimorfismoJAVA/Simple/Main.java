// Superclase abstracta Saiyajin
abstract class Saiyajin {
    protected String nombre;
    protected int nivelPoder;

    // Constructor
    public Saiyajin(String nombre, int nivelPoder) {
        this.nombre = nombre;
        this.nivelPoder = nivelPoder;
    }

    // Método común a todos los Saiyajin
    public void atacar() {
        System.out.println(nombre + " golpea con sus puños");
    }

    // Método abstracto (Cada clase que lo herede lo va a implementar de diferente forma)
    public abstract void transformarse();

    // Método
    public void ataqueEspecial() {
        System.out.println(nombre + " lanza una habilidad especial");
    }
}

// Clase Goku (Subclase de Saiyajin)
class Goku extends Saiyajin {

    public Goku() {
        super("Goku", 9000);
    }

    @Override
    public void transformarse() {
        System.out.println(nombre + " se transforma en Super Saiyajin Fase 3!");
        nivelPoder *= 50; // Aumento de nivel de poder
    }

    @Override
    public void ataqueEspecial() {
        System.out.println(nombre + " lanza un Kamehameha!");
    }
}

// Clase Vegeta (Subclase de Saiyajin)
class Vegeta extends Saiyajin {

    public Vegeta() {
        super("Vegeta", 8500);
    }

    @Override
    public void transformarse() {
        System.out.println(nombre + " se transforma en Super Saiyajin Fase 2!");
        nivelPoder *= 45; // Aumento de nivel de poder
    }

    @Override
    public void ataqueEspecial() {
        System.out.println(nombre + " lanza un ataque de Brillo Final!");
    }
}

// Clase Broly (Subclase de Saiyajin)
class Broly extends Saiyajin {

    public Broly() {
        super("Broly", 12000);
    }

    @Override
    public void transformarse() {
        System.out.println(nombre + " se transforma en Super Saiyajin Legendario!");
        nivelPoder *= 70; // Aumento de nivel de poder
    }

    @Override
    public void ataqueEspecial() {
        System.out.println(nombre + " lanza una Erupción Omega!");
    }
}

public class Main {
    public static void main(String[] args) {
        // Polimorfismo: Se usará de referencia la superclase para instanciar las subclases
        Saiyajin goku = new Goku();
        Saiyajin vegeta = new Vegeta();
        Saiyajin broly = new Broly();

        // Array
        Saiyajin[] guerreros = {goku, vegeta, broly};

        System.out.println("¡Comienza la batalla!\n");

        for (Saiyajin guerrero : guerreros) {
            System.out.println(guerrero.nombre + " entra en combate!");
            guerrero.atacar();          // Método heredado
            guerrero.transformarse();   // C/Personaje tiene su transfomración
            guerrero.ataqueEspecial();  // C/Personaje tiene un ataque diferente
            System.out.println("Nivel de poder actual de <<"  + guerrero.nombre  + ">>: " + guerrero.nivelPoder + "\n");
        }

        System.out.println("¡Fin del combate!");
    }
}
