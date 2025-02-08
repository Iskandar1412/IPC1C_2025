# Definimos una clase abstracta
from abc import ABC, abstractmethod

class Animal(ABC):
    @abstractmethod
    def sonidoAnimal(self):
        pass # método para usar en las subclases

# Definición clases hijas (subclases)
class Gato(Animal):
    def sonidoAnimal(self):
        print("Miau, soy un gato")

class Perro(Animal):
    def sonidoAnimal(self):
        print("Guauf, soy un perro")


def main():
    # Instanciamos animales
    gato = Gato()
    perro = Perro()

    gato.sonidoAnimal()
    perro.sonidoAnimal()


    # Lista de animales
    animales = [gato, perro]
    for animal in animales:
        animal.sonidoAnimal()

if __name__ == "__main__":
    main()