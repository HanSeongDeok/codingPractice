package LifeCoding_Class.Collection_FrameWork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class ListPractice {
    public static void main(String[] args) {
        MapPractice.iteratorTest();

        ArrayList<Integer> A = new ArrayList<Integer>();
        Collection<Integer> B = new ArrayList<Integer>();
        Collection<Integer> C = new HashSet<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(3);
        A.add(3);
        B.add(4);
        B.add(5);
        B.add(6);
        C.add(3);

        System.out.println(C.addAll(B));  // true
        System.out.println(B.retainAll(C)); // false
        System.out.println(A.removeAll(C)); // true
        // Iterator iter = C.iterator();
        // System.out.println(iter.next());


        Iterator hi = A.iterator();
        while (hi.hasNext()){
            System.out.println(hi.next());
        }
    }
}
