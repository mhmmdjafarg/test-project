public class Battleships {
    private final int gridSize;
    private final int numShips;
    private final int totalMissiles;

    private int p1Hits;
    private int p2Hits;
    private final BattleGround p1BattleGround;
    private final BattleGround p2BattleGround;

    public Battleships(int gridSize, int numShips, int totalMissiles) {
        this.gridSize = gridSize;
        this.numShips = numShips;
        this.totalMissiles = totalMissiles;
        this.p1Hits = 0;
        this.p2Hits = 0;

        p1BattleGround = new BattleGround(gridSize);
        p2BattleGround = new BattleGround(gridSize);
    }

    public void placeShips(String[] shipPositions, int player) {
        if (player != 1 && player != 2) {
            System.out.println("Invalid player");
            return;
        }

        if (player == 1) {
            for (int i = 0; i < numShips; i++) {
                String[] position = shipPositions[i].split(",");
                int x = Integer.parseInt(position[0]);
                int y = Integer.parseInt(position[1]);
                p1BattleGround.setAliveShip(x, y);
            }
        } else {
            for (int i = 0; i < numShips; i++) {
                String[] position = shipPositions[i].split(",");
                int x = Integer.parseInt(position[0]);
                int y = Integer.parseInt(position[1]);
                p2BattleGround.setAliveShip(x, y);
            }
        }
    }

    /**
     * Return true if hits, else false
     */
    public void fireMissilesBy(int player, int x, int y) {
        if (player != 1 && player != 2) {
            System.out.println("Invalid player");
            return;
        }

        if (x >= gridSize || y >= gridSize || x < 0 || y < 0) {
            System.out.println("Invalid positions");
            return;
        }

        if (player == 1) {
            if (p2BattleGround.isShip(x, y)) {
                this.p1Hits++;
                p2BattleGround.setDeadShip(x, y);
                return;
            }
            // miss
            p2BattleGround.setMissiles(x, y);
        } else {
            if (p1BattleGround.isShip(x, y)) {
                this.p2Hits++;
                p1BattleGround.setDeadShip(x, y);
                return;
            }
            // miss
            p1BattleGround.setMissiles(x, y);
        }
    }

    public void game(String[] p1ShipPos, String[] p2ShipPos, String[] p1Missiles, String[] p2Missiles) {
        placeShips(p1ShipPos, 1);
        placeShips(p2ShipPos, 2);
        System.out.println("Player 1 Grid: ");
        p1BattleGround.printMap();
        System.out.println("Player 2 Grid: ");
        p2BattleGround.printMap();
        System.out.println("Game start ... Firing missiles!");
        for (int i = 0; i < totalMissiles; i++) {
            String[] p1Missile = p1Missiles[i].split(",");
            int x1 = Integer.parseInt(p1Missile[0]);
            int y1 = Integer.parseInt(p1Missile[1]);
            fireMissilesBy(1, x1, y1);

            String[] p2Missile = p2Missiles[i].split(",");
            int x2 = Integer.parseInt(p2Missile[0]);
            int y2 = Integer.parseInt(p2Missile[1]);
            fireMissilesBy(2, x2, y2);
        }
        System.out.println("Game ends!\n");
        printOutput();
        reset();
    }

    public void reset() {
        this.p1Hits = 0;
        this.p2Hits = 0;

        p1BattleGround.resetMap();
        p2BattleGround.resetMap();
    }

    public void printOutput() {
        System.out.println("Player 1");
        p1BattleGround.printMap();
        System.out.println("Player 2");
        p2BattleGround.printMap();
        System.out.println();
        System.out.printf("P1: %d\n", p1Hits);
        System.out.printf("P2: %d\n", p2Hits);

        if (p1Hits > p2Hits) {
            System.out.println("Player 1 wins");
        } else if (p2Hits > p1Hits) {
            System.out.println("Player 2 wins");
        } else {
            System.out.println("It is a draw");
        }
    }
}
