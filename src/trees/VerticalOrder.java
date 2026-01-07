package trees;

import java.util.ArrayList;
import java.util.List;

public class VerticalOrder {

    static class Info {
        int row, col, data;

        Info(int r, int c, int d) {
            row = r;
            col = c;
            data = d;
        }
    }

    static List<List<Integer>> verticalOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Info> nodes = new ArrayList<>();
        dfs(root, 0, 0, nodes);

        nodes.sort((a, b) -> {
            if (a.col != b.col) return Integer.compare(a.col, b.col);
            if (a.row != b.row) return Integer.compare(a.row, b.row);
            return Integer.compare(a.data, b.data);
        });

        int prevCol = Integer.MAX_VALUE;

        for (Info node : nodes) {
            int col = node.col;
            int data = node.data;

            if (col != prevCol) {
                prevCol = col;
                ans.add(new ArrayList<>());
            }
            ans.getLast().add(data);
        }
        return ans;
    }

    static void dfs(Node root, int r, int c, List<Info> nodes) {
        if (root == null) return;
        nodes.add(new Info(r, c, root.data));
        dfs(root.left, r + 1, c - 1, nodes);
        dfs(root.right, r + 1, c + 1, nodes);
    }

    public static void main(String[] args) {
        Integer[] vals = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node root = BinaryTree.build(vals);

        System.out.println(verticalOrder(root));
    }

}
