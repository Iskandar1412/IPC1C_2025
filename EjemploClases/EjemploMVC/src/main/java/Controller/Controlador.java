package Controller;

import Model.Persona;
import Model.Profesion;
import View.Vista;

public class Controlador {
    private Persona persona; // Instanciamos un objeto de tipo Persona que hereda de Profesion
    private Vista vista; // Instanciamos objeto llamado vista de tipo vista

    // Constructor
    public Controlador(Persona persona, Vista vista) {
        this.persona = persona;
        this.vista = vista;
    }

    public void accionPersona() {
        vista.imprimir(persona.accionProfesion());
    }

    public void acciones() {
        if(persona instanceof Persona) {
            vista.imprimir(((Profesion) persona).accionProfesion());
        } else {
            vista.imprimir("No hay nada");
        }
    }
}
