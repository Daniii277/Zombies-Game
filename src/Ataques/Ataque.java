/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ataques;



public abstract class Ataque {
    private final String name;
    private final int power;
    private final int successValue;
    private final int scope;
    
    
    public Ataque(String name, int power, int successValue, int scope){
        this.name = name;
        this.power = power;
        this.successValue = successValue;
        this.scope = scope;
    }

    //GETTERS AND SETTERS
    public String getName(){
        return this.name;
    }

    public int getPower(){
        return this.power;
    }

    public int getSuccessValue(){
        return this.successValue;
    }

    public int getScope(){
        return this.scope;
    }

}
    
    
    
    

