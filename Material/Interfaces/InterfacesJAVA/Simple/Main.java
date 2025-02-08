import java.util.Random;

interface Guerrero {
    void atacar();
    void defender();
    void habilidadEspecial();
}

class Kratos implements Guerrero {
    private String nombre;

    public Kratos() {
        this.nombre = "Kratos";
    }

    @Override
    public void atacar() {
        System.out.println(nombre + " ataca con las Espadas del Caos!");
    }

    @Override
    public void defender() {
        System.out.println(nombre + " bloquea con el Escudo Guardián!");
    }

    @Override
    public void habilidadEspecial() {
        System.out.println(nombre + " usa la Ira Espartana!");
    }
}

class Atreus implements Guerrero {
    private String nombre;

    public Atreus() {
        this.nombre = "Atreus";
    }

    @Override
    public void atacar() {
        System.out.println(nombre + " dispara una flecha mágica!");
    }

    @Override
    public void defender() {
        System.out.println(nombre + " esquiva ágilmente!");
    }

    @Override
    public void habilidadEspecial() {
        System.out.println(nombre + " invoca a los lobos espirituales!");
    }
}


class Thor implements Guerrero {
    private String nombre;

    public Thor() {
        this.nombre = "Thor";
    }

    @Override
    public void atacar() {
        System.out.println(nombre + " lanza Mjölnir con furia!");
    }

    @Override
    public void defender() {
        System.out.println(nombre + " se protege con su enorme resistencia divina!");
    }

    @Override
    public void habilidadEspecial() {
        System.out.println(nombre + " desata una tormenta de rayos!");
    }
}

class Batalla {
    private Guerrero guerrero1;
    private Guerrero guerrero2;
    private Random random;

    public Batalla(Guerrero guerrero1, Guerrero guerrero2) {
        this.guerrero1 = guerrero1;
        this.guerrero2 = guerrero2;
        this.random = new Random();
    }

    public void iniciarCombate() {
        System.out.println("\n¡COMIENZA LA BATALLA!");

        for (int i = 0; i < 3; i++) { // 3 rondas de ataques
            System.out.println("\n--> RONDA " + (i + 1));

            if (random.nextBoolean()) {
                guerrero1.atacar();
                guerrero2.defender();
            } else {
                guerrero2.atacar();
                guerrero1.defender();
            }

            if (random.nextBoolean()) {
                guerrero1.habilidadEspecial();
            } else {
                guerrero2.habilidadEspecial();
            }
        }

        System.out.println("\n¡LA BATALLA HA TERMINADO!");
    }
}

public class Main {
    public static void main(String[] args) {
        // Instancia Kratos vs Thor
        Batalla batalla1 = new Batalla(new Kratos(), new Thor());
        batalla1.iniciarCombate();

        System.out.println("\n==============================\n");

        // Instancia Atreus vs Thor
        Batalla batalla2 = new Batalla(new Atreus(), new Thor());
        batalla2.iniciarCombate();
    }
}
