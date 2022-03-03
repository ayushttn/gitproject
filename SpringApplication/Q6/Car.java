package com.Ayush.SpringAssignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

    private Honk honk;

    @Autowired
    public Car(Honk honk) {
        this.honk = honk;
    }

    public void H(){
        String s = honk.Honking();
        System.out.println(s);
        System.out.println(honk);
    }
}
