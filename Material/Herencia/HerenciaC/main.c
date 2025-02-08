#include <stdio.h>
#include <string.h>

// En C no existe herencia pero se puede simular
// Estructura animal (superclase simulada)
typedef struct {
    char nombre[50];
} Animal;

// Constructor simulado para Animal
void crearAnimal(Animal *animal, const char *nombre) {
    strncpy(animal->nombre, nombre, sizeof(animal->nombre) - 1);
    animal->nombre[sizeof(animal->nombre) - 1] = '\0';
}

// Método común
void comer(const Animal *animal) {
    printf("%s [ocupado (está comiendo)]\n", animal->nombre);
}

// Estructura Subclases
typedef struct {
    Animal animal;
    char raza[50];
} Perro;

typedef struct {
    Animal animal;
    char raza[50];
} Gato;

// constructores
void crearPerro(Perro *perro, const char *nombre, const char *raza) {
    crearAnimal(&perro->animal, nombre);
    strncpy(perro->raza, raza, sizeof(perro->raza) - 1);
    perro->raza[sizeof(perro->raza) - 1] = '\0';
}

void crearGato(Gato *gato, const char *nombre, const char *raza) {
    crearAnimal(&gato->animal, nombre);
    strncpy(gato->raza, raza, sizeof(gato->raza) - 1);
    gato->raza[sizeof(gato->raza) - 1] = '\0';
}

// Métodos exclusivos de hijos
void ladrarPerro(const Perro *perro) {
    printf("%s está ladrando: ¡Raaaa!\n", perro->animal.nombre);
}

void ataqueGato(const Gato *gato) {
    printf("%s va a arañar\n", gato->animal.nombre);
}

// Sobreescritura comer
void comerPerro(const Perro *perro) {
    printf("%s (un %s) está comiendo\n", perro->animal.nombre, perro->raza);
}

void comerGato(const Gato *gato) {
    printf("%s (un %s) está comiendo\n", gato->animal.nombre, gato->raza);
}

int main() {
    // Crear instancia Animal
    Animal animal;
    crearAnimal(&animal, "Perry");
    comer(&animal);

    // Crear instancias animales
    Perro perro;
    Gato gato;
    crearPerro(&perro, "Arcanine", "Pokemon");
    crearGato(&gato, "Umbreon", "Pokemon");

    // Llamar métodos Animales
    comerPerro(&perro);
    ladrarPerro(&perro);
    comerGato(&gato);
    ataqueGato(&gato);

    return 0;
}