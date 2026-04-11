/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;
import java.util.*;


public class Zombie {
    private String name;
    private estado zombieState;
    private final int actionsPerRound = 3;
    private ArrayList<Comestible> itemsConsumed;
    private int damageReceived;
    private int hungerLevel;


    //CONSTRUCTOR
    public Zombie(String name){
        this.name = name;
        this.zombieState = estado.ACTIVO;
        this.itemsConsumed = new ArrayList<>();
        this.damageReceived = 0;
        this.hungerLevel = 0;
    }

}
