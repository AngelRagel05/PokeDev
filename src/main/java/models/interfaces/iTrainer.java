package models.interfaces;

import models.Pokemon;
import models.Trainer;
import models.enumerations.Item;

import java.util.List;

public interface iTrainer {

    void addPokemon(Pokemon pokemon);

    boolean combatTrainer(Trainer rival, Trainer principal);

    boolean capture(Item item);

    List<Pokemon> getPokemons();
}
