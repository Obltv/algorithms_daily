public class lc3136 {
    class Solution {
        public boolean isValid(String word) {
            int n = word.length();
            if (n < 3) {
                return false;
            }

            boolean flag1 = false;
            boolean flag2 = false;

            for (int i = 0; i < n; i++) {
                char c = word.charAt(i);
                if (c >= '0' && c <= '9') {
                    continue;
                }

                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                        flag1 = true;
                    } else {
                        flag2 = true;
                    }
                } else {
                    return false;
                }
            }

            return flag1 && flag2;
        }
    }
}
