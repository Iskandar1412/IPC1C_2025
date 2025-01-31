package Modelo;

public class Atreus implements Guerrero {
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
