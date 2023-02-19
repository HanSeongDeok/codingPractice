package ThreadPractice.BeepPractice;

import java.awt.*;

public class BeepThread extends Thread{
    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for(int i=0; i<5; i++){
            System.out.println("비트음 "+(i+1) +"번째 출력");
            System.out.println();
            toolkit.beep();
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){}
        }

    }
}
