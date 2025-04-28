public class lc114 {
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

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root);
    }

    TreeNode traverse(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode rightTmp = traverse(root.right);
        root.right = traverse(root.left);
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = rightTmp;
        root.left = null;
        return root;
    }
}
