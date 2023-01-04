package project4;

public class MyTreeNode<E> {
    private E element;
    private MyTreeNode<E> left;
    private MyTreeNode<E> right;
    private MyTreeNode<E> parent;
    private boolean sub;
    private int key;

    public MyTreeNode() {
    }

    public MyTreeNode(E element, MyTreeNode<E> left, MyTreeNode<E> right) {
        this.element = element;
        this.left = left;
        this.right = right;
        if(element.getClass().equals(classSection.class)){
            this.setKey(((classSection) element).getClassNumber());
        }
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public MyTreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(MyTreeNode<E> left) {
        this.left = left;
    }

    public MyTreeNode<E> getRight() {
        return right;
    }

    public void setRight(MyTreeNode<E> right) {
        this.right = right;
    }

    public MyTreeNode<E> getParent() { return parent; }

    public void setParent(MyTreeNode<E> parent) { this.parent = parent; }

    public boolean getSub() { return sub; }

    public void setSub(boolean sub) { this.sub = sub; }

    public int getKey() { return key; }

    public void setKey(int key) { this.key = key; }
}
