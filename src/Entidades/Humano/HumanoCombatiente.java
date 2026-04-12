/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades.Humano;

import Entidades.Entidad;
import Entidades.Zombie;

public class humanoCombatiente extends Humano {
    
    private tipoHumano type;

    //CONSTRUCTOR
    public humanoCombatiente(tipoHumano type){   
        super(type.endurance, type.activations);
        this.type = type;
    }

    //GETTERS
    public tipoHumano getType(){
        return this.type;
    }

    //METHODS
    @Override
    public String toString(){
        return(super.toString() + "\nTipo : " + this.type);
    }

    @Override
    public void attack(Zombie e) {
        e.getDamage(1);
    }


}
