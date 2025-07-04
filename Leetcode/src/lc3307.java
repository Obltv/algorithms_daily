public class lc3307 {
    class Solution {
        public char kthCharacter(long k, int[] operations) {
            return f(k, operations, 63 - Long.numberOfLeadingZeros(k - 1));
        }

        char f(long k, int[] operations, int i) {
            if (i < 0) {
                return 'a';
            }

            int op = operations[i];

            if (k <= (1L << i)) {
                return f(k, operations, i - 1);
            }

            char ans = f(k - (1L << i), operations, i - 1);
            return (char) ('a' + (ans - 'a' + op) % 26);
        }
    }
}
