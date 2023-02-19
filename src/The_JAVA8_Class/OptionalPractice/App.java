package The_JAVA8_Class.OptionalPractice;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.function.Predicate;
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

        Optional<OnlineClass> onlineClass = springClasses.stream()
                .filter(o -> o.getTitle().startsWith("spring"))
                .min((o1, o2) -> o1.getId() - o2.getId());

        System.out.println(onlineClass.isEmpty());
        System.out.println(onlineClass.isPresent());
        //System.out.println(onlineClass.get());
        /**
         * 위의 get 메소드로 값을 가져오는 것 대신에 ifPresent 메소드를 사용하여 출력
         * Title 출력
         */
        onlineClass.ifPresent(o -> System.out.println(o.getTitle()));

        /**
         * DataType 으로 값을 받아야 하는 경우 (orElse)
         */
        OnlineClass onlineClass1 = onlineClass.orElse(createNewClass());
        System.out.println(onlineClass1);

        /**
         * DataType 으로 값을 받아야 하는 경우 (orElseGet) 없는 경우 실행 있으면 실행 X
         */
        System.out.println("-----------");
        OnlineClass onlineClass2 = onlineClass.orElseGet(()->createNewClass());
        System.out.println(onlineClass2);

        /**
         * Optional 에서 해당사항 없을 시 Throw 를 통해 예외처리 출력
         */
         OnlineClass onlineClass3 = onlineClass.orElseThrow();
         onlineClass3 = onlineClass.orElseThrow(()->{
             return new RuntimeException();
         });
        System.out.println(onlineClass3);

        /**
         * Optional 값이 있을 경우 (없으면 아무 일도 안 일어남) filter 사용
         */
        Optional<OnlineClass> onlineClass4 = onlineClass.filter(Predicate.not(OnlineClass::isClosed));
        System.out.println(onlineClass4.isPresent());
        System.out.println(onlineClass4.isEmpty());

        /**
         * TODO 이해가 100프로 안됨 헷갈림 -> 다시 해봐야겠음
         * Optional 값이 있을 경우 (없으면 아무 일도 안 일어남) map / flatMap 사용
         * 이해가 100프로 안됨 헷갈림 -> 다시 해봐야겠음
         */
        System.out.println("------------");
        Optional<Optional<Progress>> onlineClass5 = onlineClass.map(x -> x.getProgress());
        Optional<Progress> progress = onlineClass5.orElse(Optional.empty());
        System.out.println(progress);

        //위 와 같음
        Optional<Progress> progress1 = onlineClass.flatMap(OnlineClass::getProgress);
        System.out.println(progress1);
        
    }



    public static OnlineClass createNewClass(){
        System.out.println("------------");
        System.out.println("Create New Online Class");
        return new OnlineClass(10, "New class", false);
    }


}
