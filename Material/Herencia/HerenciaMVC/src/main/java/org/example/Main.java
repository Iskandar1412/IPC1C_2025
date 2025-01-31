package org.example;

import Controlador.CPokemon;
import Modelo.Pokemon;
import Modelo.TipoPokemon;
import Vista.VPokemon;

public class Main {
    public static void main(String[] args) {
        VPokemon vista = new VPokemon(); // Vista

        // Controlador & Modelo Gyrados
        Pokemon gyrados = new Pokemon("Gyrados");
        CPokemon controladorGyrados = new CPokemon(gyrados, vista);
        controladorGyrados.pokemonComiendo();
        controladorGyrados.pokeRugido();

        // Controlador & Modelo Arcanaine
        TipoPokemon articuno = new TipoPokemon("Articuno", "Volador");
        CPokemon controladorArticuno = new CPokemon(articuno, vista);
        controladorArticuno.pokemonComiendo();
        controladorArticuno.pokeRugido();
    }
}