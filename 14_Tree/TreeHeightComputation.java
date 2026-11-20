package tree;

public class TreeHeightComputation {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static int computeHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(computeHeight(root.left), computeHeight(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        System.out.println("Tree Height: " + computeHeight(root));
    }
}
