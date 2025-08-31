package games.genericgames;

import games.players.Player;
import java.util.List;
import java.util.ArrayList;

/**
 * Représente une partie du jeu de Nim.
 * Les joueurs retirent à tour de rôle un nombre défini d'allumettes
 * en respectant les règles. Le joueur qui retire la dernière allumette perd.
 */
public class Nim extends AbstractGame {

    private int numberInitial; // Nombre initial d'allumettes
    private int numberMax; // Nombre maximal d'allumettes qu'un joueur peut retirer
    private int currentNumberMatches; // Nombre actuel d'allumettes restantes
    private boolean begin = true; // Indicateur pour le message de début

    /**
     * Constructeur pour initialiser une partie de Nim.
     *
     * @param numberInitial Le nombre initial d'allumettes.
     * @param numberMax     Le nombre maximal d'allumettes qu'un joueur peut retirer.
     * @param playerName1   Le premier joueur.
     * @param playerName2   Le second joueur.
     */
    public Nim(int numberInitial, int numberMax, Player playerName1, Player playerName2) {
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
     * Retourne une description textuelle de l'état actuel du jeu.
     *
     * @return Une chaîne représentant le nombre d'allumettes restantes ou un message de début.
     */
    @Override
    public String situationToString() {
        if (begin) {
            begin = false;
            return "Bienvenue dans la partie de Nim ! Il y a " + this.numberInitial +
                    " allumettes au total. Chaque joueur devra en retirer entre 1 et " +
                    this.numberMax + " à chaque tour.\nBonne chance, et que le meilleur stratège l’emporte !";
        } else {
            return "Il reste " + currentNumberMatches + " allumettes\n";
        }
    }

    /**
     * Effectue un coup en retirant un certain nombre d'allumettes.
     *
     * @param coup Le nombre d'allumettes à retirer.
     */
    @Override
    public void doExecute(int coup) {
        this.currentNumberMatches -= coup;
    }

    /**
     * Vérifie si le coup (nombre d'allumettes à retirer) est valide.
     *
     * @param coup Le nombre d'allumettes que le joueur souhaite retirer.
     * @return true si le coup est valide, false sinon.
     */
    @Override
    public boolean isValid(int coup) {
        return coup > 0 && coup <= this.numberMax && coup <= this.currentNumberMatches;
    }

    /**
     * Vérifie si la partie est terminée.
     *
     * @return true si toutes les allumettes ont été retirées, false sinon.
     */
    @Override
    public boolean isOver() {
        return this.currentNumberMatches == 0;
    }

    /**
     * Retourne le gagnant de la partie.
     *
     * @return Le joueur gagnant, ou null si la partie n'est pas terminée.
     */
    @Override
    public Player getWinner() {
        if (this.currentNumberMatches == 0) {
            return super.getCurrentPlayer();
        }
        return null;
    }

    /**
     * Retourne une liste des coups valides possibles.
     *
     * @return Une liste des nombres d'allumettes pouvant être retirées.
     */
    @Override
    public List<Integer> validMoves() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= getCurrentNbMatches(); i++) {
            if (isValid(i)) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * Retourne une description textuelle d'un coup joué.
     *
     * @param coup Le nombre d'allumettes retirées.
     * @return Une chaîne décrivant le coup.
     */
    @Override
    public String moveToString(int coup) {
        return super.getCurrentPlayer() + " a retiré " + coup + " allumettes.\n";
    }

    /**
     * Crée une copie de la partie actuelle.
     *
     * @return Une nouvelle instance de Nim avec le même état.
     */
    @Override
    public Game copy() {
        Nim copy = new Nim(this.numberInitial, this.numberMax, playerName1, playerName2);
        copy.currentNumberMatches = this.currentNumberMatches;
        copy.currentPlayer = super.currentPlayer;
        return copy;
    }
}
