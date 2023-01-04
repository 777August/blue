package project2;

public class Node<E> {
    private E item;
    private Node<E> next;
    private Node<E> previous;

    public Node() {
    }

    public Node(E item, Node<E> previous, Node<E> next) {
        this.item = item;
        this.next = next;
        this.previous = previous;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }


}
