/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juego;
import java.util.*;
import Entidades.*;
public class Juego  {

    public enum gameState { IN_PROGRESS, VICTORY, LOSE }


    private Tablero gameBoard;
    private gameState State;
    private int currentTurn;
    private ArrayList<Zombie> players;


    //CONSTRUCTOR
    public Juego(int numZombies){
        switch (numZombies) {
            case 1:
                this.gameBoard = new Tablero(6);
                break;
            case 2:
                this.gameBoard = new Tablero(7);
                break;
            case 3:
                this.gameBoard = new Tablero(8);
                break;
            case 4:
                this.gameBoard = new Tablero(9);
                break;
        
            default:
                break;
        }
        this.State = gameState.IN_PROGRESS;
        this.currentTurn = 0;
        this.players = new ArrayList<>();
    }
    //GETTERS AND SETTERS
    public gameState getState(){
        return this.State;
    }

    public int getTurn(){
        return this.currentTurn;
    }

    public ArrayList<Zombie> getPlayers(){
        return this.players;
    }

    public Tablero getGameBoard(){
        return this.gameBoard;
    }
    //METHODS

    //Lógica del turno de los jugadores
    public void nextPlayerTurn(Zombie z){

    }
    //Lógica del turno de los humanos
    public void nextHumanTurn(Entidad e){

    }

    public boolean endCondition(){
        if(winCondition()){
            System.out.println("Victoria de los zombies");
            return true;
        }else if(winCondition()){
            System.out.println("Derrota de los zombies");
            return true;
        }
        return false;
    }

    public boolean winCondition(){
        boolean result = false;
        for(Entidad entity : this.getPlayers()){
            if(entity.getCasillaActual() == gameBoard.getTargetBox()){
                result = true;

            }else{
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean loseCondition(){
        boolean result = false;
        for(Entidad entity : this.getPlayers()){
            if(entity.getState() == estado.ELIMINADO){
                result = true;
                break;
            }
        }
        return result;

    }

}
