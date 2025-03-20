package BinaryTree;

public class Main {
    public static void main(String[] args) {
//        TreeImplement tree = new TreeImplement();
//        tree.insert();
//        tree.littleBeautyDisplay();

//    *   binary tree
        BinaryTreeImplementation tree = new BinaryTreeImplementation();
        tree.insert(3);
        tree.insert(9);
        tree.insert(20);
        tree.insert(15);
        tree.insert(7);
//        tree.insert(40);
//     ?   insert through array
//        tree.insertSorted(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

//     ?  just another way to insert
//        tree.root = new Node(1);
//        tree.root.left = new Node(12);
//        tree.root.right = new Node(9);
//        tree.root.left.left = new Node(5);
//        tree.root.left.right = new Node(6);
//
        System.out.print("pre order transversal : ");
        tree.preOrderTransversal(tree.root);

        System.out.print("\nIn order transversal : ");
        tree.inOrderTransversal(tree.root);

        System.out.print("\nPost order transversal : ");
        tree.postOrderTransversal(tree.root);

        System.out.print("\nLevel order transversal : ");
        tree.levelOrderTransversal(tree.root);

//        tree.display();
    }
}
