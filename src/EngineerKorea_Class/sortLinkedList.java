package EngineerKorea_Class;

public class sortLinkedList {
    class Node{
        int data;
        Node next;
        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 공간을 하나만 사용하는 시간복잡도 n의 기준값 분류 함수
     * @param n
     * @param x
     */
    public static Node solution(Node n, int x){
        Node head = n;
        Node tail = n;
        while(n != null){
            Node next = n.next;
            if(n.data < x){
                n.next = head;
                head = n;
            } else {
                tail.next = n;
                tail = tail.next;
            }
            n = next;
        }
        tail.next = null;
        return head;
    }

    /**
     * 공간 복잡도 2개를 사용하는 시간복잡도 n의 기준값 분류 함수
     * @param n
     * @param x
     */
    public static Node solution2(Node n, int x){
        Node s1 = null;
        Node e1 = null;
        Node s2 = null;
        Node e2 = null;;
        while (n != null){
            Node next = n.next;
            //n.next = null; // -> 밑에 과정을 생략하고 이 구문을 추가하는 방법도 존재(이건 생각 못했음)
            if(n.data < x){
                if(s1 == null){
                    s1 = n;
                    e1 = s1;
                }else {
                    e1.next = n;
                    e1 = e1.next;
                }
            } else {
                if (s2 == null){
                    s2 = n;
                    e2 = s2;
                }else {
                    e2.next = n;
                    e2 = e2.next;
                }
            }
            n =next;
        }
        if(e1.next != null) e1.next = null; // = null;
        if(e2.next != null) e2.next = null; // = null;
        if(s1 == null){return s2;}
        e1.next = s2;
        return s1;
    }
    public static void main(String[] args) {
        int []list = {7, 2, 8, 5, 3, 4};
        Node n = null;
        for(int i=list.length-1; i>=0; i--){
            n = new sortLinkedList().new Node(list[i], n);
        }
        //Node printN = solution(n, 5);
        Node printN = solution2(n, 5);

        while(printN.next != null){
            System.out.print(printN.data + " -> ");
            printN = printN.next;
        }
        System.out.println(printN.data);
    }
}
