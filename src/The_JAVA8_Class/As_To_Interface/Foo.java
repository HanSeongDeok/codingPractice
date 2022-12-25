package The_JAVA8_Class.As_To_Interface;

public interface Foo {
    String getName = "print_good";
    void printName();
    default String getName(){
        return getName;
    };

    // 인터페이스 작성 시 주석에 상세히 작성해 놀 것!
    /**
     * @implNote
     * 이 함수를 호출 시 "test" 라는 문자열을 출력해줌
     */
    default void printNameTest(){
        System.out.println("test");
    };

    /**
     * @implSpec
     * 이 함수는 getName()으로 가저온 문자열을 대문자로 바꿔 출력한다.
     */
    default void printNameUpperCase(){
        System.out.println(getName().toUpperCase());
    };


}
