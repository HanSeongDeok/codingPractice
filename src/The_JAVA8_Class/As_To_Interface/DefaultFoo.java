package The_JAVA8_Class.As_To_Interface;

public class DefaultFoo implements Foo, BarOrigin, Bar{
    String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    /**
     * 구현하는 쪽에서 재정의 가능
     * @implNote 만약 implements 한 인터페이스들이 동일한 default 메소드를 가졌을 때 그 메소드를 재정의 해줘야만컴파일 에러가 나지 않는다.
     */
    @Override //생략이 가능
    public void printNameUpperCase() {
        System.out.println(this.name.toUpperCase());
    }
}
