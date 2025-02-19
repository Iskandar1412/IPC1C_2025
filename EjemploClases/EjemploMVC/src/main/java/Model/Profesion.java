package Model;

public class Profesion {
    private String nombreProfesion; // aqui nadie que externo de Profesión podra modificarme Muajaja

    // (lo de adentro son nuestros parametros)
    // Constructor
    public Profesion(String nombreProfesion) {
        this.nombreProfesion = nombreProfesion; // Asignamos a profesion
    } // void String Int Double Char

    public void setNombreProfesion(String a1) {
        this.nombreProfesion = a1;
    }

    public String getNombreProfesion() {
        return this.nombreProfesion;
    }

    public String accionProfesion() {
        return "La persona se asigno a la profesion: " + nombreProfesion;
    }
}


/*
// Constructor vacio
Profesion persona = new Profesion(//Parametros);
persona.setNombreProfesion("Alumno");

// Constructor con parametros
Profesion persona = new Profesion("Alumno");
*/