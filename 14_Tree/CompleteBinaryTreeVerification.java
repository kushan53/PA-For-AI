package tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTreeVerification {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean reachedEnd = false;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr == null) {
                reachedEnd = true;
            } else {
                if (reachedEnd) return false;
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println("Is complete binary tree: " + isCompleteTree(root));
    }
}
