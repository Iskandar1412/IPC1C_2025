import java.util.Arrays;

// Bubble Sort
class Bubble implements Runnable {
    private int[] array;

    public Bubble(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        System.out.println("Bubble Sort Started...");
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                // System.out.println(array[j] + " ... " + array[j + 1]);
                if (array[j] > array[j + 1]) {
                    // System.out.println(array[j] + " <-> " + array[j + 1]);
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                System.out.println("Array (Bubble): " + Arrays.toString(array));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Bubble Sort Completed: " + Arrays.toString(array));
    }
}

// Selection Sort
class Selection implements Runnable {
    private int[] array;

    public Selection(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        System.out.println("Selection Sort Started...");
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                // System.out.println(array[minIndex] + " ... " + array[j]);
                if (array[j] < array[minIndex]) {
                    // System.out.println(array[j] + " < " + array[minIndex]);
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                // System.out.println(array[i] + " <-> " + array[minIndex]);
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
            System.out.println("Array (Selection): " + Arrays.toString(array));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Selection Sort Completed: " + Arrays.toString(array));
    }
}

public class Main {
    public static void main(String[] args) {
        // Arrays
        int[] array1 = {64, 34, 25, 12, 22, 11, 90};
        int[] array2 = {64, 34, 25, 12, 22, 11, 90};

        // Creación de hilos
        Thread trhead1 = new Thread(new Bubble(array1));
        Thread trhead2 = new Thread(new Selection(array2));

        // Iniciar los hilos
        trhead1.start();
        trhead2.start();

        // Esperar a que los hilos terminen
        try {
            trhead1.join();
            trhead2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Programa Finalizado");
    }
}