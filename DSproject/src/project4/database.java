package project4;

import java.util.LinkedList;

public class database {
    private BinarySearchTree<classSection> classSections;
    private int num;
    public database() {
        classSections = new BinarySearchTree<classSection>();
        num = 0;
    }


    public BinarySearchTree<classSection> getClassSections() {
        return classSections;
    }

    public void setClassSections(BinarySearchTree<classSection> classSections) {
        this.classSections = classSections;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public  void insert(MyTreeNode aClass) throws TreeExceptions {
        classSections.insert(classSections.getRoot(), aClass);
        num++;
    }

    public void delete(int key) throws TreeExceptions {
        classSections.delete(key);
        num--;
    }

    public classSection search(int key) throws TreeExceptions {
        return (classSection) classSections.search(classSections.getRoot(),key).getElement();
    }

    public boolean isEmpty(){
        return num==0;
    }

    public void makeEmpty(){
        classSections.setRoot(null);
        num=0;
    }

    public int total(){
        return num;
    }

    public LinkedList<MyTreeNode> sort(){
        TreeIterator ti = classSections.getTreeIterator();
        ti.setInorder();
        return ti.getList();
    }
}
