package ThreadPractice;

public class BeepPrintExample2 {
    public static void main(String[] args) {
        // 직접 생성하는 멀티스레드로 하는 3가지 방법
        // 1번
        Runnable beepTask = new BeepTask();
        Thread thread = new Thread(beepTask);
        thread.start();

        for (int i=0; i<5; i++){
            System.out.println("main() for 문을 실행하는 스레드 이름 : " + Thread.currentThread().getName());
            System.out.println("띵");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){}

        }
    }
}
