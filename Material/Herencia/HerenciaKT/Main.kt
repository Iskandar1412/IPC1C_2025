// Superclase (open, hace que pueda ser heredada la clase u método)
open class Pokemon(val nombre: String) {
    open fun comer() {
        println("$nombre está comiendo tranquilamente")
    }
}

// Subclase que hereda de Pokemon
class tipoPokemon(nombre: String, val tipo: String): Pokemon(nombre) {
    fun sonidoPokemon() {
        println("$nombre está molesto, va a rugir ¡Raaaaaa!")
    }

    // Sobreescritura método comer
    override fun comer() {
        println("$nombre un pokemon tipo $tipo está comiendo detenidamente")
    }
}

fun main() {
    // Creación instancia
    val Slowpoke = Pokemon("Slowpoke")
    Slowpoke.comer()

    val Rayquaza = tipoPokemon("Rayquaza", "Dragon")
    Rayquaza.comer()
    Rayquaza.sonidoPokemon()
}