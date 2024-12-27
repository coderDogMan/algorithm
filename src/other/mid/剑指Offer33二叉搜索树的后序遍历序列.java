package other.mid;

import java.util.LinkedList;

public class 剑指Offer33二叉搜索树的后序遍历序列 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length <= 2) return true;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int n = postorder.length - 1;
        stack.addLast(postorder[n]);
        int root = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (root < postorder[i]) return false;
            if (postorder[i] > stack.getLast()) {
                stack.addLast(postorder[i]);
            } else {
                root = stack.peek();
                stack.clear();
                stack.addLast(postorder[i]);
            }
        }
        return true;
    }
}

//class Test {
//    public static void main(String[] args) {
//        剑指Offer33二叉搜索树的后序遍历序列 test = new 剑指Offer33二叉搜索树的后序遍历序列();
//        test.verifyPostorder(new int[]{1,6,3,2,5});
//    }
//}
