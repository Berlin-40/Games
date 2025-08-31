package games.genericgames;

import java.util.List;
import games.players.Player;

public interface  Game  {
    public Player getCurrentPlayer();
    public boolean isValid(int coup);
    public void execute(int coup);
    public boolean isOver();
    public Player getWinner();
    public List<Integer> validMoves();
    public String moveToString(int coup);
    public String situationToString();
    public Game copy();
}