package project4;

public class BinarySearchTree<E extends Comparable<E>> implements Specifications {

    private MyTreeNode<E> root;

    public BinarySearchTree() { root = null; }

    public BinarySearchTree(classSection item) {
        this.setRoot(new MyTreeNode<E>((E) item, null, null));
    }


    public BinarySearchTree(MyTreeNode<E> root) {
        this.root = root;
    }

    public MyTreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(MyTreeNode<E> root) {
        this.root = root;
    }

    @Override
    public classSection getRootItem() {
        return (classSection) root.getElement();
    }

    @Override
    public boolean isEmpty() {
        return root==null;
    }

    @Override
    public void makeEmpty() {
        root = null;
    }

    @Override
    public MyTreeNode search(MyTreeNode node, int key)throws TreeExceptions {
        if(node == null){
            throw new TreeExceptions("the class doesn't exist");
        }else if(node.getKey() == key){
            return node;
        }else if(node.getKey() > key){
            return search(node.getLeft(),key);
        }else{
            return search(node.getRight(),key);
        }

    }



    //aClass比node大，放在右子树，比node小，放左子树
    //同时记录aClass 是node的左子树还是右子树，并将node设为aClass的parent
    //以上两步的目的在于方便后续的删除操作
    @Override
    public void insert(MyTreeNode node, MyTreeNode aClass) throws TreeExceptions {
        if(root == null){
            root = aClass;
        }else if(node == null){
            if(node.getSub()){
                node.getParent().setLeft(aClass);
            }else{
                node.getParent().setRight(aClass);
            }
        }else if(node.getKey() == aClass.getKey()){
            throw new TreeExceptions("the class is already exist");
        }else if(node.getKey() > aClass.getKey()){
            aClass.setParent(node);
            //左子树  true
            aClass.setSub(true);
            if(node.getLeft()==null){
                node.setLeft(aClass);
            }else{
            insert(node.getLeft(),aClass);
            }
        }else if(node.getKey() < aClass.getKey()){
            aClass.setParent(node);
            aClass.setSub(false);
            if(node.getRight()==null){
                node.setRight(aClass);
            }else{
               // node.getLeft().setParent(node);
                insert(node.getRight(),aClass);
            }
        }
    }

    @Override
    public void delete(int key) throws TreeExceptions {
        MyTreeNode<E> temp = search(root,key);
        //没有左右子树
        if(temp.getLeft()==null&&temp.getRight()==null) {
            if(temp.getSub()){
                temp.getParent().setLeft(null);
            }else{
                temp.getParent().setRight(null);
            }
            //有右子树无左子树
        }else if(temp.getLeft()==null){
            if(temp.getSub()){
                temp.getParent().setLeft(temp.getRight());
            }else{
                temp.getParent().setRight(temp.getRight());
            }
            //有左子树无右子树
        }else if(temp.getRight()==null){
            if(temp.getSub()){
                temp.getParent().setLeft(temp.getLeft());
            }else{
                temp.getParent().setRight(temp.getLeft());
            }
        }else{
            //要删除的节点有两个子节点
            temp = temp.getLeft();
            //找到左子树中最右侧的节点用于替代被删除的节点
            while(temp.getRight()!=null&&temp.getLeft()!=null){
                if(temp.getRight()==null){
                    temp = temp.getLeft();
                }else{
                    temp = temp.getRight();
                }
            }
            root.setElement(temp.getElement());
            if(temp.getSub()){
                temp.getParent().setLeft(null);
            }else{
                temp.getParent().setRight(null);
            }
        }
    }

    @Override
    public TreeIterator getTreeIterator() {
        return new TreeIterator(this);
    }
}




