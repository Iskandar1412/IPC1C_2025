// dotnet new console -n <nombre_proyecto>
// cd <nombre_proyecto>
// dotnet run

using System;

// interfaz
interface Animal {
    void SonidoAnimal();
}

// clase que va a implementar la interface
class Gato: Animal {
    public void SonidoAnimal() {
        Console.WriteLine("Miau, soy un gato");
    }
}

class Perro: Animal {
    public void SonidoAnimal() {
        Console.WriteLine("Guauf, soy un perro");
    }
}

// El nombre de la clase principal (nombre del archivo)
class Program {
    static void Main(string[] args) {
        // Upcasting: Asignamos una instancia gato a una variable Animal
        Animal animal1 = new Gato();
        Animal animal2 = new Perro();

        // Downcasting explícito: Se convierte Animal de vuelta a la clase hija
        Gato gatito1 = (Gato) animal1;
        Perro perrito1 = (Perro) animal2;

        // Llamada del metodo SonidoAnimal
        gatito1.SonidoAnimal();
        perrito1.SonidoAnimal();    
    }
}