package The_JAVA8_Class.MethodRefference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class methodRefferencePractice {
    public static void main(String[] args) {
        UnaryOperator<String> hi = (s)-> "hi " + s;
        System.out.println(hi.apply("YOU"));

        /**
         * 메소드 레퍼런스
         */
        // 스태틱 메소드 참조
        UnaryOperator<String> hi2 = Greeting::hi;
        UnaryOperator<String> hi3 = name -> Greeting.hi(name);
        UnaryOperator<String> hi4 = new UnaryOperator<String>() {
            @Override
            public String apply(String name) {
                return Greeting.hi(name);
            }
        };
        System.out.println(hi2.apply(" 2"));
        System.out.println(hi3.apply(" Test"));
        System.out.println(hi4.apply(" hi4"));

        // 매개변수를 갖지 않는 생성자 참조
        Supplier<Greeting> newGreeting = Greeting::new;
        Supplier<Greeting> newGreeting2 = () -> new Greeting();
        Supplier<Greeting> newGreeting3 = new Supplier<Greeting>() {
            @Override
            public Greeting get() {
                return new Greeting();
            }
        };
        System.out.println(newGreeting.get().hi(" GOOD")); // 인스턴스 변수에서 정적 메소드 호출
        System.out.println(newGreeting.get().hello(" NICE")); // 인스턴스 변수에서 인스턴스 메소드 호출

        // 매개변수를 갖는 생성자 참조
        Function<String, Greeting> goodGreeting = Greeting::new;
        Function<String, Greeting> goodGreeting2 = name -> new Greeting(name);
        Function<String, Greeting> goodGreeting3 = new Function<String, Greeting>() {
            @Override
            public Greeting apply(String s) {
                return new Greeting(s);
            }
        };
        Greeting han = goodGreeting3.apply("HOOK");
        System.out.println(han.getName());
        System.out.println(han.hello(" HOOK_HELLO"));

        // 임의 객체의 인스턴스 메소드 참조
        String[] names = {"one,", "two", "three"};
        Arrays.sort(names, (s, str) -> s.compareToIgnoreCase(str));
        Arrays.sort(names, String::compareToIgnoreCase);
        Arrays.sort(names, (o1, o2) -> 0);
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        System.out.println(Arrays.toString(names));
    }
}
