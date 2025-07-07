package models;

import models.enumerations.Nature;
import models.enumerations.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GymTest {

    Pokemon pikachu;
    Pokemon squirtle;
    Pokemon jigglypuff;
    Pokemon onix;
    Pokemon machop;
    Pokemon psyduck;
    Pokemon zubat;
    Pokemon eevee;
    Pokemon growlithe;
    Pokemon sandshrew;
    ArrayList<Pokemon> pokemonAngel;
    ArrayList<Pokemon> pokemonJuanca;
    Region region;
    Medal medalla;
    Trainer lider;
    Trainer visitante;
    Gym gimnasio;

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
                zubat, jigglypuff, growlithe, sandshrew,pikachu
        ));

        region = new Region("Andalucía", "La tierra de los sueños");
        medalla = new Medal("Oro", "Medalla de oro obtenida al aprobar sistemas");
        visitante = new Trainer("Ángel", 5000.00, pokemonAngel);
        lider = new Trainer("Juanca", 900.00, pokemonJuanca);
        gimnasio = new Gym("AltaFit", "Gimnasio lleno de gitanos", "Málaga", lider, Type.ACERO, medalla, region);
    }

    @Test
    void winMedal() {
        boolean resultado = gimnasio.combatLeader(lider, visitante);
        assertTrue(resultado);
    }

    @Test
    void getNombre() {
        assertEquals("AltaFit", gimnasio.getNombre(), "El gimnasio se debería de llamar 'Altafit'");
    }
}