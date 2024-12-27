package week.week.year2023;

import java.util.LinkedList;

public class 从先序遍历还原二叉树1028 {

    LinkedList<Integer> num = new LinkedList<>();
    LinkedList<Integer> op = new LinkedList<>();
    public TreeNode recoverFromPreorder(String traversal) {
        int i = 0;
        int n = traversal.length();
        while (i < n) {
            if (traversal.charAt(i) <= '9' && traversal.charAt(i) >= '0') {
                int r = i + 1;
                while (r < n && traversal.charAt(r) <= '9' && traversal.charAt(r) >= '0') {
                    r++;
                }
                num.add(Integer.parseInt(traversal.substring(i, r)));
                i = r;
            } else {
                int r = i + 1;
                while (r < n && traversal.charAt(r) == '-') {
                    r++;
                }
                op.add(r - i);
                i = r;
            }
        }
        TreeNode root = new TreeNode(num.getFirst());
        num.pollFirst();
        dfs(root, 1);
        return root;

    }

    private TreeNode dfs(TreeNode root, int deep) {
        if (num.size() == 0) return null;

        if (deep == op.getFirst()) {
            root.left = new TreeNode(num.getFirst());
            num.pollFirst();
            op.pollFirst();
            dfs(root.left, deep + 1);
        }
        if (op.size() != 0 && deep == op.getFirst()) {
            root.right = new TreeNode(num.getFirst());
            num.pollFirst();
            op.pollFirst();
            dfs(root.right, deep + 1);
        }
        return root;
    }
}
