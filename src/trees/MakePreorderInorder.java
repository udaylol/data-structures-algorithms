package trees;

import java.util.*;

public class MakePreorderInorder {
    static Map<Integer, Integer> map;
    static int idx;

    static Node build(int[] inorder, int[] preorder) {
        map = new HashMap<>();
        idx = 0;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1);
    }

/*
   [] => null
 */
    static Node build(int[] preorder, int l, int r) {
        if (l > r) return null;

        int val = preorder[idx++];

        Node root = new Node(val);
        int inorderIdx = map.get(val);

        root.left = build(preorder, l, inorderIdx - 1);
        root.right = build(preorder, inorderIdx + 1, r);

        return root;
    }

    static void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);

        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{1, 2, 4, 5, 3, 6};
        int[] inorder = new int[]{4, 2, 5, 1, 6, 3};

        Node root = build(inorder, preorder);
        postorder(root);
    }
}
