package models.interfaces;

import models.enumerations.Item;
import models.enumerations.Type;

public interface iPokemon {

    void cure (Item item);

    void levelUp (Item item);

    void revive (Item item);

    String getNombre();

    Type getTipo();

    Integer getNivel();

    Double getSalud();
}