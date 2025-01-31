package Controlador;

import Modelo.Guerrero;
import Vista.VBatalla;

public class CBatalla {
    // Modelos
    private Guerrero guerrero1;
    private Guerrero guerrero2;

    // Vista
    private VBatalla vista;

    public CBatalla(Guerrero guerrero1, Guerrero guerrero2, VBatalla vista) {
        this.guerrero1 = guerrero1;
        this.guerrero2 = guerrero2;
        this.vista = vista;
    }

    public void iniciarCombate() {
        vista.mostrarBatalla("La batalla empieza!");

        // Movimientos
        guerrero1.atacar();
        guerrero2.defender();

        guerrero2.atacar();
        guerrero1.defender();

        guerrero1.habilidadEspecial();
        guerrero2.habilidadEspecial();

        vista.mostrarBatalla("Batalla finalizada");
    }
}
