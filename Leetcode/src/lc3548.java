import java.util.HashSet;
import java.util.Set;

public class lc3548 {
    public boolean canPartitionGrid(int[][] grid) {
        long sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += grid[i][j];
            }
        }
        return check(grid, sum) || check(rotate(grid), sum);
    }

    private boolean check(int[][] grid, long sum) {
        if (f(grid, sum)) {
            return true;
        }
        reverse(grid);
        return f(grid, sum);
    }

    private int[][] rotate(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][m - i - 1] = grid[i][j];
            }
        }
        return res;
    }

    private boolean f(int[][] grid, long sum) {
        Set<Long> set = new HashSet<>();
        set.add(0L);
        long total = 0;
        for (int i = 0; i < grid.length - 1; i++) {
            int[] row = grid[i];
            for (int j = 0; j < grid[0].length; j++) {
                total += row[j];
                if (i > 0 || j == 0 || j == grid[0].length - 1) {
                    set.add((long) grid[i][j]);
                }
            }

            if (grid[0].length == 1) {
                if (total * 2 == sum || total * 2 - sum == grid[0][0] || total * 2 - sum == grid[i][0]) {
                    return true;
                }
                continue;
            }

            if (set.contains(total * 2 - sum)) {
                return true;
            }

            if (i == 0) {
                for (int num : grid[i]) {
                    set.add((long) num);
                }
            }
        }
        return false;
    }

    private void reverse(int[][] grid) {
        int m = grid.length;
        for (int i = 0; i < m / 2; i++) {
            int[] tmp = grid[i];
            grid[i] = grid[m - i - 1];
            grid[m - i - 1] = tmp;
        }
    }
}
