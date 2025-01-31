/*
    // Compilar y ejecutar
        kotlinc <nombre>.kt -include-runtime -d <nombre>.jar
        java -jar <nombre>.jar

    // Ejecutar directamente (archivo.kts)
        kotlinc -script script.kts
            *
        kotlin script.kts

    // Otra forma ejecutar
        kotlinc main.kt
        kotlin MainKt // Es el nombre del archivo Class
*/

class Persona(private var nombre: String, private var edad: Int) {

    // Gets & Sets
    fun getNombre(): String = nombre
    fun setNombre(name: String) {
        nombre = name
    }

    fun getEdad(): Int = edad
    fun setEdad(year: Int) {
        if (year > 0) {
            edad = year
        } else {
            println("La edad no puede ser igual o menor a 0")
        }
    }

    // Imprimir Persona
    fun mostrarInfo() {
        println("------------------------------------")
        println("Persona")
        println("Nombre: $nombre, Edad: $edad")
        println("------------------------------------")
    }
}

fun main() {
    // Crear Instancia
    val persona = Persona("Jose", 25)

    // Acceso a Atributos
    println("Nombre inicial: ${persona.getNombre()}")
    persona.setEdad(30)
    persona.setNombre("Pablo")

    // Impresión información
    persona.mostrarInfo()

    // Asignación de edad (no valida)
    persona.setEdad(-5)
    println("Edad: ${persona.getEdad()}")
}
