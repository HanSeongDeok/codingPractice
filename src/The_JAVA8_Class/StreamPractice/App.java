package The_JAVA8_Class.StreamPractice;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "reset api development", false));

        /**
         * 출력이 안되는 이유는 스트림 파이프 라인이 중계형 오퍼레이터이기 때문이다.
         * 출력을 하려면 종료형 즉, 터미네이터형 오퍼레이터가 있어야 한다.
         */
        List<String> collect = Arrays.stream(springClasses.toArray()).map((s) -> {
            System.out.println(s);
            return s.toString().toUpperCase();
        }).collect(Collectors.toList());
        System.out.println("====================");
        collect.forEach(s -> {
            System.out.println(s);
        });
        System.out.println("====================");
        springClasses.forEach(System.out::println);

        String []test = {"one", "two", "three", "four"};
        List<String> testList = Stream.of(test).collect(Collectors.toList());
        List<String> testList2 = testList.parallelStream()
                .map(s -> {
                    System.out.println(Thread.currentThread().getName());
                   return s.toUpperCase(Locale.KOREAN);
                })
                .collect(Collectors.toList());
        testList2.forEach(s -> {
            System.out.print(s + " ");
        });
        System.out.println("");

        // 여기서 부터 예제 문제 풀이!!
        springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "reset api development", false));

        System.out.println("----------------------");
        System.out.println("Spring 으로 시작하는 수업");
        springClasses.stream()
                .filter(s -> {return s.getTitle().startsWith("spring");})
                .forEach(s -> {System.out.println(s.getTitle());});

        System.out.println("----------------------");
        System.out.println("Close 되지 않은 수업");
        springClasses.stream()
                .filter(s -> {return !s.isClosed();})
                .forEach(s -> {System.out.println(s.getId() + " " + s.getTitle());});
        // 응용 버전
        System.out.println();
        System.out.println("응용 버전");
        springClasses.stream()
                .filter(Predicate.not(OnlineClass::isClosed))
                .forEach(s->{System.out.println(s.getId() + " " + s.getTitle());});
        System.out.println("----------------------");
        System.out.println("수업 이름만 모아서 스트림 만들기");
        springClasses.stream()
                .forEach(s-> System.out.println(s.getTitle()));
        // 응용 버전
        System.out.println();
        System.out.println("응용 버전");
        springClasses.stream()
                .map(OnlineClass::getTitle)
                .forEach(System.out::println);


        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> eventClasses = new ArrayList<>();
        eventClasses.add(springClasses);
        eventClasses.add(javaClasses);

        System.out.println("----------------------");
        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        eventClasses.stream().flatMap(list -> list.stream())
                .map(OnlineClass::getId)
                .forEach(System.out::println);
        System.out.println("----------------------");
        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        Stream.iterate(10, integer -> integer+1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);
        System.out.println("----------------------");
        System.out.println("자바 수업 중에 Test 가 들어있는 수업이 있는지 확인");
        System.out.println(javaClasses.stream()
                .anyMatch(p -> p.getTitle().contains("spring")));
        System.out.println("----------------------");
        System.out.println("스프링 수업 중에 제목에 spring 이 들어간 것만 모아서 List 로 만들기");
        List<OnlineClass> temp = new ArrayList<>();
        temp = eventClasses.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
        OnlineClass []tempArr = temp.toArray(new OnlineClass[temp.size()]);
        temp = Stream.of(tempArr)
                .collect(Collectors.toList())
                .stream()
                .filter(x -> x.getTitle().contains("spring"))
                .collect(Collectors.toList());
        temp.forEach(System.out::println);
        // 수업만 출력
        temp.stream()
                .map(x -> x.getTitle())
                .filter(t -> t.contains("spring"))
                .forEach(System.out::println);
    }
}
