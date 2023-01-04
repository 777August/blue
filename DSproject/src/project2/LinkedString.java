package project2;
public class LinkedString implements LinkedStringInterface{
    private Node<Character> head;
    private int count;

    public LinkedString() {
        head = null;
        count = 0;
    }
    public LinkedString(char[] chars) {
        // let the first character become the head of the linkedString
        Node<Character> first = new Node<>(chars[0],null,null);
        head = first;
        count++;
        Node<Character> temp = null;
        for(int i = 1;i < chars.length;i++){
            Node<Character> node;

            if(i == 1){
                node = new Node<Character>(chars[i], first, null);
                head.setNext(node);
            }else {
            //add the following character into the linkedString
                node = new Node<Character>(chars[i], temp, null);
                temp.setNext(node);
            }
            temp = node;
            count++;
        }
    }

    //reuse the second constructor
    public LinkedString(String strings) {
        this(strings.toCharArray());
    }

    public Node<Character> getHead() {
        return head;
    }

    public void setHead(Node<Character> head) {
        this.head = head;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    //find the item through index
    @Override
    public char charAt(int i) {
        if(i < 0 || i > count - 1){
            throw new RuntimeException("index out of bound");
        }
        Node node = find(i);

        return (char)node.getItem();
    }

    //concat two linkedString
    @Override
    public LinkedString concat(LinkedString l) {
        LinkedString newls = new LinkedString();

        //copy the first linkedString
        Node newnode = new Node(this.charAt(0),null,null);
        newls.setHead(newnode);
        newls.count++;
        Node<Character> temp2 = null;
        for(int i = 1;i < this.count;i++){
            Node<Character> node;
            if(i == 1){
                node = new Node<Character>(this.charAt(i), newnode, null);
                newls.head.setNext(node);
            }else {
                node = new Node<Character>(this.charAt(i), temp2, null);
                temp2.setNext(node);
            }
            temp2 = node;
            newls.count++;
        }
        //copy the second linkedString after the first one
        for(int j = 0;j < l.count;j++){
            Node<Character> node;
            node = new Node<Character>(l.charAt(j), temp2, null);
            temp2.setNext(node);
            temp2 = node;
            newls.count++;
        }
        return newls;
    }

    //judge the linkedString if is empty
    @Override
    public boolean isEmpty() {
        if(count == 0){
            return true;
        }else{
            return false;
        }
    }

    //return the length of this linked string
    @Override
    public int length() {
        return count;
    }

    //return a new linked string that is a substring of this linked string
    @Override
    public LinkedString substring(int a, int b) {
        int length = b - a + 1;
        Node newHead = new Node(this.charAt(a),null,null);
        LinkedString after = new LinkedString();
        after.setHead(newHead);
        after.count++;
        Node<Character> temp = null;
        for(int i = a;i < b;i++){
            Node<Character> node;
            if(i == a){
                node = new Node<Character>(this.charAt(i+1), after.head, null);
                after.head.setNext(node);
            }else {
                node = new Node<Character>(this.charAt(i+1), temp, null);
                temp.setNext(node);
            }
            temp = node;
            after.count++;
        }
        return after;
    }

    public Node find(int j){
        Node node = head;
        for(int i = 0;i < j;i++){
            node = node.getNext();
        }
        return node;
    }
    public void print(){
        for(int i = 0;i < count;i++){
            System.out.print(this.charAt(i));
        }
    }


}
