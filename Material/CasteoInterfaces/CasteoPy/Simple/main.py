# Definimos las clases
class Gato:
    def sonidoAnimal(self):
        print("Miau, soy un gato")

class Perro: 
    def sonidoAnimal(self):
        print("Guauf, soy un perro")

def main():
    # Creamos instancias
    gato = Gato()
    perro = Perro()

    gato.sonidoAnimal()
    perro.sonidoAnimal()

    animales = [gato, perro]
    for animal in animales:
        animal.sonidoAnimal()

if __name__ == "__main__":
    main()