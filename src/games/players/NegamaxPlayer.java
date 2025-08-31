package games.players;

import java.util.List;
import games.genericgames.Game;

public class NegamaxPlayer implements Player{

    public NegamaxPlayer(){}


    public int evaluate(Game party){
        Game copyFirst = party.copy();
        Player winner = copyFirst.getWinner();
        Player currentPlayer = copyFirst.getCurrentPlayer();

        if(winner == currentPlayer){
            return 1;
        }
        else if(!(winner == currentPlayer || winner == null)){
            return -1;
        }
        else{
            if(winner == null && copyFirst.isOver()){
                return 0;
            }
            else{
                Integer  resultat = null;

                

                for(int coup :copyFirst.validMoves()){

                    Game copyAfterExc = copyFirst.copy();
                    copyAfterExc.execute(coup);
                    int value = -evaluate(copyAfterExc);

                    if(resultat == null || value>resultat){
                        resultat =value;
                    }
                }
                return resultat;
            }
        }
    }

    @Override
    public int chooseMove(Game game){

        Integer bestValue = null;
        Integer bestCoup = null;
        List<Integer> listMoves = game.validMoves();
        for(int coup :listMoves){

            Game copy = game.copy();
            copy.execute(coup);
            int value = -evaluate(copy);

            if(bestValue == null || value > bestValue){
                bestValue = value;
                bestCoup = coup;
            }

        }
        return bestCoup;

    }
}