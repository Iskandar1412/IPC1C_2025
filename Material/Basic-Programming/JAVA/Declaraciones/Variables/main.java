public class main {
    public static void main(String[] args) {
        // variables primitivas
        byte b = 123; 
        short s = 32546;
        int i = 2147483647;
        long l = 9223372036854775807L;

        float f = 3.14f;
        double d = 3.14159;

        char c = 'A';
        char c2 = '\0';
        boolean bool = true;

        System.out.println("b: " + b + ", s: " + s + ", i: " + i + ", l: " + l);
        System.out.println("f: " + f + ", d: " +  d);
        System.out.println("c: " + c + ", c2: " + c2 + ", bool: " + bool);

        // Variables de referencia
        String nombre = "jose";
        Integer numero = 25;
        Double precio = 19.99;
        Boolean booleano = false;

        System.out.println("nombre: " + nombre + ", numero: " + numero + ", precio: " + precio + ", booleano: " + booleano);

        // Constantes
        final int MAXIMO = 100;
        final String MENSAJE = "HOLA";
        System.out.println("MAXIMO: " + MAXIMO + ", MENSAJE: " + MENSAJE);
    }
}