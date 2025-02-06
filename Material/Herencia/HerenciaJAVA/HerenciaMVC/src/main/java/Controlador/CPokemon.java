package Controlador;

import Modelo.Pokemon;
import Modelo.TipoPokemon;
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

    public void pokeRugido() {
        if(modelo instanceof TipoPokemon) {
            vista.pokeMensaje(((TipoPokemon) modelo).rugidoPokemon());
        } else {
            vista.pokeMensaje(modelo.getNombre() + " te observa fijamente");
        }
    }
}
