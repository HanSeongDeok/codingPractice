package ThreadPractice;

import java.awt.*;

public class BeepTask implements Runnable{
    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for(int i=0; i<5; i++){
            System.out.println("for 문을 실행하는 스레드 이름: " + Thread.currentThread().getName());
            toolkit.beep(); // 비프음
            //sleep 을 사용하는 이유: main 스레드가 너무 빨리 실행되니까
            try {
                Thread.sleep(1000); //0.5초
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
