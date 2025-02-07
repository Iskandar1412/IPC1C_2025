import java.lang.reflect.Field;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Validar {
    int longitudMaxima();
}

class Usuario {
    @Validar(longitudMaxima = 20)
    private String nombre;

    public void setNombre(String nombre) throws Exception {
        Field campo = this.getClass().getDeclaredField("nombre");
        campo.setAccessible(true);

        if (campo.isAnnotationPresent(Validar.class)) {
            System.out.println("Anotación @Validar encontrada.");
            Validar validar = campo.getAnnotation(Validar.class);
            int longitudMaxima = validar.longitudMaxima();
            System.out.println("Longitud máxima permitida: " + longitudMaxima);

            if (nombre.length() > longitudMaxima) {
                throw new IllegalArgumentException("El nombre excede la longitud máxima permitida de " + longitudMaxima + " caracteres.");
            }
        } else {
            System.out.println("Anotación @Validar NO encontrada.");
        }

        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

public class main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();

        try {
            usuario.setNombre("Pedro");
            System.out.println("Nombre asignado: " + usuario.getNombre());

            String nombreLargo = "Este es un nombre extremadamente largo que supera la longitud máxima permitida.";
            System.out.println("Intentando asignar nombre con longitud: " + nombreLargo.length());
            usuario.setNombre(nombreLargo);
        } catch (Exception e) {
            System.err.println("Error capturado: " + e.getMessage());
        }
    }
}