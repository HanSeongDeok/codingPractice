package The_JAVA8_Class.StreamAPI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

class OnlineClass{
       private Integer id;
       private String title;
       private boolean closed;

       public OnlineClass(Integer id, String title, boolean closed){
           this.id = id;
           this.title = title;
           this.closed = closed;
       }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public boolean isClosed() {
        return closed;
    }
    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
public class StreamPractice {
    public static void main(String[] args) {
        List<OnlineClass> springClass = new ArrayList();
        springClass.add(new OnlineClass(1, "spring boot", true));
        springClass.add(new OnlineClass(2, "spring data jpa", true));
        springClass.add(new OnlineClass(3, "spring mvc", false));
        springClass.add(new OnlineClass(4, "spring core", false));
        springClass.add(new OnlineClass(5, "reset api development", true));

        List<OnlineClass> javaClass = new ArrayList<>();
        javaClass.add(new OnlineClass(6, "Java Test", true));
        javaClass.add(new OnlineClass(7, "Java Compliment", true));
        javaClass.add(new OnlineClass(8, "Java 8 to 11", false));



        System.out.println("Spring 으로 시작하는 수업");
        springClass.stream().filter(new Predicate<OnlineClass>() {
            @Override
            public boolean test(OnlineClass onlineClass) {
                return onlineClass.getTitle().startsWith("spring");
            }
        }).forEach(new Consumer<OnlineClass>() {
            @Override
            public void accept(OnlineClass onlineClass) {
                System.out.println(onlineClass.getId());
            }
        });

        System.out.println("close 되지 않은 수업");
        //springClass.parallelStream().filter(c -> !c.isClosed()).forEach(c -> c.getId());
        springClass.parallelStream().filter(Predicate.not(OnlineClass::isClosed)).forEach(c -> System.out.println(c.getId()));


        System.out.println("수업 이름만 모아서 스트림");
        springClass.stream().map(new Function<OnlineClass, Object>() {
            @Override
            public String apply(OnlineClass onlineClass) {
                return onlineClass.getTitle();
            }
        }).forEach(s -> System.out.println(s));

        springClass.stream()
                .map(OnlineClass::getTitle)
                .forEach(c -> System.out.println(c));

        List<List<OnlineClass>> hanEventList = new ArrayList<>();
        hanEventList.add(springClass);
        hanEventList.add(javaClass);

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디를 출력");
        hanEventList.stream().flatMap(new Function<List<OnlineClass>, Stream<?>>() {
            @Override
            public Stream<?> apply(List<OnlineClass> onlineClasses) {
                return onlineClasses.stream();
            }
        });
        hanEventList.stream().flatMap(Collection::stream).forEach(c -> System.out.println(c.getId()));

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        Stream.iterate(0, Integer -> Integer + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");

        System.out.println("스프링 수업 중에 제목에 Spring이 들어간 것만 모아서 List로 만들기");

    }
}
