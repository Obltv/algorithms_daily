import java.util.Stack;

public class lc402 {
    public static String removeKdigits(String num, int k) {
        int count = k;
        int index = 0;
        int l = 0;
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean flag = false;
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                count--;
                if (count == 0) {
                    index = i;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            stack.push(num.charAt(i));
        }
        for (char c : stack) {
            sb.append(c);
        }
        if (index != 0) {
            for (int i = index; i < num.length(); i++) {
                sb.append(num.charAt(i));
            }
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '0') {
                    l++;
                } else {
                    break;
                }
            }
            String substring = sb.substring(l, sb.length());
            return substring.isEmpty() ? "0" : substring;
        } else {
            for (int i = 0; i < sb.length(); i++) {
                if (k != num.length() - 1) {
                    if (sb.charAt(i) == '0') {
                        l++;
                    } else {
                        break;
                    }
                }
            }
            String substring = sb.substring(0, sb.length() - count);
            String substring2;
            if (substring.length() >= l) {
                substring2 = substring.substring(l, substring.length());
                return substring2.toString().isEmpty() ? "0" : substring2.toString();
            } else {
                return "0";
            }

        }
    }

    public static void main(String[] args) {
        String res = removeKdigits("33526221184202197273", 19);
        System.out.println(res);
    }
}
