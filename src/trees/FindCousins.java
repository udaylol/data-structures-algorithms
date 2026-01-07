package trees;

import java.util.*;

public class FindCousins {
    static List<Integer> findCousins(Node root, int key) {
        List<Integer> ans = new ArrayList<>();
        if (root == null || root.data == key) return ans;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        boolean found = false;

        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.remove();
                if (curr.left != null) {
                    if (curr.left.data == key) {
                        found = true;
                    } else {
                        queue.add(curr.left);
                    }
                }
                if (curr.right != null) {
                    if (curr.right.data == key) {
                        found = true;
                    } else {
                        queue.add(curr.right);
                    }
                }
            }
        }
        for (Node node : queue) {
            ans.add(node.data);
        }
        return ans;
    }

    public static void main(String[] args) {
        Integer[] vals = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node root = BinaryTree.build(vals);

        System.out.println(findCousins(root, 5));
    }
}
