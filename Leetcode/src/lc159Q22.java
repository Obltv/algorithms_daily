import java.util.*;

public class lc159Q22 {
    class Solution {
        public long maxArea(int[][] coords) {
            int n = coords.length;
            if (n < 3) {
                return -1;
            }

            Map<Integer, List<Integer>> map1 = new HashMap<>();
            Map<Integer, List<Integer>> map2 = new HashMap<>();

            int index1 = Integer.MAX_VALUE;
            int index2 = Integer.MAX_VALUE;

            int index3 = Integer.MIN_VALUE;
            int index4 = Integer.MIN_VALUE;
            for (int[] c : coords) {
                int a = c[0];
                int b = c[1];
                map1.computeIfAbsent(a, k -> new LinkedList<>()).add(b);
                map2.computeIfAbsent(b, k -> new LinkedList<>()).add(a);
                index1 = Math.min(a, index1);
                index2 = Math.min(index2, b);
                index3 = Math.max(a, index3);
                index4 = Math.max(index4, b);
            }

            if (map1.size() == 1 || map2.size() == 1) {
                return -1;
            }
            long res = -1L;

            for (Map.Entry<Integer, List<Integer>> entry : map1.entrySet()) {
                List<Integer> list = entry.getValue();
                if (list.size() < 2)
                    continue;
                Collections.sort(list);
                int h = list.get(list.size() - 1) - list.get(0);
                res = Math.max(res, 1L * h * (entry.getKey() - index1));
                res = Math.max(res, 1L * h * (index3 - entry.getKey()));
            }

            for (Map.Entry<Integer, List<Integer>> entry : map2.entrySet()) {
                List<Integer> list = entry.getValue();
                if (list.size() < 2)
                    continue;
                Collections.sort(list);
                int h = list.get(list.size() - 1) - list.get(0);
                res = Math.max(res, 1L * h * (entry.getKey() - index2));
                res = Math.max(res, 1L * h * (index4 - entry.getKey()));
            }

            return res;

        }
    }
}
