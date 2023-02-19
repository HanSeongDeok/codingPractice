package ThreadPractice.ThreadNamePracice;

public class ThreadNameExample {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread threadA = new ThreadA();
        Thread threadB = new Thread(()->{
            System.out.println("TEST_B--> " + Thread.currentThread().getName());
        });
        Thread threadC = new ThreadB();
        //threadA.setName("THREAD_A");
        System.out.println(threadA.getName() + " " + threadB.getName() + " " + threadC.getName());

        threadA.start();
        threadB.start();
        threadC.start();

    }
}
