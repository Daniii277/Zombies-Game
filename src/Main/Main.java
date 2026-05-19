package Main;

import java.util.List;
import java.util.Scanner;
import Ataques.AtaqueEspecial;
import Entidades.Conejo;
import Entidades.Entidad;
import Entidades.Zombie;
import Entidades.Humano.Humano;
import Juego.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Nueva partida");
        System.out.println("2 - Cargar partida guardada");
        int option = sc.nextInt();
        sc.nextLine();

        Juego game;

        if(option == 2){
            System.out.println("Ruta del fichero de partida: ");
            String path = sc.nextLine();
            game = Juego.loadGame(path);
        } else {
            System.out.println("Número de jugadores (1-4): ");
            int numPlayers = sc.nextInt();
            sc.nextLine();

            String[] names = new String[numPlayers];
            List<AtaqueEspecial> SpecialAttacks = new java.util.ArrayList<>();
            for(int i = 0; i < numPlayers; i++){
                System.out.println("Nombre del zombie " + (i + 1) + ": ");
                names[i] = sc.nextLine();
                System.out.println("Ataque especial - nombre: ");
                String atkName = sc.nextLine();
                System.out.println("Potencia: ");
                int power = sc.nextInt();
                System.out.println("Valor de éxito: ");
                int successVal = sc.nextInt();
                System.out.println("Alcance: ");
                int scope = sc.nextInt();
                sc.nextLine();
                SpecialAttacks.add(new AtaqueEspecial(atkName, power, successVal, scope));
            }

            game = new Juego(numPlayers);
            game.generatePlayers(names, SpecialAttacks);
            game.generateEntities(3 * numPlayers, 0);
        }

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
