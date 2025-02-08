# Clase padre
class Pokemon:
    def __init__(self, nombre):
        self.nombre = nombre
    
    # Método a heredar
    def comer(self):
        print(f"{self.nombre} está comiendo atentamente")

# Clases hijas (derivadas)
class TipoRoca(Pokemon):
    def __init__(self, nombre, raza):
        super().__init__(nombre) # Se llama constructor de clase padre
        self.raza = raza
    
    # Método exclusivo
    def ataqueEspecial(self):
        print(f"{self.nombre} va a usar tumba rocas")
    
    # Sobreescritura de método padre
    def comer(self):
        print(f"{self.nombre} (un {self.raza}) está comiendo rápidamente")

class TipoPsiquico(Pokemon):
    def __init__(self, nombre, raza):
        super().__init__(nombre)
        self.raza = raza
    
    def habilidadEspecial(self):
        print(f"{self.nombre} uso teletransportación")
    
    def comer(self):
        print(f"{self.nombre} (un {self.raza}) está comiendo asustado")

def main():
    # Crear instancia pokemon
    pokemon = Pokemon("Persian")
    pokemon.comer()

    # Crear instancias pokeones
    onix = TipoRoca("Onix", "¿Pokemon?")
    abra = TipoPsiquico("Abra", "¿Pokemon?")

    # Uso métodos
    onix.ataqueEspecial()
    onix.comer()

    abra.comer()
    abra.habilidadEspecial()


if __name__ == "__main__":
    main()