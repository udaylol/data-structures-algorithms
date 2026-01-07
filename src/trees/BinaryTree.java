package trees;

import java.util.*;

class BinaryTree {

    // CREATE THE TREE
    static Node build(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) return null;

        int i = 0;
        Node root = new Node(values[i]);
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.remove();
            i++;
            if (i < values.length && values[i] != null) {
                curr.left = new Node(values[i]);
                q.add(curr.left);
            }
            i++;
            if (i < values.length && values[i] != null) {
                curr.right = new Node(values[i]);
                q.add(curr.right);
            }
        }

        return root;
    }
}
