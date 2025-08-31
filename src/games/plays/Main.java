package games.plays;

import java.util.Random;
import java.util.Scanner;

import games.genericgames.TicTacToe;
import games.players.Human;
import games.players.Player;
import games.players.RandomPlayer;

public class Main{
    public static void main(String[] args) {
        Random rand = new Random(123);
        Scanner scanner = new Scanner(System.in);
        Player player1 = new Human("Moi", scanner);
        Player player2 = new RandomPlayer(rand);
        TicTacToe game = new TicTacToe(player1, player2);
        Orchestrator orchestrator = new Orchestrator(game);
        orchestrator.play();
        scanner.close();    
}
}