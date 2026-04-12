/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;
import java.util.*;

import Ataques.Ataque;
import Ataques.AtaqueNormal;
import Juego.Casilla;
import Entidades.Humano.*;


public class Zombie extends Entidad{
    private final String name;
    private final int actionsPerRound = 3;
    private ArrayList<Comestible> itemsConsumed;
    private int damageReceived;
    private int hungerLevel;
    private final Ataque basicAttack;
    private Ataque SpecialAttack;


    //CONSTRUCTOR
    public Zombie(String name){
        this.name = name;
        this.itemsConsumed = new ArrayList<>();
        this.damageReceived = 0;
        this.hungerLevel = 0;
        this.basicAttack = new AtaqueNormal("Devorar");
        
    }

    //GETTERS AND SETTERS
    public String getName(){
        return this.name;
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
        if(impacts <= 0) return;
        ArrayList<Entidad> objetivesList = orderObjetives(c.getEntidades());
        
        Entidad entity = objetivesList.getFirst();
            int endurance = entity instanceof Conejo ? 1 : ((Humano)entity).getEndurance();
            if(impacts > endurance){
                //Se elimina a la entidad
                entity.setState(estado.ELIMINADO);
                c.getEntidades().remove(entity);
                //Se resta 1 al hambre del zombie
                this.substractHunger();
                System.out.println("Entidad eliminada : " + entity.toString());

            }
        
    }
    
    //Toma solo los humanos y los ordena por prioridad de ataque
    private ArrayList<Entidad> orderObjetives(ArrayList<Entidad> entidades) {
        ArrayList<Entidad> result = new ArrayList<>();
        for (Entidad entidad : entidades) {
            if (!(entidad instanceof Zombie)) {
                result.add(entidad);
            }
        }
        result.sort((a, b) -> getPriority(a) - getPriority(b));
        return result;
    }

    public int getPriority(Entidad e){
        if (e instanceof humanoIngeniero) return 1;
        if(e instanceof humanoCombatiente){
            if(((humanoCombatiente)e).getType() == tipoHumano.SOLDADO) return 2;
            if(((humanoCombatiente)e).getType() == tipoHumano.BLINDADO) return 3;
            if(((humanoCombatiente)e).getType() == tipoHumano.ESPECIALISTA) return 4;


        }
        if(e instanceof humanoHuidizo) return 5;
        if(e instanceof Conejo) return 6;
        return 0;
    }

    public void SpecialAttack(Casilla c){
        //Calculo los impactos que obtiene el ataque
        int impacts = SpecialAttack.countImpacts(this.hungerLevel);
        if(impacts <= 0) return;
        ArrayList<Entidad> objetivesList = orderObjetives(c.getEntidades());
        
        for(Entidad entity : objetivesList){
            if(entity instanceof Conejo) continue;
            int endurance = ((Humano)entity).getEndurance();
            if(impacts > endurance){
                //Se elimina a la entidad
                entity.setState(estado.ELIMINADO);
                c.getEntidades().remove(entity);
                System.out.println("Entidad eliminada : " + entity.toString());
                //Se actualizan los impactos restantes
                impacts -= endurance;
            }else{ 
                break;
            }
        }
    }

    @Override
    public String toString(){
        return( "\nnombre : " + this.name + 
                "\nestado : " + this.getState() + 
                "\ndaño recibido : " + this.damageReceived +
                "\nhambre : " + this.hungerLevel +
                "\nCasilla : " + this.getCasillaActual().toString() +
                "\nEntidades comidas : " + this.itemsConsumed + "\n"
        );
    }

}
