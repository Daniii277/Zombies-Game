package Main;

import java.util.Scanner;

import Entidades.Conejo;
import Entidades.Entidad;
import Entidades.Zombie;
import Entidades.Humano.Humano;
import Juego.*;
public class Main {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione el número de jugadores : ");
        int numPlayers = sc.nextInt();
        Juego game = new Juego(numPlayers);
        //Se crean las entidades iniciales del tablero
        game.generatePlayers(numPlayers);
        game.generateEntities(3*numPlayers, 5);
        initGame(game);
    }

    //Se une la lógica de la IG con la del juego
    public static void initGame(Juego game){
        while(!game.endCondition()){
            //PRIMER TURNO : ZOMBIES
            for(Zombie player : game.getPlayers()){
                game.nextPlayerTurn(player);
            }
            //SEGUNDO TURNO : HUMANOS
            for(Entidad entity : game.getGameBoard().getEntities()){
                //Solo para humanos
                if(!(entity instanceof Zombie || entity instanceof Conejo)){
                    game.nextHumanTurn((Humano) entity);
                }
            }
            
            System.out.println("\nTurno finalizado\n");
            System.out.println("Estado del tablero : " + game.getGameBoard().toString());
        }
    }
}
