import java.util.HashMap;
import java.util.Map;

public class lc106 {
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }

        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int rootVal = postorder[poEnd];
        int index = hm.get(rootVal);
        int size = inEnd - index;
        TreeNode root = new TreeNode(rootVal);

        root.right = build(inorder, index + 1, inEnd, postorder, poEnd - size, poEnd - 1);
        root.left = build(inorder, inStart, index - 1, postorder, poStart, poEnd - size - 1);

        return root;
    }
}
