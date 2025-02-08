using System;

// Clase padre
class Pokemon {
    public string Nombre { get; set; }

    // Constructor
    public Pokemon(string nombre) {
        Nombre = nombre;
    }

    // Método que va a ser heredado
    public virtual void comer() {
        Console.WriteLine(Nombre + " está ocupado comiendo");
    }
}

// Clases derivadas (hijas)
class TipoFuego: Pokemon {
    public string Raza { get; set; }

    public TipoFuego(string nombre, string raza): base(nombre) {
        Raza = raza;
    }

    // Método exclusivo
    public void ataque() {
        Console.WriteLine(Nombre + " va a hacer un ataque de fuego");
    }

    public override void comer() {
        Console.Write(Nombre + " (un " + Raza + ") está comiendo atentamente");
    }
}

class TipoHielo: Pokemon {
    public string Raza { get; set; }

    public TipoHielo(string nombre, string raza): base(nombre) {
        Raza = raza;
    }

    public void habilidad() {
        Console.WriteLine(Nombre + " va a usar rompehielo");
    }

    public override void comer() {
        Console.WriteLine(Nombre + " (un " + Raza + ") está comiendo tranquilamente"); 
    }
}

class Program {
    static void Main(string[] args) {
        // Crear instancia pokemon
        Pokemon pokemon = new Pokemon("Giratina");
        pokemon.comer();

        // Crear instancias pokemones
        TipoFuego vulpix = new TipoFuego("Vulpix", "¿Pokemon?");
        TipoHielo articuno = new TipoHielo("Articuno", "¿Pokemon?");

        // llamada de métodos
        vulpix.ataque();
        vulpix.comer();

        articuno.habilidad();
        articuno.comer();
    }
}