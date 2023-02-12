package LinkedAlgorithm;

public class LinkedListRemove extends Node {
    //removeFirst And print removeNode
    Node removeFirst() {
        Node node = head;
        if(head == null) return null;
        head = head.next;
        nodeSize(head);
        return node;
    }

    //remove Node And print removeNode
    Node removeNode(int index){
        Node temp = head;
        Node returnNode = head;
        if(index>=nodeSize || index<0) {
            return null;
        }
        if(index == 0){
            return removeFirst();
        }
        for(int i=0; i<index-1; i++){
            temp = temp.next;
            returnNode = returnNode.next;
        }
        returnNode = returnNode.next;
        temp.next = temp.next.next;
        nodeSize(head);
        return returnNode;
    }

    //removeLast And Print removeNode
    Node removeLast(){
        Node temp = head;
        int count = 0;
        if (temp == null) return null;
        nodeSize(head);
        return removeNode(nodeSize-1);
    }
}