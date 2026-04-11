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
    private ArrayList<Zombie> players;

    public Tablero(int size){
        this.size = size;
        this.board = new Casilla[size][size];
        this.entities = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    //GETTERS
    public int getSize(){
        return this.size;
    }

    public ArrayList<Entidad> getEntities(){
        return this.entities;
    }

    public ArrayList<Zombie> getPlayers(){
        return this.players;
    }


    //METHODS
    @Override
    public String toString(){
        return("");
    }

}
