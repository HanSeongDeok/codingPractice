package The_JAVA8_Class.ApiBasicMethod;

import java.util.*;
import java.util.function.Consumer;

public class App{
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("seongdeok");
        name.add("keesun");
        name.add("foo");
        name.add("todo");

        /**
         * 같은 의미 다른표현 ::아래::
         */
        for(String str_name : name){
            System.out.println(str_name);
        }

        name.forEach(s -> {
            System.out.println(s);
        });

        name.forEach(System.out::println);

        /**
         * spliterator
         */
        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator2 = spliterator.trySplit();
        Spliterator<String> spliterator3 = name.spliterator();

        System.out.println("=============================");
        while (spliterator.tryAdvance(System.out::println));         //tryAdvance;
        System.out.println("=============================");
        while (spliterator2.tryAdvance(System.out::println));
        //spliterator.tryAdvance(x -> System.out.println(x));
        /*while (spliterator3.tryAdvance(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        }));*/
        System.out.println("=============================");
        spliterator3.forEachRemaining(System.out::println);

    }
}
