package Model;

public class Cuentas {
    private String idCuenta;
    private String tipoCuenta;

    // Constructor
    public Cuentas() {
        // se puede inicializar vacio
    }

    // Sobrecarga del constructor (sobrecargamos método)
    public Cuentas(String idCuenta, String tipoCuenta) {
        this.idCuenta = idCuenta;
        this.tipoCuenta = tipoCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    @Override
    public String toString() {
        return "idCuenta: " + this.idCuenta + "tipo: " + this.tipoCuenta;
    }

    public String retornoCuenta() {
        if (this.idCuenta.isEmpty() || this.tipoCuenta.isEmpty()) {
            return "No hay cuentas";
        }
        return "idCuenta: " + this.idCuenta + " - tipo: " + this.tipoCuenta + "\n";
    }

    public boolean tieneCuenta(){
        return !this.idCuenta.isEmpty() || !this.tipoCuenta.isEmpty();
    }
}
