package main

import (
	"fmt"
	"math/rand"
	"time"
)

// Interfaz
type Guerrero interface {
	Atacar()
	Defender()
	HabilidadEspecial()
}

// Kratos
type Kratos struct{}

func (k Kratos) Atacar() {
	fmt.Println("Kratos ataca con las Espadas del Caos!")
}

func (k Kratos) Defender() {
	fmt.Println("Kratos bloquea con el Escudo Guardián!")
}

func (k Kratos) HabilidadEspecial() {
	fmt.Println("Kratos usa la Ira Espartana!")
}

// Atreus
type Atreus struct{}

func (a Atreus) Atacar() {
	fmt.Println("Atreus dispara una flecha mágica!")
}

func (a Atreus) Defender() {
	fmt.Println("Atreus esquiva ágilmente!")
}

func (a Atreus) HabilidadEspecial() {
	fmt.Println("Atreus invoca a los lobos espirituales!")
}

// Thor
type Thor struct{}

func (t Thor) Atacar() {
	fmt.Println("Thor lanza Mjölnir con furia!")
}

func (t Thor) Defender() {
	fmt.Println("Thor se protege con su enorme resistencia divina!")
}

func (t Thor) HabilidadEspecial() {
	fmt.Println("Thor desata una tormenta de rayos!")
}

type Batalla struct {
	guerrero1 Guerrero
	guerrero2 Guerrero
}

func (b *Batalla) IniciarCombate() {
	fmt.Println("\n¡COMIENZA LA BATALLA!")
	rand.Seed(time.Now().UnixNano())

	for i := 0; i < 3; i++ {
		fmt.Printf("\n--> RONDA %d\n", i+1)

		if rand.Intn(2) == 0 {
			b.guerrero1.Atacar()
			b.guerrero2.Defender()
		} else {
			b.guerrero2.Atacar()
			b.guerrero1.Defender()
		}

		if rand.Intn(2) == 0 {
			b.guerrero1.HabilidadEspecial()
		} else {
			b.guerrero2.HabilidadEspecial()
		}
	}

	fmt.Println("\n¡LA BATALLA HA TERMINADO!")
}

func main() {
	// Instancias de personajes
	kratos := Kratos{}
	thor := Thor{}
	atreus := Atreus{}

	// Kratos vs Thor
	batalla1 := Batalla{guerrero1: kratos, guerrero2: thor}
	batalla1.IniciarCombate()

	fmt.Println()
	fmt.Println("==============================")

	// Atreus vs Thor
	batalla2 := Batalla{guerrero1: atreus, guerrero2: thor}
	batalla2.IniciarCombate()
}
