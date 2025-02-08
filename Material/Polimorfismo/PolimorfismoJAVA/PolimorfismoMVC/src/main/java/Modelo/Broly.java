package Modelo;

public class Broly extends Saiyajin {
    public Broly() {
        super("Broly", 12000);
    }

    @Override
    public String transformacion() {
        nivelPoder *= 70;
        return nombre + " se transforma en Super Saiyajin Legendario!";
    }

    @Override
    public String ataqueEspecial() {
        return nombre + " lanza una Erupción Omega!";
    }
}
