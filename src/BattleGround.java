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

    public void setPosition(int x, int y, char symbol) {
        grid[x][y] = symbol;
    }

    public boolean isShip(int x, int y) {
        return grid[x][y] == 'B';
    }

    public boolean isEmptyPos(int x, int y) {
        return grid[x][y] == '_';
    }

    public void printMap() {
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == col-1) {
                    System.out.println(grid[i][j]);
                } else {
                    System.out.print(grid[i][j] + " ");
                }
            }
        }
    }
}