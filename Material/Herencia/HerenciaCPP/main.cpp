#include <iostream>
#include <string>
using namespace std;

// Clase Padre
class Animal {
    protected:
        string nombre;

    public:
        // Constructor
        Animal(string nombre) : nombre(nombre) {}

        // Método común
        virtual void comer() {
            cout << nombre << " [ocupado (está comiendo)]" << endl;
        }

        // Destructor virtual
        virtual ~Animal() {}
};

// Clase hija (derivada)
class Perro: public Animal {
    private:
        string raza;

    public:
        // Constructor
        Perro(string nombre, string raza): Animal(nombre), raza(raza) {}

        // Método exclusivo
        void ladrar() {
            cout << nombre << " está ladrando: ¡Raaaa!" << endl;
        }

        // Sobrescritura de comer
        void comer() override {
            cout << nombre << " (un " << raza << ") está comiendo" << endl;
        }
};

class Gato: public Animal {
    private:
        string raza;
    
    public:
        Gato(string nombre, string raza): Animal(nombre), raza(raza) {}

        void ataque() {
            cout << nombre << " va a arañar" << endl;
        }

        void comer() override {
            cout << nombre << " (un " << raza << ") está comiendo pacificamente" << endl;
        }
};

int main() {
    // Crear instancia animal
    Animal animal("Perry");
    animal.comer();

    // Crear instancias de animales
    Perro perro("Arcanine", "Pokemon");
    Gato gato("Umbreon", "Pokemon");

    // Llamar metodos de animales
    perro.comer();
    perro.ladrar();
    gato.ataque();
    gato.comer();

    return 0;
}