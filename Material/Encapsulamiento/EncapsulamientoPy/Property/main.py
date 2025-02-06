# Definición de persona (clase)
class Persona:
    def __init__(self, nombre, edad):
        self.__nombre = nombre
        self.__edad = 1
        self.edad = edad

    # Metodos
    @property
    def nombre(self):
        return self.__nombre

    @property
    def edad(self):
        return self.__edad

    @nombre.setter
    def nombre(self, nombre):
        self.__nombre = nombre

    @edad.setter
    def edad(self, edad):
        if edad > 0:
            self.__edad = edad
        else:
            print("La edad no puede ser menor o igual a 0")

    def infoPersona(self):
        print("------------------------------------")
        print("Persona")
        print(f"Nombre: {self.__nombre}, Edad: {self.__edad}")
        print("------------------------------------")


def main():
    # Crear instancia
    persona = Persona("Mario", 22)
    persona.infoPersona()

    # Modificar información
    persona.edad = 25
    persona.nombre = "Carlos"
    persona.infoPersona()

    # Asignar valores erroneos
    persona.edad = -5
    persona.infoPersona()


if __name__ == "__main__":
    main()