import java.util.Stack;

public class lc739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res1 = new int[temperatures.length];
        int[] res2 = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res1[i] = i;
            } else {
                res1[i] = stack.peek();
            }
            stack.push(i);
        }
        for (int i = temperatures.length - 1; i >= 0; i--) {
            res2[i] = res1[i] - i;
        }
        return res2;
    }
}
