/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juego;
import java.util.*;
import Entidades.*;
import Entidades.Comestible;
import Entidades.Humano.Humano;
import Entidades.Humano.humanoCombatiente;
import Entidades.Humano.humanoHuidizo;
import Entidades.Humano.humanoIngeniero;
import Entidades.Humano.tipoHumano;
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
    public boolean nextPlayerTurn(Zombie z){
        boolean turnResult = false;

        //Cada jugador tiene 3 activaciones
        for(int i = 0; i < 3; i++){
            Scanner sc = new Scanner(System.in);
            System.out.println("Elige la acción que quieres realizar : [MOVERSE] [ATACAR] [NADA]");
            String action = sc.nextLine();
            action.toLowerCase();
            sc.close();
            //IMPLEMENTACIÓN DE LA LÓGICA DE LAS ACCIONES DEL TURNO
            switch (action) {
                case "moverse":
                    
                    break;
            
                case "atacar":

                    break;

                case "nada":

                    break;

                default:
                    break;
            }
            //Se comprueba después de cada activación si la partida no deberia finalizar.
            turnResult = winCondition();
        }
        return turnResult;
    }
    //Lógica del turno de los humanos
    public boolean nextHumanTurn(Humano e){
        boolean turnResult = false;
        //Según el número de activaciones del humano
        for(int i = 0; i < e.getActivations(); i++){
            

            //Se comprueba después de cada activación si la partida no deberia finalizar.
            turnResult = loseCondition();
        }
        return turnResult;
    }


    private void assignRandomBox(Entidad entity) {
        Random rnd = new Random();
        int coordX = rnd.nextInt(gameBoard.getSize());
        int coordY = rnd.nextInt(gameBoard.getSize());
        Casilla[][] board = gameBoard.getBoard();
        board[coordX][coordY].addEntity(entity);
        entity.setCasillaActual(board[coordX][coordY]);
        gameBoard.getEntities().add(entity);
    }


    public void generateRandomHuman(){
        Random rnd = new Random();
        int prob = rnd.nextInt(100) + 1; // 1 a 100
        Entidad h;

        if (prob <= 40) {
            h = new humanoCombatiente(tipoHumano.SOLDADO);
        } else if (prob <= 65) {
            h = new humanoCombatiente(tipoHumano.ESPECIALISTA);
        } else if (prob <= 90) {
            h = new humanoCombatiente(tipoHumano.BLINDADO);
        } else {
            h = new humanoIngeniero();
        }

        assignRandomBox(h);
    }

    public void generateRandomRabbit(){
        Entidad rabbit = new Conejo("Conejo " + gameBoard.getIdRabbit());
        gameBoard.incrementIdRabbits();
        assignRandomBox(rabbit);

    }

    public void generateEntities(int humans, int rabbits){
        //Se crean los humanos
        for(int i = 0; i < humans; i++){
            generateRandomHuman();
        }
        for(int j = 0; j < rabbits; j++){
            generateRandomRabbit();
        }
    }

    public void generatePlayers(int numPlayers){
        for(int i = 0; i < numPlayers; i++){
            Zombie z = new Zombie();
            Casilla[][] board = gameBoard.getBoard();
            board[0][0].addEntity(z);
            z.setCasillaActual(board[0][0]);
            this.players.add(z);
        }

    }

    //Método para encontrar al humano más cercano
    public void closestHuman(Zombie z){

    }


    //Método para mover al humano como una IA
    public void humanAImove(){

    }

    public void movePlayer(String move, Zombie z){
        Casilla CurrentPosition = z.getCasillaActual();
        switch (move) {
            case "izquierda":
                
                break;
        
            case "derecha":
                break;

            case "abajo":

                break;

            case "arriba":

                break;

            default:
                break;
        }
    }

    public boolean endCondition(){
        if(winCondition()){
            System.out.println("Victoria de los zombies");
            return true;
        }else if(loseCondition()){
            System.out.println("Derrota de los zombies");
            return true;
        }
        return false;
    }

    public boolean winCondition(){
        if(this.players.isEmpty()) return false;
        for(Zombie z : this.players){
            if(!z.getCasillaActual().equals(gameBoard.getTargetBox())) return false;
            boolean ateHuidizo = false;
            for(Comestible c : z.getItemsConsumed()){
                if(c instanceof humanoHuidizo){
                    ateHuidizo = true;
                    break;
                }
            }
            if(!ateHuidizo) return false;
        }
        return true;
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
