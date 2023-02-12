package LinkedAlgorithm;

public class LinkedListIterator<T> extends Node{
    Node node2;
    Node lastReturned;
    int nextIndex;
    LinkedListIterator(){
        this.node2 = head;
    }
    T next(){
        this.lastReturned = node2;
        this.node2 = node2.next;
        this.nextIndex++;
        return (T) this.lastReturned.data;
    }
    boolean hasNext(){
        return nextIndex < nodeSize;
    }
    void addNode(T data){
        Node newNode = new Node(data);
        if(lastReturned == null){
            lastReturned = newNode;
            lastReturned.next = node2;
        } else {
            lastReturned.next = newNode;
            newNode.next = node2;
        }
        lastReturned = lastReturned.next;
        nextIndex++;
        nodeSize++;
    }

    void removeNode(){
        if(nextIndex==0){
            throw new IllegalStateException();
        }
        Node temp = new LinkedListRemove();
        ((LinkedListRemove)temp).removeNode(nextIndex-1);
        nextIndex--;
    }
}
