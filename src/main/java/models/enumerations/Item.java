package models.enumerations;

public enum Item {

    POKEBALL("Una cápsula especial usada para atrapar Pokémon salvajes."),
    POTION("Restaura 100 puntos de salud de un Pokémon."),
    REVIVE("Revive a un Pokémon debilitado con la mitad de su salud máxima."),
    FULL_RESTORE("Restaura toda la salud y elimina cualquier problema de estado de un Pokémon."),
    RARE_CANDY("Aumenta instantáneamente en un nivel al Pokémon que lo consume.");

    private final String descripcion;

    private Item(String descripcion) {
        this.descripcion = descripcion;
    }

//    Metodos
    public String getDescripcion() {
        return descripcion;
    }
}