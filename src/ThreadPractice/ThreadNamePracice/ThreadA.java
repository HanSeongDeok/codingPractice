package ThreadPractice.ThreadNamePracice;

public class ThreadA extends Thread{

    @Override
    public void run() {
        System.out.println("TEST_A--> " + this.getName());
    }
}
