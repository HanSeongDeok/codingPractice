package The_JAVA8_Class.LambdaExpressionDetail;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class lambdaPractice {
    public static void main(String[] args) {
        lambdaPractice lp = new lambdaPractice();
        lp.run();
    }

    private void run() {
        //final baseNumber = 10;
        int baseNumber = 10; // --> 사실상 final

        /**
         * 로컬 클래스
         */
        class Local2Class {
            void PrintBaseNumber(){
                System.out.println(baseNumber);
            }
        }
        Local2Class test = new Local2Class();
        test.PrintBaseNumber();


        /**
         *  익명 클래스
         */
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer + baseNumber);
            }
        };
        integerConsumer.accept(20);

        /**
         *  람다
         */
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };
        printInt.accept(10);

        // 람다와 다른 클래스들의 스콥(범위) 차이!!!
        // baseNumber와 같은 스콥에 있으므로 i 대신에 baseNumber 라는 변수 이름을 사용하면 컴파일 에러 발생!!
    }
}
