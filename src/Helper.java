public class Helper {
    public static void printGrid(char[][] grid) {
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