import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

public class DS8_Graphs {
    public static ArrayList<String> bridges(String[] edges, String vertices) { String[] diffEdges = new String[edges.length-1]; ArrayList<String> bridges = new ArrayList<>(); for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < diffEdges.length; j++)
                if (j>=i) diffEdges[j] = edges[j+1]; else diffEdges[j] = edges[j];
            if (DS8_BFS.breadthFirstSearch_Unweighted(diffEdges, vertices, edges[i].charAt(0), edges[i].charAt(1)) == null)  bridges.add(edges[i]);} return bridges.isEmpty() ? null : bridges;
    }
}
