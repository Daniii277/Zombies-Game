/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;
import Juego.Casilla;


public abstract class Entidad {
    private Casilla casillaActual;


    public Entidad(){
        this.casillaActual = null;
    }

    //GETTERS AND SETTERS
    public void setCasillaActual(Casilla casilla){
        this.casillaActual = casilla;
    }

    public Casilla getCasillaActual(){
        return this.casillaActual;
    }

    //METHODS
    public void move() {
        
    }

    public void attack(){

    }
}
