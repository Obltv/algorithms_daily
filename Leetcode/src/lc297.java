import java.util.LinkedList;
import java.util.List;

public class lc297 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        String SEP = ",";
        String NULL = "#";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            _serialize(root, sb);
            return sb.toString();
        }

        void _serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULL).append(SEP);
                return;
            }

            sb.append(root.val).append(SEP);

            _serialize(root.left, sb);
            _serialize(root.right, sb);

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<String> list = new LinkedList<>();
            for (String s : data.split(SEP)) {
                list.add(s);
            }
            return _deserialize(list);
        }

        TreeNode _deserialize(LinkedList<String> list) {
            if (list.isEmpty()) {
                return null;
            }

            String node = list.removeFirst();
            if (node.equals(NULL)) {
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(node));
            root.left = _deserialize(list);
            root.right = _deserialize(list);

            return root;
        }
    }
}
