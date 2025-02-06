// gcc <programa>.c -o <programa>
// ./<programa>

#include <stdio.h>
#include <stdlib.h>

// estructura para Animal
typedef struct {
    // se crea un puntero para el sonido
    void (*sonidoAnimal)(void);
} Animal;

// implementación de SonidoAnimal en los animales
void Gato() {
    printf("Miau, soy un gato\n");
}

void Perro() {
    printf("Guaf, soy un perro\n");
}

int main() {
    // Creación de instancias para animales
    Animal gato = {.sonidoAnimal = Gato};
    Animal perro = {.sonidoAnimal = Perro};

    gato.sonidoAnimal();
    perro.sonidoAnimal();

    // Vector animales
    Animal animales[] = { gato, perro };
    int cantidad = sizeof(animales) / sizeof(animales[0]);

    for (int i = 0; i < cantidad; i++) {
        animales[i].sonidoAnimal();
    }

    return 0;
}