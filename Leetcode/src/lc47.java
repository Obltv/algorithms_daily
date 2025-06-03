import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lc47 {
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] visited;

        public List<List<Integer>> permuteUnique(int[] nums) {
            visited = new boolean[nums.length];
            Arrays.sort(nums);
            dfs(nums);
            return res;
        }

        void dfs(int[] nums) {
            if (track.size() == nums.length) {
                res.add(new LinkedList<>(track));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i])
                    continue;
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                    continue;

                visited[i] = true;
                track.add(nums[i]);
                dfs(nums);
                track.removeLast();
                visited[i] = false;

            }
        }
    }
}
