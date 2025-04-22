import java.util.Stack;

public class lc1944 {
    public int[] canSeePersonsCount(int[] heights) {
        int[] res = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            int count = 0;
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                stack.pop();
                count++;
            }
            res[i] = stack.isEmpty() ? count : count + 1;
            stack.push(i);
        }
        return res;
    }
}
