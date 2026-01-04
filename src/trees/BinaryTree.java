package trees;

import java.util.*;

class BinaryTree {

    protected TreeNode root;

    // CREATE THE TREE
    void build(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) return;

        int i = 0;
        this.root = new TreeNode(values[i]);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(this.root);

        while (!q.isEmpty()) {
            TreeNode curr = q.remove();
            i++;
            if (i < values.length && values[i] != null) {
                curr.left = new TreeNode(values[i]);
                q.add(curr.left);
            }
            i++;
            if (i < values.length && values[i] != null) {
                curr.right = new TreeNode(values[i]);
                q.add(curr.right);
            }
        }
    }

    // PRINT THE TREE
    void printTree() {
        System.out.println();
        printTree(root, 0);
        System.out.println();
    }

    // TRAVERSALS
    List<Integer> preorder() {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    List<Integer> inorder() {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    List<Integer> postorder() {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    List<List<Integer>> levelorder() {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                row.add(curr.data);

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            ans.add(row);
        }
        return ans;
    }

    // HELPERS
    protected void preorder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        ans.add(root.data);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }

    protected void inorder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        inorder(root.left, ans);
        ans.add(root.data);
        inorder(root.right, ans);
    }

    protected void postorder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.data);
    }

    protected void printTree(TreeNode node, int depth) {
        if (node == null) return;
        printTree(node.right, depth + 1);
        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }
        System.out.println(node.data);
        printTree(node.left, depth + 1);
    }

}
