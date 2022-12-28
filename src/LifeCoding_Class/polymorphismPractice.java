package LifeCoding_Class;

class A{
    int a = 10;
    public String x(){
        return "x";
    }
    public String x2(){      // --> 오버라이딩 될 경우 예제
        return "A.x";
    }
}

class B extends A{
    int b = 0;
    public String y(){
        String x = x();
        return x+"y";
    }

    @Override                 // --> 오버라이딩 될 경우 예제
    public String x2(){
        return "B.x";
    }
}
/**
 * 하나의 객체가 여러 가지 타입을 가질 수 있는 것을 의미 -> 다형성
 */
public class polymorphismPractice {
    public static void main(String[] args) {
        A obj = new B();
        System.out.println(obj.x());
       // System.out.println(obj.y()); //컴파일 에러
        System.out.println(obj.x2());
        // System.out.println(obj.b);  // 컴파일 에러
        A obj2 = new A();
        System.out.println(obj2.x2());
        B obj3 = new B();
        System.out.println(obj3.y());
    }
}
