import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc455Q2 {
    //    class Solution {
//        int[] memo;
//
//        public List<Integer> findCoins(int[] numWays) {
//            int n = numWays.length;
//            memo = new int[n + 5];
//            memo[0] = 1;
//            List<Integer> res = new ArrayList<>();
//            for (int i = 0; i < n; i++) {
//                List<Integer> list = new ArrayList<>(res);
//                int o = count(i + 1, list);
//                if (numWays[i] != o + 1 && numWays[i] != o) {
//                    return new ArrayList<>();
//                }
//                if (numWays[i] == o + 1) {
//                    res.add(i + 1);
//                }
//                memo[i + 1] = numWays[i];
//            }
//            return res;
//        }
//
//        int count(int n, List<Integer> list) {
//            for (int coin : list) {
//                memo[n] += memo[n - coin];
//            }
//            return memo[n];
//        }
//
//    }
    class Solution {
        int[] memo;

        public List<Integer> findCoins(int[] numWays) {
            int n = numWays.length;
            memo = new int[n + 5];
            Arrays.fill(memo, -1);
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                List<Integer> list = new ArrayList<>(res);
                int o = count(i + 1, list);
                if (numWays[i] != o + 1 && numWays[i] != o) {
                    return new ArrayList<>();
                }
                if (numWays[i] == o + 1) {
                    res.add(i + 1);
                }
                memo[i] = numWays[i];
            }
            return res;
        }

        int count(int n, List<Integer> list) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int coin : list) {
                for (int i = coin; i <= n; i++) {
                    dp[i] += dp[i - coin];
                }
            }
            return dp[n];
        }

    }

}
