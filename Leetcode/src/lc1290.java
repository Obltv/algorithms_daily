public class lc1290 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        int res = 0;
        int base = 1;

        public int getDecimalValue(ListNode head) {
            dfs(head);
            return res;
        }

        void dfs(ListNode head) {
            if (head.next != null) {
                dfs(head.next);
            }
            int value = head.val;
            if (value == 1) {
                res += base;
            }
            base *= 2;
        }
    }
}
