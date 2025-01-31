package Modelo;

public class Hielo extends Pokemon {
    private String tipo;

    public Hielo(String nombre, String tipo) {
        super(nombre);
        this.tipo = tipo;
    }

    public String getTipo() { return tipo; }

    public String dormir() {
        return nombre + " va a dormir";
    }

    @Override
    public String comer() {
        return nombre + " un pokemon tipo " + getTipo() + " de hielo esta comiendo su comida relajadamente.";
    }
}
