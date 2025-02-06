using System;
using System.Collections.Generic;

// Clase abstracta
abstract class Saiyajin {
    protected string Nombre { get; set; }
    protected int NivelPoder { get; set; }

    // Constructor
    public Saiyajin(string nombre, int nivelPoder) {
        Nombre = nombre;
        NivelPoder = nivelPoder;
    }

    public int getNivelPoder() { return NivelPoder; }
    public string getNombre() { return Nombre; }

    // Método común
    public void Atacar() {
        Console.WriteLine($"{Nombre} golpea con sus puños");
    }

    // Método abstracto
    public abstract void Transformarse();

    // Método virtual
    public virtual void AtaqueEspecial() {
        Console.WriteLine($"{Nombre} lanza una habilidad especial");
    }
}

// Goku
class Goku: Saiyajin {
    public Goku(): base("Goku", 9000) { }

    public override void Transformarse() {
        Console.WriteLine($"{Nombre} se transforma en Super Saiyajin Fase 3!");
        NivelPoder *= 50;
    }

    public override void AtaqueEspecial() {
        Console.WriteLine($"{Nombre} lanza un Kamehameha!");
    }
}

// Vegeta
class Vegeta: Saiyajin {
    public Vegeta(): base("Vegeta", 8500) { }

    public override void Transformarse() {
        Console.WriteLine($"{Nombre} se transforma en Super Saiyajin Fase 2!");
        NivelPoder *= 45;
    }

    public override void AtaqueEspecial() {
        Console.WriteLine($"{Nombre} lanza un ataque de Brillo Final!");
    }
}

// Broly
class Broly: Saiyajin {
    public Broly() : base("Broly", 12000) { }

    public override void Transformarse() {
        Console.WriteLine($"{Nombre} se transforma en Super Saiyajin Legendario!");
        NivelPoder *= 70;
    }

    public override void AtaqueEspecial() {
        Console.WriteLine($"{Nombre} lanza una Erupción Omega!");
    }
}

class Program {
    static void Main(string[] args) {
        // Creación de instancias
        Saiyajin goku = new Goku();
        Saiyajin vegeta = new Vegeta();
        Saiyajin broly = new Broly();

        // Lista (polimorfismo)
        List<Saiyajin> guerreros = new List<Saiyajin> { goku, vegeta, broly };

        Console.WriteLine("¡Comienza la batalla!\n");

        foreach (var guerrero in guerreros) {
            Console.WriteLine($"{guerrero.getNombre()} entra en combate!");
            guerrero.Atacar();
            guerrero.Transformarse();
            guerrero.AtaqueEspecial();
            Console.WriteLine($"Nivel de poder actual de <<{guerrero.getNombre()}>>: {guerrero.getNivelPoder()}\n");
        }

        Console.WriteLine("¡Fin del combate!");
    }
}