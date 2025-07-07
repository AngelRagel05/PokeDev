package models.interfaces;

import models.Pokemon;
import models.Trainer;

public interface iProfessor {

    void deliverStarterPokemon (Trainer trainer, Integer opc);

    String researchPokemon (Pokemon pokemon);
}
