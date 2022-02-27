package Basics_of_Multithreading;

import java.util.Random;
import java.util.concurrent.*;

public class Q4 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> fu = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                int duration = random.nextInt(10000);
                System.out.println("Started");
                Thread.sleep(duration);
                System.out.println("Finished");
                return duration;
            }
        });
        try {
            System.out.println(fu.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hi everyone");
            }
        });
        executor.shutdown();
    }
}
