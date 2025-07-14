public class lc0714Q3 {
    class Solution {
        public char processStr(String s, long k) {
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

            int resLen = sb.length();
            String res = sb.toString();
            if (k < resLen || k > resLen) {
                return '.';
            }else{
                return res.charAt((int) k);
            }
        }
    }
}
