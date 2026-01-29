import java.util.ArrayList;
import java.awt.Point;
import java.util.Collections;

public class DS8_Dijkstras {
    public static int dijkstras_Weighted(String[] edges, String vertices, char start, char end) {
        ArrayList<DS8_Weighted_Node> list = new ArrayList<>();
        list.add(new DS8_Weighted_Node(start, 0));
        for (char vertex : vertices.toCharArray())
            if (vertex!=list.getFirst().getLocation())
                list.add(new DS8_Weighted_Node(vertex, Integer.MAX_VALUE));
        ArrayList<DS8_Weighted_Node> sorted = new ArrayList<>(list);
        Collections.sort(sorted);

        while (!sorted.isEmpty()) {
            DS8_Weighted_Node node = sorted.removeFirst();
            if (node.getDistance()==Integer.MAX_VALUE)
                break;
            if (node.getLocation()==end)
                return node.getDistance();

            ArrayList<String> adj = new ArrayList<>();
            for (String edge : edges)
                if (edge.charAt(0)==node.getLocation())
                    adj.add(edge);
            for (String n : adj) {
                DS8_Weighted_Node newNode = new DS8_Weighted_Node('-', 0);
                for (DS8_Weighted_Node sd : sorted)
                    if (sd.getLocation()==n.charAt(1))
                        newNode = sd;
                DS8_Weighted_Node difNode = new DS8_Weighted_Node(n.charAt(1), Integer.parseInt(n.substring(2)));
                int d = node.getDistance() +  difNode.getDistance();
                if (d< newNode.getDistance())
                    newNode.setDistance(d);
            }
            Collections.sort(sorted);
        }
        return -1;
    }

    public static int dijkstras_Topographical(char[][] grid, ArrayList<DS8_TerrainCost> travelCosts) {
        ArrayList<DS8_Terrian_Node> sorted = new ArrayList<>();
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 'S') {
                    sorted.add(new DS8_Terrian_Node(new Point(i, j), 0));
                }
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] != 'S')
                    sorted.add(new DS8_Terrian_Node(new Point(i, j), Integer.MAX_VALUE));
        Collections.sort(sorted);
        while (!sorted.isEmpty()) {
            System.out.println(sorted);
            DS8_Terrian_Node node = sorted.removeFirst();
            if (node.getDistance()==Integer.MAX_VALUE)
                break;
            if (grid[node.getLocation().x][node.getLocation().y] == 'E')
                return node.getDistance();
            if (node.getLocation().x>0) {
                int ogd = node.getDistance();
                int d = node.getDistance();
                for (DS8_TerrainCost cost : travelCosts) {
                    if (cost.getType() == grid[node.getLocation().x - 1][node.getLocation().y])
                        d+=cost.getCost();
                }
                if (d > ogd) {
                    DS8_Terrian_Node newNode = new DS8_Terrian_Node(new Point(0, 0), 0);
                    for (DS8_Terrian_Node n : sorted) {
                        if (n.getLocation().x==node.getLocation().x-1 && n.getLocation().y==node.getLocation().y)
                            newNode = n;
                    }
                    if (d < newNode.getDistance())
                        newNode.setDistance(d);
                }
            }
            if (node.getLocation().y>0) {
                int ogd = node.getDistance();
                int d = node.getDistance();
                for (DS8_TerrainCost cost : travelCosts) {
                    if (cost.getType() == grid[node.getLocation().x][node.getLocation().y - 1])
                        d+=cost.getCost();
                }
                if (d > ogd) {
                    DS8_Terrian_Node newNode = new DS8_Terrian_Node(new Point(0, 0), 0);
                    for (DS8_Terrian_Node n : sorted) {
                        if (n.getLocation().x==node.getLocation().x && n.getLocation().y==node.getLocation().y-1)
                            newNode = n;
                    }
                    if (d < newNode.getDistance())
                        newNode.setDistance(d);
                }
            }
            if (node.getLocation().x<grid.length-1) {
                int ogd = node.getDistance();
                int d = node.getDistance();
                for (DS8_TerrainCost cost : travelCosts) {
                    if (cost.getType() == grid[node.getLocation().x + 1][node.getLocation().y])
                        d+=cost.getCost();
                }
                if (d > ogd) {
                    DS8_Terrian_Node newNode = new DS8_Terrian_Node(new Point(0, 0), 0);
                    for (DS8_Terrian_Node n : sorted) {
                        if (n.getLocation().x==node.getLocation().x+1 && n.getLocation().y==node.getLocation().y)
                            newNode = n;
                    }
                    if (d < newNode.getDistance())
                        newNode.setDistance(d);
                }
            }
            if (node.getLocation().y< grid[0].length-1) {
                System.out.println(messageOfEncouragement());
                int ogd = node.getDistance();
                int d = node.getDistance();
                for (DS8_TerrainCost cost : travelCosts) {
                    if (cost.getType() == grid[node.getLocation().x][node.getLocation().y + 1]) {
                        d += cost.getCost();
                    }
                }
                if (d > ogd) {
                    DS8_Terrian_Node newNode = new DS8_Terrian_Node(new Point(0, 0), 0);
                    for (DS8_Terrian_Node n : sorted) {
                        if (n.getLocation().x==node.getLocation().x && n.getLocation().y==node.getLocation().y+1)
                            newNode = n;
                    }
                    if (d < newNode.getDistance())
                        newNode.setDistance(d);
                }
            }
            Collections.sort(sorted);
        }
        return -1;
    }

    private static String messageOfEncouragement() {
        String[] messages = {
                "Just give it up atp \uD83E\uDD40",
                "Wrap it up twin \uD83E\uDD40",
                "Yo this aint working anytime soon \uD83E\uDD40",
                "Why are you even trying atp \uD83E\uDD40"
        };
        return messages[(int) (Math.random()*4)];
    }
}
