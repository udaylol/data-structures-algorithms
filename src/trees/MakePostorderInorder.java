package trees;

import java.util.HashMap;
import java.util.Map;

public class MakePostorderInorder {

    static Map<Integer, Integer> map;
    static int idx;

    static Node build(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        idx = inorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(postorder, 0, inorder.length - 1);
    }

    static Node build(int[] postorder, int l, int r) {
        if (l > r) return null;
        int val = postorder[idx--];
        Node root = new Node(val);
        int inorderIdx = map.get(val);

        root.right = build(postorder, inorderIdx + 1, r);
        root.left = build(postorder, l, inorderIdx - 1);

        return root;
    }

    static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{4, 2, 5, 1, 6, 3};
        int[] postorder = new int[]{4, 5, 2, 6, 3, 1};
        // preorder = 1 2 4 5 3 6

        Node root = build(inorder, postorder);
        preorder(root);
    }
}
