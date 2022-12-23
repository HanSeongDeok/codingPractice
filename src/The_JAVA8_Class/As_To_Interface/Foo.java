package The_JAVA8_Class.As_To_Interface;

public interface Foo {
    void printName();
    default void printNameUpperCase(){
        System.out.println("test");
    };
}
