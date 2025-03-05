package Model;

public class Administrador extends Usuario {
    private String usuario;
    private String contrasena;

    public Administrador(String nombre, String apellido, String correo, int telefono, int edad, String usuario, String contrasena) {
        super(nombre, apellido, correo, telefono, edad);
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
}
