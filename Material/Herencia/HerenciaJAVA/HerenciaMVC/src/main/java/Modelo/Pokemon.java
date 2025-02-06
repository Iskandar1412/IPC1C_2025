package Modelo;

public class Pokemon {
    protected String nombre;

    public Pokemon(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    public String comer() {
        return getNombre() + " está comiendo tranquilamente";
    }
}