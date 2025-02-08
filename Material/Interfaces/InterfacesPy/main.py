from abc import ABC, abstractmethod
import random

# Interfaz
class Guerrero(ABC):
    @abstractmethod
    def atacar(self):
        pass

    @abstractmethod
    def defender(self):
        pass

    @abstractmethod
    def habilidad_especial(self):
        pass

# Kratos
class Kratos(Guerrero):
    def __init__(self):
        self.nombre = "Kratos"

    def atacar(self):
        print(f"{self.nombre} ataca con las Espadas del Caos!")

    def defender(self):
        print(f"{self.nombre} bloquea con el Escudo Guardián!")

    def habilidad_especial(self):
        print(f"{self.nombre} usa la Ira Espartana!")

# Atreus
class Atreus(Guerrero):
    def __init__(self):
        self.nombre = "Atreus"

    def atacar(self):
        print(f"{self.nombre} dispara una flecha mágica!")

    def defender(self):
        print(f"{self.nombre} esquiva ágilmente!")

    def habilidad_especial(self):
        print(f"{self.nombre} invoca a los lobos espirituales!")

# Thor
class Thor(Guerrero):
    def __init__(self):
        self.nombre = "Thor"

    def atacar(self):
        print(f"{self.nombre} lanza Mjölnir con furia!")

    def defender(self):
        print(f"{self.nombre} se protege con su enorme resistencia divina!")

    def habilidad_especial(self):
        print(f"{self.nombre} desata una tormenta de rayos!")

class Batalla:
    def __init__(self, guerrero1, guerrero2):
        self.guerrero1 = guerrero1
        self.guerrero2 = guerrero2

    def iniciar_combate(self):
        print("\n¡COMIENZA LA BATALLA!")
        random.seed()

        for i in range(3):
            print(f"\n--> RONDA {i + 1}")

            if random.randint(0, 1) == 0:
                self.guerrero1.atacar()
                self.guerrero2.defender()
            else:
                self.guerrero2.atacar()
                self.guerrero1.defender()

            if random.randint(0, 1) == 0:
                self.guerrero1.habilidad_especial()
            else:
                self.guerrero2.habilidad_especial()

        print("\n¡LA BATALLA HA TERMINADO!")


def main():
    # Instancias
    kratos = Kratos()
    thor = Thor()
    atreus = Atreus()

    # Kratos vs Thor
    batalla1 = Batalla(kratos, thor)
    batalla1.iniciar_combate()

    print("\n==============================")

    # Atreus vs Thor
    batalla2 = Batalla(atreus, thor)
    batalla2.iniciar_combate()

if __name__ == "__main__":
    main()