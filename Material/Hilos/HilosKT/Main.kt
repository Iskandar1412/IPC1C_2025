import java.util.Arrays

// Bubble Sort
class Bubble(private val array: IntArray) : Runnable {
    override fun run() {
        println("Bubble Sort Started...")
        for (i in 0 until array.size - 1) {
            for (j in 0 until array.size - 1 - i) {
                if (array[j] > array[j + 1]) {
                    val temp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = temp
                    println("Array (Bubble): ${Arrays.toString(array)}")
                }
                Thread.sleep(500) // Pausa de 500ms
            }
        }
        println("Bubble Sort Completed: ${Arrays.toString(array)}")
    }
}

// Selection Sort
class Selection(private val array: IntArray) : Runnable {
    override fun run() {
        println("Selection Sort Started...")
        for (i in 0 until array.size - 1) {
            var minIndex = i
            for (j in i + 1 until array.size) {
                if (array[j] < array[minIndex]) {
                    minIndex = j
                }
            }
            if (minIndex != i) {
                val temp = array[minIndex]
                array[minIndex] = array[i]
                array[i] = temp
                println("Array (Selection): ${Arrays.toString(array)}")
            }
            Thread.sleep(500) // Pausa de 500ms
        }
        println("Selection Sort Completed: ${Arrays.toString(array)}")
    }
}

fun main() {
    val array1 = intArrayOf(64, 34, 25, 12, 22, 11, 90)
    val array2 = intArrayOf(64, 34, 25, 12, 22, 11, 90)

    // Creación de hilos
    val thread1 = Thread(Bubble(array1))
    val thread2 = Thread(Selection(array2))

    // Iniciar los hilos
    thread1.start()
    thread2.start()

    // Esperar a que los hilos terminen
    thread1.join()
    thread2.join()

    println("Programa Finalizado")
}
