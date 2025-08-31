package games.nim;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Saisie et validation des noms des joueurs
        System.out.println("Entrez le nom du premier joueur:");
        String player1 = scanner.next();

        String player2;
        while (true) {
            System.out.println("Entrez le nom du deuxième joueur:");
            player2 = scanner.next();
            if (player1.equals(player2)) {
                System.out.println("Les deux joueurs ne peuvent pas avoir le même nom. Réessayez.");
            } else {
                break;
            }
        }

        // Saisie et validation de la taille du tas
        int numberInitial = 0;
        while (numberInitial <= 0) {
            System.out.println("Entrez la taille du tas (nombre entier positif):");
            try {
                numberInitial = Integer.parseInt(scanner.next());
                if (numberInitial <= 0) {
                    System.out.println("La taille du tas doit être un entier positif.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un entier positif.");
            }
        }

        // Saisie et validation du maximum d'allumettes à retirer
        int k = 0;
        while (k <= 0 || k >= numberInitial) {
            System.out.println("Entrez le maximum d'allumettes que l'on peut retirer (doit être positif et inférieur à la taille du tas):");
            try {
                k = Integer.parseInt(scanner.next());
                if (k <= 0 || k >= numberInitial) {
                    System.out.println("Le maximum doit être un entier positif et inférieur à la taille du tas.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un entier positif.");
            }
        }

        // Initialisation du jeu
        Nim jeu = new Nim(numberInitial, k, player1, player2);

        // Boucle de jeu
        while (!jeu.isOver()) {
            System.out.println(jeu.getCurrentPlayer() + ", entrez un coup (nombre d'allumettes à retirer):");
            try {
                int c = Integer.parseInt(scanner.next());
                if (jeu.isValid(c)) {
                    jeu.removeMatches(c);
                    System.out.println(jeu.situationToString());
                } else {
                    System.out.println("Coup invalide! Entrez un nombre positif inférieur ou égal au maximum autorisé.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un entier positif.");
            }
        }

        // Annonce du gagnant
        System.out.println("**** Victoire ! " + jeu.getWinner() + " a gagné ! ****");

        scanner.close();
    }
}
