package week.week.year2023;

import java.util.HashMap;

public class 从二叉树一个节点到另一个节点每一步的方向2096 {

    int startValue;
    int destValue;
    TreeNode startNode;
    TreeNode destNode;
    HashMap<Integer, TreeNode> faMap;
    String ans;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        this.startValue = startValue;
        this.destValue = destValue;
        faMap = new HashMap<>();
        init(root);
        StringBuilder sb = new StringBuilder();
        dfs(-1, startNode, sb);
        return ans;
    }

    private void dfs(int fa, TreeNode cur, StringBuilder sb) {
        if (cur == null) return;
        if (cur.val == destValue) {
            ans = sb.toString();
            return;
        }
        if (cur.left != null && cur.left.val != fa) {
            dfs(cur.val, cur.left, sb.append('L'));
            sb.delete(sb.length() - 1, sb.length());
        }
        if (cur.right != null && cur.right.val != fa) {
            dfs(cur.val, cur.right, sb.append('R'));
            sb.delete(sb.length() - 1, sb.length());
        }

        if (faMap.get(cur.val) != null && faMap.get(cur.val).val != fa) {
            dfs(cur.val, faMap.get(cur.val) , sb.append('U'));
            sb.delete(sb.length() - 1, sb.length());
        }

    }

    private void init(TreeNode root) {
        if (root == null) return;
        if (root.val == startValue) startNode = root;
        if (root.val == destValue) destNode = root;
        if (root.left != null) {
            faMap.put(root.left.val, root);
        }
        if (root.right != null) {
            faMap.put(root.right.val, root);
        }
        init(root.left);
        init(root.right);
    }
}

class Test60 {
    public static void main(String[] args) {
        从二叉树一个节点到另一个节点每一步的方向2096 test = new 从二叉树一个节点到另一个节点每一步的方向2096();
        test.getDirections(new TreeNode(2, new TreeNode(1), null), 2, 1);
    }
}