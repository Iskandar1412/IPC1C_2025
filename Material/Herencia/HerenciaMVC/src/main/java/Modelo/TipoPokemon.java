package Modelo;

public class TipoPokemon extends Pokemon{
    private String tipo;

    public TipoPokemon(String nombre, String tipo) {
        super(nombre);
        this.tipo = tipo;
    }

    public String getTipo() { return tipo; }
    public String rugidoPokemon() { return nombre + " uso rugido pokemon: ¡Raaaa!"; }

    @Override
    public String comer() {
        return nombre + " es un pokemon tipo " + getTipo() + ", está comiendo rápidamente";
    }
}
