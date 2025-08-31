package games.factoredgames;

public abstract class AbstractGame {
    protected String playerName1;
    protected String playerName2;
    protected String currentPlayer;

    public AbstractGame(String playerName1, String playerName2) {
        this.playerName1 = playerName1;
        this.playerName2 = playerName2;
        this.currentPlayer = playerName1;
    }

    protected abstract void doExecute(int coup);

    public void execute(int coup) {
        doExecute(coup);
        if (getCurrentPlayer().equals(playerName1)) {
            this.currentPlayer = playerName2;
        } else {
            this.currentPlayer = playerName1;
        }
    }

    public String getCurrentPlayer() {
        return this.currentPlayer;
    }
}
