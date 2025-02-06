package Controlador;

import Modelo.Ordenamiento;
import Vista.VOrdenamiento;

public class COrdenamiento {
    private Ordenamiento modelo; // Modelo
    private VOrdenamiento vista; // Vista
    private Thread hilo;

    public COrdenamiento(Ordenamiento modelo, VOrdenamiento vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.hilo = new Thread(modelo);
    }

    public void init() {
        vista.imprimir("Inicio de Ordenamiento...");
        hilo.start();
    }

    public void toEnd() {
        try {
            hilo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
