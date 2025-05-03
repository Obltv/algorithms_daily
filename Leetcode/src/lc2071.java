import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class lc2071 {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int left = 0;
        int right = Math.min(tasks.length, workers.length) + 1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(tasks, workers, pills, strength, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean check(int[] tasks, int[] workers, int pills, int strength, int k) {
        // 贪心：用最强的 k 名工人，完成最简单的 k 个任务
        Deque<Integer> validTasks = new ArrayDeque<>();
        int i = 0;
        for (int j = workers.length - k; j < workers.length; j++) { // 枚举工人
            int w = workers[j];
            // 在吃药的情况下，把能完成的任务记录到 validTasks 中
            while (i < k && tasks[i] <= w + strength) {
                validTasks.addLast(tasks[i]);
                i++;
            }
            // 即使吃药也无法完成任务
            if (validTasks.isEmpty()) {
                return false;
            }
            // 无需吃药就能完成（最简单的）任务
            if (w >= validTasks.peekFirst()) {
                validTasks.pollFirst();
                continue;
            }
            // 必须吃药
            if (pills == 0) { // 没药了
                return false;
            }
            pills--;
            // 完成（能完成的）最难的任务
            validTasks.pollLast();
        }
        return true;
    }
}
