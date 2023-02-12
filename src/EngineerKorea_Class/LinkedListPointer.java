package EngineerKorea_Class;

/**
 * 공간을 필요로 하지 않고 뒤에서 n번째 노드 찾는 알고리즘
 * Pointer를 2개를 선언하여 구현
 * (O(N) - 공간복잡도 , O(1) - 시간복잡도)
 */
public class LinkedListPointer {
    static class Node{
        int data;
        Node next;
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
        public String toString(){
            return String.valueOf(this.data);
        }
    }
    public static Node KthToLast(Node head, int k){
        Node p1 = head;
        Node p2 = head;
        for(int i=0; i<k; i++){
            p1 = p1.next;
        }
        while(p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
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
        System.out.println(KthToLast(head, 1));
    }
}
