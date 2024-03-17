public class Battleships {
    private int gridSize;
    private int numShips;
    private int totalMissiles;

    // Player grids (represents ship placements)
    private int p1Hits;
    private int p2Hits;
    private char[][] playerGrid1;
    private char[][] playerGrid2;

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
}
