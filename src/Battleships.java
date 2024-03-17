public class Battleships {

    Player player1;
    Player player2;
    private final int gridSize;
    private final int numShips;
    private final int totalMissiles;

    public Battleships(int gridSize, int numShips, int totalMissiles) {
        this.gridSize = gridSize;
        this.numShips = numShips;
        this.totalMissiles = totalMissiles;
        player1 = new Player(numShips, totalMissiles, gridSize);
        player2 = new Player(numShips, totalMissiles, gridSize);
    }

    public void game(String[] p1ShipPos, String[] p2ShipPos, String[] p1Missiles, String[] p2Missiles) {
        player1.placeShips(p1ShipPos);
        player2.placeShips(p2ShipPos);
        System.out.println("Player 1 Grid: ");
        player1.getBattleGround().printMap();
        System.out.println("Player 2 Grid: ");
        player2.getBattleGround().printMap();
        System.out.println("Game start ... Firing missiles!");
        player1.attack(player2, p1Missiles);
        player2.attack(player1, p2Missiles);
        System.out.println("Game ends!\n");
        printOutput();
        reset();
    }

    public void reset() {
        player1.reset();
        player2.reset();
    }

    public void printOutput() {
        System.out.println("Player 1");
        player1.getBattleGround().printMap();
        System.out.println("Player 2");
        player2.getBattleGround().printMap();
        System.out.println();

        System.out.printf("P1: %d\n", player1.getTotalHits());
        System.out.printf("P2: %d\n", player2.getTotalHits());

        if (player1.getTotalHits() > player2.getTotalHits()) {
            System.out.println("Player 1 wins");
        } else if (player1.getTotalHits() < player2.getTotalHits()) {
            System.out.println("Player 2 wins");
        } else {
            System.out.println("It is a draw");
        }
    }
}
