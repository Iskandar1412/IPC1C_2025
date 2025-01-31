package Modelo;

public class Kratos implements Guerrero {
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
