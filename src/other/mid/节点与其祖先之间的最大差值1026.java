package other.mid;

public class 节点与其祖先之间的最大差值1026 {
    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int[] dfs(TreeNode root) {
        if (root == null) return null;
        int[] valLeft = dfs(root.left);
        int[] valRight = dfs(root.right);
        int max;
        int min;
        if (valLeft == null && valRight == null) {
            return new int[]{root.val, root.val};
        } else if (valLeft == null) {
            max = Math.max(valRight[0], valRight[1]);
            min = Math.min(valRight[0], valRight[1]);
        } else if (valRight == null) {
            max = Math.max(valLeft[0], valLeft[1]);
            min = Math.min(valLeft[0], valLeft[1]);
        } else {
            max = Math.max(valLeft[0], Math.max(valLeft[1], Math.max(valRight[0], valRight[1])));
            min = Math.min(valLeft[0], Math.min(valLeft[1], Math.min(valRight[0], valRight[1])));
        }
        ans = Math.max(ans, Math.abs(root.val - max));
        ans = Math.max(ans, Math.abs(root.val - min));
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        return new int[]{min, max};
    }
}

class Test27 {
    public static void main(String[] args) {
        节点与其祖先之间的最大差值1026 test = new 节点与其祖先之间的最大差值1026();
        System.out.println(test.maxAncestorDiff(new TreeNode(1, null, new TreeNode(2, null, new TreeNode(0, new TreeNode(3), null)))));
    }
}