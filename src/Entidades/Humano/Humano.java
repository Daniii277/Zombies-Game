package Entidades.Humano;
import Juego.Casilla;
import Entidades.*;

public abstract class Humano extends Entidad implements Comestible {
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
    public void eaten(Zombie z){
        z.setHungerLevel(0);
    }

    @Override
    public String toString(){
        return("\naguante : " + this.endurance + 
                "\nactivaciones : " + this.activations + "\n"
        );
    }

    @Override
    public void move(Casilla c) {
        this.getCasillaActual().getEntidades().remove(this);
        this.setCasillaActual(c);
        c.addEntity(this);
    }

    public abstract void attack(Zombie e);
     
}