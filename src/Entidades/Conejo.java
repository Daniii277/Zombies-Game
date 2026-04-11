/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;



public class Conejo extends Entidad implements Comestible {

    private final String name;

    //CONSTRUCTOR
    public Conejo(String name){
        this.name = name;
    }

    //GETTERS
    public String getName(){
        return this.name;
    }

    //METHODS
    public void eaten(){

    }

    @Override
    public String toString(){
        return ("\nnombre : " + this.name +
                "\nCasilla : " + this.getCasillaActual().toString() + "\n"
        );
    }
}
