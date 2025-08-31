package games.plays;

import games.genericgames.Game;

/**
 * La classe Orchestrator gère le déroulement d'une partie.
 * Elle affiche la situation actuelle du jeu, demande aux joueurs de jouer chacun leur tour,
 * et déclare le gagnant ou indique s'il y a égalité à la fin de la partie.
 */
public class Orchestrator {
    /**
     * L'instance du jeu en cours.
     */
    public Game game;

    /**
     * Constructeur de la classe Orchestrator.
     *
     * @param game Le jeu à orchestrer.
     */
    public Orchestrator(Game game) {
        this.game = game;
    }

    /**
     * Démarre le jeu et le gère jusqu'à sa fin.
     * Chaque joueur joue son tour tant que le jeu n'est pas terminé.
     * À la fin, il affiche le gagnant ou signale un match nul si aucun joueur n'a gagné.
     */
    public void play() {
        while (!this.game.isOver()) {
            // Affiche la situation actuelle du jeu
            System.out.println(this.game.situationToString());

            // Demande au joueur actuel de choisir un mouvement
            int coup = this.game.getCurrentPlayer().chooseMove(this.game);

            // Affiche le mouvement choisi
            System.out.println(this.game.moveToString(coup));

            // Exécute le mouvement
            this.game.execute(coup);
        }

        // Affiche la situation finale du jeu
        System.out.println(this.game.situationToString());

        // Vérifie et annonce le gagnant s'il y en a un
        if (this.game.getWinner() != null) {
            System.out.println("**** Victoire, " + this.game.getWinner() + " a gagné ! ****");
        } else {
            System.out.println("**** Match nul ! ****");
        }
    }
}
