import java.util.Stack;

public class lc503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] nums2 = new int[nums.length * 2];
        int[] res2 = new int[nums2.length];
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i];
            nums2[i + nums.length] = nums[i];
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            res2[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = res2[i];
        }
        return res;
    }
}
