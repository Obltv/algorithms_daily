import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class lc1298 {
    class Solution {
        int res = 0;
        HashSet<Integer> hasKey = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] box;

        public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
            int n = status.length;
            box = new boolean[n];
            for (int num : initialBoxes) {
                q.offer(num);
                box[num] = true;
            }

            while (!q.isEmpty()) {
                int cur = q.poll();
                if (status[cur] == 1 || (status[cur] == 0 && hasKey.contains(cur))) {
                    res += candies[cur];
                    for (int num : containedBoxes[cur]) {
                        q.offer(num);
                        box[num] = true;
                    }

                    for (int key : keys[cur]) {
                        hasKey.add(key);
                        if (box[key]) {
                            q.offer(key);
                        }
                    }
                }
            }

            return res;
        }
    }
}
