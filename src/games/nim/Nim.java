package games.nim;

/**
 * Représente une partie du jeu de Nim.
 * Ce jeu consiste à retirer un certain nombre d'allumettes
 * à tour de rôle, avec des règles définies par les joueurs.
 */
public class Nim {

    private int initialMatches; // Nombre initial d'allumettes
    private int maxMatchesPerTurn; // Nombre maximal d'allumettes qu'un joueur peut retirer à chaque tour
    private String player1Name; // Nom du premier joueur
    private String player2Name; // Nom du deuxième joueur
    private int currentMatches; // Nombre actuel d'allumettes restantes
    private String currentPlayer; // Nom du joueur courant

    /**
     * Constructeur pour initialiser une partie de Nim avec le nombre initial d'allumettes
     * et les noms des joueurs.
     *
     * @param initialMatches Le nombre initial d'allumettes.
     * @param maxMatchesPerTurn Le nombre maximal d'allumettes qu'un joueur peut retirer à chaque tour.
     * @param player1Name Le nom du premier joueur.
     * @param player2Name Le nom du deuxième joueur.
     */
    public Nim(int initialMatches, int maxMatchesPerTurn, String player1Name, String player2Name) {
        this.initialMatches = initialMatches;
        this.maxMatchesPerTurn = maxMatchesPerTurn;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.currentMatches = initialMatches;
        this.currentPlayer = player1Name;
    }

    /**
     * Retourne le nombre initial d'allumettes.
     *
     * @return Le nombre initial d'allumettes.
     */
    public int getInitialMatches() {
        return this.initialMatches;
    }

    /**
     * Retourne le nombre actuel d'allumettes restantes.
     *
     * @return Le nombre d'allumettes restantes.
     */
    public int getCurrentMatches() {
        return this.currentMatches;
    }

    /**
     * Retourne le nom du joueur courant.
     *
     * @return Le nom du joueur dont c'est le tour de jouer.
     */
    public String getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * Retourne une représentation textuelle de l'état actuel du jeu.
     *
     * @return Une chaîne de caractères indiquant le nombre d'allumettes restantes.
     */
    public String situationToString() {
        return "Il reste " + currentMatches + " allumettes";
    }

    /**
     * Retire un certain nombre d'allumettes du total restant.
     *
     * @param matchesToRemove Le nombre d'allumettes à retirer.
     */
    public void removeMatches(int matchesToRemove) {
        this.currentMatches -= matchesToRemove;
        if (this.currentPlayer.equals(this.player1Name)) {
            this.currentPlayer = this.player2Name;
        } else {
            this.currentPlayer = this.player1Name;
        }
    }

    /**
     * Vérifie si le nombre d'allumettes à retirer est valide.
     *
     * @param matchesToRemove Le nombre d'allumettes que le joueur souhaite retirer.
     * @return true si le nombre est valide, false sinon.
     */
    public boolean isValid(int matchesToRemove) {
        return matchesToRemove > 0 && matchesToRemove <= this.maxMatchesPerTurn && matchesToRemove <= this.currentMatches;
    }

    /**
     * Vérifie si le jeu est terminé.
     *
     * @return true si toutes les allumettes ont été retirées, false sinon.
     */
    public boolean isOver() {
        return this.currentMatches == 0;
    }

    /**
     * Retourne le nom du gagnant, si le jeu est terminé.
     *
     * @return Le nom du gagnant, ou null si le jeu n'est pas terminé.
     */
    public String getWinner() {
        if (this.currentMatches == 0) {
            if (this.currentPlayer.equals(this.player1Name)) {
                return this.player1Name;
            } else {
                return this.player2Name;
            }
        } else {
            return null;
        }
    }
}
