package games.factoredgames;

/**
 * Représente une partie de Tic Tac Toe entre deux joueurs.
 * La classe gère l'état du jeu, les mouvements des joueurs,
 * et détermine si un joueur a gagné ou si le match est terminé.
 */
public class TicTacToe extends AbstractGame {

    private String[][] table = {
        {".", ".", "."},
        {".", ".", "."},
        {".", ".", "."}
    };

    /**
     * Constructeur pour initialiser une partie de Tic Tac Toe avec les noms des joueurs.
     *
     * @param playerName1 Le nom du premier joueur.
     * @param playerName2 Le nom du deuxième joueur.
     */
    public TicTacToe(String playerName1, String playerName2) {
        super(playerName1, playerName2);
    }

    /**
     * Exécute un mouvement sur le plateau à la position spécifiée.
     *
     * @param coup La position du coup sur une grille 1D (0 à 8).
     */
    @Override
    public void doExecute(int coup) {
        int line = coup / 3;
        int column = coup % 3;
        String symbol = super.getCurrentPlayer().equals(playerName1) ? "O" : "X";
        table[line][column] = symbol;
    }

    /**
     * Vérifie si le mouvement à la position spécifiée est valide.
     *
     * @param coup La position du coup sur une grille 1D (0 à 8).
     * @return true si le mouvement est valide, false sinon.
     */
    public boolean isValid(int coup) {
        if (coup < 0 || coup > 8) return false; // Vérifie si le coup est dans la plage.
        int line = coup / 3;
        int column = coup % 3;
        return table[line][column].equals("."); // Vérifie si la case est vide.
    }
/**
     * Vérifie si un joueur a gagné à partir d'une position donnée.
     *
     * @param playerName Le nom du joueur à vérifier.
     * @param row La ligne de départ.
     * @param colomn La colonne de départ.
     * @param deltaRow Le déplacement en ligne.
     * @param deltaColumn Le déplacement en colonne.
     * @return true si le joueur a gagné, false sinon.
     */
    public boolean wins(String playerName, int row, int colomn, int deltaRow, int deltaColumn) {
        String verifcood1 = table[row][colomn];
        String verifcood2 = table[row + deltaRow][colomn + deltaColumn];
        String verifcood3 = table[row + 2 * deltaRow][colomn + 2 * deltaColumn];
        if (playerName.equals(this.playerName2)) {
            return verifcood1.equals("X") && verifcood2.equals("X") && verifcood3.equals("X");
        } else {
            return verifcood1.equals("O") && verifcood2.equals("O") && verifcood3.equals("O");
        }
    }

    /**
     * Retourne le nom du joueur qui a gagné, s'il y en a un.
     *
     * @return Le nom du gagnant, ou null s'il n'y a pas de gagnant.
     */
    public String getWinner() {
        for (int i = 0; i < 3; i++) {
            if (wins(this.playerName1, i, 0, 0, 1)) {
                return this.playerName1;
            }
            if (wins(this.playerName2, i, 0, 0, 1)) {
                return this.playerName2;
            }
            if (wins(this.playerName1, 0, i, 1, 0)) {
                return this.playerName1;
            }
            if (wins(this.playerName2, 0, i, 1, 0)) {
                return this.playerName2;
            }
        }
        // Vérification des diagonales
        if (wins(this.playerName1, 0, 0, 1, 1)) {
            return this.playerName1;
        }
        if (wins(this.playerName2, 0, 0, 1, 1)) {
            return this.playerName2;
        }
        if (wins(this.playerName1, 0, 2, 1, -1)) {
            return this.playerName1;
        }
        if (wins(this.playerName2, 0, 2, 1, -1)) {
            return this.playerName2;
        }
        return null; // Pas de gagnant
    }

    /**
     * Vérifie si le match est terminé (un joueur a gagné ou le plateau est plein).
     *
     * @return true si le match est terminé, false sinon.
     */
    public boolean isOver() {
        if (getWinner() != null) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j].equals(".")) {
                    return false; // Il reste encore des cases vides.
                }
            }
        }
        System.out.println("Match nul");
        return true;
    }

    /**
     * Retourne une représentation textuelle de l'état actuel du jeu.
     *
     * @return Une chaîne de caractères représentant l'état actuel du jeu.
     *         La première ligne contient les indices des colonnes,
     *         suivie de chaque ligne du plateau, préfixée par son indice de ligne.
     */
    public String situationToString() {
        String chaine;
        chaine = "  0 1 2" + System.lineSeparator();

        for (int i = 0; i < 3; i++) {
            String line = i + " " + table[i][0] + " " + table[i][1] + " " + table[i][2];
            chaine += line + System.lineSeparator();
        }

        return chaine;
    }
}
