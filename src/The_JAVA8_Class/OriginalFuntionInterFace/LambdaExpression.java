package The_JAVA8_Class.OriginalFuntionInterFace;

import java.util.function.Function;

public class LambdaExpression {

    public void lambdaFuntionExpression1(int a){
        // 위의 같은 표현 1
        Function originalFuntion1 = new Function() {
            @Override
            public Object apply(Object obj) {
                return obj.getClass();
            }
        };
        System.out.println(originalFuntion1.apply(a));
    }

    public void lambdaFuntionExpression2(String a){
        // 위의 같은 표현 2
        Function originalFuntion2 = (obj)-> {
            return obj.getClass();
        };
        System.out.println(originalFuntion2.apply(a));
    }

    public static void main(String[] args) {
        int a = (int)3.2; // --> 명시적 형변환
        double b = 2; // --> 자동 형변환
        LambdaExpression ex1 = new LambdaExpression();
        LambdaExpression ex2 = new LambdaExpression();
        //람다 표현
        Function originalFuntion = (obj)-> (Integer)obj + 10;
        OriginalFuntionInterface originFuntion2 = new OriginalFuntionInterface();


        Object test = originFuntion2.apply(10);
        System.out.println(originalFuntion.apply(2));
        ex1.lambdaFuntionExpression1(29);
        ex2.lambdaFuntionExpression2("aaaa");
        System.out.println(test);
    }
}
