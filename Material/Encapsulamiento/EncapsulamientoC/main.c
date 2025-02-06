#include <stdio.h>
#include <string.h>

// Estructura de persona
typedef struct {
    char nombre[50];
    int edad;
} Persona;

// Constructor simulado
void crearPersona(Persona *persona, const char *nombre, int edad) {
    strncpy(persona->nombre, nombre, sizeof(persona->nombre) - 1);
    persona->nombre[sizeof(persona->nombre) - 1] = '\0';
    if (edad > 0) {
        persona->edad = edad;
    } else {
        printf("La edad no puede ser igual o menor a 0\n");
    }
}

// Método para obtener el nombre
const char* getNombre(const Persona *persona) {
    return persona->nombre;
}

// Método para establecer nombre
void setNombre(Persona *persona, const char *nombre) {
    strncpy(persona->nombre, nombre, sizeof(persona->nombre) - 1);
    persona->nombre[sizeof(persona->nombre) - 1] = '\0';
}

// Método para obtener edad
int getEdad(const Persona *persona) {
    return persona->edad;
}

// Método para dar edad
void setEdad(Persona *persona, int edad) {
    if (edad > 0) {
        persona->edad = edad;
    } else {
        printf("La edad no puede ser igual o menor a 0\n");
    }
}

// Método para impresión de información
void infoPersona(const Persona *persona) {
    printf("------------------------------------\n");
    printf("Persona\n");
    printf("Nombre: %s, Edad: %d\n", persona->nombre, persona->edad);
    printf("------------------------------------\n");
}

int main() {
    // Creamos una instancia de persona
    Persona persona;
    crearPersona(&persona, "Mario", 25);
    infoPersona(&persona);

    // Acceso a atributos de persona
    setEdad(&persona, 30);
    setNombre(&persona, "Carlos");

    // Impresion persona
    infoPersona(&persona);

    // Asignar edad no valida
    setEdad(&persona, -5);
    infoPersona(&persona);

    return 0;
}