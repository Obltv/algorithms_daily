import java.util.LinkedList;
import java.util.Queue;

public class lc297_3 {

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
        public String serialize(TreeNode root1) {
            if (root1 == null) {
                return "";
            }

            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root1);
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode root = q.poll();

                    if (root == null) {
                        sb.append(NULL).append(SEP);
                        continue;
                    }

                    sb.append(root.val).append(SEP);

                    q.offer(root.left);
                    q.offer(root.right);
                }
            }

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            String[] nodes = data.split(SEP);
            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            int index = 1;
            while (!q.isEmpty()) {
                TreeNode parent = q.poll();
                String left = nodes[index++];
                if (!left.equals(NULL)) {
                    parent.left = new TreeNode(Integer.parseInt(left));
                    q.offer(parent.left);
                }

                String right = nodes[index++];
                if (!right.equals(NULL)) {
                    parent.right = new TreeNode(Integer.parseInt(right));
                    q.offer(parent.right);
                }

            }

            return root;
        }
    }
}
