interface Mamifero {
    void sonido();
}

class Gato implements Mamifero {
    public void sonido() {
        System.out.println("Miau, soy un gato");
    }
}

public class Main {
    public static void main(String[] args) {
        Mamifero animal1 = new Gato(); // Upcasting
        Gato gato1 = (Gato) animal1; // Downcasting explícito
        gato1.sonido(); // out: Miau
    }
}


