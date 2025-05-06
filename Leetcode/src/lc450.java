public class lc450 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        if (root.val == key) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode min = findMin(root.right);
            root.right = deleteNode(root.right, min.val);
            min.left = root.left;
            min.right = root.right;
            root = min;
        }
        return root;
    }

    TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
