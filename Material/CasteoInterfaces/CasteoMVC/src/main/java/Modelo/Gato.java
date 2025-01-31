package Modelo;

public class Gato implements Animal{
    /*
    // Forma 1 (solo 1 animal, si se quiere poner más se debe sobreescribir método)
    public String sonido() {
        return "Miau, soy un gato";
    }
     */

    @Override
    public String sonido() {
        return "Miau, soy un gato";
    }
}
