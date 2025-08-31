package games.factoredgames;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le nom du premier joueur :");
        String player1 = scanner.next();

        String player2;
        while (true) {
            System.out.println("Entrez le nom du deuxième joueur :");
            player2 = scanner.next();
            if (player1.equals(player2)) {
                System.out.println("Les deux joueurs ne peuvent pas avoir le même nom.");
            } else {
                break;
            }
        }

        System.out.println("Entrez la taille du tas :");
        int numberInitial = Integer.parseInt(scanner.next());

        System.out.println("Entrez le maximum d'allumettes que l'on peut retirer :");
        int numberMax = Integer.parseInt(scanner.next());

        while (numberMax >= numberInitial && numberInitial > 0) {
            System.out.println("Entrez à nouveau le maximum d'allumettes que l'on peut retirer :");
            numberMax = Integer.parseInt(scanner.next());
        }

        Nim jeu = new Nim(numberInitial, numberMax, player1, player2);

        while (!jeu.isOver()) {
            System.out.println(jeu.getCurrentPlayer() + ", entrez un coup :");
            int coup = Integer.parseInt(scanner.next());
            if (jeu.isValid(coup)) {
                jeu.execute(coup);
                System.out.println(jeu.situationToString());
            } else {
                System.out.println("Le dernier coup est invalide ! Entrez un nombre positif inférieur ou égal au maximum autorisé.");
            }
        }

        System.out.println("**** Victoire ! " + jeu.getWinner() + " a gagné ! ****");
        scanner.close();
    }
}
