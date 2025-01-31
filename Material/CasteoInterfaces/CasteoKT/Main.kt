interface Animal {
    fun Sonido()
}

class Gato: Animal {
    override fun Sonido() {
        println("Miau, soy un gato")
    }
}

class Perro: Animal {
    override fun Sonido() {
        println("Guauf, soy un perro")
    }
}

class AnimalMisterioso: Animal {
    override fun Sonido() {
        println("Soy un animal misterioso")
    }
}

fun main() {
    // Upcasting implícito
    val animal1: Animal = Gato() 
    val animal2: Animal = Perro()
    val animal3: Animal = AnimalMisterioso()

    // Downcasting explícito
    val gato: Gato = animal1 as Gato
    val perro: Perro = animal2 as Perro
    val animalmisterioso: AnimalMisterioso = animal3 as AnimalMisterioso

    // Impresión métodos
    gato.Sonido()
    perro.Sonido()
    animalmisterioso.Sonido()
}