public class lc114_2 {
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
        if(root==null){
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left=root.left;
        TreeNode right=root.right;

        root.right=left;
        root.left=null;

        TreeNode p=root;
        while(p.right!=null){
            p=p.right;
        }
        p.right=right;
    }
}
