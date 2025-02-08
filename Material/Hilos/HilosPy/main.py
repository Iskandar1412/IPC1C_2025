import threading
import time

def imprimirArreglo(texto, arreglo):
    print(f"{texto}: {arreglo}")

# Bubble sort
def bubble(array):
    print("Bubble Sort (Started)...")
    for i in range(len(array) - 1):
        for j in range(len(array) - 1 - i):
            if array[j] > array[j + 1]:
                array[j], array[j + 1] = array[j + 1], array[j]
                imprimirArreglo("Array (Bubble)", array)
            time.sleep(0.5)
    print(f"Bubble Sort (Ended): {array}")

# Selection Sort
def selection(array):
    print("Selection Sort (Started)...")
    for i in range(len(array) - 1):
        min_index = i
        for j in range(i + 1, len(array)):
            if array[j] < array[min_index]:
                min_index = j
        if min_index != i:
            array[i], array[min_index] = array[min_index], array[i]
            imprimirArreglo("Array (Selection)", array)
        time.sleep(0.5)
    print(f"Selection Sort (Ended): {array}")

def main():
    array1 = [64, 34, 25, 12, 22, 11, 90]
    array2 = [64, 34, 25, 12, 22, 11, 90]

    # Creación hilos
    thread1 = threading.Thread(target=bubble, args=(array1,))
    thread2 = threading.Thread(target=selection, args=(array2,))

    # Correr hilos
    thread1.start()
    thread2.start()

    # Esperar a que terminen
    thread1.join()
    thread2.join()

    print("Programa Finalizado")

if __name__ == "__main__":
    main()