package Modelo;

public class Fuego extends Pokemon {
    private String tipo;

    public Fuego(String nombre, String tipo) {
        super(nombre);
        this.tipo = tipo;
    }

    public String getTipo() { return tipo; }

    public String atacar() {
        return nombre + " va a hacer un ataque de tipo Fuego";
    }

    @Override
    public String comer() {
        return nombre + " un pokemon tipo " + getTipo() + " de fuego esta comiendo su comida.";
    }
}
