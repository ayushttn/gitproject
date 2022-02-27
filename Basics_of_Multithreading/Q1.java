package Basics_of_Multithreading;
class NewThread implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread executed");
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
public class Q1{
    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(()-> System.out.println("Running thread"));
        Runnable t2 = new NewThread();
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread of Runnable");
            }
        });
        t1.start();
        t3.start();
        t1.join();
        t3.join();
        t2.run();

    }
}
