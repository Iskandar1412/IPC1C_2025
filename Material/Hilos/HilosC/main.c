#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

typedef struct {
    int *array;
    int size;
} ThreadData;

// Impresión de arreglo (función)
void imprimirArreglo(const char *message, int *array, int size) {
    printf("%s: [", message);
    for (int i = 0; i < size; i++) {
        printf("%d", array[i]);
        if (i < size - 1) printf(", ");
    }
    printf("]\n");
}

// Bubble Sort
void *bubbleS(void *arg) {
    ThreadData *data = (ThreadData *)arg;
    int *array = data->array;
    int size = data->size;

    printf("Bubble Sort (Started)...\n");

    for (int i = 0; i < size - 1; i++) {
        for (int j = 0; j < size - 1 - i; j++) {
            if (array[j] > array[j + 1]) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                imprimirArreglo("Array (Bubble)", array, size);
            }
            usleep(500000); // sleep
        }
    }

    // printf("Bubble Sort (Ended): ");
    imprimirArreglo("Bubble Sort (Ended)", array, size);
    return NULL;
}

// Selection Sort
void *selectionS(void *arg) {
    ThreadData *data = (ThreadData *)arg;
    // int *array = (int *)arg;
    int *array = data->array;
    int size = data->size;

    printf("Selection Sort (Started)...\n");

    for (int i = 0; i < size - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < size; j++) {
            if (array[j] < array[minIndex]) {
                minIndex = j;
            }
        }
        if (minIndex != i) {
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            imprimirArreglo("Array (Selection)", array, size);
        }
        usleep(500000); // sleep
    }

    // printf("Selection Sort (Ended): ");
    imprimirArreglo("Selection Sort (Ended)", array, size);
    return NULL;
}

int main() {
    int array1[] = {64, 34, 25, 12, 22, 11, 90};
    int array2[] = {64, 34, 25, 12, 22, 11, 90};

    ThreadData bubble = {array1, sizeof(array1)/sizeof(array1[0])};
    ThreadData select = {array2, sizeof(array2)/sizeof(array2[0])};

    // Crear hilos
    pthread_t thread1, thread2;

    // Iniciar los hilos
    pthread_create(&thread1, NULL, bubbleS, &bubble);
    pthread_create(&thread2, NULL, selectionS, &select);

    // Esperar a que los hilos terminen
    pthread_join(thread1, NULL);
    pthread_join(thread2, NULL);

    printf("Programa Finalizado\n");
    return 0;
}