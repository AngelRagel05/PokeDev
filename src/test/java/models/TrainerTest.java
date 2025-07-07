package models;

import models.enumerations.Item;
import models.enumerations.Nature;
import models.enumerations.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {

    Pokemon squirtle;
    Pokemon pikachu;
    Pokemon jigglypuff;
    Pokemon onix;
    Pokemon machop;
    Pokemon psyduck;
    Pokemon zubat;
    Pokemon eevee;
    Pokemon growlithe;
    Pokemon sandshrew;
    ArrayList<Medal> medallas;
    ArrayList<Item> items;
    ArrayList<Pokemon> pokemonEntrenador;
    Trainer entrenador;
    ArrayList<Pokemon> pokemonAngel;
    ArrayList<Pokemon> pokemonJuanca;
    Trainer lider;
    Trainer visitante;

    @BeforeEach
    void setUp() {
//        Creo 10 pokemons para poder simular la batalla se lo pedí a chato
        squirtle = new Pokemon(4, "Squirtle", "Tortuga acuática", 300.00, 300.00, 45, false, Nature.FIRME, Type.AGUA);
        jigglypuff = new Pokemon(5, "Jigglypuff", "Bola de canto", 300.00, 300.00, 20, false, Nature.ALOCADA, Type.NORMAL);
        onix = new Pokemon(6, "Onix", "Serpiente de roca", 300.00, 300.00, 30, false, Nature.PICARA, Type.ROCA);
        machop = new Pokemon(7, "Machop", "Pokémon luchador", 300.00, 300.00, 50, false, Nature.FUERTE, Type.LUCHA);
        psyduck = new Pokemon(8, "Psyduck", "Pato confundido", 300.00, 300.00, 35, false, Nature.FUERTE, Type.AGUA);
        zubat = new Pokemon(9, "Zubat", "Murciélago venenoso", 300.00, 300.00, 20, false, Nature.FUERTE, Type.VOLADOR);
        eevee = new Pokemon(10, "Eevee", "Eevee evolutivo", 300.00, 300.00, 25, false, Nature.PICARA, Type.NORMAL);
        growlithe = new Pokemon(11, "Growlithe", "Perro fuego", 300.00, 300.00, 40, false, Nature.PICARA, Type.FUEGO);
        sandshrew = new Pokemon(12, "Sandshrew", "Pokémon topo", 300.00, 300.00, 30, false, Nature.FUERTE, Type.TIERRA);
        pikachu = new Pokemon(1, "Pikachu", "Rata eléctrica", 300.00, 300.00, 15, false, Nature.AFABLE, Type.ELECTRICO);

        pokemonAngel = new ArrayList<>(Arrays.asList(
                squirtle,eevee , onix, machop, psyduck
        ));
        pokemonJuanca = new ArrayList<>(Arrays.asList(
                zubat, jigglypuff, growlithe, sandshrew, pikachu
        ));

        visitante = new Trainer("Ángel", 5000.00, pokemonAngel);
        lider = new Trainer("Juanca", 900.00, pokemonJuanca);

        entrenador = new Trainer("Soraya", 900.00, pokemonEntrenador, medallas, items);
    }

    @Test
    void addPokemon() {
        visitante.addPokemon(pikachu);
        assertTrue(visitante.getPokemons().contains(pikachu), "El pokemon se debería dd haber añadido");
    }

    @Test
    void combatTrainer() {
        boolean resultado = entrenador.combatTrainer(lider, visitante);
        assertTrue(resultado);
    }

    @Test
    void capture() {
        boolean resultado = visitante.capture(Item.POKEBALL);
        assertTrue(resultado, "La captura puede haber acertado");
    }

    @Test
    void getPokemons() {
        visitante.getPokemons();
        assertNotNull(pokemonAngel, "La lista no debe ser nula");
        assertTrue(pokemonAngel.contains(eevee), "La lista debe contener a Eevee");
    }
}