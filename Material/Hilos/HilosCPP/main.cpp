#include <iostream>
#include <vector>
#include <thread>
#include <chrono>

using namespace std;

// Función impresión
void imprimirArray(const string &texto, const vector<int> &array) {
    cout << texto << ": [";
    for (size_t i = 0; i < array.size(); i++) {
        cout << array[i];
        if (i < array.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

// Bubble Sort
void bubbleS(vector<int> &array) {
    cout << "Bubble Sort (Started)..." << endl;

    for (size_t i = 0; i < array.size() - 1; i++) {
        for (size_t j = 0; j < array.size() - 1 - i; j++) {
            if (array[j] > array[j + 1]) {
                swap(array[j], array[j + 1]);
                imprimirArray("Array (Bubble)", array);
            }
            this_thread::sleep_for(chrono::milliseconds(500));
        }
    }

    cout << "Bubble Sort (Ended): ";
    imprimirArray("", array);
}

// Selection Sort
void selectionS(vector<int> &array) {
    cout << "Selection Sort (Started)..." << endl;

    for (size_t i = 0; i < array.size() - 1; i++) {
        size_t minIndex = i;
        for (size_t j = i + 1; j < array.size(); j++) {
            if (array[j] < array[minIndex]) {
                minIndex = j;
            }
        }
        if (minIndex != i) {
            swap(array[i], array[minIndex]);
            imprimirArray("Array (Selection)", array);
        }
        this_thread::sleep_for(chrono::milliseconds(500));
    }

    cout << "Selection Sort (Ended): ";
    imprimirArray("", array);
}

int main() {
    vector<int> array1 = {64, 34, 25, 12, 22, 11, 90};
    vector<int> array2 = {64, 34, 25, 12, 22, 11, 90};

    // Creamos los hilos
    thread thread1(bubbleS, ref(array1));
    thread thread2(selectionS, ref(array2));

    // Se espera a que terminen los hilos
    thread1.join();
    thread2.join();

    cout << "Programa Finalizado" << endl;
    return 0;
}