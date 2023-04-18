package The_JAVA8_Class.ConcurrentPrograming;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableAndFuture_Application {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> hello = ()-> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Callable<String> java = ()-> {
            Thread.sleep(3000L);
            return "Java";
        };

        Callable<String> thread = ()-> {
            Thread.sleep(1000L);
            return "Thread";
        };

         List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, thread));
         for(Future<String> f : futures){
             System.out.println(f.get());
         }

         String s = executorService.invokeAny(Arrays.asList(hello, java, thread));
         System.out.println(s);

        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone());
        System.out.println("Started!");

       // helloFuture.get(); //블록킹
        helloFuture.cancel(false);

        System.out.println(helloFuture.isDone());
        helloFuture.get(); //블록킹

        System.out.println("End!!");
        executorService.shutdown();

    }
}
