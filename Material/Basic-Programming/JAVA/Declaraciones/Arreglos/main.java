public class main {
    public static void main(String[] args) {
        // Array básico
        System.out.println("Array Básico");
        int[] numeros = {1, 2, 3, 4, 5};
        
        for(int num: numeros) {
            System.out.println(num);
        }
        // Array multidimensional
        System.out.println("Array Multidimensional");
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                System.out.println("i: [" + i + "] - j: [" + j + "]: (Value): " + matriz[i][j]);
            }
        }

        // Inicializar dinámicamente
        System.out.println("Inicialización Dinámica");
        int[] arreglo = new int[5];
        arreglo[0] = 5;
        arreglo[3] = 12; 
        int value_cero = 0;
        for(int enu: arreglo) {
            System.out.println("Arreglo[" + value_cero + "]: (" + enu + ")");
            value_cero++;
        }
    }   
}
