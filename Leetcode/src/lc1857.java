import java.util.*;

public class lc1857 {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<int[]>[] map = toMap(edges, n);
    }

    List<int[]>[] toMap(int[][] edges, int n) {
        List<int[]>[] res = new List[n];
        for (int i = 0; i < n; i++) {
            res[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            res[a].add(b);
        }

        return res;
    }


}
