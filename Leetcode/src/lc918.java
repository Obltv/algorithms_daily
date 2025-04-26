import java.util.Deque;
import java.util.LinkedList;

public class lc918 {

    public static void main(String[] args) {
        int[] nums = new int[]{-3,-2,-3};
        System.out.println(maxSubarraySumCircular(nums));
    }

    public static int maxSubarraySumCircular(int[] nums) {
        int[] arr = new int[2 * nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
            arr[i + nums.length] = arr[i];
        }

        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        int res = Integer.MIN_VALUE;
        MonotonicQueue q = new MonotonicQueue();
        for (int i = 0; i < arr.length; i++) {
            // 计算当前的最大和最小差值
            res = Math.max(res, sum[i] - q.min());
            if (q.size() == nums.length) {
                q.pop();
            }
            q.push(sum[i]);
        }
        return res;
    }

    private static class MonotonicQueue {
        Deque<Integer> q = new LinkedList<>();
        Deque<Integer> minQ = new LinkedList<>();

        private void push(int n) {
            q.offerLast(n);
            // 更新minQ，维护最小值
            while (!minQ.isEmpty() && n < minQ.getLast()) {
                minQ.removeLast();
            }
            minQ.offerLast(n);
        }

        private int min() {
            return minQ.isEmpty() ? 0 : minQ.getFirst();
        }

        private int pop() {
            int a = q.removeFirst();
            // 移除minQ中对应的最小值
            if (!minQ.isEmpty() && a == minQ.peekFirst()) {
                minQ.pollFirst();
            }
            return a;
        }

        private int size() {
            return q.size();
        }
    }
}
