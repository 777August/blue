package project1;

import java.util.Random;

public class ADTBag implements operations{
    private int index = 0;
    private Object[] bag;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Object[] getBag() {
        return bag;
    }

    public void setBag(Object[] bag) {
        this.bag = bag;
    }

    // create a ADTBag that can hold up to 100 items
    public ADTBag(){
        bag = new Object[100];
    }

    @Override
    public void insert(Object item) {
        bag[index] = item;
        index++;
    }

    @Override
    public void removeLast() {
        bag[index - 1] = null;
        index--;
    }

    @Override
    public void removeRandom() {
        Random r = new Random();
        int num = r.nextInt(index);
        bag[num] = null;
        for(int i = num;i < index;i++){
            bag[i] = bag[i+1];
        }
        bag[index-1] = null;
        index--;
    }

    @Override
    public int get(Object item) throws itemNotFoundException {
        for(int i = 0;i < index + 1;i++){
            if(bag[i].equals(item)){
                return i;
            }else{
                throw new itemNotFoundException(item.toString());
            }
        }
        return -1;

    }

    @Override
    public Object get(int index) throws indexOutOfBoundException {
        if(index<0 ||index > this.index){
            throw new indexOutOfBoundException(index);
        }else{
            return bag[index];
        }
    }

    @Override
    public int size() {
        return index + 1;
    }

    @Override
    public boolean isEmpty() {
        if(index == 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void makeEmpty() {
        for(int i = 0;i < index + 1;i++){
            bag[i] = null;
        }
        index = 0;
    }
}
