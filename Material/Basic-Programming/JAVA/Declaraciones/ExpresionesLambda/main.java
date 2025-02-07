@FunctionalInterface
interface Operaciones {
    int operar(int a, int b);
}

public class main {
    public static void main(String[] args) {
        Operaciones suma = (a, b) -> a + b;
        System.out.println(suma.operar(12, 15));
    }
}
