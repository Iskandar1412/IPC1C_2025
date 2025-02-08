package main

import (
	"fmt"
)

// Estructura padre
type Pokemon struct {
	Nombre string
}

// método padre
func (a *Pokemon) comer() {
	fmt.Println(a.Nombre, "está comiendo")
}

// Estructuras hijos
type TipoFuego struct {
	Pokemon
	Raza string
}

type TipoHielo struct {
	Pokemon
	Raza string
}

// Métodos exclusivos
func (tf *TipoFuego) atacar() {
	fmt.Println(tf.Nombre, "va a atacar, está muy furioso")
}

func (th *TipoHielo) habilidad() {
	fmt.Println(th.Nombre, "va a usar su habilidad de cristalización")
}

// Sobreescritura método
func (tf *TipoFuego) comer() {
	fmt.Println(tf.Nombre, "(un", tf.Raza, ") está comiendo lentamente")
}

func (tf *TipoHielo) comer() {
	fmt.Println(tf.Nombre, "(un", tf.Raza, ") come atentamente")
}

func main() {
	pokemon := Pokemon{Nombre: "Dolgera"}
	pokemon.comer()

	camerupt := TipoFuego{
		Pokemon: Pokemon{Nombre: "Camerupt"},
		Raza:    "¿Pokemon?",
	}

	regiice := TipoHielo{
		Pokemon: Pokemon{Nombre: "Regi Ice"},
		Raza:    "¿Pokemon?",
	}

	// llamada métodos
	camerupt.atacar()
	camerupt.comer()

	regiice.comer()
	regiice.habilidad()
}
