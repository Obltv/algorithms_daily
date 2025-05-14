import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class lc2094 {
    int[] count = new int[10];

    public int[] findEvenNumbers(int[] digits) {
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            count[digits[i]]++;
        }
        Set<Integer> set = new HashSet<>();
        dfs(0, 0, digits, set);
        int[] res = set.stream().mapToInt(i -> i).toArray();
        Arrays.sort(res);
        return res;
    }

    void dfs(int i, int n, int[] digits, Set<Integer> set) {
        if (i == 3) {
            set.add(n);
            return;
        }
        for (int d = 0; d <= 9; d++) {
            if (count[d] > 0 && (i == 0 && d != 0 || i == 1 || (i == 2 && d % 2 == 0))) {
                count[d]--;
                dfs(i + 1, n * 10 + d, digits, set);
                count[d]++;
            }
        }
    }
}
