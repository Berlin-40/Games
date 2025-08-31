package games.factoredgames;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le nom du premier joueur :");
        String playerName1 = scanner.next();

        System.out.println("Entrez le nom du deuxième joueur :");
        String playerName2 = scanner.next();

        TicTacToe jeu = new TicTacToe(playerName1, playerName2);

        while (!jeu.isOver()) {
            System.out.println(jeu.situationToString());
            System.out.println("C'est à " + jeu.getCurrentPlayer() + " de jouer. \nVotre coup :");

            System.out.println("Coup :");
            String inputString = scanner.next();
            int coup = Integer.parseInt(inputString);

            while (!jeu.isValid(coup)) {
                System.out.println("Le dernier coup est invalide. \nC'est toujours à " + jeu.getCurrentPlayer() + " de jouer. \nVotre coup :");
                System.out.println("Coup :");
                inputString = scanner.next();
                coup = Integer.parseInt(inputString);
            }

            jeu.execute(coup);
        }

        System.out.println(jeu.situationToString());
        System.out.println("*** Victoire ! " + jeu.getWinner() + " a gagné ! ***");

        scanner.close();
    }
}

