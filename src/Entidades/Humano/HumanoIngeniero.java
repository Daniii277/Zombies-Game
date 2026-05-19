/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades.Humano;

import java.util.Random;
import Entidades.Entidad;
import Entidades.Zombie;

/**
 *
 * @author danie
 */
public class humanoIngeniero extends Humano{
    //CONSTRUCTOR
    public humanoIngeniero(){
        super(3,1);
    }

    //METHODS
    @Override
    public String toString(){
        return(super.toString() + "\nTipo : Ingeniero");
    }

    @Override
    public void eaten(Zombie z){
        Random rnd = new Random();
        if(rnd.nextInt(2) == 0){
            z.getDamage(1);
        }
        if(z.getHungerLevel() >= 4){
            z.setHungerLevel(z.getHungerLevel() - 2);
        }
    }

    @Override
    public void attack(Zombie e) {
        if(e.getCasillaActual().equals(this.getCasillaActual())){
            e.getDamage(2);
        }else{
            e.getDamage(1);
        }
    }
}
