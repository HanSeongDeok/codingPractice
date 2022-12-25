package The_JAVA8_Class.As_To_Interface;

public class AsToApp implements Foo{
    private static String note;

    @Override
    public void printName() {
        System.out.println("print test");
    }

    public void printName2(){
        System.out.println("print3 test");
    }

    private static void asToAppFunction(){
        System.out.println("----------------------------");
        note = "NOTE_asToAppFunction";
    }

    public static void main(String[] args) {
        AsToApp ata = new AsToApp();
        Foo foo = new Foo() {
            @Override
            public void printName() {
                System.out.println("print2 test");
            }
        };
        asToAppFunction();
        System.out.println(note);
        System.out.println("----------------------------");
        ata.printName();
        ata.printNameTest();
        foo.printName();
        foo.printNameTest();

        Foo foo2 = new AsToApp();
        //foo2.printName();
        ata.printName2();
        foo2.printNameTest();
        Foo printTest = new DefaultFoo("print_good");
        printTest.printName();
        foo2.printNameUpperCase();

        Foo foo3 = new DefaultFoo("Seong_Deok");
        foo3.printName();
        foo3.printNameUpperCase();

        foo.printAnything2();
        Foo.printAnything();
    }
}
