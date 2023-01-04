package project4;

public interface Specifications<E extends Comparable<E>> {
    public abstract  classSection getRootItem();
    public abstract boolean isEmpty();
    public abstract void makeEmpty();
    public abstract MyTreeNode<E> search(MyTreeNode<E> node, int key) throws TreeExceptions;
    public abstract void insert(MyTreeNode<E> node, MyTreeNode<E> aClass) throws TreeExceptions;
    public abstract void delete(int key) throws TreeExceptions;
    public abstract TreeIterator<E> getTreeIterator();

}
