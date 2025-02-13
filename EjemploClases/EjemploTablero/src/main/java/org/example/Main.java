package org.example;
import java.util.Random;
import java.util.Scanner;

// Tablero
// Menu Inicio de Seción Usuario, Salir de seción
// Variable local -> usuario
public class Main {
    private static String usuario_logeado;
    private static final int LONGITUD = 20;
    public static char tablero[][] = new char[LONGITUD][LONGITUD];
    public Scanner entrada = new Scanner(System.in);
    public static Scanner entradaEstatica = new Scanner(System.in);
    public static String[] diccionario = new String[50];

    public static void main(String[] args) {
        Main inicio = new Main(); // instanciamos nuestra clase
        inicio.InicioUsuario(); // En caso de no usar metodos estáticos
        // InicioUsuario();
    }

    public void InicioUsuario() {
        while (true) {
            String usuario;
            System.out.println("Inicio de Seción");
            System.out.print("Ingrese su usuario: ");
            usuario = entrada.nextLine();
            if (!usuario.isEmpty()) {
                usuario_logeado = usuario;
                MenuInicioSecion();
            }
        }
    }

    public static void MenuInicioSecion() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("Menu de Opciones");
            System.out.println("1. Ingresar Palabras");
            System.out.println("2. Mostrar Tablero");
            System.out.println("3. Salir");
            int opcion;
            System.out.print("Seleccione opción (valores numericos): ");
            opcion = entradaEstatica.nextInt();
            switch (opcion) {
                case 1:
                    agregarPalabras();
                    break;
                case 2:
                    imprimirTablero();
                    break;
                case 3:
                    System.out.println("saliendo del menu");
                    continuar = false;
                    break;
                default:
                    System.err.println("Error en la opción");
            }
        }
    }

    public static void agregarPalabras() {
        System.out.println("Menu Ingreso palabras");
        int palabras;
        System.out.print("Cuantas palabras desea ingresar: ");
        palabras = entradaEstatica.nextInt();
        entradaEstatica.nextLine(); // Limpiamos buffer
        int iteraciones = 0;
        while(iteraciones < palabras) {
            String palabra;
            System.out.print("Ingrese palabra entre 5 y 12 caracteres -> ");
            palabra = entradaEstatica.nextLine();
            if (palabra.length() > 4 && palabra.length() < 13) {
                for (int i = 0; i < diccionario.length; i++) {
                    if (diccionario[i] == null) {
                        diccionario[i] = palabra.toUpperCase();
                        break;
                    }
                }
            }
            iteraciones++;
        }

        Random random = new Random();
        agregarPalabrasTablero(random);
        llenarTablero(random);
    }

    public static void agregarPalabrasTablero(Random random) {
        for (String palabra: diccionario) {
            if (palabra == null) continue;

            boolean palabraAgregada = false;
            while(!palabraAgregada) { // En caso que no se haya agregado la palabra
                int fila = random.nextInt(LONGITUD);
                int columna = random.nextInt(LONGITUD);
                boolean horizontal = random.nextBoolean();

                if(horizontal && columna + palabra.length() <= LONGITUD) {
                    boolean espacioLibre = true;
                    for (int i = 0; i < palabra.length(); i++) {
                        if(tablero[fila][columna] != '\u0000' && tablero[fila][columna + i] != palabra.charAt(i)) {
                            espacioLibre = false;
                            break;
                        }
                    }

                    if(espacioLibre) {
                        for(int i = 0; i < palabra.length(); i++) {
                            tablero[fila][columna + i] = palabra.charAt(i);
                        }
                        palabraAgregada = true;
                    }
                } else if (!horizontal && fila + palabra.length() <= LONGITUD) {
                    boolean espacioLibre = true;
                    for (int i = 0; i < palabra.length(); i++) {
                        if(tablero[fila + i][columna] != '\u0000' && tablero[fila + i][columna] != palabra.charAt(i)) {
                            espacioLibre = false;
                            break;
                        }
                    }

                    if(espacioLibre) {
                        for(int i = 0; i < palabra.length(); i++) {
                            tablero[fila + i][columna] = palabra.charAt(i);
                        }
                        palabraAgregada = true;
                    }
                }
            }
        }
    }

    public static void llenarTablero(Random random) {
        for (int i = 0; i < LONGITUD; i++) {
            for(int j = 0; j < LONGITUD; j++) {
                if(tablero[i][j] == '\u0000') { // Verificamos que en la posición i y j del tablero haya un caracter nulo
                    tablero[i][j] = (char) ('A' + random.nextInt(26)); // Casteo para que elija una letra aleatoria
                }
            }
        }
    }

    public static void imprimirTablero() {
        System.out.println("Tablero");
        for(int i = 0; i < LONGITUD; i++) {
            for(int j = 0; j < LONGITUD; j++) {
                System.out.print(tablero[i][j] == '\u0000' ? '.' : tablero[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}