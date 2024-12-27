package week.week339;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class 二叉树的堂兄弟节点II2641 {
    public TreeNode replaceValueInTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                sum += queue.get(i).left == null ? 0 : queue.get(i).left.val;
                sum += queue.get(i).right == null ? 0 : queue.get(i).right.val;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && node.right != null) {
                    int val = node.left.val + node.right.val;
                    node.left.val = sum - val;
                    node.right.val = sum - val;
                    queue.add(node.left);
                    queue.add(node.right);
                } else if (node.left == null && node.right != null) {
                    node.right.val = sum - node.right.val;
                    queue.add(node.right);
                } else if (node.left != null && node.right == null) {
                    node.left.val = sum - node.left.val;
                    queue.add(node.left);
                }
            }
        }
        return root;
    }
}

class Test6 {
    public static void main(String[] args) {
        二叉树的堂兄弟节点II2641 test = new 二叉树的堂兄弟节点II2641();
        test.replaceValueInTree(new TreeNode(5, new TreeNode(4, new TreeNode(1), new TreeNode(10)), new TreeNode(9, null, new TreeNode(7))));
    }
}