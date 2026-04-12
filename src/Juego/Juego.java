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

    public Juego(int numZombies){
        switch (numZombies) {
            case 1:
                this.gameBoard = new Tablero(7);
                break;
            case 2:
                this.gameBoard = new Tablero(8);
                break;
            case 3:
                this.gameBoard = new Tablero(9);
                break;
            case 4:
                this.gameBoard = new Tablero(10);
                break;
        
            default:
                break;
        }
        this.State = gameState.IN_PROGRESS;
        this.currentTurn = 0;
        this.players = new ArrayList<>();
    }

    

    
}
