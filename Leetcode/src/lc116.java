public class lc116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        traverse(root.left, root.right);
        return root;
    }

    void traverse(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }

        left.next = right;

        traverse(left.left, left.right);
        traverse(right.left, right.right);
        traverse(left.right, right.left);
    }
}
