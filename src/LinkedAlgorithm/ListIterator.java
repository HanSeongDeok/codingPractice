package LinkedAlgorithm;

public class ListIterator extends Node{
    private Node next;
    private Node lastReturn;
    private int nextIndex;
    ListIterator(){
        next = head;
    }
    Object next(){
        lastReturn = next;
        next = next.next;
        nextIndex++;
        return lastReturn.data;
    }
}
