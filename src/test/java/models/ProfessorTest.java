package models;

import models.enumerations.Item;
import models.enumerations.Nature;
import models.enumerations.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest {

    Pokemon pikachu;
    Pokemon charmander;
    Pokemon bulbasur;
    Region sevilla;
    List<Pokemon> pokemonsIniciales;
    ArrayList<Item> itemsIniciales;
    Professor profesor;
    Trainer ash;



    @BeforeEach
    void setUp() {
//        Creo todos los objetos para poder crear al profesor
        sevilla = new Region("Sevilla", "Ciudad no tan bonita como Córdoba");

        pikachu = new Pokemon(1, "Pikachu", "Rata eléctrica", 300.00, 300.00, 15, false, Nature.AFABLE, Type.ELECTRICO);
        charmander = new Pokemon(2, "Charmander", "Dragon chico", 300.00, 300.00, 48, false, Nature.ALOCADA, Type.FUEGO);
        bulbasur = new Pokemon(3, "Bulbasur", "Coballa plantificada", 300.00, 300.00, 78, false, Nature.FIRME, Type.PLANTA);

        pokemonsIniciales = new ArrayList<>();
        pokemonsIniciales.add(pikachu);
        pokemonsIniciales.add(charmander);
        pokemonsIniciales.add(bulbasur);

        itemsIniciales = new ArrayList<>(Arrays.asList(
                Item.POTION,
                Item.POKEBALL,
                Item.FULL_RESTORE,
                Item.RARE_CANDY,
                Item.REVIVE
        ));
        profesor = new Professor("Soraya", Type.HADA, sevilla, pokemonsIniciales, itemsIniciales);
        ash = new Trainer("Ash", 800.00, new ArrayList<>(Arrays.asList(
                charmander, bulbasur
        )));
    }

    @Test
    void deliverStarterPokemon() {
        profesor.deliverStarterPokemon(ash, 1);

        assertTrue(ash.getPokemons().contains(pikachu), "El Pokémon seleccionado no fue añadido al equipo de Ash.");
    }

    @Test
    void researchPokemon() {
        String esperado = "El pokémon: " + pikachu.getNombre() + " está siendo investigado por el profesor: " + profesor.getNombre() + System.lineSeparator() +
                "Estos son los resultados: " + System.lineSeparator() + pikachu.toString();

        assertEquals(esperado, profesor.researchPokemon(pikachu), "El método researchPokemon no devuelve la salida esperada.");
    }
}