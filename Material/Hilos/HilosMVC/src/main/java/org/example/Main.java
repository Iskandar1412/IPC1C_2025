package org.example;

import Controlador.COrdenamiento;
import Modelo.Bubble;
import Modelo.Selection;
import Vista.VOrdenamiento;

public class Main {
    public static void main(String[] args) {
        VOrdenamiento vista = new VOrdenamiento(); // Crear vista

        // Arreglos
        int[] arreglo1 = {100, 25, 21, 1, 64, 50, 44, 62, 2, 66, 3, 122, 6};
        int[] arreglo2 = {100, 25, 21, 1, 64, 50, 44, 62, 2, 66, 3, 122, 6};

        // Crear controladores
        COrdenamiento bubble = new COrdenamiento(new Bubble(arreglo1, vista), vista);
        COrdenamiento select = new COrdenamiento(new Selection(arreglo2, vista), vista);

        // Inicio de hilos
        bubble.init();
        select.init();

        // Esperar a que terminen hilos
        bubble.toEnd();
        select.toEnd();

        vista.imprimir("End Program");
    }
}