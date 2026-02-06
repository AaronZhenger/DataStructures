import Tools.DS8_Queue;

import java.awt.Point;

public class DS8_BFS {
    public static int breadthFirstSearch_Portals(char[][] maze) {
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
            location = path[path.length-1];
            if (location.equals(end)) return path.length-1;
            Point[] newPath = new Point[path.length+1];
            for (int i = 0; i<path.length; i++)
                newPath[i] = path[i];
            if (location.x>0 && maze[location.x-1][location.y]!='W' && !visited[location.x-1][location.y]) {
                newPath[newPath.length-1] = new Point(location.x-1, location.y);
                queue.offer(newPath.clone());
                visited[location.x-1][location.y]=true;
            }
            if (location.y>0 && maze[location.x][location.y-1]!='W' && !visited[location.x][location.y-1]) {
                newPath[newPath.length-1] = new Point(location.x, location.y-1);
                queue.offer(newPath.clone());
                visited[location.x][location.y-1]=true;
            }
            if (location.x< maze.length-1 && maze[location.x+1][location.y]!='W' && !visited[location.x+1][location.y]) {
                newPath[newPath.length-1] = new Point(location.x+1, location.y);
                queue.offer(newPath.clone());
                visited[location.x+1][location.y]=true;
            }
            if (location.y<maze[0].length-1 && maze[location.x][location.y+1]!='W' && !visited[location.x][location.y+1]) {
                newPath[newPath.length-1] = new Point(location.x, location.y+1);
                queue.offer(newPath.clone());
                visited[location.x][location.y+1]=true;
            }
            newPath[newPath.length - 1] = location;
            portalSearch(visited, maze,location.x ,location.y , queue, newPath);
        }
        return -1;
    }
    private static void portalSearch(boolean[][] visited, char[][] maze, int x, int y, DS8_Queue<Point[]> queue, Point[] newPath) {
        if (maze[x][y]=='A') {
            for(int i = 0; i < maze.length; i++)
                for(int j = 0; j < maze[0].length; j++) {
                    if (maze[i][j] == 'a') {
//                        Point[] newNewPath = new Point[newPath.length+1];
//                        for (int v = 0; v<newPath.length; v++)
//                            newNewPath[v] = newPath[v];
//                        newNewPath[newNewPath.length-1] = new Point(i, j);
                        newPath[newPath.length-1] = new Point(i,j);
                        if (!visited[i][j]) {
                            visited[i][j] = true;
                            newPath[newPath.length - 1] = new Point(i, j);
                            queue.offer(newPath.clone());
                        }

                    }
                }
        }
        if (maze[x][y]=='B') {
            for(int i = 0; i < maze.length; i++)
                for(int j = 0; j < maze[0].length; j++) {
                    if (maze[i][j] == 'b') {
                        newPath[newPath.length-1] = new Point(i,j);
                        if (!visited[i][j]) {
                            visited[i][j] = true;
                            newPath[newPath.length - 1] = new Point(i, j);
                            queue.offer(newPath.clone());
                        }

                    }
                }
        }
        if (maze[x][y]=='C') {
            for(int i = 0; i < maze.length; i++)
                for(int j = 0; j < maze[0].length; j++) {
                    if (maze[i][j] == 'c') {
                        newPath[newPath.length-1] = new Point(i,j);
                        if (!visited[i][j]) {
                            visited[i][j] = true;
                            newPath[newPath.length - 1] = new Point(i, j);
                            queue.offer(newPath.clone());
                        }

                    }
                }
        }
        if (maze[x][y]=='D') {
            for(int i = 0; i < maze.length; i++)
                for(int j = 0; j < maze[0].length; j++) {
                    if (maze[i][j] == 'd') {
                        newPath[newPath.length-1] = new Point(i,j);
                        if (!visited[i][j]) {
                            visited[i][j] = true;
                            newPath[newPath.length - 1] = new Point(i, j);
                            queue.offer(newPath.clone());
                        }

                    }
                }
        }
        if (maze[x][y]=='a') {
            for(int i = 0; i < maze.length; i++)
                for(int j = 0; j < maze[0].length; j++) {
                    if (maze[i][j] == 'A') {
                        newPath[newPath.length-1] = new Point(i,j);
                        if (!visited[i][j]) {
                            visited[i][j] = true;
                            newPath[newPath.length - 1] = new Point(i, j);
                            queue.offer(newPath.clone());
                        }

                    }
                }
        }
        if (maze[x][y]=='b') {
            for(int i = 0; i < maze.length; i++)
                for(int j = 0; j < maze[0].length; j++) {
                    if (maze[i][j] == 'B') {
                        newPath[newPath.length-1] = new Point(i,j);
                        if (!visited[i][j]) {
                            visited[i][j] = true;
                            newPath[newPath.length - 1] = new Point(i, j);
                            queue.offer(newPath.clone());
                        }

                    }
                }
        }
        if (maze[x][y]=='c') {
            for(int i = 0; i < maze.length; i++)
                for(int j = 0; j < maze[0].length; j++) {
                    if (maze[i][j] == 'C') {
                        newPath[newPath.length-1] = new Point(i,j);
                        if (!visited[i][j]) {
                            visited[i][j] = true;
                            newPath[newPath.length - 1] = new Point(i, j);
                            queue.offer(newPath.clone());
                        }

                    }
                }
        }
        if (maze[x][y]=='d') {
            for(int i = 0; i < maze.length; i++)
                for(int j = 0; j < maze[0].length; j++) {
                    if (maze[i][j] == 'D') {
                        newPath[newPath.length-1] = new Point(i,j);
                        if (!visited[i][j]) {
                            visited[i][j] = true;
                            newPath[newPath.length - 1] = new Point(i, j);
                            queue.offer(newPath.clone());
                        }


                    }
                }
        }

    }

    public static String breadthFirstSearch_Unweighted(String[] edges, String vertices, char start, char end) {
        boolean[] visited = new boolean[vertices.length()];
        DS8_Queue<char[]> queue = new DS8_Queue<>();
        queue.offer(new char[]{start});
        visited[vertices.indexOf(start)] = true;
        while (!queue.isEmpty()) {
            char[] path = queue.poll();
            char location = path[path.length-1];
            visited[vertices.indexOf(location)] = true;
            String formatted = "";
            for (char c : path)
                formatted+=c;
            if (visited[vertices.indexOf(end)]) return formatted;
            char[] newPath = new char[path.length+1];
            for (int i = 0; i<path.length; i++)
                newPath[i] = path[i];
            DS8_Queue<String> possiblePathways = new DS8_Queue<>();
            for (String edge : edges)
                if (edge.contains(String.valueOf(location)))
                    possiblePathways.offer(edge);
            while (!possiblePathways.isEmpty()) {
                String edge = possiblePathways.poll();
                char connect = 0;
                for (char c : edge.toCharArray())
                    if (c!=location)
                        connect = c;
                if (!visited[vertices.indexOf(connect)]) {
                    newPath[newPath.length - 1] = connect;
                    queue.offer(newPath.clone());
                }
            }
        }
        return null;
    }
}


