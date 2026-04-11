package Entidades.Humano;

public enum tipoHumano {
    //TYPES
    SOLDADO(1, 1),
    ESPECIALISTA(1, 2),
    BLINDADO(2, 1);

    //ATRIBUTES
    public final int endurance;
    public final int activations;

    //CONSTRUCTOR
    private tipoHumano(int endurance, int activations) {
        this.endurance = endurance;
        this.activations = activations;
    }
}
