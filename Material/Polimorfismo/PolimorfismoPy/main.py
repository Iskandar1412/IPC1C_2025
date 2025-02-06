from abc import ABC, abstractmethod

# Clase abstracta
class Saiyajin(ABC):
    def __init__(self, nombre, nivel_poder):
        self.nombre = nombre
        self.nivel_poder = nivel_poder

    # Método heredado
    def atacar(self):
        print(f"{self.nombre} golpea con sus puños")

    # Método abstracto
    @abstractmethod
    def transformarse(self):
        pass

    def ataque_especial(self):
        print(f"{self.nombre} lanza una habilidad especial")

# Goku
class Goku(Saiyajin):
    def __init__(self):
        super().__init__("Goku", 9000)

    def transformarse(self):
        print(f"{self.nombre} se transforma en Super Saiyajin Fase 3!")
        self.nivel_poder *= 50

    def ataque_especial(self):
        print(f"{self.nombre} lanza un Kamehameha!")

# Vegeta
class Vegeta(Saiyajin):
    def __init__(self):
        super().__init__("Vegeta", 8500)

    def transformarse(self):
        print(f"{self.nombre} se transforma en Super Saiyajin Fase 2!")
        self.nivel_poder *= 45

    def ataque_especial(self):
        print(f"{self.nombre} lanza un ataque de Brillo Final!")

# Broly
class Broly(Saiyajin):
    def __init__(self):
        super().__init__("Broly", 12000)

    def transformarse(self):
        print(f"{self.nombre} se transforma en Super Saiyajin Legendario!")
        self.nivel_poder *= 70

    def ataque_especial(self):
        print(f"{self.nombre} lanza una Erupción Omega!")

def main():
    # Creación de instancias
    goku = Goku()
    vegeta = Vegeta()
    broly = Broly()

    guerreros = [goku, vegeta, broly]

    print("¡Comienza la batalla!\n")

    for guerrero in guerreros:
        print(f"{guerrero.nombre} entra en combate!")
        guerrero.atacar()
        guerrero.transformarse()
        guerrero.ataque_especial()
        print(f"Nivel de poder actual de <<{guerrero.nombre}>>: {guerrero.nivel_poder}\n")

    print("¡Fin del combate!")

if __name__ == "__main__":
    main()