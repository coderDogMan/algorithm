package week.week.year2024secondQuarter;

import javafx.util.Pair;

import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class T662 {
    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> q = new LinkedList();
        Pair<TreeNode, Integer> pair = new Pair<>(root, 0);
        q.add(pair);
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            ans = Math.max(ans, q.getLast().getValue() - q.getFirst().getValue() + 1);
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> poll = q.poll();
                if (poll.getKey().left != null) q.add(new Pair<TreeNode, Integer>(poll.getKey().left, poll.getValue() * 2 + 1));
                if (poll.getKey().right != null) q.add(new Pair<TreeNode, Integer>(poll.getKey().right, poll.getValue() * 2 + 2));
            }
        }
        return ans;
    }
}
