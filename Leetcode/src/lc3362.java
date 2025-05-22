import java.util.*;

public class lc3362 {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int sum = 0;
        int j = 0;
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            while (j < queries.length && queries[j][0] <= i) {
                pq.add(queries[j][1]);
                j++;
            }

            while (sum < nums[i] && !pq.isEmpty() && pq.peek() >= i) {
                sum++;
                arr[pq.poll() + 1]--;
            }
            if (sum < nums[i]) {
                return -1;
            }
        }

        return pq.size();

    }
}
