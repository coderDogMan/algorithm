package other.mid;


public class 剑指Offer07重建二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preLeft, int preRigth, int[] inorder, int inLeft, int inRigth) {
        if (preLeft > preRigth) return null;
        if (preLeft == preRigth) {
            return new TreeNode(preorder[preLeft]);
        }
        TreeNode node = new TreeNode(preorder[preLeft]);
        int index = inLeft;
        while (node.val != inorder[index]) {
            index++;
        }
        // in []
        int leftLeftIn = inLeft;
        int leftRightIn = index - 1;
        int rightLeftIn = index + 1;
        int rightRightIn = inRigth;

        //pre
        int leftLeftPre = preLeft + 1;
        int leftRightPre = leftLeftPre + (leftRightIn - leftLeftIn);
        int rightLeftPre = leftRightPre + 1;
        int rightRightpre = preRigth;
        node.left = build(preorder, leftLeftPre, leftRightPre, inorder, leftLeftIn, leftRightIn);
        node.right = build(preorder, rightLeftPre, rightRightpre, inorder, rightLeftIn, rightRightIn);
        return node;
    }
}

/*
class Test {
    public static void main(String[] args) {
        剑指Offer07重建二叉树 test = new 剑指Offer07重建二叉树();
        TreeNode treeNode = test.buildTree(new int[]{1, 2}, new int[]{2, 1});
        test.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }
}*/
