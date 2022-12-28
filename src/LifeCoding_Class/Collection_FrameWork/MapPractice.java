package LifeCoding_Class.Collection_FrameWork;

import java.util.*;

/**
 * @implNote Map은 수학의 함수의 형태를 띄고 있다 -> y=f(x); 정의역 : KEY, 공역 : VALUE;
 */
public class MapPractice {
    public static void main(String[] args) {
        HashMap<String, Integer> a = new HashMap();
        a.put("One", 1);
        a.put("Two", 2);
        a.put("Three", 3);
        a.put("Four", 4);

        Iterator iterator = a.values().iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println(a.get("One"));
        System.out.println(a.clone());
        System.out.println(a.get("Two"));

        String[] strArray = {"a", "b", "c"};
        Arrays.stream(strArray).forEach(s -> System.out.print(s+" "));
        Arrays.stream(strArray).forEach(System.out::print);
        System.out.println("");
        System.out.println("--------------");

        iteratorUsingForEach(a);
        iteratorUsingIterator(a);
    }

    static void iteratorUsingForEach(HashMap map) {
        Set<HashMap.Entry<String,Integer>> entries = map.entrySet();
        entries.forEach(stringIntegerEntry -> System.out.println(stringIntegerEntry.getKey() + ":" + stringIntegerEntry.getValue()));
    }

    static void iteratorUsingIterator(HashMap map) {
        Set<HashMap<String, Integer>> entries = map.entrySet();
        Iterator<HashMap<String,Integer>> i = entries.iterator();
        while (i.hasNext()) {
            HashMap.Entry<String,Integer> a = (HashMap.Entry)i.next();
            System.out.println(a.getKey()+" : "+a.getValue());
        }
    }

    static void iteratorTest(){
        System.out.println("TEST");
    }
}
