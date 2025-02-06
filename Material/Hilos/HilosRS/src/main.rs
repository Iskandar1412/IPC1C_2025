use std::sync::{Arc, Mutex};
use std::thread;
use std::time::Duration;

// Impresión
fn imprimir_array(texto: &str, array: &[i32]) {
    print!("{}: [", texto);
    for (i, &value) in array.iter().enumerate() {
        print!("{}", value);
        if i < array.len() - 1 {
            print!(", ");
        }
    }
    println!("]");
}

// Bubble Sort
fn bubble(array: Arc<Mutex<Vec<i32>>>) {
    println!("Bubble Sort (Started)...");
    let mut sorted = false;
    while !sorted {
        sorted = true;
        let mut arr = array.lock().unwrap();
        for i in 0..arr.len() - 1 {
            if arr[i] > arr[i + 1] {
                arr.swap(i, i + 1);
                sorted = false;
                imprimir_array("Array (Bubble)", &arr);
            }
        }
        thread::sleep(Duration::from_millis(500)); // Dormir 500 ms
    }
    println!("Bubble Sort (Ended): {:?}", array.lock().unwrap());
}

// Selection Sort
fn selection(array: Arc<Mutex<Vec<i32>>>) {
    println!("Selection Sort (Started)...");
    let mut arr = array.lock().unwrap();
    for i in 0..arr.len() - 1 {
        let mut min_index = i;
        for j in i + 1..arr.len() {
            if arr[j] < arr[min_index] {
                min_index = j;
            }
        }
        if min_index != i {
            arr.swap(i, min_index);
            imprimir_array("Array (Selection)", &arr);
        }
        thread::sleep(Duration::from_millis(500)); // Dormir 500 ms
    }
    println!("Selection Sort (Ended): {:?}", arr);
}

fn main() {
    let array1 = Arc::new(Mutex::new(vec![64, 34, 25, 12, 22, 11, 90]));
    let array2 = Arc::new(Mutex::new(vec![64, 34, 25, 12, 22, 11, 90]));

    // Creación de hilos
    let bubble1 = Arc::clone(&array1);
    let selection1 = Arc::clone(&array2);
    let handle1 = thread::spawn(move || bubble(bubble1));
    let handle2 = thread::spawn(move || selection(selection1));

    // Esperar a que los hilos terminen
    handle1.join().unwrap();
    handle2.join().unwrap();

    println!("Programa Finalizado");
}