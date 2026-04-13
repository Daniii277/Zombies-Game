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
    private final Casilla targetBox;
    private static int idRabbit = 0;


    public Tablero(int size){
        this.size = size;
        this.board = new Casilla[size][size];
        this.entities = new ArrayList<>();
        this.targetBox = new Casilla(size, size);
    }

    //GETTERS
    public int getSize(){
        return this.size;
    }

    public ArrayList<Entidad> getEntities(){
        return this.entities;
    }

    public Casilla getTargetBox(){
        return this.targetBox;
    }

    public Casilla[][] getBoard(){
        return this.board;
    }

    public Casilla getBox(int x, int y){
        return board[x][y];
    }

    public int getIdRabbit(){
        return idRabbit;
    }

    //METHODS
    
    public void incrementIdRabbits(){
        idRabbit++;
    }

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
        e.getCasillaActual().eliminateEntity(e);
        //Se marca como eliminado
        e.setState(estado.ELIMINADO);
        
    }

    public void addEntity(Entidad e, Casilla c){
        //Se añade a la entidad su casilla actual
        e.setCasillaActual(c);
        //Se añade la entidad a la lista de entidades de la casilla
        c.addEntity(e);

    }



    @Override
    public String toString(){
        return("Tamaño del tablero : " + this.size +
                "Entidades : " + this.entities
        );
    }

}