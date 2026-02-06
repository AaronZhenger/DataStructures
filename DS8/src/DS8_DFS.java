import Tools.DS8_Stack;

import java.awt.Point;

public class DS8_DFS {
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
        DS8_Stack<Point> stack = new DS8_Stack<>();
        stack.push(location);
        while (!stack.isEmpty()) {
            location = stack.pop();
            if (visited[end.x][end.y]) return true;
            if (location.x>0 && maze[location.x-1][location.y]!='W' && !visited[location.x-1][location.y]) {
                stack.push(new Point(location.x-1, location.y));
                visited[location.x-1][location.y]=true;
            }
            if (location.y>0 && maze[location.x][location.y-1]!='W' && !visited[location.x][location.y-1]) {
                stack.push(new Point(location.x, location.y-1));
                visited[location.x][location.y-1]=true;
            }
            if (location.x< maze.length-1 && maze[location.x+1][location.y]!='W' && !visited[location.x+1][location.y]) {
                stack.push(new Point(location.x+1, location.y));
                visited[location.x+1][location.y]=true;
            }
            if (location.y<maze[0].length-1 && maze[location.x][location.y+1]!='W' && !visited[location.x][location.y+1]) {
                stack.push(new Point(location.x, location.y+1));
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
        DS8_Stack<Point> stack = new DS8_Stack<>();
        stack.push(location);
        while (!stack.isEmpty()) {
            location = stack.pop();
            if (visited[end.x][end.y]) return true;
            if (location.x>0 && maze[location.x-1][location.y]!='W' && !visited[location.x-1][location.y]) {
                stack.push(new Point(location.x-1, location.y));
                visited[location.x-1][location.y]=true;
                portalSearch(visited, maze,location.x-1 ,location.y , stack);
            }
            if (location.y>0 && maze[location.x][location.y-1]!='W' && !visited[location.x][location.y-1]) {
                stack.push(new Point(location.x, location.y-1));
                visited[location.x][location.y-1]=true;
                portalSearch(visited, maze,location.x ,location.y-1 , stack);
            }
            if (location.x< maze.length-1 && maze[location.x+1][location.y]!='W' && !visited[location.x+1][location.y]) {
                stack.push(new Point(location.x+1, location.y));
                visited[location.x+1][location.y]=true;
                portalSearch(visited, maze,location.x+1 ,location.y , stack);
            }
            if (location.y<maze[0].length-1 && maze[location.x][location.y+1]!='W' && !visited[location.x][location.y+1]) {
                stack.push(new Point(location.x, location.y+1));
                visited[location.x][location.y+1]=true;
                portalSearch(visited, maze,location.x ,location.y+1 , stack);
            }
        }
        return false;
    }

    private static void portalSearch(boolean[][] visited, char[][] maze, int x, int y, DS8_Stack<Point> stack) {
        if (maze[x][y]=='A') {
            for(int i = 0; i < maze.length; i++)
                for(int j = 0; j < maze[0].length; j++) {
                    if (maze[i][j] == 'a') {
                        stack.push(new Point(i, j));
                        visited[i][j] = true;
                    }
                }
        }
        if (maze[x][y]=='B') {
            for(int i = 0; i < maze.length; i++)
                for(int j = 0; j < maze[0].length; j++) {
                    if (maze[i][j] == 'b') {
                        stack.push(new Point(i, j));
                        visited[i][j] = true;
                    }
                }
        }
        if (maze[x][y]=='C') {
            for(int i = 0; i < maze.length; i++)
                for(int j = 0; j < maze[0].length; j++) {
                    if (maze[i][j] == 'c') {
                        stack.push(new Point(i, j));
                        visited[i][j] = true;
                    }
                }
        }
        if (maze[x][y]=='D') {
            for(int i = 0; i < maze.length; i++)
                for(int j = 0; j < maze[0].length; j++) {
                    if (maze[i][j] == 'd') {
                        stack.push(new Point(i, j));
                        visited[i][j] = true;
                    }
                }
        }
        if (maze[x][y]=='a') {
            for(int i = 0; i < maze.length; i++)
                for(int j = 0; j < maze[0].length; j++) {
                    if (maze[i][j] == 'A') {
                        stack.push(new Point(i, j));
                        visited[i][j] = true;
                    }
                }
        }
        if (maze[x][y]=='b') {
            for(int i = 0; i < maze.length; i++)
                for(int j = 0; j < maze[0].length; j++) {
                    if (maze[i][j] == 'B') {
                        stack.push(new Point(i, j));
                        visited[i][j] = true;
                    }
                }
        }
        if (maze[x][y]=='c') {
            for(int i = 0; i < maze.length; i++)
                for(int j = 0; j < maze[0].length; j++) {
                    if (maze[i][j] == 'C') {
                        stack.push(new Point(i, j));
                        visited[i][j] = true;
                    }
                }
        }
        if (maze[x][y]=='d') {
            for(int i = 0; i < maze.length; i++)
                for(int j = 0; j < maze[0].length; j++) {
                    if (maze[i][j] == 'D') {
                        stack.push(new Point(i, j));
                        visited[i][j] = true;
                    }
                }
        }

    }
}


