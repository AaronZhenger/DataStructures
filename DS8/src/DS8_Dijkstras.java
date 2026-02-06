import Tools.DS8_Weighted_Node;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

public class DS8_Dijkstras {
    public static int dijkstras_Weighted(String[] edges, String vertices, char start, char end) {
        ArrayList<DS8_Weighted_Node> sorted = new ArrayList<>();
        for (char v : vertices.toCharArray())
            sorted.add(v==start ? new DS8_Weighted_Node(v, 0) : new DS8_Weighted_Node(v, Integer.MAX_VALUE));
        Collections.sort(sorted);
        while (!sorted.isEmpty()) {
            DS8_Weighted_Node node = sorted.removeFirst();
            if (node.getDistance()==Integer.MAX_VALUE)
                break;
            if (node.getLocation()==end)
                return node.getDistance();
            ArrayList<DS8_Weighted_Node> adj = new ArrayList<>();
            for (String edge : edges)
                if (edge.charAt(0)==node.getLocation())
                    adj.add(new DS8_Weighted_Node(edge.charAt(1), Integer.parseInt(edge.substring(2))));
            for (DS8_Weighted_Node n : adj) {
                int d = node.getDistance() + n.getDistance();
                for (DS8_Weighted_Node ogn : sorted) {
                    if (ogn.getLocation()==n.getLocation() && d < ogn.getDistance())
                        ogn.setDistance(d);
                }
            }
            Collections.sort(sorted);
        }
        return -1;
    }

    public static int dijkstras_Topographical(char[][] grid, ArrayList<DS8_TerrainCost> travelCosts) {
        ArrayList<DS8_Terrian_Node> sorted = new ArrayList<>();
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                sorted.add(new DS8_Terrian_Node(new Point(i, j), grid[i][j]=='S' ? 0 : Integer.MAX_VALUE));
        Collections.sort(sorted);
        while (!sorted.isEmpty()) {
            System.out.println(sorted);
            DS8_Terrian_Node node = sorted.removeFirst();
            if (node.getDistance() == Integer.MAX_VALUE)
                break;
            if (grid[node.getLocation().x][node.getLocation().y]=='E')
                return node.getDistance();
            if (node.getLocation().x > 0) {
                for (DS8_TerrainCost t : travelCosts) {
                    if (t.getType()==grid[node.getLocation().x-1][node.getLocation().y] && t.getCost() != -1) {
                        int d = node.getDistance() + t.getCost();
                        for (DS8_Terrian_Node s : sorted)
                            if (s.getLocation().x==node.getLocation().x-1 && s.getLocation().y==node.getLocation().y)
                                s.setDistance(Math.min(d, s.getDistance()));
                    }
                }
            }
            if (node.getLocation().y > 0) {
                for (DS8_TerrainCost t : travelCosts) {
                    if (t.getType()==grid[node.getLocation().x][node.getLocation().y-1] && t.getCost() != -1) {
                        int d = node.getDistance() + t.getCost();
                        for (DS8_Terrian_Node s : sorted)
                            if (s.getLocation().x==node.getLocation().x && s.getLocation().y==node.getLocation().y-1)
                                s.setDistance(Math.min(d, s.getDistance()));
                    }
                }
            }
            if (node.getLocation().x < grid.length-1) {
                for (DS8_TerrainCost t : travelCosts) {
                    if (t.getType()==grid[node.getLocation().x+1][node.getLocation().y] && t.getCost() != -1) {
                        int d = node.getDistance() + t.getCost();
                        for (DS8_Terrian_Node s : sorted)
                            if (s.getLocation().x==node.getLocation().x+1 && s.getLocation().y==node.getLocation().y)
                                s.setDistance(Math.min(d, s.getDistance()));
                    }
                }
            }
            if (node.getLocation().y < grid[0].length-1) {
                for (DS8_TerrainCost t : travelCosts) {
                    if (t.getType()==grid[node.getLocation().x][node.getLocation().y+1] && t.getCost() != -1) {
                        int d = node.getDistance() + t.getCost();
                        for (DS8_Terrian_Node s : sorted)
                            if (s.getLocation().x==node.getLocation().x && s.getLocation().y==node.getLocation().y+1)
                                s.setDistance(Math.min(d, s.getDistance()));
                    }
                }
            }
            Collections.sort(sorted);
        }
        return -1;
    }
}
