/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades.Humano;

import Entidades.Entidad;

public class humanoHuidizo extends Humano{

    //CONSTRUCTOR
   public humanoHuidizo(){
        super(1,1);    
   }

   //METHODS
    @Override
    public String toString(){
        return(super.toString() + "\nTipo : Huidizo");
    }

    @Override
    public void attack(Zombie e) {

    }
}

