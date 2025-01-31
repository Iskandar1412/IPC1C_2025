package Modelo;

public class Goku extends Saiyajin {
    public Goku() {
        super("Goku", 9000);
    }

    @Override
    public String transformacion() {
        nivelPoder *= 60;
        return nombre + " se transforma en Super Saiyajin Fase 3";
    }

    @Override
    public String ataqueEspecial() {
        return nombre + " lanza un Kamehameha!";
    }
}
