import java.util.*;

public class lc3607 {
    class UF {
        int[] parent;
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();

        public UF(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                map.put(i, new TreeSet<>(List.of(i)));
            }
        }

        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) return;

            if (rootP < rootQ) {
                parent[rootQ] = rootP;
                map.get(rootP).addAll(map.get(rootQ));
                map.remove(rootQ);
            } else {
                parent[rootP] = rootQ;
                map.get(rootQ).addAll(map.get(rootP));
                map.remove(rootP);
            }
        }

        public TreeSet<Integer> getGroup(int x) {
            return map.get(find(x));
        }
    }

    class Solution {
        public int[] processQueries(int c, int[][] connections, int[][] queries) {
            UF uf = new UF(c + 1);

            for (int[] co : connections) {
                uf.union(co[0], co[1]);
            }

            List<Integer> res = new ArrayList<>();
            boolean[] visited = new boolean[c + 1];
            Arrays.fill(visited, true);

            for (int[] query : queries) {
                int a = query[0], b = query[1];

                if (a == 1) {
                    TreeSet<Integer> set = uf.getGroup(b);
                    if (set.isEmpty()) {
                        res.add(-1);
                    } else {
                        if (visited[b]) {
                            res.add(b);
                        } else {
                            res.add(set.first());
                        }
                    }
                } else {
                    uf.getGroup(b).remove(b);
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
