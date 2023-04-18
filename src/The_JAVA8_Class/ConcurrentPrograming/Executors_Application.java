package The_JAVA8_Class.ConcurrentPrograming;

import java.util.concurrent.*;

public class Executors_Application {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(getRunnable("Hello"));
        executorService.submit(getRunnable("GOOD"));
        executorService.submit(getRunnable("NICE"));
        executorService.submit(getRunnable("Java"));
        executorService.submit(getRunnable("Thread"));

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService scheduledExecutorService2 = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(getRunnable("*** Hello_Schedule *** "),1, TimeUnit.SECONDS);
        scheduledExecutorService2.scheduleAtFixedRate(getRunnable("*** Hello_Schedule Part2 ***"),2,3,TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();
        executorService.shutdown();
        scheduledExecutorService2.shutdown();
    }

    private static Runnable getRunnable(String mesaage) {
        return ()-> System.out.println(mesaage + Thread.currentThread().getName());
    }
}
