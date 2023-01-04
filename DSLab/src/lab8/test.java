package lab8;

public class test {
    public static void main(String[] args) {
        BinaryTree<Integer> tree, tree1, tree2, tree3, leftTree;
        TreeIterator<Integer> iterator, leftIterator;

        //Build the tree from leaves to root
        tree1 = new BinaryTree<Integer>();

        tree1.setRoot(40);
        tree1.attachLeft(30);
        tree1.attachRight(50);

        tree2 = new BinaryTree<Integer>();
        tree2.setRoot(20);
        tree2.attachLeft(10);
        tree2.attachRightSubtree(tree1);

        tree3 = new BinaryTree<Integer>(70);
        tree =  new BinaryTree<Integer>(60, tree2, tree3);

        iterator = new TreeIterator<Integer>(tree);

        //test hasNext
        System.out.println(iterator.hasNext());



        //test setPreorder
        iterator.setPreorder();
        System.out.println("Preorder traversal");
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");

        }
        System.out.println();

        //test setInorder
        iterator.setInorder();
        System.out.println("Inorder traversal");
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");

        }
        System.out.println();

        //test setPostorder
        iterator.setPostorder();
        System.out.println("Postorder traversal");
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");

        }
        System.out.println();

        //test remove
        iterator.remove();



    }
}
