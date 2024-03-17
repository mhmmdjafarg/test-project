public class Battleships {
    private final int gridSize;
    private final int numShips;
    private final int totalMissiles;

    private int p1Hits;
    private int p2Hits;
    private final char[][] playerGrid1;
    private final char[][] playerGrid2;

    public Battleships(int gridSize, int numShips, int totalMissiles) {
        this.gridSize = gridSize;
        this.numShips = numShips;
        this.totalMissiles = totalMissiles;
        this.p1Hits = 0;
        this.p2Hits = 0;

        playerGrid1 = new char[gridSize][gridSize];
        playerGrid2 = new char[gridSize][gridSize];

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                playerGrid1[i][j] = '_';
                playerGrid2[i][j] = '_';
            }
        }
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
                playerGrid1[x][y] = 'B';
            }
        } else {
            for (int i = 0; i < numShips; i++) {
                String[] position = shipPositions[i].split(",");
                int x = Integer.parseInt(position[0]);
                int y = Integer.parseInt(position[1]);
                playerGrid2[x][y] = 'B';
            }
        }
    }

    /**
     * Return true if hits, else false
     */
    public boolean fireMissilesBy(int player, int x, int y) {
        if (player != 1 && player != 2) {
            System.out.println("Invalid player");
            return false;
        }

        if (x >= gridSize || y >= gridSize || x < 0 || y < 0) {
            System.out.println("Invalid positions");
            return false;
        }

        if (player == 1) {
            if (playerGrid2[x][y] == 'B') {
                p1Hits++;
                playerGrid2[x][y] = 'X';
                return true;
            }
            // miss
            playerGrid2[x][y] = 'O';
        } else {
            if (playerGrid1[x][y] == 'B') {
                p2Hits++;
                playerGrid1[x][y] = 'X';
                return true;
            }
            // miss
            playerGrid1[x][y] = 'O';
        }
        return false;
    }

    public void startWar(String[] p1Missiles, String[] p2Missiles) {
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
        System.out.println("Game ends!");

        printOutput();
        reset();
    }

    public void reset() {
        this.p1Hits = 0;
        this.p2Hits = 0;

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                playerGrid1[i][j] = '_';
                playerGrid2[i][j] = '_';
            }
        }
    }

    public void printOutput() {
        System.out.println("Player 1");
        Helper.printGrid(playerGrid1);
        System.out.println("Player 2");
        Helper.printGrid(playerGrid2);
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
