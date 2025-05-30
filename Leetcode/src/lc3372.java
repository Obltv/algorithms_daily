import java.util.*;

public class lc3372 {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int max2 = 0;
        if (k > 0) {
            List<Integer>[] map2 = buildMap(edges2);
            for (int i = 0; i < map2.length; i++) {
                max2 = Math.max(dfs(i, -1, 0, k - 1, map2), max2);
            }
        }

        List<Integer>[] map1 = buildMap(edges1);
        int[] ans = new int[edges1.length + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = dfs(i, -1, 0, k, map1) + max2;
        }
        return ans;
    }

    int dfs(int i, int j, int t, int k, List<Integer>[] map) {
        if (t > k) {
            return 0;
        }
        int cnt = 1;
        for (int num : map[i]) {
            if (num != j) {
                cnt += dfs(num, i, t + 1, k, map);
            }
        }
        return cnt;
    }

    List<Integer>[] buildMap(int[][] edges) {
        int n = edges.length;
        List<Integer>[] res = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            res[e[0]].add(e[1]);
            res[e[1]].add(e[0]);
        }
        return res;
    }
}
