package org.example;

import Controlador.CPersona;
import Modelo.Persona;
import Vista.VPersona;

public class Main {
    public static void main(String[] args) {
        // Crear Modelo
        Persona modelo = new Persona("Marco", "Iglesias", 25);

        // Crear Vista
        VPersona vista = new VPersona();

        // Creación Controlador
        CPersona controlador = new CPersona(modelo, vista);

        // Mostrar persona
        controlador.mostrarPersona();

        // Modificación datos Persona
        controlador.setNombre("Kafka");
        controlador.setEdad(21);

        // Mostrar datos
        controlador.mostrarPersona();

        // Modificar a edad no disponible
        controlador.setEdad(0);
        controlador.mostrarPersona();
    }
}