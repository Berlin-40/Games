package games.players;

import java.util.List;
import java.util.Random;

import games.genericgames.Game;
public class RandomPlayer implements Player{

    public RandomPlayer(Random random){}

    public int chooseMove(Game game){
        List<Integer> listMoves = game.validMoves();

        Random rand = new Random();
        int randIndice = rand.nextInt(listMoves.size());
        return listMoves.get(randIndice);
    }

    @Override
    public String toString(){
        return "Joueur aléatoire n° " + this.hashCode();
    }
}
