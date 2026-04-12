/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juego;
import java.util.*;
import Entidades.*;


public class Tablero  {
    private final int size;
    private final Casilla[][] board;
    private ArrayList<Entidad> entities;


    public Tablero(int size){
        this.size = size;
        this.board = new Casilla[size][size];
        this.entities = new ArrayList<>();
    }

    //GETTERS
    public int getSize(){
        return this.size;
    }

    public ArrayList<Entidad> getEntities(){
        return this.entities;
    }


    //METHODS
    
    public void moveEntity(Entidad e, Casilla c){
        //Se realiza el movimiento si la casilla esta dentro del rango de casillas del tablero
        if(c.getCoordX() <= this.size && c.getCoordY() <= this.size){
            e.move(c);
        }
    }

    public void deleteEntity(Entidad e){
        //Se borra la entidad de la lista de entidades del tablero
        this.entities.remove(e);
        //Se borra la entidad de la casilla en la que estaba
        e.getCasillaActual().getEntidades().remove(e);
        //Si es un zombie se marca como eliminado
        if(e instanceof Zombie){
            e.setState(estado.ELIMINADO);
        }
    }

    public void addEntity(Entidad e, Casilla c){
        //Se añade a la entidad su casilla actual
        e.setCasillaActual(c);
        //Se añade la entidad a la lista de entidades de la casilla
        c.getEntidades().add(e);

    }


    @Override
    public String toString(){
        return("Tamaño del tablero : " + this.size +
                "Entidades : " + this.entities
        );
    }

}
