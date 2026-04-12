/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;
import java.util.*;

import Ataques.Ataque;
import Ataques.AtaqueNormal;
import Juego.Casilla;



public class Zombie extends Entidad{
    private final String name;
    private estado zombieState;
    private final int actionsPerRound = 3;
    private ArrayList<Comestible> itemsConsumed;
    private int damageReceived;
    private int hungerLevel;
    private final Ataque basicAttack;
    private Ataque SpecialAttack;


    //CONSTRUCTOR
    public Zombie(String name){
        this.name = name;
        this.zombieState = estado.ACTIVO;
        this.itemsConsumed = new ArrayList<>();
        this.damageReceived = 0;
        this.hungerLevel = 0;
        this.basicAttack = new AtaqueNormal("Devorar");
        
    }

    //GETTERS AND SETTERS
    public String getName(){
        return this.name;
    }

    public estado getState(){
        return this.zombieState;
    }

    public int getNumActions(){
        return this.actionsPerRound;
    }

    public ArrayList<Comestible> getItemsConsumed(){
        return this.itemsConsumed;
    }

    public int getDamageReceived(){
        return this.damageReceived;
    }

    public int getHungerLevel(){
        return this.hungerLevel;
    }

    public void setZombiestate(estado state){
        this.zombieState = state;
    }

    public void setSpecialAttack(Ataque Special){
        this.SpecialAttack = Special;
    }


    //METHODS 
    public void addHunger(){
        this.hungerLevel++;
    }

    public void substractHunger(){
        this.hungerLevel--;
    }

    public void getDamage(){
        this.damageReceived++;
    }

    public Entidad searchFood(){
        for(int i = 0; i < this.getCasillaActual().getEntidades().size(); i++){
            
        }
        for(Entidad entidad : this.getCasillaActual().getEntidades()){
            if(entidad instanceof Conejo){
                return entidad;
            }
        }
        return null;
    }

    public boolean eat(){
        Entidad e = this.searchFood();
        if(e != null){
            e.getCasillaActual().getEntidades().remove(e);
            e.setCasillaActual(null);
            this.itemsConsumed.add((Comestible) e);
            this.substractHunger();
            return true;
        }
        return false;
    }


    @Override
    public void move(Casilla c) {
        //Se elimina de la lista de entidades de su casilla anterior
        this.getCasillaActual().getEntidades().remove(this);
        //Se modifica la casilla actual en la entidad
        this.setCasillaActual(c);
    }

    public void basicAttack(Casilla c){
        //Calculo los impactos que obtiene el ataque
        int impacts = basicAttack.countImpacts(this.hungerLevel);
        ArrayList<Entidad> ObjetivesList = orderObjetives(c.getEntidades());
        
    }

    private ArrayList<Entidad> orderObjetives(ArrayList<Entidad> entidades) {
        ArrayList<Entidad> result = new ArrayList<>();
        return result;
    }

    public void SpecialAttack(Casilla c){

    }

    @Override
    public String toString(){
        return( "\nnombre : " + this.name + 
                "\nestado : " + this.zombieState + 
                "\ndaño recibido : " + this.damageReceived +
                "\nhambre : " + this.hungerLevel +
                "\nCasilla : " + this.getCasillaActual().toString() +
                "\nEntidades comidas : " + this.itemsConsumed + "\n"
        );
    }

}
