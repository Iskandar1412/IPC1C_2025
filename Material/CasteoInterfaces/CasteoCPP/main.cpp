// g++ <programa>.cpp -o <programa>
// ./<programa>

#include <iostream>
#include <vector>
#include <memory>


class Animal {
    public:
        virtual void SonidoAnimal() const = 0;
        virtual ~Animal() = default; // destructor
};

// Creación de clases que heredan animal
class Gato: public Animal {
    public:
        void SonidoAnimal() const override {
            std::cout << "Miau, soy un gato" << std::endl;
        }
};

class Perro: public Animal {
    public:
        void SonidoAnimal() const override {
            std::cout << "Guauf, soy un perro" << std::endl;
        }
};


int main() {
    // Creaciónd e instancias animales
    std::shared_ptr<Animal> gatito = std::make_shared<Gato>();
    std::shared_ptr<Animal> perrito = std::make_shared<Perro>();

    gatito->SonidoAnimal();
    perrito->SonidoAnimal();

    // Creación vector animales
    std::vector<std::shared_ptr<Animal>> animales = {gatito, perrito};
    for (const auto& animal: animales) {
        animal->SonidoAnimal();
    }

    return 0;
}