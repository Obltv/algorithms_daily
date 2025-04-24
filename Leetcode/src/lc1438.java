import java.util.ArrayDeque;
import java.util.Deque;

public class lc1438 {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0, right = 0;
        int windowSize = 0, res = 0;
        MonotonicQueue monotonicQueue = new MonotonicQueue();

        while (right < nums.length) {
            monotonicQueue.push(nums[right]);
            right++;
            windowSize++;

            while (monotonicQueue.max() - monotonicQueue.min() > limit) {
                monotonicQueue.pop();
                windowSize--;
                left++;
            }
            res = Math.max(res, windowSize);
        }
        return res;
    }

    class MonotonicQueue {
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> minq = new ArrayDeque<>();
        Deque<Integer> maxq = new ArrayDeque<>();

        public void push(int n) {
            q1.addLast(n);
            while (!minq.isEmpty() && minq.peekLast() > n) {
                minq.removeLast();
            }
            minq.addLast(n);

            while (!maxq.isEmpty() && maxq.peekLast() < n) {
                maxq.removeLast();
            }
            maxq.addLast(n);
        }

        public int min() {
            return minq.isEmpty() ? Integer.MAX_VALUE : minq.getFirst();
        }

        public int max() {
            return maxq.isEmpty() ? Integer.MIN_VALUE : maxq.getFirst();
        }

        public int pop() {

            int a = q1.removeFirst();

            if (!minq.isEmpty() && minq.getFirst() == a) {
                minq.removeFirst();
            }
            if (!maxq.isEmpty() && maxq.getFirst() == a) {
                maxq.removeFirst();
            }
            return a;
        }
    }
}
