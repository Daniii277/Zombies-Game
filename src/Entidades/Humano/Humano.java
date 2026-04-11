package Entidades.Humano;
import Entidades.Comestible;
import Entidades.Entidad;

public class Humano extends Entidad implements Comestible {
    private int endurance;
    private int activations;

    //CONSTRUCTOR
    public Humano(int endurance, int activations){
        this.endurance = endurance;
        this.activations = activations;
    }

    //GETTERS
    public int getEndurance(){
        return this.endurance;
    }

    public int getActivations(){
        return this.activations;
    }

    //METHODS
    @Override
    public void eaten(){

    }

    @Override
    public void move() {

    }

    @Override
    public void attack() {

    }

    public void doNothing(){

    }

    public void searchFood(){

    }

     
}