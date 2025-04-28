import java.util.HashMap;
import java.util.Map;

public class lc889 {
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

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            hm.put(postorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    TreeNode build(int[] preorder, int prStart, int prEnd, int[] postorder, int poStart, int poEnd) {
        //base case
        if (prStart > prEnd) {
            return null;
        }

        if (prStart == prEnd) {
            return new TreeNode(preorder[prStart]);
        }

        //根节点
        int rootVal = preorder[prStart];
        TreeNode root = new TreeNode(rootVal);
        //左子树的根节点
        int rootLeftval = preorder[prStart + 1];
        int index = hm.get(rootLeftval);
        //左子树长度
        int size = index - poStart + 1;

        //构建左子树
        root.left = build(preorder, prStart + 1, prStart + size, postorder, poStart, index);
        //构建右子树
        root.right = build(preorder, prStart + size + 1, prEnd, postorder, index + 1, poEnd - 1);

        return root;
    }
}
