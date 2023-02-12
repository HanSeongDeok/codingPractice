package LifeCoding_Class.LinkedList_Practice_Pack;

public class Linked_List_Practice_Review_Main {
    public static void main(String[] args) {
        // Node (add, move, get, size, index, value) function API
        LinkedList_Practice_Review test = new LinkedList_Practice_Review();
        test.addLastNode(1);
        test.addLastNode(2);
        test.addLastNode(3);
        test.addLastNode(4);
        System.out.println("Value : " + test.getValue(3));
        System.out.println("Index : " +test.getIndex(4));

        // Iterator TEST
        LinkedList_Practice_UseWithIterator iteratorTest = new LinkedList_Practice_UseWithIterator(test.head);
        //iteratorTest.next();
        System.out.println("IteratorTest = " + iteratorTest.next());
        System.out.println("IteratorTest = " + iteratorTest.next());
        System.out.println("IteratorTest = " + iteratorTest.hasNext());

        // Use By hasNext
        while (iteratorTest.hasNext()){
            System.out.println("next : " + iteratorTest.next());
        }

        test.addLastNode(5);

        System.out.println("-----------------------------------");
        iteratorTest = new LinkedList_Practice_UseWithIterator(test.head);
        System.out.println("next : " + iteratorTest.next());
        System.out.println("next : " + iteratorTest.next());
        iteratorTest.add(15);
        System.out.println("next : " + iteratorTest.next());
        iteratorTest.add(35);
        System.out.println(test);
        while (iteratorTest.hasNext()){
            System.out.println("next : " + iteratorTest.next());
        }
        iteratorTest = new LinkedList_Practice_UseWithIterator(test.head);
        System.out.println(test);
        while (iteratorTest.hasNext()){
            System.out.println("next : " + iteratorTest.next());
        }
    }
}
