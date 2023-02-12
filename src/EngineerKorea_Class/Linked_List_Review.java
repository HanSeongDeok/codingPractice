package EngineerKorea_Class;

/**
 * 클래스 안으로 들어가는 LinkedList Class 즉, 내부 클래스를 이용함
 */
public class Linked_List_Review {
    Node header;
    int size;
    static class Node<T>{
        T data;
        Node next;
    }
    // addFirstNode
    <T> void addFirstNode(T data){
        Node n = new Node();
        n.data = data;
        n.next = header;
        header = n;
    }
    // addLastNode
    <T> void addLastNode(T data){
        boolean checkSwitch = false;
        Node n = new Node();
        n.data = data;
        if(header.data==null){
            checkSwitch = true;
            header = n;
        }
        Node n2 = header;
        while (n2.next!=null){
            n2 = n2.next;
        }
        if (!checkSwitch) n2.next = n;
    }
    // deleteNode
    <T> void deleteNode(T data){
        Node n = header;
        while(n.next!=null){
            if(n.next.data==data){
                n.next = n.next.next;
            }else {
                n = n.next;
            }
        }
    }
    // retrieveNode
    void retrieveNode(){
        Node n = header;
        while (n.next!=null) {
            System.out.print(n.data+" -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }
    Linked_List_Review(){header = new Node();}
    public static void main(String[] args) {
        Linked_List_Review ll = new Linked_List_Review();
        ll.addLastNode(1);
        ll.addLastNode(2);
        ll.addLastNode(3);
        ll.addLastNode(4);
        ll.retrieveNode();
        ll.deleteNode(2);
        ll.retrieveNode();
    }
}
