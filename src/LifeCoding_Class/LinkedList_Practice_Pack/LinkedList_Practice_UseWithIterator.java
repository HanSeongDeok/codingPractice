package LifeCoding_Class.LinkedList_Practice_Pack;


class LinkedList_Practice_UseWithIterator {
    private LinkedList_Practice_Review.Node next;
    private LinkedList_Practice_Review.Node lastReturned;
    private LinkedList_Practice_Review.Node head;
    private int nextIndex;
    LinkedList_Practice_UseWithIterator(LinkedList_Practice_Review.Node head){
        this.next = head;
        this.head = head;
    }
    // find next
    Object next(){
        lastReturned = next;
        next = next.next;
        nextIndex++;
        return lastReturned.data;
    }

    // hasNext
    boolean hasNext() {
        return nextIndex < LinkedList_Practice_Review.size;
    }

    //add
    <E> void add(E data){
        LinkedList_Practice_Review.Node newNode = new LinkedList_Practice_Review().new Node(data);
        if(lastReturned == null){
            LinkedList_Practice_Review.head = newNode;
            newNode.next = this.next;
        } else{
            lastReturned.next = newNode;
            newNode.next = next;
            LinkedList_Practice_Review.head = head;
        }
        lastReturned = newNode;
        nextIndex++;
        LinkedList_Practice_Review.size++;
    }

    //remove
    void remove(){
        if(nextIndex==0){
            throw new IllegalStateException();
        }
        LinkedList_Practice_Review remove = new LinkedList_Practice_Review();
        remove.remove(nextIndex-1);
        nextIndex--;
    }

    //toString Override
    public String toString(){
        return String.valueOf(lastReturned.data);
    }
}
