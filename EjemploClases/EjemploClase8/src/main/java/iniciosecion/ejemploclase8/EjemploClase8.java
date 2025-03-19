/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package iniciosecion.ejemploclase8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Pacos
 */
public class EjemploClase8 {
    public final String PATH = System.getProperty("user.dir"); //obtenemos la carpeta raiz
    public String PATH_CARPETA; // Tendrá la ruta final
    
    public static void main(String[] args) {
        // Fibonacci
        EjemploClase8 main = new EjemploClase8();
        int fib = 21;
        System.out.println("Metodo de Fibonacci con n: " + fib);
        System.out.println("El valor es: " + main.fibonacci(fib));
        
        String cadena = "hola mundo";
        System.out.println("inversion de cadena: " + cadena);
        System.out.println("Resultado: " + main.invertirCadena(cadena));
        
        // Creación del archivo
        main.crearArchivo("ejemplo");
        main.lecturaArchivo("ejemplo.txt");
    }
    
    public int fibonacci(int n) {
        if(n <= 1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
    
    public String invertirCadena(String str) {
        if(str.isEmpty()) return str;
        return invertirCadena(str.substring(1)) + str.charAt(0);
    }
    
    public void crearArchivo(String nombre) {
        File carpeta = new File(this.PATH, "/archivos");
        if(carpeta.exists()) System.out.println("La carpeta ya existe");
        this.PATH_CARPETA = carpeta.getAbsolutePath();
        if(carpeta.mkdir()) {
            System.out.println("Carpeta creada" + carpeta.getAbsolutePath());
        } else {  // esto es porque ya existe la carpeta    /archivos/capreta2
            System.out.println("Error al crear la carpeta");
        }
        
        // Creación de archivo
        try {
            String temp;
            // no tengamos extensión de archivo (.csv)
            if(!nombre.isEmpty()) {
                String nombreArchivo = nombre;
                if(!nombreArchivo.toLowerCase().endsWith(".txt")) {
                    nombre = nombre + ".txt";
                    temp = nombre + ".txt"; // no es necesario ya que se sobreescribio nombre
                }
                
                String PathArchivo = this.PATH_CARPETA + "/" + nombre;
                File archivoSalida = new File(PathArchivo); // archivo con extensión
                if(archivoSalida.isFile()) { // situación en la que ya exista el archivo
                    System.out.println("El archivo ya existe");
                    return;
                }
                if(archivoSalida.createNewFile()) {
                    System.out.println("Archivo Creado: " + archivoSalida.getAbsolutePath());
                } else {
                    System.out.println("Error");
                    throw new Error("Error en la creación del archivo");
                }
            } else {
                throw new Error("Nombre de la carpeta vacio");
            }
        } catch(IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    
    
    public void lecturaArchivo(String nombre) {
        try (BufferedReader buffer = new BufferedReader(new FileReader(this.PATH_CARPETA + "/" + nombre))) {
            String linea; // string en el que se le va a asignar cada linea del archivo
            
            while((linea = buffer.readLine()) != null) {
                System.out.println(linea);
            }
        } catch(IOException e) {
            System.out.println("Error en la lectura del archivo");
            e.printStackTrace();
        }
    }
    /*
    if (condicion) {
        tarea 1
        tarea 2
        tarea 3
        ...
        tarea n
    }
    
    if (condicion) {
        tarea 1 // serria return
    }
    
    if (condicion) tarea 1; //solo se ejecuta esa tarea
    tarea 
    tarea 2
        
        es equivalente a
    
    if () {
        tarea 1
    }
    tarea
    tarea 2
    
    */
}
