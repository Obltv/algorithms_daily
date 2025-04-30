import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc652 {
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

    List<TreeNode> ans = new ArrayList<>();
    Map<String, Integer> hm = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return ans;
    }


    String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = serialize(root.left);
        String right = serialize(root.right);

        String res = left + "," + right + "," + root.val;

        int count = hm.getOrDefault(res, 0);
        if (count == 1) {
            ans.add(root);
        }
        hm.put(res, count + 1);
        return res;
    }
}
