package ThreadPractice.TimerThreadPractice;

import javax.swing.*;

public class DialogExample {
    public static void main(String[] args) {
        Thread t = new TimerThread();
        t.start();
       // System.out.println(Thread.currentThread().getName());
       // System.out.println(t.getName());

        String input = JOptionPane.showInputDialog("Any Key");
        System.out.println("입력 값은 " + input + "입니다.");
    }
}
