import java.util.*;

public class lc1857 {
//    public int largestPathValue(String colors, int[][] edges) {
//        int n = colors.length();
//        List<int[]>[] map = toMap(edges, n);
//    }
//
//    List<int[]>[] toMap(int[][] edges, int n) {
//        List<int[]>[] res = new List[n];
//        for (int i = 0; i < n; i++) {
//            res[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < edges.length; i++) {
//            int a = edges[i][0];
//            int b = edges[i][1];
//            res[a].add(b);
//        }
//
//        return res;
//    }

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            if (x == y) { // 自环
                return -1;
            }
            g[x].add(y);
        }

        int ans = 0;
        char[] cs = colors.toCharArray();
        int[][] memo = new int[n][];
        for (int x = 0; x < n; x++) {
            int[] res = dfs(x, g, cs, memo);
            if (res.length == 0) { // 有环
                return -1;
            }
            ans = Math.max(ans, res[cs[x] - 'a']);
        }
        return ans;
    }

    private int[] dfs(int x, List<Integer>[] g, char[] colors, int[][] memo) {
        if (memo[x] != null) { // x 计算中或者计算过
            return memo[x]; // 如果是空数组，表示有环
        }
        memo[x] = new int[]{}; // 表示计算中
        int[] res = new int[26];
        for (int y : g[x]) {
            int[] cy = dfs(y, g, colors, memo);
            if (cy.length == 0) { // 有环
                return cy;
            }
            for (int i = 0; i < 26; i++) {
                res[i] = Math.max(res[i], cy[i]);
            }
        }
        res[colors[x] - 'a']++;
        return memo[x] = res; // 记忆化，同时也表示 x 计算完毕
    }

}
