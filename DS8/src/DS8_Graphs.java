
import java.util.ArrayList;
import java.util.Arrays;

public class DS8_Graphs {
    public static ArrayList<String> bridges(String[] edges, String vertices) {
        String[] diffEdges = new String[edges.length-1];
        ArrayList<String> bridges = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < diffEdges.length; j++)
                if (j>=i) diffEdges[j] = edges[j+1];
                else diffEdges[j] = edges[j];
            if (DS8_BFS.breadthFirstSearch_Unweighted(diffEdges, vertices, edges[i].charAt(0), edges[i].charAt(1)) == null)
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
                    if (v!=c && DS8_Dijkstras.dijkstras_Weighted(edges, vertices, v, c) != -1 && DS8_Dijkstras.dijkstras_Weighted(edges, vertices, c, v) != -1) {
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
}