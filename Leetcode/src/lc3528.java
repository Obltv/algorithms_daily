import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc3528 {
    private static final int mod = 1_000_000_007;

    public int[] baseUnitConversions(int[][] conversions) {
        int n = conversions.length;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(conversions[i][0], new ArrayList<>());
            map.get(conversions[i][0]).add(conversions[i]);
        }
        int[] res = new int[n + 1];
        dfs(0, 1, map, res);
        return res;
    }

    public void dfs(int i, long n, Map<Integer, List<int[]>> map, int[] res) {
        res[i] = (int) n;
        if (map.containsKey(i)) {
            for (int[] list : map.get(i)) {
                dfs(list[1], (list[2] * n) % mod, map, res);
            }
        }
    }
}
