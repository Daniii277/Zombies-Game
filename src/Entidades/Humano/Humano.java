package Entidades.Humano;
import Juego.Casilla;
import Entidades.*;

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
    public String toString(){
        return("\naguante : " + this.endurance + 
                "\nactivaciones : " + this.activations + "\n"
        );
    }

    @Override
    public void move(Casilla c) {
        //Se elimina de la lista de entidades de su casilla anterior
        this.getCasillaActual().getEntidades().remove(this);
        //Se modifica la casilla actual en la entidad
        this.setCasillaActual(c);

    }
     
}