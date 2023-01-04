package project1;

public interface operations {
    public abstract void insert(Object item);
    public abstract void removeLast();
    public abstract void removeRandom();
    public abstract int get(Object item) throws itemNotFoundException;
    public abstract Object get(int index) throws indexOutOfBoundException;
    public abstract int size();
    public abstract boolean isEmpty();
    public abstract void makeEmpty();

}
