package Entidades.Humano;
import Entidades.Comestible;

public class Humano implements Comestible {
    private int endurance;
    private int activations;

    //CONSTRUCTOR
    public Humano(int endurance, int activations){
        this.endurance = endurance;
        this.activations = activations;
    }

     
}