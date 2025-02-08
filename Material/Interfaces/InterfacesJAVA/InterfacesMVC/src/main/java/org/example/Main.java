package org.example;

import Controlador.CBatalla;
import Modelo.Atreus;
import Modelo.Kratos;
import Modelo.Thor;
import Vista.VBatalla;

public class Main {
    public static void main(String[] args) {
        VBatalla vista = new VBatalla(); // Vista

        // Controladores
        CBatalla controlador1 = new CBatalla(new Kratos(), new Thor(), vista);
        controlador1.iniciarCombate();

        System.out.println("");
        System.out.println("");

        CBatalla controlador2 = new CBatalla(new Atreus(), new Kratos(), vista);
        controlador2.iniciarCombate();
    }
}