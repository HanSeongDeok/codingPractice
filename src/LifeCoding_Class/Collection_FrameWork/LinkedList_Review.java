package LifeCoding_Class.Collection_FrameWork;

public class LinkedList_Review {
    private Node head;
    private Node tail;
    private int size;
    private class Node{
        int data;
        Node next;
        private Node(int data){
            this.data = data;
        }
        public String toString(){
            return String.valueOf(this.data);
        }
    }

    private void addFirst(int data){
        Node n = new Node(data);
        n.next = head;
        head =  n;
        if(head.next == null){
            tail = head;
        }
        size++;
    }

    private void addLast(int data){
        Node n = new Node(data);
        if(size == 0) {
            //addFirst(data);
            n.next = tail;
            tail = n;
            head = tail;
            size++;
        } else {
            tail.next = n;
            tail = n;
            size++;
        }
    }
    private Node node(int index){
        Node x = head;
        for(int i=0; i < index; i++){
            x = x.next;
        }
        return x;
    }

    public static void main(String[] args) {
        LinkedList_Review ll = new LinkedList_Review();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        System.out.println(ll.node(1));
    }
}
