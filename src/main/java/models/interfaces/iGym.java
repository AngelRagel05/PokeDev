package models.interfaces;

import models.Trainer;

public interface iGym {

    boolean winMedal (Trainer lider, Trainer visitante);

    String getNombre();
}