public class main {
    public static void main(String[] args) {
        // Condicionales
        int edad = 18;
        if (edad >= 18) {
            System.out.println("'Mayor de edad'");
        } else {
            System.out.println("Menor de edad");
        }

        int opcion = 2;
        switch (opcion) {
            case 1:
                System.out.println("Opcion 1");
                break;
            case 2:
                System.out.println("Opcion 2");
                break;
            default:
                System.out.println("Opcion no valida");
        }

        // Bucles
        for (int i = 0; i < 5; i++) {
            System.out.println("for en [" + i + "]");
        }

        int j = 0;
        while(j < 5) {
            System.out.println("J (Value): " + j);
            j++;
        }

        int k = 0;
        do {
            System.out.println("K (Value): " + k);
            k++;
        } while(k < 5);

        // Bucles
        int[] valores = {1, 2, 3, 4, 5};
        for (int valor: valores) {
            System.out.println("For-Each (Value-in-range): " + valor);
        }
    }   
}
