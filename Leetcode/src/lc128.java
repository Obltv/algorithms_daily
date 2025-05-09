import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class lc128 {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashSet<Integer> hs = new HashSet<>();
        for (int num : nums) {
            hs.add(num);
        }
        for (int x : hs) {
            if (hs.contains(x - 1)) {
                continue;
            }
            int y = x + 1;
            while (hs.contains(y)) {
                y++;
            }
            res = Math.max(res, y - x);
        }
        return res;
    }
}
