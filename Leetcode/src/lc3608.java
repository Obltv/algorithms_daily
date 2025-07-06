import java.util.*;

public class lc3608 {
    class UF {
        int count;
        int[] parent;

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
        public int minTime(int n, int[][] edges, int k) {
            UF uf = new UF(n);
            Arrays.sort(edges, (a, b) -> b[2] - a[2]);
            for (int[] e : edges) {
                uf.union(e[0], e[1]);

                if (uf.count < k) {
                    return e[2];
                }
            }

            return 0;
        }

    }
}
