public class lc700 {
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

    TreeNode node = null;

    public TreeNode searchBST(TreeNode root, int val) {
        traverse(root, val);
        return node;
    }

    void traverse(TreeNode root, int val) {
        if (root == null) return;
        if (node != null) return;
        if (root.val == val) {
            node = root;
            return;
        }
        traverse(root.left, val);
        traverse(root.right, val);
    }
}
