import java.util.Arrays;

public class lc2410 {
    class Solution {
        public int matchPlayersAndTrainers(int[] players, int[] trainers) {
            Arrays.sort(players);
            Arrays.sort(trainers);

            int m = players.length;
            int n = trainers.length;

            int j = 0;
            for (int i = 0; i < m; i++) {
                while (j < n && trainers[j] < players[i]) {
                    j++;
                }
                if (j == n) {
                    return i;
                }
                j++;
            }

            return m;
        }
    }
}
