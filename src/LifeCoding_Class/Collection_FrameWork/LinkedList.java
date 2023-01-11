package LifeCoding_Class.Collection_FrameWork;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;
    private class Node {
        private Object data;
        private Node next;
        public Node(Object input) {
            this.data = input;
            this.next = null;
        }
    /*    public String toString(){
            return String.valueOf(this.data);
        }*/
    }
    public void addFirst(Object input){
        Node newNode = new Node(input);
        newNode.next = head;
        head = newNode;
        size++;
        if (head.next == null){
            tail = head;
        }
    }

    public void addLast(Object input){
        Node newNode = new Node(input);
        if (size == 0) {
            newNode.next = tail;
            tail = newNode;
            head = tail;
        } else{
            head.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public static void main(String[] args) {
        LinkedList numbers = new LinkedList();
        numbers.addLast(30);
        numbers.addLast(20);
        numbers.addLast(10);
    }
}
