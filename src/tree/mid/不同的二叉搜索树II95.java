package tree.mid;

import java.util.*;

public class 不同的二叉搜索树II95 {


    public List<TreeNode> generateTrees(int n) {

        return traversal(1, n);
    }
    // 构建  为根节点的 二叉搜索树
    public List<TreeNode> traversal(int start, int end) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        if (start > end) {
            linkedList.add(null);
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = traversal(start, i - 1);
            List<TreeNode> rightList = traversal(i + 1, end);

            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    linkedList.add(node);
                }
            }
        }

        return linkedList;
    }
}

class Test2 {
    public static void main(String[] args) {
        不同的二叉搜索树II95 test = new 不同的二叉搜索树II95();
        test.generateTrees(2);
    }
}