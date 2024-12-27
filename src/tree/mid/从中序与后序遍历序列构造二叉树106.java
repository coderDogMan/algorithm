package tree.mid;

public class 从中序与后序遍历序列构造二叉树106 {
    public static void main(String[] args) {
        buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
    }


    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        TreeNode tree = createTree(inorder, postorder, 0, inorder.length, 0 , postorder.length);
        return tree;
    }

    public static TreeNode createTree(int[] inorder, int[] postorder, int inleft, int inright, int postleft, int postright) {
        if (postleft >= postright || inleft >= inright) return null;
        TreeNode node = new TreeNode(postorder[postright - 1]);
        int index = 0;
        for(; index < inorder.length; index++) {
            if (inorder[index] == node.val) break;
        }
        // 左中序 inleft index,右中序 index + 1 inright
        int num = index - inleft;
        // 左后序postleft, postleft + num，右后序 postleft + num + 1, postright - 1

        node.left = createTree(inorder, postorder, inleft, index, postleft, postleft + num);
        node.right = createTree(inorder, postorder, index + 1, inright, postleft + num,postright - 1);

        return node;
    }



}
