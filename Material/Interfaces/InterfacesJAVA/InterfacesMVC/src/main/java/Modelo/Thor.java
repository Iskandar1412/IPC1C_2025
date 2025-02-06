package Modelo;

public class Thor implements Guerrero {
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
