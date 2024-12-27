package tree.hard;


import java.util.Arrays;
import java.util.LinkedList;

public class 二叉树的序列化与反序列化297 {
    StringBuffer sbf;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sbf = new StringBuffer();
        dfsSerialize(root, sbf);
        return sbf.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] splits = data.split(",");

        return dfsDeserialize(new LinkedList<String>(Arrays.asList(splits)));
    }

    public void dfsSerialize(TreeNode root, StringBuffer sbf) {
        if (root == null) {
            sbf.append("None,");
            return;
        }
        sbf.append(root.val + ",");
        dfsSerialize(root.left, sbf);
        dfsSerialize(root.right, sbf);
    }

    public TreeNode dfsDeserialize(LinkedList<String> data) {
        if (data.peek().equals("None")) {
            data.poll();
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(data.poll()));
        node.left = dfsDeserialize(data);
        node.right = dfsDeserialize(data);
        return node;
    }
}

class Test {
    public static void main(String[] args) {
        二叉树的序列化与反序列化297 test = new 二叉树的序列化与反序列化297();
        String serialize = test.serialize(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5))));
        TreeNode deserialize = test.deserialize(serialize);
        System.out.println(deserialize);
    }
}