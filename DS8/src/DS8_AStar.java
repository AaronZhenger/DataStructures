import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

public class DS8_AStar {
    public static DS8_Path_Solution<DS8_AStar_Node<Character>> aStar_Simple(char[][] maze) {
        ArrayList<DS8_AStar_Node<Character>> open = new ArrayList<>();
        ArrayList<DS8_AStar_Node<Character>> closed = new ArrayList<>();
        DS8_AStar_Node<Character> start = new DS8_AStar_Node<>('*', null, 0, 0);
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;
        for (int i = 0; i < maze.length; i++)
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 'S') {
                    start = new DS8_AStar_Node<>(i*maze[0].length+j, null, 0, 0);
                    startX = i;
                    startY = j;
                }
                if (maze[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }
            }
        char end = endX*maze[0].length+endY;
        start.setH(Math.abs(startX-endX)+Math.abs(startY-endY));
        open.add(start);
        while (!open.isEmpty()) {
            DS8_AStar_Node<Character> n = open.removeFirst();
            if (n.getLocation()==end) {
                ArrayList<DS8_AStar_Node<Character>> sol = new ArrayList<>();
                DS8_AStar_Node<Character> nn = n;
                sol.add(nn);
                while (nn.getParent()!=null) {
                    nn = nn.getParent();
                    sol.add(nn);
                }
                DS8_Path_Solution<DS8_AStar_Node<Character>> s = new DS8_Path_Solution<>(sol, n.getF());
            }
            closed.add(n);
            if (n.getLocation()>=maze[0].length && naze[n.getLocation()/maze[0].length][n.getLocation()%maze[0].length]) {
                DS8_AStar_Node<Character> a = new DS8_AStar_Node<>(
                    n.getLocation()-maze[0].length, 
                    n, 
                    n.getG()+1, 
                    0);
            }
            Collections.sort(open);
        }
    }
}
