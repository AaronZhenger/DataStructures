import java.awt.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class WumpusMap {
    public static final int NUM_ROWS = 10;
    public static final int NUM_COLUMNS = 10;
    public static final int NUM_PITS = 10;

    private WumpusSquare[][] grid;
    private int ladderC;
    private int ladderR;

    private int wumpusPosX;
    private int wumpusPosY;

    public WumpusMap() {
        createMap();
    }

    public void createMap() {
        grid = new WumpusSquare[NUM_ROWS][NUM_COLUMNS];

        for (int i = 0; i < NUM_ROWS; i++)
            for (int j = 0; j < NUM_COLUMNS; j++)
                grid[i][j] = new WumpusSquare();

        int numPits = 0;
        while (numPits<NUM_PITS) {
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
            wumpusPosX = (int) (NUM_COLUMNS * Math.random());
            wumpusPosY = (int) (NUM_ROWS * Math.random());
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

        char[][] charGrid = new char[NUM_ROWS][NUM_COLUMNS];
        for (int i = 0; i < NUM_ROWS; i++)
            for (int j = 0; j < NUM_COLUMNS; j++)
                charGrid[i][j] = grid[i][j].toString().charAt(0);
        if (breadthFirstSearch(charGrid)==-1)
            createMap();
    }

    public int getLadderC() {
        return ladderC;
    }

    public int getLadderR() {
        return ladderR;
    }

    public WumpusSquare getSquare(int col, int row) {
        return grid[row][col];
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

    public int getWumpusPosX() {
        return wumpusPosX;
    }

    public int getWumpusPosY() {
        return wumpusPosY;
    }

    private int breadthFirstSearch(char[][] maze) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Point location = new Point();
        Point end = new Point();
        for(int i = 0; i < maze.length; i++)
            for(int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 'L') {
                    location.setLocation(i, j);
                    visited[i][j] = true;
                }
                else if (maze[i][j]=='G')
                    end.setLocation(i, j);
            }
        DS8_Queue<Point[]> queue = new DS8_Queue<>();
        queue.offer(new Point[]{location});
        while (!queue.isEmpty()) {
            Point[] path = queue.poll();
            location = path[path.length-1];
            if (location.equals(end)) return path.length-1;
            Point[] newPath = new Point[path.length+1];
            for (int i = 0; i<path.length; i++)
                newPath[i] = path[i];
            if (location.x>0 && maze[location.x-1][location.y]!='P' && !visited[location.x-1][location.y]) {
                newPath[newPath.length-1] = new Point(location.x-1, location.y);
                queue.offer(newPath.clone());
                visited[location.x-1][location.y]=true;
            }
            if (location.y>0 && maze[location.x][location.y-1]!='P' && !visited[location.x][location.y-1]) {
                newPath[newPath.length-1] = new Point(location.x, location.y-1);
                queue.offer(newPath.clone());
                visited[location.x][location.y-1]=true;
            }
            if (location.x< maze.length-1 && maze[location.x+1][location.y]!='P' && !visited[location.x+1][location.y]) {
                newPath[newPath.length-1] = new Point(location.x+1, location.y);
                queue.offer(newPath.clone());
                visited[location.x+1][location.y]=true;
            }
            if (location.y<maze[0].length-1 && maze[location.x][location.y+1]!='P' && !visited[location.x][location.y+1]) {
                newPath[newPath.length-1] = new Point(location.x, location.y+1);
                queue.offer(newPath.clone());
                visited[location.x][location.y+1]=true;
            }
            newPath[newPath.length - 1] = location;
        }
        return -1;
    }

    private class DS8_Queue<E>
    {
        private ArrayList<E> queue;

        public DS8_Queue()
        {
            queue=new ArrayList();
        }
        public boolean add(E o)
        {
            if(offer(o))
                return true;
            else
                throw new IllegalStateException("Queue Full");
        }
        public boolean offer(E o)
        {
            return queue.add(o);
        }
        public E peek()
        {
            return isEmpty() ? null:get(0);
        }
        public E element()
        {
            return get(0);
        }
        public E poll()
        {
            if(isEmpty())
                return null;
            else
            {
                E head=peek();
                queue.remove(0);
                return head;
            }
        }
        public E remove()
        {
            if(isEmpty())
                return null;
            else
            {
                E head=peek();
                queue.remove(0);
                return head;
            }
        }
        public boolean isEmpty()
        {
            return (size()==0);
        }
        public int size()
        {
            int size=0;
            for(E item:queue)
                size++;
            return size;
        }
        public E get(int x)
        {
            if(isEmpty())
                return null;
            else if(x>size())
                throw new ArrayIndexOutOfBoundsException("Invalid value");
            else
                return queue.get(x);
        }
        public void clear(){
            queue.clear();
        }

        public String toString()
        {
            return queue.toString();
        }

    }

}
