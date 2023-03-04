package com.fiipractic.week1;

import com.fiipractic.week1.models.Pokemon;
import org.hibernate.annotations.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class PokemonDB {

    private static List<Pokemon> pokemons = new ArrayList<Pokemon>();

    static {
        pokemons.add(new Pokemon(1, "Bulbasaur", "Grass", "Luci", 1));
        pokemons.add(new Pokemon(2, "Eevee", "Normal", "Luci", 10));
        pokemons.add(new Pokemon(3, "Charmander", "Fire", "Luci", 5));
        pokemons.add(new Pokemon(4, "Slowpoke", "Normal", "Luci", 3));
        pokemons.add(new Pokemon(5, "Onix", "Stone", "Luci", 50));
        pokemons.add(new Pokemon(6, "Arceus", "Normal", "Luci", 100));
        pokemons.add(new Pokemon(7, "Thundurus", "Electric", "Luci", 100));
        pokemons.add(new Pokemon(8, "Latias", "Dragon", "Luci", 100));
    }

    public static List<Pokemon>getAll(){
        return pokemons;
    }

    public static Pokemon getByID(Integer id){
        for (Pokemon pokemon: pokemons){
            if(pokemon.getID().equals(id)){
                return pokemon;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Pokemon createPokemon(Pokemon pokemon){
        pokemons.add(pokemon);
        return pokemon;
    }

    public static Pokemon deletePokemon( Integer id) {
        for(Pokemon pokemon: pokemons){
            if(pokemon.getID().equals(id)){
                pokemons.remove(pokemon);
                return pokemon;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

}
