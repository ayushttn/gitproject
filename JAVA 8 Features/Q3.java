package JAVA_8;
public class Q3 {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Thread is running");
        new Thread(runnable).start();
    }
}
