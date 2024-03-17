public class BattleGround {
    private final int gridSize;
    private final char[][] grid;

    public BattleGround(int dim) {
        this.gridSize = dim;
        grid = new char[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = '_';
            }
        }
    }

    public void resetMap() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = '_';
            }
        }
    }

    public void setDeadShip(int x, int y) {
        grid[x][y] = 'X';
    }

    public void setAliveShip(int x, int y) {
        grid[x][y] = 'B';
    }

    public void setMissiles(int x, int y) {
        grid[x][y] = 'O';
    }

    public boolean isShip(int x, int y) {
        return grid[x][y] == 'B';
    }

    public boolean isEmptyPos(int x, int y) {
        return grid[x][y] == '_';
    }

    public void printMap() {
        int col = grid[0].length;

        for (char[] chars : grid) {
            for (int j = 0; j < col; j++) {
                if (j == col - 1) {
                    System.out.println(chars[j]);
                } else {
                    System.out.print(chars[j] + " ");
                }
            }
        }
    }
}
