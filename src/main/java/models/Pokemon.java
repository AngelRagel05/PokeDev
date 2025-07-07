package models;

import models.enumerations.Item;
import models.enumerations.Nature;
import models.enumerations.Type;
import models.interfaces.iPokemon;

public class Pokemon implements iPokemon {

    private final static String INCORRECT_ITEM = "Ha elegido el item incorrecto.";
    private final static String CURE_POKEMON = "Se ha curado a su Pokemon";
    private final static String NO_LEVEL_UP = "No se puede subir más de nivel";
    private final static String LEVEL_UP = "Su pokemon a subido de nivel";
    private final static String REVIVE = "Su pokemon ha revivido";

//    Atributos
    protected Integer numPokedex;
    protected String nombre;
    protected String descripcionPokemon;
    protected Double salud;
    protected Double maxSalud;
    protected Integer nivel;
    protected Boolean shinny;
    protected Nature naturaleza;
    protected Type tipo;

//    Constructor
    public Pokemon(Integer numPokedex, String nombre, String descripcionPokemon, Double salud, Double maxSalud, Integer nivel, Boolean shinny, Nature naturaleza, Type tipo) {
        this.numPokedex = numPokedex;
        this.nombre = nombre;
        this.descripcionPokemon = descripcionPokemon;
        this.salud = salud;
        this.maxSalud = maxSalud;
        this.nivel = nivel;
        this.shinny = shinny;
        this.naturaleza = naturaleza;
        this.tipo = tipo;
    }

    public Pokemon(Integer numPokedex, String nombre, String descripcionPokemon) {
        this.numPokedex = numPokedex;
        this.nombre = nombre;
        this.descripcionPokemon = descripcionPokemon;
    }

//    Metodos
    public void cure(Item item) {
        if (item.equals(Item.POTION)) {
            if (salud + 100 > maxSalud) {
                salud = maxSalud;
            } else {
                salud = salud + 100;
            }
            print(CURE_POKEMON);
        } else if (item.equals(Item.FULL_RESTORE)) {
            salud = maxSalud;
            print(CURE_POKEMON);
        } else {
            print(INCORRECT_ITEM);
        }
    }

    public void levelUp(Item item) {
        if (item.equals(Item.RARE_CANDY)) {
            if (this.nivel != 100.00) {
                this.nivel = this.getNivel() + 1;
                print(LEVEL_UP);
            } else {
                print(NO_LEVEL_UP);
            }
        } else {
            print(INCORRECT_ITEM);
        }
    }

    public void revive(Item item) {
        if (item.equals(Item.REVIVE)) {
            salud = maxSalud;
            print(REVIVE);
        } else {
            print(INCORRECT_ITEM);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Type getTipo() {
        return tipo;
    }

    public Integer getNivel() {
        return nivel;
    }

    public Double getSalud() {
        return salud;
    }

//    Funciones
    private static void print(String frase) {
        System.out.println(frase);
    }

    @Override
    public String toString() {
        return "===========================\n" +
                "        POKÉMON\n" +
                "===========================\n" +
                "Nombre       : " + nombre + "\n" +
                "Descripción  : " + descripcionPokemon + "\n" +
                "Shiny        : " + (shinny ? "Sí" : "No") + "\n" +
                "Nivel        : " + nivel + "\n" +
                "===========================";
    }
}