public class Player {

    private final int numShips;
    private final int totalMissiles;
    private final int gridSize;
    private int totalHits;
    private int aliveShips;
    private final BattleGround battleGround;

    public Player(int numShips, int totalMissiles, int gridSize) {
        this.numShips = numShips;
        this.totalMissiles = totalMissiles;
        this.gridSize = gridSize;
        this.totalHits = 0;
        this.aliveShips = numShips;
        this.battleGround = new BattleGround(gridSize);
    }

    public int getTotalHits() {
        return totalHits;
    }

    public BattleGround getBattleGround() {
        return battleGround;
    }

    public void placeShips(String[] shipPositions) {
        for (int i = 0; i < numShips; i++) {
            String[] position = shipPositions[i].split(",");
            int x = Integer.parseInt(position[0]);
            int y = Integer.parseInt(position[1]);
            battleGround.setAliveShip(x, y);
        }
    }

    public void shipDestroyed(int x, int y) {
        this.battleGround.setDeadShip(x, y);
        this.aliveShips -= 1;
    }

    public void fireSingleMissile(Player enemy, int x, int y) {
        if (enemy.getBattleGround().isShip(x, y)) {
            totalHits++;
            enemy.shipDestroyed(x, y);
            return;
        }
        // miss
        enemy.getBattleGround().setMissiles(x, y);
    }

    public void attack(Player enemy, String[] missilesPosition) {
        for (int i = 0; i < totalMissiles; i++) {
            String[] missiles = missilesPosition[i].split(",");
            int x = Integer.parseInt(missiles[0]);
            int y = Integer.parseInt(missiles[1]);
            fireSingleMissile(enemy, x, y);
        }
    }

    public void reset() {
        this.totalHits = 0;
        this.battleGround.resetMap();
    }
}
