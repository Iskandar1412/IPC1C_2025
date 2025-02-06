package Modelo;

import Vista.VOrdenamiento;
import java.util.Arrays;

public class Selection implements Ordenamiento {
    private int[] array;
    private VOrdenamiento vista;

    public Selection(int[] array, VOrdenamiento vista) {
        this.array = array;
        this.vista = vista;
    }

    @Override
    public void run() {
        ordenar();
    }

    @Override
    public void ordenar() {
        vista.imprimir("Selection Sort (Init)...");
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
                vista.imprimir("Array (Selection): " + Arrays.toString(array));
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        vista.imprimir("Selection Sort (Ended): " + Arrays.toString(array));
    }
}
