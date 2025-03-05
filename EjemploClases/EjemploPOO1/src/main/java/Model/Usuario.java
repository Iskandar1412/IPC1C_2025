package Model;

public class Usuario {
    private String nombre;
    private String idUsuario;
    private String apellido;
    private String correo;
    private String cui;
    Cuentas [] cuentas = new Cuentas[4]; //almacenamos 4 cuentas

    // constructor que inicialize los valores
    public Usuario(String nombre, String idUsuario, String apellido, String correo, String cui) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.apellido = apellido;
        this.correo = correo;
        this.cui = cui;
        // no ponemos nuestro arreglo porque tendria que ser otro vector de 4 espacios
    }

    // Método para agregar cuenta
    // como no usamos el parametro de cuentas no es necesario instanciarlo en el controlador
    // public void agregar(Cuentas cuenta) {}
    // aqui solo pedimos valores que forman parte para la sobrecarga del constructor
    // Creamos un objeto de clase cuenta desde el método y lo asignamos en un espacio de nuestro vector cuenta
    public void agregarCuenta(String idCuenta, String tipoCuenta) {
        int i = 0; // contador (vector empieza en 0)
        while(true) {
            // en caso que se quiera agregar más cuentas de las permitidas
            if(i >= 4) {
                System.out.println("No se pueden agregar más cuentas");
                break;
            }
            // Verificamos que tenga cuentas
            // En caso que ya tenga datos la cuenta continua el ciclo
            if(cuentas[i] != null) {
                // no haremos nada
                //System.out.println("Espacio con cuenta existente");
                i++;
                continue;
            } else {
                // instanciamos variable auxiliar que tendrá la nueva cuenta
                Cuentas auxiliar = new Cuentas(idCuenta, tipoCuenta);
                // asignamos el valor en cuentas [i], auxiliar
                cuentas[i] = auxiliar;
                // forma 2 para asignar (mediante métodos)
                // cuentas[i].setIdCuenta(idCuenta);
                // cuentas[i].setTipoCuenta(tipoCuenta);
                break;
            }

        }
    }

    public String retornoCuentasUsuario() {
        String variable = "";
        for(int i = 0; i < cuentas.length; i++) {
            if(cuentas[i] != null) {
                variable += cuentas[i].retornoCuenta();
            }
        }
        return variable;
    }

    public String usuarioYCuentas() {
        return "usuario (" + this.nombre + ") id [" + this.idUsuario + "] --- \nCuentas: \n" + retornoCuentasUsuario();

    }
}
