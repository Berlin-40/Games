package games.genericgames;

import java.util.List;
import java.util.ArrayList;
import games.players.Player;

/**
 * Classe représentant une partie de Tic Tac Toe.
 * Gère l'état du jeu, les coups joués et détermine les conditions de victoire ou d'égalité.
 */
public class TicTacToe extends AbstractGame {

    // Plateau de jeu initialisé avec des cases vides représentées par "."
    private String[][] table = {
        {".", ".", "."},
        {".", ".", "."},
        {".", ".", "."}
    };

    /**
     * Constructeur de la classe TicTacToe.
     *
     * @param playerName1 Le premier joueur.
     * @param playerName2 Le second joueur.
     */
    public TicTacToe(Player playerName1, Player playerName2) {
        super(playerName1, playerName2);
    }

    /**
     * Effectue le coup spécifié sur le plateau si celui-ci est valide.
     * Le joueur actuel joue à la position spécifiée.
     *
     * @param coup La position du coup (de 0 à 8, où 0 est en haut à gauche).
     */
    @Override
    public void doExecute(int coup) {
        if (isValid(coup)) {
            int line = coup / 3; // Ligne où jouer
            int colomn = coup % 3; // Colonne où jouer
            // Détermine le symbole à placer en fonction du joueur actuel
            if (super.getCurrentPlayer().equals(playerName1)) {
                this.table[line][colomn] = "O";
            } else {
                this.table[line][colomn] = "X";
            }
        }
    }

    /**
     * Vérifie si un coup donné est valide.
     * Un coup est valide s'il est dans les limites du plateau et la case est vide.
     *
     * @param coup La position du coup à vérifier.
     * @return true si le coup est valide, false sinon.
     */
    @Override
    public boolean isValid(int coup) {
        int line = coup / 3;
        int colomn = coup % 3;
        return line >= 0 && line < 3 && colomn >= 0 && colomn < 3 && table[line][colomn].equals(".");
    }

    /**
     * Vérifie si un joueur a gagné dans une direction donnée.
     *
     * @param playerName Le joueur à vérifier.
     * @param row        La ligne de départ.
     * @param colomn     La colonne de départ.
     * @param deltaRow   L'incrément pour les lignes.
     * @param deltaColumn L'incrément pour les colonnes.
     * @return true si le joueur a gagné dans cette direction, false sinon.
     */
    public boolean wins(Player playerName, int row, int colomn, int deltaRow, int deltaColumn) {
        String symbol = playerName.equals(playerName1) ? "O" : "X";
        return table[row][colomn].equals(symbol) &&
               table[row + deltaRow][colomn + deltaColumn].equals(symbol) &&
               table[row + 2 * deltaRow][colomn + 2 * deltaColumn].equals(symbol);
    }

    /**
     * Retourne le joueur qui a gagné, s'il y en a un.
     *
     * @return Le joueur gagnant ou null si aucun joueur n'a gagné.
     */
    @Override
    public Player getWinner() {
        for (int i = 0; i < 3; i++) {
            // Vérifie les lignes et colonnes
            if (wins(playerName1, i, 0, 0, 1) || wins(playerName1, 0, i, 1, 0)) {
                return playerName1;
            }
            if (wins(playerName2, i, 0, 0, 1) || wins(playerName2, 0, i, 1, 0)) {
                return playerName2;
            }
        }
        // Vérifie les diagonales
        if (wins(playerName1, 0, 0, 1, 1) || wins(playerName1, 0, 2, 1, -1)) {
            return playerName1;
        }
        if (wins(playerName2, 0, 0, 1, 1) || wins(playerName2, 0, 2, 1, -1)) {
            return playerName2;
        }
        return null;
    }

    /**
     * Vérifie si la partie est terminée.
     * Une partie est terminée si un joueur a gagné ou si toutes les cases sont occupées.
     *
     * @return true si la partie est terminée, false sinon.
     */
    @Override
    public boolean isOver() {
        if (getWinner() != null) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j].equals(".")) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Retourne une représentation textuelle de l'état actuel du plateau.
     *
     * @return Une chaîne représentant le plateau.
     */
    @Override
    public String situationToString() {
        StringBuilder chaine = new StringBuilder("  1 2 3\n");
        for (int i = 0; i < 3; i++) {
            chaine.append(i + 1).append(" ");
            for (int j = 0; j < 3; j++) {
                chaine.append(table[i][j]).append(" ");
            }
            chaine.append("\n");
        }
        return chaine.toString();
    }

    /**
     * Retourne la liste des coups valides.
     *
     * @return Une liste des indices des cases vides.
     */
    @Override
    public List<Integer> validMoves() {
        List<Integer> validMoves = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j].equals(".")) {
                    validMoves.add(i * 3 + j);
                }
            }
        }
        return validMoves;
    }

    /**
     * Retourne une représentation textuelle d'un coup spécifique.
     *
     * @param coup Le coup à représenter.
     * @return Une chaîne décrivant le coup.
     */
    @Override
    public String moveToString(int coup) {
        int line = coup / 3 + 1;
        int colomn = coup % 3 + 1;
        return getCurrentPlayer() + " a joué un coup à la ligne " + line + " et à la colonne " + colomn + "\n";
    }

    /**
     * Crée une copie de la partie actuelle.
     *
     * @return Une nouvelle instance de TicTacToe avec l'état actuel du jeu.
     */
    @Override
    public Game copy() {
        TicTacToe copy = new TicTacToe(this.playerName1, this.playerName2);
        String[][] copyTable = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                copyTable[i][j] = this.table[i][j];
            }
        }
        copy.table = copyTable;
        copy.currentPlayer = super.currentPlayer;
        return copy;
    }
}

