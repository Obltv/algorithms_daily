public class lc695 {
    class Solution {
        int res = 0;
        static int[] dx = new int[]{-1, 1, 0, 0};
        static int[] dy = new int[]{0, 0, -1, 1};
        int ans = 0;

        public int maxAreaOfIsland(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        ans = 0;
                        dfs(grid, i, j);
                    }
                }
            }

            return res;
        }

        void dfs(int[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
                return;

            if (grid[i][j] == 0)
                return;

            ans++;
            grid[i][j] = 0;
            res = Math.max(ans, res);

            for (int k = 0; k < 4; k++) {
                dfs(grid, i + dx[k], j + dy[k]);
            }

        }


    }
}
