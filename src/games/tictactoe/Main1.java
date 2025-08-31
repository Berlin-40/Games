package games.tictactoe;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Saisie des noms des joueurs
        System.out.println("Entrez le nom du premier joueur :");
        String playerName1 = scanner.next();
        System.out.println("Entrez le nom du deuxième joueur :");
        String playerName2 = scanner.next();

        // Initialisation du jeu
        TicTacToe jeu = new TicTacToe(playerName1, playerName2);

        // Boucle principale du jeu
        while (!jeu.isOver()) {
            System.out.println(jeu.situationToString());
            System.out.println("C'est à " + jeu.getCurrentPlayer() + " de jouer. Votre coup :");

            int row = -1, column = -1;

            // Validation des entrées pour la rangée
            while (row < 0 || row > 2) {
                System.out.println("_Rangée ? (0 à 2)");
                try {
                    row = Integer.parseInt(scanner.next());
                    if (row < 0 || row > 2) {
                        System.out.println("Entrée invalide. La rangée doit être entre 0 et 2.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrée invalide. Veuillez entrer un entier entre 0 et 2.");
                }
            }

            // Validation des entrées pour la colonne
            while (column < 0 || column > 2) {
                System.out.println("_Colonne ? (0 à 2)");
                try {
                    column = Integer.parseInt(scanner.next());
                    if (column < 0 || column > 2) {
                        System.out.println("Entrée invalide. La colonne doit être entre 0 et 2.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrée invalide. Veuillez entrer un entier entre 0 et 2.");
                }
            }

            // Validation du coup
            if (!jeu.isValid(row, column)) {
                System.out.println("Le coup est invalide. Cette case est déjà occupée ou hors limites.");
                continue; // Recommence le tour
            }

            // Exécution du coup
            jeu.execute(row, column);
        }

        // Affichage du résultat final
        System.out.println(jeu.situationToString());
        System.out.println("*** Victoire ! " + jeu.getWinner() + " a gagné ! ***");

        scanner.close();
    }
}
