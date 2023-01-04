package project4;

import java.util.Iterator;
import java.util.LinkedList;

public class TreeIterator<E extends Comparable<E>> implements Iterator<E> {
    private BinarySearchTree<E> tree;

    private LinkedList<MyTreeNode<E>> list;

    public TreeIterator(BinarySearchTree<E> tree) {
        this.tree = tree;
        // empty queue indicates no traversal type currently
        // selected or end of current traversal has been reached
        this.list = new LinkedList<MyTreeNode<E>>();
    }

    public LinkedList<MyTreeNode<E>> getList() {
        return list;
    }

    public void setList(LinkedList<MyTreeNode<E>> list) {
        this.list = list;
    }

    public boolean hasNext() {
        return !this.list.isEmpty();
    }

    public E next() throws java.util.NoSuchElementException {
        return this.list.remove().getElement();
    }

    public void remove() throws UnsupportedOperationException{
        // Optional means we can implement it or throw an UnsupportedOperationException. This operation is optional because
        // sometimes we just don't want the iterator's content to be modified. An iterator is normally used for executing.
        //The default implementation throws an instance of UnsupportedOperationException and performs no other action.
        throw new UnsupportedOperationException();
    }

    public void setPreorder() {
        this.list.clear();
        this.preorder(this.tree.getRoot());
    }

    public void setInorder() {
        this.list.clear();
        this.inorder(this.tree.getRoot());
    }

    public void setPostorder() {
        this.list.clear();
        this.postorder(this.tree.getRoot());
    }

    private void preorder(MyTreeNode<E> myTreeNode) {
        if(myTreeNode != null){
            this.list.add(myTreeNode);
            preorder(myTreeNode.getLeft());
            preorder(myTreeNode.getRight());

        }
    }

    private void inorder(MyTreeNode<E> myTreeNode) {
        if(myTreeNode != null){
            inorder(myTreeNode.getLeft());
            this.list.add(myTreeNode);
            inorder(myTreeNode.getRight());

        }
    }

    private void postorder(MyTreeNode<E> myTreeNode) {
        if(myTreeNode != null){
            postorder(myTreeNode.getLeft());
            postorder(myTreeNode.getRight());
            this.list.add(myTreeNode);

        }
    }
}
