#include <iostream>
#include <string>
using namespace std;

// clase persona
class Persona {
    private:
        string nombre;
        int edad;

    public:
        // constructor de persona
        Persona(string nombre, int edad) : nombre(nombre), edad(edad) {
            if (edad <= 0) {
                cout << "La edad no puede ser igual o menor a 0" << endl;
                this->edad = 1;
            }
        }

        // método obtener nombre
        string getNombre() const {
            return nombre;
        }

        // método cambiar nombre
        void setNombre(const string &nombre) {
            this->nombre = nombre;
        }

        // método obtener edad
        int getEdad() const {
            return edad;
        }

        // método cambiar edad
        void setEdad(int edad) {
            if (edad > 0) {
                this->edad = edad;
            } else {
                cout << "La edad no puede ser igual o menor a 0" << endl;
            }
        }

        // Método mostrar información
        void infoPersona() const {
            cout << "------------------------------------" << endl;
            cout << "Persona" << endl;
            cout << "Nombre: " << nombre << ", Edad: " << edad << endl;
            cout << "------------------------------------" << endl;
        }
};

int main() {
    // Crear instancia persona
    Persona persona("Mario", 25);
    persona.infoPersona();

    // Cambio atributos persona
    persona.setEdad(30);
    persona.setNombre("Carlos");

    // impresión información
    persona.infoPersona();

    // Asignar edad no valida
    persona.setEdad(-5);
    persona.infoPersona();

    return 0;
}