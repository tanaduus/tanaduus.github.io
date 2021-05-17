package tanaduus.github.io.thread.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

public class Test {


    public Test() {
    }

    public static void main(String[] args) {

        anyOf();

//        allOf();

//        combine();
    }

    private static void anyOf() {
        CompletableFuture<String> a = CompletableFuture.supplyAsync(() -> {

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":a");
            return "a";
        });


        CompletableFuture<String> b = CompletableFuture.supplyAsync(() -> {

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":b");
            return "b";
        });

        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(a, b);
        anyOf.thenAcceptAsync(result -> System.out.println(Thread.currentThread().getName() + " anyOf:" + result));

        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void allOf() {
        CompletableFuture<String> a = CompletableFuture.supplyAsync(() -> {

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":a");
            return "a";
        });


        CompletableFuture<String> b = CompletableFuture.supplyAsync(() -> {

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":b");
            return "b";
        });

        CompletableFuture<Void> allOf = CompletableFuture.allOf(a, b);
        allOf.thenRunAsync(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + ":"+a.get() + b.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void combine() {
        CompletableFuture<String> a = CompletableFuture.supplyAsync(() -> {

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":a");
            return "a";
        });


        CompletableFuture<String> b = CompletableFuture.supplyAsync(() -> {

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":b");
            return "b";
        });


        a.thenCombine(b, (s1, s2) -> {
            System.out.println(Thread.currentThread().getName() + ":" + s1 + s2);
            return "c";
        });

        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
