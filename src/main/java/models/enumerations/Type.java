package models.enumerations;

public enum Type {
    AGUA(SubType.AGUA),
    FUEGO(SubType.FUEGO),
    PLANTA(SubType.PLANTA),
    ROCA(SubType.ROCA),
    TIERRA(SubType.TIERRA),
    ELECTRICO(SubType.ELECTRICO),
    HIELO(SubType.HIELO),
    LUCHA(SubType.LUCHA),
    BICHO(SubType.BICHO),
    VOLADOR(SubType.VOLADOR),
    PSIQUICO(SubType.PSIQUICO),
    SINIESTRO(SubType.SINIESTRO),
    FANTASMA(SubType.FANTASMA),
    VENENO(SubType.VENENO),
    ACERO(SubType.ACERO),
    DRAGON(SubType.DRAGON),
    HADA(SubType.HADA),
    NORMAL(SubType.NORMAL),

    FUEGO_VOLADOR(SubType.FUEGO, SubType.VOLADOR),
    AGUA_TIERRA(SubType.AGUA, SubType.TIERRA),
    PLANTA_VENENO(SubType.PLANTA, SubType.VENENO),
    ELECTRICO_VOLADOR(SubType.ELECTRICO, SubType.VOLADOR),
    PSIQUICO_HIELO(SubType.PSIQUICO, SubType.HIELO),
    ROCA_TIERRA(SubType.ROCA, SubType.TIERRA),
    LUCHA_FANTASMA(SubType.LUCHA, SubType.FANTASMA),
    DRAGON_VENENO(SubType.DRAGON, SubType.VENENO),
    FUEGO_HIELO(SubType.FUEGO, SubType.HIELO),
    NORMAL_VENENO(SubType.NORMAL, SubType.VENENO),

    AGUA_FANTASMA(SubType.AGUA, SubType.FANTASMA),
    ELECTRICO_ACERO(SubType.ELECTRICO, SubType.ACERO),
    DRAGON_HADA(SubType.DRAGON, SubType.HADA),
    TIERRA_FANTASMA(SubType.TIERRA, SubType.FANTASMA),
    FUEGO_ACERO(SubType.FUEGO, SubType.ACERO),
    PLANTA_FANTASMA(SubType.PLANTA, SubType.FANTASMA),
    PSIQUICO_SINIESTRO(SubType.PSIQUICO, SubType.SINIESTRO),
    ELECTRICO_HADA(SubType.ELECTRICO, SubType.HADA),
    FUEGO_SINIESTRO(SubType.FUEGO, SubType.SINIESTRO),
    AGUA_HADA(SubType.AGUA, SubType.HADA);

    private SubType[] subtipos;

//    Constructor
//    Usa un parámetro varargs, sirve para poder recibir ningun o varios valores de tipo SubType
//    Me lo ha dado el ChatGPT, no sabia como organizarme con los tipos y le pedi ayuda al chato
    Type(SubType... subtipos) {
        this.subtipos = subtipos;
    }

    public SubType[] getSubtipos() {
        return subtipos;
    }
}
