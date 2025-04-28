import java.util.HashMap;
import java.util.Map;

public class lc105 {
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

    Map<Integer, Integer> hm = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        int index = hm.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int size = index - inStart;
        root.left = build(preorder, preStart + 1, preStart + size, inorder, inStart, index - 1);
        root.right = build(preorder, preStart + size + 1, preEnd, inorder, index + 1, inEnd);

        return root;

    }
}
