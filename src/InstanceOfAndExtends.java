
@FunctionalInterface
interface AnimalHiddenPoint{
    int animalHiddenPointSum(Animal o);
}

class LamdaTest{
    public int print(){
        return 1;
    }
}
class Animal{
    int animalPoint(int n){return 10;}
}

class Dog extends Animal{
    int dogPoint=5;
    int animalPoint(int n){return super.animalPoint(n)+dogPoint;}
}

class Cat extends Animal{
    int catPoint=3;
    int animalCatHiddenPint(){return 7;}
    int animalPoint(int n){return super.animalPoint(n)+catPoint;}
}

/**
 * instanceOf를 지양하고 extends를 활용하는 방법!!
 */
public class InstanceOfAndExtends{
    static class SolutionAnimalSum{
        public int animalSum(Animal n){
            return n.animalPoint(1231424);
        }
        public <E extends Cat> int hiddenPoint(E n){
            return n.animalCatHiddenPint();
        }
    }
    public static void main(String[] args) {
        Animal aniDog = new Dog();
        Animal aniCat = new Cat();
        SolutionAnimalSum aniSum = new SolutionAnimalSum();
        System.out.println("DogPoint: " + aniSum.animalSum(aniDog) + " CatPoint: " + aniSum.animalSum(aniCat));
        System.out.println("CAT HIDDEN POINT");
        System.out.println("DogPoint: " + aniSum.animalSum(aniDog) + " CatPoint: " + (aniSum.animalSum(aniCat)+aniSum.hiddenPoint((Cat)aniCat)));

        /**
         * 람다식을 사용하려면 클래스 내에 유일한 추상 메소드여야 함. -> 함수형 인터페이스
         * 아래와 같은 경우는 익명클래스만 사용이 가능하다.
         *
         */
        int b = 2;
        int a = 10 + b; //final 이 생략
        LamdaTest print = new LamdaTest(){
            @Override
            public int print() {
                return super.print() + a + b;
            }
        };
        //a = 30; // 만약 익명 클래스 내에 a가 존재한다면 a는 같은 스코프에 a를 상수 변수로 받아들여져 이 구문에 30을 초기화 한다면 논리적 오류로 인식된다.
        System.out.println(a);

        AnimalHiddenPoint test = (o9)-> o9.animalPoint(8497);
        System.out.println(test.animalHiddenPointSum(aniCat));
       // System.out.println(animalPointSum(aniDog, aniCat));
    }

    /**
     * 이런 instanceOf를 활용하는 구문보다 차라리
     * extends를 활용하는 클래스를 만들어 사용하는 것이 성능 측면에서 훨씬 빠르다!!
     *
     * @param o1
     * @param o2
     * @return
     */
    private static String animalPointSum(Animal o1, Animal o2){
        int hiddenPoint = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("Dog-Point: " + o1.animalPoint(1234125) + "Cat-Point: " + o2.animalPoint(234235));
        if(o2 instanceof Cat){
            sb.setLength(0);
            /**
             * @Note 람다를 사용할 수 있는건
             */
            AnimalHiddenPoint test = o -> o.animalPoint(1234) + ((Cat)o).animalCatHiddenPint();
            sb.append("Dog-Point: " + (o1).animalPoint(123523) + " Cat-Point: " + test.animalHiddenPointSum(o2));
        }

        return sb.toString();
    }

}


