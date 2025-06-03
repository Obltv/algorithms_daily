import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lc40 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0);
        return res;
    }

    void dfs(int[] candidates, int target, int start, int sum) {
        if (sum == target) {
            res.add(new LinkedList<>(track));
            return;
        }

        if (sum > target)
            return;

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            track.add(candidates[i]);
            sum += candidates[i];
            dfs(candidates, target, i + 1, sum);
            sum -= candidates[i];
            track.removeLast();
        }
    }
}
