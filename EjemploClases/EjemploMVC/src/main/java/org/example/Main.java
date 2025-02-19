package org.example;

import Controller.Controlador;
import Model.Persona;
import View.Vista;

public class Main {
    public static void main(String[] args) {
        Vista vista = new Vista(); // instanciamos vista

        // Utilizar los controladores
        Persona persona = new Persona("Estudiante", "Jose", 12);
        Controlador controlador = new Controlador(persona, vista);
        Persona persona2 = new Persona("Diputado", "Ezequia", 52);
        Controlador controlador2 = new Controlador(persona2, vista);

        // Utilizamos funciones del controlador
        controlador.accionPersona();
        controlador.acciones();

        // Persona2 en accion
        controlador2.accionPersona();
        controlador2.acciones();
    }
}