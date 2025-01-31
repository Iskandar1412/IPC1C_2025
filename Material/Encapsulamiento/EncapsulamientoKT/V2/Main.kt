data class Persona(var nombre: String, var edad: Int) {

    // Validacón en edad
    var edadValida: Int = edad
        set(value) {
            field = if (value > 0) value else {
                println("La edad no puede ser igual o menor a 0")
                field
            }
        }

    init {
        edadValida = edad // Validaciones iniciales
    }

    // Médoto imprmir información
    fun mostrarInfo() {
        println("""
            ------------------------------------
            Persona
            Nombre: $nombre, Edad: $edadValida
            ------------------------------------
        """.trimIndent())
    }
}

fun main() {
    val persona = Persona("Jose", 25)

    // Acceso y modificación de atributos
    println("Nombre inicial: ${persona.nombre}")
    persona.edadValida = 30
    persona.nombre = "Pablo"

    // Imprimir información
    persona.mostrarInfo()

    // Asignación edad (no valida)
    persona.edadValida = -5
    println("Edad después de intento inválido: ${persona.edadValida}")
}
