package LinkedAlgorithm;

public class LinkedIndexOf<T> extends Node{
    // Index 값을 입력하면 Value이 출력
    T getValue(int index){
        Node temp = head;
        if(index >= nodeSize){
            throw new IllegalArgumentException("Nope");
        }
        for(int i=0; i < index; i++){
            temp = temp.next;
        }
        return (T) temp.data;
    }

    // Value 값을 입력하면 Index가 출력
    int getIndex(T data){
        Node temp = head;
        int count = 0;
        while (temp.data != data){
            temp = temp.next;
            count++;
        }
        return count;
    }
}
