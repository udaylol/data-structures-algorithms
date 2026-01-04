package trees;

public class Main {
    public static void main(String[] args) {
        Integer[] vals = {1, 2, 3, 4, null, null, 5, null, 6, null, null, 7, 7};

        BinaryTree tree1 = new BinaryTree();
        tree1.build(vals);
        tree1.printTree();

        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.build(vals);
        tree2.printTree();
    }
}
