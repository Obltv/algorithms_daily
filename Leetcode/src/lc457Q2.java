import java.util.*;

public class lc457Q2 {
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

            if (rootP == rootQ)
                return;

            if (rootP < rootQ) {
                parent[rootQ] = rootP;
            } else {
                parent[rootP] = rootQ;
            }
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
        public int[] processQueries(int c, int[][] connections, int[][] queries) {
            UF uf = new UF(c + 1);
            boolean[] visited = new boolean[c + 1];
            Arrays.fill(visited, true);

            for (int i = 0; i < connections.length; i++) {
                int u = connections[i][0], v = connections[i][1];
                uf.union(u, v);
            }

            List<Integer>[] list = new List[c + 1];
            for (int i = 1; i <= c; i++) {
                int k = uf.find(i);
                if (list[k] == null)
                    list[k] = new ArrayList<>();
                list[k].add(i);
            }

            List<Integer> res = new LinkedList<>();

            for (int i = 0; i < queries.length; i++) {
                int a = queries[i][0];
                int b = queries[i][1];
                if (a == 1) {
                    if (!visited[b]) {
                        res.add(b);
                    } else {
                        int p = uf.find(b);
                        int min = Integer.MAX_VALUE;
                        for (int j : list[p]) {
                            if (visited[j]) {
                                min = Math.min(min, j);
                            }
                        }
                        int re = min == Integer.MAX_VALUE ? -1 : min;
                        res.add(re);
                    }
                } else {
                    visited[b] = false;
                }
            }

            int[] resArray = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                resArray[i] = res.get(i);
            }
            return resArray;
        }
    }
}
