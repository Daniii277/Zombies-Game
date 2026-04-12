/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;
import Juego.Casilla;


public abstract class Entidad {
    private Casilla casillaActual;
    private estado state;

    public Entidad(){
        this.casillaActual = null;
        this.state = estado.ACTIVO;
    }

    //GETTERS AND SETTERS
    public void setCasillaActual(Casilla casilla){
        this.casillaActual = casilla;
    }

    public void setState(estado newState){
        this.state = newState;
    }

    public Casilla getCasillaActual(){
        return this.casillaActual;
    }

    public estado getState(){
        return this.state;
    }

    public abstract void move(Casilla c);
}
