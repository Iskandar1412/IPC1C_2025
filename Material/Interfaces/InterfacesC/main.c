#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

// Estructura (definición interfáz)
typedef struct {
    void (*atacar)(void *self);
    void (*defender)(void *self);
    void (*habilidadEspecial)(void *self);
} Guerrero;

// Kratos
typedef struct {
    Guerrero base;
    char nombre[20];
} Kratos;

void kratosAtacar(void *self) {
    printf("Kratos ataca con las Espadas del Caos!\n");
}

void kratosDefender(void *self) {
    printf("Kratos bloquea con el Escudo Guardián!\n");
}

void kratosHabilidadEspecial(void *self) {
    printf("Kratos usa la Ira Espartana!\n");
}

void componentesKratos(Kratos *kratos) {
    strcpy(kratos->nombre, "Kratos");
    kratos->base.atacar = kratosAtacar;
    kratos->base.defender = kratosDefender;
    kratos->base.habilidadEspecial = kratosHabilidadEspecial;
}

// Atreus
typedef struct {
    Guerrero base;
    char nombre[20];
} Atreus;

void atreusAtacar(void *self) {
    printf("Atreus dispara una flecha mágica!\n");
}

void atreusDefender(void *self) {
    printf("Atreus esquiva ágilmente!\n");
}

void atreusHabilidadEspecial(void *self) {
    printf("Atreus invoca a los lobos espirituales!\n");
}

void componentesAtreus(Atreus *atreus) {
    strcpy(atreus->nombre, "Atreus");
    atreus->base.atacar = atreusAtacar;
    atreus->base.defender = atreusDefender;
    atreus->base.habilidadEspecial = atreusHabilidadEspecial;
}

// Thor
typedef struct {
    Guerrero base;
    char nombre[20];
} Thor;

void thorAtacar(void *self) {
    printf("Thor lanza Mjölnir con furia!\n");
}

void thorDefender(void *self) {
    printf("Thor se protege con su enorme resistencia divina!\n");
}

void thorHabilidadEspecial(void *self) {
    printf("Thor desata una tormenta de rayos!\n");
}

void componentesThor(Thor *thor) {
    strcpy(thor->nombre, "Thor");
    thor->base.atacar = thorAtacar;
    thor->base.defender = thorDefender;
    thor->base.habilidadEspecial = thorHabilidadEspecial;
}

// Batalla
typedef struct {
    Guerrero *guerrero1;
    Guerrero *guerrero2;
} Batalla;

void iniciarCombate(Batalla *batalla) {
    printf("\n¡COMIENZA LA BATALLA!\n");
    srand(time(NULL));

    for (int i = 0; i < 3; i++) {
        printf("\n--> RONDA %d\n", i + 1);

        if (rand() % 2) {
            batalla->guerrero1->atacar(batalla->guerrero1);
            batalla->guerrero2->defender(batalla->guerrero2);
        } else {
            batalla->guerrero2->atacar(batalla->guerrero2);
            batalla->guerrero1->defender(batalla->guerrero1);
        }

        if (rand() % 2) {
            batalla->guerrero1->habilidadEspecial(batalla->guerrero1);
        } else {
            batalla->guerrero2->habilidadEspecial(batalla->guerrero2);
        }
    }

    printf("\n¡LA BATALLA HA TERMINADO!\n");
}

int main() {
    // Instancias de guerreros
    Kratos kratos;
    componentesKratos(&kratos);

    Thor thor;
    componentesThor(&thor);

    Atreus atreus;
    componentesAtreus(&atreus);

    // Kratos vs Thor
    Batalla batalla1 = {&kratos.base, &thor.base};
    iniciarCombate(&batalla1);

    printf("\n==============================\n");

    // Atreus vs Thor
    Batalla batalla2 = {&atreus.base, &thor.base};
    iniciarCombate(&batalla2);

    return 0;
}