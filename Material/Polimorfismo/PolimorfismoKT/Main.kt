// Superclase abstracta     inmutable           mutable
abstract class Saiyajin(val nombre: String, var nivelPoder: Int) {
    // Método común
    fun atacar() {
        println("$nombre golpea con sus puños")
    }

    // Método abstracto (Cada clase lo implementará a su manera)
    abstract fun transformarse()

    // Método que puede ser sobrescrito
    open fun ataqueEspecial() {
        println("$nombre lanza una habilidad especial")
    }
}

// Subclase de Saiyajin
class Goku : Saiyajin("Goku", 9000) {
    override fun transformarse() {
        println("$nombre se transforma en Super Saiyajin Fase 3!")
        nivelPoder *= 50
    }

    override fun ataqueEspecial() {
        println("$nombre lanza un Kamehameha!")
    }
}

// Subclase de Saiyajin
class Vegeta : Saiyajin("Vegeta", 8500) {
    override fun transformarse() {
        println("$nombre se transforma en Super Saiyajin Fase 2!")
        nivelPoder *= 45
    }

    override fun ataqueEspecial() {
        println("$nombre lanza un ataque de Brillo Final!")
    }
}

// Subclase de Saiyajin
class Broly : Saiyajin("Broly", 12000) {
    override fun transformarse() {
        println("$nombre se transforma en Super Saiyajin Legendario!")
        nivelPoder *= 70
    }

    override fun ataqueEspecial() {
        println("$nombre lanza una Erupción Omega!")
    }
}

fun main() {
    // Polimorfismo: Se usa la referencia de la superclase para instanciar las subclases
    val guerreros: Array<Saiyajin> = arrayOf(Goku(), Vegeta(), Broly())

    println("¡Comienza la batalla!\n")

    for (guerrero in guerreros) {
        println("${guerrero.nombre} entra en combate!")
        guerrero.atacar()        // Método heredado
        guerrero.transformarse() // Cada personaje tiene su transformación
        guerrero.ataqueEspecial() // Cada personaje tiene un ataque especial diferente
        println("Nivel de poder actual de <<${guerrero.nombre}>>: ${guerrero.nivelPoder}\n")
    }

    println("¡Fin del combate!")
}
