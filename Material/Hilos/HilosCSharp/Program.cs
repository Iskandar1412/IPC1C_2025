using System;
using System.Threading;
using System.Threading.Tasks;

class Program {
    static void imprimirArreglo(string mensaje, int[]array) {
        Console.Write($"{mensaje}: [");
        for (int i = 0; i < array.Length; i++) {
            Console.Write(array[i]);
            if (i < array.Length - 1) Console.Write(", ");
        }
        Console.WriteLine("]");
    }

    // Bubble Sort
    static void Bubble(int[]array) {
        Console.WriteLine("Bubble Sort (Started)...");
        for (int i = 0; i < array.Length - 1; i++) {
            for (int j = 0; j < array.Length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    imprimirArreglo("Array (Bubble)", array);
                }
                Thread.Sleep(500);
            }
        }
        Console.WriteLine($"Bubble Sort (Ended): [{string.Join(", ", array)}]");
    }

    // Selection Sort
    static void Selection(int[] array) {
        Console.WriteLine("Selection Sort (Started)...");
        for (int i = 0; i < array.Length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.Length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
                imprimirArreglo("Array (Selection)", array);
            }
            Thread.Sleep(500);
        }
        Console.WriteLine($"Selection Sort (Ended): [{string.Join(", ", array)}]");
    }

    static async Task Main(string[] args) {
        int[] array1 = {544, 1, 25, 64, 32, 0, 2, 498, 122, 254};
        int[] array2 = {544, 1, 25, 64, 32, 0, 2, 498, 122, 254};

        // Creación hilos (tareas)
        Task task1 = Task.Run(() => Bubble(array1));
        Task task2 = Task.Run(() => Bubble(array2));

        // Esperar que finalicen tareas
        await Task.WhenAll(task1, task2);

        Console.WriteLine("Programa Finalizado");
    }
}