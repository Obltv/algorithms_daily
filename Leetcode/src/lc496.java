import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
方法思路
这道题目要求我们找到nums1中每个元素在nums2中的下一个更大元素。nums1是nums2的子集，且两个数组都没有重复元素。

单调栈解法
使用单调栈可以高效地解决这类"下一个更大元素"的问题。具体思路如下：

逆序遍历nums2：我们从nums2的末尾开始向前遍历，这样可以方便地找到每个元素右侧的第一个更大元素。

维护单调栈：栈中保持单调递减的顺序。对于当前元素，我们弹出栈中所有比它小的元素，这样栈顶就是当前元素的下一个更大元素。

记录映射关系：使用哈希表记录每个元素和它的下一个更大元素的对应关系。

构建结果数组：最后根据nums1中的元素顺序，从哈希表中取出对应的结果。

为什么使用单调栈
单调栈特别适合解决这种"下一个更大/更小元素"的问题。它能保证我们以O(n)的时间复杂度解决问题，因为每个元素最多入栈和出栈一次。
 */

public class lc496 {
    //单调栈
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 存放答案的数组
        int[] res = new int[nums1.length];
        //用栈记录下一个比它大的数
        Stack<Integer> stack = new Stack<>();
        //用map映射
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            //持续遍历直到找到比当前元素大的
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stack.peek());
            }
            //入栈
            stack.push(nums2[i]);
        }
        for (int i = nums1.length - 1; i >= 0; i--) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
