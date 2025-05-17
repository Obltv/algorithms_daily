public class lc130 {
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


    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        UF uf = new UF(m * n + 1);
        int dummy = m * n;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                uf.union(i * n, m * n);
            }
            if (board[i][n - 1] == 'O') {
                uf.union(i * n, m * n);
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                uf.union(i, m * n);
            }
            if (board[n - 1][i] == 'O') {
                uf.union((n - 1) * n + i, m * n);
            }
        }

        int[][] d = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        for (int i = 1; i < m - 1; i++)
            for (int j = 1; j < n - 1; j++)
                if (board[i][j] == 'O')
                    // 将此 O 与上下左右的 O 连通
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if (board[x][y] == 'O')
                            uf.union(x * n + y, i * n + j);
                    }
        // 所有不和 dummy 连通的 O，都要被替换
        for (int i = 1; i < m - 1; i++)
            for (int j = 1; j < n - 1; j++)
                if (!uf.connected(dummy, i * n + j))
                    board[i][j] = 'X';
    }
}
