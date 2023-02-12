package LifeCoding_Class.Collection_FrameWork;

public class LinkedList_Review2 {
    Node head;
    Node tail;
    static public class Node{
        int data;
        Node next;
        Node(int data){
            this.data =data;
        }
        public String toString(){
            return String.valueOf(this.data);
        }
    }

    //addFirst
    void addFirst(int data){
        Node n = new Node(data);
        n.next = head;
        head = n;
    }
    //addLast
    void addLast(int data){
        Node n = new Node(data);
        if(tail==null){
            tail = n;
            head = tail;
        } else {
            tail.next = n;
            tail = n;
        }
    }
    Node node (int index){
        Node x = head;
        for(int i=0; i<index; i++){
            x = x.next;
        }
        return x;
    }
    public void add(int k, int input){
        if(k == 0){
            addFirst(input);
        } else {
           Node temp1 = node(k-1);
           Node temp2 = temp1.next;
           Node newNode = new Node(input);
           temp1.next = newNode;
           newNode.next = temp2;
           if(newNode.next==null){
               tail = newNode;
           }
        }
    }
    public String toString(){
        if(head == null){
            return "[]";
        }
        Node temp = head;
        String str = "";
        while (temp.next != null){
            str += temp.data + " -> ";
            temp = temp.next;
        }
        str += temp.data;
        return str;
    }
    public Object removeFirst(){
        Node temp = head;
        head = head.next;
        Object returnData = temp.data;
        temp = null;
        return returnData;
    }

    public Object remove(int k) {
        if(k == 0) {
            return removeFirst();
        }
        Node temp = node(k-1);
        Node deleteNode = temp.next;
        int returnData = deleteNode.data;
        temp.next = temp.next.next;
        if(deleteNode.equals(tail)){
            tail = temp;
        }

        return returnData;
    }

    public static void main(String[] args) {
        LinkedList_Review2 ll = new LinkedList_Review2();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.add(2,5);
        System.out.println(ll.removeFirst());
        System.out.println(ll);
    }
}
