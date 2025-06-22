import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lc159Q2 {
    class Solution {
        public long maxArea(int[][] coords) {
            int n = coords.length;
            if (n < 3) {
                return -1;
            }

            List<Integer>[] col = new List[n];
            List<Integer>[] row = new List[n];
            for (int i = 0; i < n; i++) {
                col[i] = new LinkedList<>();
                row[i] = new LinkedList<>();
            }
            for (int i = 0; i < n; i++) {
                int a = coords[i][0];
                int b = coords[i][1];
                col[a].add(b);
                row[b].add(a);
            }

            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (col[i].size() > 1 || row[i].size() > 1) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return -1;
            }


            int index1 = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (!col[i].isEmpty()) {
                    index1 = i;
                    break;
                }
            }
            int res1 = 0;
            for (int i = 0; i < n; i++) {
                if (col[i].isEmpty()) continue;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int a : col[i]) {
                    min = Math.min(min, a);
                    max = Math.max(max, a);
                }
                res1 = Math.max(max - min, res1) * (index1 - i);
            }

            int index2 = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (!row[i].isEmpty()) {
                    index2 = i;
                    break;
                }

            }

            int res2 = 0;
            for (int i = 0; i < n; i++) {
                if (row[i].isEmpty()) continue;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int a : row[i]) {
                    min = Math.min(min, a);
                    max = Math.max(max, a);
                }
                res2 = Math.max(max - min, res1) * (index2 - i);
            }

            return Math.max(res1, res2);
        }
    }
}
