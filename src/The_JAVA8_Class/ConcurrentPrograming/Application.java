package The_JAVA8_Class.ConcurrentPrograming;
import javax.swing.text.TableView;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();

        Thread thread = new Thread(()->{
            //while (true){
                System.out.println("One Thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e){
                   // System.out.println("Exit!");
                    return;
                }
            //}
        });
        thread.start();
        System.out.println(Thread.currentThread().getName());
        myThread.join();
        System.out.println(myThread + "is Finished");
    }

    static class MyThread extends Thread{
        public void run(){
            try {
                sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Two Thread: " + Thread.currentThread().getName());
        }
    }
}
