public class lc785 {
    boolean res = true;
    boolean[] visited;
    int[] color;

    public boolean isBipartite(int[][] graph) {
        visited = new boolean[graph.length];
        color = new int[graph.length];
        color[0] = 1;
        for (int i = 1; i < graph.length; i++) {
            if (!visited[i]) {
                traverse(graph, i);
            }
        }
        return res;
    }

    void traverse(int[][] graph, int cur) {
        if (!res) return;
        visited[cur] = true;
        for (int node : graph[cur]) {
            if (!visited[node]) {
                color[node] = color[cur] == 1 ? 0 : 1;
                traverse(graph, node);
            } else {
                if (color[node] == color[cur]) {
                    res = false;
                    return;
                }
            }
        }
    }
}
