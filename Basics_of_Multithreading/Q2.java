package Basics_of_Multithreading;
import java.util.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{
    private int id;
    public Processor(int id){
        this.id = id;
    }
    @Override
    public void run() {
        System.out.println("Starting" + id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed" + id);
    }
}
public class Q2 {
    public static void main(String[] args) {
        ExecutorService single = Executors.newSingleThreadExecutor();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ExecutorService cache = Executors.newCachedThreadPool();
        for (int i=0;i<5;i++){
            single.submit(new Processor(i));
            executor.submit(new Processor(i));
            cache.submit(new Processor(i));
        }
        single.shutdown();
        executor.shutdown();
        cache.shutdown();
        System.out.println("All the tasks submitted");
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All the tasks completed");
    }
}