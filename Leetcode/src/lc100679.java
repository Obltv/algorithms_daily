public class lc100679 {
    class Solution {
        public String processStr(String s) {
            StringBuilder sb = new StringBuilder();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                char ch = s.charAt(i);
                if (ch >= 'a' && ch <= 'z') {
                    sb.append(ch);
                }
                if (ch == '*') {
                    if (!sb.isEmpty()) {
                        sb.setLength(sb.length() - 1);
                    }
                }
                if (ch == '#') {
                    String s1 = sb.toString();
                    sb.append(s1);
                }
                if (ch == '%') {
                    sb.reverse();
                }
            }

            return sb.toString();
        }
    }
}
