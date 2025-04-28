import java.util.Arrays;

public class Q2426 {
    static long[] visited;
    static int mod = 1000000007;

    public int[] baseUnitConversions(int[][] conversions) {
        visited = new long[conversions.length + 5];
        visited[0] = 1;
        int[] res = new int[conversions.length + 1];
        res[0] = 1;
        for (int i = 1; i <= conversions.length; i++) {
            res[i] = dfs(i, conversions, visited);
        }
        return res;
    }

    public int dfs(int i, int[][] conversions, long[] visited) {
        if (visited[i] != 0) return (int) visited[i] % mod;
        int index = 0;
        for (int k = 0; k < conversions.length; k++) {
            if (conversions[k][1] == i) {
                index = k;
                break;
            }
        }
        int a = conversions[index][0], b = conversions[index][1], c = conversions[index][2];
        visited[i] = ((long) dfs(a, conversions, visited) * c) % mod;
        return (int) visited[i] % mod;
    }

//    public static void main(String[] args) {
//        int[][] conversions = new int[][]{
//                {0, 1, 2},
//                {1, 2, 3}
//        };
//        int[] res = baseUnitConversions(conversions);
//        System.out.println(Arrays.toString(res));
//    }
}