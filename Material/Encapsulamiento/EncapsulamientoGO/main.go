// go run <nombre_archivo>.go
package main

import (
	"fmt"
)

// Estructura persona
type Persona struct {
	nombre string
	edad   int
}

// Constructor Persona
func crearPersona(nombre string, edad int) *Persona {
	if edad <= 0 {
		fmt.Println("La edad no puede ser igual o menor a 0")
		edad = 1
	}
	return &Persona{nombre: nombre, edad: edad}
}

// Método obtención nombre
func (p *Persona) GetNombre() string {
	return p.nombre
}

// Método modificar nombre
func (p *Persona) SetNombre(nombre string) {
	p.nombre = nombre
}

// Método obtener edad
func (p *Persona) GetEdad() int {
	return p.edad
}

// Método modificar edad
func (p *Persona) SetEdad(edad int) {
	if edad > 0 {
		p.edad = edad
	} else {
		fmt.Println("La edad no puede ser igual o menor a 0")
	}
}

// Método impresió persona
func (p *Persona) MostrarInfo() {
	fmt.Println("------------------------------------")
	fmt.Println("Persona")
	fmt.Printf("Nombre: %s, Edad: %d\n", p.nombre, p.edad)
	fmt.Println("------------------------------------")
}

func main() {
	// Crear instancia de persona
	persona := crearPersona("Jose", 25)
	persona.MostrarInfo()

	// Modificar datos
	persona.SetEdad(30)
	persona.SetNombre("Pablo")

	// Mostrar información
	persona.MostrarInfo()

	// Asignar edad no valida
	persona.SetEdad(-5)
	persona.MostrarInfo()
}
