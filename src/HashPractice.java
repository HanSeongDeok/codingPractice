import java.util.HashSet;
import java.util.Set;

// 연결된 목록 노드
class Node
{
    int data;
    Node next;

    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}

class HashPractice
{
    // 해싱을 이용하여 연결된 목록의 순환을 감지하는 함수
    public static boolean detectCycle(Node head)
    {
        Node curr = head;
        Set<Node> set = new HashSet<>();

        // 목록 순회
        while (curr != null)
        {
            // 이전에 이 노드를 이미 본 적이 있으면 false를 반환합니다.
            if (set.contains(curr)) {
                return true;
            }
            // 현재 노드를 집합에 삽입
            set.add(curr);
            // 다음 노드로 이동
            curr = curr.next;
        }

        // 목록에 사이클이 포함되어 있지 않으면 여기에 도달합니다.
        return false;
    }

    public static void main(String[] args)
    {
        // 입력 키
        int[] keys = {1, 2, 3, 4, 5};

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        // 사이클 삽입
        //head.next.next.next.next.next = head.next.next;

        if (detectCycle(head)) {
            System.out.println("Cycle Found");
        }
        else {
            System.out.println("No Cycle Found");
        }
    }
}
