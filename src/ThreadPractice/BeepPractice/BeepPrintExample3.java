package ThreadPractice.BeepPractice;

public class BeepPrintExample3 {
    public static void main(String[] args) {
        Thread thread = new BeepThread();
        thread.start();
        for(int i=0; i<5; i++){
            System.out.println("띵");
            System.out.println("-----------");
            System.out.println(Thread.currentThread().getName());
            System.out.println("-----------");
            try{
               Thread.sleep(1000);
            }catch (InterruptedException e){}
        }
    }
}
