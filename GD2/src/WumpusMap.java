public class WumpusMap {
    public static final int NUM_ROWS = 10;
    public static final int NUM_COLUMNS = 10;
    public static final int NUM_PITS = 10;

    private WumpusSquare[][] grid;
    private int ladderC;
    private int ladderR;

    public WumpusMap() {
        createMap();
    }

    public void createMap() {
        grid = new WumpusSquare[NUM_ROWS][NUM_COLUMNS];

        for (int i = 0; i < NUM_ROWS; i++)
            for (int j = 0; j < NUM_COLUMNS; j++)
                grid[i][j] = new WumpusSquare();

        int numPits = 0;
        while (numPits<10) {
            int posX = (int) (NUM_COLUMNS*Math.random());
            int posY = (int) (NUM_ROWS*Math.random());
            if (!grid[posY][posX].getPit()) {
                grid[posY][posX].setPit(true);
                numPits++;
            }
        }

        boolean ladderPlaced = false;
        while (!ladderPlaced) {
            int ladderPosX = (int) (NUM_COLUMNS * Math.random());
            int ladderPosY = (int) (NUM_ROWS * Math.random());
            if (!grid[ladderPosY][ladderPosX].getPit()) {
                grid[ladderPosY][ladderPosX].setLadder(true);
                ladderR = ladderPosY;
                ladderC = ladderPosX;
                ladderPlaced = true;
            }
        }

        boolean wumpusPlaced = false;
        while (!wumpusPlaced) {
            int wumpusPosX = (int) (NUM_COLUMNS * Math.random());
            int wumpusPosY = (int) (NUM_ROWS * Math.random());
            if (!grid[wumpusPosY][wumpusPosX].getPit()
                    && !grid[wumpusPosY][wumpusPosX].getLadder()) {
                grid[wumpusPosY][wumpusPosX].setWumpus(true);
                wumpusPlaced = true;
            }
        }

        boolean goldPlaced = false;
        while (!goldPlaced) {
            int goldPosX = (int) (NUM_COLUMNS * Math.random());
            int goldPosY = (int) (NUM_ROWS * Math.random());
            if (!grid[goldPosY][goldPosX].getPit()
                    && !grid[goldPosY][goldPosX].getLadder()
                    && !grid[goldPosY][goldPosX].getWumpus()) {
                grid[goldPosY][goldPosX].setGold(true);
                goldPlaced = true;
            }
        }

        for (int i = 0; i < NUM_ROWS; i++)
            for (int j = 0; j < NUM_COLUMNS; j++)
                if (!grid[i][j].getPit()) {
                    if ((i > 0 && grid[i - 1][j].getPit())
                            || (j > 0 && grid[i][j - 1].getPit())
                            || (i < grid.length - 1 && grid[i + 1][j].getPit())
                            || (j < grid[0].length - 1 && grid[i][j + 1].getPit()))
                        grid[i][j].setBreeze(true);
                    if ((i > 0 && grid[i - 1][j].getWumpus())
                            || (j > 0 && grid[i][j - 1].getWumpus())
                            || (i < grid.length - 1 && grid[i + 1][j].getWumpus())
                            || (j < grid[0].length - 1 && grid[i][j + 1].getWumpus()))
                        grid[i][j].setStench(true);
                }
    }

    public int getLadderC() {
        return ladderC;
    }

    public int getLadderR() {
        return ladderR;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLUMNS; j++)
                result.append(grid[i][j]);
            result.append("\n");
        }
        return result.toString();
    }
}
