package LinkedAlgorithm;

public class LinkedListIterator<T> extends Node{
    Node node;
    Node lastReturned;
    int nextIndex;
    LinkedListIterator(){
        this.node = head;
    }
    T next(){
        this.lastReturned = node;
        this.node = node.next;
        this.nextIndex++;
        return (T) this.lastReturned.data;
    }
}
