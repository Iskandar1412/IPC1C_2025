using System;

// clase persona
class Persona {
    // propiedades de persona
    public string Nombre { get; set; }
    private int edad;
    public int Edad {
        get { return edad; }
        set {
            if (value > 0) {
                edad = value;
            } else {
                Console.WriteLine("La edad no puede ser igual o menor a 0");
            }
        }
    }

    // constructor
    public Persona(string nombre, int edad) {
        Nombre = nombre;
        Edad = edad;
    }

    public void infoPersona() {
        Console.WriteLine("------------------------------------");
        Console.WriteLine("Persona");
        Console.WriteLine($"Nombre: {Nombre}, Edad: {Edad}");
        Console.WriteLine("------------------------------------");
    }
}

class Program {
    static void Main(string[] args) {
        // Creación instancia persona
        Persona persona = new Persona("Mario", 25);
        persona.infoPersona();

        persona.Edad = 30;
        persona.Nombre = "Carlos";
        persona.infoPersona();

        persona.Edad = -5;
        persona.infoPersona();
    }
}