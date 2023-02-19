package ThreadPractice.CalThreadPractice;

public class CalThread extends Thread{
    long sum;
    public CalThread(String str){
       // this.setName("피숑 " + str);
        //this.setName(this.getName());
    }
    @Override
    public void run() {
        for(int i=0; i<20000000; i++){
            sum += i;
        }
        System.out.println("작업을 마친 스레드: " + Thread.currentThread().getName());
        System.out.println("합계 : " + this.sum);
    }
}
