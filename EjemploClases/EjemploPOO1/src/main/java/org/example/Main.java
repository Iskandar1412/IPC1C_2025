package org.example;

import Controller.Controlador;
import Model.Usuario;
import View.Vista;

public class Main {
    public static void main(String[] args) {
        // Instanciamos el modelo
        Usuario modelo = new Usuario("Jose", "Y2K", "Kaslem", "joseka@gmail", "3005544660101");
        Vista vista = new Vista(); // Instancia de vista

        // Instanciamos controlador
        Controlador controlador = new Controlador(vista, modelo);

        controlador.CrearCuenta("Y2K", "Ahorro");
        controlador.MostrarInformacion();
        controlador.CrearCuenta("K2", "Ahorro");
        controlador.CrearCuenta("K3", "Monetaria");
        controlador.CrearCuenta("K4", "Monetaria");
        controlador.MostrarInformacion();
        controlador.CrearCuenta("K5", "Monetaria");
        controlador.MostrarInformacion();
    }
}