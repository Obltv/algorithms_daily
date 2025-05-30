public class lc547 {
    class UF {
        int[] parent;
        int count;

        public UF(int n) {
            this.parent = new int[n];
            this.count = n;

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


    }

    public int findCircleNum(int[][] isConnected) {
        UF uf = new UF(isConnected.length);
        int m = isConnected.length;
        int n = isConnected[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }


}
