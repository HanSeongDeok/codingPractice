package LifeCoding_Class.Collection_FrameWork;
import java.util.*;
import java.util.LinkedList;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");

        System.out.println(linkedList);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());

        System.out.println("----------------");
        Iterator it = linkedList.iterator();
        while(it.hasNext()){
            if (it.next().equals("1")){
                System.out.println("1 GOOD");
                System.out.println(it.next());
                System.out.println(it.next());
            }
        }

    }
}
