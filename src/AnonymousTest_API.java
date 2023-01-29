@FunctionalInterface
public interface AnonymousTest_API {
    int changeNum = 10;
    int sum(int a, int b);

    default String printA (int a){
        String printA = "a : " + a;
        return printA;
    }

    static int getChangeNumSumFive(){
        return changeNum + 5;
    }
}
