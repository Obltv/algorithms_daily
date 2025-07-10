import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class lc1353 {
    class Solution {
        public int maxEvents(int[][] events) {
            int max = 0;
            for (int[] e : events) {
                max = Math.max(e[1], max);
            }

            List<Integer>[] list = new List[max + 1];
            Arrays.setAll(list, i -> new ArrayList<>());
            for (int[] e : events) {
                list[e[0]].add(e[1]);
            }

            int res = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i <= max; i++) {
                while (!pq.isEmpty() && pq.peek() < i) {
                    pq.poll();
                }

                for (int d : list[i]) {
                    pq.offer(d);
                }

                if (!pq.isEmpty()) {
                    res++;
                    pq.poll();
                }
            }

            return res;
        }
    }
}
