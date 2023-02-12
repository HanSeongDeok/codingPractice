package LinkedAlgorithm;

public class LinkedListAdd extends Node{
    //static Node head;

    // addFirst
    <E> void addFirst(E data){
        Node node = new Node(data);
        node.next = head;
        head = node;
        nodeSize(head);
    }

    // addLast
    <E> void addLast(E data){
        Node newNode = new Node(data);
        Node temp = head;
        if(temp == null){
            head = newNode;
        } else{
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        nodeSize(head);
    }

    <E> void addNode(E data, int index){
        Node newNode = new Node(data);
        Node temp = head;
        Node temp2 = head;
        if(index == 0){
            newNode.next = temp;
            head = newNode;
        } else{
            for(int i=0; i<index-1; i++){
                temp = temp.next;
                temp2 = temp2.next;
            }
            temp2 = temp2.next;
            temp.next = newNode;
            newNode.next = temp2;
        }
        nodeSize(head);
    }


    public static void main(String[] args) {
        LinkedListAdd testAdd = new LinkedListAdd();
        LinkedListRemove testRemove = new LinkedListRemove();
        //test.addFirst(1);
        //test.addFirst(2);
        //test.addFirst(3);
        testAdd.addLast(1);
        testAdd.addFirst(6);
        testAdd.addFirst(7);
        testAdd.addNode(100, 2);
        retrieve();
      /*  System.out.println(testRemove.removeFirst());
        System.out.println("size : " + nodeSize);
        retrieve();
        System.out.println(testRemove.removeNode(1));
        System.out.println("size : " + nodeSize);
        retrieve();
        System.out.println(testRemove.removeLast());
        System.out.println("size : " + nodeSize);
        retrieve();*/
        LinkedIndexOf takeValue = new LinkedIndexOf();
        System.out.println(takeValue.getValue(3));
        System.out.println(takeValue.getIndex(7));

        LinkedListIterator iterator = new LinkedListIterator();
        System.out.println("-----------");
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        /*while(iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
        LinkedListIterator iterator2 = new LinkedListIterator();
        while(iterator2.hasNext()){
            if(100 == (int)iterator2.next()){
                iterator2.removeNode();
            }
        }
        retrieve();
    }
}