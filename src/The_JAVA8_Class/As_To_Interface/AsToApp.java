package The_JAVA8_Class.As_To_Interface;

public class AsToApp implements Foo{
    @Override
    public void printName() {
        System.out.println("print test");
    }

    public static void main(String[] args) {
        AsToApp ata = new AsToApp();
        Foo foo = () -> System.out.println("holly Test");
        ata.printName();
        ata.printNameUpperCase();
        foo.printName();
        foo.printNameUpperCase();
    }
}
