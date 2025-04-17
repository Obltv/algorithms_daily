import java.util.List;

public class lc622 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class MyCircularQueue {
        private ListNode head;
        private ListNode tail;
        private int capacity;
        private int size;

        public MyCircularQueue(int k) {
            capacity = k;
            size = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            ListNode node = new ListNode(value);
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            head = head.next;
            size--;
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return head.val;
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return tail.val;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }
}