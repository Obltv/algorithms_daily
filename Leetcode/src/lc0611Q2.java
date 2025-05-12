public class lc0611Q2 {
    public boolean canPartitionGrid(int[][] grid) {
        int[] a = new int[grid.length];
        int[] b = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                a[i] += grid[i][j];
                b[j] += grid[i][j];
            }
        }

        int[] a1 = new int[a.length];
        int[] b1 = new int[b.length];
        a1[0] = a[0];
        b1[0] = b[0];
        for (int i = 1; i < a.length; i++) {
            a1[i] = a[i] + a1[i - 1];
        }
        for (int i = 1; i < b.length; i++) {
            b1[i] = b[i] + b1[i - 1];
        }

        for (int i = 0; i < a.length; i++) {
            if (a1[i] == a1[a1.length - 1] - a1[i]) {
                return true;
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (b1[i] == b1[b1.length - 1] - b1[i]) {
                return true;
            }
        }
        return false;
    }
}
