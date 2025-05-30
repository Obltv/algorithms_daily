import java.util.*;

public class lc3373 {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length;
        List<Integer>[] map2 = buildMap(edges2);
        int max2 = 0;
        int m = edges2.length;
        max2 = dfs(0, -1, map2, true, 0);
        int l = map2[0].get(0);
        int max3 = dfs(l, -1, map2, true, 0);
        max2 = Math.max(max2, max3);

        int[] res = new int[n + 1];
        List<Integer>[] map1 = buildMap(edges1);
        for (int i = 0; i <= n; i++) {
            res[i] = dfs(i, -1, map1, false, 1) + max2;
        }

        return res;
    }

    int dfs(int i, int t, List<Integer>[] map, boolean flag, int cnt) {
        for (int edge : map[i]) {
            if (edge != t) {
                if (flag) {
                    cnt = Math.max(dfs(edge, i, map, false, cnt + 1), cnt);
                } else {
                    cnt = Math.max(dfs(edge, i, map, true, cnt), cnt);
                }
            }
        }
        return cnt;
    }

    List<Integer>[] buildMap(int[][] edges) {
        int n = edges.length;
        List<Integer>[] res = new ArrayList[n + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = new ArrayList<>();
        }
        for (int[] arr : edges) {
            res[arr[0]].add(arr[1]);
            res[arr[1]].add(arr[0]);
        }
        return res;
    }
}
