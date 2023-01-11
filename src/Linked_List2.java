class TEST <T> {
    T data;
    TEST next = null;
    TEST(T data) {
        this.data = data;
    }

    public void addNode(T data) {
        TEST end = new TEST(data);
        TEST n = this;
        while (n.next != null){
            n = n.next;
        }
        n.next = end;
    }

    public void delete(T data) {
        TEST n = this;
        while(n.next != null) {
            if(n.next.data == data){
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    public void retrieve(){
        TEST n = this;
        while(n.next!=null){
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }
}
    public class Linked_List2 {
        public static void main(String[] args) {
            TEST test = new TEST(1);
            test.addNode(2);
            test.addNode(3);
            test.addNode(4);
            test.retrieve();
            test.delete(3);
            test.retrieve();
        }
    }
