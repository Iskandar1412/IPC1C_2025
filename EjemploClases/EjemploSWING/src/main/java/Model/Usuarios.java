package Model;

abstract class Usuario {
    protected String nombre;
    protected String apellido;
    protected String correo;
    protected int telefono;
    protected int edad;

    public Usuario(String nombre, String apellido, String correo, int telefono, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.edad = edad;
    }

    public String getUsuario() {
        return nombre;
    }
}
