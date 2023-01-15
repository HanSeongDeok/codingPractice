package LifeCoding_Class.Collection_FrameWork;

public class LinkedList_Review2 {
    Node head;
    Node tail;
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data =data;
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
    public static void main(String[] args) {
        LinkedList_Review2 ll = new LinkedList_Review2();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
    }
}
