package The_JAVA8_Class.OptionalPractice;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PracticeApp {
    public static void main(String[] args) {
        List<OnlineClass> springClassed = new ArrayList();
        springClassed.add(new OnlineClass(1, "spring boot", true));
        springClassed.add(new OnlineClass(2, "spring boot2", true));
        springClassed.add(new OnlineClass(3, "spring boot3", true));
        springClassed.add(new OnlineClass(5, "rest Api", false));

        Optional<OnlineClass> optional = springClassed.stream()
                .filter(oc -> oc.getTitle().startsWith("rest")).findFirst();

        //optional.isPresent();

        /**
         * @NOTE 가급적이면 get()을 사용하지 않도록 하자!
         */
        //System.out.println(optional.get().getTitle());
        System.out.println(!optional.isPresent());
        System.out.println(optional.isPresent());
        System.out.println(optional.isEmpty());

        //1
        optional.ifPresent(oc-> System.out.println(oc.getTitle()));

        //2
        OnlineClass onlineClass1 = optional.orElse(newClass());
        //2-1
        /**
         * @NOTE Supplier 를 활용하여 필요에 의한 메소드만을 실행하여 효율성 극대화
         */
        OnlineClass onlineClass2 = optional.orElseGet(()->newClass());
        OnlineClass onlineClassSame2 = optional.orElseGet(PracticeApp::newClass);
        System.out.println(optional.orElseGet(PracticeApp::newClass).getTitle());

        //3
        /**
         * @NOTE 원하는 에러를 던질 수도 있다.
         */
        OnlineClass onlineClass = optional.orElseThrow(IllegalAccessError::new);
        System.out.println(onlineClass.getTitle());

        //4
        /**
         * @NOTE 위의 Optional 의 조건이 부합했을 때 Optional 에 담겨있는 값이 존재할 경우에 해당
         */
        Optional<OnlineClass> testOptional = optional.filter(oc -> oc.getId() > 0);
        System.out.println(testOptional.isEmpty());
        System.out.println(testOptional.isPresent());

        //5
        /**
         * @NOTE Map 을 이용할 수도 있다
         */
        System.out.println(optional.map(oc->oc.getId()).orElseGet(PracticeApp::test));

        //6
        /**
         * flatMap 을 쓰면 Optional 에 감싸져 있는 Optional 을 자동으로 정리해 준다.
         */
        Optional<Optional<Progress>> progress = optional.map(OnlineClass::getProgress);
        Optional<Progress> progress1 = progress.orElse(Optional.empty());
        //FlatMap
        Optional<Progress> progress2 = optional.flatMap(OnlineClass::getProgress);
    }

    /**
     * 무조건 실행 된다 ㅜㅜ 이게 싫다면? orElseGet 메소드를 이용하자
     * @return
     */
    private static OnlineClass newClass(){
        System.out.println("Create New Class");
        return new OnlineClass(10, "New Class", false);
    }

    private static Integer test(){
        return -1;
    }
}
