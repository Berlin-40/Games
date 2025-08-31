package games.plays;
import gamestests.plays.OrchestratorTests;
public class Test {
    public static void main(String[] args) {
        OrchestratorTests tester = new OrchestratorTests();
        boolean ok = true;
        // Change argument to true in next call to reactivate printing
        ok = ok && tester.testPlay(false);
        System.out.println(ok ? "All tests OK" : "At least one test KO");   
    }
    
}
