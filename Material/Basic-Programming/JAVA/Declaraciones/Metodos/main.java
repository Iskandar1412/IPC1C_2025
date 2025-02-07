class Ejemplo {
    // Métodos sin retorno
    public void Saludar() {
        System.out.println("Hola");
    }

    // Métodos con retorno
    public int sumar(int a, int b) {
        return a + b;
    }

    public String concatenar(String palabra1, String palabra2) {
        return palabra1 + palabra2;
    }

    // Métodos estáticos
    public static void imprimir(String mensaje) {
        System.out.println(mensaje);
    }

    // Métodos sobrecargados
    public int operar(int a, int b) {
        return a + b;
    }

    public int operar(int a, int b, int c) {
        return a + b + c;
    }

    // Métodos genéricos
    public <T> void mostrarMensaje(T elemento) {
        System.out.println(elemento);
    }
}

public class main {
    public static void main(String[] args) {
        Ejemplo ejemplo = new Ejemplo();

        ejemplo.Saludar();
        System.out.println(ejemplo.sumar(15, 12));
        System.out.println(ejemplo.concatenar("corta", "uñas"));
        ejemplo.imprimir("Mensaje");
        System.out.println(ejemplo.operar(2, 1));
        System.out.println(ejemplo.operar(2, 1, 5));
        ejemplo.mostrarMensaje(15);
    }
}
