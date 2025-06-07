import java.util.ArrayDeque;
import java.util.Deque;

public class lc2434 {
//    class Solution {
//        public String robotWithString(String s) {
//            StringBuilder sb = new StringBuilder();
//            toS(s, sb);
//            return sb.toString();
//        }
//
//        public void toS(String s, StringBuilder sb) {
//            if (s == null || s.length() == 0) {
//                return;
//            }
//            char min = s.charAt(0);
//            int index = 0;
//            for (int i = 1; i < s.length(); i++) {
//                if (s.charAt(i) < min) {
//                    min = s.charAt(i);
//                    index = i;
//                }
//            }
//
//            String str = new StringBuilder(s.substring(0, index + 1)).reverse().toString();
//            sb.append(str);
//            toS(s.substring(index + 1), sb);
//        }
//    }

    class Solution {
        public String robotWithString(String s) {
            int n = s.length();
            int[] arr = new int[n + 1];
            arr[n] = Character.MAX_VALUE;
            for (int i = n - 1; i >= 0; i--) {
                arr[i] = Math.min(s.charAt(i), arr[i + 1]);
            }

            StringBuilder res = new StringBuilder();
            Deque<Character> q = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                q.push(s.charAt(i));
                while (!q.isEmpty() && q.peek() <= arr[i + 1]) {
                    res.append(q.pop());
                }
            }

            return res.toString();
        }
    }


}
