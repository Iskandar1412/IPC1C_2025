package Modelo;

public abstract class Saiyajin {
    protected String nombre;
    protected int nivelPoder;

    public Saiyajin(String nombre, int nivelPoder) {
        this.nombre = nombre;
        this.nivelPoder = nivelPoder;
    }

    public String getNombre() { return this.nombre; }
    public int getNivelPoder() { return this.nivelPoder; }

    public String atacar() {
        return getNombre() + " golpea con sus puños";
    }

    public abstract String transformacion();
    public abstract String ataqueEspecial();
}