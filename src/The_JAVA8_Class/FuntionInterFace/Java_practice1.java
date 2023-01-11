package The_JAVA8_Class.FuntionInterFace;

public class Java_practice1{
    public static void main(String[] args) {
        // 익명 내부 클래스 annoymous inner Class
        RunSomthing runSomthing = new RunSomthing() {
            @Override
            public String doit() {
                System.out.println("lambda");
                return "null";
            }
        };

        //람다로 구현
        RunSomthing runSomthingLambda = () -> "null";
        RunSomthing runSomthingLambda2 = () -> {
            String a = "good";
            return a;
        };

        /**
         * 퓨어한 함수형 인터페이스가 아님
         */
        RunSomthing runSomthing2 = new RunSomthing() {
            String baseNumber = "10";   //가능은 하나 함수의 값이 변경 될 가능성이 있는 경우는
                                        // 퓨어한 함수형 인터페이스라 하기 어렵다
            @Override
            public String doit() {
                baseNumber += "2";
                return baseNumber;
            }
            //baseNumber+="521"; final이 생략됨.
        };
        System.out.println(runSomthing.doit());
        System.out.println(runSomthingLambda.doit());
        System.out.println(runSomthingLambda2.doit());
    }
}
