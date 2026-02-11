import java.util.ArrayList;
import java.util.Collections;

public class DS8_Graphs {
    public static ArrayList<String> bridges(String[] edges, String vertices) {
        String[] diffEdges = new String[edges.length-1];
        ArrayList<String> bridges = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < diffEdges.length; j++)
                if (j>=i) diffEdges[j] = edges[j+1];
                else diffEdges[j] = edges[j];
            if (breadthFirstSearch_Unweighted(diffEdges, vertices, edges[i].charAt(0), edges[i].charAt(1)) == null)
                bridges.add(edges[i]);}
        return bridges.isEmpty() ? null : bridges;
    }

    public static String[] stronglyConnectedRegions(String[] edges, String vertices) {
        ArrayList<String> regions = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            edges[i] = edges[i]+"1";
        }
        ArrayList<Character> usedLocations = new ArrayList<>();
        for (char v : vertices.toCharArray()) {
            if (!usedLocations.contains(v)) {
                StringBuilder thisRegion = new StringBuilder().append(v);
                for (char c : vertices.toCharArray()) {
                    if (v!=c && dijkstras_Weighted(edges, vertices, v, c) != -1 && dijkstras_Weighted(edges, vertices, c, v) != -1) {
                        thisRegion.append(c);
                        usedLocations.add(c);
                    }
                }
                if (thisRegion.length() > 1) {
                    usedLocations.add(v);
                    regions.add(thisRegion.toString());
                }
            }
        }
        String[] returnRegion = new String[regions.size()];
        for (int i = 0; i < returnRegion.length; i++) {
            returnRegion[i] = regions.get(i);
        }
        return returnRegion.length>0 ? returnRegion : null;
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
}