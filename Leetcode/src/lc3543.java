import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc3543 {
    int res = -1;
    Set<Integer> set = new HashSet<>();

    public int maxWeight(int n, int[][] edges, int k, int t) {
        List<int[]>[] graph = buildGraph(n, edges);
        for (int i = 0; i < n; i++) {
            dfs(i, 0, 0, graph, k, t);
        }
        return res;
    }

    void dfs(int x, int l, int s, List<int[]>[] graph, int k, int t) {
        if (l == k) {
            res = Math.max(res, s);
            return;
        }
        int mask = x << 20 | l << 10 | s;
        if (!set.add(mask)) return;

        for (int[] edge : graph[x]) {
            int a = edge[0];
            int b = edge[1];
            if (s + b < t) {
                dfs(a, l + 1, s + b, graph, k, t);
            }
        }
    }

    List<int[]>[] buildGraph(int n, int[][] edges) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(new int[]{edges[i][1], edges[i][2]});
        }
        return graph;
    }
}
