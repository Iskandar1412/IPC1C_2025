package Modelo;

public abstract class Pokemon {
    protected String nombre;

    public Pokemon(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    public abstract String comer(); // Método abstracto
}
