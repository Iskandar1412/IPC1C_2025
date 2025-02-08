package org.example;

import Controlador.CSaiyajin;
import Modelo.Broly;
import Modelo.Goku;
import Modelo.Vegeta;
import Vista.VBatalla;

public class Main {
    public static void main(String[] args) {
        VBatalla vista = new VBatalla(); // Vista

        // Controladores
        CSaiyajin batalla1 = new CSaiyajin(new Goku(), new Vegeta(), vista);
        CSaiyajin batalla2 = new CSaiyajin(new Goku(), new Broly(), vista);

        // Metodos controladores
        batalla1.iniciarBatalla();
        System.out.println("<--- --- --- --- --- --- --->");
        batalla2.iniciarBatalla();
    }
}