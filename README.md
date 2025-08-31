# Games


.
└── games
    ├── factoredgames
    │   ├── AbstractGame.java
    │   ├── Main1.java
    │   ├── Main.java
    │   ├── Nim.java
    │   ├── Test.java
    │   └── TicTacToe.java
    ├── genericgames
    │   ├── AbstractGame.java
    │   ├── Game.java
    │   ├── Nim.java
    │   ├── Test.java
    │   └── TicTacToe.java
    ├── nim
    │   ├── Main.java
    │   ├── Nim.java
    │   └── Test.java
    ├── players
    │   ├── Human.java
    │   ├── NegamaxPlayer.java
    │   ├── Player.java
    │   ├── RandomPlayer.java
    │   ├── Test.java
    │   └── TestNegamax.java
    ├── plays
    │   ├── Main1.java
    │   ├── Main.java
    │   ├── Orchestrator.java
    │   └── Test.java
    └── tictactoe
        ├── Main1.java
        ├── Test.java
        └── TicTacToe.java

Démonstration :
    +Compilation
        Nous avons plusieurs démo

        src$ javac -d ../build games/nim/Main.java

        src$ javac -d ../build games/tictactoe/Main.java

        src$ javac -d ../build games/factoredgames/Main.java

        src$ javac -d ../build games/factoredgames/Main1.java

        src$ javac -d ../build games/plays/Main.java

        src$ javac -d ../build games/plays/Main1.java

    +Exécution
        src$ java -cp ../build games.nim.Main

        src$ java -cp ../build games.tictactoe.Main

        src$ java -cp ../build games.factoredgames.Main

        src$ java -cp ../build games.factoredgames.Main1

        src$ java -cp ../build games.plays/Main

        src$ java -cp ../build games.plays.Main1


    + Jeux
        Nous avons réaliser plusieurs jeux, ils sont dans les fichiers
        
        ├── jeu_01.txt
        ├── jeu_02.txt
Javadoc
    +Ligne de géneration
    src$ javadoc -d ../docs games/tictactoe/TicTacToe.java games/nim/Nim.java -cp ../lib/gamestests.jar


Test
    src$ javac -d ../build -cp ../lib/gamestests.jar games/nim/Test.java
    src$ java -cp ../build/:../lib/gamestests.jar games.nim.Test

    src$ javac -d ../build -cp ../lib/gamestests.jar games/tictactoe/Test.java
    src$ java -cp ../build/:../lib/gamestests.jar games.tictactoe.Test

    src$ javac -d ../build -cp ../lib/gamestests.jar games/factoredgames/Test.java
    src$ java -cp ../build/:../lib/gamestests.jar games.factoredgames.Test

    src$ javac -d ../build -cp ../lib/gamestests.jar games/genericgames/Test.java
    src$ java -cp ../build/:../lib/gamestests.jar games.genericgames.Test

    src$ javac -d ../build -cp ../lib/gamestests.jar games/plays/Test.java
    src$ java -cp ../build/:../lib/gamestests.jar games.plays.Test

    src$ javac -d ../build -cp ../lib/gamestests.jar games/players/Test.java
    src$ java -cp ../build/:../lib/gamestests.jar games.players.Test
