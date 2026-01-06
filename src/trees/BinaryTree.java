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

    static class InfoDFS {
        int row, col, val;

        InfoDFS(int r, int c, int v) {
            row = r;
            col = c;
            val = v;
        }
    }

    List<List<Integer>> verticalorderDFS() {
        List<List<Integer>> ans = new ArrayList<>();
        List<InfoDFS> nodes = new ArrayList<>();
        verticalHelperDFS(root, 0, 0, nodes);

        nodes.sort((a, b) -> {
            if (a.col != b.col) return Integer.compare(a.col, b.col);
            if (a.row != b.row) return Integer.compare(a.row, b.row);
            return Integer.compare(a.val, b.val);
        });

        int prevCol = Integer.MIN_VALUE;
        for (InfoDFS node : nodes) {
            int col = node.col;
            int val = node.val;
            if (col != prevCol) {
                ans.add(new ArrayList<>());
                prevCol = col;
            }
            ans.getLast().add(val);
        }
        return ans;
    }

    private void verticalHelperDFS(TreeNode root, int r, int c, List<InfoDFS> nodes) {
        if (root == null) return;

        nodes.add(new InfoDFS(r, c, root.data));
        verticalHelperDFS(root.left, r + 1, c - 1, nodes);
        verticalHelperDFS(root.right, r + 1, c + 1, nodes);
    }

    static class InfoBFS {
        TreeNode node;
        int col;

        InfoBFS(TreeNode n, int c) {
            node = n;
            col = c;
        }
    }

    List<List<Integer>> verticalorderBFS() {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<InfoBFS> queue = new ArrayDeque<>();
        queue.add(new InfoBFS(root, 0));

        Map<Integer, List<Integer>> map = new HashMap<>();
        int minCol = 0, maxCol = 0;

        while (!queue.isEmpty()) {
            InfoBFS curr = queue.remove();
            TreeNode node = curr.node;
            int col = curr.col;

            minCol = Math.min(col, minCol);
            maxCol = Math.max(col, maxCol);

            map.computeIfAbsent(col, k -> new ArrayList<>()).add(node.data);

            if (node.left != null) queue.add(new InfoBFS(node.left, col - 1));
            if (node.right != null) queue.add(new InfoBFS(node.right, col + 1));
        }
        for (int i = minCol; i <= maxCol; i++) {
            ans.add(map.get(i));
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
            System.out.print("   ");
        }
        System.out.println(node.data);
        printTree(node.left, depth + 1);
    }

}
