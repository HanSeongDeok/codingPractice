package LifeCoding_Class.LinkedList_Practice_Pack;


class LinkedList_Practice_Review{
    static Node head;
    Node tail;
    static int size;
    class Node<T> {
        T data;
        Node next;
        Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    //addFirst
    <E> void addFirstNode(E data){
        Node node = new Node(data);
        node.next = head;
        head = node;
        if(node.next==null) {tail = node;}
        size++;
    }
    //addLast
    <E> void addLastNode(E data){
        Node node = new Node(data);
        if(tail==null){
            addFirstNode(data); //addFirst
            tail = head;
        } else{
            tail.next = node;
            tail = node;
            size++;
        }
    }
    //Add Coincident Value To Corresponding Of Index
    <E> void add(int k , E data){
        if(k==0){
            addFirstNode(data);
        } else {
            Node node = node(k-1);
            Node newNode = new Node(data);
            Node temp = node.next;
            node.next = newNode;
            node.next.next = temp;
            size++;
            if(temp == null){
                tail = node.next;
            }
        }
    }
    //removeFirst
    Object removeFirstNode(){
        Node temp = head;
        head = head.next;
        Object returnValue = temp.data;
        size--;
        return returnValue;
    }

    //removeLast
    Object removeLast(){
        return remove(size-1);
    }

    //Remove Value To Corresponding of Index
     Object remove(int index){
        if(index == 0){
            return removeFirstNode();
        } else{
            Node node = node(index-1);
            Node returnDelete = node.next;
            node.next = node.next.next;
            if(node.next == null){
                tail = node;
            }
            size--;
            return returnDelete.data;
        }
    }

    //node(Return Corresponding Of Index)
    Node node(int index){
        Node x = head;
        for (int i =0; i<index;i++){
            x = x.next;
        }
        return x;
    }

    //toString
    public String toString(){
        Node headToStr = head;
        if(headToStr==null){
            return "[]";
        }
        StringBuilder printHead = new StringBuilder();
        while (headToStr.next!=null){
            printHead.append(headToStr.data+", ");
            headToStr = headToStr.next;
        }
        printHead.append(headToStr.data);
        return "["+printHead.toString()+"]";
    }

    //size
    int getSize(){
        return size;
    }

    // index of value
    <E> Object getIndex(E data){
        Node temp = head;
        int index = 0;
        while (temp.data != data){
            if (temp.data == null){
                return -1;
            }
            temp = temp.next;
            index++;
        }
        return index;
    }

    // value of index
    Object getValue(int index){
        Node node = node(index);
        return node.data;
    }



}
