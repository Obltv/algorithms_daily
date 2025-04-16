import java.util.LinkedList;
import java.util.Queue;

public class lc933 {
    class RecentCounter {
        Queue<Integer> q;

        public RecentCounter() {
            q = new LinkedList<>();

        }

        public int ping(int t) {
            q.offer(t);
            int m = t - 3000;
            while (q.peek() < m) {
                q.poll();
            }
            return q.size();
        }
    }
}
