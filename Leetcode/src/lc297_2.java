import java.util.LinkedList;

public class lc297_2 {
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
//            if (root == null) {
//                sb.append(NULL).append(SEP);
//            }
//
//            _serialize(root.left, sb);
//            _serialize(root.right, sb);
//
//            sb.append(root.val).append(SEP);
            if (root == null) {
                sb.append(NULL).append(SEP);
                return;
            }

            _serialize(root.left, sb);
            _serialize(root.right, sb);

            // ****** 后序位置 ********
            sb.append(root.val).append(SEP);
            // ***********************
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

            String str = list.removeLast();
            if (str.equals(NULL)) {
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(str));
            root.right = _deserialize(list);
            root.left = _deserialize(list);

            return root;
        }
    }
}
