class Animal {
    public void hacerRuido() {
        System.out.println("Soy un animal");
    }
}

class Gato extends Animal {
    public void hacerRuido() {
        System.out.println("Miau");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Gato(); // Upcasting implícito
        if (animal1 instanceof Gato) {
            Gato gato1 = (Gato) animal1; // Downcasting explícito
            gato1.hacerRuido(); // out: Miau
        }
    }
}

// public class Main {
//     public static void main(String[] args) {
//         Gato gatito = new Gato();
//         Animal gato1 = gatito; // Upcasting implícito
//         gato1.hacerRuido(); // out: Miau
//     }
// }

