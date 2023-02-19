package ThreadPractice.ThreadNamePracice;

public class ThreadB extends Thread{

    @Override
    public void run() {
        System.out.println("TEST_C--> " + this.getName());
    }
}
