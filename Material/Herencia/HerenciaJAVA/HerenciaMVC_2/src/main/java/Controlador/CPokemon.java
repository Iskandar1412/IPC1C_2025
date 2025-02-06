package Controlador;

import Modelo.Fuego;
import Modelo.Hielo;
import Modelo.Pokemon;
import Vista.VPokemon;

public class CPokemon {
    private Pokemon modelo; // Modelo
    private VPokemon vista; // Vista

    public CPokemon(Pokemon modelo, VPokemon vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void pokemonComiendo() {
        vista.pokeMensaje(modelo.comer());
    }

    public void pokeActividad() {
        if (modelo instanceof Fuego) {
            vista.pokeMensaje(((Fuego) modelo).atacar());
        } else if (modelo instanceof Hielo) {
            vista.pokeMensaje(((Hielo) modelo).dormir());
        } else {
            vista.pokeMensaje(modelo.getNombre() + " te observa fijamente");
        }
    }
}
