package The_JAVA8_Class.FuntionInterFace;

/**
 * 함수형 인터페이스란?
 */
// 함수형 인터페이스를 규제해주는 어노테이션
@FunctionalInterface
public interface RunSomthing {
    public abstract String doit(); // 추상 메소드가 한개만 있는 경우를 함수형 인터페이스라 지칭한다.
}