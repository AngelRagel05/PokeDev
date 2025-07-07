package models;

import models.abstracts.Person;
import models.enumerations.Item;
import models.enumerations.Type;
import models.interfaces.iProfessor;

import java.util.*;

public class Professor extends Person implements iProfessor {

    private static Scanner sc = new Scanner(System.in);

    private static final String EMPTY_POKEMON = "No hay Pokémon iniciales disponibles.";
    private static final String WRONG_CHOOSE = "Selección inválida. Debe estar entre 1 y ";
    private static final String CHOSEN_POKEMON = " ha recibido a ";

//    Atributos
    protected Type tipo;
    protected Region region;
    protected List<Pokemon> pokemonLab;
    protected ArrayList<Item> objetosIniciales;

//    Constructor
    public Professor(String nombre, Type especialidad, Region region, List<Pokemon> pokemonLab, ArrayList<Item> objetosIniciales) {
        super(nombre);
        this.tipo = especialidad;
        this.region = region;
        this.pokemonLab = pokemonLab;
        this.objetosIniciales = objetosIniciales;
    }

    public Professor(String nombre, Type especialidad, Region region) {
        super(nombre);
        this.tipo = especialidad;
        this.region = region;
    }

//    Metdodos
    public void deliverStarterPokemon(Trainer trainer, Integer opc) {
        if (opc >= 0 && opc < pokemonLab.size()) {
            Pokemon pokemon = pokemonLab.get(opc - 1);
            trainer.addPokemon(pokemon);
            print(trainer.getNombre() + CHOSEN_POKEMON + pokemon.getNombre());
        }
    }

    public String researchPokemon(Pokemon pokemon) {
//        Antes tenia puesto el "\n" pero me saltaba fallo, y usando el System.lineSeparator() me lo coge bien
        String resultado = "El pokémon: " + pokemon.getNombre() + " está siendo investigado por el profesor: " + getNombre() + System.lineSeparator() +
                "Estos son los resultados: " + System.lineSeparator() + pokemon.toString();
        return resultado;
    }

//    Funciones
    private static void print(String frase) {
        System.out.println(frase);
    }

    private static void printError(String frase) {
        System.err.println(frase);
    }
}