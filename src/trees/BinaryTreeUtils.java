package trees;

public class BinaryTreeUtils {

    public static int diameter(TreeNode root) {
        int[] diameter = new int[1];
        diameterHelper(root, diameter);
        return diameter[0];
    }

    private static int diameterHelper(TreeNode root, int[] diameter) {
        if (root == null) return 0;

        int lh = diameterHelper(root.left, diameter);
        int rh = diameterHelper(root.right, diameter);

        diameter[0] = Math.max(diameter[0], lh + rh + 1);

        return Math.max(lh, rh) + 1;
    }
}
