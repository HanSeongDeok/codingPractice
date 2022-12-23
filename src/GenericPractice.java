import java.util.ArrayList;
import java.util.List;

class Person<T> {
    public T info;
}

public class GenericPractice {
    int a;
    String b;

    public static void main(String[] args) {
        GenericPractice test = new GenericPractice();
        test.a = 2;
        test.b = "Test";
        //Person<String> p1 = new Person<String>();
        //Person<StringBuilder> p2 = new Person<StringBuilder>();

        StudentPerson p1 = new StudentPerson(4);
        StudentPersonInfo p2 = new StudentPersonInfo(p1);
        System.out.println("p2 = " + p2.info.grade);

        // 기존 문제점 -> 해결하기 위해 제네릭 나옴
        PersonInfo perInfo= new PersonInfo("부장");   // 문제가 발생 : 의도 하지 않은 데이터 타입을 허용
        /**
         * Cast 에러 발생 (RunTimeError)
         */
        try {
            EmployeePerson ep = (EmployeePerson)perInfo.info;
            System.out.println(ep.age);
        } catch (Exception e) {
            System.out.println("RunTimeError 발생 (Cast 에러)");
        }
        /**
         * 이런 문제를 해결하기 위해 Generic 나옴
         */
        EmployeePerson age= new EmployeePerson(4);
        Person2<EmployeePerson,Integer> em = new Person2(age,1);  // 아래와 같음
        //Person2<EmployeePerson, Integer> em = new Person2<EmployeePerson, Integer>(new EmployeePerson(4),1);
        System.out.println("age = " + em.info.age + " and id = " + em.id);

        /**
         * 메소드의 Generic -> 추정이 가능하면 코드 생략도 가능하다
         */
        em.takeInfo("Test");
        em.takeInfo(1);
        em.takeInfo(5.5);
        //이것도 가능
        em.<String>takeInfo("test");
        em.<Integer>takeInfo(new StudentPerson(2).grade);
        em.<EmployeePerson>takeInfo(age);
        em.takeInfo(age); //제네릭 데이터 타입(참조 자료형만) 생략 가능

        /**
         * 제네릭의 제한 사용  -> 제네릭<T>의 데이터 탑입을 설정해 주지 않는다면
         * Object 타입 전체를 상속받을 수 있다는 뜻으로 특정 객체의 데이터를 받아올 수 없음
         */
        PersonHeartBeat<PersonHeartBeat> heatBeat = new PersonHeartBeat<PersonHeartBeat>(128);
        heatBeat.PersonHeartBeat(new PersonHeartBeat(132));
        // heatBeat.className.PersonHeartBeat(new PersonHeartBeat(132));
        // heatBeat.className.PersonHeartBeat(new PersonHeartBeat(138));
        // heatBeat.PersonHeartBeat(new PersonHeartBeat(142));
        System.out.println(heatBeat.className.getHeartBeat()); // 132
        System.out.println(heatBeat.getHeartBeat()); // 128
        // 활용
        MenLife<Men> me = new MenLife(new Men(126));
        System.out.println("평소 나(남자)의 심장박동수");
        System.out.println(me.Men.MenHeartBeat);
        System.out.println("흥분할 때 나(남자)의 심장박동수");
        System.out.println(me.Men.getHeartBeat());
        /**
         * map <Key, Value></>  원리 알아보기 -> 내가 생각해서 만들어본 것. 틀릴 수도???-> 나중에 확인해보기
         */
        em.setKey("Test1");
        em.setKey("Test2");
        em.setKey("Test3");
        System.out.println(em.getKey());

    }
}
interface LifeObjectInfo{
    int getHeartBeat(); //interface 특성상 public abstract 생략가능
}
abstract class LifeObject{
    public int heartBeat;
    LifeObject(int heartBeat){
        this.heartBeat = heartBeat;
    }
    public abstract int getHeartBeat();
}
class Men implements LifeObjectInfo{
    public int MenHeartBeat;
    Men(int MenHeartBeat){
        this.MenHeartBeat = MenHeartBeat;
    }
    @Override
    public int getHeartBeat() {
        return MenHeartBeat+(MenHeartBeat*(12/10)-100);
    }
}
class MenLife<T extends LifeObjectInfo>{
    public T Men;
    MenLife(T men){
        this.Men = men;
    }
}
class PersonHeartBeat<T extends LifeObject> extends LifeObject{
    public T className;
    public int heartBeat;
    public void PersonHeartBeat(T className){
        this.className = className;
    }
    PersonHeartBeat(int heartBeat) {
        super(heartBeat);
        this.heartBeat = heartBeat;
    }
    @Override
    public int getHeartBeat() {
        return heartBeat;
    }
}
class Person2<T,S>{
    public T info;
    public S id;
    public List list = new ArrayList<>();

    Person2(T info, S id){
        this.info = info;
        this.id = id;
    }
    // 데이터 타입이 정해지지 않는 문장에서 데이터 값 반환은 불가능 Void 만 가능
    public <U> void takeInfo(U in){
        EmployeePerson compare = null;
        try {
            compare = ((EmployeePerson) in);
            System.out.println("in : " +compare.age);
        } catch (Exception e) {
            System.out.println("in : "+in);
        }
    }

    // Map <Key,Value> 함수의 원리 알아보자! -> 내가 생각해서 만들어 본것. 아닐 수 도..?
    public <E> void setKey(E key){
        this.list.add(key);
    }

    public List getKey(){
        return this.list;
    }
}
class PersonInfo {
    Object info;
    PersonInfo(Object info){this.info=info;}
}
class StudentPerson {
    int grade;
    StudentPerson(int grade) {this.grade = grade;}
}
class EmployeePerson {
    int age;
    EmployeePerson(int age){this.age=age;}
}
class StudentPersonInfo { StudentPerson info;StudentPersonInfo(StudentPerson info) {this.info=info;}}
class EmployeePersonInfo{ EmployeePerson info;EmployeePersonInfo(EmployeePerson info){this.info=info;}}
