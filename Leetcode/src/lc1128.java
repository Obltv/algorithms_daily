import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        //int n = dominoes.length;
        int n = 50000;
        int[][] ans = new int[n][n];
        for (int i = 0; i < dominoes.length; i++) {
            if (dominoes[i][0] > dominoes[i][1]) {
                int temp = dominoes[i][0];
                dominoes[i][0] = dominoes[i][1];
                dominoes[i][1] = temp;
            }
            res += ans[dominoes[i][0]][dominoes[i][1]]++;
        }
        return res;
    }
}
