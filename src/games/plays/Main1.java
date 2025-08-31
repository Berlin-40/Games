package games.plays;

import java.util.Scanner;
import games.genericgames.Nim;
import games.players.Human;
import games.players.Player;
import games.players.NegamaxPlayer;

public class Main1{
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Player player1 = new Human("Moi", scanner);
        Player player2 = new NegamaxPlayer();
        Nim game = new Nim(13, 3, player1, player2);
        Orchestrator orchestrator = new Orchestrator(game);
        orchestrator.play();
        scanner.close();   
    }
}

