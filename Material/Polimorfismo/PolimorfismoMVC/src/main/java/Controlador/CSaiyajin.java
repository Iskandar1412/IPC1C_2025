package Controlador;

import Modelo.Goku;
import Modelo.Saiyajin;
import Vista.VBatalla;

import java.util.Random;

public class CSaiyajin {
    // Modelo
    private Saiyajin guerrero1;
    private Saiyajin guerrero2;

    // Vista
    private VBatalla vista = new VBatalla();
    private Random random;

    public CSaiyajin(Saiyajin guerrero1, Saiyajin guerrero2, VBatalla vista) {
        this.guerrero1 = guerrero1;
        this.guerrero2 = guerrero2;
        this.vista = vista;
        this.random = new Random();
    }

    public void iniciarBatalla() {
        vista.mostrarBatalla("Empieza la batalla en");
        try {
            System.out.print("3...");
            Thread.sleep(1000);
            System.out.print("2...");
            Thread.sleep(1000);
            System.out.print("1...");
            Thread.sleep(1000);
            System.out.println("Go!!!\n");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 3; i++) {
            vista.mostrarBatalla("Round " + i + 1);

            if(random.nextBoolean()) {
                vista.mostrarBatalla(guerrero1.atacar());
                vista.mostrarBatalla(guerrero2.transformacion());
            } else {
                vista.mostrarBatalla(guerrero2.atacar());
                vista.mostrarBatalla(guerrero1.transformacion());
            }

            if(random.nextBoolean()) {
                vista.mostrarBatalla(guerrero1.ataqueEspecial());
            } else {
                vista.mostrarBatalla(guerrero2.ataqueEspecial());
            }
        }
        System.out.println("\nFin de la batalla!");
    }
}
