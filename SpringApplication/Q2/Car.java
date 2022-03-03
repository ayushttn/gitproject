package com.Ayush.SpringAssignment;

public class Car {
    private Honk honk;

    public Car(Honk honk) {
        this.honk = honk;
    }

    public void H(){
        String s = honk.Honking();
        System.out.println(s);
        System.out.println(honk);
    }
}
