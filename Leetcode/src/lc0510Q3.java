import java.util.*;

public class lc0510Q3 {
    int ans[];
    int count = 0;
    boolean[] isOk;
    int o;

    public int maxWeight(int n, int[][] edges, int k, int t) {
        o = t;
        ans = new int[n];
        int res = -1;
        isOk = new boolean[n];
        List<State>[] graph = buildGraph(n, edges);

        for (int i = 0; i < n; i++) {
            count = 0;
            dfs(graph, k, 0, i);
        }
        for (int i = 0; i < n; i++) {
            if (ans[i] < t) {
                res = Math.max(res, ans[i]);
            }
        }
        return res == 0 ? -1 : res;
    }

    class State {
        int x;
        int weight;

        public State(int x, int weight) {
            this.x = x;
            this.weight = weight;
        }
    }

    void dfs(List<State>[] graph, int k, int sum, int i) {
        if (sum < o && count == k) {
            ans[i] = Math.max(ans[i], sum);
            return;
        }
        for (State s : graph[i]) {
            sum += s.weight;
            count++;
            dfs(graph, k, sum, s.x);
            count--;
            sum -= s.weight;
        }
    }

    List<State>[] buildGraph(int n, int[][] edges) {
        List<State>[] res = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            res[i] = new LinkedList<>();
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int weight = edge[2];
            res[a].add(new State(b, weight));
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1, 4}, {0, 2, 3}, {1, 2, 9}, {2, 3, 5}, {0, 3, 5}};
        lc0510Q3 lcQ3 = new lc0510Q3();
        System.out.println(lcQ3.maxWeight(4, edges, 2, 11));
    }
}
