package trees;

import java.util.*;

public class BinarySearchTree extends BinaryTree {
    @Override
    void build(Integer[] values) {
        if (values == null) {
            root = null;
            return;
        }

        int[] arr = Arrays.stream(values)
                .filter(x -> x != null)
                .distinct()
                .mapToInt(x -> x)
                .toArray();

        if (arr.length == 0) {
            root = null;
            return;
        }

        Arrays.sort(arr);
        root = build(arr, 0, arr.length - 1);
    }

    private TreeNode build(int[] arr, int l, int r) {
        if (l > r) return null;

        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(arr[mid]);

        node.left = build(arr, l, mid - 1);
        node.right = build(arr, mid + 1, r);

        return node;
    }


}
