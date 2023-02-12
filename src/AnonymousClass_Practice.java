public class AnonymousClass_Practice {
    int x;
    int y;
    public void test(int x, int y){
        this.x = x;
        this.y = y;
        AnonymousTest_API sumTest = (a, b)->{
            int ax = a*10 + AnonymousTest_API.changeNum;
            int bx = b*10 + AnonymousTest_API.getChangeNumSumFive();
            return ax+bx;
        };

        int sum = sumTest.sum(x,y);
        System.out.println(sumTest.printA(sum));
        System.out.println(sum);
        System.out.println(AnonymousTest_API.getChangeNumSumFive());
        System.out.println(sumTest.changeNum);
    }
    public static void main(String[] args) {
        AnonymousClass_Practice test = new AnonymousClass_Practice();
        test.test(1,3);
    }
}
