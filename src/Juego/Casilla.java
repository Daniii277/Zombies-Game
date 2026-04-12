/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juego;
import java.util.*;
import Entidades.Entidad;


public class Casilla  {
    private int coordX;
    private int coordY;
    private ArrayList<Entidad> entidades;

    
    public Casilla(int x, int y){
        this.coordX = x;
        this.coordY = y;
        this.entidades = new ArrayList<>();
    }

    //GETTERS AND SETTERS
    public int getCoordX(){
        return this.coordX;
    }

    public int getCoordY(){
        return this.coordY;
    }

    public ArrayList<Entidad> getEntidades(){
        return this.entidades;
    }

    public void setCoordX(int x){
        this.coordX = x;
    }

    public void setCoordY(int y){
        this.coordY = y;
    }


    //METHODS 
    public void eliminateEntity(Entidad e){
        this.entidades.remove(e);
    }

    public void addEntity(Entidad e){
        this.entidades.add(e);
    }


    @Override
    public String toString(){
        return ("(" + this.coordX + ") , (" + this.coordY + ")");
    }

    public boolean equals(Casilla c){
        if(c.getCoordX() == this.getCoordX() && c.getCoordY() == this.getCoordY()) return true;
        return false;
    }


}
