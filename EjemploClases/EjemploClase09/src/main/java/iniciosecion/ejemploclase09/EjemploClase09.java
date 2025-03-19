/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package iniciosecion.ejemploclase09;

import java.util.Arrays;

/**
 *
 * @author Pacos
 */

class QuickSort implements Runnable {
    private int[]Arreglo;
    
    // constructor 
    public QuickSort(int [] array) {
        this.Arreglo = array;
    }
    
    // hereda
    @Override
    public void run() {
        System.out.println("Iniciando QuickSort...");
        this.quick(Arreglo, 0, this.Arreglo.length - 1); // tamaño 14, 13 -> en caso doe que sea solo lenght da un error de index en arreglo
        System.out.println("Fin QuickSort: " + Arrays.toString(this.Arreglo));
    }
    
    
    public void quick(int[] array, int inicial, int ultimo) {
        if(inicial < ultimo) {
            int particion = this.dividirArreglo(array, inicial, ultimo);
            
            // Recursividad para los elementos después de la partición
            this.quick(array, inicial, particion - 1);
            this.quick(array, particion + 1, ultimo);
        }
    }
    
    private int dividirArreglo(int[] array, int inicial, int ultimo) {
        int pivote = array[ultimo];
        int i = (inicial - 1); // buscamos el índice
        
        for(int j = inicial; j < ultimo; j++) { // posiciones inicial = posición / final = otra posición
            if(array[j] <= pivote) {
                i++;
                
                // valor temporal el valor que vamos a reemplazar
                int temporal = array[i];
                array[i] = array[j];
                array[j] = temporal;
                
                System.out.println("Array (QuickSort): " + Arrays.toString(array));
            }
            
            try {
                Thread.sleep(1000); // 1 segundo para 
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        int temp = array[i + 1];
        array[i + 1] = array[ultimo];
        array[ultimo] = temp;
        
        System.out.println("Array (QuickSort): " + Arrays.toString(array));
        
        return i + 1;
    }
    
}

public class EjemploClase09 {

    public static void main(String[] args) {
        
        int []array = { 5, 10, 50, 1, 1000, 2, -2, 66, 44, 555, 1052, 4 };
        
        Thread hilo1 = new Thread(new QuickSort(array));
        
        hilo1.start();
        
        // Finalizar el hilo (Esperar a que finalice)
        try {
            hilo1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
