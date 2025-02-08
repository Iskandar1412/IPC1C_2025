package Modelo;

import Vista.VOrdenamiento;
import java.util.Arrays;

public class Bubble implements Ordenamiento {
    private int[] array;
    private VOrdenamiento vista;

    public Bubble(int[] array, VOrdenamiento vista) {
        this.array = array;
        this.vista = vista;
    }

    @Override
    public void run() {
        ordenar();
    }

    @Override
    public void ordenar() {
        vista.imprimir("Bubble Sort (Init)...");
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    vista.imprimir("Array (Bubble): " + Arrays.toString(array));
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        vista.imprimir("Bubble Sort (Ended): " + Arrays.toString(array));
    }
}
