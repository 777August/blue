package week2;

public class DoubleLinkedList<E> {

    //头节点，尾节点，大小
    //没太理解头尾节点的作用，但还是写上了
    private Node head;
    private Node end;
    private int size;

    //初始化链表
    public DoubleLinkedList() {
        head = null;
        end = null;
        size = 0;
    }

    //链表的节点类
    public  class Node{
        private E data;
        private Node pre;
        private Node next;

        public Node() {
        }

        public Node(E data, Node pre, Node next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }


    //根据index找到对应的节点
    public Node find(int index){
        //判断角标是否合理
        if(index > size-1 || index < 0){
            throw new RuntimeException("不存在对应的角标" + index);
        }
        Node node = head;
        for(int i = 0;i < index;i++){
            node = node.next;
        }

        return node;
    }

    //顺序插入
    public  void add(E data){
        Node newNode = new Node(data,null,null);
        if(size == 0){
            head = newNode;
            end = newNode;
            size++;
        }else{
            end.next = newNode;
            newNode.pre = end;
            end = newNode;
            size++;
        }
    }

    //按照角标插入
    public void add(int index,E data){
        if(index < 0 || index > size - 1){
            throw  new RuntimeException("不存在对应的角标" + index);
        }

        Node nextNode = find(index);
        if(index == 0){
            Node newNode = new Node ( data,null, nextNode);
            newNode.pre = newNode;
            head = newNode;
        }else{
            Node prevNode = nextNode.pre;
            Node newNode = new Node ( data,prevNode, nextNode);
            nextNode.pre = newNode;
            prevNode.next = newNode;
        }

        size++;
    }

    //按角标删除
    public void delete(int index){
        if(index < 0 || index > size - 1){
            throw  new RuntimeException("不存在对应的角标" + index);
        }
        Node deleteNode = find(index);
        if(index == 0){
            Node nextNode = deleteNode.next;
            nextNode.pre = null;
            head = nextNode;
        }else if(index == size - 1){
            Node preNode = deleteNode.pre;
            preNode.next = null;
            end = preNode;
        }else{
            Node preNode = deleteNode.pre;
            Node nextNode = deleteNode.next;
            preNode.next = nextNode;
            nextNode.pre = preNode;
        }

        size--;

    }


    //翻转链表
    public DoubleLinkedList reverse(){
        if(size == 0 || size == 1){
            return this;
        }else{
            //值交换
            for(int i = 0;i < size/2;i++){
                Node begin = find(i);
                Node end = find(size-1 - i);
                E temp = begin.data;
                begin.data = end.data;
                end.data = temp;
            }
        }


        return this;
    }
    @Override
    public String toString() {
        String s = "[";
        for(int i = 0;i < size;i++){
            Node now = find(i);
            s += now.data.toString();
            if(i < size -1){
                s += ",";
            }
        }
        s += "]";
        return s;
    }

    //测试类
    public static void main(String[] args) {
        DoubleLinkedList<Integer> h = new DoubleLinkedList<>();
        h.add(1);
        h.add(2);
        h.add(3);
        h.add(4);
        System.out.println(h);//[1,2,3,4]
        h.add(2,5);
        System.out.println(h);//[1,2,5,3,4]
        h.delete(3);
        System.out.println(h);//[1,2,5,4]
        System.out.println(h.find(1));//2
        h.reverse();
        System.out.println(h);//[4,5,2,1]
    }
}

