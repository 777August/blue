package project4;

public class test {
    public static void main(String[] args) {
        MyTreeNode<Integer> a  = new MyTreeNode<>(1,null,null);
        MyTreeNode<Integer> b  = new MyTreeNode<>(2,null,null);
        MyTreeNode<Integer> c  = new MyTreeNode<>(3,b,a);
        MyTreeNode<Integer> d  = new MyTreeNode<>(4,null,null);
        MyTreeNode<Integer> e  = new MyTreeNode<>(5,null,null);
        MyTreeNode<Integer> f  = new MyTreeNode<>(6,null,null);
        MyTreeNode<Integer> g = a;
        g.setElement(9);
        System.out.println();
        System.out.println(a.getLeft()==null);
        int s = 2;
        add(s);
        System.out.println(s);
    }
    public static void add(int a){
        a+=2;
    }

}
