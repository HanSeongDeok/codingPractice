package The_JAVA8_Class.ConcurrentPrograming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFuture_Practice2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(()-> {
            System.out.println("Hello" + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> hello2 = CompletableFuture.supplyAsync(()-> {
            System.out.println("Hello2" + Thread.currentThread().getName());
            return "Hello2";
        });

        /**
         * thenCompose 활용
         */
        hello.thenCompose(CompletableFuture_Practice2::getWorld).get();

        /**
         * Combine 활용
         */
        System.out.println(hello.thenCombine(hello2, (h, w) -> h + " " + w).get());

        /**
         * 모든 future 의 결과값을 Collection 으로 받고 싶을 때
         * But, 약간 좀 그럼..
         */
         List<CompletableFuture<String>> futures = Arrays.asList(hello, hello2);
         CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);

         CompletableFuture<List<String>> results = CompletableFuture.allOf(futuresArray)
                 .thenApply(v -> futures.stream()
                         .map(CompletableFuture::join)
                         .collect(Collectors.toList()));
        System.out.println(results.get());
        results.get().forEach(System.out::println);
    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(message +" World "+Thread.currentThread().getName());
            return message + "World";
        });
    }



}
