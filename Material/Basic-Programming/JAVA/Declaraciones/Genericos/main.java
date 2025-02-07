class Caja<T> {
    private T contenido;

    public Caja(T contenido) {
        this.contenido = contenido;
    }

    public T getContenido() {
        return contenido;
    }
}


public class main {
    public static void main(String[] args) {
        Caja<String> caja = new Caja<>("Hola Mundo");
        System.out.println(caja.getContenido());

    }    
}
