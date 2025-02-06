package main

// go run <nombre>.go

import "fmt"

// Interfaz animal
type Animal interface {
	SonidoAnimal()
}

// Estructura animales
type Gato struct{}
type Perro struct{}

// Implementación métodos animales
func (g Gato) SonidoAnimal() {
	fmt.Println("Miau, soy un gato")
}

func (p Perro) SonidoAnimal() {
	fmt.Println("Guauf, soy un perro")
}

func main() {
	// Upcasting: Asignar instancias animales variables tipo Animal
	var animal1 Animal = Gato{}
	var animal2 Animal = Perro{}

	// Downcasting explícito: Conversión a tipos originales
	gatito1 := animal1.(Gato)
	perrito1 := animal2.(Perro)

	// Método de animal
	gatito1.SonidoAnimal()
	perrito1.SonidoAnimal()
}
