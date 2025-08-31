package games.players;

import games.genericgames.Game;
import java.util.List;
import java.util.Scanner;

public class Human implements Player{
    private String name;
    private Scanner scanner;

    public Human(String name, Scanner scanner){
        this.name = name;
        this.scanner = scanner;
    }
    @Override
    public int chooseMove(Game game){
        List<Integer> listMoves = game.validMoves();
        int move = -1;
        boolean isFirstAttempt = true; // Indicateur pour différencier le premier essai des suivants

        do {
            if (!isFirstAttempt) {
                System.out.println("Coup invalide ! Veuillez choisir un coup valide parmi les suivants : " + listMoves);
            } else {
                System.out.println("C'est à " + game.getCurrentPlayer() + " , Choisissez un coup parmi les suivants : " + listMoves);
                isFirstAttempt = false;
            }


            try {
                // Convertir l'entrée en un entier et vérifier s'il fait partie des coups valides
                move = scanner.nextInt();

                if (!listMoves.contains(move)) {
                    System.out.println("Le coup " + move + " n'est pas dans la liste des coups valides.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Saisie invalide. Veuillez entrer un nombre entier.");
            }

        } while (!listMoves.contains(move)); // Répète la demande tant que le coup n'est pas valide

        return move;
    }
    
    @Override
    public String toString(){
        return this.name;
    }

}

