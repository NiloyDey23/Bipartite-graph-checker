package project_bipartite;
import java.util.*;

public class EdgestoGraph {
    
    List<List<Integer>> graph;
    
    EdgestoGraph(List<Edges> edges, int N)
    {
        graph = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.size(); i++)
        {
            int start = edges.get(i) .start;
            int end = edges.get(i).end;
            
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
    }
}