package week.week.year2023;

import java.util.HashMap;
import java.util.LinkedList;

public class 感染二叉树需要的总时间2385 {
    HashMap<TreeNode, TreeNode> parent = new HashMap<TreeNode, TreeNode>();
    int ans = 0;
    TreeNode startNode;
    int start;
    public int amountOfTime(TreeNode root, int start) {
        this.start = start;
        dfs(root);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(startNode);
        startNode.val = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && node.left.val != -1) {
                    node.left.val = -1;
                    queue.add(node.left);
                }
                if (node.right != null && node.right.val != -1) {
                    node.right.val = -1;
                    queue.add(node.right);
                }
                if (parent.get(node) != null && parent.get(node).val != -1) {
                    parent.get(node).val = -1;
                    queue.add(parent.get(node));
                }
                ans++;
            }
        }
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.val == start) {
            startNode = root;
        }
        if (root.left != null) {
            parent.put(root.left, root);
        }
        if (root.right != null) {
            parent.put(root.right, root);
        }
        dfs(root.left);
        dfs(root.right);
    }
}

class Test11 {
    public static void main(String[] args) {
        感染二叉树需要的总时间2385 test = new 感染二叉树需要的总时间2385();
        test.amountOfTime(new TreeNode(16, null, new TreeNode(20, new TreeNode(7, null, new TreeNode(15, null, new TreeNode(1))), new TreeNode(12, null,new TreeNode(19, new TreeNode(2), null)))), 1);
//        test.amountOfTime(new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4, new TreeNode(5), null), null), null), null), 3);
//        test.amountOfTime(new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4, new TreeNode(5), null), null), null), null), 2);
//        test.amountOfTime(new TreeNode(1, new TreeNode(5, null, new TreeNode(4, new TreeNode(9), new TreeNode(2))), new TreeNode(3, new TreeNode(10), new TreeNode(6))), 3);
    }
}
