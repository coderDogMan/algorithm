package tree.mid;

import javax.xml.soap.Node;
import java.util.LinkedList;
import java.util.Queue;

public class 找树左下角的值513 {
    private static int deep = 0;
    private static int res = 0;

    public static void main(String[] args) {
        int bottomLeftValue = findBottomLeftValue(new TreeNode(0));
        System.out.println(bottomLeftValue);
    }

    public static int findBottomLeftValue(TreeNode root) {
        traversal(root, 1);
        return res;
    }

    public static void traversal(TreeNode root, int d) {
        if (root == null) return;
        if (d > deep) {
            deep = d;
            res = root.val;
        }
        traversal(root.left, d + 1);
        traversal(root.right, d + 1);
    }

    public int  traversal2(TreeNode root) {
        if (root == null) return 0;
        int value = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() != 0) {
            int size = queue.size();
            if (size > 0) {
                TreeNode node = queue.poll();
                value = node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            for (int i = 1; i < size; i++) {
                TreeNode node = queue.poll( );
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return value;
    }
}
