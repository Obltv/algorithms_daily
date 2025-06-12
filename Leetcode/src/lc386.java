import java.util.LinkedList;
import java.util.List;

public class lc386 {
    class Solution {
        List<Integer> res = new LinkedList<>();

        public List<Integer> lexicalOrder(int n) {
            for (int i = 1; i <= 9; i++)
                dfs(i, n);
            return res;
        }

        void dfs(int i, int n) {
            if (i > n)
                return;
            res.add(i);
            for (int k = 0; k <= 9; k++)
                dfs(10 * i + k, n);
        }
    }
}
