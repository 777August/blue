package project3;

public interface GenericStackInterface<E>  {
    public abstract void push(E e);
    public abstract E pop() throws StackException;
    public abstract void popAll();
    public abstract E peek() throws StackException;
    public abstract boolean isEmpty();
    public abstract int size();

}
