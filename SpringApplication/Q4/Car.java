package com.Ayush.SpringAssignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {

    @Autowired
    private Honk honk;

    public Car(Honk honk) {
        this.honk = honk;
    }

    public Honk getHonk() {
        return honk;
    }

    public void H(){
        String s = honk.Honking();
        System.out.println(s);
        System.out.println(honk);
    }
}
