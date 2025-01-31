import kotlin.random.Random

interface Guerrero {
    fun atacar()
    fun defender()
    fun habilidadEspecial()
}

class Kratos: Guerrero {
    private val nombre = "Kratos"

    override fun atacar() {
        println("$nombre ataca con las Espadas del Caos!")
    }

    override fun defender() {
        println("$nombre bloquea con el Escudo Guardián!")
    }

    override fun habilidadEspecial() {
        println("$nombre usa la Ira Espartana!")
    }
}

class Atreus: Guerrero {
    private val nombre = "Atreus"

    override fun atacar() {
        println("$nombre dispara una flecha mágica!")
    }

    override fun defender() {
        println("$nombre esquiva ágilmente!")
    }

    override fun habilidadEspecial() {
        println("$nombre invoca a los lobos espirituales!")
    }
}

class Thor: Guerrero {
    private val nombre = "Thor"

    override fun atacar() {
        println("$nombre lanza Mjölnir con furia!")
    }

    override fun defender() {
        println("$nombre se protege con su enorme resistencia divina!")
    }

    override fun habilidadEspecial() {
        println("$nombre desata una tormenta de rayos!")
    }
}

class Batalla(private val guerrero1: Guerrero, private val guerrero2: Guerrero) {
    private val random = Random

    fun iniciarCombate() {
        println("\n¡COMIENZA LA BATALLA!")

        repeat(3) { ronda ->
            println("\nRONDA ${ronda + 1}")

            if (random.nextBoolean()) {
                guerrero1.atacar()
                guerrero2.defender()
            } else {
                guerrero2.atacar()
                guerrero1.defender()
            }

            if (random.nextBoolean()) {
                guerrero1.habilidadEspecial()
            } else {
                guerrero2.habilidadEspecial()
            }
        }

        println("\n¡LA BATALLA HA TERMINADO!")
    }
}

fun main() {
    // Instancia Kratos vs Thor
    val batalla1 = Batalla(Kratos(), Thor())
    batalla1.iniciarCombate()

    println("\n==============================\n")

    // Instancia Atreus vs Thor
    val batalla2 = Batalla(Atreus(), Thor())
    batalla2.iniciarCombate()
}