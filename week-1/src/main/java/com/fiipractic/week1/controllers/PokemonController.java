package com.fiipractic.week1.controllers;

import com.fiipractic.week1.PokemonDB;
import com.fiipractic.week1.models.Pokemon;
import com.fiipractic.week1.repository.PokemonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class PokemonController {

    private final PokemonDB pokemonDB;
    private final PokemonRepository pokemonRepository;

    public PokemonController(PokemonDB pokemonDB, PokemonRepository pokemonRepository) {
        this.pokemonDB = pokemonDB;
        this.pokemonRepository = pokemonRepository;
    }


    @GetMapping(path = "/pokemons")
    public List<Pokemon> pokemons(){
        return pokemonRepository.findAll();
    }

    @GetMapping(path = "/pokemons/{id}")
    public Pokemon pokemon(@PathVariable Integer id){
        Pokemon pokemon = pokemonRepository.findById(id).orElse(null);

        if(pokemon = null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            return pokemon;
        }
    }

    @PostMapping(path = "/pokemons")
    public Pokemon createPokemon(@RequestBody Pokemon pokemon){
        return pokemonRepository.save(pokemon);
    }

    @DeleteMapping(path = "/pokemons/{id}")
    public Pokemon deletePokemon(@PathVariable Integer id){
        Pokemon pokemon = pokemonRepository.getReferenceById(id);
        pokemonRepository.deleteById(id);
        Pokemon updatedPokemon = pokemonRepository.getReferenceById(id);
        if(pokemon.getName() != null){
            updatedPokemon.setName(pokemon.getName());
        }

        if(pokemon.getTrainer() != null){
            updatedPokemon.setTrainer(pokemon.getTrainer());
        }

        if (pokemon.getId() != null){
            updatedPokemon.setId(pokemon.getId());
        }

        if (pokemon.getType() != null){
            updatedPokemon.setType(pokemon.getType());
        }

        if (pokemon.getLevel() != null){
            updatedPokemon.setLevel(pokemon.getLevel());
        }

        return pokemonDB.deletePokemon(id);
    }

    @PatchMapping(path = "/pokemons/{id}")
    public Pokemon updatePokemon(@PathVariable Integer id, @RequestBody Pokemon pokemon){
        Pokemon updatedPokemon = pokemonRepository.getReferenceById(id);

        if(pokemon.getName() != null){
            updatedPokemon.setName(pokemon.getName());
        }

        if(pokemon.getTrainer() != null){
            updatedPokemon.setTrainer(pokemon.getTrainer());
        }

        if (pokemon.getId() != null){
            updatedPokemon.setId(pokemon.getId());
        }

        if (pokemon.getType() != null){
            updatedPokemon.setType(pokemon.getType());
        }

        if (pokemon.getLevel() != null){
            updatedPokemon.setLevel(pokemon.getLevel());
        }

        pokemonRepository.save(updatedPokemon);
        return updatedPokemon;
    }
}