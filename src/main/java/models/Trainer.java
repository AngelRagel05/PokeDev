package models;

import models.abstracts.Person;
import models.enumerations.Item;
import models.enumerations.Nature;
import models.enumerations.SubType;
import models.enumerations.Type;
import models.interfaces.iTrainer;

import java.util.*;

public class Trainer extends Person implements iTrainer  {

    private static Scanner sc = new Scanner(System.in);

    private static final String CHOOSE_NATURE = "Elige una naturaleza del pokémon.";
    private static final String CHOOSE_NUMBER_NATURE = "Elige el número correspondiente a la naturaleza.";

    private static final String CHOOSE_TYPE = "Elige un tipo del pokémon.";
    private static final String CHOOSE_NUMBER_TYPE = "Elige el número correspondiente al tipo.";

    private static final String INVALID_OPTION = "Opción inválida. Introduce un número entre 1 y ";
    private static final String INVALID_ENTRY = "Entrada no válida. Ingresa un número.";
    private static final String NEGATIVE_ENTRY = "Este campo no puede ser negativo.";
    private static final String INCORRECT_ITEM = "El item elegido no sirve para capturar pokémon.";

    private static final String POKEMON_ID = "Cuál es el número de la pokedex de su pokémon.";
    private static final String POKEMON_NAME = "Que nombre tendrá el pokémon.";
    private static final String POKEMON_DESCRIPTION = "Que descripción tendrá en pokémon.";
    private static final String POKEMON_HEALTH = "Que vida actual tendrá el pokémon.";
    private static final String POKEMON_MAX_HEALTH = "Que vida máxima tendrá el pokémon.";
    private static final String POKEMON_SHINNY = "El pokémon es shinny, introduce false si es falso o true si es verdadero.";

//    Atributos
    protected Double recompensa;
    protected ArrayList<Pokemon> pokemons;
    protected ArrayList<Medal> medallas;
    protected ArrayList<Item> items;

//    Constructor
    public Trainer(String nombre, Double recompensa, ArrayList<Pokemon> pokemonsT, ArrayList<Medal> medallas, ArrayList<Item> items) {
        super(nombre);
        this.recompensa = recompensa;
        this.pokemons = pokemonsT;
        this.medallas = medallas;
        this.items = items;
    }

    public Trainer (String nombre, Double recompensa, ArrayList<Pokemon> pokeTrainer) {
        super(nombre);
        this.recompensa = recompensa;
        this.pokemons = pokeTrainer;
    }

    public Trainer (String nombre, Double recompensa) {
        super(nombre);
        this.recompensa = recompensa;
    }

//    Metodos
    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public boolean combatTrainer(Trainer lider, Trainer visitante) {
        List<Pokemon> pokemonsLider = lider.getPokemons().subList(0, 5);
        List<Pokemon> pokemonsVisitante = visitante.getPokemons().subList(0, 5);

        int combatesGanadosLider = 0, combatesGanadosVisitante = 0;

        for (int i = 0; i < 5; i++) {
            Pokemon pLider = pokemonsLider.get(i), pVisitante = pokemonsVisitante.get(i);
            boolean liderGana = checkAdvantage(pLider, pVisitante);
            boolean visitanteGana = checkAdvantage(pVisitante, pLider);

            if (liderGana ^ visitanteGana) { // Solo uno gana
                if (liderGana) combatesGanadosLider++;
                else combatesGanadosVisitante++;
            } else { // Empate, decidir por nivel
                if (pLider.getNivel() > pVisitante.getNivel()) combatesGanadosLider++;
                else if (pVisitante.getNivel() > pLider.getNivel()) combatesGanadosVisitante++;
            }
        }
        return combatesGanadosVisitante > combatesGanadosLider;
    }

    public boolean capture(Item item) {
        boolean capturar = false;
        if (item == Item.POKEBALL) {
            print("Has capturado al pokemon");
            capturar = true;
        } else {
            printError(INCORRECT_ITEM);
        }
        return capturar;
    }

    public List<Pokemon> getPokemons() {
        return new ArrayList<>(pokemons);
    }

//    Funciones
    private boolean checkAdvantage(Pokemon atacante, Pokemon defensor) {
        return hasTypeAdvantage(atacante.getTipo(), defensor.getTipo()) ||
                hasSubTypeAdvantage(atacante.getTipo().getSubtipos(), defensor.getTipo().getSubtipos());
    }

    private boolean hasTypeAdvantage(Type atacante, Type defensor) {
        Map<Type, List<Type>> ventajas = new HashMap<>();

        ventajas.put(Type.AGUA, List.of(Type.FUEGO, Type.ROCA, Type.TIERRA));
        ventajas.put(Type.FUEGO, List.of(Type.PLANTA, Type.HIELO, Type.BICHO, Type.ACERO));
        ventajas.put(Type.PLANTA, List.of(Type.AGUA, Type.ROCA, Type.TIERRA));
        ventajas.put(Type.ELECTRICO, List.of(Type.AGUA));
        ventajas.put(Type.HIELO, List.of(Type.PLANTA, Type.TIERRA, Type.DRAGON, Type.VOLADOR));
        ventajas.put(Type.LUCHA, List.of(Type.NORMAL, Type.HIELO, Type.ROCA, Type.SINIESTRO, Type.ACERO));
        ventajas.put(Type.BICHO, List.of(Type.PLANTA, Type.PSIQUICO, Type.SINIESTRO));
        ventajas.put(Type.VOLADOR, List.of(Type.PLANTA, Type.LUCHA, Type.BICHO));
        ventajas.put(Type.PSIQUICO, List.of(Type.LUCHA, Type.VENENO));
        ventajas.put(Type.SINIESTRO, List.of(Type.PSIQUICO, Type.FANTASMA));
        ventajas.put(Type.FANTASMA, List.of(Type.PSIQUICO, Type.FANTASMA));
        ventajas.put(Type.VENENO, List.of(Type.PLANTA, Type.HADA));
        ventajas.put(Type.ACERO, List.of(Type.HIELO, Type.ROCA, Type.HADA));
        ventajas.put(Type.DRAGON, List.of(Type.DRAGON));
        ventajas.put(Type.HADA, List.of(Type.DRAGON, Type.SINIESTRO, Type.LUCHA));

        return ventajas.getOrDefault(atacante, List.of()).contains(defensor);
    }

    private boolean hasSubTypeAdvantage(SubType[] atacante, SubType[] defensor) {
        Map<SubType, SubType> ventajas = Map.of(
                SubType.FUEGO, SubType.VOLADOR,
                SubType.AGUA, SubType.TIERRA,
                SubType.PLANTA, SubType.VENENO,
                SubType.ELECTRICO, SubType.VOLADOR,
                SubType.PSIQUICO, SubType.HIELO,
                SubType.ROCA, SubType.TIERRA,
                SubType.LUCHA, SubType.FANTASMA,
                SubType.DRAGON, SubType.VENENO
        );
        return Arrays.stream(atacante).anyMatch(a -> Arrays.stream(defensor).anyMatch(d -> ventajas.getOrDefault(a, null) == d));
    }

    private static void print(String frase) {
        System.out.println(frase);
    }

    private static void printError(String frase) {
        System.err.println(frase);
    }
}