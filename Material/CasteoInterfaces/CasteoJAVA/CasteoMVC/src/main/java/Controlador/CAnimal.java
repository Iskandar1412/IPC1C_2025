package Controlador;

import Modelo.Animal;
import Vista.VAnimmal;

public class CAnimal {
    private Animal modelo; // Modelo
    private VAnimmal vista; // Vista

    public CAnimal(Animal modelo, VAnimmal vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void emitirSonidoAnimal() {
        vista.sonidoAnimal(this.modelo.sonido());
    }
}
