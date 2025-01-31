package Controlador;

import Modelo.Persona;
import Vista.VPersona;

public class CPersona {
    private Persona modelo; // Modelo
    private VPersona vista; // Vista

    public CPersona(Persona modelo, VPersona vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void setNombre(String nombre) {
        modelo.setNombre(nombre);
    }

    public void setApellido(String apellido) {
        modelo.setApellido(apellido);
    }

    public void setEdad(int edad) {
        modelo.setEdad(edad);
    }

    public void mostrarPersona() {
        vista.mostrarPersona(modelo.getNombre(), modelo.getApellido(), modelo.getEdad());
    }
}
