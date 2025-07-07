package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedalTest {

    Medal medalla;

    @BeforeEach
    void setUp() {
        medalla = new Medal("Oro", "Medalla de oro");
    }

    @Test
    void getNombre() {
        assertEquals("Oro", medalla.getNombre());
    }
}