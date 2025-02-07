public class main {
    public static void main(String[] args) {
        System.out.println("With Static method");
        impresionV2(1, 5, 6, 8, 70, 12, 3);
        
        System.out.println("With non Static method");
        main impresiones = new main();
        impresiones.impresion(4, 6, 8, 7, 20, 10);
    }

    public void impresion(int... numeros) {
        for(int num: numeros) {
            System.out.println(num);
        }
    }

    public static void impresionV2(int... numeros) {
        for(int num: numeros) {
            System.out.println(num);
        }
    }
}
