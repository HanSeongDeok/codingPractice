package EngineerKorea_Class;

public class LinkedList_Class {
    Node end;
    private static class Node<T>{
        T data;
        Node next;
        public Node(T data){
            this.data = data;
        }
    }
    public <T> void addNode(T data){
        Node add = new Node(data);
        add.next = end;
        end = add;
    }

    public static void main(String[] args) {
        LinkedList_Class linky = new LinkedList_Class();
        linky.addNode(1);
        linky.addNode(2);
        linky.addNode(3);
    }
}
