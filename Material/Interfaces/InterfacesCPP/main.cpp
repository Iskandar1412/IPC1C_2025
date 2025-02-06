#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

// Interfaz
class Guerrero {
    public:
        virtual void atacar() = 0;
        virtual void defender() = 0;
        virtual void habilidadEspecial() = 0;
        virtual ~Guerrero() {}
};

// Kratos
class Kratos: public Guerrero {
    private:
        string nombre;
    public:
        Kratos(): nombre("Kratos") {}

        void atacar() override {
            cout << nombre << " ataca con las Espadas del Caos!" << endl;
        }

        void defender() override {
            cout << nombre << " bloquea con el Escudo Guardián!" << endl;
        }

        void habilidadEspecial() override {
            cout << nombre << " usa la Ira Espartana!" << endl;
        }
};

// Atreus
class Atreus: public Guerrero {
    private:
        string nombre;
    public:
        Atreus(): nombre("Atreus") {}

        void atacar() override {
            cout << nombre << " dispara una flecha mágica!" << endl;
        }

        void defender() override {
            cout << nombre << " esquiva ágilmente!" << endl;
        }

        void habilidadEspecial() override {
            cout << nombre << " invoca a los lobos espirituales!" << endl;
        }
};

// Thor
class Thor: public Guerrero {
    private:
        string nombre;
    public:
        Thor(): nombre("Thor") {}

        void atacar() override {
            cout << nombre << " lanza Mjölnir con furia!" << endl;
        }

        void defender() override {
            cout << nombre << " se protege con su enorme resistencia divina!" << endl;
        }

        void habilidadEspecial() override {
            cout << nombre << " desata una tormenta de rayos!" << endl;
        }
};

// Clase Batalla
class Batalla {
    private:
        Guerrero *guerrero1;
        Guerrero *guerrero2;
    public:
        Batalla(Guerrero *g1, Guerrero *g2) : guerrero1(g1), guerrero2(g2) {}

        void iniciarCombate() {
            cout << "\n¡COMIENZA LA BATALLA!" << endl;
            srand(time(NULL));

            for (int i = 0; i < 3; i++) {
                cout << "\n--> RONDA " << (i + 1) << endl;

                if (rand() % 2) {
                    guerrero1->atacar();
                    guerrero2->defender();
                } else {
                    guerrero2->atacar();
                    guerrero1->defender();
                }

                if (rand() % 2) {
                    guerrero1->habilidadEspecial();
                } else {
                    guerrero2->habilidadEspecial();
                }
            }

            cout << "\n¡LA BATALLA HA TERMINADO!" << endl;
        }
};

int main() {
    // Instancias de guerreros
    Kratos kratos;
    Thor thor;
    Atreus atreus;

    // Kratos vs Thor
    Batalla batalla1(&kratos, &thor);
    batalla1.iniciarCombate();

    cout << "\n==============================\n";

    // Atreus vs Thor
    Batalla batalla2(&atreus, &thor);
    batalla2.iniciarCombate();

    return 0;
}