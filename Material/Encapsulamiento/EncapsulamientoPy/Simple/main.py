# Definición persona
class Persona:
    def __init__(self, nombre, edad):
        self.nombre = nombre
        self.edad = edad
        self.setEdad(edad)
    
    # Métodos
    # Sets
    def getNombre(self):
        return self.nombre

    def getEdad(self):
        return self.edad
    
    # Gets
    def setNombre(self, nombre):
        self.nombre = nombre

    def setEdad(self, edad):
        if edad > 0:
            self.edad = edad
        else:
            print("La edad no puede ser menor o igual a 0")
    
    # Mostrar persona
    def infoPersona(self):
        print("------------------------------------")
        print("Persona")
        print(f"Nombre: {self.nombre}, Edad: {self.edad}")
        print("------------------------------------")
    
def main():
    # Creamos intancia persona
    persona = Persona("Mario", 22)
    persona.infoPersona()

    # Modificar datos
    persona.setNombre("Carlos")
    persona.setEdad(25)
    persona.infoPersona()

    # Edad incorrecta
    persona.setEdad(-5)
    persona.infoPersona()

if __name__ == "__main__":
    main()