import java.util.*;

public class lc886 {
    boolean res = true;
    boolean[] color;
    boolean[] visited;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        color = new boolean[n + 1];
        visited = new boolean[n + 1];
        List<Integer>[] graph = buildGraph(n, dislikes);
        for (int j = 0; j < n; j++) {
            if (!visited[j]) {
                traverse(graph, j);
            }
        }
        return res;
    }

    void traverse(List<Integer>[] graph, int i) {
        if (!res) {
            return;
        }

        visited[i] = true;
        for (int w : graph[i]) {
            if (!visited[w]) {
                color[w] = !color[i];
                traverse(graph, w);
            } else {
                if (color[w] == color[i]) {
                    res = false;
                }
            }
        }
    }

    List<Integer>[] buildGraph(int n, int[][] dislikes) {
        List<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < dislikes.length; i++) {
            graph[dislikes[i][0]].add(dislikes[i][1]);
            graph[dislikes[i][1]].add(dislikes[i][0]);
        }
        return graph;
    }

    
}