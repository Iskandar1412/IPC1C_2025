package org.example;

import Controlador.CPokemon;
import Modelo.Fuego;
import Modelo.Hielo;
import Vista.VPokemon;

public class Main {
    public static void main(String[] args) {
        VPokemon vista = new VPokemon(); // Instancia vista

        // Creación instancias Pokemones
        CPokemon controladorArticuno = new CPokemon(new Hielo("Articuno", "Volador"), vista);
        CPokemon controladorMoltress = new CPokemon(new Fuego("Moltress", "Volador"), vista);

        // Acciones pokemones
        controladorArticuno.pokemonComiendo();
        controladorArticuno.pokeActividad();

        controladorMoltress.pokemonComiendo();
        controladorMoltress.pokeActividad();
    }
}