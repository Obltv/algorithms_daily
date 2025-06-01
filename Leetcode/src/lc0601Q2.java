import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class lc0601Q2 {
//    public int[][] minAbsDiff(int[][] grid, int k) {
//        int m = grid.length;
//        int n = grid[0].length;
//        int[][] ans = new int[m - k + 1][n - k + 1];
//        for (int i = 0; i < m - k + 1; i++) {
//            for (int j = 0; j < n - k + 1; j++) {
//                ans[i][j] = abs(i, j, grid, k);
//            }
//        }
//
//        return ans;
//    }
//
//    int abs(int m, int n, int[][] grid, int k) {
//        int[] arr = new int[k * k];
//        for (int i = m; i < m + k; i++) {
//            for (int j = n; j < n + k; j++) {
//                arr[(i - m) * k + j - n] = grid[i][j];
//            }
//        }
//
//        Arrays.sort(arr);
//        int min = 1000000000;
//        for (int i = 0; i < k * k - 1; i++) {
//            min = Math.min(min, arr[i + 1] - arr[i]);
//        }
//        return min;
//    }

    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];
        for (int i = 0; i < m - k + 1; i++) {
            for (int j = 0; j < n - k + 1; j++) {
                ans[i][j] = abs(i, j, grid, k);
            }
        }
        return ans;
    }

    int abs(int m, int n, int[][] grid, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = m; i < m + k; i++) {
            for (int j = n; j < n + k; j++) {
                set.add(grid[i][j]);
            }
        }

        if (set.size() == 1) return 0;

        int[] arr = set.stream().mapToInt(x -> x).toArray();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            min = Math.min(min, arr[i + 1] - arr[i]);
        }
        return min;
    }

}
