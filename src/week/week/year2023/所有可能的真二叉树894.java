package week.week.year2023;

import java.util.LinkedList;
import java.util.List;

public class 所有可能的真二叉树894 {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new LinkedList<>();
        if (n % 2 == 0) return ans;
        else {
            for (int l = 0;  l < n; l++) {
                int r = n - 1 - l;
                for (TreeNode leftNode : allPossibleFBT(l)) {
                    for (TreeNode rightNode : allPossibleFBT(r)) {
                        TreeNode node = new TreeNode(0);
                        node.left = leftNode;
                        node.right = rightNode;
                        ans.add(node);
                    }
                }
            }

        }
        return ans;

    }
}
