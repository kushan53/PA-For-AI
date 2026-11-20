package tree;

import java.util.HashMap;
import java.util.Map;

public class LC105_ConstructBinaryTreeFromPreorderAndInorder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    private static int preIndex = 0;
    private static Map<Integer, Integer> inMap = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        inMap.clear();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return construct(preorder, 0, inorder.length - 1);
    }

    private static TreeNode construct(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = inMap.get(rootVal);

        root.left = construct(preorder, inStart, rootIndex - 1);
        root.right = construct(preorder, rootIndex + 1, inEnd);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println("Root val: " + root.val);
        System.out.println("Left val: " + root.left.val);
        System.out.println("Right val: " + root.right.val);
    }
}
