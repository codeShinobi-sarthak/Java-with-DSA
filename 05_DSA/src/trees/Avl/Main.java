package Avl;

public class Main {
    public static void main(String[] args) {

        AvlTree tree = new AvlTree();
        /* Constructing tree given in the above figure */
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */

        System.out.println("Preorder traversal : ");
        tree.preOrderTransversal(tree.root);
    }
}
