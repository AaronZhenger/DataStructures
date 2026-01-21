import java.awt.Point;
import java.util.Arrays;

public class DS8_BFS {
    public static int breadthFirstSearch_Portals(char[][] maze) {
        System.out.println();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Point location = new Point();
        Point end = new Point();
        for(int i = 0; i < maze.length; i++)
            for(int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 'S') {
                    location.setLocation(i, j);
                    visited[i][j] = true;
                }
                else if (maze[i][j]=='E')
                    end.setLocation(i, j);
            }
        DS8_Queue<Point[]> queue = new DS8_Queue<>();
        queue.offer(new Point[]{location});
        while (!queue.isEmpty()) {
            Point[] path = queue.poll();
            System.out.println(queue);
            System.out.println(Arrays.toString(path));
            location = path[path.length-1];
            if (visited[end.x][end.y] && location.equals(end)) return path.length-1;
            Point[] newPath = new Point[path.length+1];
            for (int i = 0; i<path.length; i++)
                newPath[i] = path[i];
            if (location.x>0 && maze[location.x-1][location.y]!='W' && !visited[location.x-1][location.y]) {
                newPath[newPath.length-1] = new Point(location.x-1, location.y);
                queue.offer(newPath.clone());
                visited[location.x-1][location.y]=true;
                portalSearch(visited, maze,location.x-1 ,location.y , queue, newPath);
            }
            if (location.y>0 && maze[location.x][location.y-1]!='W' && !visited[location.x][location.y-1]) {
                newPath[newPath.length-1] = new Point(location.x, location.y-1);
                queue.offer(newPath.clone());
                System.out.println("Tried to go left");
                visited[location.x][location.y-1]=true;
                portalSearch(visited, maze,location.x ,location.y-1 , queue, newPath);
            }
            if (location.x< maze.length-1 && maze[location.x+1][location.y]!='W' && !visited[location.x+1][location.y]) {
                newPath[newPath.length-1] = new Point(location.x+1, location.y);
                queue.offer(newPath.clone());
                visited[location.x+1][location.y]=true;
                portalSearch(visited, maze,location.x+1 ,location.y , queue, newPath);
            }
            if (location.y<maze[0].length-1 && maze[location.x][location.y+1]!='W' && !visited[location.x][location.y+1]) {
                newPath[newPath.length-1] = new Point(location.x, location.y+1);
                queue.offer(newPath.clone());
                System.out.println("Tried to go right");
                visited[location.x][location.y+1]=true;
                portalSearch(visited, maze,location.x ,location.y+1 , queue, newPath);
            }
        }
        return -1;
    }
    private static void portalSearch(boolean[][] visited, char[][] maze, int x, int y, DS8_Queue<Point[]> queue, Point[] newPath) {
        if (maze[x][y]=='A') {
            for(int i = 0; i < maze.length; i++)
                for(int j = 0; j < maze[0].length; j++) {
                    if (maze[i][j] == 'a') {
                        Point[] newNewPath = new Point[newPath.length+1];
                        for (int v = 0; v<newPath.length; v++)
                            newNewPath[v] = newPath[v];
                        newNewPath[newNewPath.length-1] = new Point(i, j);
                        queue.offer(newNewPath);
                        visited[i][j] = true;
                    }
                }
        }
        if (maze[x][y]=='B') {
            for(int i = 0; i < maze.length; i++)
                for(int j = 0; j < maze[0].length; j++) {
                    if (maze[i][j] == 'b') {
                        Point[] newNewPath = new Point[newPath.length+1];
                        for (int v = 0; v<newPath.length; v++)
                            newNewPath[v] = newPath[v];
                        newNewPath[newNewPath.length-1] = new Point(i, j);
                        queue.offer(newNewPath);
                        visited[i][j] = true;
                    }
                }
        }
        if (maze[x][y]=='C') {
            for(int i = 0; i < maze.length; i++)
                for(int j = 0; j < maze[0].length; j++) {
                    if (maze[i][j] == 'c') {
                        Point[] newNewPath = new Point[newPath.length+1];
                        for (int v = 0; v<newPath.length; v++)
                            newNewPath[v] = newPath[v];
                        newNewPath[newNewPath.length-1] = new Point(i, j);
                        queue.offer(newNewPath);
                        visited[i][j] = true;
                    }
                }
        }
        if (maze[x][y]=='D') {
            for(int i = 0; i < maze.length; i++)
                for(int j = 0; j < maze[0].length; j++) {
                    if (maze[i][j] == 'd') {
                        Point[] newNewPath = new Point[newPath.length+1];
                        for (int v = 0; v<newPath.length; v++)
                            newNewPath[v] = newPath[v];
                        newNewPath[newNewPath.length-1] = new Point(i, j);
                        queue.offer(newNewPath);
                        visited[i][j] = true;
                    }
                }
        }
        if (maze[x][y]=='a') {
            for(int i = 0; i < maze.length; i++)
                for(int j = 0; j < maze[0].length; j++) {
                    if (maze[i][j] == 'A') {
                        Point[] newNewPath = new Point[newPath.length+1];
                        for (int v = 0; v<newPath.length; v++)
                            newNewPath[v] = newPath[v];
                        newNewPath[newNewPath.length-1] = new Point(i, j);
                        queue.offer(newNewPath);
                        visited[i][j] = true;
                    }
                }
        }
        if (maze[x][y]=='b') {
            for(int i = 0; i < maze.length; i++)
                for(int j = 0; j < maze[0].length; j++) {
                    if (maze[i][j] == 'B') {
                        Point[] newNewPath = new Point[newPath.length+1];
                        for (int v = 0; v<newPath.length; v++)
                            newNewPath[v] = newPath[v];
                        newNewPath[newNewPath.length-1] = new Point(i, j);
                        queue.offer(newNewPath);
                        visited[i][j] = true;
                    }
                }
        }
        if (maze[x][y]=='c') {
            for(int i = 0; i < maze.length; i++)
                for(int j = 0; j < maze[0].length; j++) {
                    if (maze[i][j] == 'C') {
                        Point[] newNewPath = new Point[newPath.length+1];
                        for (int v = 0; v<newPath.length; v++)
                            newNewPath[v] = newPath[v];
                        newNewPath[newNewPath.length-1] = new Point(i, j);
                        queue.offer(newNewPath);
                        visited[i][j] = true;
                    }
                }
        }
        if (maze[x][y]=='d') {
            for(int i = 0; i < maze.length; i++)
                for(int j = 0; j < maze[0].length; j++) {
                    if (maze[i][j] == 'D') {
                        Point[] newNewPath = new Point[newPath.length+1];
                        for (int v = 0; v<newPath.length; v++)
                            newNewPath[v] = newPath[v];
                        newNewPath[newNewPath.length-1] = new Point(i, j);
                        queue.offer(newNewPath);
                        visited[i][j] = true;
                    }
                }
        }

    }
}


