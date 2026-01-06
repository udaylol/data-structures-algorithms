package trees;

public class Main {
    public static void main(String[] args) {
        Integer[] vals = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.build(vals);
        binaryTree.printTree();
        System.out.println(binaryTree.verticalorderDFS());
        System.out.println(binaryTree.verticalorderBFS());
    }
}
