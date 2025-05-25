import java.util.ArrayDeque;
import java.util.Deque;

public class lc0525Q2 {
//    public String resultingString(String s) {
//        int n = s.length();
//        char[] arr = s.toCharArray();
//        int k = 0;
//        while (k < n) {
//            int index = n;
//            for (int i = k; i < n - 1; i++) {
//                if (i < 0 || arr[i] == 0) {
//                    continue;
//                }
//                char p = arr[i];
//                int j = i + 1;
//                while (j < n && arr[j] == 0) {
//                    j++;
//                }
//                char q = arr[j];
//                if (p == q + 1 || p == q - 1 || (p == 'a' && q == 'z') || (p == 'z' && q == 'a')) {
//                    arr[i] = 0;
//                    arr[j] = 0;
//                    index = i - 1;
//                }
//            }
//            k = index;
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < n; i++) {
//            if (arr[i] != 0) {
//                sb.append(arr[i]);
//            }
//        }
//        return sb.toString();
//    }

//    public static void main(String[] args) {
//        String s = "abc";
//        resultingString(s);
//    }

    public String resultingString(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && ((st.peek() == (c + 1)) || (st.peek() == (c - 1)) || ((st.peek() == 'a') && (c == 'z')) || ((st.peek() == 'z') && (c == 'a')))) {
                st.pop();
            } else {
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.removeLast());
        }
        return sb.toString();
    }
}
