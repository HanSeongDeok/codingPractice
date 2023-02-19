package ThreadPractice.TimerThreadPractice;

public class TimerThreadPrintExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new TimerThread();
        thread.start();

       /* Thread thread2 = new Thread (()->{
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            for(int i=0; i< 3; i++){
                toolkit.beep();
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
            }
        });
        thread2.start();*/
        for (int i=0; i<10; i++){
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }
}
