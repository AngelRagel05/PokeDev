package models;

import models.enumerations.Item;
import models.enumerations.Nature;
import models.enumerations.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PokemonTest {

    Pokemon pikachu;

    @BeforeEach
    void setUp() {
        pikachu = new Pokemon(1, "Pikachu", "Rata electrica", 100.00, 300.00, 15, false, Nature.AFABLE, Type.ELECTRICO);
    }

    @Test
    void cure_WithPotion() {
        pikachu.cure(Item.POTION);
        assertEquals(200, pikachu.getSalud(), "Su pokemon se ha curado");
    }

    @Test
    void cure_WithFullRestore() {
        pikachu.cure(Item.FULL_RESTORE);
        assertEquals(300, pikachu.getSalud(), "Su pokemon se ha curado");
    }

    @Test
    void cure_RareCandy() {
        pikachu.cure(Item.RARE_CANDY);
    }

    @Test
    void levelUp_RareCandy() {
        pikachu.levelUp(Item.RARE_CANDY);
        assertEquals(16, pikachu.getNivel(), "Su pokemon se ha curado");
    }

    @Test
    void levelUp_Potion() {
        pikachu.levelUp(Item.POTION);
        assertEquals(15, pikachu.getNivel(), "Pikachu no se deberia de curar");
    }

    @Test
    void revive_Potion() {
        pikachu.revive(Item.POTION);
        assertEquals(100, pikachu.getSalud(), "Pikachu no deberia revivir");
    }

    @Test
    void revive_Revive() {
        pikachu.revive(Item.REVIVE);
        assertEquals(300, pikachu.getSalud(), "Pikachu ha revivido");
    }

    @Test
    void getNombre() {
        assertEquals("Pikachu", pikachu.getNombre(), "Pikachu se deberia llamar Pikachu");
    }

    @Test
    void getTipo() {
        assertEquals(Type.ELECTRICO, pikachu.getTipo(), "Pikachu es de tipo Electrico");
    }

    @Test
    void getNivel() {
        assertEquals(15, pikachu.getNivel(), "Pikachu deberia de tener 15 niveles");
    }

    @Test
    void getSalud() {
        assertEquals(100, pikachu.getSalud(), "Pikachu deberia de tener 100 de salud");
    }

    @Test
    void testToString() {
        String esperado =  "===========================\n" +
                "        POKÉMON\n" +
                "===========================\n" +
                "Nombre       : Pikachu\n" +
                "Descripción  : Rata electrica\n" +
                "Shiny        : No\n" +
                "Nivel        : 15\n" +
                "===========================";
        assertEquals(esperado, pikachu.toString(), "El método toString() no devuelve la salida esperada.");
    }
}