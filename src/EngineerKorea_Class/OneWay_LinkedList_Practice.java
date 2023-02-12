package EngineerKorea_Class;

public class OneWay_LinkedList_Practice {
    int data;
    OneWay_LinkedList_Practice next;
    OneWay_LinkedList_Practice(int data){
        this.data = data;
    }
    void append(int data){
        OneWay_LinkedList_Practice end = new OneWay_LinkedList_Practice(data);
        OneWay_LinkedList_Practice n = this;
        while (n.next != null){
            n = n.next;
        }
        n.next = end;
    }

    void delete(int data) {
        OneWay_LinkedList_Practice n = this;
        while(n.next!=null){
            if(n.next.data==data) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    void retrieve(){
        OneWay_LinkedList_Practice n = this;
        while (n.next!=null){
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }

    public static void main(String[] args) {
        OneWay_LinkedList_Practice ll = new OneWay_LinkedList_Practice(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();
        ll.delete(2);
        ll.delete(3);
        ll.retrieve();
    }
}
