package Modelo;

public class Vegeta extends Saiyajin {
    public Vegeta() {
        super("Vegeta", 6500);
    }

    @Override
    public String transformacion() {
        nivelPoder *= 30;
        return nombre + " se transforma en Super Saiyajin Fase 2";
    }

    @Override
    public String ataqueEspecial() {
        return nombre + " lanza un ataque de Brillo Final!";
    }
}
