import java.awt.*;

public class DS8_BFS {
    public static boolean depthFirstSearch_Simple(char[][] maze) {
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
        DS8_Queue<Point> queue = new DS8_Queue<>();
        queue.offer(location);
        while (!queue.isEmpty()) {
            location = queue.poll();
            if (visited[end.x][end.y]) return true;
            if (location.x>0 && maze[location.x-1][location.y]!='W' && !visited[location.x-1][location.y]) {
                queue.offer(new Point(location.x-1, location.y));
                visited[location.x-1][location.y]=true;
            }
            if (location.y>0 && maze[location.x][location.y-1]!='W' && !visited[location.x][location.y-1]) {
                queue.offer(new Point(location.x, location.y-1));
                visited[location.x][location.y-1]=true;
            }
            if (location.x< maze.length-1 && maze[location.x+1][location.y]!='W' && !visited[location.x+1][location.y]) {
                queue.offer(new Point(location.x+1, location.y));
                visited[location.x+1][location.y]=true;
            }
            if (location.y<maze[0].length-1 && maze[location.x][location.y+1]!='W' && !visited[location.x][location.y+1]) {
                queue.offer(new Point(location.x, location.y+1));
                visited[location.x][location.y+1]=true;
            }
        }
        return false;
    }

    public static boolean depthFirstSearch_Portals(char[][] maze) {
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
        DS8_Queue<Point> queue = new DS8_Queue<>();
        queue.offer(location);
        while (!queue.isEmpty()) {
            location = queue.poll();
            if (visited[end.x][end.y]) return true;
            if (location.x>0 && maze[location.x-1][location.y]!='W' && !visited[location.x-1][location.y]) {
                queue.offer(new Point(location.x-1, location.y));
                visited[location.x-1][location.y]=true;
                if (
                    maze[location.x-1][location.y]=='A'
                    || maze[location.x-1][location.y]=='B'
                    || maze[location.x-1][location.y]=='C'
                    || maze[location.x-1][location.y]=='D'
                ) {

                }
            }
            if (location.y>0 && maze[location.x][location.y-1]!='W' && !visited[location.x][location.y-1]) {
                queue.offer(new Point(location.x, location.y-1));
                visited[location.x][location.y-1]=true;
            }
            if (location.x< maze.length-1 && maze[location.x+1][location.y]!='W' && !visited[location.x+1][location.y]) {
                queue.offer(new Point(location.x+1, location.y));
                visited[location.x+1][location.y]=true;
            }
            if (location.y<maze[0].length-1 && maze[location.x][location.y+1]!='W' && !visited[location.x][location.y+1]) {
                queue.offer(new Point(location.x, location.y+1));
                visited[location.x][location.y+1]=true;
            }
        }
        return false;
    }
}


