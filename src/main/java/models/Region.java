package models;

import models.interfaces.iRegion;

import java.util.ArrayList;
import java.util.List;

public class Region implements iRegion {

    private static final String ADDED = " añadido correctamente a la lista.";

//    Atributos
    protected String nombre;
    protected String descripcionRegion;
    protected List<Medal> medallas;
    protected List<Pokemon> pokemons;
    protected List<Gym> gimnasios;
    protected ArrayList<Trainer> entrenadores;

//    Constructor
    public Region(String nombre, String descripcionRegion, List<Medal> medallas, List<Pokemon> pokemons, List<Gym> gimnasios, ArrayList<Trainer> entrenadores) {
        this.nombre = nombre;
        this.descripcionRegion = descripcionRegion;
        this.medallas = medallas;
        this.pokemons = pokemons;
        this.gimnasios = gimnasios;
        this.entrenadores = entrenadores;
    }

    public Region (String nombre, String descripcionRegion) {
        this.nombre = nombre;
        this.descripcionRegion = descripcionRegion;
    }

//    Metodos
    public List<Medal> showMedals() {
        return new ArrayList<>(medallas);
    }

    public List<Pokemon> showPokemons() {
        return new ArrayList<>(pokemons);
    }

    public List<Gym> showGym() {
        return new ArrayList<>(gimnasios);
    }

    public ArrayList<Trainer> showTrainers() {
        return new ArrayList<>(entrenadores);
    }

    public void addTrainer(Trainer trainer) {
        entrenadores.add(trainer);
        print(trainer.getNombre() + ADDED);
    }

//    Funciones
    private static void print(String frase) {
        System.out.println(frase);
    }

}