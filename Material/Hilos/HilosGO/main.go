package main

import (
	"fmt"
	"time"
)

// Impresión data
func salidaArreglo(texto string, array []int) {
	fmt.Printf("%s: %v\n", texto, array)
}

func bubble(array []int, done chan bool) {
	fmt.Println("Bubble Sort (Started)...")
	for i := 0; i < len(array)-1; i++ {
		for j := 0; j < len(array)-1-i; j++ {
			if array[j] > array[j+1] {
				array[j], array[j+1] = array[j+1], array[j]
				salidaArreglo("Array (Bubble)", array)
			}
			time.Sleep(500 * time.Millisecond)
		}
	}
	fmt.Printf("Bubble Sort (Ended): %v\n", array)
	done <- true
}

func selection(array []int, done chan bool) {
	fmt.Println("Selection Sort (Started)...")
	for i := 0; i < len(array)-1; i++ {
		minIndex := i
		for j := i + 1; j < len(array); j++ {
			if array[j] < array[minIndex] {
				minIndex = j
			}
		}
		if minIndex != i {
			array[i], array[minIndex] = array[minIndex], array[i]
			salidaArreglo("Array (Selection)", array)
		}
		time.Sleep(500 * time.Millisecond)
	}
	fmt.Printf("Selection Sort (Ended): %v\n", array)
	done <- true
}

func main() {
	array1 := []int{164, 21, 5, 135, 2, 0, 546, 110, 1}
	array2 := []int{164, 21, 5, 135, 2, 0, 546, 110, 1}

	// Sincronización de go routines (canales)
	done := make(chan bool)

	// Iniciamos go routines
	go bubble(array1, done)
	go selection(array2, done)

	// Esperar a que terminen go routines
	<-done
	<-done

	fmt.Println("Programa Finalizado")
}
