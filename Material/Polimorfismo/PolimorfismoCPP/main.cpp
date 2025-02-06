#include <iostream>
#include <vector>
using namespace std;

// Clase abstracta
class Saiyajin {
    protected:
        string nombre;
        int nivelPoder;

    public:
        // Constructor
        Saiyajin(string nombre, int nivelPoder) : nombre(nombre), nivelPoder(nivelPoder) {}

        void atacar() {
            cout << nombre << " golpea con sus puños" << endl;
        }

        // Método abstracto
        virtual void transformarse() = 0;

        // Método virtual
        virtual void ataqueEspecial() {
            cout << nombre << " lanza una habilidad especial" << endl;
        }

        int getNivelPoder() const {
            return nivelPoder;
        }

        string getNombre() const {
            return nombre;
        }
};

// Goku
class Goku: public Saiyajin {
public:
    Goku(): Saiyajin("Goku", 9000) {}

    void transformarse() override {
        cout << nombre << " se transforma en Super Saiyajin Fase 3!" << endl;
        nivelPoder *= 50;
    }

    void ataqueEspecial() override {
        cout << nombre << " lanza un Kamehameha!" << endl;
    }
};

// Vegeta
class Vegeta: public Saiyajin {
    public:
        Vegeta(): Saiyajin("Vegeta", 8500) {}

        void transformarse() override {
            cout << nombre << " se transforma en Super Saiyajin Fase 2!" << endl;
            nivelPoder *= 45;
        }

        void ataqueEspecial() override {
            cout << nombre << " lanza un ataque de Brillo Final!" << endl;
        }
};

// Broly
class Broly: public Saiyajin {
    public:
        Broly(): Saiyajin("Broly", 12000) {}

        void transformarse() override {
            cout << nombre << " se transforma en Super Saiyajin Legendario!" << endl;
            nivelPoder *= 70;
        }

        void ataqueEspecial() override {
            cout << nombre << " lanza una Erupción Omega!" << endl;
        }
};

int main() {
    // Creación de instancias
    Goku goku;
    Vegeta vegeta;
    Broly broly;

    // Arreglo de Saiyajin (polimorfismo)
    vector<Saiyajin *> guerreros = {&goku, &vegeta, &broly};

    cout << "¡Comienza la batalla!" << endl
         << endl;

    for (Saiyajin *guerrero : guerreros) {
        cout << guerrero->getNombre() << " entra en combate!" << endl;
        guerrero->atacar();
        guerrero->transformarse();
        guerrero->ataqueEspecial();
        cout << "Nivel de poder actual de <<" << guerrero->getNombre() << ">>: " << guerrero->getNivelPoder() << endl
             << endl;
    }

    cout << "¡Fin del combate!" << endl;

    return 0;
}