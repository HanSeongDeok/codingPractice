package The_JAVA8_Class.As_To_Interface;

public interface Bar extends Foo {
    // Bar를 이용할 때 printNameUpperCase()를 다시 재정의 해줘야한다. -> Foo 에서의 Default 함수 기능을 사용 하기 싫을 때
    default void printNameUpperCaseBar(){

    };

}
