package main

import (
	"fmt"
)

// Interfaz
type Saiyajin interface {
	Atacar()
	Transformarse()
	AtaqueEspecial()
	GetNombre() string
	GetNivelPoder() int
}

// Estructura base
type BaseSaiyajin struct {
	nombre     string
	nivelPoder int
}

func (s *BaseSaiyajin) Atacar() {
	fmt.Println(s.nombre, "golpea con sus puños")
}

func (s *BaseSaiyajin) GetNombre() string {
	return s.nombre
}

func (s *BaseSaiyajin) GetNivelPoder() int {
	return s.nivelPoder
}

// Goku
type Goku struct {
	BaseSaiyajin
}

func InvocarGoku() *Goku {
	return &Goku{
		BaseSaiyajin: BaseSaiyajin{
			nombre:     "Goku",
			nivelPoder: 9000,
		},
	}
}

func (g *Goku) Transformarse() {
	fmt.Println(g.nombre, "se transforma en Super Saiyajin Fase 3!")
	g.nivelPoder *= 50
}

func (g *Goku) AtaqueEspecial() {
	fmt.Println(g.nombre, "lanza un Kamehameha!")
}

// Vegeta
type Vegeta struct {
	BaseSaiyajin
}

func InvocarVegeta() *Vegeta {
	return &Vegeta{
		BaseSaiyajin: BaseSaiyajin{
			nombre:     "Vegeta",
			nivelPoder: 8500,
		},
	}
}

func (v *Vegeta) Transformarse() {
	fmt.Println(v.nombre, "se transforma en Super Saiyajin Fase 2!")
	v.nivelPoder *= 45
}

func (v *Vegeta) AtaqueEspecial() {
	fmt.Println(v.nombre, "lanza un ataque de Brillo Final!")
}

// Broly
type Broly struct {
	BaseSaiyajin
}

func InvocarBroly() *Broly {
	return &Broly{
		BaseSaiyajin: BaseSaiyajin{
			nombre:     "Broly",
			nivelPoder: 12000,
		},
	}
}

func (b *Broly) Transformarse() {
	fmt.Println(b.nombre, "se transforma en Super Saiyajin Legendario!")
	b.nivelPoder *= 70
}

func (b *Broly) AtaqueEspecial() {
	fmt.Println(b.nombre, "lanza una Erupción Omega!")
}

func main() {
	// Creación de instancias
	goku := InvocarGoku()
	vegeta := InvocarVegeta()
	broly := InvocarBroly()

	// Arreglo (polimorfismo)
	guerreros := []Saiyajin{goku, vegeta, broly}

	fmt.Println("¡Comienza la batalla!")
	fmt.Println()

	for _, guerrero := range guerreros {
		fmt.Println(guerrero.GetNombre(), "entra en combate!")
		guerrero.Atacar()
		guerrero.Transformarse()
		guerrero.AtaqueEspecial()
		fmt.Printf("Nivel de poder actual de <<%s>>: %d\n\n", guerrero.GetNombre(), guerrero.GetNivelPoder())
	}

	fmt.Println("¡Fin del combate!")
}
