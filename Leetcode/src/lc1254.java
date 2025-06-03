public class lc1254 {
    class Solution {
        int res = 0;
        static int[] dx = new int[]{-1, 1, 0, 0};
        static int[] dy = new int[]{0, 0, -1, 1};

        public int closedIsland(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < m; i++) {
                dfs(grid, i, 0);
                dfs(grid, i, n - 1);
            }

            for (int i = 0; i < n; i++) {
                dfs(grid, 0, i);
                dfs(grid, m - 1, i);
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        res++;
                        dfs(grid, i, j);
                    }
                }
            }

            return res;
        }

        void dfs(int[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
                return;

            if (grid[i][j] == 1) return;

            grid[i][j] = 1;

            for (int k = 0; k < 4; k++) {
                dfs(grid, i + dx[k], j + dy[k]);
            }

        }
    }
}
