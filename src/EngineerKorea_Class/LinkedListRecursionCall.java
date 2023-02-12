package EngineerKorea_Class;

import LinkedAlgorithm.Node;

public class LinkedListRecursionCall {
    static class Node{
        int data;
        Node next;
        public Node(int data,Node next){
            this.data = data;
            this.next = next;
        }
    }

    static class Reference{
        public int count = 0;
    }

    public static Node KthToLastNode(Node n, int k, Reference r){
        if(n==null){
            return null;
        }
        Node found = KthToLastNode(n.next, k, r);
        r.count++;
        if(r.count == k){
            return n;
        }
        return found;
    }

    public static int KthToLast(Node n, int k){
        if(n == null){
            return 0;
        }
        int count = KthToLast(n.next, k) + 1;
        if(count == k){
            System.out.println("뒤에서 "+k+"번째 data : " + n.data);
        }
        return count;
    }
    public static void main(String[] args) {
        int tempList[] = {1,2,3,4};
        Node head = null;
        Node temp1 = null;
        for(int i=0; i<tempList.length; i++) {
            Node temp2 = new Node(tempList[i], null);
            if(temp1 == null){
                head = temp2;
                temp1 = head;
            }else {
                temp1.next = temp2;
                temp1 = temp1.next;
            }
        }
        KthToLast(head,4);
        Reference r = new Reference();
        Node found = KthToLastNode(head, 4, r);
        System.out.println(found.data);
    }
}
