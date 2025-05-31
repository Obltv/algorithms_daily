import java.util.Arrays;

public class lc2359 {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] arr1 = dfs(edges, node1);
        int[] arr2 = dfs(edges, node2);

        int res = -1;
        int dis = n;
        for (int i = 0; i < n; i++) {
            int m = Math.max(arr1[i], arr2[i]);
            if (m < dis) {
                dis = m;
                res = i;
            }
        }

        return res;
    }

    int[] dfs(int[] edges, int node) {
        int n = edges.length;
        int[] res = new int[n];
        Arrays.fill(res, n);
        int x = node;
        for (int d = 0; x >= 0 && res[x] == n; x = edges[x]) {
            res[x] = d++;
        }
        return res;
    }
}
