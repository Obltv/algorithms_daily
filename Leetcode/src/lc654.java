public class lc654 {
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

    TreeNode root = null;

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        root = traverse(nums, 0, nums.length - 1, root);
        return root;
    }

    TreeNode traverse(int[] nums, int begin, int end, TreeNode node) {
        if (begin > end) {
            return null;
        }

        int maxI = begin;
        int max = nums[begin];
        for (int i = begin + 1; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxI = i;
            }
        }

        node.val = max;
        node.left = traverse(nums, begin, maxI - 1, node.left);
        node.right = traverse(nums, maxI + 1, end, node.right);

        return node;
    }
}
