#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Superclase (simulada cono struct con funciones)
typedef struct {
    char nombre[50];
    int nivelPoder;
    void (*atacar)(void *self);
    void (*transformarse)(void *self);
    void (*ataqueEspecial)(void *self);
} Saiyajin;

// Funciones comunes
void atacar(Saiyajin *self) {
    printf("%s golpea con sus puños\n", self->nombre);
}

// Goku
typedef struct {
    Saiyajin base; // Composición (simulación herencia)
} Goku;

void transformarseGoku(void *self) {
    Goku *goku = (Goku *)self;
    printf("%s se transforma en Super Saiyajin Fase 3!\n", goku->base.nombre);
    goku->base.nivelPoder *= 50;
}

void ataqueEspecialGoku(void *self) {
    Goku *goku = (Goku *)self;
    printf("%s lanza un Kamehameha!\n", goku->base.nombre);
}

Goku *crearGoku() {
    Goku *goku = malloc(sizeof(Goku));
    strcpy(goku->base.nombre, "Goku");
    goku->base.nivelPoder = 9000;
    goku->base.atacar = (void (*)(void *))atacar;
    goku->base.transformarse = transformarseGoku;
    goku->base.ataqueEspecial = ataqueEspecialGoku;
    return goku;
}

// Vegeta
typedef struct {
    Saiyajin base;
} Vegeta;

void transformarseVegeta(void *self) {
    Vegeta *vegeta = (Vegeta *)self;
    printf("%s se transforma en Super Saiyajin Fase 2!\n", vegeta->base.nombre);
    vegeta->base.nivelPoder *= 45;
}

void ataqueEspecialVegeta(void *self) {
    Vegeta *vegeta = (Vegeta *)self;
    printf("%s lanza un ataque de Brillo Final!\n", vegeta->base.nombre);
}

Vegeta *crearVegeta() {
    Vegeta *vegeta = malloc(sizeof(Vegeta));
    strcpy(vegeta->base.nombre, "Vegeta");
    vegeta->base.nivelPoder = 8500;
    vegeta->base.atacar = (void (*)(void *))atacar;
    vegeta->base.transformarse = transformarseVegeta;
    vegeta->base.ataqueEspecial = ataqueEspecialVegeta;
    return vegeta;
}

// Broly
typedef struct {
    Saiyajin base; // Composición (simulación herencia)
} Broly;

void transformarseBroly(void *self) {
    Broly *broly = (Broly *)self;
    printf("%s se transforma en Super Saiyajin Legendario!\n", broly->base.nombre);
    broly->base.nivelPoder *= 70;
}

void ataqueEspecialBroly(void *self) {
    Broly *broly = (Broly *)self;
    printf("%s lanza una Erupción Omega!\n", broly->base.nombre);
}

Broly *crearBroly() {
    Broly *broly = malloc(sizeof(Broly));
    strcpy(broly->base.nombre, "Broly");
    broly->base.nivelPoder = 12000;
    broly->base.atacar = (void (*)(void *))atacar;
    broly->base.transformarse = transformarseBroly;
    broly->base.ataqueEspecial = ataqueEspecialBroly;
    return broly;
}

int main() {
    // Creaión d e instancias
    Goku *goku = crearGoku();
    Vegeta *vegeta = crearVegeta();
    Broly *broly = crearBroly();

    // polimorfismo simulado
    Saiyajin *guerreros[] = {(Saiyajin *)goku, (Saiyajin *)vegeta, (Saiyajin *)broly};
    int numGuerreros = sizeof(guerreros) / sizeof(guerreros[0]);

    printf("¡Comienza la batalla!\n\n");

    for (int i = 0; i < numGuerreros; i++) {
        Saiyajin *guerrero = guerreros[i];
        printf("%s entra en combate!\n", guerrero->nombre);
        guerrero->atacar(guerrero);
        guerrero->transformarse(guerrero);
        guerrero->ataqueEspecial(guerrero);
        printf("Nivel de poder actual de <<%s>>: %d\n\n", guerrero->nombre, guerrero->nivelPoder);
    }

    printf("¡Fin del combate!\n");

    // Liberar memoria
    free(goku);
    free(vegeta);
    free(broly);

    return 0;
}