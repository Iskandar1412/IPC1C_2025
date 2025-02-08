// Clase Básica
class Persona { // si fuera en otro archivo public tendría antes
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void mostrarPersona() {
        System.out.println("nombre: " + this.nombre + ", edad: " + this.edad);
    }
}

// Clase Abstracta
abstract class Pokemon {
    protected String nombre;

    public Pokemon(String nombre) {
        this.nombre = nombre;
    }

    public abstract void ataque();
}

class TipoPokemon extends Pokemon {
    public TipoPokemon(String nombre) {
        super(nombre);
    }

    @Override
    public void ataque() {
        System.out.println(nombre + " esta atacando");
    }
}

// Interfaces
interface Character {
    void juego();
}

class Morrigan implements Character {
    private String nombre;
    public Morrigan() {
        this.nombre = "Morrigan";
    }

    @Override
    public void juego() {
        System.out.println(this.nombre + " in... ¡Tatsunoko Vs. Capcon!");
    }
}

public class main {

    private String mensaje = "Me utiliza la clase interna"; // Para clase interna
    public static void main(String[] args) {
        // Clase normal
        System.out.println("Clases Normales");
        Persona persona = new Persona("jose", 15);
        persona.mostrarPersona();
        // Clase abstracta
        System.out.println("Clases Abstractas");
        Pokemon pikachu = new TipoPokemon("Pikachu");
        pikachu.ataque();
        // Interfaces
        System.out.println("Interfaces");
        Character morrigan = new Morrigan();
        morrigan.juego();
        // Clases anonimas
        System.out.println("Clases Anónimas");
        // Clases anónimas
        Character game_player = new Character() {
            @Override
            public void juego() {
                System.out.println("Es un jugador de un juego");
            }
        };
        game_player.juego();
        // Expresión lambda
        Character player = () -> System.out.println("Jugador a la vista");
        player.juego();

        // Clase interna
        main externa = new main(); // creamos instancia clase externa
        main.Interna interna = externa.new Interna(); // instanciamos clase interna
        interna.impresion();
    }

    // Clase interna no estática
    public class Interna {
        public void impresion() {
            System.out.println(mensaje);
        }
    }
}
