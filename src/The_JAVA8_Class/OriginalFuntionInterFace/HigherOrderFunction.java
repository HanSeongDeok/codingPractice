package The_JAVA8_Class.OriginalFuntionInterFace;

import java.util.function.*;

public class HigherOrderFunction {
    public static void main(String[] args) {
        /**
         * Function<T, R>
         */
        Function<Integer,Integer> plus10 = (number) -> number + 10;
        Function<Integer,Integer> multiply2 = (number) -> number * 2;

        //Compose 함수
        Function<Integer,Integer> composeTest = plus10.compose(multiply2);
        System.out.println(composeTest.apply(2));

        // andthen 함수
        Function<Integer,Integer> andthenTest = plus10.andThen(multiply2);
        System.out.println(andthenTest.apply(2));  // 24
        System.out.println(plus10.andThen(multiply2).apply(2));  // 24

        /**
         * BiFunction<T, U, R>
         */

        /**
         * Consumer<T>
         */
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        /**
         * Supplier<T>
         */
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        /**
         * Predicate<T>
         */
        Predicate<String> startsWithKeesum = (s) -> s.startsWith("Keesun");
        Predicate<Integer> isOdd = (i) -> i%2 != 0;

        /**
         * UnaryOperator<T>
         */
        UnaryOperator<Integer> plusTen = (number) -> number + 10;
        UnaryOperator<Integer> multiplyTwo = (number) -> number * 2;

        /**
         * BinaryOperator<T>
         */
    }
}
