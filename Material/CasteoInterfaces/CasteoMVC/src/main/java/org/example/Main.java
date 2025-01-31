package org.example;

import Controlador.CAnimal;
import Modelo.Animal;
import Modelo.Gato;
import Modelo.Perro;
import Vista.VAnimmal;

public class Main {
    public static void main(String[] args) {
        /*
        // Forma 1
        // Creación modelo
        Animal modelo = new Gato();

        // Creación vista
        VAnimmal vista = new VAnimmal();

        // Controlador
        CAnimal controlador = new CAnimal(modelo, vista);

        // LLamada al método del controlador para el sonido animal
        controlador.emitirSonidoAnimal();
         */

        // Forma 2
        // Creación Modelo
        VAnimmal vista = new VAnimmal();

        // Creación  controladores
        CAnimal gato = new CAnimal(new Gato(), vista);
        CAnimal perro = new CAnimal(new Perro(), vista);

        // Ejecución sonidos de animales
        gato.emitirSonidoAnimal();
        perro.emitirSonidoAnimal();
    }
}