package models.interfaces;

import models.Gym;
import models.Medal;
import models.Pokemon;
import models.Trainer;

import java.util.ArrayList;
import java.util.List;

public interface iRegion {
    
    List<Medal> showMedals();

    List<Pokemon> showPokemons();

    List<Gym> showGym();

    ArrayList<Trainer> showTrainers();

    void addTrainer (Trainer trainer);
}