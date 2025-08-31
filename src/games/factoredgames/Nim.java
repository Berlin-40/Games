package games.factoredgames;

/**
 * Représente une partie du jeu de Nim.
 * Ce jeu consiste à retirer un certain nombre d'allumettes 
 * à tour de rôle, avec des règles définies par les joueurs.
 */
public class Nim extends AbstractGame {

    private int numberInitial;
    private int numberMax;
    private int currentNumberMatches;

    /**
     * Constructeur pour initialiser une partie de Nim avec le nombre initial d'allumettes
     * et les noms des joueurs.
     *
     * @param numberInitial Le nombre initial d'allumettes.
     * @param numberMax Le nombre maximal d'allumettes qu'un joueur peut retirer à chaque tour.
     * @param playerName1 Le nom du premier joueur.
     * @param playerName2 Le nom du deuxième joueur.
     */
    public Nim(int numberInitial, int numberMax, String playerName1, String playerName2) {
        super(playerName1, playerName2);
        this.numberInitial = numberInitial;
        this.numberMax = numberMax;
        this.currentNumberMatches = numberInitial;
    }

    /**
     * Retourne le nombre initial d'allumettes.
     *
     * @return Le nombre initial d'allumettes.
     */
    public int getInitialNbMatches() {
        return this.numberInitial;
    }

    /**
     * Retourne le nombre actuel d'allumettes restantes.
     *
     * @return Le nombre d'allumettes restantes.
     */
    public int getCurrentNbMatches() {
        return this.currentNumberMatches;
    }

    /**
     * Retourne une représentation textuelle de l'état actuel du jeu.
     *
     * @return Une chaîne de caractères indiquant le nombre d'allumettes restantes.
     */
    public String situationToString() {
        return "Il reste " + currentNumberMatches + " allumettes.";
    }

    /**
     * Exécute le retrait d'allumettes pour un coup donné.
     *
     * @param n Le nombre d'allumettes à retirer.
     */
    @Override
    public void doExecute(int n) {
        this.currentNumberMatches -= n;
    }

    /**
     * Vérifie si le nombre d'allumettes à retirer est valide.
     *
     * @param coup Le nombre d'allumettes que le joueur souhaite retirer.
     * @return true si le nombre est valide, false sinon.
     */
    public boolean isValid(int coup) {
        return coup > 0 && coup <= this.numberMax && coup <= this.currentNumberMatches;
    }

    /**
     * Vérifie si le jeu est terminé.
     *
     * @return true si toutes les allumettes ont été retirées, false sinon.
     */
    public boolean isOver() {
        return this.currentNumberMatches == 0;
    }

    /**
     * Retourne le nom du gagnant, si le jeu est terminé.
     *
     * @return Le nom du gagnant, ou null si le jeu n'est pas terminé.
     */
    public String getWinner() {
        if (this.currentNumberMatches == 0) {
            return super.getCurrentPlayer();
        }
        return null;
    }
}
