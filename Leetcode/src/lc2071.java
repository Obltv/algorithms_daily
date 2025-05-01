import java.util.Arrays;

public class lc2071 {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int res = 0;
        int index = 0;
        for (int i = 0; i < tasks.length; i++) {
            while (index < workers.length) {
                if (workers[index] >= tasks[i]) {
                    res++;
                    index++;
                    break;
                } else if (workers[index] + strength >= tasks[i]) {
                    if (pills > 0) {
                        res++;
                        index++;
                        pills--;
                        break;
                    } else {
                        index++;
                    }
                } else {
                    index++;
                }
            }
        }

        return res;
    }
}
