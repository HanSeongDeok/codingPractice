package ThreadPractice.CalThreadPractice;

public class PriorityExample {
    public static void main(String[] args) {
        for(int i=0; i<=10; i++){
            Thread thread = new CalThread("Thread : " + i);
            if(i!=10){
                thread.setPriority(Thread.MIN_PRIORITY);
            } else{
                thread.setPriority(Thread.MAX_PRIORITY);
            }
            System.out.println(thread.getName());
            thread.start();
        }
    }
}
