import java.util.*;

public class lc3442 {
    class Solution {
        public int maxDifference(String s) {
            int[] arr = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                arr[c - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 26; i++) {
                if (arr[i] == 0) continue;
                if (arr[i] % 2 == 0 && arr[i] < min) {
                    min = arr[i];
                }
                if (arr[i] % 2 == 1 && arr[i] > max) {
                    max = arr[i];
                }
            }

            return max - min;
        }
    }

}
