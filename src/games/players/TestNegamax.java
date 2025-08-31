package games.players;

import gamestests.players.NegamaxPlayerTests;
import gamestests.players.NegamaxPlayerWithCacheTests;
        
public class TestNegamax {
    public static void main(String[] args) {
        
        boolean ok = true;
        NegamaxPlayerTests negamaxTester = new NegamaxPlayerTests();
        ok = ok && negamaxTester.testEvaluate();
        ok = ok && negamaxTester.testChooseMove();
        System.out.println(ok ? "All tests OK" : "At least one test KO");
    }
    
}
