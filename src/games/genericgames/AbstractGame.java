package games.genericgames;

import games.players.Player;

/**
 * Classe abstraite représentant la base pour les jeux.
 * Fournit une structure commune pour gérer les joueurs, le déroulement des tours,
 * et les actions spécifiques au jeu.
 */
public abstract class AbstractGame implements Game {

    protected Player playerName1; // Premier joueur
    protected Player playerName2; // Deuxième joueur
    protected Player currentPlayer; // Joueur actuellement en train de jouer

    /**
     * Constructeur pour initialiser une partie avec deux joueurs.
     *
     * @param playerName1 Le premier joueur.
     * @param playerName2 Le deuxième joueur.
     */
    public AbstractGame(Player playerName1, Player playerName2) {
        this.playerName1 = playerName1;
        this.playerName2 = playerName2;
        this.currentPlayer = playerName1; // Le premier joueur commence par défaut
    }

    /**
     * Méthode abstraite pour exécuter les actions spécifiques au jeu.
     * Cette méthode doit être implémentée par les classes concrètes.
     *
     * @param coup Le coup joué par le joueur.
     */
    protected abstract void doExecute(int coup);

    /**
     * Exécute un coup, puis change le joueur actif.
     *
     * @param coup Le coup joué par le joueur actif.
     */
    @Override
    public void execute(int coup) {
        doExecute(coup); // Exécute le coup
        // Alterne le joueur actif
        if (getCurrentPlayer().equals(playerName1)) {
            this.currentPlayer = playerName2;
        } else {
            this.currentPlayer = playerName1;
        }
    }

    /**
     * Retourne le joueur actuellement en train de jouer.
     *
     * @return Le joueur actif.
     */
    @Override
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }
}
