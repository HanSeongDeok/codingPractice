package LifeCoding_Class;

interface CalculatorInterfaceTest{
    default void test(){
        System.out.println("testste");
    }
    default int test2(){
        return 0;
    }
}

class Calculator{
    public int calSum(int a, int b){return 0;}
    public int calMinor(int a, int b){return 0;}
    public void run(){}
}
class CalSum extends Calculator{
    int calSumVal;
    public int calSum(int a, int b){this.calSumVal=a+b; return a+b;}

    @Override
    public void run() {
        System.out.println("합 : "+ this.calSumVal);
    }
}
class CalMinor extends Calculator{
    int calMinorVal;
    public int calMinor(int a, int b){this.calMinorVal=a-b; return a-b;}

    @Override
    public void run() {
        System.out.println("뺄 : "+ this.calMinorVal);
    }
}

public class polymorphismCalculatorDemo {
        public static void execute(Calculator cal) {
            cal.run();
        }
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Calculator sum = new CalSum();
        Calculator minor = new CalMinor();
        sum.calSum(1,5);
        minor.calMinor(5,4);
        execute(sum);
        execute(minor);
    }
}
