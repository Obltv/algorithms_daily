import java.util.Stack;

public class lc1019 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int[] nextLargerNodes(ListNode head) {
        int[] arr = new int[10005];
        int count = 0;
        while (head != null) {
            arr[count++] = head.val;
            head = head.next;
        }

        int[] res = new int[count];
        Stack<Integer> stack = new Stack<>();
        for (int i = count - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(arr[i]);
        }
        return res;
    }
}
