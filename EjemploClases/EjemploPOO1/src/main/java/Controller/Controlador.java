package Controller;

import Model.Usuario;
import View.Vista;

public class Controlador {
    private Vista vista;
    private Usuario usuario; // instanciamos usuarios
    // ¿Por qué no instanciamos Cuentas? porque ya están instaciadas desde el vector
    // solo piden valores String (metodo)

    // Creamos constructor para asignar valores
    public Controlador(Vista vista, Usuario usuario) {
        this.vista = vista;
        this.usuario = usuario;
    }

    // Con nuestro modelo asignamos valores
    public void CrearUsuario(String nombre, String idUsuario, String apellido, String correo, String cui) {
        Usuario auxiliar = new Usuario(nombre, idUsuario, apellido, correo, cui);
        this.usuario = auxiliar;
    }

    // Crearemos cuenta para usuario
    public void CrearCuenta(String idCuenta, String tipoCuenta) {
        usuario.agregarCuenta(idCuenta, tipoCuenta);
    }

    // Utilizamos la vista para el envio de la información
    public void MostrarInformacion(){
        vista.Imprimir(usuario.usuarioYCuentas());
    }
}
