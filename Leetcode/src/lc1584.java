import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lc1584 {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> graph = new ArrayList<>();
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                graph.add(new int[]{
                        i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])
                });
            }
        }

        Collections.sort(graph, (m, k) -> m[2] - k[2]);

        UF uf = new UF(n);
        int res = 0;
        for (int[] edge : graph) {
            int a = edge[0];
            int b = edge[1];
            int c = edge[2];
            if (uf.connect(a, b)) {
                continue;
            }
            res += c;
            uf.union(a, b);
        }

        return res;
    }

    class UF {
        int count;
        int[] parent;

        public UF(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        void union(int a, int b) {
            int m = find(a);
            int n = find(b);
            if (m == n) return;
            parent[m] = n;
            count--;
        }

        int find(int a) {
            if (parent[a] != a) {
                parent[a] = find(parent[a]);
            }

            return parent[a];
        }

        boolean connect(int a, int b) {
            int m = find(a);
            int n = find(b);
            return m == n;
        }
    }
}
