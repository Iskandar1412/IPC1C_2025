using System;

// Interfaz
interface Guerrero {
    void Atacar();
    void Defender();
    void HabilidadEspecial();
}

// Kratos
class Kratos: Guerrero {
    private string nombre = "Kratos";

    public void Atacar() {
        Console.WriteLine($"{nombre} ataca con las Espadas del Caos!");
    }

    public void Defender() {
        Console.WriteLine($"{nombre} bloquea con el Escudo Guardián!");
    }

    public void HabilidadEspecial() {
        Console.WriteLine($"{nombre} usa la Ira Espartana!");
    }
}

// Atreus
class Atreus: Guerrero {
    private string nombre = "Atreus";

    public void Atacar() {
        Console.WriteLine($"{nombre} dispara una flecha mágica!");
    }

    public void Defender() {
        Console.WriteLine($"{nombre} esquiva ágilmente!");
    }

    public void HabilidadEspecial() {
        Console.WriteLine($"{nombre} invoca a los lobos espirituales!");
    }
}

// Thor
class Thor: Guerrero {
    private string nombre = "Thor";

    public void Atacar() {
        Console.WriteLine($"{nombre} lanza Mjölnir con furia!");
    }

    public void Defender() {
        Console.WriteLine($"{nombre} se protege con su enorme resistencia divina!");
    }

    public void HabilidadEspecial() {
        Console.WriteLine($"{nombre} desata una tormenta de rayos!");
    }
}

class Batalla {
    private Guerrero guerrero1;
    private Guerrero guerrero2;
    private Random random;

    public Batalla(Guerrero g1, Guerrero g2) {
        guerrero1 = g1;
        guerrero2 = g2;
        random = new Random();
    }

    public void IniciarCombate() {
        Console.WriteLine("\n¡COMIENZA LA BATALLA!");

        for (int i = 0; i < 3; i++) {
            Console.WriteLine($"\n--> RONDA {i + 1}");

            if (random.Next(2) == 0) {
                guerrero1.Atacar();
                guerrero2.Defender();
            } else {
                guerrero2.Atacar();
                guerrero1.Defender();
            }

            if (random.Next(2) == 0) {
                guerrero1.HabilidadEspecial();
            } else {
                guerrero2.HabilidadEspecial();
            }
        }

        Console.WriteLine("\n¡LA BATALLA HA TERMINADO!");
    }
}

class Program {
    static void Main(string[] args) {
        // Instancias
        Guerrero kratos = new Kratos();
        Guerrero thor = new Thor();
        Guerrero atreus = new Atreus();

        // Kratos vs Thor
        Batalla batalla1 = new Batalla(kratos, thor);
        batalla1.IniciarCombate();

        Console.WriteLine("\n==============================");

        // Atreus vs Thor
        Batalla batalla2 = new Batalla(atreus, thor);
        batalla2.IniciarCombate();
    }
}