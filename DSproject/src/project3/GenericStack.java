package project3;

import java.util.ArrayList;

public class GenericStack<E> implements GenericStackInterface{

    private ArrayList<E> list = new ArrayList<>();
    private int top;

    public GenericStack() {
        top = -1;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    @Override
    public void push(Object o) {
        list.add((E) o);
        top++;
    }

    @Override
    public E pop() throws StackException{
        if(!this.isEmpty()){
            top--;
            return list.remove(top + 1);
        }else{
            throw new StackException("the stack is empty");
        }
    }

    @Override
    public void popAll() {
        list.clear();
    }

    @Override
    public E peek() throws StackException{
        if(!this.isEmpty()){
            return list.get(top);
        }else{
            throw new StackException("the stack is empty");
        }
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public String toString() {
        return "GenericStack{" +
                "list=" + list +
                '}';
    }
}
