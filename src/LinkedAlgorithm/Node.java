package LinkedAlgorithm;

public class Node<T> {
    static Node head;
    static int nodeSize;
    protected T data;
    protected Node next;
    protected Node(){}
    protected Node(T data){
        this.data = data;
        this.next = null;
    }
    public String toString(){
        return String.valueOf(this.data);
    }

    /**
     * Linked List Size 측정
     */
    protected int nodeSize(Node head){
        nodeSize = 0;
        Node temp = head;
        while (temp!=null){
            temp = temp.next;
            nodeSize++;
        }
        return nodeSize;
    }

    /**
     * Linked List 검색
     */
    protected static void retrieve(){
        String printNode = "";
        Node retrieveNode = head;
        if(retrieveNode == null){
            System.out.println("[]");
        } else{
            while(retrieveNode.next!=null){
                printNode += retrieveNode.data + " -> ";
                retrieveNode = retrieveNode.next;
            }
            printNode += retrieveNode.data;
            System.out.println("[" + printNode + "]");
        }
    }
}
