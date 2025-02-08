public class main {

    public static void main(String[] args) {
        // Hanoi
        int noDiscos = 3;
        char torreIzquierda = 'A';
        char torreCentral = 'C';
        char torreDerecha = 'B';

        System.out.println("Resolviendo las Torres de Hanoi para " + noDiscos + " discos:");
        hanoiFunction(noDiscos, torreIzquierda, torreCentral, torreDerecha);

        // Factorial
        System.out.println("Factorial");
        System.out.println(factorial(4));
        
        // Fibonacci
        System.out.println("Fibonacci");
        System.out.println(fibonacci(21));
        
        // Invertir cadena
        System.out.println("Invertir cadena");
        System.out.println(invertirCadena("hola mundo"));

        // Suma de elementos en un array
        System.out.println("Suma array");
        int [] arreglo = {12, 15, 13, 54};
        System.out.println(sumaArray(arreglo, arreglo.length));
    }

    // Torres de hannois
    public static void hanoiFunction(int n, char origen, char destino, char auxiliar) {
        if (n == 1) {
            System.out.println("[Disco 1] " + origen + " [a] " + destino);
            return;
        }

        hanoiFunction(n - 1, origen, auxiliar, destino);
        System.out.println("[Disco " + n + "] " + origen + " [a] " + destino);
        hanoiFunction(n - 1, auxiliar, destino, origen);
    }

    // Factorial
    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    // Fibonacci
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Inversión de cadena
    public static String invertirCadena(String str) {
        if (str.isEmpty()) return str;
        return invertirCadena(str.substring(1)) + str.charAt(0);
    }

    // Suma elementos de array
    public static int sumaArray(int[] arr, int n) {
        if (n == 0) return 0;
        return arr[n - 1] + sumaArray(arr, n - 1);
    }
}