package other.mid;

import java.util.PriorityQueue;

public class 剑指Offer26树的子结构 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        PriorityQueue<Integer> max = new PriorityQueue<Integer>((a, b) -> (b - a));
        if (A == null || B == null) return false;
        return (A != null && B != null) && (isContains(A, B) || isContains(A.left, B) || isContains(A.right, B));
    }

    public boolean isContains(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return isContains(A.left, B.left) && isContains(A.right, B.right);
    }
}

class Test7 {
    public static void main(String[] args) {
        剑指Offer26树的子结构 test = new 剑指Offer26树的子结构();
        TreeNode A = new TreeNode(4,new TreeNode(2,
                new TreeNode(4,
                        new TreeNode(8), new TreeNode(9)),new TreeNode(5)), new TreeNode(3
        , new TreeNode(6), new TreeNode(7)));
        TreeNode B = new TreeNode(4, new TreeNode(8), new TreeNode(9));
        System.out.println(test.isContains(A, B));
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
//[3,1,1,4,3,1,1,3,1,1,1,1,30,1,3,2,1,25,2,1,19,2,1,3,2,1,11,5,1,1,2,1,3,2,1,2,1,2,1,3,2,1,0,46,3,1,1,1,30,18,5,2,1,2,1,12,1,10,5,4,3,2,1,4,3,2,1,11,2,1,8,2,1,5,4,3,2,1,11,10,9,8,7,6,5,4,3,2,1,0,1,0,3,2,1,0,0,0,0,0]
//[3,1,1,4,3,1,1,3,1,1,1,1,30,1,3,2,1,25,2,1,19,2,1,3,2,1,11,5,1,1,2,1,3,2,1,2,1,2,1,3,2,1,0,46,3,1,1,1,30,18,5,1,1,2,1,12,1,10,5,1,2,1,1,4,3,1,1,11,1,1,8,1,1,5,1,3,1,1,11,1,3,2,1,1,5,3,2,1,1,0,1,0,3,2,1,0,0,2,1,0]
    }
}