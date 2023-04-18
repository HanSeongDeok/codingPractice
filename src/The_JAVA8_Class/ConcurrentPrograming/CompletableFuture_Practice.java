package The_JAVA8_Class.ConcurrentPrograming;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFuture_Practice {
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
            System.out.println("Hello " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                return;
            }
        }, executorService).thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        }, executorService);
        
        future.get();
        executorService.shutdown();

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(()->{
            System.out.println("Hello2 " + Thread.currentThread().getName());
            return "TEST";
        }).thenApply(s -> {
            System.out.println(Thread.currentThread().getName());
            return s.toLowerCase();
        });

        System.out.println(future2.get());
    }
}
