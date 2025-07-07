package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegionTest {

    List<Medal> medallas;
    List<Pokemon> pokemons;
    List<Gym> gimnasios;
    ArrayList<Trainer> entrenadores;
    Region kanto;

    @BeforeEach
    void setUp() {
//        Creo dos objetos de cada
        medallas = new ArrayList<>(Arrays.asList(
                new Medal("Oro", "Medalla de oro"),
                new Medal("Plata", "Medalla de plata")
        ));
        pokemons = new ArrayList<>(Arrays.asList(
                new Pokemon(1, "Pikachu", "Rata eléctrica"),
                new Pokemon(2, "Bulbasur", "Gusano de planta")
        ));
        gimnasios = new ArrayList<>(Arrays.asList(
                new Gym("AltaFit", "Gimnasio lleno de personas 'FIT'"),
                new Gym("InnerJoin", "Gimnsaio que cruza tablas")
        ));
        entrenadores = new ArrayList<>(Arrays.asList(
                new Trainer("Ash", 800.00),
                new Trainer("Olga", 1000.00)
        ));
        kanto = new Region("Kanto", "Kanto es una región", medallas, pokemons, gimnasios, entrenadores);
    }

    @Test
    void showMedals() {
//        Creo una copia de la lista
        List<Medal> medallasRegion = kanto.showMedals();

//        Verifico que el tamaño sea correcto
        assertEquals(2, medallasRegion.size(), "La región debería tener dos medallas");

//        Verifico que los nombres de los objetos sean iguales
        assertEquals("Oro", medallasRegion.get(0).getNombre(), "La primera medalla se debería de llamar 'Oro'");
        assertEquals("Plata", medallasRegion.get(1).getNombre(), "La segunda medalla se debería de llamar 'Plata'");
    }

    @Test
    void showPokemons() {
//        Creo una copia de la lista
        List<Pokemon> pokemonRegion = kanto.showPokemons();

//        Verifico que el tamaño sea correcto
        assertEquals(2, pokemonRegion.size(), "La región debería de tener dos pokemons");

//        Verifico que los nombres de los objetos sean iguales
        assertEquals("Pikachu", pokemonRegion.get(0).getNombre(), "El primer pokemon se debería de llamar 'Pikachu'");
        assertEquals("Bulbasur", pokemonRegion.get(1).getNombre(), "El segundo pokemon se debería de llamar 'Bulbasur'");
    }

    @Test
    void showGym() {
//        Creo una copia de la lista
        List<Gym> gimnasiosRegion = kanto.showGym();

//        Verifico que el tamaño sea correcto
        assertEquals(2, gimnasiosRegion.size(), "La región debería tener dos regiones");

//        Verifico que los nombres de los objetos sean iguales
        assertEquals("AltaFit", gimnasiosRegion.get(0).getNombre(), "El primer gimnasio se debería llamar 'AltaFit'");
        assertEquals("InnerJoin", gimnasiosRegion.get(1).getNombre(), "El segundo gimnasio se debería llamar 'InnerJoin'");
    }

    @Test
    void showTrainers() {
//        Creo una copia de la lista
        ArrayList<Trainer> entrenadoresRegion = kanto.showTrainers();

//        Verifico que el tamaño sea correcto
        assertEquals(2, entrenadoresRegion.size(), "En la región debería haber dos entrenadores");

//        Verifico que los nombres de los objetos sean iguales
        assertEquals("Ash", entrenadoresRegion.get(0).getNombre(), "El primer entrenador se debería llamar 'Ash'");
        assertEquals("Olga", entrenadoresRegion.get(1).getNombre(), "El segundo entrenador se debería llamar 'Olga'");
    }

    @Test
    void addTrainer() {
//        Creo un nuevo entrenador
        Trainer nuevoEntrenador = new Trainer("Juanca", 900.00);

//        Lo añado a la lista
        kanto.addTrainer(nuevoEntrenador);

//        Verifico que el entrenador esté en la lista
        assertTrue(kanto.showTrainers().contains(nuevoEntrenador), "El entrenador debería estar en la lista");
    }
}