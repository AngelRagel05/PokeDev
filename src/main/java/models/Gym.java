package models;

import models.enumerations.SubType;
import models.enumerations.Type;
import models.interfaces.iGym;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gym implements iGym {

//    Atributos
    protected String nombre;
    protected String descripcionGym;
    protected String ciudad;
    protected Trainer lider;
    protected Type tipo;
    protected Medal medalla;
    protected Region region;

//    Constructor
    public Gym(String nombre, String descripcionGym, String ciudad, Trainer lider, Type tipo, Medal medalla, Region region) {
        this.nombre = nombre;
        this.descripcionGym = descripcionGym;
        this.ciudad = ciudad;
        this.lider = lider;
        this.tipo = tipo;
        this.medalla = medalla;
        this.region = region;
    }

    public Gym(String nombre, String descripcionGym) {
        this.nombre = nombre;
        this.descripcionGym = descripcionGym;
    }

//    Métodos
    public boolean winMedal(Trainer lider, Trainer visitante) {
        return combatLeader(lider, visitante);
    }

    public String getNombre() {
        return this.nombre;
    }

//    Funciones
    protected boolean combatLeader(Trainer lider, Trainer visitante) {
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
}