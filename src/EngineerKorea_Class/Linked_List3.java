package EngineerKorea_Class;

public class Linked_List3 {
    private Node head;
    private class Node{
         int data;
         Node next;
    }
    Linked_List3(){}
    public void addNode(int data){
        Node header = new Node();
        header.data = data;
        header.next = head;
        head = header;
    }
    public void addNode2(int data){
        Node header = new Node();
        header.data = data;
        Node n = head;
        if(n==null) n = header;

    }
    public static void main(String[] args) {
        Linked_List3 test = new Linked_List3();
        test.addNode2(1);
        test.addNode2(2);
        test.addNode2(3);
    }
}
