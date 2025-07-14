import java.util.Arrays;

public class lc100721 {
    class UF {
        private int count;
        private int[] parent;

        public UF(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }

        public int find(int p) {
            while (parent[p] != p) {
                parent[p] = find(parent[p]);
                p = parent[p];
            }
            return parent[p];
        }

        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        public int count() {
            return count;
        }

    }

    class Solution {
        public int minCost(int n, int[][] edges, int k) {
            UF uf = new UF(n);
            Arrays.sort(edges, (a, b) -> a[2] - b[2]);
            for (int i = 0; i < edges.length; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                uf.union(v, u);
                if (uf.count() == k) {
                    return edges[i][2];
                }
            }

            return 0;
        }
    }


}
