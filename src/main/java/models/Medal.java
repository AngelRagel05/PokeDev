package models;

import models.interfaces.iMedal;

public class Medal implements iMedal {

//    Atributos
    protected String nombre;
    protected String descripcionMedalla;

//    Constructor
    public Medal(String nombre, String descripcionMedalla) {
        this.nombre = nombre;
        this.descripcionMedalla = descripcionMedalla;
    }

//    Metodos
    public String getNombre() {
        return nombre;
    }
}