package Basics_of_Multithreading;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account{
    private int balance = 10000;
    public void deposit(int amount){
        balance += amount;
    }
    public void withdraw(int amount){
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
    public static void transfer(Account a1, Account a2, int amount){
        a1.withdraw(amount);
        a2.deposit(amount);
    }
}
class Run{
    private Account acc1 = new Account();
    private Account acc2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    //Method for solving Deadlock
    private void acquireLocks(Lock firstLock, Lock secondLock){
        while (true) {
            boolean gotFirstLock = false;
            boolean gotSecondLock = false;
            try {
                gotFirstLock = firstLock.tryLock();
                gotSecondLock = secondLock.tryLock();
            } finally {
                if(gotFirstLock && gotSecondLock){
                    return;
                }
                if(gotFirstLock){
                    firstLock.unlock();
                }
                if (gotSecondLock){
                    secondLock.unlock();
                }
            }
        }
    }
    public void firstThread() throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < 10000; i++){
            //lock1.lock();
            //lock2.lock();
            acquireLocks(lock1, lock2);
            try {
                Account.transfer(acc1, acc2, random.nextInt(100));
            }
            finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }
    public void secondThread() throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < 10000; i++){
            //lock2.lock();
            //lock1.lock();
            acquireLocks(lock1, lock2);
            try {
                Account.transfer(acc2, acc1, random.nextInt(100));
            }
            finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }
    public void finished(){
        System.out.println("Account 1 balance: " + acc1.getBalance());
        System.out.println("Account 2 balance: " + acc2.getBalance());
        System.out.println("Total balance: " + (acc2.getBalance() + acc1.getBalance()));
    }
}
public class Q5 {
    public static void main(String[] args) throws InterruptedException {
        Run run = new Run();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    run.firstThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    run.secondThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        run.finished();
    }
}